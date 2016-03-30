package gnu.xml;

import gnu.expr.Keyword;
import gnu.kawa.sax.ContentConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.CharSeq;
import gnu.lists.Consumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.TreeList;
import gnu.lists.UnescapedData;
import gnu.lists.XConsumer;
import gnu.mapping.Symbol;
import gnu.text.Char;
import gnu.text.LineBufferedReader;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import java.util.Iterator;
import java.util.List;
import org.xml.sax.AttributeList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DocumentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class XMLFilter
  implements DocumentHandler, ContentHandler, SourceLocator, XConsumer, PositionConsumer
{
  public static final int COPY_NAMESPACES_INHERIT = 2;
  public static final int COPY_NAMESPACES_PRESERVE = 1;
  private static final int SAW_KEYWORD = 1;
  private static final int SAW_WORD = 2;
  int attrCount = -1;
  String attrLocalName;
  String attrPrefix;
  Consumer base;
  public transient int copyNamespacesMode = 1;
  String currentNamespacePrefix;
  protected int ignoringLevel;
  LineBufferedReader in;
  boolean inStartTag;
  SourceLocator locator;
  MappingInfo[] mappingTable = new MappingInfo[''];
  int mappingTableMask = this.mappingTable.length - 1;
  private SourceMessages messages;
  boolean mismatchReported;
  NamespaceBinding namespaceBindings;
  public boolean namespacePrefixes = false;
  protected int nesting;
  public Consumer out;
  int previous = 0;
  int[] startIndexes = null;
  protected int stringizingElementNesting = -1;
  protected int stringizingLevel;
  TreeList tlist;
  Object[] workStack;

  public XMLFilter(Consumer paramConsumer)
  {
    this.base = paramConsumer;
    this.out = paramConsumer;
    if ((paramConsumer instanceof NodeTree));
    for (this.tlist = ((NodeTree)paramConsumer); ; this.tlist = new TreeList())
    {
      this.namespaceBindings = NamespaceBinding.predefinedXML;
      return;
    }
  }

  public static String duplicateAttributeMessage(Symbol paramSymbol, Object paramObject)
  {
    StringBuffer localStringBuffer = new StringBuffer("duplicate attribute: ");
    String str = paramSymbol.getNamespaceURI();
    if ((str != null) && (str.length() > 0))
    {
      localStringBuffer.append('{');
      localStringBuffer.append('}');
      localStringBuffer.append(str);
    }
    localStringBuffer.append(paramSymbol.getLocalPart());
    if (paramObject != null)
    {
      localStringBuffer.append(" in <");
      localStringBuffer.append(paramObject);
      localStringBuffer.append('>');
    }
    return localStringBuffer.toString();
  }

  private void ensureSpaceInStartIndexes(int paramInt)
  {
    if (this.startIndexes == null)
      this.startIndexes = new int[20];
    while (paramInt < this.startIndexes.length)
      return;
    int[] arrayOfInt = new int[2 * this.startIndexes.length];
    System.arraycopy(this.startIndexes, 0, arrayOfInt, 0, paramInt);
    this.startIndexes = arrayOfInt;
  }

  private void ensureSpaceInWorkStack(int paramInt)
  {
    if (this.workStack == null)
      this.workStack = new Object[20];
    while (paramInt < this.workStack.length)
      return;
    Object[] arrayOfObject = new Object[2 * this.workStack.length];
    System.arraycopy(this.workStack, 0, arrayOfObject, 0, paramInt);
    this.workStack = arrayOfObject;
  }

  private NamespaceBinding mergeHelper(NamespaceBinding paramNamespaceBinding1, NamespaceBinding paramNamespaceBinding2)
  {
    if (paramNamespaceBinding2 == NamespaceBinding.predefinedXML)
      return paramNamespaceBinding1;
    NamespaceBinding localNamespaceBinding = mergeHelper(paramNamespaceBinding1, paramNamespaceBinding2.next);
    String str1 = paramNamespaceBinding2.uri;
    if (localNamespaceBinding == null)
    {
      if (str1 == null)
        return localNamespaceBinding;
      localNamespaceBinding = NamespaceBinding.predefinedXML;
    }
    String str2 = paramNamespaceBinding2.prefix;
    String str3 = localNamespaceBinding.resolve(str2);
    if (str3 == null)
    {
      if (str1 != null);
    }
    else
      while (str3.equals(str1))
        return localNamespaceBinding;
    return findNamespaceBinding(str2, str1, localNamespaceBinding);
  }

  private String resolve(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramString == null))
      return "";
    String str = this.namespaceBindings.resolve(paramString);
    if (str != null)
      return str;
    if (paramString != null)
      error('e', "unknown namespace prefix '" + paramString + '\'');
    return "";
  }

  private boolean startAttributeCommon()
  {
    if (this.stringizingElementNesting >= 0)
      this.ignoringLevel = (1 + this.ignoringLevel);
    int i = this.stringizingLevel;
    this.stringizingLevel = (i + 1);
    if (i > 0)
      return false;
    if (this.attrCount < 0)
      this.attrCount = 0;
    ensureSpaceInWorkStack(this.nesting + this.attrCount);
    ensureSpaceInStartIndexes(this.attrCount);
    this.startIndexes[this.attrCount] = this.tlist.gapStart;
    this.attrCount = (1 + this.attrCount);
    return true;
  }

  public XMLFilter append(char paramChar)
  {
    write(paramChar);
    return this;
  }

  public XMLFilter append(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      paramCharSequence = "null";
    append(paramCharSequence, 0, paramCharSequence.length());
    return this;
  }

  public XMLFilter append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramCharSequence == null)
      paramCharSequence = "null";
    write(paramCharSequence, paramInt1, paramInt2 - paramInt1);
    return this;
  }

  public void beginEntity(Object paramObject)
  {
    if ((this.base instanceof XConsumer))
      ((XConsumer)this.base).beginEntity(paramObject);
  }

  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    write(paramArrayOfChar, paramInt1, paramInt2);
  }

  protected void checkValidComment(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    int k;
    for (int j = 1; ; j = k)
    {
      i--;
      if (i >= 0)
        if (paramArrayOfChar[(paramInt1 + i)] != '-')
          break label47;
      label47: for (k = 1; (j != 0) && (k != 0); k = 0)
      {
        error('e', "consecutive or final hyphen in XML comment");
        return;
      }
    }
  }

  protected boolean checkWriteAtomic()
  {
    this.previous = 0;
    if (this.ignoringLevel > 0)
      return false;
    closeStartTag();
    return true;
  }

  void closeStartTag()
  {
    if ((this.attrCount < 0) || (this.stringizingLevel > 0))
      return;
    this.inStartTag = false;
    this.previous = 0;
    if (this.attrLocalName != null)
      endAttribute();
    if (this.nesting == 0);
    NamespaceBinding localNamespaceBinding2;
    int i;
    Symbol localSymbol7;
    String str9;
    String str10;
    for (NamespaceBinding localNamespaceBinding1 = NamespaceBinding.predefinedXML; ; localNamespaceBinding1 = (NamespaceBinding)this.workStack[(this.nesting - 2)])
    {
      localNamespaceBinding2 = this.namespaceBindings;
      for (i = 0; ; i++)
      {
        int j = this.attrCount;
        if (i > j)
          break label400;
        Object localObject6 = this.workStack[(i + this.nesting - 1)];
        if ((localObject6 instanceof Symbol))
        {
          localSymbol7 = (Symbol)localObject6;
          str9 = localSymbol7.getPrefix();
          if (str9 == "")
            str9 = null;
          str10 = localSymbol7.getNamespaceURI();
          if (str10 == "")
            str10 = null;
          if ((i <= 0) || (str9 != null) || (str10 != null))
            break;
        }
      }
    }
    int i10 = 0;
    for (NamespaceBinding localNamespaceBinding3 = localNamespaceBinding2; ; localNamespaceBinding3 = localNamespaceBinding3.next)
    {
      if (localNamespaceBinding3 == localNamespaceBinding1)
        i10 = 1;
      if (localNamespaceBinding3 == null)
      {
        if ((str9 == null) && (str10 == null))
          break;
        localNamespaceBinding2 = findNamespaceBinding(str9, str10, localNamespaceBinding2);
        break;
      }
      if (localNamespaceBinding3.prefix == str9)
      {
        if (localNamespaceBinding3.uri == str10)
          break;
        if (i10 != 0)
        {
          localNamespaceBinding2 = findNamespaceBinding(str9, str10, localNamespaceBinding2);
          break;
        }
        label260: label380: for (NamespaceBinding localNamespaceBinding4 = localNamespaceBinding2; ; localNamespaceBinding4 = localNamespaceBinding4.next)
        {
          int i11;
          String str11;
          if (localNamespaceBinding4 == null)
          {
            i11 = 1;
            str11 = ("_ns_" + i11).intern();
            if (localNamespaceBinding2.resolve(str11) != null);
          }
          do
          {
            localNamespaceBinding2 = findNamespaceBinding(str11, str10, localNamespaceBinding2);
            String str12 = localSymbol7.getLocalName();
            if (str10 == null)
              str10 = "";
            this.workStack[(i + this.nesting - 1)] = Symbol.make(str10, str12, str11);
            break;
            i11++;
            break label260;
            if (localNamespaceBinding4.uri != str10)
              break label380;
            str11 = localNamespaceBinding4.prefix;
          }
          while (localNamespaceBinding2.resolve(str11) == str10);
        }
      }
    }
    label400: int k = 0;
    int m = this.attrCount;
    if (k <= m)
    {
      Object localObject1 = this.workStack[(k + this.nesting - 1)];
      MappingInfo localMappingInfo1;
      String str1;
      String str2;
      int i2;
      String str3;
      int i3;
      MappingInfo localMappingInfo2;
      label665: label681: int i5;
      label684: Object localObject4;
      if (((localObject1 instanceof MappingInfo)) || (this.out == this.tlist))
        if ((localObject1 instanceof MappingInfo))
        {
          localMappingInfo1 = (MappingInfo)localObject1;
          str1 = localMappingInfo1.prefix;
          str2 = localMappingInfo1.local;
          if ((k > 0) && (((str1 == null) && (str2 == "xmlns")) || (str1 == "xmlns")))
          {
            i2 = 1;
            str3 = "(namespace-node)";
            i3 = localMappingInfo1.tagHash;
            int i4 = i3 & this.mappingTableMask;
            localMappingInfo2 = this.mappingTable[i4];
            if (localMappingInfo2 != null)
              break label872;
            localMappingInfo2 = new MappingInfo();
            localMappingInfo2.tagHash = i3;
            String str4 = str1;
            localMappingInfo2.prefix = str4;
            localMappingInfo2.local = str2;
            MappingInfo localMappingInfo3 = this.mappingTable[i4];
            localMappingInfo2.nextInBucket = localMappingInfo3;
            this.mappingTable[i4] = localMappingInfo2;
            String str5 = str3;
            localMappingInfo2.uri = str5;
            Symbol localSymbol2 = Symbol.make(str3, str2, str1);
            localMappingInfo2.qname = localSymbol2;
            if (k == 0)
            {
              XName localXName1 = new XName(localMappingInfo2.qname, localNamespaceBinding2);
              localMappingInfo2.type = localXName1;
              localMappingInfo2.namespaces = localNamespaceBinding2;
            }
            this.workStack[(k + this.nesting - 1)] = localMappingInfo2;
            i5 = 1;
            if (i5 >= k)
              break label1113;
            localObject4 = this.workStack[(i5 + this.nesting - 1)];
            if (!(localObject4 instanceof Symbol))
              break label1092;
          }
        }
      label1024: label1053: label1092: for (Symbol localSymbol3 = (Symbol)localObject4; ; localSymbol3 = ((MappingInfo)localObject4).qname)
      {
        String str6 = localSymbol3.getLocalPart();
        if (str2 == str6)
        {
          String str7 = localSymbol3.getNamespaceURI();
          if (str3 == str7)
          {
            Object localObject5 = this.workStack[(this.nesting - 1)];
            if ((localObject5 instanceof MappingInfo))
              localObject5 = ((MappingInfo)localObject5).qname;
            error('e', duplicateAttributeMessage(localSymbol3, localObject5));
          }
        }
        label872: 
        do
        {
          i5++;
          break label684;
          if (k > 0);
          for (boolean bool = true; ; bool = false)
          {
            str3 = resolve(str1, bool);
            i2 = 0;
            break;
          }
          Symbol localSymbol1 = (Symbol)localObject1;
          localMappingInfo1 = lookupTag(localSymbol1);
          str1 = localMappingInfo1.prefix;
          str2 = localMappingInfo1.local;
          str3 = localSymbol1.getNamespaceURI();
          i2 = 0;
          break;
          if ((localMappingInfo2.tagHash == i3) && (localMappingInfo2.local == str2) && (localMappingInfo2.prefix == str1))
            if (localMappingInfo2.uri == null)
            {
              String str8 = str3;
              localMappingInfo2.uri = str8;
              Symbol localSymbol5 = Symbol.make(str3, str2, str1);
              localMappingInfo2.qname = localSymbol5;
            }
          while (true)
          {
            if (k != 0)
              break label1053;
            if ((localMappingInfo2.namespaces == localNamespaceBinding2) || (localMappingInfo2.namespaces == null))
            {
              XName localXName2 = localMappingInfo2.type;
              localMappingInfo2.namespaces = localNamespaceBinding2;
              if (localXName2 != null)
                break label665;
              XName localXName3 = new XName(localMappingInfo2.qname, localNamespaceBinding2);
              localMappingInfo2.type = localXName3;
              break label665;
              if (localMappingInfo2.uri == str3)
                break label1024;
            }
            localMappingInfo2 = localMappingInfo2.nextInBucket;
            break;
            if (localMappingInfo2.qname == null)
            {
              Symbol localSymbol4 = Symbol.make(str3, str2, str1);
              localMappingInfo2.qname = localSymbol4;
            }
          }
          break label665;
          Symbol localSymbol6 = (Symbol)localObject1;
          str3 = localSymbol6.getNamespaceURI();
          str2 = localSymbol6.getLocalName();
          localMappingInfo2 = null;
          i2 = 0;
          break label681;
        }
        while (!(localObject4 instanceof MappingInfo));
      }
      label1113: Object localObject3;
      label1136: int i9;
      if (this.out == this.tlist)
        if (k == 0)
        {
          localObject3 = localMappingInfo2.type;
          i9 = localMappingInfo2.index;
          if ((i9 <= 0) || (this.tlist.objects[i9] != localObject3))
          {
            i9 = this.tlist.find(localObject3);
            localMappingInfo2.index = i9;
          }
          if (k != 0)
            break label1218;
          this.tlist.setElementName(this.tlist.gapEnd, i9);
        }
      label1218: Object localObject2;
      label1304: 
      do
      {
        while (true)
        {
          k++;
          break;
          localObject3 = localMappingInfo2.qname;
          break label1136;
          if ((i2 == 0) || (this.namespacePrefixes))
            this.tlist.setAttributeName(this.startIndexes[(k - 1)], i9);
        }
        if (localMappingInfo2 == null)
          localObject2 = localObject1;
        while (true)
        {
          if (k != 0)
            break label1304;
          this.out.startElement(localObject2);
          break;
          if (k == 0)
            localObject2 = localMappingInfo2.type;
          else
            localObject2 = localMappingInfo2.qname;
        }
      }
      while ((i2 != 0) && (!this.namespacePrefixes));
      this.out.startAttribute(localObject2);
      int i6 = this.startIndexes[(k - 1)];
      int i7 = this.attrCount;
      if (k < i7);
      for (int i8 = this.startIndexes[k]; ; i8 = this.tlist.gapStart)
      {
        this.tlist.consumeIRange(i6 + 5, i8 - 1, this.out);
        this.out.endAttribute();
        break;
      }
    }
    if ((this.out instanceof ContentConsumer))
      ((ContentConsumer)this.out).endStartTag();
    for (int n = 1; ; n++)
    {
      int i1 = this.attrCount;
      if (n > i1)
        break;
      this.workStack[(n + this.nesting - 1)] = null;
    }
    if (this.out != this.tlist)
    {
      this.base = this.out;
      this.tlist.clear();
    }
    this.attrCount = -1;
  }

  public void commentFromParser(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.stringizingLevel == 0)
    {
      closeStartTag();
      if ((this.base instanceof XConsumer))
        ((XConsumer)this.base).writeComment(paramArrayOfChar, paramInt1, paramInt2);
    }
    while (this.stringizingElementNesting >= 0)
      return;
    this.base.write(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void consume(SeqPosition paramSeqPosition)
  {
    writePosition(paramSeqPosition.sequence, paramSeqPosition.ipos);
  }

  public void emitCharacterReference(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 65536)
    {
      Char.print(paramInt1, this);
      return;
    }
    write(paramInt1);
  }

  public void emitDoctypeDecl(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  public void emitEndAttributes()
  {
    if (this.attrLocalName != null)
      endAttribute();
    closeStartTag();
  }

  public void emitEndElement(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.attrLocalName != null)
    {
      error('e', "unclosed attribute");
      endAttribute();
    }
    if (!inElement())
      error('e', "unmatched end element");
    do
    {
      return;
      if (paramArrayOfChar != null)
      {
        MappingInfo localMappingInfo1 = lookupTag(paramArrayOfChar, paramInt1, paramInt2);
        Object localObject = this.workStack[(this.nesting - 1)];
        if (((localObject instanceof MappingInfo)) && (!this.mismatchReported))
        {
          MappingInfo localMappingInfo2 = (MappingInfo)localObject;
          if ((localMappingInfo1.local != localMappingInfo2.local) || (localMappingInfo1.prefix != localMappingInfo2.prefix))
          {
            StringBuffer localStringBuffer = new StringBuffer("</");
            localStringBuffer.append(paramArrayOfChar, paramInt1, paramInt2);
            localStringBuffer.append("> matching <");
            String str = localMappingInfo2.prefix;
            if (str != null)
            {
              localStringBuffer.append(str);
              localStringBuffer.append(':');
            }
            localStringBuffer.append(localMappingInfo2.local);
            localStringBuffer.append('>');
            error('e', localStringBuffer.toString());
            this.mismatchReported = true;
          }
        }
      }
      closeStartTag();
    }
    while (this.nesting <= 0);
    endElement();
  }

  public void emitEntityReference(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfChar[paramInt1];
    int j = 63;
    if ((paramInt2 == 2) && (paramArrayOfChar[(paramInt1 + 1)] == 't'))
      if (i == 108)
        j = 60;
    while (true)
    {
      write(j);
      return;
      if (i == 103)
      {
        j = 62;
        continue;
        if (paramInt2 == 3)
        {
          if ((i == 97) && (paramArrayOfChar[(paramInt1 + 1)] == 'm') && (paramArrayOfChar[(paramInt1 + 2)] == 'p'))
            j = 38;
        }
        else if (paramInt2 == 4)
        {
          int k = paramArrayOfChar[(paramInt1 + 1)];
          int m = paramArrayOfChar[(paramInt1 + 2)];
          int n = paramArrayOfChar[(paramInt1 + 3)];
          if ((i == 113) && (k == 117) && (m == 111) && (n == 116))
            j = 34;
          else if ((i == 97) && (k == 112) && (m == 111) && (n == 115))
            j = 39;
        }
      }
    }
  }

  public void emitStartAttribute(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.attrLocalName != null)
      endAttribute();
    if (!startAttributeCommon());
    while (true)
    {
      return;
      MappingInfo localMappingInfo = lookupTag(paramArrayOfChar, paramInt1, paramInt2);
      this.workStack[(this.nesting + this.attrCount - 1)] = localMappingInfo;
      String str1 = localMappingInfo.prefix;
      String str2 = localMappingInfo.local;
      this.attrLocalName = str2;
      this.attrPrefix = str1;
      if (str1 != null)
        if (str1 != "xmlns");
      for (this.currentNamespacePrefix = str2; (this.currentNamespacePrefix == null) || (this.namespacePrefixes); this.currentNamespacePrefix = "")
      {
        label91: this.tlist.startAttribute(0);
        return;
        if ((str2 != "xmlns") || (str1 != null))
          break label91;
      }
    }
  }

  public void emitStartElement(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    closeStartTag();
    MappingInfo localMappingInfo = lookupTag(paramArrayOfChar, paramInt1, paramInt2);
    startElementCommon();
    ensureSpaceInWorkStack(this.nesting - 1);
    this.workStack[(this.nesting - 1)] = localMappingInfo;
  }

  public void endAttribute()
  {
    if (this.attrLocalName == null);
    int i5;
    int i6;
    char[] arrayOfChar2;
    int i7;
    label119: 
    do
    {
      int i;
      do
      {
        return;
        if (this.previous == 1)
        {
          this.previous = 0;
          return;
        }
        if (this.stringizingElementNesting >= 0)
          this.ignoringLevel -= 1;
        i = this.stringizingLevel - 1;
        this.stringizingLevel = i;
      }
      while (i != 0);
      if ((this.attrLocalName == "id") && (this.attrPrefix == "xml"))
      {
        i5 = 5 + this.startIndexes[(this.attrCount - 1)];
        i6 = this.tlist.gapStart;
        arrayOfChar2 = this.tlist.data;
        i7 = i5;
        if (i7 < i6)
          break;
      }
      this.attrLocalName = null;
      this.attrPrefix = null;
      if ((this.currentNamespacePrefix == null) || (this.namespacePrefixes))
        this.tlist.endAttribute();
    }
    while (this.currentNamespacePrefix == null);
    int j = this.startIndexes[(this.attrCount - 1)];
    int k = j;
    int m = this.tlist.gapStart;
    int n = m - k;
    char[] arrayOfChar1 = this.tlist.data;
    int i1 = 0;
    int i2 = k;
    label201: int i3;
    if (i2 < m)
    {
      i3 = arrayOfChar1[i2];
      if ((0xFFFF & i3) > 40959)
      {
        StringBuffer localStringBuffer1 = new StringBuffer();
        this.tlist.stringValue(k, m, localStringBuffer1);
        i1 = localStringBuffer1.hashCode();
        k = 0;
        n = localStringBuffer1.length();
        int i4 = n;
        arrayOfChar1 = new char[localStringBuffer1.length()];
        localStringBuffer1.getChars(0, i4, arrayOfChar1, 0);
      }
    }
    else
    {
      this.tlist.gapStart = j;
      if (this.currentNamespacePrefix != "")
        break label481;
    }
    label481: for (String str = null; ; str = this.currentNamespacePrefix)
    {
      this.namespaceBindings = lookupNamespaceBinding(str, arrayOfChar1, k, n, i1, this.namespaceBindings).namespaces;
      this.currentNamespacePrefix = null;
      return;
      int i8 = i7 + 1;
      int i9 = arrayOfChar2[i7];
      if (((0xFFFF & i9) > 40959) || (i9 == 9) || (i9 == 13) || (i9 == 10) || ((i9 == 32) && ((i8 == i6) || (arrayOfChar2[i8] == ' '))))
      {
        StringBuffer localStringBuffer2 = new StringBuffer();
        this.tlist.stringValue(i5, i6, localStringBuffer2);
        this.tlist.gapStart = i5;
        this.tlist.write(TextUtils.replaceWhitespace(localStringBuffer2.toString(), true));
        break label119;
      }
      i7 = i8;
      break;
      i1 = i3 + i1 * 31;
      i2++;
      break label201;
    }
  }

  public void endDocument()
  {
    if (this.stringizingLevel > 0)
    {
      writeJoiner();
      return;
    }
    this.nesting -= 2;
    this.namespaceBindings = ((NamespaceBinding)this.workStack[this.nesting]);
    this.workStack[this.nesting] = null;
    this.workStack[(1 + this.nesting)] = null;
    if (this.nesting == 0)
    {
      this.base.endDocument();
      return;
    }
    writeJoiner();
  }

  public void endElement()
  {
    closeStartTag();
    this.nesting -= 2;
    this.previous = 0;
    if (this.stringizingLevel == 0)
    {
      this.namespaceBindings = ((NamespaceBinding)this.workStack[this.nesting]);
      this.workStack[this.nesting] = null;
      this.workStack[(1 + this.nesting)] = null;
      this.base.endElement();
    }
    while (this.stringizingElementNesting != this.nesting)
      return;
    this.stringizingElementNesting = -1;
    this.previous = 2;
  }

  public void endElement(String paramString)
    throws SAXException
  {
    endElement();
  }

  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    endElement();
  }

  public void endEntity()
  {
    if ((this.base instanceof XConsumer))
      ((XConsumer)this.base).endEntity();
  }

  public void endPrefixMapping(String paramString)
  {
    this.namespaceBindings = this.namespaceBindings.getNext();
  }

  public void error(char paramChar, String paramString)
  {
    if (this.messages == null)
      throw new RuntimeException(paramString);
    if (this.locator != null)
    {
      this.messages.error(paramChar, this.locator, paramString);
      return;
    }
    this.messages.error(paramChar, paramString);
  }

  public NamespaceBinding findNamespaceBinding(String paramString1, String paramString2, NamespaceBinding paramNamespaceBinding)
  {
    int i;
    int j;
    if (paramString2 == null)
    {
      i = 0;
      if (paramString1 != null)
        i ^= paramString1.hashCode();
      j = i & this.mappingTableMask;
    }
    for (MappingInfo localMappingInfo1 = this.mappingTable[j]; ; localMappingInfo1 = localMappingInfo1.nextInBucket)
    {
      if (localMappingInfo1 == null)
      {
        MappingInfo localMappingInfo2 = new MappingInfo();
        localMappingInfo2.nextInBucket = this.mappingTable[j];
        this.mappingTable[j] = localMappingInfo2;
        localMappingInfo2.tagHash = i;
        localMappingInfo2.prefix = paramString1;
        localMappingInfo2.local = paramString2;
        localMappingInfo2.uri = paramString2;
        if (paramString2 == "")
          paramString2 = null;
        localMappingInfo2.namespaces = new NamespaceBinding(paramString1, paramString2, paramNamespaceBinding);
        return localMappingInfo2.namespaces;
        i = paramString2.hashCode();
        break;
      }
      if ((localMappingInfo1.tagHash == i) && (localMappingInfo1.prefix == paramString1))
      {
        NamespaceBinding localNamespaceBinding = localMappingInfo1.namespaces;
        if ((localNamespaceBinding != null) && (localNamespaceBinding.getNext() == this.namespaceBindings) && (localNamespaceBinding.getPrefix() == paramString1) && (localMappingInfo1.uri == paramString2))
          return localMappingInfo1.namespaces;
      }
    }
  }

  public int getColumnNumber()
  {
    if (this.in != null)
    {
      int i = this.in.getColumnNumber();
      if (i > 0)
        return i;
    }
    return -1;
  }

  public String getFileName()
  {
    if (this.in == null)
      return null;
    return this.in.getName();
  }

  public int getLineNumber()
  {
    if (this.in == null)
      return -1;
    int i = this.in.getLineNumber();
    if (i < 0)
      return -1;
    return i + 1;
  }

  public String getPublicId()
  {
    return null;
  }

  public String getSystemId()
  {
    if (this.in == null)
      return null;
    return this.in.getName();
  }

  public void ignorableWhitespace(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    write(paramArrayOfChar, paramInt1, paramInt2);
  }

  public boolean ignoring()
  {
    return this.ignoringLevel > 0;
  }

  final boolean inElement()
  {
    for (int i = this.nesting; (i > 0) && (this.workStack[(i - 1)] == null); i -= 2);
    return i != 0;
  }

  public boolean isStableSourceLocation()
  {
    return false;
  }

  public void linefeedFromParser()
  {
    if ((inElement()) && (checkWriteAtomic()))
      this.base.write(10);
  }

  public MappingInfo lookupNamespaceBinding(String paramString, char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, NamespaceBinding paramNamespaceBinding)
  {
    int i;
    int j;
    if (paramString == null)
    {
      i = paramInt3;
      j = i & this.mappingTableMask;
    }
    for (MappingInfo localMappingInfo1 = this.mappingTable[j]; ; localMappingInfo1 = localMappingInfo1.nextInBucket)
    {
      if (localMappingInfo1 == null)
      {
        MappingInfo localMappingInfo2 = new MappingInfo();
        localMappingInfo2.nextInBucket = this.mappingTable[j];
        this.mappingTable[j] = localMappingInfo2;
        String str = new String(paramArrayOfChar, paramInt1, paramInt2).intern();
        localMappingInfo2.tagHash = i;
        localMappingInfo2.prefix = paramString;
        localMappingInfo2.local = str;
        localMappingInfo2.uri = str;
        if (str == "")
          str = null;
        localMappingInfo2.namespaces = new NamespaceBinding(paramString, str, paramNamespaceBinding);
        return localMappingInfo2;
        i = paramInt3 ^ paramString.hashCode();
        break;
      }
      if ((localMappingInfo1.tagHash == i) && (localMappingInfo1.prefix == paramString))
      {
        NamespaceBinding localNamespaceBinding = localMappingInfo1.namespaces;
        if ((localNamespaceBinding != null) && (localNamespaceBinding.getNext() == this.namespaceBindings) && (localNamespaceBinding.getPrefix() == paramString) && (MappingInfo.equals(localMappingInfo1.uri, paramArrayOfChar, paramInt1, paramInt2)))
          return localMappingInfo1;
      }
    }
  }

  MappingInfo lookupTag(Symbol paramSymbol)
  {
    String str1 = paramSymbol.getLocalPart();
    String str2 = paramSymbol.getPrefix();
    if (str2 == "")
      str2 = null;
    String str3 = paramSymbol.getNamespaceURI();
    int i = MappingInfo.hash(str2, str1);
    int j = i & this.mappingTableMask;
    MappingInfo localMappingInfo1 = this.mappingTable[j];
    for (MappingInfo localMappingInfo2 = localMappingInfo1; ; localMappingInfo2 = localMappingInfo2.nextInBucket)
    {
      if (localMappingInfo2 == null)
      {
        MappingInfo localMappingInfo3 = new MappingInfo();
        localMappingInfo3.qname = paramSymbol;
        localMappingInfo3.prefix = str2;
        localMappingInfo3.uri = str3;
        localMappingInfo3.local = str1;
        localMappingInfo3.tagHash = i;
        localMappingInfo3.nextInBucket = localMappingInfo1;
        this.mappingTable[j] = localMappingInfo1;
        return localMappingInfo3;
      }
      if (paramSymbol == localMappingInfo2.qname)
        return localMappingInfo2;
      if ((str1 == localMappingInfo2.local) && (localMappingInfo2.qname == null) && ((str3 == localMappingInfo2.uri) || (localMappingInfo2.uri == null)) && (str2 == localMappingInfo2.prefix))
      {
        localMappingInfo2.uri = str3;
        localMappingInfo2.qname = paramSymbol;
        return localMappingInfo2;
      }
    }
  }

  MappingInfo lookupTag(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    int k = -1;
    int m = 0;
    if (m < paramInt2)
    {
      int i3 = paramArrayOfChar[(paramInt1 + m)];
      if ((i3 == 58) && (k < 0))
      {
        k = m;
        j = i;
      }
      for (i = 0; ; i = i3 + i * 31)
      {
        m++;
        break;
      }
    }
    int n = i ^ j;
    int i1 = n & this.mappingTableMask;
    MappingInfo localMappingInfo1 = this.mappingTable[i1];
    for (MappingInfo localMappingInfo2 = localMappingInfo1; ; localMappingInfo2 = localMappingInfo2.nextInBucket)
    {
      if (localMappingInfo2 == null)
      {
        MappingInfo localMappingInfo3 = new MappingInfo();
        localMappingInfo3.tagHash = n;
        int i2;
        if (k >= 0)
        {
          localMappingInfo3.prefix = new String(paramArrayOfChar, paramInt1, k).intern();
          i2 = k + 1;
        }
        for (localMappingInfo3.local = new String(paramArrayOfChar, paramInt1 + i2, paramInt2 - i2).intern(); ; localMappingInfo3.local = new String(paramArrayOfChar, paramInt1, paramInt2).intern())
        {
          localMappingInfo3.nextInBucket = localMappingInfo1;
          this.mappingTable[i1] = localMappingInfo1;
          return localMappingInfo3;
          localMappingInfo3.prefix = null;
        }
      }
      if ((n == localMappingInfo2.tagHash) && (localMappingInfo2.match(paramArrayOfChar, paramInt1, paramInt2)))
        return localMappingInfo2;
    }
  }

  public void processingInstruction(String paramString1, String paramString2)
  {
    char[] arrayOfChar = paramString2.toCharArray();
    processingInstructionCommon(paramString1, arrayOfChar, 0, arrayOfChar.length);
  }

  void processingInstructionCommon(String paramString, char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.stringizingLevel == 0)
    {
      closeStartTag();
      if ((this.base instanceof XConsumer))
        ((XConsumer)this.base).writeProcessingInstruction(paramString, paramArrayOfChar, paramInt1, paramInt2);
    }
    while (this.stringizingElementNesting >= 0)
      return;
    this.base.write(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void processingInstructionFromParser(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 == 3) && (!inElement()) && (paramArrayOfChar[paramInt1] == 'x') && (paramArrayOfChar[(paramInt1 + 1)] == 'm') && (paramArrayOfChar[(paramInt1 + 2)] == 'l'))
      return;
    processingInstructionCommon(new String(paramArrayOfChar, paramInt1, paramInt2), paramArrayOfChar, paramInt3, paramInt4);
  }

  public void setDocumentLocator(Locator paramLocator)
  {
    if ((paramLocator instanceof SourceLocator))
      this.locator = ((SourceLocator)paramLocator);
  }

  public void setMessages(SourceMessages paramSourceMessages)
  {
    this.messages = paramSourceMessages;
  }

  public void setSourceLocator(LineBufferedReader paramLineBufferedReader)
  {
    this.in = paramLineBufferedReader;
    this.locator = this;
  }

  public void setSourceLocator(SourceLocator paramSourceLocator)
  {
    this.locator = paramSourceLocator;
  }

  public void skippedEntity(String paramString)
  {
  }

  public void startAttribute(Object paramObject)
  {
    this.previous = 0;
    if ((paramObject instanceof Symbol))
    {
      Symbol localSymbol = (Symbol)paramObject;
      String str1 = localSymbol.getLocalPart();
      this.attrLocalName = str1;
      this.attrPrefix = localSymbol.getPrefix();
      String str2 = localSymbol.getNamespaceURI();
      if ((str2 == "http://www.w3.org/2000/xmlns/") || ((str2 == "") && (str1 == "xmlns")))
        error('e', "arttribute name cannot be 'xmlns' or in xmlns namespace");
    }
    if ((this.nesting == 2) && (this.workStack[1] == null))
      error('e', "attribute not allowed at document level");
    if ((this.attrCount < 0) && (this.nesting > 0))
      error('e', "attribute '" + paramObject + "' follows non-attribute content");
    if (!startAttributeCommon())
      return;
    this.workStack[(this.nesting + this.attrCount - 1)] = paramObject;
    if (this.nesting == 0)
    {
      this.base.startAttribute(paramObject);
      return;
    }
    this.tlist.startAttribute(0);
  }

  public void startDocument()
  {
    closeStartTag();
    if (this.stringizingLevel > 0)
    {
      writeJoiner();
      return;
    }
    if (this.nesting == 0)
      this.base.startDocument();
    while (true)
    {
      ensureSpaceInWorkStack(this.nesting);
      this.workStack[this.nesting] = this.namespaceBindings;
      this.workStack[(1 + this.nesting)] = null;
      this.nesting = (2 + this.nesting);
      return;
      writeJoiner();
    }
  }

  public void startElement(Object paramObject)
  {
    startElementCommon();
    if (this.stringizingLevel == 0)
    {
      ensureSpaceInWorkStack(this.nesting - 1);
      this.workStack[(this.nesting - 1)] = paramObject;
      if (this.copyNamespacesMode == 0)
        this.namespaceBindings = NamespaceBinding.predefinedXML;
    }
    else
    {
      return;
    }
    if ((this.copyNamespacesMode == 1) || (this.nesting == 2))
    {
      if ((paramObject instanceof XName));
      for (NamespaceBinding localNamespaceBinding1 = ((XName)paramObject).getNamespaceNodes(); ; localNamespaceBinding1 = NamespaceBinding.predefinedXML)
      {
        this.namespaceBindings = localNamespaceBinding1;
        return;
      }
    }
    int i = 2;
    NamespaceBinding localNamespaceBinding2;
    if (i == this.nesting)
    {
      localNamespaceBinding2 = null;
      label105: if (localNamespaceBinding2 != null)
        break label172;
      if (!(paramObject instanceof XName))
        break label164;
    }
    label164: for (NamespaceBinding localNamespaceBinding4 = ((XName)paramObject).getNamespaceNodes(); ; localNamespaceBinding4 = NamespaceBinding.predefinedXML)
    {
      this.namespaceBindings = localNamespaceBinding4;
      return;
      if (this.workStack[(i + 1)] != null)
      {
        localNamespaceBinding2 = (NamespaceBinding)this.workStack[i];
        break label105;
      }
      i += 2;
      break;
    }
    label172: if (this.copyNamespacesMode == 2)
    {
      this.namespaceBindings = localNamespaceBinding2;
      return;
    }
    if ((paramObject instanceof XName))
    {
      NamespaceBinding localNamespaceBinding3 = ((XName)paramObject).getNamespaceNodes();
      if (NamespaceBinding.commonAncestor(localNamespaceBinding2, localNamespaceBinding3) == localNamespaceBinding2)
      {
        this.namespaceBindings = localNamespaceBinding3;
        return;
      }
      this.namespaceBindings = mergeHelper(localNamespaceBinding2, localNamespaceBinding3);
      return;
    }
    this.namespaceBindings = localNamespaceBinding2;
  }

  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    startElement(Symbol.make(paramString1, paramString2));
    int i = paramAttributes.getLength();
    for (int j = 0; j < i; j++)
    {
      startAttribute(Symbol.make(paramAttributes.getURI(j), paramAttributes.getLocalName(j)));
      write(paramAttributes.getValue(j));
      endAttribute();
    }
  }

  public void startElement(String paramString, AttributeList paramAttributeList)
  {
    startElement(paramString.intern());
    int i = paramAttributeList.getLength();
    for (int j = 0; j < i; j++)
    {
      String str1 = paramAttributeList.getName(j).intern();
      paramAttributeList.getType(j);
      String str2 = paramAttributeList.getValue(j);
      startAttribute(str1);
      write(str2);
      endAttribute();
    }
  }

  protected void startElementCommon()
  {
    closeStartTag();
    if (this.stringizingLevel == 0)
    {
      ensureSpaceInWorkStack(this.nesting);
      this.workStack[this.nesting] = this.namespaceBindings;
      this.tlist.startElement(0);
      this.base = this.tlist;
      this.attrCount = 0;
    }
    while (true)
    {
      this.nesting = (2 + this.nesting);
      return;
      if ((this.previous == 2) && (this.stringizingElementNesting < 0))
        write(32);
      this.previous = 0;
      if (this.stringizingElementNesting < 0)
        this.stringizingElementNesting = this.nesting;
    }
  }

  public void startPrefixMapping(String paramString1, String paramString2)
  {
    this.namespaceBindings = findNamespaceBinding(paramString1.intern(), paramString2.intern(), this.namespaceBindings);
  }

  public void textFromParser(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (!inElement())
    {
      i = 0;
      if (i != paramInt2);
    }
    while ((paramInt2 <= 0) || (!checkWriteAtomic()))
      while (true)
      {
        int i;
        return;
        if (!Character.isWhitespace(paramArrayOfChar[(paramInt1 + i)]))
        {
          error('e', "text at document level");
          return;
        }
        i++;
      }
    this.base.write(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void write(int paramInt)
  {
    if (checkWriteAtomic())
      this.base.write(paramInt);
  }

  public void write(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      writeJoiner();
    while (!checkWriteAtomic())
      return;
    this.base.write(paramCharSequence, paramInt1, paramInt2);
  }

  public void write(String paramString)
  {
    write(paramString, 0, paramString.length());
  }

  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      writeJoiner();
    while (!checkWriteAtomic())
      return;
    this.base.write(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void writeBoolean(boolean paramBoolean)
  {
    if (checkWriteAtomic())
      this.base.writeBoolean(paramBoolean);
  }

  public void writeCDATA(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (checkWriteAtomic())
    {
      if ((this.base instanceof XConsumer))
        ((XConsumer)this.base).writeCDATA(paramArrayOfChar, paramInt1, paramInt2);
    }
    else
      return;
    write(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void writeComment(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    checkValidComment(paramArrayOfChar, paramInt1, paramInt2);
    commentFromParser(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void writeDocumentUri(Object paramObject)
  {
    if ((this.nesting == 2) && ((this.base instanceof TreeList)))
      ((TreeList)this.base).writeDocumentUri(paramObject);
  }

  public void writeDouble(double paramDouble)
  {
    if (checkWriteAtomic())
      this.base.writeDouble(paramDouble);
  }

  public void writeFloat(float paramFloat)
  {
    if (checkWriteAtomic())
      this.base.writeFloat(paramFloat);
  }

  public void writeInt(int paramInt)
  {
    if (checkWriteAtomic())
      this.base.writeInt(paramInt);
  }

  protected void writeJoiner()
  {
    this.previous = 0;
    if (this.ignoringLevel == 0)
      ((TreeList)this.base).writeJoiner();
  }

  public void writeLong(long paramLong)
  {
    if (checkWriteAtomic())
      this.base.writeLong(paramLong);
  }

  public void writeObject(Object paramObject)
  {
    if (this.ignoringLevel > 0);
    while (true)
    {
      return;
      if ((paramObject instanceof SeqPosition))
      {
        SeqPosition localSeqPosition = (SeqPosition)paramObject;
        writePosition(localSeqPosition.sequence, localSeqPosition.getPos());
        return;
      }
      if ((paramObject instanceof TreeList))
      {
        ((TreeList)paramObject).consume(this);
        return;
      }
      if ((!(paramObject instanceof List)) || ((paramObject instanceof CharSeq)))
        break;
      Iterator localIterator = ((List)paramObject).iterator();
      for (int i = 0; localIterator.hasNext(); i++)
        writeObject(localIterator.next());
    }
    if ((paramObject instanceof Keyword))
    {
      startAttribute(((Keyword)paramObject).asSymbol());
      this.previous = 1;
      return;
    }
    closeStartTag();
    if ((paramObject instanceof UnescapedData))
    {
      this.base.writeObject(paramObject);
      this.previous = 0;
      return;
    }
    if (this.previous == 2)
      write(32);
    TextUtils.textValue(paramObject, this);
    this.previous = 2;
  }

  public void writePosition(AbstractSequence paramAbstractSequence, int paramInt)
  {
    if (this.ignoringLevel > 0);
    do
    {
      return;
      if ((this.stringizingLevel > 0) && (this.previous == 2))
      {
        if (this.stringizingElementNesting < 0)
          write(32);
        this.previous = 0;
      }
      paramAbstractSequence.consumeNext(paramInt, this);
    }
    while ((this.stringizingLevel <= 0) || (this.stringizingElementNesting >= 0));
    this.previous = 2;
  }

  public void writeProcessingInstruction(String paramString, char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    String str = TextUtils.replaceWhitespace(paramString, true);
    int i = paramInt1 + paramInt2;
    i--;
    while (true)
    {
      if (i < paramInt1)
        break label69;
      int j = paramArrayOfChar[i];
      if (j == 62)
      {
        i--;
        if (i >= paramInt1)
        {
          j = paramArrayOfChar[i];
          if (j != 63)
            break;
          error('e', "'?>' is not allowed in a processing-instruction");
        }
      }
    }
    label69: if ("xml".equalsIgnoreCase(str))
      error('e', "processing-instruction target may not be 'xml' (ignoring case)");
    if (!XName.isNCName(str))
      error('e', "processing-instruction target '" + str + "' is not a valid Name");
    processingInstructionCommon(str, paramArrayOfChar, paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.xml.XMLFilter
 * JD-Core Version:    0.6.2
 */