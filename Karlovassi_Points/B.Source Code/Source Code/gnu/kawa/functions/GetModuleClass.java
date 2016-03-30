package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BindingInitializer;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.Target;
import gnu.mapping.Namespace;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.text.Path;
import gnu.text.URLPath;

public class GetModuleClass extends ProcedureN
  implements Inlineable
{
  private static Symbol CLASS_RESOURCE_NAME = Namespace.getDefaultSymbol("$class_resource_URL$");
  public static final GetModuleClass getModuleClass = new GetModuleClass();
  public static final GetModuleClass getModuleUri = new GetModuleClass();
  public static final GetModuleClass getModuleUriDummy = new GetModuleClass();
  static final Method maker;
  static final ClassType typeURLPath = ClassType.make("gnu.text.URLPath");

  static
  {
    maker = typeURLPath.getDeclaredMethod("classResourcePath", 1);
  }

  public static Expression getModuleClassURI(Compilation paramCompilation)
  {
    Declaration localDeclaration = paramCompilation.mainLambda.lookup(CLASS_RESOURCE_NAME);
    Object localObject2;
    if (localDeclaration == null)
    {
      localDeclaration = new Declaration(CLASS_RESOURCE_NAME, typeURLPath);
      localDeclaration.setFlag(536889344L);
      if (!paramCompilation.immediate)
        break label120;
      localObject2 = paramCompilation.minfo.getSourceAbsPath();
      if (localObject2 == null)
        localObject2 = Path.currentPath();
      if (!(localObject2 instanceof URLPath))
        localObject2 = URLPath.valueOf(((Path)localObject2).toURL());
    }
    ReferenceExp localReferenceExp;
    label120: ApplyExp localApplyExp;
    for (Object localObject1 = QuoteExp.getInstance(localObject2); ; localObject1 = new ApplyExp(maker, new Expression[] { localApplyExp }))
    {
      localDeclaration.setValue((Expression)localObject1);
      paramCompilation.mainLambda.add(null, localDeclaration);
      localReferenceExp = new ReferenceExp(localDeclaration);
      if (!paramCompilation.immediate)
        break;
      return localReferenceExp;
      localApplyExp = new ApplyExp(getModuleClass, Expression.noExpressions);
    }
    return new ApplyExp(getModuleUriDummy, new Expression[] { localReferenceExp });
  }

  public Object applyN(Object[] paramArrayOfObject)
  {
    throw new Error("get-module-class must be inlined");
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    if (this == getModuleUriDummy)
    {
      ReferenceExp localReferenceExp = (ReferenceExp)paramApplyExp.getArgs()[0];
      localReferenceExp.compile(paramCompilation, paramTarget);
      Declaration localDeclaration = localReferenceExp.getBinding();
      Expression localExpression = localDeclaration.getValue();
      if (localExpression != null)
      {
        BindingInitializer.create(localDeclaration, localExpression, paramCompilation);
        localDeclaration.setValue(null);
      }
      return;
    }
    paramCompilation.loadClassRef(paramCompilation.mainClass);
    if (this == getModuleUri)
      paramCompilation.getCode().emitInvoke(maker);
    paramTarget.compileFromStack(paramCompilation, paramApplyExp.getType());
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    if (this == getModuleClass)
      return Type.javalangClassType;
    return typeURLPath;
  }

  public int numArgs()
  {
    if (this == getModuleUriDummy)
      return 4097;
    return 0;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.GetModuleClass
 * JD-Core Version:    0.6.2
 */