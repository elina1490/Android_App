package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Filter;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;

class MethodFilter
  implements Filter
{
  ClassType caller;
  int modifiers;
  int modmask;
  String name;
  int nlen;
  ObjectType receiver;

  public MethodFilter(String paramString, int paramInt1, int paramInt2, ClassType paramClassType, ObjectType paramObjectType)
  {
    this.name = paramString;
    this.nlen = paramString.length();
    this.modifiers = paramInt1;
    this.modmask = paramInt2;
    this.caller = paramClassType;
    this.receiver = paramObjectType;
  }

  public boolean select(Object paramObject)
  {
    Method localMethod = (Method)paramObject;
    String str = localMethod.getName();
    int i = localMethod.getModifiers();
    if (((i & this.modmask) != this.modifiers) || ((i & 0x1000) != 0) || (!str.startsWith(this.name)))
      return false;
    int j = str.length();
    if (j != this.nlen)
      if ((j == 2 + this.nlen) && (str.charAt(this.nlen) == '$'))
      {
        int k = str.charAt(1 + this.nlen);
        if ((k == 86) || (k == 88));
      }
      else if ((j != 4 + this.nlen) || (!str.endsWith("$V$X")))
      {
        return false;
      }
    if ((this.receiver instanceof ClassType));
    for (ClassType localClassType = (ClassType)this.receiver; (this.caller == null) || (this.caller.isAccessible(localClassType, this.receiver, localMethod.getModifiers())); localClassType = localMethod.getDeclaringClass())
      return true;
    return false;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.MethodFilter
 * JD-Core Version:    0.6.2
 */