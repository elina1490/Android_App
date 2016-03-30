package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.expr.Compilation;
import gnu.lists.TreePosition;
import gnu.math.IntNum;

public final class Focus extends TreePosition
{
  public static final ClassType TYPE = ClassType.make("gnu.kawa.xml.Focus");
  static ThreadLocal current = new ThreadLocal();
  static final Method getCurrentFocusMethod = TYPE.getDeclaredMethod("getCurrent", 0);
  IntNum contextPosition;
  public long position;

  public static void compileGetCurrent(Compilation paramCompilation)
  {
    paramCompilation.getCode().emitInvoke(getCurrentFocusMethod);
  }

  public static Focus getCurrent()
  {
    Object localObject = current.get();
    if (localObject == null)
    {
      localObject = new Focus();
      current.set(localObject);
    }
    return (Focus)localObject;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.Focus
 * JD-Core Version:    0.6.2
 */