package gnu.kawa.lispexpr;

import gnu.expr.Keyword;
import gnu.expr.QuoteExp;
import gnu.expr.Special;
import gnu.kawa.util.GeneralHashTable;
import gnu.lists.Convert;
import gnu.lists.F32Vector;
import gnu.lists.F64Vector;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.S16Vector;
import gnu.lists.S32Vector;
import gnu.lists.S64Vector;
import gnu.lists.S8Vector;
import gnu.lists.Sequence;
import gnu.lists.SimpleVector;
import gnu.lists.U16Vector;
import gnu.lists.U32Vector;
import gnu.lists.U64Vector;
import gnu.lists.U8Vector;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.Complex;
import gnu.math.DComplex;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.RatNum;
import gnu.math.RealNum;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.math.BigDecimal;

public class LispReader extends Lexer
{
  static final int SCM_COMPLEX = 1;
  public static final int SCM_NUMBERS = 1;
  public static final char TOKEN_ESCAPE_CHAR = 'èøø';
  protected boolean seenEscapes;
  GeneralHashTable<Integer, Object> sharedStructureTable;

  public LispReader(LineBufferedReader paramLineBufferedReader)
  {
    super(paramLineBufferedReader);
  }

  public LispReader(LineBufferedReader paramLineBufferedReader, SourceMessages paramSourceMessages)
  {
    super(paramLineBufferedReader, paramSourceMessages);
  }

  static char getReadCase()
  {
    try
    {
      char c = Environment.getCurrent().get("symbol-read-case", "P").toString().charAt(0);
      if (c == 'P');
      do
      {
        return c;
        if (c == 'u')
          return 'U';
        if ((c == 'd') || (c == 'l') || (c == 'L'))
          return 'D';
      }
      while (c != 'i');
      return 'I';
    }
    catch (Exception localException)
    {
    }
    return 'P';
  }

  private boolean isPotentialNumber(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramInt1;
    if (j < paramInt2)
    {
      char c = paramArrayOfChar[j];
      if (Character.isDigit(c))
        i++;
      label59: label105: 
      do
      {
        do
        {
          do
          {
            j++;
            break;
            if ((c != '-') && (c != '+'))
              break label59;
          }
          while (j + 1 != paramInt2);
          return false;
          if (c == '#')
            return true;
          if ((!Character.isLetter(c)) && (c != '/') && (c != '_') && (c != '^'))
            break label105;
        }
        while (j != paramInt1);
        return false;
      }
      while (c == '.');
      return false;
    }
    return i > 0;
  }

  public static Object parseNumber(CharSequence paramCharSequence, int paramInt)
  {
    if ((paramCharSequence instanceof FString));
    for (char[] arrayOfChar = ((FString)paramCharSequence).data; ; arrayOfChar = paramCharSequence.toString().toCharArray())
      return parseNumber(arrayOfChar, 0, paramCharSequence.length(), '\000', paramInt, 1);
  }

