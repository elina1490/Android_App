package kawa.lang;

import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1or2;
import gnu.text.SourceMessages;

public class Eval extends Procedure1or2
{
  public static final Eval eval = new Eval();
  static final String evalFunctionName = "atEvalLevel$";

  static
  {
    eval.setName("eval");
  }

  public static Object eval(Object paramObject, Environment paramEnvironment)
    throws Throwable
  {
    CallContext localCallContext = CallContext.getInstance();
    int i = localCallContext.startFromContext();
    try
    {
      eval(paramObject, paramEnvironment, localCallContext);
      Object localObject = localCallContext.getFromContext(i);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localCallContext.cleanupFromContext(i);
      throw localThrowable;
    }
  }

  public static void eval(Object paramObject, Environment paramEnvironment, CallContext paramCallContext)
    throws Throwable
  {
    PairWithPosition localPairWithPosition;
    if ((paramObject instanceof PairWithPosition))
      localPairWithPosition = new PairWithPosition((PairWithPosition)paramObject, paramObject, LList.Empty);
    while (true)
    {
      evalBody(localPairWithPosition, paramEnvironment, new SourceMessages(), paramCallContext);
      return;
      localPairWithPosition = new PairWithPosition(paramObject, LList.Empty);
      localPairWithPosition.setFile("<eval>");
    }
  }

  public static Object evalBody(Object paramObject, Environment paramEnvironment, SourceMessages paramSourceMessages)
    throws Throwable
  {
    CallContext localCallContext = CallContext.getInstance();
    int i = localCallContext.startFromContext();
    try
    {
      evalBody(paramObject, paramEnvironment, paramSourceMessages, localCallContext);
      Object localObject = localCallContext.getFromContext(i);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localCallContext.cleanupFromContext(i);
      throw localThrowable;
    }
  }

