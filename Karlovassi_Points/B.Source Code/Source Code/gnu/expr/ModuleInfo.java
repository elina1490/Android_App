package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.reflect.FieldLocation;
import gnu.kawa.util.AbstractWeakHashTable;
import gnu.mapping.Location;
import gnu.mapping.WrappedException;
import gnu.text.Path;

public class ModuleInfo
{
  static ClassToInfoMap mapClassToInfo = new ClassToInfoMap();
  private String className;
  Compilation comp;
  ModuleInfo[] dependencies;
  ModuleExp exp;
  public long lastCheckedTime;
  public long lastModifiedTime;
  Class moduleClass;
  int numDependencies;
  Path sourceAbsPath;
  String sourceAbsPathname;
  public String sourcePath;
  String uri;

  public static Path absPath(String paramString)
  {
    return Path.valueOf(paramString).getCanonical();
  }

  public static ModuleInfo find(ClassType paramClassType)
  {
    if (paramClassType.isExisting())
      try
      {
        ModuleInfo localModuleInfo = ModuleManager.findWithClass(paramClassType.getReflectClass());
        return localModuleInfo;
      }
      catch (Exception localException)
      {
      }
    return ModuleManager.getInstance().findWithClassName(paramClassType.getName());
  }

  public static ModuleInfo findFromInstance(Object paramObject)
  {
    return ModuleContext.getContext().findFromInstance(paramObject);
  }

  static void makeDeclInModule2(ModuleExp paramModuleExp, Declaration paramDeclaration)
  {
    Object localObject = paramDeclaration.getConstantValue();
    ReferenceExp localReferenceExp;
    String str;
    if ((localObject instanceof FieldLocation))
    {
      FieldLocation localFieldLocation = (FieldLocation)localObject;
      Declaration localDeclaration1 = localFieldLocation.getDeclaration();
      localReferenceExp = new ReferenceExp(localDeclaration1);
      paramDeclaration.setAlias(true);
      localReferenceExp.setDontDereference(true);
      paramDeclaration.setValue(localReferenceExp);
      if (localDeclaration1.isProcedureDecl())
        paramDeclaration.setProcedureDecl(true);
      if (localDeclaration1.getFlag(32768L))
        paramDeclaration.setSyntax();
      if (!paramDeclaration.getFlag(2048L))
        str = localFieldLocation.getDeclaringClass().getName();
    }
    for (Declaration localDeclaration2 = paramModuleExp.firstDecl(); ; localDeclaration2 = localDeclaration2.nextDecl())
      if (localDeclaration2 != null)
      {
        if ((str.equals(localDeclaration2.getType().getName())) && (localDeclaration2.getFlag(1073741824L)))
          localReferenceExp.setContextDecl(localDeclaration2);
      }
      else
        return;
  }

  public static void register(Object paramObject)
  {
    ModuleContext.getContext().setInstance(paramObject);
  }

  public void addDependency(ModuleInfo paramModuleInfo)
  {
    try
    {
      if (this.dependencies == null)
        this.dependencies = new ModuleInfo[8];
      while (true)
      {
        ModuleInfo[] arrayOfModuleInfo2 = this.dependencies;
        int i = this.numDependencies;
        this.numDependencies = (i + 1);
        arrayOfModuleInfo2[i] = paramModuleInfo;
        return;
        if (this.numDependencies == this.dependencies.length)
        {
          ModuleInfo[] arrayOfModuleInfo1 = new ModuleInfo[2 * this.numDependencies];
          System.arraycopy(this.dependencies, 0, arrayOfModuleInfo1, 0, this.numDependencies);
          this.dependencies = arrayOfModuleInfo1;
        }
      }
    }
    finally
    {
    }
  }