  public static Object parseNumber(char[] paramArrayOfChar, int paramInt1, int paramInt2, char paramChar, int paramInt3, int paramInt4)
  {
    int i = paramInt1 + paramInt2;
    Object localObject5;
    if (paramInt1 >= i)
    {
      localObject5 = "no digits";
      return localObject5;
    }
    int j = paramInt1 + 1;
    char c1 = paramArrayOfChar[paramInt1];
    while (c1 == '#')
    {
      if (j >= i)
        return "no digits";
      int i29 = j + 1;
      char c6 = paramArrayOfChar[j];
      int i32;
      int i33;
      int i30;
      switch (c6)
      {
      default:
        i32 = 0;
        i33 = Character.digit(c6, 10);
        if (i33 < 0)
        {
          if ((c6 != 'R') && (c6 != 'r'))
            break label384;
          if (paramInt3 == 0)
            break label357;
          return "duplicate radix specifier";
        }
        break;
      case 'B':
      case 'b':
        if (paramInt3 != 0)
          return "duplicate radix specifier";
        paramInt3 = 2;
        i30 = i29;
      case 'O':
      case 'o':
      case 'D':
      case 'd':
      case 'X':
      case 'x':
      case 'E':
      case 'I':
      case 'e':
      case 'i':
      }
      while (true)
        if (i30 >= i)
        {
          return "no digits";
          if (paramInt3 != 0)
            return "duplicate radix specifier";
          paramInt3 = 8;
          i30 = i29;
          continue;
          if (paramInt3 != 0)
            return "duplicate radix specifier";
          paramInt3 = 10;
          i30 = i29;
          continue;
          if (paramInt3 != 0)
            return "duplicate radix specifier";
          paramInt3 = 16;
          i30 = i29;
          continue;
          if (paramChar != 0)
          {
            if (paramChar == ' ')
              return "non-prefix exactness specifier";
            return "duplicate exactness specifier";
          }
          paramChar = c6;
          i30 = i29;
          continue;
          i32 = i33 + i32 * 10;
          if (i29 >= i)
            return "missing letter after '#'";
          int i34 = i29 + 1;
          c6 = paramArrayOfChar[i29];
          i29 = i34;
          break;
          label357: if ((i32 < 2) || (i32 > 35))
            return "invalid radix specifier";
          paramInt3 = i32;
          i30 = i29;
          continue;
          label384: return "unknown modifier '#" + c6 + '\'';
        }
      int i31 = i30 + 1;
      c1 = paramArrayOfChar[i30];
      j = i31;
    }
    if (paramChar == 0)
      paramChar = ' ';
    int i28;
    label456: boolean bool1;
    label466: boolean bool2;
    int k;
    if (paramInt3 == 0)
    {
      i28 = paramInt2;
      i28--;
      if (i28 < 0)
        paramInt3 = 10;
    }
    else
    {
      if (c1 != '-')
        break label523;
      bool1 = true;
      bool2 = bool1;
      if ((c1 != '-') && (c1 != '+'))
        break label529;
      k = 1;
    }
    label523: label529: int m;
    char c2;
    while (true)
      if (k != 0)
      {
        if (j >= i)
        {
          return "no digits following sign";
          if (paramArrayOfChar[(paramInt1 + i28)] != '.')
            break;
          paramInt3 = 10;
          break label456;
          bool1 = false;
          break label466;
          k = 0;
          continue;
        }
        m = j + 1;
        c2 = paramArrayOfChar[j];
      }
    while (true)
    {
      if (((c2 == 'i') || (c2 == 'I')) && (m == i) && (paramInt1 == m - 2) && ((paramInt4 & 0x1) != 0))
      {
        int i27 = paramArrayOfChar[paramInt1];
        if ((i27 != 43) && (i27 != 45))
          return "no digits";
        if ((paramChar == 'i') || (paramChar == 'I'))
        {
          if (bool1);
          for (double d6 = -1.0D; ; d6 = 1.0D)
          {
            DComplex localDComplex = new DComplex(0.0D, d6);
            return localDComplex;
          }
        }
        if (bool1)
          return Complex.imMinusOne();
        return Complex.imOne();
      }
      (m - 1);
      int n = -1;
      long l = 0L;
      Object localObject1 = null;
      char c3 = c2;
      int i1 = -1;
      label682: int i2 = Character.digit(c3, paramInt3);
      Object localObject2;
      int i4;
      Object localObject3;
      int i5;
      if (i2 >= 0)
      {
        if ((0 != 0) && (i1 < 0))
          return "digit after '#' in number";
        if (n < 0)
          n = m - 1;
        l = l * paramInt3 + i2;
        localObject2 = localObject1;
        if (m != i)
          break label1250;
        i4 = i1;
        localObject3 = localObject2;
        i5 = -1;
      }
      while (true)
      {
        label753: int i6;
        int i26;
        label1250: label1273: int i7;
        if (n < 0)
        {
          i6 = 0;
          if (k != 0)
          {
            int i20 = m + 4;
            i6 = 0;
            if (i20 < i)
            {
              int i21 = paramArrayOfChar[(m + 3)];
              i6 = 0;
              if (i21 == 46)
              {
                int i22 = paramArrayOfChar[(m + 4)];
                i6 = 0;
                if (i22 == 48)
                {
                  if ((paramArrayOfChar[m] != 'i') || (paramArrayOfChar[(m + 1)] != 'n') || (paramArrayOfChar[(m + 2)] != 'f'))
                    break label1273;
                  i6 = 105;
                }
              }
            }
          }
          while (true)
          {
            if (i6 != 0)
              break label1332;
            return "no digits";
            switch (c3)
            {
            default:
              m--;
              i4 = i1;
              i5 = -1;
              localObject3 = localObject1;
              break;
            case '.':
              if (i1 >= 0)
                return "duplicate '.' in number";
              if (paramInt3 != 10)
                return "'.' in non-decimal number";
              i1 = m - 1;
              localObject2 = localObject1;
              break;
            case 'D':
            case 'E':
            case 'F':
            case 'L':
            case 'S':
            case 'd':
            case 'e':
            case 'f':
            case 'l':
            case 's':
              if ((m == i) || (paramInt3 != 10))
              {
                m--;
                i4 = i1;
                i5 = -1;
                localObject3 = localObject1;
                break label753;
              }
              char c5 = paramArrayOfChar[m];
              i26 = m - 1;
              if ((c5 == '+') || (c5 == '-'))
              {
                m++;
                if ((m >= i) || (Character.digit(paramArrayOfChar[m], 10) < 0))
                  return "missing exponent digits";
              }
              else if (Character.digit(c5, 10) < 0)
              {
                m--;
                i4 = i1;
                i5 = -1;
                localObject3 = localObject1;
                break label753;
              }
              if (-1 >= 0)
                return "duplicate exponent";
              if (paramInt3 != 10)
                return "exponent in non-decimal number";
              if (n < 0)
                return "mantissa with no digits";
              do
              {
                m++;
                if (m >= i)
                  break;
              }
              while (Character.digit(paramArrayOfChar[m], 10) >= 0);
              localObject3 = localObject1;
              i4 = i1;
              i5 = i26;
              break;
            case '/':
              if (localObject1 != null)
                return "multiple fraction symbol '/'";
              if (n < 0)
                return "no digits before fraction symbol '/'";
              if ((-1 >= 0) || (i1 >= 0))
                return "fraction symbol '/' following exponent or '.'";
              IntNum localIntNum1 = valueOf(paramArrayOfChar, n, m - n, paramInt3, bool1, l);
              n = -1;
              l = 0L;
              localObject2 = localIntNum1;
              bool1 = false;
              break;
              int i3 = m + 1;
              c3 = paramArrayOfChar[m];
              m = i3;
              localObject1 = localObject2;
              break label682;
              int i23 = paramArrayOfChar[m];
              i6 = 0;
              if (i23 == 110)
              {
                int i24 = paramArrayOfChar[(m + 1)];
                i6 = 0;
                if (i24 == 97)
                {
                  int i25 = paramArrayOfChar[(m + 2)];
                  i6 = 0;
                  if (i25 == 110)
                    i6 = 110;
                }
              }
              break;
            }
          }
          label1332: i7 = m + 5;
        }
        while (true)
        {
          int i8;
          if (((0 != 0) || (0 == 0)) || ((paramChar == 'i') || (paramChar == 'I') || ((paramChar == ' ') && (0 != 0))))
          {
            i8 = 1;
            label1371: if (i6 == 0)
              break label1512;
            if (i6 != 105)
              break label1504;
          }
          int i11;
          Object localObject4;
          label1416: int i12;
          char c4;
          label1504: for (double d5 = (1.0D / 0.0D); ; d5 = (0.0D / 0.0D))
          {
            if (bool1)
              d5 = -d5;
            DFloNum localDFloNum3 = new DFloNum(d5);
            i11 = 0;
            localObject4 = localDFloNum3;
            if ((paramChar == 'e') || (paramChar == 'E'))
              localObject4 = ((RealNum)localObject4).toExact();
            if (i7 >= i)
              break label2143;
            i12 = i7 + 1;
            c4 = paramArrayOfChar[i7];
            if (c4 != '@')
              break label1923;
            localObject5 = parseNumber(paramArrayOfChar, i12, i - i12, paramChar, 10, paramInt4);
            if ((localObject5 instanceof String))
              break;
            if ((localObject5 instanceof RealNum))
              break label1883;
            return "invalid complex polar constant";
            i8 = 0;
            break label1371;
          }
          label1512: String str1;
          int i18;
          int i10;
          String str2;
          if ((i5 >= 0) || (i4 >= 0))
          {
            if ((n > i4) && (i4 >= 0))
              n = i4;
            if (localObject3 != null)
              return "floating-point number after fraction symbol '/'";
            int i9 = i7 - n;
            str1 = new String(paramArrayOfChar, n, i9);
            if (i5 < 0)
              break label2286;
            i18 = Character.toLowerCase(paramArrayOfChar[i5]);
            if (i18 == 101)
              break label2275;
            int i19 = i5 - n;
            String str3 = str1.substring(0, i19) + 'e' + str1.substring(i19 + 1);
            i10 = i18;
            str2 = str3;
          }
          while (true)
          {
            double d1 = Convert.parseDouble(str2);
            if (bool1)
              d1 = -d1;
            DFloNum localDFloNum1 = new DFloNum(d1);
            i11 = i10;
            localObject4 = localDFloNum1;
            break label1416;
            IntNum localIntNum2 = valueOf(paramArrayOfChar, n, i7 - n, paramInt3, bool1, l);
            Object localObject6;
            if (localObject3 == null)
            {
              localObject6 = localIntNum2;
              label1716: if ((i8 == 0) || (!((RealNum)localObject6).isExact()))
                break label2262;
              if ((!bool2) || (!((RealNum)localObject6).isZero()))
                break label1873;
            }
            label1799: label1873: for (double d3 = 0.0D; ; d3 = ((RealNum)localObject6).doubleValue())
            {
              DFloNum localDFloNum2 = new DFloNum(d3);
              localObject4 = localDFloNum2;
              i11 = 0;
              break;
              if (localIntNum2.isZero())
              {
                boolean bool3 = localObject3.isZero();
                double d4;
                if (i8 != 0)
                  if (bool3)
                    d4 = (0.0D / 0.0D);
                for (Object localObject7 = new DFloNum(d4); ; localObject7 = RatNum.make(localObject3, localIntNum2))
                {
                  localObject6 = localObject7;
                  break;
                  if (bool2)
                  {
                    d4 = (-1.0D / 0.0D);
                    break label1799;
                  }
                  d4 = (1.0D / 0.0D);
                  break label1799;
                  if (bool3)
                    return "0/0 is undefined";
                }
              }
              localObject6 = RatNum.make(localObject3, localIntNum2);
              break label1716;
            }
            label1883: RealNum localRealNum2 = (RealNum)localObject5;
            if ((((RealNum)localObject4).isZero()) && (!localRealNum2.isExact()))
              return new DFloNum(0.0D);
            return Complex.polar((RealNum)localObject4, localRealNum2);
            label1923: if ((c4 == '-') || (c4 == '+'))
            {
              int i13 = i12 - 1;
              localObject5 = parseNumber(paramArrayOfChar, i13, i - i13, paramChar, 10, paramInt4);
              if ((localObject5 instanceof String))
                break;
              if (!(localObject5 instanceof Complex))
                return "invalid numeric constant (" + localObject5 + ")";
              Complex localComplex = (Complex)localObject5;
              if (!localComplex.re().isZero())
                return "invalid numeric constant";
              RealNum localRealNum1 = localComplex.im();
              return Complex.make((RealNum)localObject4, localRealNum1);
            }
            int i14 = 0;
            while (true)
            {
              if (!Character.isLetter(c4))
                i12--;
              for (int i16 = i14; ; i16 = i14)
              {
                if (i16 != 1)
                  break label2140;
                int i17 = paramArrayOfChar[(i12 - 1)];
                if ((i17 != 105) && (i17 != 73))
                  break label2140;
                if (i12 >= i)
                  break label2131;
                return "junk after imaginary suffix 'i'";
                i14++;
                if (i12 != i)
                  break;
              }
              int i15 = i12 + 1;
              c4 = paramArrayOfChar[i12];
              i12 = i15;
            }
            label2131: return Complex.make(IntNum.zero(), (RealNum)localObject4);
            label2140: return "excess junk after number";
            label2143: double d2;
            if (((localObject4 instanceof DFloNum)) && (i11 > 0) && (i11 != 101))
              d2 = ((RealNum)localObject4).doubleValue();
            switch (i11)
            {
            default:
              return localObject4;
            case 102:
            case 115:
              Float localFloat = Float.valueOf((float)d2);
              return localFloat;
            case 100:
              Double localDouble = Double.valueOf(d2);
              return localDouble;
            case 108:
            }
            BigDecimal localBigDecimal = BigDecimal.valueOf(d2);
            return localBigDecimal;
            label2262: localObject4 = localObject6;
            i11 = 0;
            break label1416;
            label2275: i10 = i18;
            str2 = str1;
            continue;
            label2286: str2 = str1;
            i10 = 0;
          }
          i7 = m;
          i6 = 0;
        }
        localObject3 = localObject1;
        i4 = i1;
        i5 = i26;
      }
      c2 = c1;
      m = j;
    }
  }

