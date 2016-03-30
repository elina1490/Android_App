package gnu.kawa.reflect;

import gnu.bytecode.Type;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;

public class ArrayGet extends Procedure2
  implements Externalizable
{
  Type element_type;

  public ArrayGet(Type paramType)
  {
    this.element_type = paramType;
    setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileArrays:validateArrayGet");
    Procedure.compilerKey.set(this, "*gnu.kawa.reflect.CompileArrays:getForArrayGet");
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    Object localObject = Array.get(paramObject1, ((Number)paramObject2).intValue());
    return this.element_type.coerceToObject(localObject);
  }

  public boolean isSideEffectFree()
  {
    return true;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.element_type = ((Type)paramObjectInput.readObject());
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.element_type);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.ArrayGet
 * JD-Core Version:    0.6.2
 */