  // ERROR //
  public boolean checkCurrent(ModuleManager paramModuleManager, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 192	gnu/expr/ModuleInfo:sourceAbsPath	Lgnu/text/Path;
    //   4: ifnonnull +5 -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 194	gnu/expr/ModuleInfo:lastCheckedTime	J
    //   13: aload_1
    //   14: getfield 197	gnu/expr/ModuleManager:lastModifiedCacheTime	J
    //   17: ladd
    //   18: lload_2
    //   19: lcmp
    //   20: iflt +14 -> 34
    //   23: aload_0
    //   24: getfield 199	gnu/expr/ModuleInfo:moduleClass	Ljava/lang/Class;
    //   27: ifnull +5 -> 32
    //   30: iconst_1
    //   31: ireturn
    //   32: iconst_0
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 192	gnu/expr/ModuleInfo:sourceAbsPath	Lgnu/text/Path;
    //   38: invokevirtual 203	gnu/text/Path:getLastModified	()J
    //   41: lstore 4
    //   43: aload_0
    //   44: getfield 205	gnu/expr/ModuleInfo:lastModifiedTime	J
    //   47: lstore 6
    //   49: aload_0
    //   50: lload 4
    //   52: putfield 205	gnu/expr/ModuleInfo:lastModifiedTime	J
    //   55: aload_0
    //   56: lload_2
    //   57: putfield 194	gnu/expr/ModuleInfo:lastCheckedTime	J
    //   60: aload_0
    //   61: getfield 207	gnu/expr/ModuleInfo:className	Ljava/lang/String;
    //   64: ifnonnull +5 -> 69
    //   67: iconst_0
    //   68: ireturn
    //   69: aload_0
    //   70: getfield 199	gnu/expr/ModuleInfo:moduleClass	Ljava/lang/Class;
    //   73: ifnonnull +14 -> 87
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 207	gnu/expr/ModuleInfo:className	Ljava/lang/String;
    //   81: invokestatic 211	gnu/bytecode/ClassType:getContextClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   84: putfield 199	gnu/expr/ModuleInfo:moduleClass	Ljava/lang/Class;
    //   87: lload 6
    //   89: lconst_0
    //   90: lcmp
    //   91: ifne +112 -> 203
    //   94: aload_0
    //   95: getfield 199	gnu/expr/ModuleInfo:moduleClass	Ljava/lang/Class;
    //   98: ifnull +105 -> 203
    //   101: aload_0
    //   102: getfield 207	gnu/expr/ModuleInfo:className	Ljava/lang/String;
    //   105: astore 10
    //   107: aload 10
    //   109: bipush 46
    //   111: invokevirtual 215	java/lang/String:lastIndexOf	(I)I
    //   114: istore 11
    //   116: iload 11
    //   118: iflt +14 -> 132
    //   121: aload 10
    //   123: iload 11
    //   125: iconst_1
    //   126: iadd
    //   127: invokevirtual 219	java/lang/String:substring	(I)Ljava/lang/String;
    //   130: astore 10
    //   132: new 221	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   139: aload 10
    //   141: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 228
    //   146: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: astore 12
    //   154: aload_0
    //   155: getfield 199	gnu/expr/ModuleInfo:moduleClass	Ljava/lang/Class;
    //   158: aload 12
    //   160: invokevirtual 237	java/lang/Class:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   163: astore 13
    //   165: aload 13
    //   167: ifnull +17 -> 184
    //   170: aload 13
    //   172: invokevirtual 243	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   175: invokevirtual 246	java/net/URLConnection:getLastModified	()J
    //   178: lstore 15
    //   180: lload 15
    //   182: lstore 6
    //   184: aload 13
    //   186: ifnonnull +17 -> 203
    //   189: iconst_1
    //   190: ireturn
    //   191: astore 17
    //   193: iconst_0
    //   194: ireturn
    //   195: astore 14
    //   197: aconst_null
    //   198: astore 13
    //   200: goto -16 -> 184
    //   203: lload 4
    //   205: lload 6
    //   207: lcmp
    //   208: ifle +10 -> 218
    //   211: aload_0
    //   212: aconst_null
    //   213: putfield 199	gnu/expr/ModuleInfo:moduleClass	Ljava/lang/Class;
    //   216: iconst_0
    //   217: ireturn
    //   218: aload_0
    //   219: getfield 178	gnu/expr/ModuleInfo:numDependencies	I
    //   222: istore 8
    //   224: iinc 8 255
    //   227: iload 8
    //   229: iflt +37 -> 266
    //   232: aload_0
    //   233: getfield 176	gnu/expr/ModuleInfo:dependencies	[Lgnu/expr/ModuleInfo;
    //   236: iload 8
    //   238: aaload
    //   239: astore 9
    //   241: aload 9
    //   243: getfield 248	gnu/expr/ModuleInfo:comp	Lgnu/expr/Compilation;
    //   246: ifnonnull -22 -> 224
    //   249: aload 9
    //   251: aload_1
    //   252: lload_2
    //   253: invokevirtual 250	gnu/expr/ModuleInfo:checkCurrent	(Lgnu/expr/ModuleManager;J)Z
    //   256: ifne -32 -> 224
    //   259: aload_0
    //   260: aconst_null
    //   261: putfield 199	gnu/expr/ModuleInfo:moduleClass	Ljava/lang/Class;
    //   264: iconst_0
    //   265: ireturn
    //   266: iconst_1
    //   267: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   76	87	191	java/lang/ClassNotFoundException
    //   170	180	195	java/io/IOException
  }

