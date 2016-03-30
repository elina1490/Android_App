package appinventor.ai_elinanon.karlovassi_new;

import com.google.appinventor.components.runtime.Component;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Symbol;
import gnu.mapping.Values;

public class Screen5$frame extends ModuleBody
{
  Screen5 $main;

  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply0(paramModuleMethod);
    case 14:
      return Screen5.lambda2();
    case 15:
      this.$main.$define();
      return Values.empty;
    case 16:
      return Screen5.lambda3();
    case 17:
      return Screen5.lambda4();
    case 18:
      return Screen5.lambda5();
    case 19:
      return Screen5.lambda6();
    case 20:
      return Screen5.lambda7();
    case 21:
      return Screen5.lambda8();
    case 22:
      return Screen5.lambda9();
    case 23:
      return Screen5.lambda10();
    case 24:
    }
    return Screen5.lambda11();
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 18	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+60 -> 64, 1:+67->71, 2:+60->64, 3:+79->83, 4:+60->64, 5:+99->103, 6:+60->64, 7:+60->64, 8:+60->64, 9:+60->64, 10:+127->131, 11:+139->143
    //   65: aload_1
    //   66: aload_2
    //   67: invokespecial 70	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: areturn
    //   71: aload_0
    //   72: getfield 28	appinventor/ai_elinanon/karlovassi_new/Screen5$frame:$main	Lappinventor/ai_elinanon/karlovassi_new/Screen5;
    //   75: aload_2
    //   76: invokevirtual 74	appinventor/ai_elinanon/karlovassi_new/Screen5:androidLogForm	(Ljava/lang/Object;)V
    //   79: getstatic 37	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   82: areturn
    //   83: aload_0
    //   84: getfield 28	appinventor/ai_elinanon/karlovassi_new/Screen5$frame:$main	Lappinventor/ai_elinanon/karlovassi_new/Screen5;
    //   87: astore 6
    //   89: aload_2
    //   90: checkcast 76	gnu/mapping/Symbol
    //   93: astore 8
    //   95: aload 6
    //   97: aload 8
    //   99: invokevirtual 80	appinventor/ai_elinanon/karlovassi_new/Screen5:lookupInFormEnvironment	(Lgnu/mapping/Symbol;)Ljava/lang/Object;
    //   102: areturn
    //   103: aload_0
    //   104: getfield 28	appinventor/ai_elinanon/karlovassi_new/Screen5$frame:$main	Lappinventor/ai_elinanon/karlovassi_new/Screen5;
    //   107: astore_3
    //   108: aload_2
    //   109: checkcast 76	gnu/mapping/Symbol
    //   112: astore 5
    //   114: aload_3
    //   115: aload 5
    //   117: invokevirtual 84	appinventor/ai_elinanon/karlovassi_new/Screen5:isBoundInFormEnvironment	(Lgnu/mapping/Symbol;)Z
    //   120: ifeq +7 -> 127
    //   123: getstatic 90	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   126: areturn
    //   127: getstatic 93	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   130: areturn
    //   131: aload_0
    //   132: getfield 28	appinventor/ai_elinanon/karlovassi_new/Screen5$frame:$main	Lappinventor/ai_elinanon/karlovassi_new/Screen5;
    //   135: aload_2
    //   136: invokevirtual 96	appinventor/ai_elinanon/karlovassi_new/Screen5:addToFormDoAfterCreation	(Ljava/lang/Object;)V
    //   139: getstatic 37	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   142: areturn
    //   143: aload_0
    //   144: getfield 28	appinventor/ai_elinanon/karlovassi_new/Screen5$frame:$main	Lappinventor/ai_elinanon/karlovassi_new/Screen5;
    //   147: aload_2
    //   148: invokevirtual 99	appinventor/ai_elinanon/karlovassi_new/Screen5:processException	(Ljava/lang/Object;)V
    //   151: getstatic 37	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   154: areturn
    //   155: astore 7
    //   157: new 101	gnu/mapping/WrongType
    //   160: dup
    //   161: aload 7
    //   163: ldc 103
    //   165: iconst_1
    //   166: aload_2
    //   167: invokespecial 106	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   170: athrow
    //   171: astore 4
    //   173: new 101	gnu/mapping/WrongType
    //   176: dup
    //   177: aload 4
    //   179: ldc 108
    //   181: iconst_1
    //   182: aload_2
    //   183: invokespecial 106	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   186: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   89	95	155	java/lang/ClassCastException
    //   108	114	171	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 18	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+64 -> 68, 2:+72->76, 3:+96->100, 4:+64->68, 5:+64->68, 6:+117->121, 7:+141->145, 8:+64->68, 9:+154->158, 10:+64->68, 11:+64->68, 12:+64->68, 13:+167->171
    //   69: aload_1
    //   70: aload_2
    //   71: aload_3
    //   72: invokespecial 112	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   75: areturn
    //   76: aload_0
    //   77: getfield 28	appinventor/ai_elinanon/karlovassi_new/Screen5$frame:$main	Lappinventor/ai_elinanon/karlovassi_new/Screen5;
    //   80: astore 10
    //   82: aload_2
    //   83: checkcast 76	gnu/mapping/Symbol
    //   86: astore 12
    //   88: aload 10
    //   90: aload 12
    //   92: aload_3
    //   93: invokevirtual 116	appinventor/ai_elinanon/karlovassi_new/Screen5:addToFormEnvironment	(Lgnu/mapping/Symbol;Ljava/lang/Object;)V
    //   96: getstatic 37	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   99: areturn
    //   100: aload_0
    //   101: getfield 28	appinventor/ai_elinanon/karlovassi_new/Screen5$frame:$main	Lappinventor/ai_elinanon/karlovassi_new/Screen5;
    //   104: astore 7
    //   106: aload_2
    //   107: checkcast 76	gnu/mapping/Symbol
    //   110: astore 9
    //   112: aload 7
    //   114: aload 9
    //   116: aload_3
    //   117: invokevirtual 119	appinventor/ai_elinanon/karlovassi_new/Screen5:lookupInFormEnvironment	(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;
    //   120: areturn
    //   121: aload_0
    //   122: getfield 28	appinventor/ai_elinanon/karlovassi_new/Screen5$frame:$main	Lappinventor/ai_elinanon/karlovassi_new/Screen5;
    //   125: astore 4
    //   127: aload_2
    //   128: checkcast 76	gnu/mapping/Symbol
    //   131: astore 6
    //   133: aload 4
    //   135: aload 6
    //   137: aload_3
    //   138: invokevirtual 122	appinventor/ai_elinanon/karlovassi_new/Screen5:addToGlobalVarEnvironment	(Lgnu/mapping/Symbol;Ljava/lang/Object;)V
    //   141: getstatic 37	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   144: areturn
    //   145: aload_0
    //   146: getfield 28	appinventor/ai_elinanon/karlovassi_new/Screen5$frame:$main	Lappinventor/ai_elinanon/karlovassi_new/Screen5;
    //   149: aload_2
    //   150: aload_3
    //   151: invokevirtual 126	appinventor/ai_elinanon/karlovassi_new/Screen5:addToEvents	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   154: getstatic 37	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   157: areturn
    //   158: aload_0
    //   159: getfield 28	appinventor/ai_elinanon/karlovassi_new/Screen5$frame:$main	Lappinventor/ai_elinanon/karlovassi_new/Screen5;
    //   162: aload_2
    //   163: aload_3
    //   164: invokevirtual 129	appinventor/ai_elinanon/karlovassi_new/Screen5:addToGlobalVars	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   167: getstatic 37	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   170: areturn
    //   171: aload_0
    //   172: getfield 28	appinventor/ai_elinanon/karlovassi_new/Screen5$frame:$main	Lappinventor/ai_elinanon/karlovassi_new/Screen5;
    //   175: aload_2
    //   176: aload_3
    //   177: invokevirtual 133	appinventor/ai_elinanon/karlovassi_new/Screen5:lookupHandler	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: areturn
    //   181: astore 11
    //   183: new 101	gnu/mapping/WrongType
    //   186: dup
    //   187: aload 11
    //   189: ldc 135
    //   191: iconst_1
    //   192: aload_2
    //   193: invokespecial 106	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   196: athrow
    //   197: astore 8
    //   199: new 101	gnu/mapping/WrongType
    //   202: dup
    //   203: aload 8
    //   205: ldc 103
    //   207: iconst_1
    //   208: aload_2
    //   209: invokespecial 106	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   212: athrow
    //   213: astore 5
    //   215: new 101	gnu/mapping/WrongType
    //   218: dup
    //   219: aload 5
    //   221: ldc 137
    //   223: iconst_1
    //   224: aload_2
    //   225: invokespecial 106	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   228: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   82	88	181	java/lang/ClassCastException
    //   106	112	197	java/lang/ClassCastException
    //   127	133	213	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 18	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+28->32, 8:+40->44, 12:+57->61
    //   33: aload_1
    //   34: aload_2
    //   35: aload_3
    //   36: aload 4
    //   38: aload 5
    //   40: invokespecial 141	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: areturn
    //   44: aload_0
    //   45: getfield 28	appinventor/ai_elinanon/karlovassi_new/Screen5$frame:$main	Lappinventor/ai_elinanon/karlovassi_new/Screen5;
    //   48: aload_2
    //   49: aload_3
    //   50: aload 4
    //   52: aload 5
    //   54: invokevirtual 145	appinventor/ai_elinanon/karlovassi_new/Screen5:addToComponents	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   57: getstatic 37	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   60: areturn
    //   61: aload_0
    //   62: getfield 28	appinventor/ai_elinanon/karlovassi_new/Screen5$frame:$main	Lappinventor/ai_elinanon/karlovassi_new/Screen5;
    //   65: astore 6
    //   67: aload_2
    //   68: checkcast 147	com/google/appinventor/components/runtime/Component
    //   71: astore 8
    //   73: aload_3
    //   74: checkcast 149	java/lang/String
    //   77: astore 10
    //   79: aload 4
    //   81: checkcast 149	java/lang/String
    //   84: astore 12
    //   86: aload 5
    //   88: checkcast 151	[Ljava/lang/Object;
    //   91: astore 14
    //   93: aload 6
    //   95: aload 8
    //   97: aload 10
    //   99: aload 12
    //   101: aload 14
    //   103: invokevirtual 155	appinventor/ai_elinanon/karlovassi_new/Screen5:dispatchEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Z
    //   106: ifeq +7 -> 113
    //   109: getstatic 90	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   112: areturn
    //   113: getstatic 93	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   116: areturn
    //   117: astore 7
    //   119: new 101	gnu/mapping/WrongType
    //   122: dup
    //   123: aload 7
    //   125: ldc 156
    //   127: iconst_1
    //   128: aload_2
    //   129: invokespecial 106	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   132: athrow
    //   133: astore 9
    //   135: new 101	gnu/mapping/WrongType
    //   138: dup
    //   139: aload 9
    //   141: ldc 156
    //   143: iconst_2
    //   144: aload_3
    //   145: invokespecial 106	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   148: athrow
    //   149: astore 11
    //   151: new 101	gnu/mapping/WrongType
    //   154: dup
    //   155: aload 11
    //   157: ldc 156
    //   159: iconst_3
    //   160: aload 4
    //   162: invokespecial 106	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   165: athrow
    //   166: astore 13
    //   168: new 101	gnu/mapping/WrongType
    //   171: dup
    //   172: aload 13
    //   174: ldc 156
    //   176: iconst_4
    //   177: aload 5
    //   179: invokespecial 106	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   182: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   67	73	117	java/lang/ClassCastException
    //   73	79	133	java/lang/ClassCastException
    //   79	86	149	java/lang/ClassCastException
    //   86	93	166	java/lang/ClassCastException
  }

  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match0(paramModuleMethod, paramCallContext);
    case 24:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 23:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 22:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 21:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 20:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 19:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 18:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 17:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 16:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 15:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 14:
    }
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 0;
    return 0;
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 2:
    case 4:
    case 6:
    case 7:
    case 8:
    case 9:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 11:
      if (!(paramObject instanceof Screen5))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 10:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 5:
      if (!(paramObject instanceof Symbol))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 3:
      if (!(paramObject instanceof Symbol))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 1:
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }

  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 4:
    case 5:
    case 8:
    case 10:
    case 11:
    case 12:
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 13:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 9:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 7:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 6:
      if (!(paramObject1 instanceof Symbol))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 3:
      if (!(paramObject1 instanceof Symbol))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 2:
    }
    if (!(paramObject1 instanceof Symbol))
      return -786431;
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }

  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    case 12:
      if (!(paramObject1 instanceof Screen5))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Component))
        return -786430;
      paramCallContext.value2 = paramObject2;
      if (!(paramObject3 instanceof String))
        return -786429;
      paramCallContext.value3 = paramObject3;
      if (!(paramObject4 instanceof String))
        return -786428;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    case 8:
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.value4 = paramObject4;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 4;
    return 0;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     appinventor.ai_elinanon.karlovassi_new.Screen5.frame
 * JD-Core Version:    0.6.2
 */