  public static Object readCharacter(LispReader paramLispReader)
    throws IOException, SyntaxException
  {
    int i = paramLispReader.read();
    if (i < 0)
      paramLispReader.eofError("unexpected EOF in character literal");
    int j = paramLispReader.tokenBufferLength;
    paramLispReader.tokenBufferAppend(i);
    paramLispReader.readToken(paramLispReader.read(), 'D', ReadTable.getCurrent());
    char[] arrayOfChar = paramLispReader.tokenBuffer;
    int k = paramLispReader.tokenBufferLength - j;
    if (k == 1)
      return Char.make(arrayOfChar[j]);
    String str = new String(arrayOfChar, j, k);
    int m = Char.nameToChar(str);
    if (m >= 0)
      return Char.make(m);
    int n = arrayOfChar[j];
    int i1;
    int i2;
    int i3;
    label152: int i5;
    if ((n == 120) || (n == 88))
    {
      i1 = 0;
      i2 = 1;
      if (i2 == k)
        return Char.make(i1);
      i3 = Character.digit(arrayOfChar[(j + i2)], 16);
      if (i3 >= 0);
    }
    else
    {
      int i4 = Character.digit(n, 8);
      if (i4 < 0)
        break label228;
      i5 = i4;
    }
    for (int i6 = 1; ; i6++)
    {
      if (i6 == k)
      {
        return Char.make(i5);
        i1 = i3 + i1 * 16;
        if (i1 > 1114111)
          break label152;
        i2++;
        break;
      }
      int i7 = Character.digit(arrayOfChar[(j + i6)], 8);
      if (i7 < 0)
      {
        label228: paramLispReader.error("unknown character name: " + str);
        return Char.make(63);
      }
      i5 = i7 + i5 * 8;
    }
  }

