package gnu.text;

import gnu.lists.LList;
import gnu.mapping.ThreadLocation;
import java.io.IOException;
import java.io.Writer;

public class PrettyWriter extends Writer
{
  private static final int BLOCK_PER_LINE_PREFIX_END = -3;
  private static final int BLOCK_PREFIX_LENGTH = -4;
  private static final int BLOCK_SECTION_COLUMN = -2;
  private static final int BLOCK_SECTION_START_LINE = -6;
  private static final int BLOCK_START_COLUMN = -1;
  private static final int BLOCK_SUFFIX_LENGTH = -5;
  private static final int LOGICAL_BLOCK_LENGTH = 6;
  public static final int NEWLINE_FILL = 70;
  public static final int NEWLINE_LINEAR = 78;
  public static final int NEWLINE_LITERAL = 76;
  public static final int NEWLINE_MANDATORY = 82;
  public static final int NEWLINE_MISER = 77;
  public static final int NEWLINE_SPACE = 83;
  static final int QITEM_BASE_SIZE = 2;
  static final int QITEM_BLOCK_END_SIZE = 2;
  static final int QITEM_BLOCK_END_TYPE = 5;
  static final int QITEM_BLOCK_START_BLOCK_END = 4;
  static final int QITEM_BLOCK_START_PREFIX = 5;
  static final int QITEM_BLOCK_START_SIZE = 7;
  static final int QITEM_BLOCK_START_SUFFIX = 6;
  static final int QITEM_BLOCK_START_TYPE = 4;
  static final int QITEM_INDENTATION_AMOUNT = 3;
  static final char QITEM_INDENTATION_BLOCK = 'B';
  static final char QITEM_INDENTATION_CURRENT = 'C';
  static final int QITEM_INDENTATION_KIND = 2;
  static final int QITEM_INDENTATION_SIZE = 4;
  static final int QITEM_INDENTATION_TYPE = 3;
  static final int QITEM_NEWLINE_KIND = 4;
  static final int QITEM_NEWLINE_SIZE = 5;
  static final int QITEM_NEWLINE_TYPE = 2;
  static final int QITEM_NOP_TYPE = 0;
  static final int QITEM_POSN = 1;
  static final int QITEM_SECTION_START_DEPTH = 2;
  static final int QITEM_SECTION_START_SECTION_END = 3;
  static final int QITEM_SECTION_START_SIZE = 4;
  static final int QITEM_TAB_COLINC = 4;
  static final int QITEM_TAB_COLNUM = 3;
  static final int QITEM_TAB_FLAGS = 2;
  static final int QITEM_TAB_IS_RELATIVE = 2;
  static final int QITEM_TAB_IS_SECTION = 1;
  static final int QITEM_TAB_SIZE = 5;
  static final int QITEM_TAB_TYPE = 6;
  static final int QITEM_TYPE_AND_SIZE = 0;
  static final int QUEUE_INIT_ALLOC_SIZE = 300;
  public static ThreadLocation indentLoc = new ThreadLocation("indent");
  public static int initialBufferSize = 126;
  public static ThreadLocation lineLengthLoc = new ThreadLocation("line-length");
  public static ThreadLocation miserWidthLoc = new ThreadLocation("miser-width");
  int blockDepth = 6;
  int[] blocks = new int[60];
  public char[] buffer = new char[initialBufferSize];
  public int bufferFillPointer;
  int bufferOffset;
  int bufferStartColumn;
  int currentBlock = -1;
  int lineLength = 80;
  int lineNumber;
  int miserWidth = 40;
  protected Writer out;
  public int pendingBlocksCount;
  char[] prefix = new char[initialBufferSize];
  int prettyPrintingMode;
  int[] queueInts = new int[300];
  int queueSize;
  String[] queueStrings = new String[300];
  int queueTail;
  char[] suffix = new char[initialBufferSize];
  boolean wordEndSeen;

  public PrettyWriter(Writer paramWriter)
  {
    this.out = paramWriter;
    this.prettyPrintingMode = 1;
  }

  public PrettyWriter(Writer paramWriter, int paramInt)
  {
    this.out = paramWriter;
    this.lineLength = paramInt;
    if (paramInt > 1);
    for (int i = 1; ; i = 0)
    {
      this.prettyPrintingMode = i;
      return;
    }
  }

