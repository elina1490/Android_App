package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.xml.Document;
import gnu.kawa.xml.KAttr;
import gnu.kawa.xml.KComment;
import gnu.kawa.xml.KDocument;
import gnu.kawa.xml.KElement;
import gnu.kawa.xml.KProcessingInstruction;
import gnu.kawa.xml.OutputAsXML;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;

public class XML extends ModuleBody
{
  public static final XML $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit2 = (SimpleSymbol)new SimpleSymbol("attribute-name").readResolve();
  public static OutputAsXML as$Mnxml;
  public static final ModuleMethod attribute$Mnname;
  public static final Class comment;
  public static final ModuleMethod element$Mnname;
  public static final ModuleMethod parse$Mnxml$Mnfrom$Mnurl;
  public static final Class processing$Mninstruction;

  static
  {
    Lit1 = (SimpleSymbol)new SimpleSymbol("element-name").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("parse-xml-from-url").readResolve();
    processing$Mninstruction = KProcessingInstruction.class;
    comment = KComment.class;
    $instance = new XML();
    XML localXML = $instance;
    parse$Mnxml$Mnfrom$Mnurl = new ModuleMethod(localXML, 1, Lit0, 4097);
    element$Mnname = new ModuleMethod(localXML, 2, Lit1, 4097);
    attribute$Mnname = new ModuleMethod(localXML, 3, Lit2, 4097);
    $instance.run();
  }

  public XML()
  {
    ModuleInfo.register(this);
  }

  public static Symbol attributeName(KAttr paramKAttr)
  {
    return paramKAttr.getNodeSymbol();
  }

  public static Symbol elementName(KElement paramKElement)
  {
    return paramKElement.getNodeSymbol();
  }

  public static KDocument parseXmlFromUrl(Object paramObject)
  {
    return Document.parse(paramObject);
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 104	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+28 -> 32, 1:+35->39, 2:+40->44, 3:+52->56
    //   33: aload_1
    //   34: aload_2
    //   35: invokespecial 106	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: areturn
    //   39: aload_2
    //   40: invokestatic 108	gnu/kawa/slib/XML:parseXmlFromUrl	(Ljava/lang/Object;)Lgnu/kawa/xml/KDocument;
    //   43: areturn
    //   44: aload_2
    //   45: checkcast 88	gnu/kawa/xml/KElement
    //   48: astore 6
    //   50: aload 6
    //   52: invokestatic 110	gnu/kawa/slib/XML:elementName	(Lgnu/kawa/xml/KElement;)Lgnu/mapping/Symbol;
    //   55: areturn
    //   56: aload_2
    //   57: checkcast 80	gnu/kawa/xml/KAttr
    //   60: astore 4
    //   62: aload 4
    //   64: invokestatic 112	gnu/kawa/slib/XML:attributeName	(Lgnu/kawa/xml/KAttr;)Lgnu/mapping/Symbol;
    //   67: areturn
    //   68: astore 5
    //   70: new 114	gnu/mapping/WrongType
    //   73: dup
    //   74: aload 5
    //   76: ldc 37
    //   78: iconst_1
    //   79: aload_2
    //   80: invokespecial 117	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   83: athrow
    //   84: astore_3
    //   85: new 114	gnu/mapping/WrongType
    //   88: dup
    //   89: aload_3
    //   90: ldc 25
    //   92: iconst_1
    //   93: aload_2
    //   94: invokespecial 117	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   97: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   44	50	68	java/lang/ClassCastException
    //   56	62	84	java/lang/ClassCastException
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 3:
      if (!(paramObject instanceof KAttr))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2:
      if (!(paramObject instanceof KElement))
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

  public final void run(CallContext paramCallContext)
  {
    as$Mnxml = new OutputAsXML();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.XML
 * JD-Core Version:    0.6.2
 */