  public static Object readNumberWithRadix(int paramInt1, LispReader paramLispReader, int paramInt2)
    throws IOException, SyntaxException
  {
    int i = paramLispReader.tokenBufferLength - paramInt1;
    paramLispReader.readToken(paramLispReader.read(), 'P', ReadTable.getCurrent());
    int j = paramLispReader.tokenBufferLength;
    if (i == j)
    {
      paramLispReader.error("missing numeric token");
      return IntNum.zero();
    }
    Object localObject = parseNumber(paramLispReader.tokenBuffer, i, j - i, '\000', paramInt2, 0);
    if ((localObject instanceof String))
    {
      paramLispReader.error((String)localObject);
      return IntNum.zero();
    }
    if (localObject == null)
    {
      paramLispReader.error("invalid numeric constant");
      return IntNum.zero();
    }
    return localObject;
  }

  public static SimpleVector readSimpleVector(LispReader paramLispReader, char paramChar)
    throws IOException, SyntaxException
  {
    int k;
    for (int i = 0; ; i = k + i * 10)
    {
      int j = paramLispReader.read();
      if (j < 0)
        paramLispReader.eofError("unexpected EOF reading uniform vector");
      k = Character.digit((char)j, 10);
      if (k < 0)
      {
        if (((i == 8) || (i == 16) || (i == 32) || (i == 64)) && ((paramChar != 'F') || (i >= 32)) && (j == 40))
          break;
        paramLispReader.error("invalid uniform vector syntax");
        return null;
      }
    }
    Object localObject = ReaderParens.readList(paramLispReader, 40, -1, 41);
    if (LList.listLength(localObject, false) < 0)
    {
      paramLispReader.error("invalid elements in uniform vector syntax");
      return null;
    }
    Sequence localSequence = (Sequence)localObject;
    switch (paramChar)
    {
    default:
    case 'F':
    case 'S':
    case 'U':
    }
    while (true)
    {
      return null;
      switch (i)
      {
      default:
        switch (i)
        {
        default:
          switch (i)
          {
          default:
          case 8:
          case 16:
          case 32:
          case 64:
          }
          break;
        case 8:
        case 16:
        case 32:
        case 64:
        }
        break;
      case 32:
      case 64:
      }
    }
    return new U8Vector(localSequence);
    return new F32Vector(localSequence);
    return new F64Vector(localSequence);
    return new S8Vector(localSequence);
    return new S16Vector(localSequence);
    return new S32Vector(localSequence);
    return new S64Vector(localSequence);
    return new U16Vector(localSequence);
    return new U32Vector(localSequence);
    return new U64Vector(localSequence);
  }

