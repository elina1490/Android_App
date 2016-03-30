package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.WrappedException;
import kawa.lang.Syntax;

public class FieldLocation extends ClassMemberLocation
{
  static final int CONSTANT = 4;
  static final int INDIRECT_LOCATION = 2;
  public static final int KIND_FLAGS_SET = 64;
  public static final int PROCEDURE = 16;
  static final int SETUP_DONE = 1;
  public static final int SYNTAX = 32;
  static final int VALUE_SET = 8;
  Declaration decl;
  private int flags;
  Object value;

  public FieldLocation(Object paramObject, ClassType paramClassType, String paramString)
  {
    super(paramObject, paramClassType, paramString);
  }

  public FieldLocation(Object paramObject, String paramString1, String paramString2)
  {
    super(paramObject, ClassType.make(paramString1), paramString2);
  }

  public FieldLocation(Object paramObject, java.lang.reflect.Field paramField)
  {
    super(paramObject, paramField);
    this.type = ((ClassType)Type.make(paramField.getDeclaringClass()));
  }

  private Object getFieldValue()
  {
    super.setup();
    try
    {
      Object localObject = this.rfield.get(this.instance);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      throw WrappedException.wrapIfNeeded(localThrowable);
    }
  }

  public static FieldLocation make(Object paramObject, Declaration paramDeclaration)
  {
    gnu.bytecode.Field localField = paramDeclaration.field;
    FieldLocation localFieldLocation = new FieldLocation(paramObject, localField.getDeclaringClass(), localField.getName());
    localFieldLocation.setDeclaration(paramDeclaration);
    return localFieldLocation;
  }

  public static FieldLocation make(Object paramObject, String paramString1, String paramString2)
  {
    return new FieldLocation(paramObject, ClassType.make(paramString1), paramString2);
  }

