package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.reflect.OccurrenceType;

public class ConsumerTarget extends Target
{
  Variable consumer;
  boolean isContextTarget;

  public ConsumerTarget(Variable paramVariable)
  {
    this.consumer = paramVariable;
  }

  public static void compileUsingConsumer(Expression paramExpression, Compilation paramCompilation, Target paramTarget)
  {
    if (((paramTarget instanceof ConsumerTarget)) || ((paramTarget instanceof IgnoreTarget)))
    {
      paramExpression.compile(paramCompilation, paramTarget);
      return;
    }
    ClassType localClassType = Compilation.typeValues;
    compileUsingConsumer(paramExpression, paramCompilation, paramTarget, localClassType.getDeclaredMethod("make", 0), localClassType.getDeclaredMethod("canonicalize", 0));
  }

  public static void compileUsingConsumer(Expression paramExpression, Compilation paramCompilation, Target paramTarget, Method paramMethod1, Method paramMethod2)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Scope localScope = localCodeAttr.pushScope();
    Object localObject1;
    if (paramMethod1.getName() == "<init>")
    {
      ClassType localClassType = paramMethod1.getDeclaringClass();
      localObject1 = localClassType;
      localCodeAttr.emitNew(localClassType);
      localCodeAttr.emitDup((Type)localObject1);
      localCodeAttr.emitInvoke(paramMethod1);
      Variable localVariable = localScope.addVariable(localCodeAttr, (Type)localObject1, null);
      ConsumerTarget localConsumerTarget = new ConsumerTarget(localVariable);
      localCodeAttr.emitStore(localVariable);
      paramExpression.compile(paramCompilation, localConsumerTarget);
      localCodeAttr.emitLoad(localVariable);
      if (paramMethod2 != null)
        localCodeAttr.emitInvoke(paramMethod2);
      localCodeAttr.popScope();
      if (paramMethod2 != null)
        break label146;
    }
    label146: for (Object localObject2 = localObject1; ; localObject2 = paramMethod2.getReturnType())
    {
      paramTarget.compileFromStack(paramCompilation, (Type)localObject2);
      return;
      localObject1 = paramMethod1.getReturnType();
      localCodeAttr.emitInvokeStatic(paramMethod1);
      break;
    }
  }

  public static Target makeContextTarget(Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    paramCompilation.loadCallContext();
    localCodeAttr.emitGetField(Compilation.typeCallContext.getDeclaredField("consumer"));
    Variable localVariable = localCodeAttr.getCurrentScope().addVariable(localCodeAttr, Compilation.typeConsumer, "$result");
    localCodeAttr.emitStore(localVariable);
    ConsumerTarget localConsumerTarget = new ConsumerTarget(localVariable);
    localConsumerTarget.isContextTarget = true;
    return localConsumerTarget;
  }

  public void compileFromStack(Compilation paramCompilation, Type paramType)
  {
    compileFromStack(paramCompilation, paramType, -1);
  }

  void compileFromStack(Compilation paramCompilation, Type paramType, int paramInt)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Type localType = paramType.getImplementationType();
    int j;
    int i;
    Object localObject;
    String str;
    if ((localType instanceof PrimType))
    {
      j = localType.getSignature().charAt(0);
      i = 0;
      localObject = null;
      str = null;
      switch (j)
      {
      default:
        if (paramInt < 0)
          break;
      case 86:
      case 66:
      case 73:
      case 83:
      case 74:
      case 70:
      case 68:
      case 67:
      case 90:
      }
    }
    while (true)
    {
      Method localMethod1 = null;
      if (0 == 0)
      {
        localMethod1 = null;
        if (str != null)
        {
          Type[] arrayOfType = { localObject };
          localMethod1 = Compilation.typeConsumer.getDeclaredMethod(str, arrayOfType);
        }
      }
      if (localMethod1 != null)
        localCodeAttr.emitInvokeInterface(localMethod1);
      if (j == 67)
        localCodeAttr.emitPop(1);
      return;
      str = "writeInt";
      localObject = Type.intType;
      i = 0;
      break;
      str = "writeLong";
      localObject = Type.longType;
      i = 1;
      break;
      str = "writeFloat";
      localObject = Type.floatType;
      i = 0;
      break;
      str = "writeDouble";
      localObject = Type.doubleType;
      i = 1;
      break;
      str = "append";
      localObject = Type.charType;
      i = 0;
      break;
      str = "writeBoolean";
      localObject = Type.booleanType;
      i = 0;
      break;
      if ((paramInt == 1) || (OccurrenceType.itemCountIsOne(localType)))
      {
        str = "writeObject";
        localObject = Type.pointer_type;
        i = 0;
        j = 0;
        break;
      }
      Method localMethod2 = Compilation.typeValues.getDeclaredMethod("writeValues", 2);
      localCodeAttr.emitLoad(this.consumer);
      if (paramInt == 0)
        localCodeAttr.emitSwap();
      localCodeAttr.emitInvokeStatic(localMethod2);
      return;
      if (i != 0)
      {
        localCodeAttr.pushScope();
        Variable localVariable = localCodeAttr.addLocal(localType);
        localCodeAttr.emitStore(localVariable);
        localCodeAttr.emitLoad(this.consumer);
        localCodeAttr.emitLoad(localVariable);
        localCodeAttr.popScope();
      }
      else
      {
        localCodeAttr.emitLoad(this.consumer);
        localCodeAttr.emitSwap();
      }
    }
  }

  public boolean compileWrite(Expression paramExpression, Compilation paramCompilation)
  {
    Type localType = paramExpression.getType().getImplementationType();
    if ((((localType instanceof PrimType)) && (!localType.isVoid())) || (OccurrenceType.itemCountIsOne(localType)))
    {
      paramCompilation.getCode().emitLoad(this.consumer);
      paramExpression.compile(paramCompilation, StackTarget.getInstance(localType));
      compileFromStack(paramCompilation, localType, 1);
      return true;
    }
    return false;
  }

  public Variable getConsumerVariable()
  {
    return this.consumer;
  }

  public Type getType()
  {
    return Compilation.scmSequenceType;
  }

  public final boolean isContextTarget()
  {
    return this.isContextTarget;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ConsumerTarget
 * JD-Core Version:    0.6.2
 */