package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.prim_syntax;
import kawa.lib.std_syntax;
import kawa.standard.syntax_case;

public class srfi2 extends ModuleBody
{
  public static final srfi2 $instance;
  static final SimpleSymbol Lit0;
  static final SyntaxPattern Lit1;
  static final SyntaxTemplate Lit10;
  static final SyntaxPattern Lit11;
  static final SyntaxTemplate Lit12;
  static final SyntaxPattern Lit13;
  static final SyntaxTemplate Lit14;
  static final SyntaxPattern Lit15;
  static final SyntaxTemplate Lit16;
  static final SyntaxTemplate Lit17;
  static final SyntaxTemplate Lit18;
  static final SyntaxPattern Lit19;
  static final SyntaxTemplate Lit2;
  static final SyntaxTemplate Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22 = (SimpleSymbol)new SimpleSymbol("let").readResolve();
  static final SyntaxPattern Lit3;
  static final SyntaxTemplate Lit4;
  static final SyntaxPattern Lit5;
  static final SyntaxTemplate Lit6;
  static final SyntaxPattern Lit7;
  static final SyntaxTemplate Lit8;
  static final SyntaxTemplate Lit9;
  public static final Macro and$Mnlet$St;

  static
  {
    Lit21 = (SimpleSymbol)new SimpleSymbol("and").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Boolean.TRUE;
    Lit20 = new SyntaxTemplate("\001", "\030\004", arrayOfObject1, 0);
    Lit19 = new SyntaxPattern("\f\007\f\b\b", new Object[0], 1);
    Lit18 = new SyntaxTemplate("", "\013", new Object[0], 0);
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = Lit21;
    Lit17 = new SyntaxTemplate("", "\021\030\004\t\013\b\t\003\b\022", arrayOfObject2, 0);
    Lit16 = new SyntaxTemplate("", "\013", new Object[0], 0);
    Lit15 = new SyntaxPattern("\f\007\034\f\017\023\b", new Object[0], 3);
    Object[] arrayOfObject3 = new Object[1];
    arrayOfObject3[0] = Lit21;
    Lit14 = new SyntaxTemplate("", "\021\030\004\t\013\b\t\003\b\022", arrayOfObject3, 0);
    Lit13 = new SyntaxPattern("\f\007,\034\f\017\b\023\b", new Object[0], 3);
    Object[] arrayOfObject4 = new Object[2];
    arrayOfObject4[0] = Lit22;
    arrayOfObject4[1] = Lit21;
    Lit12 = new SyntaxTemplate("", "\021\030\004)\b\t\013\b\023\b\021\030\f\t\013\b\t\003\b\032", arrayOfObject4, 0);
    Lit11 = new SyntaxPattern("\f\007<,\f\017\f\027\b\033\b", new Object[0], 4);
    Lit10 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    Lit9 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    Lit8 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    Lit7 = new SyntaxPattern("\f\007\034\f\017\b\b", new Object[0], 2);
    Lit6 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    Lit5 = new SyntaxPattern("\f\007,\034\f\017\b\b\b", new Object[0], 2);
    Object[] arrayOfObject5 = new Object[1];
    arrayOfObject5[0] = Lit22;
    Lit4 = new SyntaxTemplate("\001\001\001", "\021\030\004)\b\t\013\b\023\b\013", arrayOfObject5, 0);
    Lit3 = new SyntaxPattern("\f\007<,\f\017\f\027\b\b\b", new Object[0], 3);
    Object[] arrayOfObject6 = new Object[1];
    arrayOfObject6[0] = ((SimpleSymbol)new SimpleSymbol("begin").readResolve());
    Lit2 = new SyntaxTemplate("", "\t\003\b\021\r\013\b\b\021\030\004\t\023\032", arrayOfObject6, 1);
    Lit1 = new SyntaxPattern("\f\007,\r\017\b\b\b\f\027\033", new Object[0], 4);
    Lit0 = (SimpleSymbol)new SimpleSymbol("and-let*").readResolve();
    $instance = new srfi2();
    and$Mnlet$St = Macro.make(Lit0, new ModuleMethod($instance, 1, null, 4097), $instance);
    $instance.run();
  }

  public srfi2()
  {
    ModuleInfo.register(this);
  }

  static Object lambda1(Object paramObject)
  {
    Object[] arrayOfObject1 = SyntaxPattern.allocVars(4, null);
    if (Lit1.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope12 = TemplateScope.make();
      return Lit2.execute(arrayOfObject1, localTemplateScope12);
    }
    if (Lit3.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope11 = TemplateScope.make();
      return Lit4.execute(arrayOfObject1, localTemplateScope11);
    }
    if (Lit5.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope10 = TemplateScope.make();
      return Lit6.execute(arrayOfObject1, localTemplateScope10);
    }
    if (Lit7.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope7 = TemplateScope.make();
      if (std_syntax.isIdentifier(Lit8.execute(arrayOfObject1, localTemplateScope7)))
      {
        TemplateScope localTemplateScope9 = TemplateScope.make();
        return Lit9.execute(arrayOfObject1, localTemplateScope9);
      }
      TemplateScope localTemplateScope8 = TemplateScope.make();
      Object localObject2 = Lit10.execute(arrayOfObject1, localTemplateScope8);
      if (("expected a variable name" instanceof Object[]));
      for (Object[] arrayOfObject3 = (Object[])"expected a variable name"; ; arrayOfObject3 = new Object[] { "expected a variable name" })
        return prim_syntax.syntaxError(localObject2, arrayOfObject3);
    }
    if (Lit11.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope6 = TemplateScope.make();
      return Lit12.execute(arrayOfObject1, localTemplateScope6);
    }
    if (Lit13.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope5 = TemplateScope.make();
      return Lit14.execute(arrayOfObject1, localTemplateScope5);
    }
    if (Lit15.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      if (std_syntax.isIdentifier(Lit16.execute(arrayOfObject1, localTemplateScope2)))
      {
        TemplateScope localTemplateScope4 = TemplateScope.make();
        return Lit17.execute(arrayOfObject1, localTemplateScope4);
      }
      TemplateScope localTemplateScope3 = TemplateScope.make();
      Object localObject1 = Lit18.execute(arrayOfObject1, localTemplateScope3);
      if (("expected a variable name" instanceof Object[]));
      for (Object[] arrayOfObject2 = (Object[])"expected a variable name"; ; arrayOfObject2 = new Object[] { "expected a variable name" })
        return prim_syntax.syntaxError(localObject1, arrayOfObject2);
    }
    if (Lit19.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      return Lit20.execute(arrayOfObject1, localTemplateScope1);
    }
    return syntax_case.error("syntax-case", paramObject);
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    if (paramModuleMethod.selector == 1)
      return lambda1(paramObject);
    return super.apply1(paramModuleMethod, paramObject);
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 1)
    {
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    return super.match1(paramModuleMethod, paramObject, paramCallContext);
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.srfi2
 * JD-Core Version:    0.6.2
 */