  public static Object readSpecial(LispReader paramLispReader)
    throws IOException, SyntaxException
  {
    int i = paramLispReader.read();
    if (i < 0)
      paramLispReader.eofError("unexpected EOF in #! special form");
    if ((i == 47) && (paramLispReader.getLineNumber() == 0) && (paramLispReader.getColumnNumber() == 3))
    {
      ReaderIgnoreRestOfLine.getInstance().read(paramLispReader, 35, 1);
      return Values.empty;
    }
    int j = paramLispReader.tokenBufferLength;
    paramLispReader.tokenBufferAppend(i);
    paramLispReader.readToken(paramLispReader.read(), 'D', ReadTable.getCurrent());
    int k = paramLispReader.tokenBufferLength - j;
    String str = new String(paramLispReader.tokenBuffer, j, k);
    if (str.equals("optional"))
      return Special.optional;
    if (str.equals("rest"))
      return Special.rest;
    if (str.equals("key"))
      return Special.key;
    if (str.equals("eof"))
      return Special.eof;
    if (str.equals("void"))
      return QuoteExp.voidExp;
    if (str.equals("default"))
      return Special.dfault;
    if (str.equals("undefined"))
      return Special.undefined;
    if (str.equals("abstract"))
      return Special.abstractSpecial;
    if (str.equals("null"))
      return null;
    paramLispReader.error("unknown named constant #!" + str);
    return null;
  }

  private static IntNum valueOf(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong)
  {
    if (paramInt2 + paramInt3 <= 28)
    {
      if (paramBoolean);
      for (long l = -paramLong; ; l = paramLong)
        return IntNum.make(l);
    }
    return IntNum.valueOf(paramArrayOfChar, paramInt1, paramInt2, paramInt3, paramBoolean);
  }

  Object handlePostfix(Object paramObject, ReadTable paramReadTable, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    if (paramObject == QuoteExp.voidExp);
    Pair localPair;
    for (paramObject = Values.empty; ; paramObject = PairWithPosition.make(LispLanguage.lookup_sym, localPair, this.port.getName(), paramInt1 + 1, paramInt2 + 1))
    {
      int i = this.port.peek();
      if ((i < 0) || (i != paramReadTable.postfixLookupOperator))
        return paramObject;
      this.port.read();
      if (!validPostfixLookupStart(this.port.peek(), paramReadTable))
      {
        unread();
        return paramObject;
      }
      int j = this.port.read();
      Object localObject = readValues(j, paramReadTable.lookup(j), paramReadTable);
      localPair = LList.list2(paramObject, LList.list2(paramReadTable.makeSymbol("quasiquote"), localObject));
    }
  }

