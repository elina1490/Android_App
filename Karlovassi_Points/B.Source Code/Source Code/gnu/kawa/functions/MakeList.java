package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.ProcedureN;

public class MakeList extends ProcedureN
  implements Inlineable
{
  public static final MakeList list = new MakeList();

  static
  {
    list.setName("list");
  }

  public static void compile(Expression[] paramArrayOfExpression, int paramInt, Compilation paramCompilation)
  {
    int i = paramArrayOfExpression.length - paramInt;
    CodeAttr localCodeAttr = paramCompilation.getCode();
    if (i == 0)
    {
      new QuoteExp(LList.Empty).compile(paramCompilation, Target.pushObject);
      return;
    }
    if (i <= 4)
    {
      for (int m = 0; m < i; m++)
        paramArrayOfExpression[(paramInt + m)].compile(paramCompilation, Target.pushObject);
      localCodeAttr.emitInvokeStatic(Compilation.scmListType.getDeclaredMethod("list" + i, null));
      return;
    }
    paramArrayOfExpression[paramInt].compile(paramCompilation, Target.pushObject);
    localCodeAttr.emitInvokeStatic(Compilation.scmListType.getDeclaredMethod("list1", null));
    localCodeAttr.emitDup(1);
    int j = paramInt + 1;
    int k = i - 1;
    while (k >= 4)
    {
      paramArrayOfExpression[j].compile(paramCompilation, Target.pushObject);
      paramArrayOfExpression[(j + 1)].compile(paramCompilation, Target.pushObject);
      paramArrayOfExpression[(j + 2)].compile(paramCompilation, Target.pushObject);
      paramArrayOfExpression[(j + 3)].compile(paramCompilation, Target.pushObject);
      k -= 4;
      j += 4;
      localCodeAttr.emitInvokeStatic(Compilation.scmListType.getDeclaredMethod("chain4", null));
    }
    while (k > 0)
    {
      paramArrayOfExpression[j].compile(paramCompilation, Target.pushObject);
      k--;
      j++;
      localCodeAttr.emitInvokeStatic(Compilation.scmListType.getDeclaredMethod("chain1", null));
    }
    localCodeAttr.emitPop(1);
  }

  public static Object list$V(Object[] paramArrayOfObject)
  {
    LList localLList = LList.Empty;
    int i = paramArrayOfObject.length;
    for (Object localObject = localLList; ; localObject = new Pair(paramArrayOfObject[i], localObject))
    {
      i--;
      if (i < 0)
        break;
    }
    return localObject;
  }

  public Object applyN(Object[] paramArrayOfObject)
  {
    return list$V(paramArrayOfObject);
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    compile(paramApplyExp.getArgs(), 0, paramCompilation);
    paramTarget.compileFromStack(paramCompilation, paramApplyExp.getType());
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    if (paramArrayOfExpression.length > 0)
      return Compilation.typePair;
    return LangObjType.listType;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.MakeList
 * JD-Core Version:    0.6.2
 */