  public PrettyWriter(Writer paramWriter, boolean paramBoolean)
  {
    this.out = paramWriter;
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      this.prettyPrintingMode = i;
      return;
    }
  }

  private static int enoughSpace(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * 2;
    int j = paramInt1 + (paramInt2 * 5 >> 2);
    if (i > j)
      return i;
    return j;
  }

  private int getPerLinePrefixEnd()
  {
    return this.blocks[(-3 + this.blockDepth)];
  }

  private int getPrefixLength()
  {
    return this.blocks[(-4 + this.blockDepth)];
  }

  private int getQueueSize(int paramInt)
  {
    return this.queueInts[paramInt] >> 16;
  }

  private int getQueueType(int paramInt)
  {
    return 0xFF & this.queueInts[paramInt];
  }

  private int getSectionColumn()
  {
    return this.blocks[(-2 + this.blockDepth)];
  }

  private int getSectionStartLine()
  {
    return this.blocks[(-6 + this.blockDepth)];
  }

  private int getStartColumn()
  {
    return this.blocks[(-1 + this.blockDepth)];
  }

  private int getSuffixLength()
  {
    return this.blocks[(-5 + this.blockDepth)];
  }

  private int indexPosn(int paramInt)
  {
    return paramInt + this.bufferOffset;
  }

  private int posnColumn(int paramInt)
  {
    return indexColumn(posnIndex(paramInt));
  }

  private int posnIndex(int paramInt)
  {
    return paramInt - this.bufferOffset;
  }

  private void pushLogicalBlock(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = 6 + this.blockDepth;
    if (i >= this.blocks.length)
    {
      int[] arrayOfInt = new int[2 * this.blocks.length];
      System.arraycopy(this.blocks, 0, arrayOfInt, 0, this.blockDepth);
      this.blocks = arrayOfInt;
    }
    this.blockDepth = i;
    this.blocks[(-1 + this.blockDepth)] = paramInt1;
    this.blocks[(-2 + this.blockDepth)] = paramInt1;
    this.blocks[(-3 + this.blockDepth)] = paramInt2;
    this.blocks[(-4 + this.blockDepth)] = paramInt3;
    this.blocks[(-5 + this.blockDepth)] = paramInt4;
    this.blocks[(-6 + this.blockDepth)] = paramInt5;
  }

  public void addIndentation(int paramInt, boolean paramBoolean)
  {
    if (this.prettyPrintingMode > 0)
      if (!paramBoolean)
        break label22;
    label22: for (char c = 'C'; ; c = 'B')
    {
      enqueueIndent(c, paramInt);
      return;
    }
  }

  public void clearBuffer()
  {
    this.bufferStartColumn = 0;
    this.bufferFillPointer = 0;
    this.lineNumber = 0;
    this.bufferOffset = 0;
    this.blockDepth = 6;
    this.queueTail = 0;
    this.queueSize = 0;
    this.pendingBlocksCount = 0;
  }

  public void clearWordEnd()
  {
    this.wordEndSeen = false;
  }

  public void close()
    throws IOException
  {
    if (this.out != null)
    {
      forcePrettyOutput();
      this.out.close();
      this.out = null;
    }
    this.buffer = null;
  }

  public void closeThis()
    throws IOException
  {
    if (this.out != null)
    {
      forcePrettyOutput();
      this.out = null;
    }
    this.buffer = null;
  }

  int computeTabSize(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.queueInts[(paramInt1 + 2)];
    int j;
    int k;
    if ((i & 0x1) != 0)
    {
      j = 1;
      if ((i & 0x2) == 0)
        break label99;
      k = 1;
      label30: if (j == 0)
        break label105;
    }
    int n;
    int i1;
    label99: label105: for (int m = paramInt2; ; m = 0)
    {
      n = this.queueInts[(paramInt1 + 3)];
      i1 = this.queueInts[(paramInt1 + 4)];
      if (k == 0)
        break label111;
      if (i1 > 1)
      {
        int i2 = (paramInt3 + n) % i1;
        if (i2 != 0)
          n += i2;
      }
      return n;
      j = 0;
      break;
      k = 0;
      break label30;
    }
    label111: if (paramInt3 <= n + m)
      return paramInt3 + m - paramInt3;
    return i1 - (paramInt3 - m) % i1;
  }

  public void endLogicalBlock()
  {
    int i = enqueue(5, 2);
    this.pendingBlocksCount -= 1;
    if (this.currentBlock < 0)
    {
      int i2 = this.blocks[(-5 + this.blockDepth)];
      int i3 = this.blocks[(-5 + (this.blockDepth - 6))];
      if (i2 > i3)
        write(this.suffix, this.suffix.length - i2, i2 - i3);
      this.currentBlock = -1;
      return;
    }
    int j = this.currentBlock;
    int k = this.queueInts[(j + 4)];
    if (k == 0)
      this.currentBlock = -1;
    while (true)
    {
      String str = this.queueStrings[(j + 6)];
      if (str != null)
        write(str);
      int i1 = i - j;
      if (i1 < 0)
        i1 += this.queueInts.length;
      this.queueInts[(j + 4)] = i1;
      return;
      int m = this.queueTail - j;
      if (m > 0)
        m -= this.queueInts.length;
      if (k < m)
      {
        this.currentBlock = -1;
      }
      else
      {
        int n = k + j;
        if (n < 0)
          n += this.queueInts.length;
        this.currentBlock = n;
      }
    }
  }

  public void endLogicalBlock(String paramString)
  {
    if (this.prettyPrintingMode > 0)
      endLogicalBlock();
    while (paramString == null)
      return;
    write(paramString);
  }

  public int enqueue(int paramInt1, int paramInt2)
  {
    int i = this.queueInts.length;
    int j = i - this.queueTail - this.queueSize;
    if ((j > 0) && (paramInt2 > j))
      enqueue(0, j);
    if (paramInt2 + this.queueSize > i)
    {
      int m = enoughSpace(i, paramInt2);
      int[] arrayOfInt = new int[m];
      String[] arrayOfString = new String[m];
      int n = this.queueTail + this.queueSize - i;
      if (n > 0)
      {
        System.arraycopy(this.queueInts, 0, arrayOfInt, 0, n);
        System.arraycopy(this.queueStrings, 0, arrayOfString, 0, n);
      }
      int i1 = i - this.queueTail;
      int i2 = m - i;
      System.arraycopy(this.queueInts, this.queueTail, arrayOfInt, i2 + this.queueTail, i1);
      System.arraycopy(this.queueStrings, this.queueTail, arrayOfString, i2 + this.queueTail, i1);
      this.queueInts = arrayOfInt;
      this.queueStrings = arrayOfString;
      if (this.currentBlock >= this.queueTail)
        this.currentBlock = (i2 + this.currentBlock);
      this.queueTail = (i2 + this.queueTail);
    }
    int k = this.queueTail + this.queueSize;
    if (k >= this.queueInts.length)
      k -= this.queueInts.length;
    this.queueInts[(k + 0)] = (paramInt1 | paramInt2 << 16);
    if (paramInt2 > 1)
      this.queueInts[(k + 1)] = indexPosn(this.bufferFillPointer);
    this.queueSize = (paramInt2 + this.queueSize);
    return k;
  }

  public int enqueueIndent(char paramChar, int paramInt)
  {
    int i = enqueue(3, 4);
    this.queueInts[(i + 2)] = paramChar;
    this.queueInts[(i + 3)] = paramInt;
    return i;
  }

  public void enqueueNewline(int paramInt)
  {
    this.wordEndSeen = false;
    int i = this.pendingBlocksCount;
    int j = enqueue(2, 5);
    this.queueInts[(j + 4)] = paramInt;
    this.queueInts[(j + 2)] = this.pendingBlocksCount;
    this.queueInts[(j + 3)] = 0;
    int k = this.queueTail;
    int m = this.queueSize;
    if (m > 0)
    {
      if (k == this.queueInts.length)
        k = 0;
      if (k != j);
    }
    else
    {
      if ((paramInt != 76) && (paramInt != 82))
        break label209;
    }
    label209: for (boolean bool = true; ; bool = false)
    {
      maybeOutput(bool, false);
      return;
      int n = getQueueType(k);
      if (((n == 2) || (n == 4)) && (this.queueInts[(k + 3)] == 0) && (i <= this.queueInts[(k + 2)]))
      {
        int i2 = j - k;
        if (i2 < 0)
          i2 += this.queueInts.length;
        this.queueInts[(k + 3)] = i2;
      }
      int i1 = getQueueSize(k);
      m -= i1;
      k += i1;
      break;
    }
  }

  int enqueueTab(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = enqueue(6, 5);
    this.queueInts[(i + 2)] = paramInt1;
    this.queueInts[(i + 3)] = paramInt2;
    this.queueInts[(i + 4)] = paramInt3;
    return i;
  }

  int ensureSpaceInBuffer(int paramInt)
  {
    char[] arrayOfChar1 = this.buffer;
    int i = arrayOfChar1.length;
    int j = this.bufferFillPointer;
    int k = i - j;
    if (k > 0)
      return k;
    if ((this.prettyPrintingMode > 0) && (j > this.lineLength))
    {
      if (!maybeOutput(false, false))
        outputPartialLine();
      return ensureSpaceInBuffer(paramInt);
    }
    int m = enoughSpace(i, paramInt);
    char[] arrayOfChar2 = new char[m];
    this.buffer = arrayOfChar2;
    int n = j;
    while (true)
    {
      n--;
      if (n < 0)
        break;
      arrayOfChar2[n] = arrayOfChar1[n];
    }
    return m - j;
  }

  void expandTabs(int paramInt)
  {
    int i = 0;
    int j = 0;
    int k = this.bufferStartColumn;
    int m = getSectionColumn();
    int n = this.queueTail;
    int i1 = this.queueSize;
    int i2 = 6 * this.pendingBlocksCount;
    char[] arrayOfChar1;
    char[] arrayOfChar2;
    int i6;
    int i7;
    if (i1 > 0)
    {
      int i13 = this.queueInts.length;
      if (n == i13)
        n = 0;
      if (n != paramInt);
    }
    else
    {
      if (i <= 0)
        return;
      int i3 = this.bufferFillPointer;
      int i4 = i3 + j;
      arrayOfChar1 = this.buffer;
      arrayOfChar2 = arrayOfChar1;
      int i5 = arrayOfChar1.length;
      i6 = i3;
      if (i4 > i5)
      {
        arrayOfChar2 = new char[enoughSpace(i3, j)];
        this.buffer = arrayOfChar2;
      }
      this.bufferFillPointer = i4;
      this.bufferOffset -= j;
      i7 = i;
    }
    while (true)
    {
      i7--;
      if (i7 < 0)
        break label445;
      int i8 = this.blocks[(i2 + i7 * 2)];
      int i9 = this.blocks[(1 + (i2 + i7 * 2))];
      int i10 = i8 + j;
      int i11 = i6 - i8;
      System.arraycopy(arrayOfChar1, i8, arrayOfChar2, i10, i11);
      int i12 = i10 - i9;
      while (i12 < i10)
      {
        arrayOfChar2[i12] = ' ';
        i12++;
        continue;
        if (getQueueType(n) == 6)
        {
          int i15 = posnIndex(this.queueInts[(n + 1)]);
          int i16 = k + i15;
          int i17 = computeTabSize(n, m, i16);
          if (i17 != 0)
          {
            if (1 + (i2 + i * 2) >= this.blocks.length)
            {
              int[] arrayOfInt = new int[2 * this.blocks.length];
              System.arraycopy(this.blocks, 0, arrayOfInt, 0, this.blocks.length);
              this.blocks = arrayOfInt;
            }
            this.blocks[(i2 + i * 2)] = i15;
            this.blocks[(1 + (i2 + i * 2))] = i17;
            i++;
            j += i17;
            k += i17;
          }
        }
        while (true)
        {
          int i14 = getQueueSize(n);
          i1 -= i14;
          n += i14;
          break;
          if ((n == 2) || (n == 4))
            m = k + posnIndex(this.queueInts[(n + 1)]);
        }
      }
      j -= i9;
      i6 = i8;
    }
    label445: if (arrayOfChar2 != arrayOfChar1)
      System.arraycopy(arrayOfChar1, 0, arrayOfChar2, 0, i6);
  }

  int fitsOnLine(int paramInt, boolean paramBoolean)
  {
    int i = this.lineLength;
    if ((!printReadably()) && (getMaxLines() == this.lineNumber))
      i = i - 3 - getSuffixLength();
    if (paramInt >= 0)
    {
      if (posnColumn(this.queueInts[(paramInt + 1)]) <= i)
        return 1;
      return -1;
    }
    if (paramBoolean)
      return -1;
    if (indexColumn(this.bufferFillPointer) > i)
      return -1;
    return 0;
  }

  public void flush()
  {
    if (this.out == null)
      return;
    try
    {
      forcePrettyOutput();
      this.out.flush();
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException.toString());
    }
  }

  public void forcePrettyOutput()
    throws IOException
  {
    maybeOutput(false, true);
    if (this.bufferFillPointer > 0)
      outputPartialLine();
    expandTabs(-1);
    this.bufferStartColumn = getColumnNumber();
    this.out.write(this.buffer, 0, this.bufferFillPointer);
    this.bufferFillPointer = 0;
    this.queueSize = 0;
  }

  public int getColumnNumber()
  {
    int i = this.bufferFillPointer;
    int j;
    do
    {
      i--;
      if (i < 0)
        return this.bufferStartColumn + this.bufferFillPointer;
      j = this.buffer[i];
    }
    while ((j != 10) && (j != 13));
    return this.bufferFillPointer - (i + 1);
  }

  int getMaxLines()
  {
    return -1;
  }

  protected int getMiserWidth()
  {
    return this.miserWidth;
  }

  public int getPrettyPrintingMode()
  {
    return this.prettyPrintingMode;
  }

  int indexColumn(int paramInt)
  {
    int i = this.bufferStartColumn;
    int j = getSectionColumn();
    int k = indexPosn(paramInt);
    int m = this.queueTail;
    int n = this.queueSize;
    int i1;
    int i3;
    if (n > 0)
    {
      if (m >= this.queueInts.length)
        m = 0;
      i1 = getQueueType(m);
      if (i1 == 0)
        break label107;
      i3 = this.queueInts[(m + 1)];
      if (i3 < k);
    }
    else
    {
      return i + paramInt;
    }
    if (i1 == 6)
      i += computeTabSize(m, j, i + posnIndex(i3));
    while (true)
    {
      label107: int i2 = getQueueSize(m);
      n -= i2;
      m += i2;
      break;
      if ((i1 == 2) || (i1 == 4))
        j = i + posnIndex(this.queueInts[(m + 1)]);
    }
  }

  boolean isMisering()
  {
    int i = getMiserWidth();
    return (i > 0) && (this.lineLength - getStartColumn() <= i);
  }

  public boolean isPrettyPrinting()
  {
    return this.prettyPrintingMode > 0;
  }

  public void lineAbbreviationHappened()
  {
  }

  boolean maybeOutput(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = false;
    if (this.queueSize > 0)
    {
      if (this.queueTail >= this.queueInts.length)
        this.queueTail = 0;
      int i = this.queueTail;
      switch (getQueueType(i))
      {
      default:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      }
      while (true)
      {
        int j = getQueueSize(this.queueTail);
        this.queueSize -= j;
        this.queueTail = (i + j);
        break;
        int i6 = -1;
        boolean bool2;
        switch (this.queueInts[(i + 4)])
        {
        default:
          bool2 = true;
        case 77:
        case 70:
        case 83:
        }
        while (bool2)
        {
          while (true)
          {
            bool1 = true;
            if ((!paramBoolean2) || (i6 != 0))
              break label315;
            try
            {
              outputPartialLine();
            }
            catch (IOException localIOException)
            {
              RuntimeException localRuntimeException = new RuntimeException(localIOException);
              throw localRuntimeException;
            }
          }
          bool2 = isMisering();
          continue;
          if ((isMisering()) || (this.lineNumber > getSectionStartLine()))
          {
            bool2 = true;
          }
          else
          {
            int i7 = this.queueInts[(i + 3)];
            int i8;
            if (i7 == 0)
              i8 = -1;
            while (true)
            {
              i6 = fitsOnLine(i8, paramBoolean1);
              if (i6 <= 0)
                break label300;
              bool2 = false;
              break;
              i8 = i7 + i;
              int i9 = this.queueInts.length;
              if (i8 >= i9)
                i8 -= this.queueInts.length;
            }
            label300: if ((i6 >= 0) && (!paramBoolean2))
              break label588;
            bool2 = true;
          }
        }
        label315: outputLine(i);
        continue;
        if (!isMisering())
        {
          int i3 = this.queueInts[(i + 2)];
          int i4 = this.queueInts[(i + 3)];
          if (i3 == 66);
          for (int i5 = i4 + getStartColumn(); ; i5 = i4 + posnColumn(this.queueInts[(i + 1)]))
          {
            setIndentation(i5);
            break;
          }
          int k = i;
          int m = this.queueInts[(i + 3)];
          int n;
          label432: int i1;
          if (m > 0)
          {
            n = (m + i) % this.queueInts.length;
            i1 = fitsOnLine(n, paramBoolean1);
            if (i1 <= 0)
              break label516;
            int i2 = this.queueInts[(i + 4)];
            i = (i2 + i) % this.queueInts.length;
            expandTabs(i);
            this.queueTail = i;
            this.queueSize -= i2;
          }
          while (this.currentBlock == k)
          {
            this.currentBlock = -1;
            break;
            n = -1;
            break label432;
            label516: if ((i1 >= 0) && (!paramBoolean2))
              break label588;
            String str1 = this.queueStrings[(i + 5)];
            String str2 = this.queueStrings[(i + 6)];
            reallyStartLogicalBlock(posnColumn(this.queueInts[(i + 1)]), str1, str2);
          }
          reallyEndLogicalBlock();
          continue;
          expandTabs(i);
        }
      }
    }
    label588: return bool1;
  }

  void outputLine(int paramInt)
    throws IOException
  {
    char[] arrayOfChar1 = this.buffer;
    int i;
    int j;
    int m;
    label42: int n;
    int i1;
    if (this.queueInts[(paramInt + 4)] == 76)
    {
      i = 1;
      j = posnIndex(this.queueInts[(paramInt + 1)]);
      if (i == 0)
        break label309;
      m = j;
      this.out.write(arrayOfChar1, 0, m);
      n = 1 + this.lineNumber;
      if (!printReadably())
      {
        int i7 = getMaxLines();
        if ((i7 > 0) && (n >= i7))
        {
          this.out.write(" ..");
          int i8 = getSuffixLength();
          if (i8 != 0)
          {
            char[] arrayOfChar3 = this.suffix;
            int i9 = arrayOfChar3.length;
            this.out.write(arrayOfChar3, i9 - i8, i8);
          }
          lineAbbreviationHappened();
        }
      }
      this.lineNumber = n;
      this.out.write(10);
      this.bufferStartColumn = 0;
      i1 = this.bufferFillPointer;
      if (i == 0)
        break label345;
    }
    label309: label345: for (int i2 = getPerLinePrefixEnd(); ; i2 = getPrefixLength())
    {
      int i3 = j - i2;
      int i4 = i1 - i3;
      char[] arrayOfChar2 = arrayOfChar1;
      int i5 = arrayOfChar1.length;
      if (i4 > i5)
      {
        arrayOfChar2 = new char[enoughSpace(i5, i4 - i5)];
        this.buffer = arrayOfChar2;
      }
      int i6 = i1 - j;
      System.arraycopy(arrayOfChar1, j, arrayOfChar2, i2, i6);
      System.arraycopy(this.prefix, 0, arrayOfChar2, 0, i2);
      this.bufferFillPointer = i4;
      this.bufferOffset = (i3 + this.bufferOffset);
      if (i == 0)
      {
        this.blocks[(-2 + this.blockDepth)] = i2;
        this.blocks[(-6 + this.blockDepth)] = n;
      }
      return;
      i = 0;
      break;
      int k = j;
      do
      {
        k--;
        if (k < 0)
        {
          m = 0;
          break;
        }
      }
      while (arrayOfChar1[k] == ' ');
      m = k + 1;
      break label42;
    }
  }

  void outputPartialLine()
  {
    int i = this.queueTail;
    while ((this.queueSize > 0) && (getQueueType(i) == 0))
    {
      int n = getQueueSize(i);
      this.queueSize -= n;
      i += n;
      if (i == this.queueInts.length)
        i = 0;
      this.queueTail = i;
    }
    int j = this.bufferFillPointer;
    if (this.queueSize > 0);
    int m;
    for (int k = posnIndex(this.queueInts[(i + 1)]); ; k = j)
    {
      m = j - k;
      if (k > 0)
        break;
      throw new Error("outputPartialLine called when nothing can be output.");
    }
    try
    {
      this.out.write(this.buffer, 0, k);
      this.bufferFillPointer = k;
      this.bufferStartColumn = getColumnNumber();
      System.arraycopy(this.buffer, k, this.buffer, 0, m);
      this.bufferFillPointer = m;
      this.bufferOffset = (k + this.bufferOffset);
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }

  boolean printReadably()
  {
    return true;
  }

  void reallyEndLogicalBlock()
  {
    int i = getPrefixLength();
    this.blockDepth -= 6;
    int j = getPrefixLength();
    if (j > i)
      for (int k = i; k < j; k++)
        this.prefix[k] = ' ';
  }

  void reallyStartLogicalBlock(int paramInt, String paramString1, String paramString2)
  {
    int i = getPerLinePrefixEnd();
    int j = getPrefixLength();
    int k = getSuffixLength();
    pushLogicalBlock(paramInt, i, j, k, this.lineNumber);
    setIndentation(paramInt);
    if (paramString1 != null)
    {
      this.blocks[(-3 + this.blockDepth)] = paramInt;
      int i3 = paramString1.length();
      paramString1.getChars(0, i3, this.suffix, paramInt - i3);
    }
    if (paramString2 != null)
    {
      char[] arrayOfChar = this.suffix;
      int m = arrayOfChar.length;
      int n = paramString2.length();
      int i1 = k + n;
      if (i1 > m)
      {
        int i2 = enoughSpace(m, n);
        this.suffix = new char[i2];
        System.arraycopy(arrayOfChar, m - k, this.suffix, i2 - k, k);
        m = i2;
      }
      paramString2.getChars(0, n, arrayOfChar, m - i1);
      this.blocks[(-5 + this.blockDepth)] = i1;
    }
  }

  public void setColumnNumber(int paramInt)
  {
    this.bufferStartColumn += paramInt - getColumnNumber();
  }

  public void setIndentation(int paramInt)
  {
    char[] arrayOfChar = this.prefix;
    int i = arrayOfChar.length;
    int j = getPrefixLength();
    int k = getPerLinePrefixEnd();
    if (k > paramInt)
      paramInt = k;
    if (paramInt > i)
    {
      arrayOfChar = new char[enoughSpace(i, paramInt - i)];
      System.arraycopy(this.prefix, 0, arrayOfChar, 0, j);
      this.prefix = arrayOfChar;
    }
    if (paramInt > j)
      for (int m = j; m < paramInt; m++)
        arrayOfChar[m] = ' ';
    this.blocks[(-4 + this.blockDepth)] = paramInt;
  }

  public void setPrettyPrinting(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 0; ; i = 1)
    {
      this.prettyPrintingMode = i;
      return;
    }
  }

  public void setPrettyPrintingMode(int paramInt)
  {
    this.prettyPrintingMode = paramInt;
  }

  public void startLogicalBlock(String paramString1, boolean paramBoolean, String paramString2)
  {
    Object localObject1;
    Object localObject2;
    if ((this.queueSize == 0) && (this.bufferFillPointer == 0))
    {
      localObject1 = lineLengthLoc.get(null);
      if (localObject1 != null)
        break label94;
      this.lineLength = 80;
      localObject2 = miserWidthLoc.get(null);
      if ((localObject2 != null) && (localObject2 != Boolean.FALSE) && (localObject2 != LList.Empty))
        break label109;
    }
    label94: label109: for (this.miserWidth = -1; ; this.miserWidth = Integer.parseInt(localObject2.toString()))
    {
      indentLoc.get(null);
      if (paramString1 != null)
        write(paramString1);
      if (this.prettyPrintingMode != 0)
        break label124;
      return;
      this.lineLength = Integer.parseInt(localObject1.toString());
      break;
    }
    label124: int i = enqueue(4, 7);
    this.queueInts[(i + 2)] = this.pendingBlocksCount;
    String[] arrayOfString = this.queueStrings;
    int j = i + 5;
    String str;
    int k;
    int m;
    if (paramBoolean)
    {
      str = paramString1;
      arrayOfString[j] = str;
      this.queueStrings[(i + 6)] = paramString2;
      this.pendingBlocksCount = (1 + this.pendingBlocksCount);
      k = this.currentBlock;
      if (k >= 0)
        break label241;
      m = 0;
    }
    while (true)
    {
      this.queueInts[(i + 4)] = m;
      this.queueInts[(i + 3)] = 0;
      this.currentBlock = i;
      return;
      str = null;
      break;
      label241: m = k - i;
      if (m > 0)
        m -= this.queueInts.length;
    }
  }

  public void write(int paramInt)
  {
    this.wordEndSeen = false;
    if ((paramInt == 10) && (this.prettyPrintingMode > 0))
      enqueueNewline(76);
    do
    {
      return;
      ensureSpaceInBuffer(1);
      int i = this.bufferFillPointer;
      this.buffer[i] = ((char)paramInt);
      this.bufferFillPointer = (i + 1);
    }
    while ((paramInt != 32) || (this.prettyPrintingMode <= 1) || (this.currentBlock >= 0));
    enqueueNewline(83);
  }

  public void write(String paramString)
  {
    write(paramString, 0, paramString.length());
  }

  public void write(String paramString, int paramInt1, int paramInt2)
  {
    this.wordEndSeen = false;
    while (paramInt2 > 0)
    {
      int i = paramInt2;
      int j = ensureSpaceInBuffer(paramInt2);
      if (i > j)
        i = j;
      int k = this.bufferFillPointer;
      paramInt2 -= i;
      int m = k;
      int n = paramInt1;
      i--;
      if (i >= 0)
      {
        int i1 = n + 1;
        int i2 = paramString.charAt(n);
        if ((i2 == 10) && (this.prettyPrintingMode > 0))
        {
          this.bufferFillPointer = m;
          enqueueNewline(76);
        }
        for (int i3 = this.bufferFillPointer; ; i3 = this.bufferFillPointer)
        {
          do
          {
            m = i3;
            n = i1;
            break;
            char[] arrayOfChar = this.buffer;
            i3 = m + 1;
            arrayOfChar[m] = i2;
          }
          while ((i2 != 32) || (this.prettyPrintingMode <= 1) || (this.currentBlock >= 0));
          this.bufferFillPointer = i3;
          enqueueNewline(83);
        }
      }
      this.bufferFillPointer = m;
      paramInt1 = n;
    }
  }

  public void write(char[] paramArrayOfChar)
  {
    write(paramArrayOfChar, 0, paramArrayOfChar.length);
  }

  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.wordEndSeen = false;
    int i = paramInt1 + paramInt2;
    while (paramInt2 > 0)
    {
      for (int j = paramInt1; ; j++)
      {
        if (j >= i)
          break label96;
        if (this.prettyPrintingMode > 0)
        {
          int i5 = paramArrayOfChar[j];
          if ((i5 == 10) || ((i5 == 32) && (this.currentBlock < 0)))
          {
            write(paramArrayOfChar, paramInt1, j - paramInt1);
            write(i5);
            paramInt1 = j + 1;
            paramInt2 = i - paramInt1;
            break;
          }
        }
      }
      int i3;
      label96: 
      do
      {
        paramInt1 = i3;
        int k = ensureSpaceInBuffer(paramInt2);
        if (k < paramInt2);
        int i1;
        for (int m = k; ; m = paramInt2)
        {
          int n = this.bufferFillPointer;
          i1 = n + m;
          int i2 = n;
          int i4;
          for (i3 = paramInt1; i2 < i1; i3 = i4)
          {
            char[] arrayOfChar = this.buffer;
            i4 = i3 + 1;
            arrayOfChar[i2] = paramArrayOfChar[i3];
            i2++;
          }
        }
        this.bufferFillPointer = i1;
        paramInt2 -= m;
      }
      while (paramInt2 != 0);
      paramInt1 = i3;
    }
  }

  public final void writeBreak(int paramInt)
  {
    if (this.prettyPrintingMode > 0)
      enqueueNewline(paramInt);
  }

  public void writeWordEnd()
  {
    this.wordEndSeen = true;
  }

  public void writeWordStart()
  {
    if (this.wordEndSeen)
      write(32);
    this.wordEndSeen = false;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.PrettyWriter
 * JD-Core Version:    0.6.2
 */