  protected Object makeNil()
  {
    return LList.Empty;
  }

  protected Pair makePair(Object paramObject, int paramInt1, int paramInt2)
  {
    return makePair(paramObject, LList.Empty, paramInt1, paramInt2);
  }

  protected Pair makePair(Object paramObject1, Object paramObject2, int paramInt1, int paramInt2)
  {
    String str = this.port.getName();
    if ((str != null) && (paramInt1 >= 0))
      return PairWithPosition.make(paramObject1, paramObject2, str, paramInt1 + 1, paramInt2 + 1);
    return Pair.make(paramObject1, paramObject2);
  }

  protected Object readAndHandleToken(int paramInt1, int paramInt2, ReadTable paramReadTable)
    throws IOException, SyntaxException
  {
    readToken(paramInt1, getReadCase(), paramReadTable);
    int i = this.tokenBufferLength;
    if (!this.seenEscapes)
    {
      Object localObject2 = parseNumber(this.tokenBuffer, paramInt2, i - paramInt2, '\000', 0, 1);
      if ((localObject2 != null) && (!(localObject2 instanceof String)))
        return localObject2;
    }
    int j = getReadCase();
    int i13;
    int k;
    label193: int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    label211: int i11;
    int i12;
    if (j == 73)
    {
      i13 = 0;
      int i14 = 0;
      int i15 = paramInt2;
      if (i15 < i)
      {
        int i16 = this.tokenBuffer[i15];
        if (i16 == 65535)
          i15++;
        while (true)
        {
          i15++;
          break;
          if (Character.isLowerCase(i16))
            i14++;
          else if (Character.isUpperCase(i16))
            i13++;
        }
      }
      if (i14 == 0)
        j = 68;
    }
    else
    {
      if ((i < paramInt2 + 2) || (this.tokenBuffer[(i - 1)] != '}') || (this.tokenBuffer[(i - 2)] == 65535) || (peek() != 58))
        break label297;
      k = 1;
      m = -1;
      n = -1;
      i1 = -1;
      i2 = 0;
      i3 = paramInt2;
      i4 = paramInt2;
      if (i3 >= i)
        break label459;
      i11 = this.tokenBuffer[i3];
      if (i11 != 65535)
        break label303;
      i3++;
      if (i3 >= i)
        break label730;
      char[] arrayOfChar2 = this.tokenBuffer;
      i12 = i4 + 1;
      arrayOfChar2[i4] = this.tokenBuffer[i3];
    }
    while (true)
    {
      i3++;
      i4 = i12;
      break label211;
      if (i13 == 0)
      {
        j = 85;
        break;
      }
      j = 80;
      break;
      label297: k = 0;
      break label193;
      label303: if (k != 0)
      {
        if (i11 != 123)
          break label362;
        if (n < 0)
        {
          n = i4;
          label324: i2++;
        }
      }
      else
      {
        label327: if (i2 <= 0)
          break label400;
      }
      while (true)
      {
        char[] arrayOfChar1 = this.tokenBuffer;
        i12 = i4 + 1;
        arrayOfChar1[i4] = i11;
        break;
        if (i2 != 0)
          break label324;
        break label324;
        label362: if (i11 != 125)
          break label327;
        i2--;
        if ((i2 < 0) || (i2 != 0))
          break label327;
        if (i1 < 0)
        {
          i1 = i4;
          break label327;
        }
        break label327;
        label400: if (i11 == 58)
        {
          if (m >= 0);
          for (m = -1; ; m = i4)
            break;
        }
        char c;
        if (j == 85)
          c = Character.toUpperCase(i11);
        else if (j == 68)
          c = Character.toLowerCase(c);
      }
      label459: int i5 = i4;
      int i6 = i5 - paramInt2;
      if ((n >= 0) && (i1 > n))
      {
        String str4;
        if (n > 0)
          str4 = new String(this.tokenBuffer, paramInt2, n - paramInt2);
        for (String str5 = str4; ; str5 = null)
        {
          int i9 = n + 1;
          String str6 = new String(this.tokenBuffer, i9, i1 - i9);
          read();
          int i10 = read();
          Object localObject1 = readValues(i10, paramReadTable.lookup(i10), paramReadTable);
          if (!(localObject1 instanceof SimpleSymbol))
            error("expected identifier in symbol after '{URI}:'");
          return Symbol.valueOf(localObject1.toString(), str6, str5);
        }
      }
      if ((paramReadTable.initialColonIsKeyword) && (m == paramInt2) && (i6 > 1))
      {
        int i8 = paramInt2 + 1;
        String str3 = new String(this.tokenBuffer, i8, i5 - i8);
        return Keyword.make(str3.intern());
      }
      if (paramReadTable.finalColonIsKeyword)
      {
        int i7 = i5 - 1;
        if ((m == i7) && ((i6 > 1) || (this.seenEscapes)))
        {
          String str2 = new String(this.tokenBuffer, paramInt2, i6 - 1);
          return Keyword.make(str2.intern());
        }
      }
      String str1 = new String(this.tokenBuffer, paramInt2, i6);
      return paramReadTable.makeSymbol(str1);
      label730: i12 = i4;
    }
  }

