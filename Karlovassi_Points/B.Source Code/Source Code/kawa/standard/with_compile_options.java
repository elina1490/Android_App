package kawa.standard;

import gnu.expr.BeginExp;
import gnu.expr.Expression;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.text.Options;
import java.util.Stack;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class with_compile_options extends Syntax
{
  public static final with_compile_options with_compile_options = new with_compile_options();

  static
  {
    with_compile_options.setName("with-compile-options");
  }

  // ERROR //
  public static Object getOptions(Object paramObject, Stack paramStack, Syntax paramSyntax, Translator paramTranslator)
  {
    // Byte code:
    //   0: aload_3
    //   1: getfield 28	kawa/lang/Translator:currentOptions	Lgnu/text/Options;
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: iconst_0
    //   10: istore 6
    //   12: aload_0
    //   13: instanceof 30
    //   16: ifeq +24 -> 40
    //   19: aload_0
    //   20: checkcast 30	kawa/lang/SyntaxForm
    //   23: astore 31
    //   25: aload 31
    //   27: invokeinterface 34 1 0
    //   32: astore_0
    //   33: aload 31
    //   35: astore 5
    //   37: goto -25 -> 12
    //   40: aload_0
    //   41: instanceof 36
    //   44: ifne +53 -> 97
    //   47: iload 6
    //   49: ifne +31 -> 80
    //   52: aload_3
    //   53: bipush 101
    //   55: new 38	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   62: ldc 41
    //   64: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_2
    //   68: invokevirtual 49	kawa/lang/Syntax:getName	()Ljava/lang/String;
    //   71: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokevirtual 56	kawa/lang/Translator:error	(CLjava/lang/String;)V
    //   80: aload_0
    //   81: aload 5
    //   83: invokestatic 60	kawa/lang/Translator:wrapSyntax	(Ljava/lang/Object;Lkawa/lang/SyntaxForm;)Ljava/lang/Object;
    //   86: astore 28
    //   88: aload 5
    //   90: pop
    //   91: iload 6
    //   93: pop
    //   94: aload 28
    //   96: areturn
    //   97: aload_0
    //   98: checkcast 36	gnu/lists/Pair
    //   101: astore 7
    //   103: aload 7
    //   105: invokevirtual 63	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   108: invokestatic 67	kawa/lang/Translator:stripSyntax	(Ljava/lang/Object;)Ljava/lang/Object;
    //   111: astore 8
    //   113: aload 8
    //   115: instanceof 69
    //   118: ifeq -71 -> 47
    //   121: aload 8
    //   123: checkcast 69	gnu/expr/Keyword
    //   126: invokevirtual 70	gnu/expr/Keyword:getName	()Ljava/lang/String;
    //   129: astore 9
    //   131: aload_3
    //   132: aload 7
    //   134: invokevirtual 73	kawa/lang/Translator:pushPositionOf	(Ljava/lang/Object;)Ljava/lang/Object;
    //   137: astore 10
    //   139: aload 7
    //   141: invokevirtual 76	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   144: astore 14
    //   146: aload 14
    //   148: instanceof 30
    //   151: ifeq +30 -> 181
    //   154: aload 14
    //   156: checkcast 30	kawa/lang/SyntaxForm
    //   159: astore 25
    //   161: aload 25
    //   163: invokeinterface 34 1 0
    //   168: astore 27
    //   170: aload 27
    //   172: astore 14
    //   174: aload 25
    //   176: astore 5
    //   178: goto -32 -> 146
    //   181: aload 14
    //   183: instanceof 36
    //   186: ifne +51 -> 237
    //   189: aload_3
    //   190: bipush 101
    //   192: new 38	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   199: ldc 78
    //   201: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 9
    //   206: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 80
    //   211: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokevirtual 56	kawa/lang/Translator:error	(CLjava/lang/String;)V
    //   220: getstatic 86	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   223: astore 23
    //   225: aload_3
    //   226: aload 10
    //   228: invokevirtual 90	kawa/lang/Translator:popPositionOf	(Ljava/lang/Object;)V
    //   231: aload 5
    //   233: pop
    //   234: aload 23
    //   236: areturn
    //   237: aload 14
    //   239: checkcast 36	gnu/lists/Pair
    //   242: astore 15
    //   244: aload 15
    //   246: invokevirtual 63	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   249: invokestatic 67	kawa/lang/Translator:stripSyntax	(Ljava/lang/Object;)Ljava/lang/Object;
    //   252: astore 18
    //   254: aload 15
    //   256: invokevirtual 76	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   259: astore_0
    //   260: aload 4
    //   262: aload 9
    //   264: invokevirtual 96	gnu/text/Options:getLocal	(Ljava/lang/String;)Ljava/lang/Object;
    //   267: astore 19
    //   269: aload 4
    //   271: aload 9
    //   273: invokevirtual 100	gnu/text/Options:getInfo	(Ljava/lang/String;)Lgnu/text/Options$OptionInfo;
    //   276: ifnonnull +41 -> 317
    //   279: aload_3
    //   280: bipush 119
    //   282: new 38	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   289: ldc 102
    //   291: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload 9
    //   296: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokevirtual 56	kawa/lang/Translator:error	(CLjava/lang/String;)V
    //   305: aload_3
    //   306: aload 10
    //   308: invokevirtual 90	kawa/lang/Translator:popPositionOf	(Ljava/lang/Object;)V
    //   311: iconst_1
    //   312: istore 6
    //   314: goto -302 -> 12
    //   317: aload 18
    //   319: instanceof 104
    //   322: ifeq +60 -> 382
    //   325: aload 18
    //   327: invokevirtual 107	java/lang/Object:toString	()Ljava/lang/String;
    //   330: astore 18
    //   332: aload 4
    //   334: aload 9
    //   336: aload 18
    //   338: aload_3
    //   339: invokevirtual 111	kawa/lang/Translator:getMessages	()Lgnu/text/SourceMessages;
    //   342: invokevirtual 115	gnu/text/Options:set	(Ljava/lang/String;Ljava/lang/Object;Lgnu/text/SourceMessages;)V
    //   345: aload_1
    //   346: ifnull +24 -> 370
    //   349: aload_1
    //   350: aload 9
    //   352: invokevirtual 120	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   355: pop
    //   356: aload_1
    //   357: aload 19
    //   359: invokevirtual 120	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   362: pop
    //   363: aload_1
    //   364: aload 18
    //   366: invokevirtual 120	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   369: pop
    //   370: aload_3
    //   371: aload 10
    //   373: invokevirtual 90	kawa/lang/Translator:popPositionOf	(Ljava/lang/Object;)V
    //   376: iconst_1
    //   377: istore 6
    //   379: goto -367 -> 12
    //   382: aload 18
    //   384: instanceof 122
    //   387: ifne -55 -> 332
    //   390: aload 18
    //   392: instanceof 124
    //   395: ifne -63 -> 332
    //   398: aload_3
    //   399: bipush 101
    //   401: new 38	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   408: ldc 126
    //   410: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload 9
    //   415: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokevirtual 56	kawa/lang/Translator:error	(CLjava/lang/String;)V
    //   424: aconst_null
    //   425: astore 18
    //   427: goto -95 -> 332
    //   430: astore 16
    //   432: aload 16
    //   434: astore 12
    //   436: aload 5
    //   438: pop
    //   439: aload_3
    //   440: aload 10
    //   442: invokevirtual 90	kawa/lang/Translator:popPositionOf	(Ljava/lang/Object;)V
    //   445: aload 12
    //   447: athrow
    //   448: astore 11
    //   450: aload 11
    //   452: astore 12
    //   454: aload 5
    //   456: pop
    //   457: goto -18 -> 439
    //   460: astore 26
    //   462: aload 26
    //   464: astore 12
    //   466: goto -27 -> 439
    //
    // Exception table:
    //   from	to	target	type
    //   244	305	430	finally
    //   317	332	430	finally
    //   332	345	430	finally
    //   349	370	430	finally
    //   382	424	430	finally
    //   139	146	448	finally
    //   146	161	448	finally
    //   181	225	448	finally
    //   237	244	448	finally
    //   161	170	460	finally
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Object localObject1 = paramPair.getCdr();
    Stack localStack;
    Object localObject2;
    if ((localObject1 instanceof Pair))
    {
      Pair localPair = (Pair)localObject1;
      if ((localPair.getCar() instanceof Stack))
      {
        localStack = (Stack)localPair.getCar();
        localObject2 = localPair.getCdr();
        paramTranslator.currentOptions.pushOptionValues(localStack);
      }
    }
    try
    {
      Expression localExpression = paramTranslator.rewrite_body(localObject2);
      if ((localExpression instanceof BeginExp));
      for (BeginExp localBeginExp = (BeginExp)localExpression; ; localBeginExp = new BeginExp(new Expression[] { localExpression }))
      {
        localBeginExp.setCompileOptions(localStack);
        return localBeginExp;
        localStack = new Stack();
        localObject2 = getOptions(localObject1, localStack, this, paramTranslator);
        break;
      }
    }
    finally
    {
      paramTranslator.currentOptions.popOptionValues(localStack);
    }
  }

  public void scanForm(Pair paramPair, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    Stack localStack = new Stack();
    Object localObject = getOptions(paramPair.getCdr(), localStack, this, paramTranslator);
    if (localObject == LList.Empty)
      return;
    if (localObject == paramPair.getCdr())
    {
      paramTranslator.scanBody(localObject, paramScopeExp, false);
      return;
    }
    Pair localPair = new Pair(localStack, paramTranslator.scanBody(localObject, paramScopeExp, true));
    paramTranslator.currentOptions.popOptionValues(localStack);
    paramTranslator.formStack.add(Translator.makePair(paramPair, paramPair.getCar(), localPair));
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.with_compile_options
 * JD-Core Version:    0.6.2
 */