  public void cleanupAfterCompilation()
  {
    if (this.comp != null)
      this.comp.cleanupAfterCompilation();
  }

  public void clearClass()
  {
    this.moduleClass = null;
    this.numDependencies = 0;
    this.dependencies = null;
  }

  public String getClassName()
  {
    try
    {
      if (this.className == null)
        if (this.moduleClass == null)
          break label36;
      for (this.className = this.moduleClass.getName(); ; this.className = this.comp.mainClass.getName())
        label36: 
        do
        {
          String str = this.className;
          return str;
        }
        while ((this.comp == null) || (this.comp.mainClass == null));
    }
    finally
    {
    }
  }

  public ClassType getClassType()
  {
    try
    {
      Object localObject2;
      if (this.moduleClass != null)
        localObject2 = (ClassType)Type.make(this.moduleClass);
      while (true)
      {
        return localObject2;
        if ((this.comp != null) && (this.comp.mainClass != null))
        {
          localObject2 = this.comp.mainClass;
        }
        else
        {
          ClassType localClassType = ClassType.make(this.className);
          localObject2 = localClassType;
        }
      }
    }
    finally
    {
    }
  }

  public Compilation getCompilation()
  {
    return this.comp;
  }

  public Object getInstance()
  {
    return ModuleContext.getContext().findInstance(this);
  }

  public Class getModuleClass()
    throws ClassNotFoundException
  {
    try
    {
      Class localClass1 = this.moduleClass;
      if (localClass1 != null);
      Class localClass2;
      for (Object localObject2 = localClass1; ; localObject2 = localClass2)
      {
        return localObject2;
        localClass2 = ClassType.getContextClass(this.className);
        this.moduleClass = localClass2;
      }
    }
    finally
    {
    }
  }

  public Class getModuleClassRaw()
  {
    return this.moduleClass;
  }

  public ModuleExp getModuleExp()
  {
    try
    {
      ModuleExp localModuleExp1 = this.exp;
      if (localModuleExp1 == null)
        if (this.comp == null);
      for (ModuleExp localModuleExp2 = this.comp.mainLambda; ; localModuleExp2 = localModuleExp1)
      {
        return localModuleExp2;
        ClassType localClassType = ClassType.make(this.className);
        localModuleExp1 = new ModuleExp();
        localModuleExp1.type = localClassType;
        localModuleExp1.setName(localClassType.getName());
        localModuleExp1.flags = (0x80000 | localModuleExp1.flags);
        localModuleExp1.info = this;
        this.exp = localModuleExp1;
      }
    }
    finally
    {
    }
  }

  public String getNamespaceUri()
  {
    return this.uri;
  }

  public Object getRunInstance()
  {
    Object localObject = getInstance();
    if ((localObject instanceof Runnable))
      ((Runnable)localObject).run();
    return localObject;
  }

  public Path getSourceAbsPath()
  {
    return this.sourceAbsPath;
  }

  public String getSourceAbsPathname()
  {
    String str = this.sourceAbsPathname;
    if ((str == null) && (this.sourceAbsPath != null))
    {
      str = this.sourceAbsPath.toString();
      this.sourceAbsPathname = str;
    }
    return str;
  }

  public int getState()
  {
    if (this.comp == null)
      return 14;
    return this.comp.getState();
  }

  public void loadByStages(int paramInt)
  {
    if (1 + getState() >= paramInt);
    int m;
    do
    {
      int i;
      do
      {
        return;
        loadByStages(paramInt - 2);
        i = getState();
      }
      while (i >= paramInt);
      this.comp.setState(i + 1);
      int j = this.numDependencies;
      for (int k = 0; k < j; k++)
        this.dependencies[k].loadByStages(paramInt);
      m = getState();
    }
    while (m >= paramInt);
    this.comp.setState(m & 0xFFFFFFFE);
    this.comp.process(paramInt);
  }

