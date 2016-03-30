package gnu.lists;

import gnu.text.Char;
import java.io.PrintWriter;

public class TreeList extends AbstractSequence
  implements Appendable, XConsumer, PositionConsumer, Consumable
{
  protected static final int BEGIN_ATTRIBUTE_LONG = 61705;
  public static final int BEGIN_ATTRIBUTE_LONG_SIZE = 5;
  protected static final int BEGIN_DOCUMENT = 61712;
  protected static final int BEGIN_ELEMENT_LONG = 61704;
  protected static final int BEGIN_ELEMENT_SHORT = 40960;
  protected static final int BEGIN_ELEMENT_SHORT_INDEX_MAX = 4095;
  public static final int BEGIN_ENTITY = 61714;
  public static final int BEGIN_ENTITY_SIZE = 5;
  static final char BOOL_FALSE = '';
  static final char BOOL_TRUE = '';
  static final int BYTE_PREFIX = 61440;
  static final int CDATA_SECTION = 61717;
  static final int CHAR_FOLLOWS = 61702;
  static final int COMMENT = 61719;
  protected static final int DOCUMENT_URI = 61720;
  static final int DOUBLE_FOLLOWS = 61701;
  static final int END_ATTRIBUTE = 61706;
  public static final int END_ATTRIBUTE_SIZE = 1;
  protected static final int END_DOCUMENT = 61713;
  protected static final int END_ELEMENT_LONG = 61708;
  protected static final int END_ELEMENT_SHORT = 61707;
  protected static final int END_ENTITY = 61715;
  static final int FLOAT_FOLLOWS = 61700;
  public static final int INT_FOLLOWS = 61698;
  static final int INT_SHORT_ZERO = 49152;
  static final int JOINER = 61718;
  static final int LONG_FOLLOWS = 61699;
  public static final int MAX_CHAR_SHORT = 40959;
  static final int MAX_INT_SHORT = 8191;
  static final int MIN_INT_SHORT = -4096;
  static final char OBJECT_REF_FOLLOWS = '';
  static final int OBJECT_REF_SHORT = 57344;
  static final int OBJECT_REF_SHORT_INDEX_MAX = 4095;
  protected static final char POSITION_PAIR_FOLLOWS = '';
  static final char POSITION_REF_FOLLOWS = '';
  protected static final int PROCESSING_INSTRUCTION = 61716;
  public int attrStart;
  int currentParent = -1;
  public char[] data;
  public int docStart;
  public int gapEnd;
  public int gapStart;
  public Object[] objects;
  public int oindex;

  public TreeList()
  {
    resizeObjects();
    this.gapEnd = 200;
    this.data = new char[this.gapEnd];
  }

  public TreeList(TreeList paramTreeList)
  {
    this(paramTreeList, 0, paramTreeList.data.length);
  }

  public TreeList(TreeList paramTreeList, int paramInt1, int paramInt2)
  {
    this();
    paramTreeList.consumeIRange(paramInt1, paramInt2, this);
  }

  private Object copyToList(int paramInt1, int paramInt2)
  {
    return new TreeList(this, paramInt1, paramInt2);
  }

  public Consumer append(char paramChar)
  {
    write(paramChar);
    return this;
  }

  public Consumer append(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      paramCharSequence = "null";
    return append(paramCharSequence, 0, paramCharSequence.length());
  }

  public Consumer append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramCharSequence == null)
      paramCharSequence = "null";
    for (int i = paramInt1; i < paramInt2; i++)
      append(paramCharSequence.charAt(i));
    return this;
  }

  public void beginEntity(Object paramObject)
  {
    if (this.gapStart != 0)
      return;
    ensureSpace(6);
    this.gapEnd -= 1;
    int i = this.gapStart;
    this.data[i] = 61714;
    setIntN(i + 1, find(paramObject));
    int j = i + 3;
    if (this.currentParent == -1);
    for (int k = -1; ; k = this.currentParent - i)
    {
      setIntN(j, k);
      this.gapStart = (i + 5);
      this.currentParent = i;
      this.data[this.gapEnd] = 61715;
      return;
    }
  }

  public void clear()
  {
    this.gapStart = 0;
    this.gapEnd = this.data.length;
    this.attrStart = 0;
    if (this.gapEnd > 1500)
    {
      this.gapEnd = 200;
      this.data = new char[this.gapEnd];
    }
    this.objects = null;
    this.oindex = 0;
    resizeObjects();
  }

  public int compare(int paramInt1, int paramInt2)
  {
    int i = posToDataIndex(paramInt1);
    int j = posToDataIndex(paramInt2);
    if (i < j)
      return -1;
    if (i > j)
      return 1;
    return 0;
  }

  public void consume(Consumer paramConsumer)
  {
    consumeIRange(0, this.data.length, paramConsumer);
  }

  public void consume(SeqPosition paramSeqPosition)
  {
    ensureSpace(3);
    int i = find(paramSeqPosition.copy());
    char[] arrayOfChar = this.data;
    int j = this.gapStart;
    this.gapStart = (j + 1);
    arrayOfChar[j] = 61710;
    setIntN(this.gapStart, i);
    this.gapStart = (2 + this.gapStart);
  }

  public int consumeIRange(int paramInt1, int paramInt2, Consumer paramConsumer)
  {
    int i = paramInt1;
    int j;
    int k;
    int m;
    int i14;
    int i15;
    if ((paramInt1 <= this.gapStart) && (paramInt2 > this.gapStart))
    {
      j = this.gapStart;
      if (i >= j)
      {
        if ((i != this.gapStart) || (paramInt2 <= this.gapEnd))
          break label1176;
        i = this.gapEnd;
        j = paramInt2;
      }
      char[] arrayOfChar1 = this.data;
      k = i + 1;
      m = arrayOfChar1[i];
      if (m > 40959)
        break label162;
      i14 = k - 1;
      i15 = j;
    }
    while (true)
    {
      if (k >= i15);
      int i16;
      for (i = k; ; i = i16 - 1)
      {
        paramConsumer.write(this.data, i14, i - i14);
        break;
        j = paramInt2;
        break;
        char[] arrayOfChar3 = this.data;
        i16 = k + 1;
        if (arrayOfChar3[k] <= 40959)
          break label1186;
      }
      label162: if ((m >= 57344) && (m <= 61439))
      {
        paramConsumer.writeObject(this.objects[(m - 57344)]);
        i = k;
        break;
      }
      if ((m >= 40960) && (m <= 45055))
      {
        int i13 = m - 40960;
        paramConsumer.startElement(this.objects[i13]);
        i = k + 2;
        break;
      }
      if ((m >= 45056) && (m <= 57343))
      {
        paramConsumer.writeInt(m - 49152);
        i = k;
        break;
      }
      switch (m)
      {
      case 61703:
      default:
        throw new Error("unknown code:" + m);
      case 61712:
        paramConsumer.startDocument();
        i = k + 4;
        break;
      case 61713:
        paramConsumer.endDocument();
        i = k;
        break;
      case 61714:
        if ((paramConsumer instanceof TreeList))
          ((TreeList)paramConsumer).beginEntity(this.objects[getIntN(k)]);
        i = k + 4;
        break;
      case 61715:
        if ((paramConsumer instanceof TreeList))
        {
          ((TreeList)paramConsumer).endEntity();
          i = k;
        }
        break;
      case 61720:
        if ((paramConsumer instanceof TreeList))
          ((TreeList)paramConsumer).writeDocumentUri(this.objects[getIntN(k)]);
        i = k + 2;
        break;
      case 61719:
        int i11 = getIntN(k);
        int i12 = k + 2;
        if ((paramConsumer instanceof XConsumer))
          ((XConsumer)paramConsumer).writeComment(this.data, i12, i11);
        i = i12 + i11;
        break;
      case 61717:
        int i9 = getIntN(k);
        int i10 = k + 2;
        if ((paramConsumer instanceof XConsumer))
          ((XConsumer)paramConsumer).writeCDATA(this.data, i10, i9);
        while (true)
        {
          i = i10 + i9;
          break;
          paramConsumer.write(this.data, i10, i9);
        }
      case 61716:
        String str = (String)this.objects[getIntN(k)];
        int i7 = getIntN(k + 2);
        int i8 = k + 4;
        if ((paramConsumer instanceof XConsumer))
          ((XConsumer)paramConsumer).writeProcessingInstruction(str, this.data, i8, i7);
        i = i8 + i7;
        break;
      case 61696:
      case 61697:
        if (m != 61696);
        for (boolean bool = true; ; bool = false)
        {
          paramConsumer.writeBoolean(bool);
          i = k;
          break;
        }
      case 61718:
        paramConsumer.write("");
        i = k;
        break;
      case 61702:
        char[] arrayOfChar2 = this.data;
        int i6 = m + 1 - 61702;
        paramConsumer.write(arrayOfChar2, k, i6);
        i = k + 1;
        break;
      case 61711:
        AbstractSequence localAbstractSequence = (AbstractSequence)this.objects[getIntN(k)];
        int i5 = getIntN(k + 2);
        if ((paramConsumer instanceof PositionConsumer))
          ((PositionConsumer)paramConsumer).writePosition(localAbstractSequence, i5);
        while (true)
        {
          i = k + 4;
          break;
          paramConsumer.writeObject(localAbstractSequence.getIteratorAtPos(i5));
        }
      case 61710:
        if ((paramConsumer instanceof PositionConsumer))
        {
          ((PositionConsumer)paramConsumer).consume((SeqPosition)this.objects[getIntN(k)]);
          i = k + 2;
        }
        break;
      case 61709:
        paramConsumer.writeObject(this.objects[getIntN(k)]);
        i = k + 2;
        break;
      case 61707:
        i = k + 1;
        paramConsumer.endElement();
        break;
      case 61704:
        int i1 = getIntN(k);
        if (i1 >= 0);
        for (int i2 = k - 1; ; i2 = this.data.length)
        {
          int i3 = i1 + i2;
          i = k + 2;
          int i4 = getIntN(i3 + 1);
          paramConsumer.startElement(this.objects[i4]);
          break;
        }
      case 61708:
        getIntN(k);
        paramConsumer.endElement();
        i = k + 6;
        break;
      case 61705:
        int n = getIntN(k);
        paramConsumer.startAttribute(this.objects[n]);
        i = k + 4;
        break;
      case 61706:
        paramConsumer.endAttribute();
        i = k;
        break;
      case 61698:
        paramConsumer.writeInt(getIntN(k));
        i = k + 2;
        break;
      case 61700:
        paramConsumer.writeFloat(Float.intBitsToFloat(getIntN(k)));
        i = k + 2;
        break;
      case 61699:
        paramConsumer.writeLong(getLongN(k));
        i = k + 4;
        break;
      case 61701:
        paramConsumer.writeDouble(Double.longBitsToDouble(getLongN(k)));
        i = k + 4;
        break;
        label1176: return i;
        i = k;
        break;
        label1186: k = i16;
      }
    }
  }

  public boolean consumeNext(int paramInt, Consumer paramConsumer)
  {
    if (!hasNext(paramInt))
      return false;
    int i = posToDataIndex(paramInt);
    int j = nextNodeIndex(i, 2147483647);
    if (j == i)
      j = nextDataIndex(i);
    if (j >= 0)
      consumeIRange(i, j, paramConsumer);
    return true;
  }

  public void consumePosRange(int paramInt1, int paramInt2, Consumer paramConsumer)
  {
    consumeIRange(posToDataIndex(paramInt1), posToDataIndex(paramInt2), paramConsumer);
  }

  public int createPos(int paramInt, boolean paramBoolean)
  {
    return createRelativePos(0, paramInt, paramBoolean);
  }

  public int createRelativePos(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramInt2 == 0)
      {
        if ((paramInt1 & 0x1) != 0)
          return paramInt1;
        if (paramInt1 == 0)
          return 1;
      }
      paramInt2--;
    }
    if (paramInt2 < 0)
      throw unsupported("backwards createRelativePos");
    int i = posToDataIndex(paramInt1);
    do
    {
      paramInt2--;
      if (paramInt2 < 0)
        break;
      i = nextDataIndex(i);
    }
    while (i >= 0);
    throw new IndexOutOfBoundsException();
    if (i >= this.gapEnd)
      i -= this.gapEnd - this.gapStart;
    if (paramBoolean)
      return 0x1 | i + 1 << 1;
    return i << 1;
  }

  public Object documentUriOfPos(int paramInt)
  {
    int i = posToDataIndex(paramInt);
    if (i == this.data.length)
      return null;
    if (this.data[i] == 61712)
    {
      int j = i + 5;
      if (j == this.gapStart)
        j = this.gapEnd;
      if ((j < this.data.length) && (this.data[j] == 61720))
        return this.objects[getIntN(j + 1)];
    }
    return null;
  }

  public void dump()
  {
    PrintWriter localPrintWriter = new PrintWriter(System.out);
    dump(localPrintWriter);
    localPrintWriter.flush();
  }

  public void dump(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.println(getClass().getName() + " @" + Integer.toHexString(System.identityHashCode(this)) + " gapStart:" + this.gapStart + " gapEnd:" + this.gapEnd + " length:" + this.data.length);
    dump(paramPrintWriter, 0, this.data.length);
  }

  public void dump(PrintWriter paramPrintWriter, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramInt1;
    if (j < paramInt2)
    {
      int k;
      if ((j < this.gapStart) || (j >= this.gapEnd))
      {
        k = this.data[j];
        paramPrintWriter.print("" + j + ": 0x" + Integer.toHexString(k) + '=' + (short)k);
        i--;
        if (i < 0)
        {
          if (k > 40959)
            break label232;
          if ((k < 32) || (k >= 127))
            break label178;
          paramPrintWriter.print("='" + k + "'");
        }
      }
      while (true)
      {
        paramPrintWriter.println();
        if ((1 != 0) && (i > 0))
        {
          j += i;
          i = 0;
        }
        j++;
        break;
        label178: label1368: if (k == 10)
        {
          paramPrintWriter.print("='\\n'");
        }
        else
        {
          paramPrintWriter.print("='\\u" + Integer.toHexString(k) + "'");
          continue;
          label232: if ((k >= 57344) && (k <= 61439))
          {
            int i26 = k - 57344;
            Object localObject2 = this.objects[i26];
            paramPrintWriter.print("=Object#" + i26 + '=' + localObject2 + ':' + localObject2.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(localObject2)));
          }
          else if ((k >= 40960) && (k <= 45055))
          {
            int i24 = k - 40960;
            int i25 = j + this.data[(j + 1)];
            paramPrintWriter.print("=BEGIN_ELEMENT_SHORT end:" + i25 + " index#" + i24 + "=<" + this.objects[i24] + '>');
            i = 2;
          }
          else if ((k >= 45056) && (k <= 57343))
          {
            paramPrintWriter.print("= INT_SHORT:" + (k - 49152));
          }
          else
          {
            switch (k)
            {
            case 61703:
            default:
              break;
            case 61696:
              paramPrintWriter.print("= false");
              break;
            case 61698:
              int i23 = getIntN(j + 1);
              paramPrintWriter.print("=INT_FOLLOWS value:" + i23);
              i = 2;
              break;
            case 61699:
              long l2 = getLongN(j + 1);
              paramPrintWriter.print("=LONG_FOLLOWS value:" + l2);
              i = 4;
              break;
            case 61700:
              int i22 = getIntN(j + 1);
              paramPrintWriter.write("=FLOAT_FOLLOWS value:" + Float.intBitsToFloat(i22));
              i = 2;
              break;
            case 61701:
              long l1 = getLongN(j + 1);
              paramPrintWriter.print("=DOUBLE_FOLLOWS value:" + Double.longBitsToDouble(l1));
              i = 4;
              break;
            case 61712:
              int i19 = getIntN(j + 1);
              if (i19 < 0);
              for (int i20 = this.data.length; ; i20 = j)
              {
                int i21 = i19 + i20;
                paramPrintWriter.print("=BEGIN_DOCUMENT end:");
                paramPrintWriter.print(i21);
                paramPrintWriter.print(" parent:");
                paramPrintWriter.print(getIntN(j + 3));
                i = 4;
                break;
              }
            case 61714:
              int i18 = getIntN(j + 1);
              paramPrintWriter.print("=BEGIN_ENTITY base:");
              paramPrintWriter.print(i18);
              paramPrintWriter.print(" parent:");
              paramPrintWriter.print(getIntN(j + 3));
              i = 4;
              break;
            case 61715:
              paramPrintWriter.print("=END_ENTITY");
              break;
            case 61720:
              paramPrintWriter.print("=DOCUMENT_URI: ");
              int i17 = getIntN(j + 1);
              paramPrintWriter.print(this.objects[i17]);
              i = 2;
              break;
            case 61719:
              paramPrintWriter.print("=COMMENT: '");
              int i16 = getIntN(j + 1);
              paramPrintWriter.write(this.data, j + 3, i16);
              paramPrintWriter.print('\'');
              i = i16 + 2;
              break;
            case 61717:
              paramPrintWriter.print("=CDATA: '");
              int i15 = getIntN(j + 1);
              paramPrintWriter.write(this.data, j + 3, i15);
              paramPrintWriter.print('\'');
              i = i15 + 2;
              break;
            case 61716:
              paramPrintWriter.print("=PROCESSING_INSTRUCTION: ");
              int i13 = getIntN(j + 1);
              paramPrintWriter.print(this.objects[i13]);
              paramPrintWriter.print(" '");
              int i14 = getIntN(j + 3);
              paramPrintWriter.write(this.data, j + 5, i14);
              paramPrintWriter.print('\'');
              i = i14 + 4;
              break;
            case 61713:
              paramPrintWriter.print("=END_DOCUMENT");
              break;
            case 61697:
              paramPrintWriter.print("= true");
              break;
            case 61718:
              paramPrintWriter.print("= joiner");
              break;
            case 61702:
              paramPrintWriter.print("=CHAR_FOLLOWS");
              i = 1;
              break;
            case 61709:
            case 61710:
              i = 2;
              break;
            case 61707:
              paramPrintWriter.print("=END_ELEMENT_SHORT begin:");
              int i11 = j - this.data[(j + 1)];
              paramPrintWriter.print(i11);
              int i12 = this.data[i11] - 40960;
              paramPrintWriter.print(" -> #");
              paramPrintWriter.print(i12);
              paramPrintWriter.print("=<");
              paramPrintWriter.print(this.objects[i12]);
              paramPrintWriter.print('>');
              i = 1;
              break;
            case 61704:
              int i7 = getIntN(j + 1);
              int i8;
              if (i7 < 0)
              {
                i8 = this.data.length;
                int i9 = i7 + i8;
                paramPrintWriter.print("=BEGIN_ELEMENT_LONG end:");
                paramPrintWriter.print(i9);
                int i10 = getIntN(i9 + 1);
                paramPrintWriter.print(" -> #");
                paramPrintWriter.print(i10);
                if ((i10 < 0) || (i10 + 1 >= this.objects.length))
                  break label1368;
                paramPrintWriter.print("=<" + this.objects[i10] + '>');
              }
              while (true)
              {
                i = 2;
                break;
                i8 = j;
                break label1260;
                paramPrintWriter.print("=<out-of-bounds>");
              }
            case 61708:
              int i4 = getIntN(j + 1);
              paramPrintWriter.print("=END_ELEMENT_LONG name:" + i4 + "=<" + this.objects[i4] + '>');
              int i5 = getIntN(j + 3);
              if (i5 < 0)
                i5 = j + i5;
              paramPrintWriter.print(" begin:" + i5);
              int i6 = getIntN(j + 5);
              if (i6 < 0)
                i6 = j + i6;
              paramPrintWriter.print(" parent:" + i6);
              i = 6;
              break;
            case 61705:
              int n = getIntN(j + 1);
              paramPrintWriter.print("=BEGIN_ATTRIBUTE name:" + n + "=" + this.objects[n]);
              int i1 = getIntN(j + 3);
              if (i1 < 0);
              for (int i2 = this.data.length; ; i2 = j)
              {
                int i3 = i1 + i2;
                paramPrintWriter.print(" end:" + i3);
                i = 4;
                break;
              }
            case 61706:
              label1260: paramPrintWriter.print("=END_ATTRIBUTE");
            case 61711:
            }
          }
        }
      }
      paramPrintWriter.print("=POSITION_PAIR_FOLLOWS seq:");
      int m = getIntN(j + 1);
      paramPrintWriter.print(m);
      paramPrintWriter.print('=');
      Object localObject1 = this.objects[m];
      String str;
      if (localObject1 == null)
      {
        str = null;
        label1709: paramPrintWriter.print(str);
        paramPrintWriter.print('@');
        if (localObject1 != null)
          break label1770;
        paramPrintWriter.print("null");
      }
      while (true)
      {
        paramPrintWriter.print(" ipos:");
        paramPrintWriter.print(getIntN(j + 3));
        i = 4;
        break;
        str = localObject1.getClass().getName();
        break label1709;
        label1770: paramPrintWriter.print(Integer.toHexString(System.identityHashCode(localObject1)));
      }
    }
  }

  public void endAttribute()
  {
    if (this.attrStart <= 0)
      return;
    if (this.data[this.gapEnd] != 61706)
      throw new Error("unexpected endAttribute");
    this.gapEnd = (1 + this.gapEnd);
    setIntN(2 + this.attrStart, 1 + (this.gapStart - this.attrStart));
    this.attrStart = 0;
    char[] arrayOfChar = this.data;
    int i = this.gapStart;
    this.gapStart = (i + 1);
    arrayOfChar[i] = 61706;
  }

  public void endDocument()
  {
    if ((this.data[this.gapEnd] != 61713) || (this.docStart <= 0) || (this.data[this.currentParent] != 61712))
      throw new Error("unexpected endDocument");
    this.gapEnd = (1 + this.gapEnd);
    setIntN(this.docStart, 1 + (this.gapStart - this.docStart));
    this.docStart = 0;
    char[] arrayOfChar = this.data;
    int i = this.gapStart;
    this.gapStart = (i + 1);
    arrayOfChar[i] = 61713;
    int j = getIntN(3 + this.currentParent);
    if (j >= -1);
    for (int k = j; ; k = j + this.currentParent)
    {
      this.currentParent = k;
      return;
    }
  }

  public void endElement()
  {
    if (this.data[this.gapEnd] != 61708)
      throw new Error("unexpected endElement");
    int i = getIntN(1 + this.gapEnd);
    int j = getIntN(3 + this.gapEnd);
    int k = getIntN(5 + this.gapEnd);
    this.currentParent = k;
    this.gapEnd = (7 + this.gapEnd);
    int m = this.gapStart - j;
    int n = j - k;
    if ((i < 4095) && (m < 65536) && (n < 65536))
    {
      this.data[j] = ((char)(0xA000 | i));
      this.data[(j + 1)] = ((char)m);
      this.data[(j + 2)] = ((char)n);
      this.data[this.gapStart] = 61707;
      this.data[(1 + this.gapStart)] = ((char)m);
      this.gapStart = (2 + this.gapStart);
      return;
    }
    this.data[j] = 61704;
    setIntN(j + 1, m);
    this.data[this.gapStart] = 61708;
    setIntN(1 + this.gapStart, i);
    setIntN(3 + this.gapStart, -m);
    if ((k >= this.gapStart) || (j <= this.gapStart))
      k -= this.gapStart;
    setIntN(5 + this.gapStart, k);
    this.gapStart = (7 + this.gapStart);
  }

  public void endEntity()
  {
    if ((1 + this.gapEnd != this.data.length) || (this.data[this.gapEnd] != 61715))
      return;
    if (this.data[this.currentParent] != 61714)
      throw new Error("unexpected endEntity");
    this.gapEnd = (1 + this.gapEnd);
    char[] arrayOfChar = this.data;
    int i = this.gapStart;
    this.gapStart = (i + 1);
    arrayOfChar[i] = 61715;
    int j = getIntN(3 + this.currentParent);
    if (j >= -1);
    for (int k = j; ; k = j + this.currentParent)
    {
      this.currentParent = k;
      return;
    }
  }

  public void ensureSpace(int paramInt)
  {
    int i = this.gapEnd - this.gapStart;
    if (paramInt > i)
    {
      int j = this.data.length;
      int k = paramInt + (j - i);
      int m = j * 2;
      if (m < k)
        m = k;
      char[] arrayOfChar = new char[m];
      if (this.gapStart > 0)
        System.arraycopy(this.data, 0, arrayOfChar, 0, this.gapStart);
      int n = j - this.gapEnd;
      if (n > 0)
        System.arraycopy(this.data, this.gapEnd, arrayOfChar, m - n, n);
      this.gapEnd = (m - n);
      this.data = arrayOfChar;
    }
  }

  public int find(Object paramObject)
  {
    if (this.oindex == this.objects.length)
      resizeObjects();
    this.objects[this.oindex] = paramObject;
    int i = this.oindex;
    this.oindex = (i + 1);
    return i;
  }

  public int firstAttributePos(int paramInt)
  {
    int i = gotoAttributesStart(posToDataIndex(paramInt));
    if (i < 0)
      return 0;
    return i << 1;
  }

  public int firstChildPos(int paramInt)
  {
    int i = gotoChildrenStart(posToDataIndex(paramInt));
    if (i < 0)
      return 0;
    return i << 1;
  }

  public Object get(int paramInt)
  {
    int i = 0;
    do
    {
      paramInt--;
      if (paramInt < 0)
        break;
      i = nextPos(i);
    }
    while (i != 0);
    throw new IndexOutOfBoundsException();
    return getPosNext(i);
  }

  public int getAttributeCount(int paramInt)
  {
    int i = 0;
    for (int j = firstAttributePos(paramInt); (j != 0) && (getNextKind(j) == 35); j = nextPos(j))
      i++;
    return i;
  }

  protected int getIndexDifference(int paramInt1, int paramInt2)
  {
    int i = posToDataIndex(paramInt2);
    int j = posToDataIndex(paramInt1);
    int k = 0;
    if (i > j)
    {
      k = 1;
      int n = j;
      j = i;
      i = n;
    }
    for (int m = 0; i < j; m++)
      i = nextDataIndex(i);
    if (k != 0)
      return -m;
    return m;
  }

  protected final int getIntN(int paramInt)
  {
    return this.data[paramInt] << '\020' | 0xFFFF & this.data[(paramInt + 1)];
  }

  protected final long getLongN(int paramInt)
  {
    char[] arrayOfChar = this.data;
    return (0xFFFF & arrayOfChar[paramInt]) << 48 | (0xFFFF & arrayOfChar[(paramInt + 1)]) << 32 | (0xFFFF & arrayOfChar[(paramInt + 2)]) << 16 | 0xFFFF & arrayOfChar[(paramInt + 3)];
  }

  public int getNextKind(int paramInt)
  {
    return getNextKindI(posToDataIndex(paramInt));
  }

  public int getNextKindI(int paramInt)
  {
    if (paramInt == this.data.length)
      return 0;
    int i = this.data[paramInt];
    if (i <= 40959)
      return 29;
    if ((i >= 57344) && (i <= 61439))
      return 32;
    if ((i >= 40960) && (i <= 45055))
      return 33;
    if ((0xFF00 & i) == 61440)
      return 28;
    if ((i >= 45056) && (i <= 57343))
      return 22;
    switch (i)
    {
    case 61703:
    case 61709:
    case 61710:
    case 61711:
    case 61718:
    default:
      return 32;
    case 61696:
    case 61697:
      return 27;
    case 61698:
      return 22;
    case 61699:
      return 24;
    case 61700:
      return 25;
    case 61701:
      return 26;
    case 61702:
    case 61712:
      return 34;
    case 61714:
      return getNextKind(paramInt + 5 << 1);
    case 61704:
      return 33;
    case 61706:
    case 61707:
    case 61708:
    case 61713:
    case 61715:
      return 0;
    case 61705:
      return 35;
    case 61717:
      return 31;
    case 61719:
      return 36;
    case 61716:
    }
    return 37;
  }

  public String getNextTypeName(int paramInt)
  {
    Object localObject = getNextTypeObject(paramInt);
    if (localObject == null)
      return null;
    return localObject.toString();
  }

  public Object getNextTypeObject(int paramInt)
  {
    int i = posToDataIndex(paramInt);
    if (i == this.data.length)
      return null;
    int j = this.data[i];
    int k;
    if (j != 61714)
    {
      if ((j < 40960) || (j > 45055))
        break label61;
      k = j - 40960;
    }
    while (true)
      if (k < 0)
      {
        return null;
        i += 5;
        break;
        label61: if (j == 61704)
        {
          int m = getIntN(i + 1);
          if (m < 0);
          for (int n = this.data.length; ; n = i)
          {
            k = getIntN(1 + (m + n));
            break;
          }
        }
        if (j == 61705)
          k = getIntN(i + 1);
        else if (j == 61716)
          k = getIntN(i + 1);
        else
          return null;
      }
    return this.objects[k];
  }

  public Object getPosNext(int paramInt)
  {
    int i = posToDataIndex(paramInt);
    if (i == this.data.length)
      return Sequence.eofValue;
    int j = this.data[i];
    if (j <= 40959)
      return Convert.toObject(j);
    if ((j >= 57344) && (j <= 61439))
      return this.objects[(j - 57344)];
    if ((j >= 40960) && (j <= 45055))
      return copyToList(i, 2 + (i + this.data[(i + 1)]));
    if ((j >= 45056) && (j <= 57343))
      return Convert.toObject(j - 49152);
    switch (j)
    {
    case 61703:
    case 61714:
    case 61715:
    case 61716:
    case 61717:
    default:
      throw unsupported("getPosNext, code=" + Integer.toHexString(j));
    case 61712:
      int i2 = getIntN(i + 1);
      if (i2 < 0);
      for (int i3 = this.data.length; ; i3 = i)
        return copyToList(i, 1 + (i2 + i3));
    case 61696:
    case 61697:
      if (j != 61696);
      for (boolean bool = true; ; bool = false)
        return Convert.toObject(bool);
    case 61698:
      return Convert.toObject(getIntN(i + 1));
    case 61699:
      return Convert.toObject(getLongN(i + 1));
    case 61700:
      return Convert.toObject(Float.intBitsToFloat(getIntN(i + 1)));
    case 61701:
      return Convert.toObject(Double.longBitsToDouble(getLongN(i + 1)));
    case 61702:
      return Convert.toObject(this.data[(i + 1)]);
    case 61705:
      int n = getIntN(i + 3);
      if (n < 0);
      for (int i1 = this.data.length; ; i1 = i)
        return copyToList(i, 1 + (n + i1));
    case 61704:
      int k = getIntN(i + 1);
      if (k < 0);
      for (int m = this.data.length; ; m = i)
        return copyToList(i, 7 + (k + m));
    case 61706:
    case 61707:
    case 61708:
    case 61713:
      return Sequence.eofValue;
    case 61709:
    case 61710:
      return this.objects[getIntN(i + 1)];
    case 61718:
      return "";
    case 61711:
    }
    return ((AbstractSequence)this.objects[getIntN(i + 1)]).getIteratorAtPos(getIntN(i + 3));
  }

  public int getPosNextInt(int paramInt)
  {
    int i = posToDataIndex(paramInt);
    if (i < this.data.length)
    {
      int j = this.data[i];
      if ((j >= 45056) && (j <= 57343))
        return j - 49152;
      if (j == 61698)
        return getIntN(i + 1);
    }
    return ((Number)getPosNext(paramInt)).intValue();
  }

  public Object getPosPrevious(int paramInt)
  {
    if (((paramInt & 0x1) != 0) && (paramInt != -1))
      return getPosNext(paramInt - 3);
    return super.getPosPrevious(paramInt);
  }

  public int gotoAttributesStart(int paramInt)
  {
    if (paramInt >= this.gapStart)
      paramInt += this.gapEnd - this.gapStart;
    if (paramInt == this.data.length)
      return -1;
    int i = this.data[paramInt];
    if (((i >= 40960) && (i <= 45055)) || (i == 61704))
      return paramInt + 3;
    return -1;
  }

  public boolean gotoAttributesStart(TreePosition paramTreePosition)
  {
    int i = gotoAttributesStart(paramTreePosition.ipos >> 1);
    if (i < 0)
      return false;
    paramTreePosition.push(this, i << 1);
    return true;
  }

  public final int gotoChildrenStart(int paramInt)
  {
    if (paramInt == this.data.length)
      return -1;
    int i = this.data[paramInt];
    int j;
    if (((i >= 40960) && (i <= 45055)) || (i == 61704))
      j = paramInt + 3;
    while (true)
    {
      if (j >= this.gapStart)
        j += this.gapEnd - this.gapStart;
      int k = this.data[j];
      if (k == 61705)
      {
        int m = getIntN(j + 3);
        if (m < 0);
        for (int n = this.data.length; ; n = j)
        {
          j = m + n;
          break;
          if ((i == 61712) || (i == 61714))
          {
            j = paramInt + 5;
            break;
          }
          return -1;
        }
      }
      if ((k == 61706) || (k == 61718))
      {
        j++;
      }
      else
      {
        if (k != 61720)
          break;
        j += 3;
      }
    }
    return j;
  }

  public boolean hasNext(int paramInt)
  {
    int i = posToDataIndex(paramInt);
    if (i == this.data.length)
      return false;
    int j = this.data[i];
    return (j != 61706) && (j != 61707) && (j != 61708) && (j != 61713);
  }

  public int hashCode()
  {
    return System.identityHashCode(this);
  }

  public boolean ignoring()
  {
    return false;
  }

  public boolean isEmpty()
  {
    if (this.gapStart == 0);
    for (int i = this.gapEnd; i == this.data.length; i = 0)
      return true;
    return false;
  }

  public final int nextDataIndex(int paramInt)
  {
    if (paramInt == this.gapStart)
      paramInt = this.gapEnd;
    if (paramInt == this.data.length)
      return -1;
    char[] arrayOfChar = this.data;
    int i = paramInt + 1;
    int j = arrayOfChar[paramInt];
    if ((j <= 40959) || ((j >= 57344) && (j <= 61439)) || ((j >= 45056) && (j <= 57343)))
      return i;
    if ((j >= 40960) && (j <= 45055))
      return 1 + (i + this.data[i]);
    switch (j)
    {
    case 61703:
    default:
      throw new Error("unknown code:" + Integer.toHexString(j));
    case 61712:
      int i4 = getIntN(i);
      if (i4 < 0);
      for (int i5 = this.data.length; ; i5 = i - 1)
        return 1 + (i4 + i5);
    case 61714:
      for (int i3 = i + 4; ; i3 = nextDataIndex(i3))
      {
        if (i3 == this.gapStart)
          i3 = this.gapEnd;
        if (i3 == this.data.length)
          return -1;
        if (this.data[i3] == 61715)
          return i3 + 1;
      }
    case 61696:
    case 61697:
    case 61718:
      return i;
    case 61702:
      return i + 1;
    case 61698:
    case 61700:
    case 61709:
    case 61710:
      return i + 2;
    case 61711:
      return i + 4;
    case 61706:
    case 61707:
    case 61708:
    case 61713:
    case 61715:
      return -1;
    case 61704:
      int i1 = getIntN(i);
      if (i1 < 0);
      for (int i2 = this.data.length; ; i2 = i - 1)
        return 7 + (i1 + i2);
    case 61705:
      int m = getIntN(i + 2);
      if (m < 0);
      for (int n = this.data.length; ; n = i - 1)
        return 1 + (m + n);
    case 61699:
    case 61701:
      return i + 4;
    case 61716:
    case 61717:
    case 61719:
    }
    for (int k = i + 2; ; k = i)
      return k + 2 + getIntN(k);
  }

  public int nextMatching(int paramInt1, ItemPredicate paramItemPredicate, int paramInt2, boolean paramBoolean)
  {
    int i = posToDataIndex(paramInt1);
    int j = posToDataIndex(paramInt2);
    int k = i;
    if ((paramItemPredicate instanceof NodePredicate))
      k = nextNodeIndex(k, j);
    int m;
    int n;
    int i1;
    if ((paramItemPredicate instanceof ElementPredicate))
    {
      m = 1;
      n = 1;
      i1 = 0;
    }
    int i2;
    while (true)
    {
      if (k == this.gapStart)
        k = this.gapEnd;
      if ((k >= j) && (j != -1))
      {
        return 0;
        if ((paramItemPredicate instanceof AttributePredicate))
        {
          m = 1;
          n = 0;
          i1 = 0;
        }
        else
        {
          m = 1;
          n = 1;
          i1 = 1;
        }
      }
      else
      {
        i2 = this.data[k];
        if ((i2 > 40959) && ((i2 < 57344) || (i2 > 61439)) && ((i2 < 45056) || (i2 > 57343)))
          break;
        if ((i1 != 0) && (paramItemPredicate.isInstancePos(this, k << 1)))
        {
          if (k >= this.gapEnd)
            k -= this.gapEnd - this.gapStart;
          return k << 1;
        }
        i3 = k + 1;
        k = i3;
      }
    }
    switch (i2)
    {
    case 61703:
    default:
      if ((i2 < 40960) || (i2 > 45055))
        break label778;
      if (!paramBoolean)
        break;
    case 61720:
    case 61712:
    case 61714:
    case 61698:
    case 61700:
    case 61709:
    case 61710:
    case 61702:
    case 61707:
    case 61711:
    case 61708:
    case 61706:
    case 61713:
    case 61715:
    case 61705:
    case 61696:
    case 61697:
    case 61718:
    case 61699:
    case 61701:
    case 61716:
    case 61719:
    case 61717:
    case 61704:
    }
    for (int i3 = k + 3; n != 0; i3 = 2 + (k + this.data[(k + 1)]))
    {
      label362: 
      while ((k > i) && (paramItemPredicate.isInstancePos(this, k << 1)))
      {
        if (k >= this.gapEnd)
          k -= this.gapEnd - this.gapStart;
        return k << 1;
        i3 = k + 3;
        break;
        i3 = k + 5;
        if (m == 0)
          break;
        continue;
        i3 = k + 5;
        break;
        i3 = k + 3;
        if (i1 == 0)
          break;
        continue;
        i3 = k + 2;
        break;
        if (!paramBoolean)
          return 0;
        i3 = k + 2;
        break;
        i3 = k + 5;
        if (i1 == 0)
          break;
        continue;
        if (!paramBoolean)
          return 0;
        i3 = k + 7;
        break;
        if (!paramBoolean)
          return 0;
        i3 = k + 1;
        break;
        int i7;
        int i8;
        if (m != 0)
        {
          int i6 = getIntN(k + 3);
          i7 = i6 + 1;
          if (i6 < 0)
            i8 = this.data.length;
        }
        for (i3 = i7 + i8; 0 != 0; i3 = k + 5)
        {
          break label362;
          i8 = k;
          break label562;
        }
        i3 = k + 1;
        if (i1 == 0)
          break;
        continue;
        i3 = k + 1;
        break;
        i3 = k + 5;
        if (i1 == 0)
          break;
        continue;
        i3 = k + 5 + getIntN(k + 3);
        if (m == 0)
          break;
        continue;
        i3 = k + 3 + getIntN(k + 1);
        if (m == 0)
          break;
        continue;
        i3 = k + 3 + getIntN(k + 1);
        if (i1 == 0)
          break;
        continue;
        if (!paramBoolean)
          break label717;
        i3 = k + 3;
        if (n == 0)
          break label750;
      }
      label562: label709: label717: int i4 = getIntN(k + 1);
      if (i4 < 0);
      for (int i5 = this.data.length; ; i5 = k)
      {
        i3 = 7 + (i5 + i4);
        break label709;
        label750: break;
      }
    }
    label778: throw new Error("unknown code:" + i2);
  }

  public final int nextNodeIndex(int paramInt1, int paramInt2)
  {
    if ((0x80000000 | paramInt2) == -1)
      paramInt2 = this.data.length;
    while (true)
    {
      if (paramInt1 == this.gapStart)
        paramInt1 = this.gapEnd;
      if (paramInt1 >= paramInt2);
      int i;
      do
      {
        return paramInt1;
        i = this.data[paramInt1];
        if ((i <= 40959) || ((i >= 57344) && (i <= 61439)) || ((i >= 45056) && (i <= 57343)) || ((0xFF00 & i) == 61440))
        {
          paramInt1++;
          break;
        }
      }
      while ((i >= 40960) && (i <= 45055));
      switch (i)
      {
      case 61704:
      case 61705:
      case 61706:
      case 61707:
      case 61708:
      case 61712:
      case 61713:
      case 61715:
      case 61716:
      case 61719:
      case 61709:
      case 61710:
      case 61711:
      case 61717:
      default:
        paramInt1 = nextDataIndex(paramInt1);
        break;
      case 61720:
        paramInt1 += 3;
        break;
      case 61718:
        paramInt1++;
        break;
      case 61714:
        paramInt1 += 5;
      }
    }
  }

  public int nextPos(int paramInt)
  {
    int i = posToDataIndex(paramInt);
    if (i == this.data.length)
      return 0;
    if (i >= this.gapEnd)
      i -= this.gapEnd - this.gapStart;
    return 3 + (i << 1);
  }

  public int parentOrEntityI(int paramInt)
  {
    if (paramInt == this.data.length)
      return -1;
    int i = this.data[paramInt];
    if ((i == 61712) || (i == 61714))
    {
      int j = getIntN(paramInt + 3);
      if (j >= -1)
        return j;
      return paramInt + j;
    }
    if ((i >= 40960) && (i <= 45055))
    {
      int i3 = this.data[(paramInt + 2)];
      if (i3 == 0)
        return -1;
      return paramInt - i3;
    }
    if (i == 61704)
    {
      int m = getIntN(paramInt + 1);
      if (m < 0);
      int i1;
      int i2;
      for (int n = this.data.length; ; n = paramInt)
      {
        i1 = m + n;
        i2 = getIntN(i1 + 5);
        if (i2 != 0)
          break;
        return -1;
      }
      if (i2 < 0)
        i2 += i1;
      return i2;
      paramInt++;
    }
    do
    {
      if (paramInt == this.gapStart)
        paramInt = this.gapEnd;
      if (paramInt == this.data.length)
        return -1;
      switch (this.data[paramInt])
      {
      case '':
      case '':
      case '':
      case '':
      case '':
      default:
        paramInt = nextDataIndex(paramInt);
      case '':
      case '':
      case '':
      }
    }
    while (paramInt >= 0);
    return -1;
    return paramInt - this.data[(paramInt + 1)];
    int k = getIntN(paramInt + 3);
    if (k < 0)
      k += paramInt;
    return k;
    return -1;
  }

  public int parentOrEntityPos(int paramInt)
  {
    int i = parentOrEntityI(posToDataIndex(paramInt));
    if (i < 0)
      return -1;
    return i << 1;
  }

  public int parentPos(int paramInt)
  {
    int i = posToDataIndex(paramInt);
    do
    {
      i = parentOrEntityI(i);
      if (i == -1)
        return -1;
    }
    while (this.data[i] == 61714);
    return i << 1;
  }

  public final int posToDataIndex(int paramInt)
  {
    if (paramInt == -1)
      return this.data.length;
    int i = paramInt >>> 1;
    if ((paramInt & 0x1) != 0)
      i--;
    if (i >= this.gapStart)
      i += this.gapEnd - this.gapStart;
    if ((paramInt & 0x1) != 0)
    {
      i = nextDataIndex(i);
      if (i < 0)
        return this.data.length;
      if (i == this.gapStart)
        i += this.gapEnd - this.gapStart;
    }
    return i;
  }

  public final void resizeObjects()
  {
    Object[] arrayOfObject;
    if (this.objects == null)
      arrayOfObject = new Object[100];
    while (true)
    {
      this.objects = arrayOfObject;
      return;
      int i = this.objects.length;
      arrayOfObject = new Object[i * 2];
      System.arraycopy(this.objects, 0, arrayOfObject, 0, i);
    }
  }

  public void setAttributeName(int paramInt1, int paramInt2)
  {
    setIntN(paramInt1 + 1, paramInt2);
  }

  public void setElementName(int paramInt1, int paramInt2)
  {
    int i;
    if (this.data[paramInt1] == 61704)
    {
      i = getIntN(paramInt1 + 1);
      if (i >= 0)
        break label54;
    }
    label54: for (int j = this.data.length; ; j = paramInt1)
    {
      paramInt1 = i + j;
      if (paramInt1 >= this.gapEnd)
        break;
      throw new Error("setElementName before gapEnd");
    }
    setIntN(paramInt1 + 1, paramInt2);
  }

  public final void setIntN(int paramInt1, int paramInt2)
  {
    this.data[paramInt1] = ((char)(paramInt2 >> 16));
    this.data[(paramInt1 + 1)] = ((char)paramInt2);
  }

  public int size()
  {
    int i = 0;
    int j = 0;
    while (true)
    {
      j = nextPos(j);
      if (j == 0)
        return i;
      i++;
    }
  }

  public void startAttribute(int paramInt)
  {
    ensureSpace(6);
    this.gapEnd -= 1;
    char[] arrayOfChar = this.data;
    int i = this.gapStart;
    this.gapStart = (i + 1);
    arrayOfChar[i] = 61705;
    if (this.attrStart != 0)
      throw new Error("nested attribute");
    this.attrStart = this.gapStart;
    setIntN(this.gapStart, paramInt);
    setIntN(2 + this.gapStart, this.gapEnd - this.data.length);
    this.gapStart = (4 + this.gapStart);
    this.data[this.gapEnd] = 61706;
  }

  public void startAttribute(Object paramObject)
  {
    startAttribute(find(paramObject));
  }

  public void startDocument()
  {
    ensureSpace(6);
    this.gapEnd -= 1;
    int i = this.gapStart;
    this.data[i] = 61712;
    if (this.docStart != 0)
      throw new Error("nested document");
    this.docStart = (i + 1);
    setIntN(i + 1, this.gapEnd - this.data.length);
    int j = i + 3;
    if (this.currentParent == -1);
    for (int k = -1; ; k = this.currentParent - i)
    {
      setIntN(j, k);
      this.currentParent = i;
      this.gapStart = (i + 5);
      this.currentParent = i;
      this.data[this.gapEnd] = 61713;
      return;
    }
  }

  public void startElement(int paramInt)
  {
    ensureSpace(10);
    this.gapEnd -= 7;
    char[] arrayOfChar = this.data;
    int i = this.gapStart;
    this.gapStart = (i + 1);
    arrayOfChar[i] = 61704;
    setIntN(this.gapStart, this.gapEnd - this.data.length);
    this.gapStart = (2 + this.gapStart);
    this.data[this.gapEnd] = 61708;
    setIntN(1 + this.gapEnd, paramInt);
    setIntN(3 + this.gapEnd, this.gapStart - 3);
    setIntN(5 + this.gapEnd, this.currentParent);
    this.currentParent = (this.gapStart - 3);
  }

  public void startElement(Object paramObject)
  {
    startElement(find(paramObject));
  }

  public void statistics()
  {
    PrintWriter localPrintWriter = new PrintWriter(System.out);
    statistics(localPrintWriter);
    localPrintWriter.flush();
  }

  public void statistics(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.print("data array length: ");
    paramPrintWriter.println(this.data.length);
    paramPrintWriter.print("data array gap: ");
    paramPrintWriter.println(this.gapEnd - this.gapStart);
    paramPrintWriter.print("object array length: ");
    paramPrintWriter.println(this.objects.length);
  }

  public int stringValue(int paramInt, StringBuffer paramStringBuffer)
  {
    int i = nextNodeIndex(paramInt, 2147483647);
    if (i > paramInt)
    {
      stringValue(paramInt, i, paramStringBuffer);
      return paramInt;
    }
    return stringValue(false, paramInt, paramStringBuffer);
  }

  public int stringValue(boolean paramBoolean, int paramInt, StringBuffer paramStringBuffer)
  {
    int i = 0;
    if (paramInt >= this.gapStart)
      paramInt += this.gapEnd - this.gapStart;
    if (paramInt == this.data.length)
      return -1;
    int j = this.data[paramInt];
    int k = paramInt + 1;
    if (j <= 40959)
    {
      paramStringBuffer.append(j);
      return k;
    }
    Object localObject;
    if ((j >= 57344) && (j <= 61439))
    {
      if (0 != 0)
        paramStringBuffer.append(' ');
      localObject = this.objects[(j - 57344)];
    }
    while (true)
    {
      if (localObject != null)
        paramStringBuffer.append(localObject);
      if (i > 0)
        do
          i = stringValue(true, i, paramStringBuffer);
        while (i >= 0);
      return k;
      if ((j >= 40960) && (j <= 45055))
      {
        i = k + 2;
        k = 1 + (k + this.data[k]);
        localObject = null;
      }
      else
      {
        if ((0xFF00 & j) == 61440)
        {
          paramStringBuffer.append(j & 0xFF);
          return k;
        }
        if ((j >= 45056) && (j <= 57343))
        {
          paramStringBuffer.append(j - 49152);
          return k;
        }
        switch (j)
        {
        case 61703:
        case 61709:
        case 61710:
        default:
          throw new Error("unimplemented: " + Integer.toHexString(j) + " at:" + k);
        case 61720:
          return k + 2;
        case 61716:
          k += 2;
        case 61717:
        case 61719:
          int i4 = getIntN(k);
          int i5 = k + 2;
          if ((!paramBoolean) || (j == 61717))
            paramStringBuffer.append(this.data, i5, i4);
          return i5 + i4;
        case 61696:
        case 61697:
          if (0 != 0)
            paramStringBuffer.append(' ');
          if (j != 61696);
          for (boolean bool = true; ; bool = false)
          {
            paramStringBuffer.append(bool);
            return k;
          }
        case 61698:
          if (0 != 0)
            paramStringBuffer.append(' ');
          paramStringBuffer.append(getIntN(k));
          return k + 2;
        case 61699:
          if (0 != 0)
            paramStringBuffer.append(' ');
          paramStringBuffer.append(getLongN(k));
          return k + 4;
        case 61700:
          if (0 != 0)
            paramStringBuffer.append(' ');
          paramStringBuffer.append(Float.intBitsToFloat(getIntN(k)));
          return k + 2;
        case 61701:
          if (0 != 0)
            paramStringBuffer.append(' ');
          paramStringBuffer.append(Double.longBitsToDouble(getLongN(k)));
          return k + 4;
        case 61702:
          paramStringBuffer.append(this.data[k]);
          return k + 1;
        case 61712:
        case 61714:
          i = k + 4;
          k = nextDataIndex(k - 1);
          localObject = null;
          break;
        case 61704:
          i = k + 2;
          int i2 = getIntN(k);
          if (i2 < 0);
          for (int i3 = this.data.length; ; i3 = k - 1)
          {
            k = 7 + (i2 + i3);
            localObject = null;
            break;
          }
        case 61718:
          i = 0;
          localObject = null;
          break;
        case 61706:
        case 61707:
        case 61708:
        case 61713:
        case 61715:
          return -1;
        case 61705:
          i = 0;
          if (!paramBoolean)
            i = k + 4;
          int n = getIntN(k + 2);
          if (n < 0);
          for (int i1 = 1 + this.data.length; ; i1 = k)
          {
            k = n + i1;
            localObject = null;
            break;
          }
        case 61711:
          AbstractSequence localAbstractSequence = (AbstractSequence)this.objects[getIntN(k)];
          int m = getIntN(k + 2);
          ((TreeList)localAbstractSequence).stringValue(paramBoolean, m >> 1, paramStringBuffer);
          k += 4;
          i = 0;
          localObject = null;
        }
      }
    }
  }

  public void stringValue(int paramInt1, int paramInt2, StringBuffer paramStringBuffer)
  {
    for (int i = paramInt1; (i < paramInt2) && (i >= 0); i = stringValue(false, i, paramStringBuffer));
  }

  public void toString(String paramString, StringBuffer paramStringBuffer)
  {
    int i = 0;
    int j = this.gapStart;
    int k = 0;
    int m = 0;
    if (i >= j)
    {
      int i21 = this.gapStart;
      if (i == i21)
      {
        i = this.gapEnd;
        j = this.data.length;
        if (i != j);
      }
      else
      {
        return;
      }
    }
    char[] arrayOfChar1 = this.data;
    int n = i + 1;
    int i1 = arrayOfChar1[i];
    int i18;
    int i19;
    if (i1 <= 40959)
    {
      i18 = n - 1;
      i19 = j;
    }
    while (true)
    {
      if (n >= i19);
      int i20;
      for (i = n; ; i = i20 - 1)
      {
        if (m != 0)
        {
          paramStringBuffer.append('>');
          m = 0;
        }
        paramStringBuffer.append(this.data, i18, i - i18);
        k = 0;
        break;
        char[] arrayOfChar4 = this.data;
        i20 = n + 1;
        if (arrayOfChar4[n] <= 40959)
          break label1509;
      }
      if ((i1 >= 57344) && (i1 <= 61439))
      {
        if (m != 0)
        {
          paramStringBuffer.append('>');
          m = 0;
        }
        if (k != 0)
          paramStringBuffer.append(paramString);
        while (true)
        {
          paramStringBuffer.append(this.objects[(i1 - 57344)]);
          i = n;
          break;
          k = 1;
        }
      }
      if ((i1 >= 40960) && (i1 <= 45055))
      {
        if (m != 0)
          paramStringBuffer.append('>');
        int i17 = i1 - 40960;
        if (k != 0)
          paramStringBuffer.append(paramString);
        paramStringBuffer.append('<');
        paramStringBuffer.append(this.objects[i17].toString());
        i = n + 2;
        m = 1;
        k = 0;
        break;
      }
      if ((i1 >= 45056) && (i1 <= 57343))
      {
        if (m != 0)
        {
          paramStringBuffer.append('>');
          m = 0;
        }
        if (k != 0)
          paramStringBuffer.append(paramString);
        while (true)
        {
          paramStringBuffer.append(i1 - 49152);
          i = n;
          break;
          k = 1;
        }
      }
      switch (i1)
      {
      case 61703:
      default:
        throw new Error("unknown code:" + i1);
      case 61712:
      case 61714:
        i = n + 4;
        break;
      case 61720:
        i = n + 2;
        break;
      case 61719:
        if (m != 0)
        {
          paramStringBuffer.append('>');
          m = 0;
        }
        int i15 = getIntN(n);
        int i16 = n + 2;
        paramStringBuffer.append("<!--");
        paramStringBuffer.append(this.data, i16, i15);
        paramStringBuffer.append("-->");
        i = i16 + i15;
        break;
      case 61717:
        if (m != 0)
        {
          paramStringBuffer.append('>');
          m = 0;
        }
        int i13 = getIntN(n);
        int i14 = n + 2;
        paramStringBuffer.append("<![CDATA[");
        paramStringBuffer.append(this.data, i14, i13);
        paramStringBuffer.append("]]>");
        i = i14 + i13;
        break;
      case 61716:
        if (m != 0)
        {
          paramStringBuffer.append('>');
          m = 0;
        }
        paramStringBuffer.append("<?");
        int i10 = getIntN(n);
        int i11 = n + 2;
        paramStringBuffer.append(this.objects[i10]);
        int i12 = getIntN(i11);
        i = i11 + 2;
        if (i12 > 0)
        {
          paramStringBuffer.append(' ');
          paramStringBuffer.append(this.data, i, i12);
          i += i12;
        }
        paramStringBuffer.append("?>");
        break;
      case 61713:
      case 61715:
        i = n;
        break;
      case 61696:
      case 61697:
        if (m != 0)
        {
          paramStringBuffer.append('>');
          m = 0;
        }
        if (k != 0)
        {
          paramStringBuffer.append(paramString);
          if (i1 == 61696)
            break label829;
        }
        for (boolean bool = true; ; bool = false)
        {
          paramStringBuffer.append(bool);
          i = n;
          break;
          k = 1;
          break label800;
        }
      case 61718:
        i = n;
        break;
      case 61702:
        if (m != 0)
        {
          paramStringBuffer.append('>');
          m = 0;
        }
        char[] arrayOfChar3 = this.data;
        int i9 = i1 + 1 - 61702;
        paramStringBuffer.append(arrayOfChar3, n, i9);
        i = n + 1;
        k = 0;
        break;
      case 61711:
        if (m != 0)
        {
          paramStringBuffer.append('>');
          m = 0;
        }
        if (k != 0)
          paramStringBuffer.append(paramString);
        while (true)
        {
          paramStringBuffer.append(((AbstractSequence)this.objects[getIntN(n)]).getIteratorAtPos(getIntN(n + 2)));
          i = n + 4;
          break;
          k = 1;
        }
      case 61709:
      case 61710:
        if (m != 0)
        {
          paramStringBuffer.append('>');
          m = 0;
        }
        if (k != 0)
          paramStringBuffer.append(paramString);
        while (true)
        {
          paramStringBuffer.append(this.objects[getIntN(n)]);
          i = n + 2;
          break;
          k = 1;
        }
      case 61704:
        int i5 = getIntN(n);
        int i6;
        int i8;
        if (i5 >= 0)
        {
          i6 = n - 1;
          int i7 = i5 + i6;
          i = n + 2;
          i8 = getIntN(i7 + 1);
          if (m == 0)
            break label1110;
          paramStringBuffer.append('>');
        }
        while (true)
        {
          paramStringBuffer.append('<');
          paramStringBuffer.append(this.objects[i8]);
          m = 1;
          k = 0;
          break;
          i6 = this.data.length;
          break label1038;
          if (k != 0)
            paramStringBuffer.append(paramString);
        }
      case 61707:
      case 61708:
        int i3;
        if (i1 == 61707)
        {
          char[] arrayOfChar2 = this.data;
          i = n + 1;
          int i4 = arrayOfChar2[n];
          i3 = this.data[(i - 2 - i4)] - 40960;
          if (m == 0)
            break label1204;
          paramStringBuffer.append("/>");
        }
        while (true)
        {
          k = 1;
          m = 0;
          break;
          i3 = getIntN(n);
          i = n + 6;
          break label1165;
          paramStringBuffer.append("</");
          paramStringBuffer.append(this.objects[i3]);
          paramStringBuffer.append('>');
        }
      case 61705:
        int i2 = getIntN(n);
        paramStringBuffer.append(' ');
        paramStringBuffer.append(this.objects[i2]);
        paramStringBuffer.append("=\"");
        i = n + 4;
        m = 0;
        break;
      case 61706:
        paramStringBuffer.append('"');
        m = 1;
        i = n;
        k = 0;
        break;
      case 61698:
        if (m != 0)
        {
          paramStringBuffer.append('>');
          m = 0;
        }
        if (k != 0)
          paramStringBuffer.append(paramString);
        while (true)
        {
          paramStringBuffer.append(getIntN(n));
          i = n + 2;
          break;
          k = 1;
        }
      case 61700:
        if (m != 0)
        {
          paramStringBuffer.append('>');
          m = 0;
        }
        if (k != 0)
          paramStringBuffer.append(paramString);
        while (true)
        {
          paramStringBuffer.append(Float.intBitsToFloat(getIntN(n)));
          i = n + 2;
          break;
          k = 1;
        }
      case 61699:
        if (m != 0)
        {
          paramStringBuffer.append('>');
          m = 0;
        }
        if (k != 0)
          paramStringBuffer.append(paramString);
        while (true)
        {
          paramStringBuffer.append(getLongN(n));
          i = n + 4;
          break;
          k = 1;
        }
      case 61701:
        label800: label829: label1110: if (m != 0)
        {
          paramStringBuffer.append('>');
          m = 0;
        }
        label1038: label1204: if (k != 0)
          paramStringBuffer.append(paramString);
        while (true)
        {
          label1165: paramStringBuffer.append(Double.longBitsToDouble(getLongN(n)));
          i = n + 4;
          break;
          k = 1;
        }
        label1509: n = i20;
      }
    }
  }

  public void write(int paramInt)
  {
    ensureSpace(3);
    if (paramInt <= 40959)
    {
      char[] arrayOfChar3 = this.data;
      int k = this.gapStart;
      this.gapStart = (k + 1);
      arrayOfChar3[k] = ((char)paramInt);
      return;
    }
    if (paramInt < 65536)
    {
      char[] arrayOfChar1 = this.data;
      int i = this.gapStart;
      this.gapStart = (i + 1);
      arrayOfChar1[i] = 61702;
      char[] arrayOfChar2 = this.data;
      int j = this.gapStart;
      this.gapStart = (j + 1);
      arrayOfChar2[j] = ((char)paramInt);
      return;
    }
    Char.print(paramInt, this);
  }

  public void write(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      writeJoiner();
    ensureSpace(paramInt2);
    int i = paramInt1;
    if (paramInt2 > 0)
    {
      int j = i + 1;
      int k = paramCharSequence.charAt(i);
      paramInt2--;
      if (k <= 40959)
      {
        char[] arrayOfChar = this.data;
        int m = this.gapStart;
        this.gapStart = (m + 1);
        arrayOfChar[m] = k;
      }
      while (true)
      {
        i = j;
        break;
        write(k);
        ensureSpace(paramInt2);
      }
    }
  }

  public void write(String paramString)
  {
    write(paramString, 0, paramString.length());
  }

  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      writeJoiner();
    ensureSpace(paramInt2);
    int i = paramInt1;
    if (paramInt2 > 0)
    {
      int j = i + 1;
      int k = paramArrayOfChar[i];
      paramInt2--;
      if (k <= 40959)
      {
        char[] arrayOfChar = this.data;
        int m = this.gapStart;
        this.gapStart = (m + 1);
        arrayOfChar[m] = k;
      }
      while (true)
      {
        i = j;
        break;
        write(k);
        ensureSpace(paramInt2);
      }
    }
  }

  public void writeBoolean(boolean paramBoolean)
  {
    ensureSpace(1);
    char[] arrayOfChar = this.data;
    int i = this.gapStart;
    this.gapStart = (i + 1);
    if (paramBoolean);
    for (int j = 61697; ; j = 61696)
    {
      arrayOfChar[i] = j;
      return;
    }
  }

  public void writeByte(int paramInt)
  {
    ensureSpace(1);
    char[] arrayOfChar = this.data;
    int i = this.gapStart;
    this.gapStart = (i + 1);
    arrayOfChar[i] = ((char)(61440 + (paramInt & 0xFF)));
  }

  public void writeCDATA(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    ensureSpace(paramInt2 + 3);
    int i = this.gapStart;
    char[] arrayOfChar = this.data;
    int j = i + 1;
    arrayOfChar[i] = 61717;
    setIntN(j, paramInt2);
    int k = j + 2;
    System.arraycopy(paramArrayOfChar, paramInt1, this.data, k, paramInt2);
    this.gapStart = (k + paramInt2);
  }

  public void writeComment(String paramString, int paramInt1, int paramInt2)
  {
    ensureSpace(paramInt2 + 3);
    int i = this.gapStart;
    char[] arrayOfChar = this.data;
    int j = i + 1;
    arrayOfChar[i] = 61719;
    setIntN(j, paramInt2);
    int k = j + 2;
    paramString.getChars(paramInt1, paramInt1 + paramInt2, this.data, k);
    this.gapStart = (k + paramInt2);
  }

  public void writeComment(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    ensureSpace(paramInt2 + 3);
    int i = this.gapStart;
    char[] arrayOfChar = this.data;
    int j = i + 1;
    arrayOfChar[i] = 61719;
    setIntN(j, paramInt2);
    int k = j + 2;
    System.arraycopy(paramArrayOfChar, paramInt1, this.data, k, paramInt2);
    this.gapStart = (k + paramInt2);
  }

  public void writeDocumentUri(Object paramObject)
  {
    ensureSpace(3);
    int i = find(paramObject);
    char[] arrayOfChar = this.data;
    int j = this.gapStart;
    this.gapStart = (j + 1);
    arrayOfChar[j] = 61720;
    setIntN(this.gapStart, i);
    this.gapStart = (2 + this.gapStart);
  }

  public void writeDouble(double paramDouble)
  {
    ensureSpace(5);
    long l = Double.doubleToLongBits(paramDouble);
    char[] arrayOfChar1 = this.data;
    int i = this.gapStart;
    this.gapStart = (i + 1);
    arrayOfChar1[i] = 61701;
    char[] arrayOfChar2 = this.data;
    int j = this.gapStart;
    this.gapStart = (j + 1);
    arrayOfChar2[j] = ((char)(int)(l >>> 48));
    char[] arrayOfChar3 = this.data;
    int k = this.gapStart;
    this.gapStart = (k + 1);
    arrayOfChar3[k] = ((char)(int)(l >>> 32));
    char[] arrayOfChar4 = this.data;
    int m = this.gapStart;
    this.gapStart = (m + 1);
    arrayOfChar4[m] = ((char)(int)(l >>> 16));
    char[] arrayOfChar5 = this.data;
    int n = this.gapStart;
    this.gapStart = (n + 1);
    arrayOfChar5[n] = ((char)(int)l);
  }

  public void writeFloat(float paramFloat)
  {
    ensureSpace(3);
    int i = Float.floatToIntBits(paramFloat);
    char[] arrayOfChar1 = this.data;
    int j = this.gapStart;
    this.gapStart = (j + 1);
    arrayOfChar1[j] = 61700;
    char[] arrayOfChar2 = this.data;
    int k = this.gapStart;
    this.gapStart = (k + 1);
    arrayOfChar2[k] = ((char)(i >>> 16));
    char[] arrayOfChar3 = this.data;
    int m = this.gapStart;
    this.gapStart = (m + 1);
    arrayOfChar3[m] = ((char)i);
  }

  public void writeInt(int paramInt)
  {
    ensureSpace(3);
    if ((paramInt >= -4096) && (paramInt <= 8191))
    {
      char[] arrayOfChar2 = this.data;
      int j = this.gapStart;
      this.gapStart = (j + 1);
      arrayOfChar2[j] = ((char)(49152 + paramInt));
      return;
    }
    char[] arrayOfChar1 = this.data;
    int i = this.gapStart;
    this.gapStart = (i + 1);
    arrayOfChar1[i] = 61698;
    setIntN(this.gapStart, paramInt);
    this.gapStart = (2 + this.gapStart);
  }

  public void writeJoiner()
  {
    ensureSpace(1);
    char[] arrayOfChar = this.data;
    int i = this.gapStart;
    this.gapStart = (i + 1);
    arrayOfChar[i] = 61718;
  }

  public void writeLong(long paramLong)
  {
    ensureSpace(5);
    char[] arrayOfChar1 = this.data;
    int i = this.gapStart;
    this.gapStart = (i + 1);
    arrayOfChar1[i] = 61699;
    char[] arrayOfChar2 = this.data;
    int j = this.gapStart;
    this.gapStart = (j + 1);
    arrayOfChar2[j] = ((char)(int)(paramLong >>> 48));
    char[] arrayOfChar3 = this.data;
    int k = this.gapStart;
    this.gapStart = (k + 1);
    arrayOfChar3[k] = ((char)(int)(paramLong >>> 32));
    char[] arrayOfChar4 = this.data;
    int m = this.gapStart;
    this.gapStart = (m + 1);
    arrayOfChar4[m] = ((char)(int)(paramLong >>> 16));
    char[] arrayOfChar5 = this.data;
    int n = this.gapStart;
    this.gapStart = (n + 1);
    arrayOfChar5[n] = ((char)(int)paramLong);
  }

  public void writeObject(Object paramObject)
  {
    ensureSpace(3);
    int i = find(paramObject);
    if (i < 4096)
    {
      char[] arrayOfChar2 = this.data;
      int k = this.gapStart;
      this.gapStart = (k + 1);
      arrayOfChar2[k] = ((char)(0xE000 | i));
      return;
    }
    char[] arrayOfChar1 = this.data;
    int j = this.gapStart;
    this.gapStart = (j + 1);
    arrayOfChar1[j] = 61709;
    setIntN(this.gapStart, i);
    this.gapStart = (2 + this.gapStart);
  }

  public void writePosition(AbstractSequence paramAbstractSequence, int paramInt)
  {
    ensureSpace(5);
    this.data[this.gapStart] = 61711;
    int i = find(paramAbstractSequence);
    setIntN(1 + this.gapStart, i);
    setIntN(3 + this.gapStart, paramInt);
    this.gapStart = (5 + this.gapStart);
  }

  public void writeProcessingInstruction(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    ensureSpace(paramInt2 + 5);
    int i = this.gapStart;
    char[] arrayOfChar = this.data;
    int j = i + 1;
    arrayOfChar[i] = 61716;
    setIntN(j, find(paramString1));
    setIntN(j + 2, paramInt2);
    int k = j + 4;
    paramString2.getChars(paramInt1, paramInt1 + paramInt2, this.data, k);
    this.gapStart = (k + paramInt2);
  }

  public void writeProcessingInstruction(String paramString, char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    ensureSpace(paramInt2 + 5);
    int i = this.gapStart;
    char[] arrayOfChar = this.data;
    int j = i + 1;
    arrayOfChar[i] = 61716;
    setIntN(j, find(paramString));
    setIntN(j + 2, paramInt2);
    int k = j + 4;
    System.arraycopy(paramArrayOfChar, paramInt1, this.data, k, paramInt2);
    this.gapStart = (k + paramInt2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.TreeList
 * JD-Core Version:    0.6.2
 */