package gnu.xml;

import gnu.expr.Keyword;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumable;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.UnescapedData;
import gnu.lists.XConsumer;
import gnu.mapping.OutPort;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.math.DFloNum;
import gnu.math.RealNum;
import gnu.text.Char;
import gnu.text.Path;
import gnu.text.PrettyWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;

public class XMLPrinter extends OutPort
  implements PositionConsumer, XConsumer
{
  private static final int COMMENT = -5;
  private static final int ELEMENT_END = -4;
  private static final int ELEMENT_START = -3;
  static final String HtmlEmptyTags = "/area/base/basefont/br/col/frame/hr/img/input/isindex/link/meta/para/";
  private static final int KEYWORD = -6;
  private static final int PROC_INST = -7;
  private static final int WORD = -2;
  public static final ThreadLocation doctypePublic = new ThreadLocation("doctype-public");
  public static final ThreadLocation doctypeSystem = new ThreadLocation("doctype-system");
  public static final ThreadLocation indentLoc = new ThreadLocation("xml-indent");
  boolean canonicalize = true;
  public boolean canonicalizeCDATA;
  Object[] elementNameStack = new Object[20];
  int elementNesting;
  public boolean escapeNonAscii = true;
  public boolean escapeText = true;
  boolean inAttribute = false;
  int inComment;
  boolean inDocument;
  boolean inStartTag = false;
  public boolean indentAttributes;
  boolean isHtml = false;
  boolean isHtmlOrXhtml = false;
  NamespaceBinding namespaceBindings = NamespaceBinding.predefinedXML;
  NamespaceBinding[] namespaceSaveStack = new NamespaceBinding[20];
  boolean needXMLdecl = false;
  int prev = 32;
  public int printIndent = -1;
  boolean printXMLdecl = false;
  char savedHighSurrogate;
  public boolean strict;
  Object style;
  boolean undeclareNamespaces = false;
  public int useEmptyElementTag = 2;

  public XMLPrinter(OutPort paramOutPort, boolean paramBoolean)
  {
    super(paramOutPort, paramBoolean);
  }

  public XMLPrinter(OutputStream paramOutputStream)
  {
    super(new OutputStreamWriter(paramOutputStream), false, false);
  }

  public XMLPrinter(OutputStream paramOutputStream, Path paramPath)
  {
    super(new OutputStreamWriter(paramOutputStream), true, false, paramPath);
  }

  public XMLPrinter(OutputStream paramOutputStream, boolean paramBoolean)
  {
    super(new OutputStreamWriter(paramOutputStream), true, paramBoolean);
  }

  public XMLPrinter(Writer paramWriter)
  {
    super(paramWriter);
  }

  public XMLPrinter(Writer paramWriter, boolean paramBoolean)
  {
    super(paramWriter, paramBoolean);
  }

  static String formatDecimal(String paramString)
  {
    if (paramString.indexOf('.') >= 0)
    {
      int i = paramString.length();
      int j = i;
      int k;
      do
      {
        j--;
        k = paramString.charAt(j);
      }
      while (k == 48);
      if (k != 46)
        j++;
      if (j == i)
        return paramString;
      return paramString.substring(0, j);
    }
    return paramString;
  }

  public static String formatDecimal(BigDecimal paramBigDecimal)
  {
    return formatDecimal(paramBigDecimal.toPlainString());
  }

  public static String formatDouble(double paramDouble)
  {
    if (Double.isNaN(paramDouble))
      return "NaN";
    int i;
    if (paramDouble < 0.0D)
      i = 1;
    while (Double.isInfinite(paramDouble))
      if (i != 0)
      {
        return "-INF";
        i = 0;
      }
      else
      {
        return "INF";
      }
    if (i != 0);
    String str;
    for (double d = -paramDouble; ; d = paramDouble)
    {
      str = Double.toString(paramDouble);
      if (((d < 1000000.0D) && (d >= 1.0E-006D)) || (d == 0.0D))
        break;
      return RealNum.toStringScientific(str);
    }
    return formatDecimal(RealNum.toStringDecimal(str));
  }

  public static String formatFloat(float paramFloat)
  {
    if (Float.isNaN(paramFloat))
      return "NaN";
    int i;
    if (paramFloat < 0.0F)
      i = 1;
    while (Float.isInfinite(paramFloat))
      if (i != 0)
      {
        return "-INF";
        i = 0;
      }
      else
      {
        return "INF";
      }
    if (i != 0);
    String str;
    for (float f = -paramFloat; ; f = paramFloat)
    {
      str = Float.toString(paramFloat);
      if (((f < 1000000.0F) && (f >= 1.0E-006D)) || (f == 0.0D))
        break;
      return RealNum.toStringScientific(str);
    }
    return formatDecimal(RealNum.toStringDecimal(str));
  }

  public static boolean isHtmlEmptyElementTag(String paramString)
  {
    int i = "/area/base/basefont/br/col/frame/hr/img/input/isindex/link/meta/para/".indexOf(paramString);
    return (i > 0) && ("/area/base/basefont/br/col/frame/hr/img/input/isindex/link/meta/para/".charAt(i - 1) == '/') && ("/area/base/basefont/br/col/frame/hr/img/input/isindex/link/meta/para/".charAt(i + paramString.length()) == '/');
  }

  public static XMLPrinter make(OutPort paramOutPort, Object paramObject)
  {
    XMLPrinter localXMLPrinter = new XMLPrinter(paramOutPort, true);
    localXMLPrinter.setStyle(paramObject);
    return localXMLPrinter;
  }

  private void startWord()
  {
    closeTag();
    writeWordStart();
  }

  public static String toString(Object paramObject)
  {
    StringWriter localStringWriter = new StringWriter();
    new XMLPrinter(localStringWriter).writeObject(paramObject);
    return localStringWriter.toString();
  }

  public void beginComment()
  {
    closeTag();
    if ((this.printIndent >= 0) && ((this.prev == -3) || (this.prev == -4) || (this.prev == -5)))
      if (this.printIndent <= 0)
        break label68;
    label68: for (int i = 82; ; i = 78)
    {
      writeBreak(i);
      this.bout.write("<!--");
      this.inComment = 1;
      return;
    }
  }

  public void beginEntity(Object paramObject)
  {
  }

  public void closeTag()
  {
    if ((this.inStartTag) && (!this.inAttribute))
    {
      if ((this.printIndent >= 0) && (this.indentAttributes))
        endLogicalBlock("");
      this.bout.write(62);
      this.inStartTag = false;
      this.prev = -3;
    }
    while (!this.needXMLdecl)
      return;
    this.bout.write("<?xml version=\"1.0\"?>\n");
    if (this.printIndent >= 0)
      startLogicalBlock("", "", 2);
    this.needXMLdecl = false;
    this.prev = 62;
  }

  public void consume(SeqPosition paramSeqPosition)
  {
    paramSeqPosition.sequence.consumeNext(paramSeqPosition.ipos, this);
  }

  public void endAttribute()
  {
    if (this.inAttribute)
    {
      if (this.prev != -6)
      {
        this.bout.write(34);
        this.inAttribute = false;
      }
      this.prev = 32;
    }
  }

  public void endComment()
  {
    this.bout.write("-->");
    this.prev = -5;
    this.inComment = 0;
  }

  public void endDocument()
  {
    this.inDocument = false;
    if (this.printIndent >= 0)
      endLogicalBlock("");
    freshLine();
  }

  public void endElement()
  {
    if (this.useEmptyElementTag == 0)
      closeTag();
    Object localObject = this.elementNameStack[(this.elementNesting - 1)];
    String str1 = getHtmlTag(localObject);
    if (this.inStartTag)
    {
      if ((this.printIndent >= 0) && (this.indentAttributes))
        endLogicalBlock("");
      int k;
      String str2;
      String str4;
      String str5;
      if ((str1 != null) && (isHtmlEmptyElementTag(str1)))
      {
        k = 1;
        if (this.useEmptyElementTag != 0)
        {
          str2 = null;
          if (str1 != null)
          {
            str2 = null;
            if (k != 0);
          }
        }
        else
        {
          boolean bool = localObject instanceof Symbol;
          str2 = null;
          if (bool)
          {
            Symbol localSymbol = (Symbol)localObject;
            String str3 = localSymbol.getPrefix();
            str4 = localSymbol.getNamespaceURI();
            str5 = localSymbol.getLocalName();
            if (str3 == "")
              break label328;
            str2 = "></" + str3 + ":" + str5 + ">";
          }
        }
        label182: if (str2 == null)
        {
          if ((k == 0) || (!this.isHtml))
            break label376;
          str2 = ">";
        }
      }
      while (true)
      {
        this.bout.write(str2);
        this.inStartTag = false;
        if (this.printIndent >= 0)
          endLogicalBlock("");
        this.prev = -4;
        if ((str1 != null) && (!this.escapeText) && (("script".equals(str1)) || ("style".equals(str1))))
          this.escapeText = true;
        NamespaceBinding[] arrayOfNamespaceBinding = this.namespaceSaveStack;
        int i = this.elementNesting - 1;
        this.elementNesting = i;
        this.namespaceBindings = arrayOfNamespaceBinding[i];
        this.namespaceSaveStack[this.elementNesting] = null;
        this.elementNameStack[this.elementNesting] = null;
        return;
        k = 0;
        break;
        label328: if (str4 != "")
        {
          str2 = null;
          if (str4 != null)
            break label182;
        }
        str2 = "></" + str5 + ">";
        break label182;
        label376: if (this.useEmptyElementTag == 2)
          str2 = " />";
        else
          str2 = "/>";
      }
    }
    if (this.printIndent >= 0)
    {
      setIndentation(0, false);
      if (this.prev == -4)
        if (this.printIndent <= 0)
          break label467;
    }
    label467: for (int j = 82; ; j = 78)
    {
      writeBreak(j);
      this.bout.write("</");
      writeQName(localObject);
      this.bout.write(">");
      break;
    }
  }

  public void endEntity()
  {
  }

  protected void endNumber()
  {
    writeWordEnd();
  }

  public void error(String paramString1, String paramString2)
  {
    throw new RuntimeException("serialization error: " + paramString1 + " [" + paramString2 + ']');
  }

  protected String getHtmlTag(Object paramObject)
  {
    if ((paramObject instanceof Symbol))
    {
      Symbol localSymbol = (Symbol)paramObject;
      String str = localSymbol.getNamespaceURI();
      if ((str == "http://www.w3.org/1999/xhtml") || ((this.isHtmlOrXhtml) && (str == "")))
        return localSymbol.getLocalPart();
    }
    else if (this.isHtmlOrXhtml)
    {
      return paramObject.toString();
    }
    return null;
  }

  public boolean ignoring()
  {
    return false;
  }

  boolean mustHexEscape(int paramInt)
  {
    return ((paramInt >= 127) && ((paramInt <= 159) || (this.escapeNonAscii))) || (paramInt == 8232) || ((paramInt < 32) && ((this.inAttribute) || ((paramInt != 9) && (paramInt != 10))));
  }

  public void print(Object paramObject)
  {
    if ((paramObject instanceof BigDecimal))
    {
      paramObject = formatDecimal((BigDecimal)paramObject);
      if (paramObject != null)
        break label78;
    }
    label78: for (String str = "(null)"; ; str = paramObject.toString())
    {
      write(str);
      return;
      if (((paramObject instanceof Double)) || ((paramObject instanceof DFloNum)))
      {
        paramObject = formatDouble(((Number)paramObject).doubleValue());
        break;
      }
      if (!(paramObject instanceof Float))
        break;
      paramObject = formatFloat(((Float)paramObject).floatValue());
      break;
    }
  }

  void setIndentMode()
  {
    Object localObject = indentLoc.get(null);
    if (localObject == null);
    for (String str = null; str == null; str = localObject.toString())
    {
      this.printIndent = -1;
      return;
    }
    if (str.equals("pretty"))
    {
      this.printIndent = 0;
      return;
    }
    if ((str.equals("always")) || (str.equals("yes")))
    {
      this.printIndent = 1;
      return;
    }
    this.printIndent = -1;
  }

  public void setPrintXMLdecl(boolean paramBoolean)
  {
    this.printXMLdecl = paramBoolean;
  }

  public void setStyle(Object paramObject)
  {
    this.style = paramObject;
    int i;
    if (this.canonicalize)
    {
      i = 0;
      this.useEmptyElementTag = i;
      if (!"html".equals(paramObject))
        break label102;
      this.isHtml = true;
      this.isHtmlOrXhtml = true;
      this.useEmptyElementTag = 2;
      if (this.namespaceBindings == NamespaceBinding.predefinedXML)
        this.namespaceBindings = XmlNamespace.HTML_BINDINGS;
    }
    while (true)
    {
      if ("xhtml".equals(paramObject))
      {
        this.isHtmlOrXhtml = true;
        this.useEmptyElementTag = 2;
      }
      if ("plain".equals(paramObject))
        this.escapeText = false;
      return;
      i = 1;
      break;
      label102: if (this.namespaceBindings == XmlNamespace.HTML_BINDINGS)
        this.namespaceBindings = NamespaceBinding.predefinedXML;
    }
  }

  public void startAttribute(Object paramObject)
  {
    if ((!this.inStartTag) && (this.strict))
      error("attribute not in element", "SENR0001");
    if (this.inAttribute)
      this.bout.write(34);
    this.inAttribute = true;
    this.bout.write(32);
    if (this.printIndent >= 0)
      writeBreakFill();
    this.bout.write(paramObject.toString());
    this.bout.write("=\"");
    this.prev = 32;
  }

  public void startDocument()
  {
    if (this.printXMLdecl)
      this.needXMLdecl = true;
    setIndentMode();
    this.inDocument = true;
    if ((this.printIndent >= 0) && (!this.needXMLdecl))
      startLogicalBlock("", "", 2);
  }

  public void startElement(Object paramObject)
  {
    closeTag();
    Object localObject2;
    String str8;
    if (this.elementNesting == 0)
    {
      if (!this.inDocument)
        setIndentMode();
      if (this.prev == -7)
        write(10);
      Object localObject1 = doctypeSystem.get(null);
      if (localObject1 != null)
      {
        String str7 = localObject1.toString();
        if (str7.length() > 0)
        {
          localObject2 = doctypePublic.get(null);
          this.bout.write("<!DOCTYPE ");
          this.bout.write(paramObject.toString());
          if (localObject2 != null)
            break label422;
          str8 = null;
          if ((str8 == null) || (str8.length() <= 0))
            break label432;
          this.bout.write(" PUBLIC \"");
          this.bout.write(str8);
          this.bout.write("\" \"");
          label146: this.bout.write(str7);
          this.bout.write("\">");
          println();
        }
      }
    }
    int i2;
    label214: NamespaceBinding localNamespaceBinding1;
    NamespaceBinding localNamespaceBinding2;
    int j;
    label339: NamespaceBinding[] arrayOfNamespaceBinding3;
    int k;
    boolean bool;
    NamespaceBinding localNamespaceBinding3;
    label359: int n;
    String str5;
    if (this.printIndent >= 0)
    {
      if ((this.prev == -3) || (this.prev == -4) || (this.prev == -5))
      {
        if (this.printIndent > 0)
        {
          i2 = 82;
          writeBreak(i2);
        }
      }
      else
        startLogicalBlock("", "", 2);
    }
    else
    {
      this.bout.write(60);
      writeQName(paramObject);
      if ((this.printIndent >= 0) && (this.indentAttributes))
        startLogicalBlock("", "", 2);
      this.elementNameStack[this.elementNesting] = paramObject;
      NamespaceBinding[] arrayOfNamespaceBinding1 = this.namespaceSaveStack;
      int i = this.elementNesting;
      this.elementNesting = (i + 1);
      arrayOfNamespaceBinding1[i] = this.namespaceBindings;
      if (!(paramObject instanceof XName))
        break label802;
      localNamespaceBinding1 = ((XName)paramObject).namespaceNodes;
      localNamespaceBinding2 = NamespaceBinding.commonAncestor(localNamespaceBinding1, this.namespaceBindings);
      if (localNamespaceBinding1 != null)
        break label452;
      j = 0;
      arrayOfNamespaceBinding3 = new NamespaceBinding[j];
      k = 0;
      bool = this.canonicalize;
      localNamespaceBinding3 = localNamespaceBinding1;
      if (localNamespaceBinding3 == localNamespaceBinding2)
        break label532;
      n = k;
      localNamespaceBinding3.getUri();
      str5 = localNamespaceBinding3.getPrefix();
    }
    NamespaceBinding localNamespaceBinding6;
    String str6;
    label412: label422: label432: label452: 
    do
    {
      n--;
      if (n < 0)
        break label474;
      localNamespaceBinding6 = arrayOfNamespaceBinding3[n];
      str6 = localNamespaceBinding6.getPrefix();
      if (str5 == str6)
      {
        localNamespaceBinding3 = localNamespaceBinding3.next;
        break label359;
        str8 = localObject2.toString();
        break;
        this.bout.write(" SYSTEM \"");
        break label146;
        i2 = 78;
        break label214;
        j = localNamespaceBinding1.count(localNamespaceBinding2);
        break label339;
      }
    }
    while (!bool);
    if (str5 == null)
      label474: if (!bool)
        break label525;
    label525: for (int i1 = n + 1; ; i1 = k)
    {
      arrayOfNamespaceBinding3[i1] = localNamespaceBinding3;
      k++;
      break label412;
      if ((str6 != null) && (str5.compareTo(str6) <= 0))
        break label474;
      arrayOfNamespaceBinding3[(n + 1)] = localNamespaceBinding6;
      break;
    }
    label532: int m = k;
    String str3;
    String str4;
    do
    {
      m--;
      if (m < 0)
        break;
      NamespaceBinding localNamespaceBinding5 = arrayOfNamespaceBinding3[m];
      str3 = localNamespaceBinding5.prefix;
      str4 = localNamespaceBinding5.uri;
    }
    while ((str4 == this.namespaceBindings.resolve(str3)) || ((str4 == null) && (str3 != null) && (!this.undeclareNamespaces)));
    this.bout.write(32);
    if (str3 == null)
      this.bout.write("xmlns");
    while (true)
    {
      this.bout.write("=\"");
      this.inAttribute = true;
      if (str4 != null)
        write(str4);
      this.inAttribute = false;
      this.bout.write(34);
      break;
      this.bout.write("xmlns:");
      this.bout.write(str3);
    }
    if (this.undeclareNamespaces)
    {
      NamespaceBinding localNamespaceBinding4 = this.namespaceBindings;
      if (localNamespaceBinding4 != localNamespaceBinding2)
      {
        String str2 = localNamespaceBinding4.prefix;
        if ((localNamespaceBinding4.uri != null) && (localNamespaceBinding1.resolve(str2) == null))
        {
          this.bout.write(32);
          if (str2 != null)
            break label774;
          this.bout.write("xmlns");
        }
        while (true)
        {
          this.bout.write("=\"\"");
          localNamespaceBinding4 = localNamespaceBinding4.next;
          break;
          label774: this.bout.write("xmlns:");
          this.bout.write(str2);
        }
      }
    }
    this.namespaceBindings = localNamespaceBinding1;
    label802: if (this.elementNesting >= this.namespaceSaveStack.length)
    {
      NamespaceBinding[] arrayOfNamespaceBinding2 = new NamespaceBinding[2 * this.elementNesting];
      System.arraycopy(this.namespaceSaveStack, 0, arrayOfNamespaceBinding2, 0, this.elementNesting);
      this.namespaceSaveStack = arrayOfNamespaceBinding2;
      Object[] arrayOfObject = new Object[2 * this.elementNesting];
      System.arraycopy(this.elementNameStack, 0, arrayOfObject, 0, this.elementNesting);
      this.elementNameStack = arrayOfObject;
    }
    this.inStartTag = true;
    String str1 = getHtmlTag(paramObject);
    if (("script".equals(str1)) || ("style".equals(str1)))
      this.escapeText = false;
  }

  protected void startNumber()
  {
    startWord();
  }

  public void write(int paramInt)
  {
    closeTag();
    if ((this.printIndent >= 0) && ((paramInt == 13) || (paramInt == 10)))
    {
      if ((paramInt != 10) || (this.prev != 13))
        writeBreak(82);
      if (this.inComment > 0)
        this.inComment = 1;
      return;
    }
    if (!this.escapeText)
    {
      this.bout.write(paramInt);
      this.prev = paramInt;
      return;
    }
    if (this.inComment > 0)
    {
      if (paramInt == 45)
        if (this.inComment == 1)
          this.inComment = 2;
      while (true)
      {
        super.write(paramInt);
        return;
        this.bout.write(32);
        continue;
        this.inComment = 1;
      }
    }
    this.prev = 59;
    if ((paramInt == 60) && ((!this.isHtml) || (!this.inAttribute)))
    {
      this.bout.write("&lt;");
      return;
    }
    if (paramInt == 62)
    {
      this.bout.write("&gt;");
      return;
    }
    if (paramInt == 38)
    {
      this.bout.write("&amp;");
      return;
    }
    if ((paramInt == 34) && (this.inAttribute))
    {
      this.bout.write("&quot;");
      return;
    }
    if (mustHexEscape(paramInt))
    {
      int i = paramInt;
      if (paramInt >= 55296)
      {
        if (paramInt < 56320)
        {
          this.savedHighSurrogate = ((char)paramInt);
          return;
        }
        if (paramInt < 57344)
        {
          i = 65536 + (1024 * (this.savedHighSurrogate - 55296) + (i - 56320));
          this.savedHighSurrogate = '\000';
        }
      }
      this.bout.write("&#x" + Integer.toHexString(i).toUpperCase() + ";");
      return;
    }
    this.bout.write(paramInt);
    this.prev = paramInt;
  }

  public void write(String paramString, int paramInt1, int paramInt2)
  {
    int k;
    if (paramInt2 > 0)
    {
      closeTag();
      int i = paramInt1 + paramInt2;
      int j = 0;
      k = paramInt1;
      if (k < i)
      {
        int m = k + 1;
        int n = paramString.charAt(k);
        if (!mustHexEscape(n))
        {
          if (this.inComment > 0)
            if ((n != 45) && (this.inComment != 2))
              break label151;
        }
        else
        {
          label71: if (j > 0)
            this.bout.write(paramString, m - 1 - j, j);
          write(n);
        }
        label151: for (j = 0; ; j++)
        {
          k = m;
          break;
          if ((n == 60) || (n == 62) || (n == 38) || ((this.inAttribute) && ((n == 34) || (n < 32))))
            break label71;
        }
      }
      if (j > 0)
        this.bout.write(paramString, i - j, j);
    }
    this.prev = 45;
  }

  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int k;
    if (paramInt2 > 0)
    {
      closeTag();
      int i = paramInt1 + paramInt2;
      int j = 0;
      k = paramInt1;
      if (k < i)
      {
        int m = k + 1;
        int n = paramArrayOfChar[k];
        if (!mustHexEscape(n))
        {
          if (this.inComment > 0)
            if ((n != 45) && (this.inComment != 2))
              break label149;
        }
        else
        {
          label69: if (j > 0)
            this.bout.write(paramArrayOfChar, m - 1 - j, j);
          write(n);
        }
        label149: for (j = 0; ; j++)
        {
          k = m;
          break;
          if ((n == 60) || (n == 62) || (n == 38) || ((this.inAttribute) && ((n == 34) || (n < 32))))
            break label69;
        }
      }
      if (j > 0)
        this.bout.write(paramArrayOfChar, i - j, j);
    }
    this.prev = 45;
  }

  public void writeBaseUri(Object paramObject)
  {
  }

  public void writeBoolean(boolean paramBoolean)
  {
    startWord();
    super.print(paramBoolean);
    writeWordEnd();
  }

  public void writeCDATA(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.canonicalizeCDATA)
    {
      write(paramArrayOfChar, paramInt1, paramInt2);
      return;
    }
    closeTag();
    this.bout.write("<![CDATA[");
    int i = paramInt1 + paramInt2;
    for (int j = paramInt1; j < i - 2; j++)
      if ((paramArrayOfChar[j] == ']') && (paramArrayOfChar[(j + 1)] == ']') && (paramArrayOfChar[(j + 2)] == '>'))
      {
        if (j > paramInt1)
          this.bout.write(paramArrayOfChar, paramInt1, j - paramInt1);
        print("]]]><![CDATA[]>");
        paramInt1 = j + 3;
        paramInt2 = i - paramInt1;
        j += 2;
      }
    this.bout.write(paramArrayOfChar, paramInt1, paramInt2);
    this.bout.write("]]>");
    this.prev = 62;
  }

  public void writeComment(String paramString)
  {
    beginComment();
    write(paramString);
    endComment();
  }

  public void writeComment(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    beginComment();
    write(paramArrayOfChar, paramInt1, paramInt2);
    endComment();
  }

  public void writeDouble(double paramDouble)
  {
    startWord();
    this.bout.write(formatDouble(paramDouble));
  }

  public void writeFloat(float paramFloat)
  {
    startWord();
    this.bout.write(formatFloat(paramFloat));
  }

  public void writeObject(Object paramObject)
  {
    if ((paramObject instanceof SeqPosition))
    {
      this.bout.clearWordEnd();
      SeqPosition localSeqPosition = (SeqPosition)paramObject;
      localSeqPosition.sequence.consumeNext(localSeqPosition.ipos, this);
      if ((localSeqPosition.sequence instanceof NodeTree))
        this.prev = 45;
      return;
    }
    if (((paramObject instanceof Consumable)) && (!(paramObject instanceof UnescapedData)))
    {
      ((Consumable)paramObject).consume(this);
      return;
    }
    if ((paramObject instanceof Keyword))
    {
      startAttribute(((Keyword)paramObject).getName());
      this.prev = -6;
      return;
    }
    closeTag();
    if ((paramObject instanceof UnescapedData))
    {
      this.bout.clearWordEnd();
      this.bout.write(((UnescapedData)paramObject).getData());
      this.prev = 45;
      return;
    }
    if ((paramObject instanceof Char))
    {
      Char.print(((Char)paramObject).intValue(), this);
      return;
    }
    startWord();
    this.prev = 32;
    print(paramObject);
    writeWordEnd();
    this.prev = -2;
  }

  public void writePosition(AbstractSequence paramAbstractSequence, int paramInt)
  {
    paramAbstractSequence.consumeNext(paramInt, this);
  }

  public void writeProcessingInstruction(String paramString, char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if ("xml".equals(paramString))
      this.needXMLdecl = false;
    closeTag();
    this.bout.write("<?");
    print(paramString);
    print(' ');
    this.bout.write(paramArrayOfChar, paramInt1, paramInt2);
    this.bout.write("?>");
    this.prev = -7;
  }

  protected void writeQName(Object paramObject)
  {
    if ((paramObject instanceof Symbol))
    {
      Symbol localSymbol = (Symbol)paramObject;
      String str2 = localSymbol.getPrefix();
      if ((str2 != null) && (str2.length() > 0))
      {
        this.bout.write(str2);
        this.bout.write(58);
      }
      this.bout.write(localSymbol.getLocalPart());
      return;
    }
    PrettyWriter localPrettyWriter = this.bout;
    if (paramObject == null);
    for (String str1 = "{null name}"; ; str1 = (String)paramObject)
    {
      localPrettyWriter.write(str1);
      return;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.xml.XMLPrinter
 * JD-Core Version:    0.6.2
 */