package gnu.commonlisp.lang;

import gnu.bytecode.Type;
import gnu.expr.Language;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.functions.IsEq;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.Not;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.InstanceOf;
import gnu.lists.AbstractFormat;
import gnu.mapping.Environment;
import gnu.mapping.LocationEnumeration;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.text.Char;
import kawa.lang.Lambda;
import kawa.standard.Scheme;
import kawa.standard.begin;

public class CommonLisp extends Lisp2
{
  static boolean charIsInt = false;
  public static final Environment clispEnvironment = Environment.make("clisp-environment");
  static final AbstractFormat displayFormat;
  public static final CommonLisp instance = new CommonLisp();
  public static final NumberCompare numEqu;
  public static final NumberCompare numGEq;
  public static final NumberCompare numGrt;
  public static final NumberCompare numLEq;
  public static final NumberCompare numLss;
  static final AbstractFormat writeFormat;
  LangPrimType booleanType;

  static
  {
    instance.define("t", TRUE);
    instance.define("nil", FALSE);
    numEqu = NumberCompare.make(instance, "=", 8);
    numGrt = NumberCompare.make(instance, ">", 16);
    numGEq = NumberCompare.make(instance, ">=", 24);
    numLss = NumberCompare.make(instance, "<", 4);
    numLEq = NumberCompare.make(instance, "<=", 12);
    Environment localEnvironment = Environment.setSaveCurrent(clispEnvironment);
    try
    {
      instance.initLisp();
      Environment.restoreCurrent(localEnvironment);
      writeFormat = new DisplayFormat(true, 'C');
      displayFormat = new DisplayFormat(false, 'C');
      return;
    }
    finally
    {
      Environment.restoreCurrent(localEnvironment);
    }
  }

  public CommonLisp()
  {
    this.environ = clispEnvironment;
  }

  public static char asChar(Object paramObject)
  {
    if ((paramObject instanceof Char))
      return ((Char)paramObject).charValue();
    if ((paramObject instanceof Numeric));
    for (int i = ((Numeric)paramObject).intValue(); (i < 0) || (i > 65535); i = -1)
      throw new ClassCastException("not a character value");
    return (char)i;
  }

  public static Numeric asNumber(Object paramObject)
  {
    if ((paramObject instanceof Char))
      return IntNum.make(((Char)paramObject).intValue());
    return (Numeric)paramObject;
  }

  public static Object getCharacter(int paramInt)
  {
    if (charIsInt)
      return IntNum.make(paramInt);
    return Char.make((char)paramInt);
  }

  public static CommonLisp getInstance()
  {
    return instance;
  }

  public static void registerEnvironment()
  {
    Language.setDefaults(instance);
  }

  public AbstractFormat getFormat(boolean paramBoolean)
  {
    if (paramBoolean)
      return writeFormat;
    return displayFormat;
  }

  public String getName()
  {
    return "CommonLisp";
  }

  public Type getTypeFor(Class paramClass)
  {
    if (paramClass.isPrimitive())
    {
      String str = paramClass.getName();
      if (str.equals("boolean"))
      {
        if (this.booleanType == null)
          this.booleanType = new LangPrimType(Type.booleanType, this);
        return this.booleanType;
      }
      return Scheme.getNamedType(str);
    }
    return Type.make(paramClass);
  }

  public Type getTypeFor(String paramString)
  {
    if (paramString == "t")
      paramString = "java.lang.Object";
    return Scheme.string2Type(paramString);
  }

  void initLisp()
  {
    LocationEnumeration localLocationEnumeration = Scheme.builtin().enumerateAllLocations();
    while (localLocationEnumeration.hasMoreElements())
      importLocation(localLocationEnumeration.nextLocation());
    try
    {
      loadClass("kawa.lib.prim_syntax");
      loadClass("kawa.lib.std_syntax");
      loadClass("kawa.lib.lists");
      loadClass("kawa.lib.strings");
      loadClass("gnu.commonlisp.lisp.PrimOps");
      label55: Lambda localLambda = new Lambda();
      localLambda.setKeywords(asSymbol("&optional"), asSymbol("&rest"), asSymbol("&key"));
      localLambda.defaultDefault = nilExpr;
      defun("lambda", localLambda);
      defun("defun", new defun(localLambda));
      defun("defvar", new defvar(false));
      defun("defconst", new defvar(true));
      defun("defsubst", new defun(localLambda));
      defun("function", new function(localLambda));
      defun("setq", new setq());
      defun("prog1", new prog1("prog1", 1));
      defun("prog2", prog1.prog2);
      defun("progn", new begin());
      defun("unwind-protect", new UnwindProtect());
      Not localNot = new Not(this);
      defun("not", localNot);
      defun("null", localNot);
      defun("eq", new IsEq(this, "eq"));
      defun("equal", new IsEqual(this, "equal"));
      defun("typep", new InstanceOf(this));
      defun("princ", displayFormat);
      defun("prin1", writeFormat);
      defProcStFld("=", "gnu.commonlisp.lang.CommonLisp", "numEqu");
      defProcStFld("<", "gnu.commonlisp.lang.CommonLisp", "numLss");
      defProcStFld(">", "gnu.commonlisp.lang.CommonLisp", "numGrt");
      defProcStFld("<=", "gnu.commonlisp.lang.CommonLisp", "numLEq");
      defProcStFld(">=", "gnu.commonlisp.lang.CommonLisp", "numGEq");
      defProcStFld("functionp", "gnu.commonlisp.lisp.PrimOps");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label55;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.commonlisp.lang.CommonLisp
 * JD-Core Version:    0.6.2
 */