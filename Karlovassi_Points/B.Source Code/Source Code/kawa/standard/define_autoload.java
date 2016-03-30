package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.kawa.lispexpr.LispReader;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.mapping.InPort;
import gnu.mapping.Symbol;
import gnu.text.SyntaxException;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import kawa.lang.AutoloadProcedure;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class define_autoload extends Syntax
{
  public static final define_autoload define_autoload = new define_autoload("define-autoload", false);
  public static final define_autoload define_autoloads_from_file = new define_autoload("define-autoloads-from-file", true);
  boolean fromFile;

  public define_autoload(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.fromFile = paramBoolean;
  }

  public static void findAutoloadComments(LispReader paramLispReader, String paramString, ScopeExp paramScopeExp, Translator paramTranslator)
    throws IOException, SyntaxException
  {
    int i = ";;;###autoload".length();
    int j = 1;
    int k;
    while (true)
    {
      k = paramLispReader.peek();
      if (k < 0)
        return;
      if ((k == 10) || (k == 13))
      {
        paramLispReader.read();
        j = 1;
      }
      else
      {
        if ((j != 0) && (k == 59))
        {
          int m = 0;
          label68: Pair localPair;
          Object localObject2;
          String str1;
          label123: String str2;
          if (m == i)
          {
            if (m <= 0)
              break label363;
            Object localObject1 = paramLispReader.readObject();
            if ((localObject1 instanceof Pair))
            {
              localPair = (Pair)localObject1;
              localObject2 = localPair.getCar();
              if (!(localObject2 instanceof String))
                break label298;
              str1 = localObject2.toString();
              if (str1 != "defun")
                break label325;
              str2 = ((Pair)localPair.getCdr()).getCar().toString();
            }
          }
          for (AutoloadProcedure localAutoloadProcedure = new AutoloadProcedure(str2, paramString, paramTranslator.getLanguage()); ; localAutoloadProcedure = null)
          {
            if (localAutoloadProcedure != null)
            {
              Declaration localDeclaration = paramScopeExp.getDefine(str2, 'w', paramTranslator);
              QuoteExp localQuoteExp = new QuoteExp(localAutoloadProcedure);
              localDeclaration.setFlag(16384L);
              localDeclaration.noteValue(localQuoteExp);
              localDeclaration.setProcedureDecl(true);
              localDeclaration.setType(Compilation.typeProcedure);
            }
            j = 0;
            break;
            k = paramLispReader.read();
            if (k < 0)
              return;
            if ((k == 10) || (k == 13))
            {
              j = 1;
              break;
            }
            if (m < 0)
              break label68;
            int n = m + 1;
            if (k == ";;;###autoload".charAt(m))
            {
              m = n;
              break label68;
            }
            m = -1;
            break label68;
            label298: if ((localObject2 instanceof Symbol))
            {
              str1 = ((Symbol)localObject2).getName();
              break label123;
            }
            str1 = null;
            break label123;
            label325: paramTranslator.error('w', "unsupported ;;;###autoload followed by: " + localPair.getCar());
            str2 = null;
          }
        }
        label363: paramLispReader.skip();
        if ((k != 35) || (paramLispReader.peek() != 124))
          break;
        paramLispReader.skip();
        paramLispReader.readNestedComment('#', '|');
        j = 0;
      }
    }
    if (Character.isWhitespace((char)k));
    while (paramLispReader.readObject(k) != Sequence.eofValue)
    {
      j = 0;
      break;
    }
  }

  public static boolean process(Object paramObject1, Object paramObject2, Vector paramVector, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    if ((paramObject1 instanceof Pair))
    {
      Pair localPair = (Pair)paramObject1;
      return (process(localPair.getCar(), paramObject2, paramVector, paramScopeExp, paramTranslator)) && (process(localPair.getCdr(), paramObject2, paramVector, paramScopeExp, paramTranslator));
    }
    if (paramObject1 == LList.Empty)
      return true;
    if (((paramObject1 instanceof String)) || ((paramObject1 instanceof Symbol)))
    {
      String str1 = paramObject1.toString();
      Declaration localDeclaration = paramScopeExp.getDefine(str1, 'w', paramTranslator);
      if ((paramObject2 instanceof String))
      {
        String str2 = (String)paramObject2;
        int i = str2.length();
        if ((i > 2) && (str2.charAt(0) == '<') && (str2.charAt(i - 1) == '>'))
          paramObject2 = str2.substring(1, i - 1);
      }
      QuoteExp localQuoteExp = new QuoteExp(new AutoloadProcedure(str1, paramObject2.toString(), paramTranslator.getLanguage()));
      localDeclaration.setFlag(16384L);
      localDeclaration.noteValue(localQuoteExp);
      return true;
    }
    return false;
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    return null;
  }

  public boolean scanFile(String paramString, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    if (paramString.endsWith(".el"));
    File localFile = new File(paramString);
    if (!localFile.isAbsolute())
    {
      String str6 = new File(paramTranslator.getFileName()).getParent();
      localFile = new File(str6, paramString);
    }
    String str1 = localFile.getPath();
    int i = str1.lastIndexOf('.');
    Language localLanguage;
    String str5;
    if (i >= 0)
    {
      String str2 = str1.substring(i);
      localLanguage = Language.getInstance(str2);
      if (localLanguage == null)
      {
        paramTranslator.syntaxError("unknown extension for " + str1);
        return true;
      }
      String str3 = paramTranslator.classPrefix;
      int j = str2.length();
      for (String str4 = paramString.substring(0, paramString.length() - j); str4.startsWith("../"); str4 = str4.substring(3))
      {
        int k = str3.length() - 2;
        int m = str3.lastIndexOf('.', k);
        if (m < 0)
        {
          paramTranslator.syntaxError("cannot use relative filename \"" + paramString + "\" with simple prefix \"" + str3 + "\"");
          return false;
        }
        int n = m + 1;
        str3 = str3.substring(0, n);
      }
      str5 = (str3 + str4).replace('/', '.');
    }
    try
    {
      findAutoloadComments((LispReader)localLanguage.getLexer(InPort.openFile(str1), paramTranslator.getMessages()), str5, paramScopeExp, paramTranslator);
      return true;
    }
    catch (Exception localException)
    {
      paramTranslator.syntaxError("error reading " + str1 + ": " + localException);
    }
    return true;
  }

  public boolean scanForDefinitions(Pair paramPair, Vector paramVector, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    if (!(paramPair.getCdr() instanceof Pair))
      return super.scanForDefinitions(paramPair, paramVector, paramScopeExp, paramTranslator);
    Pair localPair = (Pair)paramPair.getCdr();
    if (this.fromFile)
      while (true)
      {
        if (!(localPair.getCar() instanceof CharSequence));
        Object localObject2;
        do
        {
          paramTranslator.syntaxError("invalid syntax for define-autoloads-from-file");
          return false;
          if (!scanFile(localPair.getCar().toString(), paramScopeExp, paramTranslator))
            return false;
          localObject2 = localPair.getCdr();
          if (localObject2 == LList.Empty)
            return true;
        }
        while (!(localObject2 instanceof Pair));
        localPair = (Pair)localPair.getCdr();
      }
    Object localObject1 = localPair.getCar();
    if ((localPair.getCdr() instanceof Pair))
      return process(localObject1, ((Pair)localPair.getCdr()).getCar(), paramVector, paramScopeExp, paramTranslator);
    paramTranslator.syntaxError("invalid syntax for define-autoload");
    return false;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.define_autoload
 * JD-Core Version:    0.6.2
 */