  public Object get(Object paramObject)
  {
    try
    {
      setup();
      if ((0x8 & this.flags) != 0)
      {
        localObject = this.value;
        if ((0x4 & this.flags) == 0)
          break label93;
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      return paramObject;
    }
    Object localObject = getFieldValue();
    if ((0x10 & this.type.getDeclaredField(this.mname).getModifiers()) != 0)
    {
      this.flags = (0x8 | this.flags);
      if ((0x2 & this.flags) == 0)
        this.flags = (0x4 | this.flags);
      this.value = localObject;
    }
    label93: if ((0x2 & this.flags) != 0)
    {
      String str = Location.UNBOUND;
      Location localLocation = (Location)localObject;
      localObject = localLocation.get(str);
      if (localObject == str)
        return paramObject;
      if (localLocation.isConstant())
      {
        this.flags = (0x4 | this.flags);
        this.value = localObject;
      }
    }
    return localObject;
  }

  public Declaration getDeclaration()
  {
    while (true)
    {
      try
      {
        if ((0x40 & this.flags) == 0)
          setKindFlags();
        localDeclaration1 = this.decl;
        if (localDeclaration1 != null)
          break label143;
        String str = getMemberName();
        ClassType localClassType = getDeclaringClass();
        gnu.bytecode.Field localField = localClassType.getDeclaredField(str);
        if (localField == null)
        {
          localDeclaration2 = null;
          return localDeclaration2;
        }
        localDeclaration1 = ModuleInfo.find(localClassType).getModuleExp().firstDecl();
        if ((localDeclaration1 == null) || ((localDeclaration1.field != null) && (localDeclaration1.field.getName().equals(str))))
        {
          if (localDeclaration1 != null)
            break label138;
          throw new RuntimeException("no field found for " + this);
        }
      }
      finally
      {
      }
      Declaration localDeclaration1 = localDeclaration1.nextDecl();
      continue;
      label138: this.decl = localDeclaration1;
      label143: Declaration localDeclaration2 = localDeclaration1;
    }
  }

  public Type getFType()
  {
    return this.type.getDeclaredField(this.mname).getType();
  }

  public gnu.bytecode.Field getField()
  {
    return this.type.getDeclaredField(this.mname);
  }

  public boolean isBound()
  {
    if ((0x40 & this.flags) == 0)
      setKindFlags();
    if (((0x4 & this.flags) != 0) || ((0x2 & this.flags) == 0))
      return true;
    Object localObject;
    if ((0x8 & this.flags) != 0)
      localObject = this.value;
    while (true)
    {
      return ((Location)localObject).isBound();
      try
      {
        setup();
        localObject = getFieldValue();
        this.flags = (0x8 | this.flags);
        this.value = localObject;
      }
      catch (Throwable localThrowable)
      {
      }
    }
    return false;
  }

  public boolean isConstant()
  {
    if ((0x40 & this.flags) == 0)
      setKindFlags();
    if ((0x4 & this.flags) != 0)
      return true;
    if (isIndirectLocation())
    {
      Object localObject;
      if ((0x8 & this.flags) != 0)
        localObject = this.value;
      while (true)
      {
        return ((Location)localObject).isConstant();
        try
        {
          setup();
          localObject = getFieldValue();
          this.flags = (0x8 | this.flags);
          this.value = localObject;
        }
        catch (Throwable localThrowable)
        {
          return false;
        }
      }
    }
    return false;
  }

  public boolean isIndirectLocation()
  {
    return (0x2 & this.flags) != 0;
  }

  public boolean isProcedureOrSyntax()
  {
    if ((0x40 & this.flags) == 0)
      setKindFlags();
    return (0x30 & this.flags) != 0;
  }

  public void set(Object paramObject)
  {
    setup();
    if ((0x2 & this.flags) == 0)
      try
      {
        this.rfield.set(this.instance, paramObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        throw WrappedException.wrapIfNeeded(localThrowable);
      }
    Object localObject;
    if ((0x8 & this.flags) != 0)
      localObject = this.value;
    while (true)
    {
      ((Location)localObject).set(paramObject);
      return;
      this.flags = (0x8 | this.flags);
      localObject = getFieldValue();
      this.value = localObject;
    }
  }

  public void setDeclaration(Declaration paramDeclaration)
  {
    this.decl = paramDeclaration;
  }

  void setKindFlags()
  {
    String str = getMemberName();
    gnu.bytecode.Field localField = getDeclaringClass().getDeclaredField(str);
    int i = localField.getModifiers();
    Type localType = localField.getType();
    if (localType.isSubtype(Compilation.typeLocation))
      this.flags = (0x2 | this.flags);
    if ((i & 0x10) != 0)
    {
      if ((0x2 & this.flags) != 0)
        break label138;
      this.flags = (0x4 | this.flags);
      if (localType.isSubtype(Compilation.typeProcedure))
        this.flags = (0x10 | this.flags);
      if (((localType instanceof ClassType)) && (((ClassType)localType).isSubclass("kawa.lang.Syntax")))
        this.flags = (0x20 | this.flags);
    }
    while (true)
    {
      this.flags = (0x40 | this.flags);
      return;
      label138: Location localLocation = (Location)getFieldValue();
      if ((localLocation instanceof FieldLocation))
      {
        FieldLocation localFieldLocation = (FieldLocation)localLocation;
        if ((0x40 & localFieldLocation.flags) == 0)
          localFieldLocation.setKindFlags();
        this.flags |= 0x34 & localFieldLocation.flags;
        if ((0x4 & localFieldLocation.flags) != 0)
        {
          if ((0x8 & localFieldLocation.flags) != 0)
          {
            this.value = localFieldLocation.value;
            this.flags = (0x8 | this.flags);
          }
        }
        else
        {
          this.value = localFieldLocation;
          this.flags = (0x8 | this.flags);
        }
      }
      else if (localLocation.isConstant())
      {
        Object localObject = localLocation.get(null);
        if ((localObject instanceof Procedure))
          this.flags = (0x10 | this.flags);
        if ((localObject instanceof Syntax))
          this.flags = (0x20 | this.flags);
        this.flags = (0xC | this.flags);
        this.value = localObject;
      }
    }
  }

  public void setProcedure()
  {
    this.flags = (0x54 | this.flags);
  }

  public void setRestore(Object paramObject)
  {
    if ((0x2 & this.flags) == 0)
    {
      super.setRestore(paramObject);
      return;
    }
    ((Location)this.value).setRestore(paramObject);
  }

  public void setSyntax()
  {
    this.flags = (0x64 | this.flags);
  }

  public Object setWithSave(Object paramObject)
  {
    if ((0x40 & this.flags) == 0)
      setKindFlags();
    if ((0x2 & this.flags) == 0)
      return super.setWithSave(paramObject);
    Object localObject;
    if ((0x8 & this.flags) != 0)
      localObject = this.value;
    while (true)
    {
      return ((Location)localObject).setWithSave(paramObject);
      this.flags = (0x8 | this.flags);
      localObject = getFieldValue();
      this.value = localObject;
    }
  }

  void setup()
  {
    try
    {
      if ((0x1 & this.flags) != 0)
        return;
      super.setup();
      if ((0x40 & this.flags) == 0)
        setKindFlags();
      this.flags = (0x1 | this.flags);
      return;
    }
    finally
    {
    }
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FieldLocation[");
    if (this.instance != null)
    {
      localStringBuffer.append(this.instance);
      localStringBuffer.append(' ');
    }
    if (this.type == null);
    for (String str = "(null)"; ; str = this.type.getName())
    {
      localStringBuffer.append(str);
      localStringBuffer.append('.');
      localStringBuffer.append(this.mname);
      localStringBuffer.append(']');
      return localStringBuffer.toString();
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.FieldLocation
 * JD-Core Version:    0.6.2
 */