  public Object readCommand()
    throws IOException, SyntaxException
  {
    return readObject();
  }

  public int readEscape()
    throws IOException, SyntaxException
  {
    int i = read();
    if (i < 0)
    {
      eofError("unexpected EOF in character literal");
      return -1;
    }
    return readEscape(i);
  }

  public final int readEscape(int paramInt)
    throws IOException, SyntaxException
  {
    switch ((char)paramInt)
    {
    default:
    case 'a':
    case 'b':
    case 't':
    case 'n':
    case 'v':
    case 'f':
    case 'r':
    case 'e':
    case '"':
    case '\\':
    case '\t':
    case '\n':
    case '\r':
    case ' ':
    case 'M':
    case 'C':
    case '^':
    case '0':
    case '1':
    case '2':
    case '3':
    case '4':
    case '5':
    case '6':
    case '7':
      while (true)
      {
        return paramInt;
        paramInt = 7;
        continue;
        paramInt = 8;
        continue;
        paramInt = 9;
        continue;
        paramInt = 10;
        continue;
        paramInt = 11;
        continue;
        paramInt = 12;
        continue;
        paramInt = 13;
        continue;
        paramInt = 27;
        continue;
        paramInt = 34;
        continue;
        paramInt = 92;
        continue;
        paramInt = read();
        if (paramInt < 0)
        {
          eofError("unexpected EOF in literal");
          return -1;
        }
        if (paramInt == 10)
        {
          if (paramInt != 10);
        }
        else
        {
          int i4;
          do
          {
            i4 = read();
            if (i4 < 0)
            {
              eofError("unexpected EOF in literal");
              return -1;
              if (paramInt == 13)
              {
                if (peek() == 10)
                  skip();
                paramInt = 10;
                break label322;
              }
              if ((paramInt == 32) || (paramInt == 9))
                break;
              unread(paramInt);
              break label322;
            }
          }
          while ((i4 == 32) || (i4 == 9));
          unread(i4);
          return -2;
          if (read() != 45)
          {
            error("Invalid escape character syntax");
            return 63;
          }
          int i3 = read();
          if (i3 == 92)
            i3 = readEscape();
          return i3 | 0x80;
          if (read() != 45)
          {
            error("Invalid escape character syntax");
            return 63;
          }
          int i2 = read();
          if (i2 == 92)
            i2 = readEscape();
          if (i2 == 63)
            return 127;
          return i2 & 0x9F;
          paramInt -= 48;
          int m = 0;
          int n;
          while (true)
          {
            m++;
            if (m >= 3)
              break;
            n = read();
            int i1 = Character.digit((char)n, 8);
            if (i1 < 0)
              break label562;
            paramInt = i1 + (paramInt << 3);
          }
          if (n >= 0)
            unread(n);
        }
      }
    case 'u':
      label322: paramInt = 0;
      label562: int i = 4;
      while (true)
      {
        i--;
        if (i < 0)
          break;
        int j = read();
        if (j < 0)
          eofError("premature EOF in \\u escape");
        int k = Character.digit((char)j, 16);
        if (k < 0)
          error("non-hex character following \\u");
        paramInt = k + paramInt * 16;
      }
    case 'X':
    case 'x':
    }
    return readHexEscape();
  }

  public int readHexEscape()
    throws IOException, SyntaxException
  {
    int j;
    int k;
    for (int i = 0; ; i = k + (i << 4))
    {
      j = read();
      k = Character.digit((char)j, 16);
      if (k < 0)
        break;
    }
    if ((j != 59) && (j >= 0))
      unread(j);
    return i;
  }

  public final void readNestedComment(char paramChar1, char paramChar2)
    throws IOException, SyntaxException
  {
    int i = 1;
    int j = this.port.getLineNumber();
    int k = this.port.getColumnNumber();
    do
    {
      char c = read();
      if (c == '|')
      {
        c = read();
        if (c == paramChar1)
          i--;
      }
      while (c < 0)
      {
        eofError("unexpected end-of-file in " + paramChar1 + paramChar2 + " comment starting here", j + 1, k - 1);
        return;
        if (c == paramChar1)
        {
          c = read();
          if (c == paramChar2)
            i++;
        }
      }
    }
    while (i > 0);
  }

