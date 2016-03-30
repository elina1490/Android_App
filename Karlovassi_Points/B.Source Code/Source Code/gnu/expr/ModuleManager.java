package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.mapping.WrappedException;
import gnu.text.Path;
import gnu.text.URLPath;
import java.io.File;
import java.net.URL;

public class ModuleManager
{
  public static final long LAST_MODIFIED_CACHE_TIME = 1000L;
  static ModuleManager instance = new ModuleManager();
  private String compilationDirectory = "";
  public long lastModifiedCacheTime = 1000L;
  ModuleInfo[] modules;
  int numModules;
  ModuleSet packageInfoChain;

  private void add(ModuleInfo paramModuleInfo)
  {
    try
    {
      if (this.modules == null)
        this.modules = new ModuleInfo[10];
      while (true)
      {
        ModuleInfo[] arrayOfModuleInfo2 = this.modules;
        int i = this.numModules;
        this.numModules = (i + 1);
        arrayOfModuleInfo2[i] = paramModuleInfo;
        return;
        if (this.numModules == this.modules.length)
        {
          ModuleInfo[] arrayOfModuleInfo1 = new ModuleInfo[2 * this.numModules];
          System.arraycopy(this.modules, 0, arrayOfModuleInfo1, 0, this.numModules);
          this.modules = arrayOfModuleInfo1;
        }
      }
    }
    finally
    {
    }
  }

  public static ModuleInfo findWithClass(Class paramClass)
  {
    try
    {
      ModuleInfo localModuleInfo = (ModuleInfo)ModuleInfo.mapClassToInfo.get(paramClass);
      if (localModuleInfo == null)
      {
        localModuleInfo = new ModuleInfo();
        localModuleInfo.setModuleClass(paramClass);
      }
      return localModuleInfo;
    }
    finally
    {
    }
  }

  public static ModuleManager getInstance()
  {
    return instance;
  }

  private ModuleInfo searchWithAbsSourcePath(String paramString)
  {
    try
    {
      int i = this.numModules;
      ModuleInfo localModuleInfo1;
      boolean bool;
      do
      {
        i--;
        if (i < 0)
          break;
        localModuleInfo1 = this.modules[i];
        bool = paramString.equals(localModuleInfo1.getSourceAbsPathname());
      }
      while (!bool);
      for (ModuleInfo localModuleInfo2 = localModuleInfo1; ; localModuleInfo2 = null)
        return localModuleInfo2;
    }
    finally
    {
    }
  }

  public void clear()
  {
    try
    {
      ModuleSet localModuleSet;
      for (Object localObject2 = this.packageInfoChain; localObject2 != null; localObject2 = localModuleSet)
      {
        localModuleSet = ((ModuleSet)localObject2).next;
        ((ModuleSet)localObject2).next = null;
      }
      this.packageInfoChain = null;
      this.modules = null;
      this.numModules = 0;
      return;
    }
    finally
    {
    }
  }