  // ERROR //
  public static void evalBody(Object paramObject, Environment paramEnvironment, SourceMessages paramSourceMessages, CallContext paramCallContext)
    throws Throwable
  {
    // Byte code:
    //   0: invokestatic 80	gnu/expr/Language:getDefaultLanguage	()Lgnu/expr/Language;
    //   3: astore 4
    //   5: invokestatic 86	gnu/mapping/Environment:getCurrent	()Lgnu/mapping/Environment;
    //   8: astore 5
    //   10: aload_1
    //   11: aload 5
    //   13: if_acmpeq +7 -> 20
    //   16: aload_1
    //   17: invokestatic 90	gnu/mapping/Environment:setCurrent	(Lgnu/mapping/Environment;)V
    //   20: new 92	kawa/lang/Translator
    //   23: dup
    //   24: aload 4
    //   26: aload_2
    //   27: aload_1
    //   28: aload 4
    //   30: invokestatic 97	gnu/expr/NameLookup:getInstance	(Lgnu/mapping/Environment;Lgnu/expr/Language;)Lgnu/expr/NameLookup;
    //   33: invokespecial 100	kawa/lang/Translator:<init>	(Lgnu/expr/Language;Lgnu/text/SourceMessages;Lgnu/expr/NameLookup;)V
    //   36: astore 6
    //   38: aload 6
    //   40: iconst_1
    //   41: putfield 104	kawa/lang/Translator:immediate	Z
    //   44: aload 6
    //   46: iconst_3
    //   47: invokevirtual 107	kawa/lang/Translator:setState	(I)V
    //   50: aload 6
    //   52: iconst_1
    //   53: invokevirtual 111	kawa/lang/Translator:setSharedModuleDefs	(Z)V
    //   56: aload 6
    //   58: aconst_null
    //   59: checkcast 113	java/lang/String
    //   62: invokevirtual 117	kawa/lang/Translator:pushNewModule	(Ljava/lang/String;)Lgnu/expr/ModuleExp;
    //   65: astore 8
    //   67: aload 6
    //   69: invokestatic 123	gnu/expr/Compilation:setSaveCurrent	(Lgnu/expr/Compilation;)Lgnu/expr/Compilation;
    //   72: astore 9
    //   74: aload 6
    //   76: getfield 127	kawa/lang/Translator:formStack	Ljava/util/Stack;
    //   79: invokevirtual 132	java/util/Stack:size	()I
    //   82: istore 11
    //   84: aload 6
    //   86: aload_0
    //   87: aload 8
    //   89: iconst_0
    //   90: invokevirtual 136	kawa/lang/Translator:scanBody	(Ljava/lang/Object;Lgnu/expr/ScopeExp;Z)Lgnu/lists/LList;
    //   93: pop
    //   94: aload 6
    //   96: iload 11
    //   98: putfield 140	kawa/lang/Translator:firstForm	I
    //   101: aload 6
    //   103: aload 8
    //   105: invokevirtual 144	kawa/lang/Translator:finishModule	(Lgnu/expr/ModuleExp;)V
    //   108: aload 9
    //   110: invokestatic 148	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   113: aload_0
    //   114: instanceof 49
    //   117: ifeq +15 -> 132
    //   120: aload 8
    //   122: aload_0
    //   123: checkcast 49	gnu/lists/PairWithPosition
    //   126: invokevirtual 152	gnu/lists/PairWithPosition:getFileName	()Ljava/lang/String;
    //   129: invokevirtual 155	gnu/expr/ModuleExp:setFile	(Ljava/lang/String;)V
    //   132: new 157	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   139: ldc 10
    //   141: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: astore 13
    //   146: iconst_1
    //   147: getstatic 165	gnu/expr/ModuleExp:interactiveCounter	I
    //   150: iadd
    //   151: istore 14
    //   153: iload 14
    //   155: putstatic 165	gnu/expr/ModuleExp:interactiveCounter	I
    //   158: aload 8
    //   160: aload 13
    //   162: iload 14
    //   164: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokevirtual 172	gnu/expr/ModuleExp:setName	(Ljava/lang/String;)V
    //   173: aload_1
    //   174: aload_3
    //   175: aload 6
    //   177: aconst_null
    //   178: aconst_null
    //   179: invokestatic 176	gnu/expr/ModuleExp:evalModule	(Lgnu/mapping/Environment;Lgnu/mapping/CallContext;Lgnu/expr/Compilation;Ljava/net/URL;Lgnu/mapping/OutPort;)Z
    //   182: pop
    //   183: aload_2
    //   184: invokevirtual 180	gnu/text/SourceMessages:seenErrors	()Z
    //   187: ifeq +61 -> 248
    //   190: new 182	java/lang/RuntimeException
    //   193: dup
    //   194: new 157	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   201: ldc 184
    //   203: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_2
    //   207: bipush 20
    //   209: invokevirtual 187	gnu/text/SourceMessages:toString	(I)Ljava/lang/String;
    //   212: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokespecial 189	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   221: athrow
    //   222: astore 7
    //   224: aload_1
    //   225: aload 5
    //   227: if_acmpeq +8 -> 235
    //   230: aload 5
    //   232: invokestatic 90	gnu/mapping/Environment:setCurrent	(Lgnu/mapping/Environment;)V
    //   235: aload 7
    //   237: athrow
    //   238: astore 10
    //   240: aload 9
    //   242: invokestatic 148	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   245: aload 10
    //   247: athrow
    //   248: aload_1
    //   249: aload 5
    //   251: if_acmpeq +8 -> 259
    //   254: aload 5
    //   256: invokestatic 90	gnu/mapping/Environment:setCurrent	(Lgnu/mapping/Environment;)V
    //   259: return
    //
    // Exception table:
    //   from	to	target	type
    //   16	20	222	finally
    //   20	74	222	finally
    //   108	132	222	finally
    //   132	222	222	finally
    //   240	248	222	finally
    //   74	108	238	finally
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Procedure.checkArgCount(this, paramCallContext.count);
    Object localObject = paramCallContext.getNextArg();
    Environment localEnvironment = (Environment)paramCallContext.getNextArg(null);
    if (localEnvironment == null)
      localEnvironment = Environment.user();
    paramCallContext.lastArg();
    eval(localObject, localEnvironment, paramCallContext);
  }

  public Object apply1(Object paramObject)
    throws Throwable
  {
    return eval(paramObject, Environment.user());
  }

  public Object apply2(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    return eval(paramObject1, (Environment)paramObject2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.Eval
 * JD-Core Version:    0.6.2
 */