  public Object readObject()
    throws IOException, SyntaxException
  {
    char c = ((InPort)this.port).readState;
    int i = this.tokenBufferLength;
    ((InPort)this.port).readState = ' ';
    try
    {
      ReadTable localReadTable = ReadTable.getCurrent();
      int j;
      int k;
      Object localObject3;
      do
      {
        j = this.port.getLineNumber();
        k = this.port.getColumnNumber();
        int m = this.port.read();
        if (m < 0)
        {
          Object localObject2 = Sequence.eofValue;
          return localObject2;
        }
        localObject3 = readValues(m, localReadTable);
      }
      while (localObject3 == Values.empty);
      Object localObject4 = handlePostfix(localObject3, localReadTable, j, k);
      return localObject4;
    }
    finally
    {
      this.tokenBufferLength = i;
      ((InPort)this.port).readState = c;
    }
  }

  public final Object readObject(int paramInt)
    throws IOException, SyntaxException
  {
    unread(paramInt);
    return readObject();
  }

  void readToken(int paramInt, char paramChar, ReadTable paramReadTable)
    throws IOException, SyntaxException
  {
    int i = 0;
    int j = 0;
    ReadTableEntry localReadTableEntry;
    int k;
    if (paramInt < 0)
    {
      if (i != 0)
        eofError("unexpected EOF between escapes");
    }
    else
    {
      localReadTableEntry = paramReadTable.lookup(paramInt);
      k = localReadTableEntry.getKind();
      if (k != 0)
        break label93;
      if (i != 0)
      {
        tokenBufferAppend(65535);
        tokenBufferAppend(paramInt);
      }
    }
    while (true)
    {
      paramInt = read();
      break;
      if (paramInt == 125)
      {
        j--;
        if (j >= 0)
          tokenBufferAppend(paramInt);
      }
      else
      {
        unread(paramInt);
        return;
        label93: if ((paramInt == paramReadTable.postfixLookupOperator) && (i == 0))
        {
          int n = this.port.peek();
          if (n == paramReadTable.postfixLookupOperator)
          {
            unread(paramInt);
            return;
          }
          if (validPostfixLookupStart(n, paramReadTable))
            k = 5;
        }
        if (k == 3)
        {
          int m = read();
          if (m < 0)
            eofError("unexpected EOF after single escape");
          if ((paramReadTable.hexEscapeAfterBackslash) && ((m == 120) || (m == 88)))
            m = readHexEscape();
          tokenBufferAppend(65535);
          tokenBufferAppend(m);
          this.seenEscapes = true;
        }
        else
        {
          if (k == 4)
          {
            if (i == 0);
            for (i = 1; ; i = 0)
            {
              this.seenEscapes = true;
              break;
            }
          }
          if (i != 0)
          {
            tokenBufferAppend(65535);
            tokenBufferAppend(paramInt);
          }
          else
          {
            switch (k)
            {
            case 3:
            default:
              break;
            case 1:
              unread(paramInt);
              return;
            case 2:
              if ((paramInt == 123) && (localReadTableEntry == ReadTableEntry.brace))
                j++;
            case 6:
              tokenBufferAppend(paramInt);
              break;
            case 4:
              i = 1;
              this.seenEscapes = true;
            case 5:
            }
          }
        }
      }
    }
    unread(paramInt);
  }

  public Object readValues(int paramInt, ReadTable paramReadTable)
    throws IOException, SyntaxException
  {
    return readValues(paramInt, paramReadTable.lookup(paramInt), paramReadTable);
  }

  public Object readValues(int paramInt, ReadTableEntry paramReadTableEntry, ReadTable paramReadTable)
    throws IOException, SyntaxException
  {
    int i = this.tokenBufferLength;
    this.seenEscapes = false;
    switch (paramReadTableEntry.getKind())
    {
    case 2:
    case 3:
    case 4:
    default:
      return readAndHandleToken(paramInt, i, paramReadTable);
    case 0:
      String str = "invalid character #\\" + (char)paramInt;
      if (this.interactive)
        fatal(str);
      while (true)
      {
        return Values.empty;
        error(str);
      }
    case 1:
      return Values.empty;
    case 5:
    case 6:
    }
    return paramReadTableEntry.read(this, paramInt, -1);
  }

  protected void setCdr(Object paramObject1, Object paramObject2)
  {
    ((Pair)paramObject1).setCdrBackdoor(paramObject2);
  }

  protected boolean validPostfixLookupStart(int paramInt, ReadTable paramReadTable)
    throws IOException
  {
    if ((paramInt < 0) || (paramInt == 58) || (paramInt == paramReadTable.postfixLookupOperator))
      return false;
    if (paramInt == 44)
      return true;
    int i = paramReadTable.lookup(paramInt).getKind();
    return (i == 2) || (i == 6) || (i == 4) || (i == 3);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.LispReader
 * JD-Core Version:    0.6.2
 */