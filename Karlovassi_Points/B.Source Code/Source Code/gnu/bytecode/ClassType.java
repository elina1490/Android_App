package gnu.bytecode;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.Externalizable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class ClassType extends ObjectType
  implements AttrContainer, Externalizable, Member
{
  public static final int JDK_1_1_VERSION = 2949123;
  public static final int JDK_1_2_VERSION = 3014656;
  public static final int JDK_1_3_VERSION = 3080192;
  public static final int JDK_1_4_VERSION = 3145728;
  public static final int JDK_1_5_VERSION = 3211264;
  public static final int JDK_1_6_VERSION = 3276800;
  public static final int JDK_1_7_VERSION = 3342336;
  public static final ClassType[] noClasses = new ClassType[0];
  int Code_name_index;
  int ConstantValue_name_index;
  int LineNumberTable_name_index;
  int LocalVariableTable_name_index;
  int access_flags;
  Attribute attributes;
  int classfileFormatVersion = 2949123;
  ConstantPool constants;
  public Method constructor;
  boolean emitDebugInfo = true;
  Member enclosingMember;
  Field fields;
  int fields_count;
  ClassType firstInnerClass;
  int[] interfaceIndexes;
  ClassType[] interfaces;
  Field last_field;
  Method last_method;
  Method methods;
  int methods_count;
  ClassType nextInnerClass;
  SourceDebugExtAttr sourceDbgExt;
  ClassType superClass;
  int superClassIndex = -1;
  int thisClassIndex;

  public ClassType()
  {
  }

  public ClassType(String paramString)
  {
    setName(paramString);
  }

  public static ClassType make(String paramString)
  {
    return (ClassType)Type.getType(paramString);
  }

  public static ClassType make(String paramString, ClassType paramClassType)
  {
    ClassType localClassType = make(paramString);
    if (localClassType.superClass == null)
      localClassType.setSuper(paramClassType);
    return localClassType;
  }

  public static byte[] to_utf8(String paramString)
  {
    if (paramString == null)
      return null;
    int i = paramString.length();
    int j = 0;
    int k = 0;
    if (k < i)
    {
      int i7 = paramString.charAt(k);
      if ((i7 > 0) && (i7 <= 127))
        j++;
      while (true)
      {
        k++;
        break;
        if (i7 <= 2047)
          j += 2;
        else
          j += 3;
      }
    }
    byte[] arrayOfByte = new byte[j];
    int m = 0;
    int n = 0;
    if (m < i)
    {
      int i1 = paramString.charAt(m);
      int i4;
      if ((i1 > 0) && (i1 <= 127))
      {
        i4 = n + 1;
        arrayOfByte[n] = ((byte)i1);
      }
      while (true)
      {
        m++;
        n = i4;
        break;
        if (i1 <= 2047)
        {
          int i5 = n + 1;
          arrayOfByte[n] = ((byte)(0xC0 | 0x1F & i1 >> 6));
          int i6 = i5 + 1;
          arrayOfByte[i5] = ((byte)(0x80 | 0x3F & i1 >> 0));
          i4 = i6;
        }
        else
        {
          int i2 = n + 1;
          arrayOfByte[n] = ((byte)(0xE0 | 0xF & i1 >> 12));
          int i3 = i2 + 1;
          arrayOfByte[i2] = ((byte)(0x80 | 0x3F & i1 >> 6));
          i4 = i3 + 1;
          arrayOfByte[i3] = ((byte)(0x80 | 0x3F & i1 >> 0));
        }
      }
    }
    return arrayOfByte;
  }

  void addEnclosingMember()
  {
    while (true)
    {
      Class localClass1;
      Class localClass2;
      try
      {
        int i = this.flags;
        if ((i & 0x18) != 16)
          return;
        localClass1 = getReflectClass();
        this.flags = (0x8 | this.flags);
        localClass2 = localClass1.getEnclosingClass();
        if (localClass2 == null)
          continue;
        if (localClass1.isMemberClass())
          break label106;
        java.lang.reflect.Method localMethod = localClass1.getEnclosingMethod();
        if (localMethod != null)
        {
          this.enclosingMember = addMethod(localMethod);
          continue;
        }
      }
      finally
      {
      }
      Constructor localConstructor = localClass1.getEnclosingConstructor();
      if (localConstructor != null)
        this.enclosingMember = addMethod(localConstructor);
      else
        label106: this.enclosingMember = ((ClassType)Type.make(localClass2));
    }
  }

  public Field addField()
  {
    return new Field(this);
  }

  public Field addField(String paramString)
  {
    Field localField = new Field(this);
    localField.setName(paramString);
    return localField;
  }

  public final Field addField(String paramString, Type paramType)
  {
    Field localField = new Field(this);
    localField.setName(paramString);
    localField.setType(paramType);
    return localField;
  }

  public final Field addField(String paramString, Type paramType, int paramInt)
  {
    Field localField = addField(paramString, paramType);
    localField.flags = paramInt;
    return localField;
  }

  public void addFields()
  {
    try
    {
      Class localClass = getReflectClass();
      try
      {
        java.lang.reflect.Field[] arrayOfField2 = localClass.getDeclaredFields();
        for (java.lang.reflect.Field localField : arrayOfField2)
        {
          if ("this$0".equals(localField.getName()))
            this.flags = (0x20 | this.flags);
          addField(localField.getName(), Type.make(localField.getType()), localField.getModifiers());
        }
      }
      catch (SecurityException localSecurityException)
      {
        while (true)
          ??? = localClass.getFields();
        this.flags = (0x1 | this.flags);
        return;
      }
    }
    finally
    {
    }
  }

  public void addInterface(ClassType paramClassType)
  {
    int i;
    if ((this.interfaces == null) || (this.interfaces.length == 0))
      i = 0;
    ClassType[] arrayOfClassType;
    for (this.interfaces = new ClassType[1]; ; this.interfaces = arrayOfClassType)
    {
      this.interfaces[i] = paramClassType;
      return;
      i = this.interfaces.length;
      int j = i;
      do
      {
        j--;
        if (j < 0)
          break;
      }
      while (this.interfaces[j] != paramClassType);
      return;
      arrayOfClassType = new ClassType[i + 1];
      System.arraycopy(this.interfaces, 0, arrayOfClassType, 0, i);
    }
  }

  public void addMemberClass(ClassType paramClassType)
  {
    Object localObject = null;
    for (ClassType localClassType = this.firstInnerClass; localClassType != null; localClassType = localClassType.nextInnerClass)
    {
      if (localClassType == paramClassType)
        return;
      localObject = localClassType;
    }
    if (localObject == null)
    {
      this.firstInnerClass = paramClassType;
      return;
    }
    localObject.nextInnerClass = paramClassType;
  }

  public void addMemberClasses()
  {
    try
    {
      int i = this.flags;
      if ((i & 0x14) != 16);
      while (true)
      {
        return;
        Class localClass = getReflectClass();
        this.flags = (0x4 | this.flags);
        Class[] arrayOfClass = localClass.getClasses();
        int j = arrayOfClass.length;
        if (j > 0)
          for (int k = 0; k < j; k++)
            addMemberClass((ClassType)Type.make(arrayOfClass[k]));
      }
    }
    finally
    {
    }
  }

  Method addMethod()
  {
    return new Method(this, 0);
  }

  public Method addMethod(String paramString)
  {
    return addMethod(paramString, 0);
  }

  public Method addMethod(String paramString, int paramInt)
  {
    Method localMethod = new Method(this, paramInt);
    localMethod.setName(paramString);
    return localMethod;
  }

  public Method addMethod(String paramString, int paramInt, Type[] paramArrayOfType, Type paramType)
  {
    try
    {
      Method localMethod1 = getDeclaredMethod(paramString, paramArrayOfType);
      if ((localMethod1 != null) && (paramType.equals(localMethod1.getReturnType())))
      {
        int i = localMethod1.access_flags;
        if ((i & paramInt) != paramInt);
      }
      Method localMethod2;
      for (Object localObject2 = localMethod1; ; localObject2 = localMethod2)
      {
        return localObject2;
        localMethod2 = addMethod(paramString, paramInt);
        localMethod2.arg_types = paramArrayOfType;
        localMethod2.return_type = paramType;
      }
    }
    finally
    {
    }
  }

  public Method addMethod(String paramString1, String paramString2, int paramInt)
  {
    Method localMethod = addMethod(paramString1, paramInt);
    localMethod.setSignature(paramString2);
    return localMethod;
  }

  public Method addMethod(String paramString, Type[] paramArrayOfType, Type paramType, int paramInt)
  {
    return addMethod(paramString, paramInt, paramArrayOfType, paramType);
  }

  public Method addMethod(Constructor paramConstructor)
  {
    Class[] arrayOfClass = paramConstructor.getParameterTypes();
    int i = paramConstructor.getModifiers();
    int j = arrayOfClass.length;
    Type[] arrayOfType = new Type[j];
    while (true)
    {
      j--;
      if (j < 0)
        break;
      arrayOfType[j] = Type.make(arrayOfClass[j]);
    }
    return addMethod("<init>", i, arrayOfType, Type.voidType);
  }

  public Method addMethod(java.lang.reflect.Method paramMethod)
  {
    int i = paramMethod.getModifiers();
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int j = arrayOfClass.length;
    Type[] arrayOfType = new Type[j];
    while (true)
    {
      j--;
      if (j < 0)
        break;
      arrayOfType[j] = Type.make(arrayOfClass[j]);
    }
    Type localType = Type.make(paramMethod.getReturnType());
    return addMethod(paramMethod.getName(), i, arrayOfType, localType);
  }

  public void addMethods(Class paramClass)
  {
    int j;
    try
    {
      this.flags = (0x2 | this.flags);
      try
      {
        java.lang.reflect.Method[] arrayOfMethod2 = paramClass.getDeclaredMethods();
        arrayOfMethod1 = arrayOfMethod2;
        int i = arrayOfMethod1.length;
        j = 0;
        if (j < i)
        {
          localMethod = arrayOfMethod1[j];
          if (localMethod.getDeclaringClass().equals(paramClass));
        }
      }
      catch (SecurityException localSecurityException1)
      {
        java.lang.reflect.Method localMethod;
        while (true)
          java.lang.reflect.Method[] arrayOfMethod1 = paramClass.getMethods();
        addMethod(localMethod);
      }
    }
    finally
    {
    }
    while (true)
    {
      int m;
      try
      {
        Constructor[] arrayOfConstructor2 = paramClass.getDeclaredConstructors();
        arrayOfConstructor1 = arrayOfConstructor2;
        int k = arrayOfConstructor1.length;
        m = 0;
        if (m < k)
        {
          localConstructor = arrayOfConstructor1[m];
          if (localConstructor.getDeclaringClass().equals(paramClass));
        }
      }
      catch (SecurityException localSecurityException2)
      {
        Constructor localConstructor;
        Constructor[] arrayOfConstructor1 = paramClass.getConstructors();
        continue;
        addMethod(localConstructor);
      }
      return;
      j++;
      break;
      m++;
    }
  }

  public final void addModifiers(int paramInt)
  {
    this.access_flags = (paramInt | this.access_flags);
  }

  public Method checkSingleAbstractMethod()
  {
    Method[] arrayOfMethod = getAbstractMethods();
    int i = arrayOfMethod.length;
    Object localObject = null;
    int j = 0;
    if (j < i)
    {
      Method localMethod1 = arrayOfMethod[j];
      Method localMethod2 = getMethod(localMethod1.getName(), localMethod1.getParameterTypes());
      if ((localMethod2 != null) && (!localMethod2.isAbstract()));
      while (true)
      {
        j++;
        break;
        if (localObject != null)
          return null;
        localObject = localMethod1;
      }
    }
    return localObject;
  }

  public void cleanupAfterCompilation()
  {
    for (Method localMethod = this.methods; localMethod != null; localMethod = localMethod.getNext())
      localMethod.cleanupAfterCompilation();
    this.constants = null;
    this.attributes = null;
    this.sourceDbgExt = null;
  }

  public int compare(Type paramType)
  {
    if (paramType == nullType)
      return 1;
    if (!(paramType instanceof ClassType))
      return swappedCompareResult(paramType.compare(this));
    String str = getName();
    if ((str != null) && (str.equals(paramType.getName())))
      return 0;
    ClassType localClassType = (ClassType)paramType;
    if (isSubclass(localClassType))
      return -1;
    if (localClassType.isSubclass(this))
      return 1;
    if (this == toStringType)
    {
      if (localClassType == Type.javalangObjectType)
        return -1;
      return 1;
    }
    if (localClassType == toStringType)
    {
      if (this == Type.javalangObjectType)
        return 1;
      return -1;
    }
    if (isInterface())
    {
      if (localClassType == Type.javalangObjectType)
        return -1;
      return -2;
    }
    if (localClassType.isInterface())
    {
      if (this == Type.javalangObjectType)
        return 1;
      return -2;
    }
    return -3;
  }

  public final int countMethods(Filter paramFilter, int paramInt)
  {
    Vector localVector = new Vector();
    getMethods(paramFilter, paramInt, localVector);
    return localVector.size();
  }

  public void doFixups()
  {
    if (this.constants == null)
      this.constants = new ConstantPool();
    if (this.thisClassIndex == 0)
      this.thisClassIndex = this.constants.addClass(this).index;
    if (this.superClass == this)
      setSuper((ClassType)null);
    if (this.superClassIndex < 0)
      if (this.superClass != null)
        break label148;
    label148: for (int m = 0; ; m = this.constants.addClass(this.superClass).index)
    {
      this.superClassIndex = m;
      if ((this.interfaces == null) || (this.interfaceIndexes != null))
        break;
      int j = this.interfaces.length;
      this.interfaceIndexes = new int[j];
      for (int k = 0; k < j; k++)
        this.interfaceIndexes[k] = this.constants.addClass(this.interfaces[k]).index;
    }
    for (Field localField = this.fields; localField != null; localField = localField.next)
      localField.assign_constants(this);
    for (Method localMethod = this.methods; localMethod != null; localMethod = localMethod.next)
      localMethod.assignConstants();
    if ((this.enclosingMember instanceof Method))
    {
      EnclosingMethodAttr localEnclosingMethodAttr = EnclosingMethodAttr.getFirstEnclosingMethod(getAttributes());
      if (localEnclosingMethodAttr == null)
        localEnclosingMethodAttr = new EnclosingMethodAttr(this);
      localEnclosingMethodAttr.method = ((Method)this.enclosingMember);
    }
    while (true)
    {
      for (ClassType localClassType = this.firstInnerClass; localClassType != null; localClassType = localClassType.nextInnerClass)
        this.constants.addClass(localClassType);
      if ((this.enclosingMember instanceof ClassType))
        this.constants.addClass((ClassType)this.enclosingMember);
    }
    InnerClassesAttr localInnerClassesAttr = InnerClassesAttr.getFirstInnerClasses(getAttributes());
    if (localInnerClassesAttr != null)
      localInnerClassesAttr.setSkipped(true);
    Attribute.assignConstants(this, this);
    int i = 1;
    if (i <= this.constants.count)
    {
      CpoolEntry localCpoolEntry = this.constants.pool[i];
      if (!(localCpoolEntry instanceof CpoolClass));
      while (true)
      {
        i++;
        break;
        CpoolClass localCpoolClass = (CpoolClass)localCpoolEntry;
        if (((localCpoolClass.clas instanceof ClassType)) && (((ClassType)localCpoolClass.clas).getEnclosingMember() != null))
        {
          if (localInnerClassesAttr == null)
            localInnerClassesAttr = new InnerClassesAttr(this);
          localInnerClassesAttr.addClass(localCpoolClass, this);
        }
      }
    }
    if (localInnerClassesAttr != null)
    {
      localInnerClassesAttr.setSkipped(false);
      localInnerClassesAttr.assignConstants(this);
    }
  }

  public Method[] getAbstractMethods()
  {
    return getMethods(AbstractMethodFilter.instance, 2);
  }

  public final Attribute getAttributes()
  {
    return this.attributes;
  }

  public short getClassfileMajorVersion()
  {
    return (short)(this.classfileFormatVersion >> 16);
  }

  public short getClassfileMinorVersion()
  {
    return (short)(0xFFFF & this.classfileFormatVersion);
  }

  public int getClassfileVersion()
  {
    return this.classfileFormatVersion;
  }

  public final CpoolEntry getConstant(int paramInt)
  {
    if ((this.constants == null) || (this.constants.pool == null) || (paramInt > this.constants.count))
      return null;
    return this.constants.pool[paramInt];
  }

  public final ConstantPool getConstants()
  {
    return this.constants;
  }

  public ClassType getDeclaredClass(String paramString)
  {
    addMemberClasses();
    for (ClassType localClassType = this.firstInnerClass; localClassType != null; localClassType = localClassType.nextInnerClass)
      if (paramString.equals(localClassType.getSimpleName()))
        return localClassType;
    return null;
  }

  public Field getDeclaredField(String paramString)
  {
    for (Field localField = getFields(); localField != null; localField = localField.next)
      if (paramString.equals(localField.name))
        return localField;
    return null;
  }

  public Method getDeclaredMethod(String paramString, int paramInt)
  {
    Object localObject1 = null;
    while (true)
    {
      try
      {
        if (("<init>".equals(paramString)) && (hasOuterLink()))
        {
          i = 1;
          localMethod = getDeclaredMethods();
          if (localMethod == null)
            break;
          if ((!paramString.equals(localMethod.getName())) || (paramInt + i != localMethod.getParameterTypes().length))
            break label139;
          if (localObject1 == null)
            break label136;
          throw new Error("ambiguous call to getDeclaredMethod(\"" + paramString + "\", " + paramInt + ")\n - " + localObject1 + "\n - " + localMethod);
        }
      }
      finally
      {
      }
      int i = 0;
      continue;
      label136: localObject1 = localMethod;
      label139: Method localMethod = localMethod.next;
    }
    return localObject1;
  }

  public Method getDeclaredMethod(String paramString, Type[] paramArrayOfType)
  {
    int i;
    Method localMethod;
    if (("<init>".equals(paramString)) && (hasOuterLink()))
    {
      i = 1;
      localMethod = getDeclaredMethods();
      label25: if (localMethod == null)
        break label154;
      if (paramString.equals(localMethod.getName()))
        break label57;
    }
    label57: int j;
    do
    {
      Type[] arrayOfType;
      do
      {
        localMethod = localMethod.next;
        break label25;
        i = 0;
        break;
        arrayOfType = localMethod.getParameterTypes();
        if ((paramArrayOfType == null) || ((paramArrayOfType == arrayOfType) && (i == 0)))
          return localMethod;
        j = paramArrayOfType.length;
      }
      while (j != arrayOfType.length - i);
      Type localType1;
      Type localType2;
      do
      {
        j--;
        if (j < 0)
          break;
        localType1 = arrayOfType[(j + i)];
        localType2 = paramArrayOfType[j];
      }
      while ((localType1 == localType2) || (localType2 == null) || (localType1.getSignature().equals(localType2.getSignature())));
    }
    while (j >= 0);
    return localMethod;
    label154: return null;
  }

  public final Method getDeclaredMethods()
  {
    try
    {
      if ((0x12 & this.flags) == 16)
        addMethods(getReflectClass());
      Method localMethod = this.methods;
      return localMethod;
    }
    finally
    {
    }
  }

  public ClassType getDeclaringClass()
  {
    addEnclosingMember();
    if ((this.enclosingMember instanceof ClassType))
      return (ClassType)this.enclosingMember;
    return null;
  }

  public Member getEnclosingMember()
  {
    addEnclosingMember();
    return this.enclosingMember;
  }

  public Field getField(String paramString)
  {
    return getField(paramString, 1);
  }

  public Field getField(String paramString, int paramInt)
  {
    Object localObject1 = this;
    while (true)
    {
      int i;
      try
      {
        Field localField1 = ((ClassType)localObject1).getDeclaredField(paramString);
        if (localField1 != null)
          if (paramInt != -1)
          {
            int j = localField1.getModifiers();
            if ((j & paramInt) == 0);
          }
          else
          {
            localObject3 = localField1;
            return localObject3;
          }
        ClassType[] arrayOfClassType = ((ClassType)localObject1).getInterfaces();
        if (arrayOfClassType != null)
        {
          i = 0;
          if (i < arrayOfClassType.length)
          {
            Field localField2 = arrayOfClassType[i].getField(paramString, paramInt);
            if (localField2 == null)
              break label116;
            localObject3 = localField2;
            continue;
          }
        }
        ClassType localClassType = ((ClassType)localObject1).getSuperclass();
        localObject1 = localClassType;
        if (localObject1 != null)
          continue;
        Object localObject3 = null;
        continue;
      }
      finally
      {
      }
      label116: i++;
    }
  }

  public final int getFieldCount()
  {
    return this.fields_count;
  }

  public final Field getFields()
  {
    try
    {
      if ((0x11 & this.flags) == 16)
        addFields();
      Field localField = this.fields;
      return localField;
    }
    finally
    {
    }
  }

  public ClassType[] getInterfaces()
  {
    try
    {
      if ((this.interfaces == null) && ((0x10 & this.flags) != 0) && (getReflectClass() != null))
      {
        Class[] arrayOfClass = this.reflectClass.getInterfaces();
        int i = arrayOfClass.length;
        if (i == 0);
        for (ClassType[] arrayOfClassType2 = noClasses; ; arrayOfClassType2 = new ClassType[i])
        {
          this.interfaces = arrayOfClassType2;
          for (int j = 0; j < i; j++)
            this.interfaces[j] = ((ClassType)Type.make(arrayOfClass[j]));
        }
      }
      ClassType[] arrayOfClassType1 = this.interfaces;
      return arrayOfClassType1;
    }
    finally
    {
    }
  }

  public Method[] getMatchingMethods(String paramString, Type[] paramArrayOfType, int paramInt)
  {
    int i = 0;
    Vector localVector = new Vector(10);
    Method localMethod = this.methods;
    if (localMethod != null)
    {
      if (!paramString.equals(localMethod.getName()));
      while (true)
      {
        localMethod = localMethod.getNext();
        break;
        if (((paramInt & 0x8) == (0x8 & localMethod.access_flags)) && ((paramInt & 0x1) <= (0x1 & localMethod.access_flags)) && (localMethod.arg_types.length == paramArrayOfType.length))
        {
          i++;
          localVector.addElement(localMethod);
        }
      }
    }
    Method[] arrayOfMethod = new Method[i];
    localVector.copyInto(arrayOfMethod);
    return arrayOfMethod;
  }

  public Method getMethod(String paramString, Type[] paramArrayOfType)
  {
    ClassType localClassType1 = this;
    while (true)
    {
      int i;
      try
      {
        Method localMethod1 = localClassType1.getDeclaredMethod(paramString, paramArrayOfType);
        if (localMethod1 != null)
        {
          localObject3 = localMethod1;
          return localObject3;
        }
        localClassType1 = localClassType1.getSuperclass();
        if (localClassType1 != null)
          continue;
        Object localObject2 = this;
        ClassType[] arrayOfClassType = ((ClassType)localObject2).getInterfaces();
        if (arrayOfClassType != null)
        {
          i = 0;
          if (i < arrayOfClassType.length)
          {
            Method localMethod2 = arrayOfClassType[i].getDeclaredMethod(paramString, paramArrayOfType);
            if (localMethod2 == null)
              break label114;
            localObject3 = localMethod2;
            continue;
          }
        }
        ClassType localClassType2 = ((ClassType)localObject2).getSuperclass();
        localObject2 = localClassType2;
        if (localObject2 != null)
          continue;
        Object localObject3 = null;
        continue;
      }
      finally
      {
      }
      label114: i++;
    }
  }

  public Method getMethod(java.lang.reflect.Method paramMethod)
  {
    String str = paramMethod.getName();
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    Type[] arrayOfType = new Type[arrayOfClass.length];
    int i = arrayOfClass.length;
    while (true)
    {
      i--;
      if (i < 0)
        break;
      arrayOfType[i] = Type.make(arrayOfClass[i]);
    }
    return addMethod(str, paramMethod.getModifiers(), arrayOfType, Type.make(paramMethod.getReturnType()));
  }

  public final int getMethodCount()
  {
    return this.methods_count;
  }

  public int getMethods(Filter paramFilter, int paramInt, List<Method> paramList)
  {
    int i = 0;
    Object localObject = null;
    for (ClassType localClassType = this; ; localClassType = localClassType.getSuperclass())
    {
      if (localClassType != null)
      {
        String str = localClassType.getPackageName();
        Method localMethod = localClassType.getDeclaredMethods();
        if (localMethod != null)
        {
          int k;
          if (localClassType != this)
          {
            k = localMethod.getModifiers();
            if ((k & 0x2) == 0);
          }
          while (true)
          {
            localMethod = localMethod.getNext();
            break;
            if (((k & 0x5) != 0) || (str.equals(localObject)))
              if (paramFilter.select(localMethod))
              {
                if (paramList != null)
                  paramList.add(localMethod);
                i++;
              }
          }
        }
        localObject = str;
        if (paramInt != 0);
      }
      else
      {
        return i;
      }
      if (paramInt > 1)
      {
        ClassType[] arrayOfClassType = localClassType.getInterfaces();
        if (arrayOfClassType != null)
          for (int j = 0; j < arrayOfClassType.length; j++)
            i += arrayOfClassType[j].getMethods(paramFilter, paramInt, paramList);
      }
    }
  }

  public int getMethods(Filter paramFilter, int paramInt1, Method[] paramArrayOfMethod, int paramInt2)
  {
    Vector localVector = new Vector();
    getMethods(paramFilter, paramInt1, localVector);
    int i = localVector.size();
    for (int j = 0; j < i; j++)
      paramArrayOfMethod[(paramInt2 + j)] = ((Method)localVector.elementAt(j));
    return i;
  }

  public final Method getMethods()
  {
    return this.methods;
  }

  public Method[] getMethods(Filter paramFilter, int paramInt)
  {
    Vector localVector = new Vector();
    getMethods(paramFilter, paramInt, localVector);
    int i = localVector.size();
    Method[] arrayOfMethod = new Method[i];
    for (int j = 0; j < i; j++)
      arrayOfMethod[j] = ((Method)localVector.elementAt(j));
    return arrayOfMethod;
  }

  public Method[] getMethods(Filter paramFilter, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
      return getMethods(paramFilter, i);
  }

  public final int getModifiers()
  {
    try
    {
      if ((this.access_flags == 0) && ((0x10 & this.flags) != 0) && (getReflectClass() != null))
        this.access_flags = this.reflectClass.getModifiers();
      int i = this.access_flags;
      return i;
    }
    finally
    {
    }
  }

  public ClassType getOuterLinkType()
  {
    if (!hasOuterLink())
      return null;
    return (ClassType)getDeclaredField("this$0").getType();
  }

  public String getPackageName()
  {
    String str = getName();
    int i = str.lastIndexOf('.');
    if (i < 0)
      return "";
    return str.substring(0, i);
  }

  public String getSimpleName()
  {
    try
    {
      if ((0x10 & this.flags) != 0)
      {
        Class localClass = getReflectClass();
        if (localClass == null);
      }
      while (true)
      {
        try
        {
          String str2 = this.reflectClass.getSimpleName();
          localObject3 = str2;
          return localObject3;
        }
        catch (Throwable localThrowable)
        {
        }
        Object localObject2 = getName();
        int i = ((String)localObject2).lastIndexOf('.');
        if (i > 0)
          localObject2 = ((String)localObject2).substring(i + 1);
        int j = ((String)localObject2).lastIndexOf('$');
        if (j >= 0)
        {
          int k = ((String)localObject2).length();
          for (int m = j + 1; m < k; m++)
          {
            int n = ((String)localObject2).charAt(m);
            if ((n < 48) || (n > 57))
              break;
          }
          String str1 = ((String)localObject2).substring(m);
          localObject2 = str1;
        }
        Object localObject3 = localObject2;
      }
    }
    finally
    {
    }
  }

  public final boolean getStaticFlag()
  {
    return (0x8 & getModifiers()) != 0;
  }

  public ClassType getSuperclass()
  {
    try
    {
      if ((this.superClass == null) && (!isInterface()) && (!"java.lang.Object".equals(getName())) && ((0x10 & this.flags) != 0) && (getReflectClass() != null))
        this.superClass = ((ClassType)make(this.reflectClass.getSuperclass()));
      ClassType localClassType = this.superClass;
      return localClassType;
    }
    finally
    {
    }
  }

  public final boolean hasOuterLink()
  {
    getFields();
    return (0x20 & this.flags) != 0;
  }

  public final boolean implementsInterface(ClassType paramClassType)
  {
    if (this == paramClassType)
      return true;
    ClassType localClassType = getSuperclass();
    if ((localClassType != null) && (localClassType.implementsInterface(paramClassType)))
      return true;
    ClassType[] arrayOfClassType = getInterfaces();
    if (arrayOfClassType != null)
    {
      int i = arrayOfClassType.length;
      do
      {
        i--;
        if (i < 0)
          break;
      }
      while (!arrayOfClassType[i].implementsInterface(paramClassType));
      return true;
    }
    return false;
  }

  public boolean isAccessible(ClassType paramClassType, ObjectType paramObjectType, int paramInt)
  {
    int i = paramClassType.getModifiers();
    if (((paramInt & 0x1) != 0) && ((i & 0x1) != 0))
      return true;
    String str1 = getName();
    String str2 = paramClassType.getName();
    if (str1.equals(str2))
      return true;
    if ((paramInt & 0x2) != 0)
      return false;
    int j = str1.lastIndexOf('.');
    String str3;
    int k;
    if (j >= 0)
    {
      str3 = str1.substring(0, j);
      k = str2.lastIndexOf('.');
      if (k < 0)
        break label121;
    }
    label121: for (String str4 = str2.substring(0, k); ; str4 = "")
    {
      if (!str3.equals(str4))
        break label129;
      return true;
      str3 = "";
      break;
    }
    label129: if ((i & 0x1) == 0)
      return false;
    return ((paramInt & 0x4) != 0) && (isSubclass(paramClassType)) && ((!(paramObjectType instanceof ClassType)) || (((ClassType)paramObjectType).isSubclass(this)));
  }

  public boolean isAccessible(Member paramMember, ObjectType paramObjectType)
  {
    if (paramMember.getStaticFlag())
      paramObjectType = null;
    return isAccessible(paramMember.getDeclaringClass(), paramObjectType, paramMember.getModifiers());
  }

  public final boolean isInterface()
  {
    return (0x200 & getModifiers()) != 0;
  }

  public final boolean isSubclass(ClassType paramClassType)
  {
    if (paramClassType.isInterface())
      return implementsInterface(paramClassType);
    if (((this == toStringType) && (paramClassType == javalangStringType)) || ((this == javalangStringType) && (paramClassType == toStringType)))
      return true;
    for (ClassType localClassType = this; localClassType != null; localClassType = localClassType.getSuperclass())
      if (localClassType == paramClassType)
        return true;
    return false;
  }

  public final boolean isSubclass(String paramString)
  {
    ClassType localClassType = this;
    do
    {
      if (paramString.equals(localClassType.getName()))
        return true;
      localClassType = localClassType.getSuperclass();
    }
    while (localClassType != null);
    return false;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    setName(paramObjectInput.readUTF());
    this.flags = (0x10 | this.flags);
  }

  public Object readResolve()
    throws ObjectStreamException
  {
    String str = getName();
    synchronized (mapNameToType)
    {
      Type localType = (Type)???.get(str);
      if (localType != null)
        return localType;
      ???.put(str, this);
      return this;
    }
  }

  public final void setAttributes(Attribute paramAttribute)
  {
    this.attributes = paramAttribute;
  }

  public void setClassfileVersion(int paramInt)
  {
    this.classfileFormatVersion = paramInt;
  }

  public void setClassfileVersion(int paramInt1, int paramInt2)
  {
    this.classfileFormatVersion = (65536 * (paramInt1 & 0xFFFF) + paramInt2 * 65535);
  }

  public void setClassfileVersionJava5()
  {
    setClassfileVersion(3211264);
  }

  public void setEnclosingMember(Member paramMember)
  {
    this.enclosingMember = paramMember;
  }

  public final void setInterface(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.access_flags = (0x600 | this.access_flags);
      return;
    }
    this.access_flags = (0xFFFFFDFF & this.access_flags);
  }

  public void setInterfaces(ClassType[] paramArrayOfClassType)
  {
    this.interfaces = paramArrayOfClassType;
  }

  public final void setModifiers(int paramInt)
  {
    this.access_flags = paramInt;
  }

  public void setName(String paramString)
  {
    this.this_name = paramString;
    setSignature("L" + paramString.replace('.', '/') + ";");
  }

  public final Field setOuterLink(ClassType paramClassType)
  {
    if ((0x10 & this.flags) != 0)
      throw new Error("setOuterLink called for existing class " + getName());
    Field localField = getDeclaredField("this$0");
    if (localField == null)
    {
      localField = addField("this$0", paramClassType);
      this.flags = (0x20 | this.flags);
      for (Method localMethod = this.methods; localMethod != null; localMethod = localMethod.getNext())
        if ("<init>".equals(localMethod.getName()))
        {
          if (localMethod.code != null)
            throw new Error("setOuterLink called when " + localMethod + " has code");
          Type[] arrayOfType1 = localMethod.arg_types;
          Type[] arrayOfType2 = new Type[1 + arrayOfType1.length];
          System.arraycopy(arrayOfType1, 0, arrayOfType2, 1, arrayOfType1.length);
          arrayOfType2[0] = paramClassType;
          localMethod.arg_types = arrayOfType2;
          localMethod.signature = null;
        }
    }
    if (!paramClassType.equals(localField.getType()))
      throw new Error("inconsistent setOuterLink call for " + getName());
    return localField;
  }

  public void setSourceFile(String paramString)
  {
    if (this.sourceDbgExt != null)
    {
      this.sourceDbgExt.addFile(paramString);
      if (this.sourceDbgExt.fileCount > 1)
        return;
    }
    String str = SourceFileAttr.fixSourceFile(paramString);
    int i = str.lastIndexOf('/');
    if (i >= 0)
      str = str.substring(i + 1);
    SourceFileAttr.setSourceFile(this, str);
  }

  public void setStratum(String paramString)
  {
    if (this.sourceDbgExt == null)
      this.sourceDbgExt = new SourceDebugExtAttr(this);
    this.sourceDbgExt.addStratum(paramString);
  }

  public void setSuper(ClassType paramClassType)
  {
    this.superClass = paramClassType;
  }

  public void setSuper(String paramString)
  {
    if (paramString == null);
    for (ClassType localClassType = Type.pointer_type; ; localClassType = make(paramString))
    {
      setSuper(localClassType);
      return;
    }
  }

  public String toString()
  {
    return "ClassType " + getName();
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeUTF(getName());
  }

  public byte[] writeToArray()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(500);
    try
    {
      writeToStream(localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException localIOException)
    {
      throw new InternalError(localIOException.toString());
    }
  }

  public void writeToFile()
    throws IOException
  {
    writeToFile(this.this_name.replace('.', File.separatorChar) + ".class");
  }

  public void writeToFile(String paramString)
    throws IOException
  {
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramString));
    writeToStream(localBufferedOutputStream);
    localBufferedOutputStream.close();
  }

  public void writeToStream(OutputStream paramOutputStream)
    throws IOException
  {
    DataOutputStream localDataOutputStream = new DataOutputStream(paramOutputStream);
    doFixups();
    localDataOutputStream.writeInt(-889275714);
    localDataOutputStream.writeShort(getClassfileMinorVersion());
    localDataOutputStream.writeShort(getClassfileMajorVersion());
    if (this.constants == null)
    {
      localDataOutputStream.writeShort(1);
      localDataOutputStream.writeShort(this.access_flags);
      localDataOutputStream.writeShort(this.thisClassIndex);
      localDataOutputStream.writeShort(this.superClassIndex);
      if (this.interfaceIndexes != null)
        break label131;
      localDataOutputStream.writeShort(0);
    }
    while (true)
    {
      localDataOutputStream.writeShort(this.fields_count);
      for (Field localField = this.fields; localField != null; localField = localField.next)
        localField.write(localDataOutputStream, this);
      this.constants.write(localDataOutputStream);
      break;
      label131: int i = this.interfaceIndexes.length;
      localDataOutputStream.writeShort(i);
      for (int j = 0; j < i; j++)
        localDataOutputStream.writeShort(this.interfaceIndexes[j]);
    }
    localDataOutputStream.writeShort(this.methods_count);
    for (Method localMethod = this.methods; localMethod != null; localMethod = localMethod.next)
      localMethod.write(localDataOutputStream, this);
    Attribute.writeAll(this, localDataOutputStream);
    this.flags = (0x3 | this.flags);
  }

  static class AbstractMethodFilter
    implements Filter
  {
    public static final AbstractMethodFilter instance = new AbstractMethodFilter();

    public boolean select(Object paramObject)
    {
      return ((Method)paramObject).isAbstract();
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.ClassType
 * JD-Core Version:    0.6.2
 */