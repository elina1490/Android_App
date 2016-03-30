package gnu.kawa.servlet;

import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleContext;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.text.Path;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Hashtable;

public class KawaAutoHandler
{
  static final String MODULE_MAP_ATTRIBUTE = "gnu.kawa.module-map";

  public static Object getModule(HttpRequestContext paramHttpRequestContext, CallContext paramCallContext, boolean paramBoolean)
    throws Exception
  {
    String str1 = paramHttpRequestContext.getRequestPath().substring(paramHttpRequestContext.getContextPath().length() - 1);
    Hashtable localHashtable1 = (Hashtable)paramHttpRequestContext.getAttribute("gnu.kawa.module-map");
    if (localHashtable1 == null)
    {
      localHashtable1 = new Hashtable();
      paramHttpRequestContext.setAttribute("gnu.kawa.module-map", localHashtable1);
    }
    Hashtable localHashtable2 = localHashtable1;
    ModuleContext localModuleContext1 = (ModuleContext)paramHttpRequestContext.getAttribute("gnu.kawa.module-context");
    if (localModuleContext1 == null);
    for (ModuleContext localModuleContext2 = ModuleContext.getContext(); ; localModuleContext2 = localModuleContext1)
    {
      localModuleContext2.addFlags(ModuleContext.IN_HTTP_SERVER);
      if (paramHttpRequestContext.getClass().getName().endsWith("KawaServlet$Context"))
        localModuleContext2.addFlags(ModuleContext.IN_SERVLET);
      ModuleInfo localModuleInfo1 = (ModuleInfo)localHashtable2.get(str1);
      long l = System.currentTimeMillis();
      ModuleManager localModuleManager = localModuleContext2.getManager();
      if ((localModuleInfo1 != null) && (l - localModuleInfo1.lastCheckedTime < localModuleManager.lastModifiedCacheTime))
        return localModuleContext2.findInstance(localModuleInfo1);
      int i = str1.length();
      URL localURL1;
      if ((i == 0) || (str1.charAt(i - 1) == '/'))
        localURL1 = null;
      label201: label226: URL localURL2;
      String str2;
      while (true)
      {
        String str5;
        URL localURL3;
        String str6;
        int k;
        String str7;
        URL localURL4;
        byte[] arrayOfByte3;
        OutputStream localOutputStream3;
        if (localURL1 == null)
        {
          str5 = str1;
          localURL3 = localURL1;
          str6 = str1;
          k = str5.lastIndexOf('/');
          if (k < 0)
          {
            str7 = str6;
            localURL4 = localURL3;
            localURL2 = localURL4;
            str2 = str7;
            if (localURL2 != null)
              break;
            arrayOfByte3 = ("The requested URL " + str1 + " was not found on this server." + " res/:" + paramHttpRequestContext.getResourceURL("/") + "\r\n").getBytes();
            paramHttpRequestContext.sendResponseHeaders(404, null, arrayOfByte3.length);
            localOutputStream3 = paramHttpRequestContext.getResponseStream();
          }
        }
        try
        {
          localOutputStream3.write(arrayOfByte3);
          return null;
          localURL1 = paramHttpRequestContext.getResourceURL(str1);
          continue;
          str5 = str5.substring(0, k);
          str6 = str5 + "/+default+";
          localURL3 = paramHttpRequestContext.getResourceURL(str6);
          if (localURL3 == null)
            break label201;
          paramHttpRequestContext.setScriptAndLocalPath(str1.substring(1, k + 1), str1.substring(k + 1));
          str7 = str6;
          localURL4 = localURL3;
          break label226;
          paramHttpRequestContext.setScriptAndLocalPath(str1, "");
          localURL2 = localURL1;
          str2 = str1;
        }
        catch (IOException localIOException2)
        {
          throw new RuntimeException(localIOException2);
        }
      }
      String str3 = localURL2.toExternalForm();
      if ((localModuleInfo1 == null) || (!str3.equals(localModuleInfo1.getSourceAbsPathname())));
      for (ModuleInfo localModuleInfo2 = localModuleManager.findWithURL(localURL2); ; localModuleInfo2 = localModuleInfo1)
      {
        if (localModuleInfo2.checkCurrent(localModuleManager, l))
        {
          Object localObject3 = localModuleContext2.findInstance(localModuleInfo2);
          return localObject3;
        }
        localHashtable2.put(str1, localModuleInfo2);
        Path localPath = localModuleInfo2.getSourceAbsPath();
        InputStream localInputStream = localPath.openInputStream();
        if (!(localInputStream instanceof BufferedInputStream));
        for (Object localObject1 = new BufferedInputStream(localInputStream); ; localObject1 = localInputStream)
        {
          Language localLanguage = Language.getInstanceFromFilenameExtension(str1);
          if (localLanguage != null)
            paramHttpRequestContext.log("Compile " + str1 + " - a " + localLanguage.getName() + " source file (based on extension)");
          while (true)
          {
            InPort localInPort = new InPort((InputStream)localObject1, localPath);
            Language.setCurrentLanguage(localLanguage);
            SourceMessages localSourceMessages = new SourceMessages();
            try
            {
              Compilation localCompilation2 = localLanguage.parse(localInPort, localSourceMessages, 9, localModuleInfo2);
              localCompilation1 = localCompilation2;
              boolean bool = localSourceMessages.seenErrors();
              localClass = null;
              if (!bool)
              {
                localCompilation1.getModule();
                localClass = (Class)ModuleExp.evalModule1(Environment.getCurrent(), localCompilation1, localURL2, null);
              }
              if (localSourceMessages.seenErrors())
              {
                String str4 = "script syntax error:\n" + localSourceMessages.toString(20);
                ((ServletPrinter)paramCallContext.consumer).addHeader("Content-type", "text/plain");
                paramHttpRequestContext.sendResponseHeaders(500, "Syntax errors", -1L);
                paramCallContext.consumer.write(str4);
                localModuleInfo2.cleanupAfterCompilation();
                return null;
                localLanguage = Language.detect((InputStream)localObject1);
                if (localLanguage != null)
                {
                  paramHttpRequestContext.log("Compile " + str1 + " - a " + localLanguage.getName() + " source file (detected from content)");
                  continue;
                }
                if (str1 != str2)
                {
                  byte[] arrayOfByte2 = ("The requested URL " + str1 + " was not found on this server." + " upath=" + str2 + ".\r\n").getBytes();
                  paramHttpRequestContext.sendResponseHeaders(404, null, arrayOfByte2.length);
                  OutputStream localOutputStream2 = paramHttpRequestContext.getResponseStream();
                  try
                  {
                    localOutputStream2.write(arrayOfByte2);
                    return null;
                  }
                  catch (IOException localIOException1)
                  {
                    throw new RuntimeException(localIOException1);
                  }
                }
                paramHttpRequestContext.sendResponseHeaders(200, null, localPath.getContentLength());
                OutputStream localOutputStream1 = paramHttpRequestContext.getResponseStream();
                byte[] arrayOfByte1 = new byte[4096];
                while (true)
                {
                  int j = ((InputStream)localObject1).read(arrayOfByte1);
                  if (j < 0)
                  {
                    ((InputStream)localObject1).close();
                    localOutputStream1.close();
                    return null;
                  }
                  localOutputStream1.write(arrayOfByte1, 0, j);
                }
              }
            }
            catch (SyntaxException localSyntaxException)
            {
              Class localClass;
              while (true)
              {
                if (localSyntaxException.getMessages() != localSourceMessages)
                  throw localSyntaxException;
                Compilation localCompilation1 = null;
              }
              localModuleInfo2.setModuleClass(localClass);
              Object localObject2 = localModuleContext2.findInstance(localModuleInfo2);
              return localObject2;
            }
          }
        }
      }
    }
  }

  public static void run(HttpRequestContext paramHttpRequestContext, CallContext paramCallContext)
    throws Throwable
  {
    if (paramHttpRequestContext.getRequestParameter("qexo-save-class") != null);
    for (boolean bool = true; ; bool = false)
    {
      Object localObject = getModule(paramHttpRequestContext, paramCallContext, bool);
      if ((localObject instanceof ModuleBody))
        ((ModuleBody)localObject).run(paramCallContext);
      return;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.servlet.KawaAutoHandler
 * JD-Core Version:    0.6.2
 */