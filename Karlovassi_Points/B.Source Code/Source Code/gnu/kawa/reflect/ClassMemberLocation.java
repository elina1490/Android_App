package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.Symbol;
import gnu.mapping.WrappedException;
import java.lang.reflect.Field;

public abstract class ClassMemberLocation extends Location
{
  Object instance;
  String mname;
  Field rfield;
  ClassType type;

  public ClassMemberLocation(Object paramObject, ClassType paramClassType, String paramString)
  {
    this.instance = paramObject;
    this.type = paramClassType;
    this.mname = paramString;
  }

  public ClassMemberLocation(Object paramObject, Class paramClass, String paramString)
  {
    this.instance = paramObject;
    this.type = ((ClassType)Type.make(paramClass));
    this.mname = paramString;
  }

  public ClassMemberLocation(Object paramObject, Field paramField)
  {
    this.instance = paramObject;
    this.rfield = paramField;
    this.mname = paramField.getName();
  }

  public static void define(Object paramObject, Field paramField, String paramString, Language paramLanguage, Environment paramEnvironment)
    throws IllegalAccessException
  {
    Object localObject1 = paramField.get(paramObject);
    Type localType = Type.make(paramField.getType());
    boolean bool = localType.isSubtype(Compilation.typeLocation);
    localType.isSubtype(Compilation.typeProcedure);
    int i = paramField.getModifiers();
    int j;
    Object localObject2;
    if ((i & 0x10) != 0)
    {
      j = 1;
      if ((j == 0) || (!(localObject1 instanceof Named)) || (bool))
        break label136;
      localObject2 = ((Named)localObject1).getSymbol();
      label82: if (!(localObject2 instanceof Symbol))
        break label149;
    }
    Object localObject4;
    Object localObject5;
    for (Symbol localSymbol = (Symbol)localObject2; ; localSymbol = Symbol.make(paramString, localObject2.toString().intern()))
    {
      if ((!bool) || (j == 0))
        break label173;
      localObject4 = (Location)localObject1;
      localObject5 = null;
      paramEnvironment.addLocation(localSymbol, localObject5, (Location)localObject4);
      return;
      j = 0;
      break;
      label136: localObject2 = Compilation.demangleName(paramField.getName(), true);
      break label82;
      label149: if (paramString == null)
        paramString = "";
    }
    label173: if (j != 0);
    for (Object localObject3 = paramLanguage.getEnvPropertyFor(paramField, localObject1); ; localObject3 = null)
    {
      if ((i & 0x8) != 0);
      for (int k = 1; ; k = 0)
      {
        if (k == 0)
          break label226;
        localObject4 = new StaticFieldLocation(paramField);
        localObject5 = localObject3;
        break;
      }
      label226: FieldLocation localFieldLocation = new FieldLocation(paramObject, paramField);
      localObject5 = localObject3;
      localObject4 = localFieldLocation;
      break;
    }
  }

  public static void defineAll(Object paramObject, Language paramLanguage, Environment paramEnvironment)
    throws IllegalAccessException
  {
    Field[] arrayOfField = paramObject.getClass().getFields();
    int i = arrayOfField.length;
    while (true)
    {
      i--;
      if (i < 0)
        break;
      Field localField = arrayOfField[i];
      String str = localField.getName();
      if ((!str.startsWith("$Prvt$")) && (!str.endsWith("$instance")))
        define(paramObject, localField, null, paramLanguage, paramEnvironment);
    }
  }

  public Object get(Object paramObject)
  {
    Field localField = getRField();
    if (localField == null)
      return paramObject;
    try
    {
      Object localObject = localField.get(this.instance);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw WrappedException.wrapIfNeeded(localIllegalAccessException);
    }
  }

  public ClassType getDeclaringClass()
  {
    return this.type;
  }

  public final Object getInstance()
  {
    return this.instance;
  }

  public String getMemberName()
  {
    return this.mname;
  }

  public Class getRClass()
  {
    Field localField = this.rfield;
    if (localField != null)
      return localField.getDeclaringClass();
    try
    {
      Class localClass = this.type.getReflectClass();
      return localClass;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public Field getRField()
  {
    Field localField = this.rfield;
    if (localField == null);
    try
    {
      localField = this.type.getReflectClass().getField(this.mname);
      this.rfield = localField;
      return localField;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public boolean isBound()
  {
    return getRField() != null;
  }

  public boolean isConstant()
  {
    return (getRField() != null) && ((0x10 & this.rfield.getModifiers()) != 0);
  }

  public void set(Object paramObject)
  {
    setup();
    try
    {
      this.rfield.set(this.instance, paramObject);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw WrappedException.wrapIfNeeded(localIllegalAccessException);
    }
  }

  public final void setInstance(Object paramObject)
  {
    this.instance = paramObject;
  }

  // ERROR //
  void setup()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	gnu/kawa/reflect/ClassMemberLocation:rfield	Ljava/lang/reflect/Field;
    //   4: ifnonnull +25 -> 29
    //   7: aload_0
    //   8: getfield 21	gnu/kawa/reflect/ClassMemberLocation:type	Lgnu/bytecode/ClassType;
    //   11: invokevirtual 163	gnu/bytecode/ClassType:getReflectClass	()Ljava/lang/Class;
    //   14: astore 4
    //   16: aload_0
    //   17: aload 4
    //   19: aload_0
    //   20: getfield 23	gnu/kawa/reflect/ClassMemberLocation:mname	Ljava/lang/String;
    //   23: invokevirtual 167	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   26: putfield 35	gnu/kawa/reflect/ClassMemberLocation:rfield	Ljava/lang/reflect/Field;
    //   29: return
    //   30: astore_1
    //   31: new 185	gnu/mapping/UnboundLocationException
    //   34: dup
    //   35: aconst_null
    //   36: new 187	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   43: ldc 190
    //   45: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 195	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   52: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokespecial 199	gnu/mapping/UnboundLocationException:<init>	(Ljava/lang/Object;Ljava/lang/String;)V
    //   61: astore_2
    //   62: aload_2
    //   63: aload_1
    //   64: invokevirtual 203	java/lang/RuntimeException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   67: pop
    //   68: aload_2
    //   69: athrow
    //   70: astore 5
    //   72: new 185	gnu/mapping/UnboundLocationException
    //   75: dup
    //   76: aconst_null
    //   77: new 187	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   84: ldc 205
    //   86: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: getfield 23	gnu/kawa/reflect/ClassMemberLocation:mname	Ljava/lang/String;
    //   93: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 207
    //   98: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: getfield 21	gnu/kawa/reflect/ClassMemberLocation:type	Lgnu/bytecode/ClassType;
    //   105: invokevirtual 208	gnu/bytecode/ClassType:getName	()Ljava/lang/String;
    //   108: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokespecial 199	gnu/mapping/UnboundLocationException:<init>	(Ljava/lang/Object;Ljava/lang/String;)V
    //   117: astore 6
    //   119: aload 6
    //   121: aload 5
    //   123: invokevirtual 203	java/lang/RuntimeException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   126: pop
    //   127: aload 6
    //   129: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   7	16	30	java/lang/RuntimeException
    //   16	29	70	java/lang/NoSuchFieldException
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.ClassMemberLocation
 * JD-Core Version:    0.6.2
 */