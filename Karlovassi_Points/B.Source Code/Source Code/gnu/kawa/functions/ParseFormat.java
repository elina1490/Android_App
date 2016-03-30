package gnu.kawa.functions;

import gnu.mapping.Procedure1;
import gnu.text.CompoundFormat;
import gnu.text.LineBufferedReader;
import gnu.text.LiteralFormat;
import gnu.text.PadFormat;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.util.Vector;

public class ParseFormat extends Procedure1
{
  public static final int PARAM_FROM_LIST = -1610612736;
  public static final int PARAM_UNSPECIFIED = -1073741824;
  public static final int SEEN_HASH = 16;
  public static final int SEEN_MINUS = 1;
  public static final int SEEN_PLUS = 2;
  public static final int SEEN_SPACE = 4;
  public static final int SEEN_ZERO = 8;
  public static final ParseFormat parseFormat = new ParseFormat(false);
  boolean emacsStyle = true;

  public ParseFormat(boolean paramBoolean)
  {
    this.emacsStyle = paramBoolean;
  }

  // ERROR //
  public static ReportFormat asFormat(Object paramObject, char paramChar)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 45
    //   4: ifeq +8 -> 12
    //   7: aload_0
    //   8: checkcast 45	gnu/text/ReportFormat
    //   11: areturn
    //   12: iload_1
    //   13: bipush 126
    //   15: if_icmpne +54 -> 69
    //   18: new 47	gnu/kawa/functions/LispFormat
    //   21: dup
    //   22: aload_0
    //   23: invokevirtual 53	java/lang/Object:toString	()Ljava/lang/String;
    //   26: invokespecial 56	gnu/kawa/functions/LispFormat:<init>	(Ljava/lang/String;)V
    //   29: astore 5
    //   31: aload 5
    //   33: areturn
    //   34: astore 4
    //   36: new 58	java/lang/RuntimeException
    //   39: dup
    //   40: new 60	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   47: ldc 63
    //   49: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload 4
    //   54: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: ldc 72
    //   59: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokespecial 74	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   68: athrow
    //   69: aload_0
    //   70: instanceof 76
    //   73: ifeq +77 -> 150
    //   76: aload_0
    //   77: checkcast 76	gnu/lists/FString
    //   80: astore 9
    //   82: new 78	gnu/mapping/CharArrayInPort
    //   85: dup
    //   86: aload 9
    //   88: getfield 82	gnu/lists/FString:data	[C
    //   91: aload 9
    //   93: getfield 85	gnu/lists/FString:size	I
    //   96: invokespecial 88	gnu/mapping/CharArrayInPort:<init>	([CI)V
    //   99: astore 6
    //   101: aload 6
    //   103: iload_1
    //   104: invokestatic 91	gnu/kawa/functions/ParseFormat:parseFormat	(Lgnu/text/LineBufferedReader;C)Lgnu/text/ReportFormat;
    //   107: astore 8
    //   109: aload 6
    //   111: invokevirtual 96	gnu/mapping/InPort:close	()V
    //   114: aload 8
    //   116: areturn
    //   117: astore_3
    //   118: new 58	java/lang/RuntimeException
    //   121: dup
    //   122: new 60	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   129: ldc 98
    //   131: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_3
    //   135: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: ldc 72
    //   140: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokespecial 74	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   149: athrow
    //   150: new 78	gnu/mapping/CharArrayInPort
    //   153: dup
    //   154: aload_0
    //   155: invokevirtual 53	java/lang/Object:toString	()Ljava/lang/String;
    //   158: invokespecial 99	gnu/mapping/CharArrayInPort:<init>	(Ljava/lang/String;)V
    //   161: astore 6
    //   163: goto -62 -> 101
    //   166: astore 7
    //   168: aload 6
    //   170: invokevirtual 96	gnu/mapping/InPort:close	()V
    //   173: aload 7
    //   175: athrow
    //   176: astore_2
    //   177: new 58	java/lang/RuntimeException
    //   180: dup
    //   181: ldc 101
    //   183: invokespecial 74	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   186: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	12	34	java/io/IOException
    //   18	31	34	java/io/IOException
    //   69	101	34	java/io/IOException
    //   109	114	34	java/io/IOException
    //   150	163	34	java/io/IOException
    //   168	176	34	java/io/IOException
    //   0	12	117	java/text/ParseException
    //   18	31	117	java/text/ParseException
    //   69	101	117	java/text/ParseException
    //   109	114	117	java/text/ParseException
    //   150	163	117	java/text/ParseException
    //   168	176	117	java/text/ParseException
    //   101	109	166	finally
    //   0	12	176	java/lang/IndexOutOfBoundsException
    //   18	31	176	java/lang/IndexOutOfBoundsException
    //   69	101	176	java/lang/IndexOutOfBoundsException
    //   109	114	176	java/lang/IndexOutOfBoundsException
    //   150	163	176	java/lang/IndexOutOfBoundsException
    //   168	176	176	java/lang/IndexOutOfBoundsException
  }

  public static ReportFormat parseFormat(LineBufferedReader paramLineBufferedReader, char paramChar)
    throws ParseException, IOException
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    Vector localVector = new Vector();
    int i = 0;
    char c1;
    while (true)
    {
      c1 = paramLineBufferedReader.read();
      if (c1 < 0)
        break;
      if (c1 != paramChar)
      {
        localStringBuffer.append((char)c1);
      }
      else
      {
        c1 = paramLineBufferedReader.read();
        if (c1 != paramChar)
          break;
        localStringBuffer.append((char)c1);
      }
    }
    int j = localStringBuffer.length();
    if (j > 0)
    {
      char[] arrayOfChar = new char[j];
      localStringBuffer.getChars(0, j, arrayOfChar, 0);
      localStringBuffer.setLength(0);
      localVector.addElement(new LiteralFormat(arrayOfChar));
    }
    int i18;
    int i15;
    int i16;
    if (c1 < 0)
    {
      i18 = localVector.size();
      if (i18 == 1)
      {
        Object localObject3 = localVector.elementAt(0);
        if ((localObject3 instanceof ReportFormat))
          return (ReportFormat)localObject3;
      }
    }
    else
    {
      if (c1 != '$')
        break label1020;
      i15 = Character.digit((char)paramLineBufferedReader.read(), 10);
      if (i15 >= 0)
        break label1013;
      ParseException localParseException2 = new ParseException("missing number (position) after '%$'", -1);
      throw localParseException2;
      int i17;
      label204: 
      do
      {
        i16 = i17 + i16 * 10;
        c1 = paramLineBufferedReader.read();
        i17 = Character.digit((char)c1, 10);
      }
      while (i17 >= 0);
    }
    label336: label740: label888: label1020: for (int k = i16 - 1; ; k = i)
    {
      int m = 0;
      int i1;
      int i2;
      int i14;
      int i3;
      switch ((char)c1)
      {
      default:
        i1 = -1073741824;
        i2 = Character.digit((char)c1, 10);
        if (i2 >= 0)
        {
          i1 = i2;
          c1 = paramLineBufferedReader.read();
          i14 = Character.digit((char)c1, 10);
          if (i14 < 0)
            i3 = i14;
        }
        break;
      case '-':
      case '+':
      case ' ':
      case '0':
      case '#':
      }
      while (true)
      {
        int i4 = -1073741824;
        int i5;
        if (c1 == '.')
          if (c1 == '*')
          {
            i4 = -1610612736;
            i5 = c1;
          }
        while (true)
        {
          boolean bool;
          label636: Object localObject1;
          int i6;
          char c2;
          int i7;
          switch (i5)
          {
          default:
            ParseException localParseException1 = new ParseException("unknown format character '" + i5 + "'", -1);
            throw localParseException1;
            int n = m | 0x1;
            while (true)
            {
              c1 = paramLineBufferedReader.read();
              m = n;
              break;
              n = m | 0x2;
              continue;
              n = m | 0x4;
              continue;
              n = m | 0x8;
              continue;
              n = m | 0x10;
            }
            i1 = i14 + i1 * 10;
            break;
            if (c1 != '*')
              break label1006;
            i1 = -1610612736;
            i3 = i2;
            break label336;
            int i13;
            for (i4 = 0; ; i4 = i13 + i4 * 10)
            {
              int i12 = paramLineBufferedReader.read();
              i13 = Character.digit((char)i12, 10);
              if (i13 < 0)
              {
                i5 = i12;
                break;
              }
            }
          case 83:
          case 115:
            if (i5 == 83)
            {
              bool = true;
              localObject1 = new ObjectFormat(bool, i4);
              i6 = m;
              if (i1 <= 0)
                break label989;
              if ((i6 & 0x8) == 0)
                break label936;
              c2 = '0';
              if ((i6 & 0x1) == 0)
                break label943;
              i7 = 100;
            }
          case 88:
          case 100:
          case 105:
          case 111:
          case 120:
          case 101:
          case 102:
          case 103:
            for (Object localObject2 = new PadFormat((Format)localObject1, i1, c2, i7); ; localObject2 = localObject1)
            {
              localVector.addElement(localObject2);
              i = k + 1;
              break;
              bool = false;
              break label636;
              int i8 = 0;
              int i9;
              if ((i5 == 100) || (i5 == 105))
              {
                i9 = 10;
                if ((m & 0x9) != 8)
                  break label888;
              }
              for (int i10 = 48; ; i10 = 32)
              {
                if ((m & 0x10) != 0)
                  i8 |= 8;
                if ((m & 0x2) != 0)
                  i8 |= 2;
                if ((m & 0x1) != 0)
                  i8 |= 16;
                if ((m & 0x4) != 0)
                  i8 |= 4;
                if (i4 == -1073741824)
                  break label895;
                int i11 = m & 0xFFFFFFF7;
                localObject1 = IntegerFormat.getInstance(i9, i4, 48, -1073741824, -1073741824, i8 | 0x40);
                i6 = i11;
                break;
                if (i5 == 111)
                {
                  i9 = 8;
                  i8 = 0;
                  break label740;
                }
                i9 = 16;
                i8 = 0;
                if (i5 != 88)
                  break label740;
                i8 = 32;
                break label740;
              }
              label895: localObject1 = IntegerFormat.getInstance(i9, i1, i10, -1073741824, -1073741824, i8);
              i6 = m;
              break label653;
              localObject1 = new ObjectFormat(false);
              i6 = m;
              break label653;
              c2 = ' ';
              break label670;
              if (c2 == '0')
              {
                i7 = -1;
                break label681;
              }
              i7 = 0;
              break label681;
              Format[] arrayOfFormat = new Format[i18];
              localVector.copyInto(arrayOfFormat);
              CompoundFormat localCompoundFormat = new CompoundFormat(arrayOfFormat);
              return localCompoundFormat;
            }
            i5 = c1;
          }
        }
        i3 = i2;
      }
      i16 = i15;
      break label204;
    }
  }

  public Object apply1(Object paramObject)
  {
    if (this.emacsStyle);
    for (char c = '?'; ; c = '~')
      return asFormat(paramObject, c);
  }

  public ReportFormat parseFormat(LineBufferedReader paramLineBufferedReader)
    throws ParseException, IOException
  {
    if (this.emacsStyle);
    for (char c = '?'; ; c = '~')
      return parseFormat(paramLineBufferedReader, c);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.ParseFormat
 * JD-Core Version:    0.6.2
 */