  public ModuleInfo find(Compilation paramCompilation)
  {
    try
    {
      ModuleExp localModuleExp = paramCompilation.getModule();
      ClassType localClassType = localModuleExp.classFor(paramCompilation);
      String str = localModuleExp.getFileName();
      ModuleInfo localModuleInfo = findWithSourcePath(ModuleInfo.absPath(str), str);
      localModuleInfo.setClassName(localClassType.getName());
      localModuleInfo.exp = localModuleExp;
      paramCompilation.minfo = localModuleInfo;
      localModuleInfo.comp = paramCompilation;
      return localModuleInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public ModuleInfo findWithClassName(String paramString)
  {
    ModuleInfo localModuleInfo1 = searchWithClassName(paramString);
    if (localModuleInfo1 != null)
      return localModuleInfo1;
    try
    {
      ModuleInfo localModuleInfo2 = findWithClass(ClassType.getContextClass(paramString));
      return localModuleInfo2;
    }
    catch (Throwable localThrowable)
    {
      throw WrappedException.wrapIfNeeded(localThrowable);
    }
  }

  public ModuleInfo findWithSourcePath(Path paramPath, String paramString)
  {
    try
    {
      String str = paramPath.toString();
      ModuleInfo localModuleInfo = searchWithAbsSourcePath(str);
      if (localModuleInfo == null)
      {
        localModuleInfo = new ModuleInfo();
        localModuleInfo.sourcePath = paramString;
        localModuleInfo.sourceAbsPath = paramPath;
        localModuleInfo.sourceAbsPathname = str;
        add(localModuleInfo);
      }
      return localModuleInfo;
    }
    finally
    {
    }
  }

  public ModuleInfo findWithSourcePath(String paramString)
  {
    try
    {
      ModuleInfo localModuleInfo = findWithSourcePath(ModuleInfo.absPath(paramString), paramString);
      return localModuleInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public ModuleInfo findWithURL(URL paramURL)
  {
    try
    {
      ModuleInfo localModuleInfo = findWithSourcePath(URLPath.valueOf(paramURL), paramURL.toExternalForm());
      return localModuleInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getCompilationDirectory()
  {
    return this.compilationDirectory;
  }

  public ModuleInfo getModule(int paramInt)
  {
    try
    {
      int i = this.numModules;
      if (paramInt >= i);
      for (ModuleInfo localModuleInfo = null; ; localModuleInfo = this.modules[paramInt])
        return localModuleInfo;
    }
    finally
    {
    }
  }

  public void loadPackageInfo(String paramString)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException
  {
    try
    {
      String str = paramString + "." + "$ModulesMap$";
      for (ModuleSet localModuleSet1 = this.packageInfoChain; localModuleSet1 != null; localModuleSet1 = localModuleSet1.next)
        if (!localModuleSet1.getClass().getName().equals(str));
      ModuleSet localModuleSet2 = (ModuleSet)Class.forName(str).newInstance();
      localModuleSet2.next = this.packageInfoChain;
      this.packageInfoChain = localModuleSet2;
      localModuleSet2.register(this);
      return;
    }
    finally
    {
    }
  }

  public void register(String paramString1, String paramString2, String paramString3)
  {
    while (true)
    {
      ModuleInfo localModuleInfo2;
      try
      {
        ModuleInfo localModuleInfo1 = searchWithClassName(paramString1);
        if (localModuleInfo1 != null)
          return;
        Path localPath1 = Path.valueOf(paramString2);
        String str1 = localPath1.getCanonical().toString();
        if (searchWithAbsSourcePath(str1) != null)
          continue;
        localModuleInfo2 = new ModuleInfo();
        if (localPath1.isAbsolute())
        {
          localModuleInfo2.sourceAbsPath = localPath1;
          localModuleInfo2.sourceAbsPathname = str1;
          localModuleInfo2.setClassName(paramString1);
          localModuleInfo2.sourcePath = paramString2;
          localModuleInfo2.uri = paramString3;
          add(localModuleInfo2);
          continue;
        }
      }
      finally
      {
      }
      try
      {
        Class localClass = this.packageInfoChain.getClass();
        String str2 = localClass.getName().replace('.', '/') + ".class";
        Path localPath2 = URLPath.valueOf(localClass.getClassLoader().getResource(str2)).resolve(paramString2);
        localModuleInfo2.sourceAbsPath = localPath2;
        localModuleInfo2.sourceAbsPathname = localPath2.toString();
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }

  public ModuleInfo searchWithClassName(String paramString)
  {
    try
    {
      int i = this.numModules;
      ModuleInfo localModuleInfo1;
      boolean bool;
      do
      {
        i--;
        if (i < 0)
          break;
        localModuleInfo1 = this.modules[i];
        bool = paramString.equals(localModuleInfo1.getClassName());
      }
      while (!bool);
      for (ModuleInfo localModuleInfo2 = localModuleInfo1; ; localModuleInfo2 = null)
        return localModuleInfo2;
    }
    finally
    {
    }
  }

  public void setCompilationDirectory(String paramString)
  {
    if (paramString == null)
      paramString = "";
    int i = paramString.length();
    if (i > 0)
    {
      char c = File.separatorChar;
      if (paramString.charAt(i - 1) != c)
        paramString = paramString + c;
    }
    this.compilationDirectory = paramString;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ModuleManager
 * JD-Core Version:    0.6.2
 */