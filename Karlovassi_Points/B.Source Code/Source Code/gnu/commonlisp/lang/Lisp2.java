package gnu.commonlisp.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.QuoteExp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.reflect.FieldLocation;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.NamedLocation;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import java.lang.reflect.Field;
import kawa.lang.Syntax;

public abstract class Lisp2 extends LispLanguage
{
  public static final LList FALSE = LList.Empty;
  public static final Symbol TRUE = Namespace.getDefault().getSymbol("t");
  public static final Expression nilExpr = new QuoteExp(FALSE);

  public static Object asSymbol(String paramString)
  {
    if (paramString == "nil")
      return FALSE;
    return Environment.getCurrent().getSymbol(paramString);
  }

  private void defun(Procedure paramProcedure)
  {
    defun(paramProcedure.getName(), paramProcedure);
  }

  public static Object getString(Symbol paramSymbol)
  {
    return getString(paramSymbol.getName());
  }

  public static Object getString(String paramString)
  {
    return new FString(paramString);
  }

  public Object booleanObject(boolean paramBoolean)
  {
    if (paramBoolean)
      return TRUE;
    return FALSE;
  }

  public ReadTable createReadTable()
  {
    Lisp2ReadTable localLisp2ReadTable = new Lisp2ReadTable();
    localLisp2ReadTable.initialize();
    localLisp2ReadTable.setInitialColonIsKeyword(true);
    return localLisp2ReadTable;
  }

  protected void defun(Symbol paramSymbol, Object paramObject)
  {
    this.environ.define(paramSymbol, EnvironmentKey.FUNCTION, paramObject);
    if ((paramObject instanceof Procedure))
    {
      Procedure localProcedure = (Procedure)paramObject;
      if (localProcedure.getSymbol() == null)
        localProcedure.setSymbol(paramSymbol);
    }
  }

  protected void defun(String paramString, Object paramObject)
  {
    this.environ.define(getSymbol(paramString), EnvironmentKey.FUNCTION, paramObject);
    if ((paramObject instanceof Named))
    {
      Named localNamed = (Named)paramObject;
      if (localNamed.getName() == null)
        localNamed.setName(paramString);
    }
  }

  public void emitPushBoolean(boolean paramBoolean, CodeAttr paramCodeAttr)
  {
    if (paramBoolean)
    {
      paramCodeAttr.emitGetStatic(ClassType.make("gnu.commonlisp.lang.Lisp2").getDeclaredField("TRUE"));
      return;
    }
    paramCodeAttr.emitGetStatic(Compilation.scmListType.getDeclaredField("Empty"));
  }

  protected Symbol fromLangSymbol(Object paramObject)
  {
    if (paramObject == LList.Empty)
      return this.environ.getSymbol("nil");
    return super.fromLangSymbol(paramObject);
  }

  public Object getEnvPropertyFor(Field paramField, Object paramObject)
  {
    if ((Compilation.typeProcedure.getReflectClass().isAssignableFrom(paramField.getType())) || ((paramObject instanceof Syntax)))
      return EnvironmentKey.FUNCTION;
    return null;
  }

  public int getNamespaceOf(Declaration paramDeclaration)
  {
    if (paramDeclaration.isAlias())
      return 3;
    if (paramDeclaration.isProcedureDecl())
      return 2;
    return 1;
  }

  public boolean hasSeparateFunctionNamespace()
  {
    return true;
  }

  protected void importLocation(Location paramLocation)
  {
    Symbol localSymbol = ((NamedLocation)paramLocation).getKeySymbol();
    if (this.environ.isBound(localSymbol, EnvironmentKey.FUNCTION));
    Object localObject;
    do
    {
      return;
      Location localLocation = paramLocation.getBase();
      if (((localLocation instanceof FieldLocation)) && (((FieldLocation)localLocation).isProcedureOrSyntax()))
      {
        this.environ.addLocation(localSymbol, EnvironmentKey.FUNCTION, localLocation);
        return;
      }
      localObject = localLocation.get(null);
    }
    while (localObject == null);
    if (((localObject instanceof Procedure)) || ((localObject instanceof Syntax)))
    {
      defun(localSymbol, localObject);
      return;
    }
    if ((localObject instanceof LangObjType))
    {
      defun(localSymbol, ((LangObjType)localObject).getConstructor());
      return;
    }
    define(localSymbol.getName(), localObject);
  }

  public boolean isTrue(Object paramObject)
  {
    return paramObject != FALSE;
  }

  public Object noValue()
  {
    return FALSE;
  }

  public boolean selfEvaluatingSymbol(Object paramObject)
  {
    return ((paramObject instanceof Keyword)) || (paramObject == TRUE) || (paramObject == FALSE);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.commonlisp.lang.Lisp2
 * JD-Core Version:    0.6.2
 */