package gnu.expr;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ClassType;
import gnu.kawa.reflect.ClassMemberLocation;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.OutPort;
import gnu.mapping.Symbol;
import gnu.mapping.WrappedException;
import gnu.text.Path;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.Externalizable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ModuleExp extends LambdaExp
  implements Externalizable
{
  public static final int EXPORT_SPECIFIED = 16384;
  public static final int IMMEDIATE = 1048576;
  public static final int LAZY_DECLARATIONS = 524288;
  public static final int NONSTATIC_SPECIFIED = 65536;
  public static final int STATIC_RUN_SPECIFIED = 262144;
  public static final int STATIC_SPECIFIED = 32768;
  public static final int SUPERTYPE_SPECIFIED = 131072;
  public static boolean alwaysCompile = compilerAvailable;
  public static boolean compilerAvailable = true;
  public static String dumpZipPrefix;
  public static int interactiveCounter;
  static int lastZipCounter;
  public static boolean neverCompile = false;
  ModuleInfo info;
  ClassType[] interfaces;
  ClassType superType;

  public static final boolean evalModule(Environment paramEnvironment, CallContext paramCallContext, Compilation paramCompilation, URL paramURL, OutPort paramOutPort)
    throws Throwable
  {
    ModuleExp localModuleExp = paramCompilation.getModule();
    Language localLanguage = paramCompilation.getLanguage();
    Object localObject = evalModule1(paramEnvironment, paramCompilation, paramURL, paramOutPort);
    if (localObject == null)
      return false;
    evalModule2(paramEnvironment, paramCallContext, localLanguage, localModuleExp, localObject);
    return true;
  }

  public static final Object evalModule1(Environment paramEnvironment, Compilation paramCompilation, URL paramURL, OutPort paramOutPort)
    throws SyntaxException
  {
    ModuleExp localModuleExp = paramCompilation.getModule();
    localModuleExp.info = paramCompilation.minfo;
    Environment localEnvironment = Environment.setSaveCurrent(paramEnvironment);
    Compilation localCompilation = Compilation.setSaveCurrent(paramCompilation);
    SourceMessages localSourceMessages = paramCompilation.getMessages();
    ClassLoader localClassLoader = null;
    Thread localThread = null;
    if ((alwaysCompile) && (neverCompile))
      throw new RuntimeException("alwaysCompile and neverCompile are both true!");
    if (neverCompile)
      paramCompilation.mustCompile = false;
    try
    {
      paramCompilation.process(6);
      paramCompilation.minfo.loadByStages(8);
      Object localObject2;
      if (paramOutPort != null)
      {
        boolean bool1 = localSourceMessages.checkErrors(paramOutPort, 20);
        if (!bool1)
          break label139;
        Environment.restoreCurrent(localEnvironment);
        Compilation.restoreCurrent(localCompilation);
        if (0 != 0)
          null.setContextClassLoader(null);
        localObject2 = null;
      }
      while (true)
      {
        return localObject2;
        if (localSourceMessages.seenErrors())
          break;
        label139: boolean bool2 = paramCompilation.mustCompile;
        localClassLoader = null;
        localThread = null;
        if (!bool2)
        {
          if (Compilation.debugPrintFinalExpr)
          {
            localClassLoader = null;
            localThread = null;
            if (paramOutPort != null)
            {
              paramOutPort.println("[Evaluating final module \"" + localModuleExp.getName() + "\":");
              localModuleExp.print(paramOutPort);
              paramOutPort.println(']');
              paramOutPort.flush();
            }
          }
          localObject2 = Boolean.TRUE;
          Environment.restoreCurrent(localEnvironment);
          Compilation.restoreCurrent(localCompilation);
          if (0 == 0)
            continue;
          null.setContextClassLoader(null);
          return localObject2;
        }
        Class localClass = evalToClass(paramCompilation, paramURL);
        if (localClass == null)
        {
          Environment.restoreCurrent(localEnvironment);
          Compilation.restoreCurrent(localCompilation);
          if (0 != 0)
            null.setContextClassLoader(null);
          return null;
        }
        try
        {
          localThread = Thread.currentThread();
          localClassLoader = localThread.getContextClassLoader();
          localThread.setContextClassLoader(localClass.getClassLoader());
          localModuleExp.body = null;
          localModuleExp.thisVariable = null;
          if (paramOutPort != null)
          {
            if (!localSourceMessages.checkErrors(paramOutPort, 20))
              break label384;
            Boolean localBoolean = Boolean.valueOf(false);
            localObject2 = localBoolean;
            return localObject2;
          }
        }
        catch (Throwable localThrowable)
        {
          boolean bool3;
          do
          {
            while (true)
              localThread = null;
            bool3 = localSourceMessages.seenErrors();
          }
          while (bool3);
          label384: return localClass;
        }
      }
    }
    finally
    {
      Environment.restoreCurrent(localEnvironment);
      Compilation.restoreCurrent(localCompilation);
      if (localThread != null)
        localThread.setContextClassLoader(localClassLoader);
    }
  }

  public static final void evalModule2(Environment paramEnvironment, CallContext paramCallContext, Language paramLanguage, ModuleExp paramModuleExp, Object paramObject)
    throws Throwable
  {
    Environment localEnvironment = Environment.setSaveCurrent(paramEnvironment);
    label138: label151: Declaration localDeclaration;
    Object localObject2;
    while (true)
    {
      try
      {
        if (paramObject == Boolean.TRUE)
        {
          paramModuleExp.body.apply(paramCallContext);
          paramCallContext.runUntilDone();
          return;
        }
        if ((paramObject instanceof Class))
          paramObject = ModuleContext.getContext().findInstance((Class)paramObject);
        if ((paramObject instanceof Runnable))
        {
          if (!(paramObject instanceof ModuleBody))
            break label138;
          ModuleBody localModuleBody = (ModuleBody)paramObject;
          if (!localModuleBody.runDone)
          {
            localModuleBody.runDone = true;
            localModuleBody.run(paramCallContext);
          }
        }
        if (paramModuleExp != null)
          break label151;
        ClassMemberLocation.defineAll(paramObject, paramLanguage, paramEnvironment);
        continue;
      }
      finally
      {
        Environment.restoreCurrent(localEnvironment);
        if (0 != 0)
          null.setContextClassLoader(null);
      }
      ((Runnable)paramObject).run();
      continue;
      for (localDeclaration = paramModuleExp.firstDecl(); localDeclaration != null; localDeclaration = localDeclaration.nextDecl())
      {
        localObject2 = localDeclaration.getSymbol();
        if ((!localDeclaration.isPrivate()) && (localObject2 != null))
          break label192;
      }
    }
    label192: gnu.bytecode.Field localField = localDeclaration.field;
    Symbol localSymbol;
    label214: Object localObject3;
    Expression localExpression;
    Object localObject5;
    if ((localObject2 instanceof Symbol))
    {
      localSymbol = (Symbol)localObject2;
      localObject3 = paramLanguage.getEnvPropertyFor(localDeclaration);
      localExpression = localDeclaration.getValue();
      if ((0x10 & localDeclaration.field.getModifiers()) == 0)
        break label390;
      if ((!(localExpression instanceof QuoteExp)) || (localExpression == QuoteExp.undefined_exp))
        break label313;
      localObject5 = ((QuoteExp)localExpression).getValue();
    }
    while (true)
    {
      label313: Object localObject4;
      if (localDeclaration.isIndirectBinding())
      {
        paramEnvironment.addLocation(localSymbol, localObject3, (Location)localObject5);
        break;
        localSymbol = Symbol.make("", localObject2.toString().intern());
        break label214;
        localObject4 = localDeclaration.field.getReflectField().get(null);
        if (!localDeclaration.isIndirectBinding())
        {
          localDeclaration.setValue(QuoteExp.getInstance(localObject4));
          localObject5 = localObject4;
          continue;
        }
        if ((localDeclaration.isAlias()) && ((localExpression instanceof ReferenceExp)))
          break label436;
        localDeclaration.setValue(null);
        break label436;
      }
      paramEnvironment.define(localSymbol, localObject3, localObject5);
      break;
      label390: StaticFieldLocation localStaticFieldLocation = new StaticFieldLocation(localField.getDeclaringClass(), localField.getName());
      localStaticFieldLocation.setDeclaration(localDeclaration);
      paramEnvironment.addLocation(localSymbol, localObject3, localStaticFieldLocation);
      localDeclaration.setValue(null);
      break;
      label436: localObject5 = localObject4;
    }
  }

  public static Class evalToClass(Compilation paramCompilation, URL paramURL)
    throws SyntaxException
  {
    paramCompilation.getModule();
    SourceMessages localSourceMessages = paramCompilation.getMessages();
    int j;
    Object localObject2;
    Object localObject1;
    while (true)
    {
      ArrayClassLoader localArrayClassLoader1;
      try
      {
        paramCompilation.minfo.loadByStages(12);
        if (localSourceMessages.seenErrors())
          return null;
        localArrayClassLoader1 = paramCompilation.loader;
        if (paramURL == null)
          paramURL = Path.currentPath().toURL();
        localArrayClassLoader1.setResourceContext(paramURL);
        if (dumpZipPrefix != null)
        {
          StringBuffer localStringBuffer = new StringBuffer(dumpZipPrefix);
          lastZipCounter = 1 + lastZipCounter;
          if (interactiveCounter > lastZipCounter)
            lastZipCounter = interactiveCounter;
          localStringBuffer.append(lastZipCounter);
          localStringBuffer.append(".zip");
          localZipOutputStream = new ZipOutputStream(new FileOutputStream(localStringBuffer.toString()));
          break label548;
          if (i < paramCompilation.numClasses)
          {
            ClassType localClassType2 = paramCompilation.classes[i];
            String str = localClassType2.getName();
            byte[] arrayOfByte = localClassType2.writeToArray();
            localArrayClassLoader1.addClass(str, arrayOfByte);
            if (localZipOutputStream == null)
              break label554;
            ZipEntry localZipEntry = new ZipEntry(str.replace('.', '/') + ".class");
            localZipEntry.setSize(arrayOfByte.length);
            CRC32 localCRC32 = new CRC32();
            localCRC32.update(arrayOfByte);
            localZipEntry.setCrc(localCRC32.getValue());
            localZipEntry.setMethod(0);
            localZipOutputStream.putNextEntry(localZipEntry);
            localZipOutputStream.write(arrayOfByte);
            break label554;
          }
          if (localZipOutputStream == null)
            break label560;
          localZipOutputStream.close();
          break label560;
          if (!(localArrayClassLoader2.getParent() instanceof ArrayClassLoader))
            break label567;
          localArrayClassLoader2 = (ArrayClassLoader)localArrayClassLoader2.getParent();
          continue;
          if (j < paramCompilation.numClasses)
          {
            ClassType localClassType1 = paramCompilation.classes[j];
            Class localClass2 = localArrayClassLoader1.loadClass(localClassType1.getName());
            localClassType1.setReflectClass(localClass2);
            localClassType1.setExisting(true);
            if (j == 0)
            {
              localObject2 = localClass2;
              break;
            }
            if (localArrayClassLoader2 == localArrayClassLoader1)
              break label586;
            localArrayClassLoader2.addClass(localClass2);
            break label586;
          }
          ModuleInfo localModuleInfo1 = paramCompilation.minfo;
          localModuleInfo1.setModuleClass((Class)localObject1);
          paramCompilation.cleanupAfterCompilation();
          int k = localModuleInfo1.numDependencies;
          int m = 0;
          if (m < k)
          {
            ModuleInfo localModuleInfo2 = localModuleInfo1.dependencies[m];
            Class localClass1 = localModuleInfo2.getModuleClassRaw();
            if (localClass1 == null)
              localClass1 = evalToClass(localModuleInfo2.comp, null);
            paramCompilation.loader.addClass(localClass1);
            m++;
            continue;
          }
          return localObject1;
        }
      }
      catch (IOException localIOException)
      {
        throw new WrappedException("I/O error in lambda eval", localIOException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new WrappedException("class not found in lambda eval", localClassNotFoundException);
      }
      catch (Throwable localThrowable)
      {
        paramCompilation.getMessages().error('f', "internal compile error - caught " + localThrowable, localThrowable);
        throw new SyntaxException(localSourceMessages);
      }
      ZipOutputStream localZipOutputStream = null;
      label548: int i = 0;
      continue;
      label554: i++;
      continue;
      label560: ArrayClassLoader localArrayClassLoader2 = localArrayClassLoader1;
      continue;
      label567: localObject1 = null;
      j = 0;
    }
    while (true)
    {
      j++;
      localObject1 = localObject2;
      break;
      label586: localObject2 = localObject1;
    }
  }

  public static void mustAlwaysCompile()
  {
    alwaysCompile = true;
    neverCompile = false;
  }

  public static void mustNeverCompile()
  {
    alwaysCompile = false;
    neverCompile = true;
    compilerAvailable = false;
  }

  public void allocChildClasses(Compilation paramCompilation)
  {
    declareClosureEnv();
    if (!paramCompilation.usingCPStyle())
      return;
    allocFrame(paramCompilation);
  }

  void allocFields(Compilation paramCompilation)
  {
    Declaration localDeclaration1 = firstDecl();
    if (localDeclaration1 != null)
    {
      if (((localDeclaration1.isSimple()) && (!localDeclaration1.isPublic())) || (localDeclaration1.field != null));
      while (true)
      {
        localDeclaration1 = localDeclaration1.nextDecl();
        break;
        if ((localDeclaration1.getFlag(65536L)) && (localDeclaration1.getFlag(6L)))
          localDeclaration1.makeField(paramCompilation, null);
      }
    }
    Declaration localDeclaration2 = firstDecl();
    if (localDeclaration2 != null)
    {
      if (localDeclaration2.field != null);
      Expression localExpression1;
      while (true)
      {
        localDeclaration2 = localDeclaration2.nextDecl();
        break;
        localExpression1 = localDeclaration2.getValue();
        if (((!localDeclaration2.isSimple()) || (localDeclaration2.isPublic()) || (localDeclaration2.isNamespaceDecl()) || ((localDeclaration2.getFlag(16384L)) && (localDeclaration2.getFlag(6L)))) && (!localDeclaration2.getFlag(65536L)))
        {
          if ((!(localExpression1 instanceof LambdaExp)) || ((localExpression1 instanceof ModuleExp)) || ((localExpression1 instanceof ClassExp)))
            break label185;
          ((LambdaExp)localExpression1).allocFieldFor(paramCompilation);
        }
      }
      label185: if ((localDeclaration2.shouldEarlyInit()) || (localDeclaration2.isAlias()));
      for (Expression localExpression2 = localExpression1; ; localExpression2 = null)
      {
        localDeclaration2.makeField(paramCompilation, localExpression2);
        break;
      }
    }
  }

  public ClassType classFor(Compilation paramCompilation)
  {
    if ((this.type != null) && (this.type != Compilation.typeProcedure))
      return this.type;
    String str1 = getFileName();
    String str2 = getName();
    Path localPath1 = null;
    String str3;
    String str4;
    String str7;
    String str5;
    label173: ClassType localClassType;
    if (str2 != null)
    {
      str3 = str2;
      if (getName() == null)
        setName(str3);
      str4 = Compilation.mangleNameIfNeeded(str3);
      if ((paramCompilation.classPrefix.length() != 0) || (localPath1 == null) || (localPath1.isAbsolute()))
        break label368;
      Path localPath2 = localPath1.getParent();
      if (localPath2 == null)
        break label368;
      String str6 = localPath2.toString();
      if ((str6.length() <= 0) || (str6.indexOf("..") >= 0))
        break label368;
      str7 = str6.replaceAll(System.getProperty("file.separator"), "/");
      if (str7.startsWith("./"))
        str7 = str7.substring(2);
      if (!str7.equals("."))
        break label334;
      str5 = str4;
      localClassType = new ClassType(str5);
      setType(localClassType);
      if (paramCompilation.mainLambda == this)
      {
        if (paramCompilation.mainClass != null)
          break label395;
        paramCompilation.mainClass = localClassType;
      }
    }
    while (true)
    {
      return localClassType;
      if (str1 == null)
      {
        str3 = getName();
        localPath1 = null;
        if (str3 != null)
          break;
        str3 = "$unnamed_input_file$";
        localPath1 = null;
        break;
      }
      if ((this.filename.equals("-")) || (this.filename.equals("/dev/stdin")))
      {
        str3 = getName();
        localPath1 = null;
        if (str3 != null)
          break;
        str3 = "$stdin$";
        localPath1 = null;
        break;
      }
      localPath1 = Path.valueOf(str1);
      str3 = localPath1.getLast();
      int i = str3.lastIndexOf('.');
      if (i <= 0)
        break;
      str3 = str3.substring(0, i);
      break;
      label334: str5 = Compilation.mangleURI(str7) + "." + str4;
      break label173;
      label368: str5 = paramCompilation.classPrefix + str4;
      break label173;
      label395: if (!str5.equals(paramCompilation.mainClass.getName()))
        paramCompilation.error('e', "inconsistent main class name: " + str5 + " - old name: " + paramCompilation.mainClass.getName());
    }
  }

  public Declaration firstDecl()
  {
    try
    {
      if (getFlag(524288))
        this.info.setupModuleExp();
      return this.decls;
    }
    finally
    {
    }
  }

  public final ClassType[] getInterfaces()
  {
    return this.interfaces;
  }

  public String getNamespaceUri()
  {
    return this.info.uri;
  }

  public final ClassType getSuperType()
  {
    return this.superType;
  }

  public final boolean isStatic()
  {
    return (getFlag(32768)) || (((Compilation.moduleStatic >= 0) || (getFlag(1048576))) && (!getFlag(131072)) && (!getFlag(65536)));
  }

  public void print(OutPort paramOutPort)
  {
    paramOutPort.startLogicalBlock("(Module/", ")", 2);
    Object localObject = getSymbol();
    if (localObject != null)
    {
      paramOutPort.print(localObject);
      paramOutPort.print('/');
    }
    paramOutPort.print(this.id);
    paramOutPort.print('/');
    paramOutPort.writeSpaceFill();
    paramOutPort.startLogicalBlock("(", false, ")");
    Declaration localDeclaration = firstDecl();
    if (localDeclaration != null)
    {
      paramOutPort.print("Declarations:");
      while (localDeclaration != null)
      {
        paramOutPort.writeSpaceFill();
        localDeclaration.printInfo(paramOutPort);
        localDeclaration = localDeclaration.nextDecl();
      }
    }
    paramOutPort.endLogicalBlock(")");
    paramOutPort.writeSpaceLinear();
    if (this.body == null)
      paramOutPort.print("<null body>");
    while (true)
    {
      paramOutPort.endLogicalBlock(")");
      return;
      this.body.print(paramOutPort);
    }
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    Object localObject = paramObjectInput.readObject();
    if ((localObject instanceof ClassType))
    {
      this.type = ((ClassType)localObject);
      setName(this.type.getName());
    }
    while (true)
    {
      this.flags = (0x80000 | this.flags);
      return;
      setName((String)localObject);
    }
  }

  public final void setInterfaces(ClassType[] paramArrayOfClassType)
  {
    this.interfaces = paramArrayOfClassType;
  }

  public final void setSuperType(ClassType paramClassType)
  {
    this.superType = paramClassType;
  }

  public boolean staticInitRun()
  {
    return (isStatic()) && ((getFlag(262144)) || (Compilation.moduleStatic == 2));
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    return paramExpVisitor.visitModuleExp(this, paramD);
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    if ((this.type != null) && (this.type != Compilation.typeProcedure) && (!this.type.isExisting()))
    {
      paramObjectOutput.writeObject(this.type);
      return;
    }
    String str = null;
    if (0 == 0)
      str = getName();
    if (str == null)
      str = getFileName();
    paramObjectOutput.writeObject(str);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ModuleExp
 * JD-Core Version:    0.6.2
 */