  public boolean loadEager(int paramInt)
  {
    if ((this.comp == null) && (this.className != null))
      return false;
    int i = getState();
    if (i >= paramInt)
      return true;
    if ((i & 0x1) != 0)
      return false;
    this.comp.setState(i + 1);
    int j = this.numDependencies;
    for (int k = 0; k < j; k++)
      if (!this.dependencies[k].loadEager(paramInt))
      {
        if (getState() == i + 1)
          this.comp.setState(i);
        return false;
      }
    if (getState() == i + 1)
      this.comp.setState(i);
    this.comp.process(paramInt);
    return getState() == paramInt;
  }

  public void setClassName(String paramString)
  {
    this.className = paramString;
  }

  public void setCompilation(Compilation paramCompilation)
  {
    paramCompilation.minfo = this;
    this.comp = paramCompilation;
    ModuleExp localModuleExp = paramCompilation.mainLambda;
    this.exp = localModuleExp;
    if (localModuleExp != null)
    {
      String str = localModuleExp.getFileName();
      this.sourcePath = str;
      this.sourceAbsPath = absPath(str);
    }
  }

  public void setModuleClass(Class paramClass)
  {
    this.moduleClass = paramClass;
    this.className = paramClass.getName();
    mapClassToInfo.put(paramClass, this);
  }

  public void setNamespaceUri(String paramString)
  {
    this.uri = paramString;
  }

  public void setSourceAbsPath(Path paramPath)
  {
    this.sourceAbsPath = paramPath;
    this.sourceAbsPathname = null;
  }

  public ModuleExp setupModuleExp()
  {
    while (true)
    {
      ModuleExp localModuleExp;
      Declaration localDeclaration1;
      try
      {
        localModuleExp = getModuleExp();
        int i = localModuleExp.flags;
        if ((i & 0x80000) == 0)
          return localModuleExp;
        localModuleExp.setFlag(false, 524288);
        Object localObject2;
        ClassType localClassType;
        Language localLanguage;
        gnu.bytecode.Field localField;
        Object localObject3;
        int j;
        Class localClass;
        if (this.moduleClass != null)
        {
          localObject2 = this.moduleClass;
          localClassType = (ClassType)Type.make((Class)localObject2);
          localLanguage = Language.getDefaultLanguage();
          localField = localClassType.getFields();
          localObject3 = null;
          if (localField == null)
            break label237;
          j = localField.getFlags();
          if ((j & 0x1) == 0)
          {
            localField = localField.getNext();
            continue;
          }
        }
        else
        {
          localClassType = ClassType.make(this.className);
          localClass = localClassType.getReflectClass();
          localObject2 = localClass;
          continue;
        }
        if (((j & 0x8) == 0) && (localObject3 == null));
        try
        {
          localObject3 = getInstance();
          Object localObject4 = ((Class)localObject2).getField(localField.getName()).get(localObject3);
          localDeclaration1 = localLanguage.declFromField(localModuleExp, localObject4, localField);
          if (((j & 0x10) != 0) && ((!(localObject4 instanceof Location)) || ((localObject4 instanceof FieldLocation))))
            localDeclaration1.noteValue(new QuoteExp(localObject4));
        }
        catch (Exception localException)
        {
          throw new WrappedException(localException);
        }
      }
      finally
      {
      }
      localDeclaration1.noteValue(null);
      continue;
      label237: Declaration localDeclaration2;
      for (Object localObject5 = localModuleExp.firstDecl(); localObject5 != null; localObject5 = localDeclaration2)
      {
        makeDeclInModule2(localModuleExp, (Declaration)localObject5);
        localDeclaration2 = ((Declaration)localObject5).nextDecl();
      }
    }
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ModuleInfo[");
    if (this.moduleClass != null)
    {
      localStringBuffer.append("class: ");
      localStringBuffer.append(this.moduleClass);
    }
    while (true)
    {
      localStringBuffer.append(']');
      return localStringBuffer.toString();
      if (this.className != null)
      {
        localStringBuffer.append("class-name: ");
        localStringBuffer.append(this.className);
      }
    }
  }

  static class ClassToInfoMap extends AbstractWeakHashTable<Class, ModuleInfo>
  {
    protected Class getKeyFromValue(ModuleInfo paramModuleInfo)
    {
      return paramModuleInfo.moduleClass;
    }

    protected boolean matches(Class paramClass1, Class paramClass2)
    {
      return paramClass1 == paramClass2;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ModuleInfo
 * JD-Core Version:    0.6.2
 */