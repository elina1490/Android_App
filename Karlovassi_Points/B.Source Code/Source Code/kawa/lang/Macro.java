package kawa.lang;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.lists.Consumer;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.text.Printable;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Macro extends Syntax
  implements Printable, Externalizable
{
  private ScopeExp capturedScope;
  public Object expander;
  private boolean hygienic = true;
  Object instance;

  public Macro()
  {
  }

  public Macro(Object paramObject)
  {
    super(paramObject);
  }

  public Macro(Object paramObject, Procedure paramProcedure)
  {
    super(paramObject);
    this.expander = new QuoteExp(paramProcedure);
  }

  public Macro(Macro paramMacro)
  {
    this.name = paramMacro.name;
    this.expander = paramMacro.expander;
    this.hygienic = paramMacro.hygienic;
  }

  public static Macro make(Declaration paramDeclaration)
  {
    Macro localMacro = new Macro(paramDeclaration.getSymbol());
    paramDeclaration.setSyntax();
    localMacro.capturedScope = paramDeclaration.context;
    return localMacro;
  }

  public static Macro make(Object paramObject, Procedure paramProcedure)
  {
    return new Macro(paramObject, paramProcedure);
  }

  public static Macro make(Object paramObject1, Procedure paramProcedure, Object paramObject2)
  {
    Macro localMacro = new Macro(paramObject1, paramProcedure);
    localMacro.instance = paramObject2;
    return localMacro;
  }

  public static Macro makeNonHygienic(Object paramObject, Procedure paramProcedure)
  {
    Macro localMacro = new Macro(paramObject, paramProcedure);
    localMacro.hygienic = false;
    return localMacro;
  }

  public static Macro makeNonHygienic(Object paramObject1, Procedure paramProcedure, Object paramObject2)
  {
    Macro localMacro = new Macro(paramObject1, paramProcedure);
    localMacro.hygienic = false;
    localMacro.instance = paramObject2;
    return localMacro;
  }

  // ERROR //
  public Object expand(Object paramObject, Translator paramTranslator)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	kawa/lang/Macro:expander	Ljava/lang/Object;
    //   4: astore 4
    //   6: aload 4
    //   8: instanceof 64
    //   11: ifeq +66 -> 77
    //   14: aload 4
    //   16: instanceof 66
    //   19: ifne +58 -> 77
    //   22: aload 4
    //   24: checkcast 64	gnu/mapping/Procedure
    //   27: astore 5
    //   29: aload_0
    //   30: getfield 21	kawa/lang/Macro:hygienic	Z
    //   33: ifne +274 -> 307
    //   36: aload_1
    //   37: aload_2
    //   38: invokestatic 71	kawa/lang/Quote:quote	(Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;
    //   41: astore_1
    //   42: aload_1
    //   43: invokestatic 77	kawa/lang/Translator:listLength	(Ljava/lang/Object;)I
    //   46: istore 9
    //   48: iload 9
    //   50: ifgt +134 -> 184
    //   53: aload_2
    //   54: new 79	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   61: ldc 82
    //   63: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_0
    //   67: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokevirtual 97	kawa/lang/Translator:syntaxError	(Ljava/lang/String;)Lgnu/expr/Expression;
    //   76: areturn
    //   77: aload 4
    //   79: instanceof 66
    //   82: ifne +34 -> 116
    //   85: aload_2
    //   86: getfield 101	kawa/lang/Translator:currentMacroDefinition	Lkawa/lang/Macro;
    //   89: astore 14
    //   91: aload_2
    //   92: aload_0
    //   93: putfield 101	kawa/lang/Translator:currentMacroDefinition	Lkawa/lang/Macro;
    //   96: aload_2
    //   97: aload 4
    //   99: invokevirtual 105	kawa/lang/Translator:rewrite	(Ljava/lang/Object;)Lgnu/expr/Expression;
    //   102: astore 4
    //   104: aload_0
    //   105: aload 4
    //   107: putfield 30	kawa/lang/Macro:expander	Ljava/lang/Object;
    //   110: aload_2
    //   111: aload 14
    //   113: putfield 101	kawa/lang/Translator:currentMacroDefinition	Lkawa/lang/Macro;
    //   116: aload 4
    //   118: checkcast 66	gnu/expr/Expression
    //   121: aload_2
    //   122: invokevirtual 109	kawa/lang/Translator:getGlobalEnvironment	()Lgnu/mapping/Environment;
    //   125: invokevirtual 113	gnu/expr/Expression:eval	(Lgnu/mapping/Environment;)Ljava/lang/Object;
    //   128: checkcast 64	gnu/mapping/Procedure
    //   131: astore 5
    //   133: goto -104 -> 29
    //   136: astore 15
    //   138: aload_2
    //   139: aload 14
    //   141: putfield 101	kawa/lang/Translator:currentMacroDefinition	Lkawa/lang/Macro;
    //   144: aload 15
    //   146: athrow
    //   147: astore_3
    //   148: aload_2
    //   149: new 79	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   156: ldc 115
    //   158: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: invokevirtual 118	kawa/lang/Macro:getName	()Ljava/lang/String;
    //   165: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc 120
    //   170: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_3
    //   174: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokevirtual 97	kawa/lang/Translator:syntaxError	(Ljava/lang/String;)Lgnu/expr/Expression;
    //   183: areturn
    //   184: iload 9
    //   186: iconst_1
    //   187: isub
    //   188: istore 10
    //   190: iload 10
    //   192: anewarray 122	java/lang/Object
    //   195: astore 11
    //   197: iconst_0
    //   198: istore 12
    //   200: iload 12
    //   202: iload 9
    //   204: if_icmpge +38 -> 242
    //   207: aload_1
    //   208: checkcast 124	gnu/lists/Pair
    //   211: astore 13
    //   213: iload 12
    //   215: ifle +15 -> 230
    //   218: aload 11
    //   220: iload 12
    //   222: iconst_1
    //   223: isub
    //   224: aload 13
    //   226: invokevirtual 127	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   229: aastore
    //   230: aload 13
    //   232: invokevirtual 130	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   235: astore_1
    //   236: iinc 12 1
    //   239: goto -39 -> 200
    //   242: aload 5
    //   244: aload 11
    //   246: invokevirtual 134	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
    //   249: astore 7
    //   251: aload_1
    //   252: instanceof 136
    //   255: ifeq +67 -> 322
    //   258: aload 7
    //   260: instanceof 124
    //   263: ifeq +59 -> 322
    //   266: aload 7
    //   268: instanceof 136
    //   271: ifne +51 -> 322
    //   274: aload 7
    //   276: checkcast 124	gnu/lists/Pair
    //   279: astore 8
    //   281: new 136	gnu/lists/PairWithPosition
    //   284: dup
    //   285: aload_1
    //   286: checkcast 136	gnu/lists/PairWithPosition
    //   289: aload 8
    //   291: invokevirtual 127	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   294: aload 8
    //   296: invokevirtual 130	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   299: invokespecial 139	gnu/lists/PairWithPosition:<init>	(Lgnu/text/SourceLocator;Ljava/lang/Object;Ljava/lang/Object;)V
    //   302: astore 7
    //   304: goto +18 -> 322
    //   307: aload 5
    //   309: aload_1
    //   310: invokevirtual 143	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   313: astore 6
    //   315: aload 6
    //   317: astore 7
    //   319: goto -68 -> 251
    //   322: aload 7
    //   324: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   96	110	136	finally
    //   0	29	147	java/lang/Throwable
    //   29	48	147	java/lang/Throwable
    //   53	77	147	java/lang/Throwable
    //   77	96	147	java/lang/Throwable
    //   110	116	147	java/lang/Throwable
    //   116	133	147	java/lang/Throwable
    //   138	147	147	java/lang/Throwable
    //   190	197	147	java/lang/Throwable
    //   207	213	147	java/lang/Throwable
    //   218	230	147	java/lang/Throwable
    //   230	236	147	java/lang/Throwable
    //   242	251	147	java/lang/Throwable
    //   251	304	147	java/lang/Throwable
    //   307	315	147	java/lang/Throwable
  }

  public ScopeExp getCapturedScope()
  {
    if (this.capturedScope == null)
    {
      if (!(this.instance instanceof ModuleExp))
        break label33;
      this.capturedScope = ((ModuleExp)this.instance);
    }
    while (true)
    {
      return this.capturedScope;
      label33: if (this.instance != null)
        this.capturedScope = ModuleInfo.findFromInstance(this.instance).getModuleExp();
    }
  }

  public final boolean isHygienic()
  {
    return this.hygienic;
  }

  public void print(Consumer paramConsumer)
  {
    paramConsumer.write("#<macro ");
    paramConsumer.write(getName());
    paramConsumer.write(62);
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    setName((String)paramObjectInput.readObject());
    this.expander = new QuoteExp(paramObjectInput.readObject());
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    return paramTranslator.rewrite(expand(paramPair, paramTranslator));
  }

  public Expression rewriteForm(Object paramObject, Translator paramTranslator)
  {
    return paramTranslator.rewrite(expand(paramObject, paramTranslator));
  }

  public void scanForm(Pair paramPair, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    String str = paramTranslator.getFileName();
    int i = paramTranslator.getLineNumber();
    int j = paramTranslator.getColumnNumber();
    Syntax localSyntax = paramTranslator.currentSyntax;
    try
    {
      paramTranslator.setLine(paramPair);
      paramTranslator.currentSyntax = this;
      paramTranslator.scanForm(expand(paramPair, paramTranslator), paramScopeExp);
      return;
    }
    finally
    {
      paramTranslator.setLine(str, i, j);
      paramTranslator.currentSyntax = localSyntax;
    }
  }

  public void setCapturedScope(ScopeExp paramScopeExp)
  {
    this.capturedScope = paramScopeExp;
  }

  public final void setHygienic(boolean paramBoolean)
  {
    this.hygienic = paramBoolean;
  }

  public String toString()
  {
    return "#<macro " + getName() + '>';
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(getName());
    paramObjectOutput.writeObject(((QuoteExp)this.expander).getValue());
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.Macro
 * JD-Core Version:    0.6.2
 */