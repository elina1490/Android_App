package gnu.kawa.functions;

import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.math.IntNum;
import gnu.text.CaseConvertFormat;
import gnu.text.Char;
import gnu.text.CompoundFormat;
import gnu.text.FlushFormat;
import gnu.text.LiteralFormat;
import gnu.text.ReportFormat;
import java.text.Format;
import java.text.ParseException;
import java.util.Stack;
import java.util.Vector;

public class LispFormat extends CompoundFormat
{
  public static final String paramFromCount = "<from count>";
  public static final String paramFromList = "<from list>";
  public static final String paramUnspecified = "<unspecified>";

  public LispFormat(String paramString)
    throws ParseException
  {
    this(paramString.toCharArray());
  }

  public LispFormat(char[] paramArrayOfChar)
    throws ParseException
  {
    this(paramArrayOfChar, 0, paramArrayOfChar.length);
  }

  public LispFormat(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws ParseException
  {
    super(null, 0);
    int i = -1;
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer(100);
    Stack localStack = new Stack();
    int k = paramInt1 + paramInt2;
    int n;
    for (int m = paramInt1; ; m = n)
    {
      if (((m >= k) || (paramArrayOfChar[m] == '~')) && (localStringBuffer.length() > 0))
      {
        LiteralFormat localLiteralFormat = new LiteralFormat(localStringBuffer);
        localStack.push(localLiteralFormat);
        localStringBuffer.setLength(0);
      }
      if (m >= k)
      {
        if (m <= k)
          break label3007;
        throw new IndexOutOfBoundsException();
      }
      n = m + 1;
      char c1 = paramArrayOfChar[m];
      if (c1 == '~')
        break;
      localStringBuffer.append(c1);
    }
    int i1 = localStack.size();
    int i2 = n + 1;
    char c2 = paramArrayOfChar[n];
    label164: if (c2 == '#')
    {
      localStack.push("<from count>");
      int i45 = i2 + 1;
      c2 = paramArrayOfChar[i2];
      i2 = i45;
    }
    label195: int i5;
    label206: boolean bool1;
    boolean bool2;
    label226: boolean bool4;
    label313: int i38;
    while (true)
      if (c2 != ',')
      {
        i5 = i2;
        bool1 = false;
        bool2 = false;
        int i37;
        for (m = i5; c2 == ':'; m = i37)
        {
          bool1 = true;
          i37 = m + 1;
          c2 = paramArrayOfChar[m];
        }
        if ((c2 == 'v') || (c2 == 'V'))
        {
          localStack.push("<from list>");
          int i3 = i2 + 1;
          c2 = paramArrayOfChar[i2];
          i2 = i3;
        }
        else if ((c2 == '-') || (Character.digit(c2, 10) >= 0))
        {
          if (c2 == '-')
          {
            bool4 = true;
            if (!bool4)
              break label3080;
            i38 = i2 + 1;
            c2 = paramArrayOfChar[i2];
          }
        }
      }
    while (true)
    {
      int i39 = 0;
      int i40 = i38;
      label337: int i41 = Character.digit(c2, 10);
      int i43;
      if (i41 < 0)
      {
        if (i38 - i40 >= 8)
          break label435;
        if (!bool4)
          break label428;
        i43 = -i39;
      }
      label371: for (IntNum localIntNum = IntNum.make(i43); ; localIntNum = IntNum.valueOf(paramArrayOfChar, i40, i38 - i40, 10, bool4))
      {
        localStack.push(localIntNum);
        i2 = i38;
        break;
        bool4 = false;
        break label313;
        i39 = i41 + i39 * 10;
        int i42 = i38 + 1;
        c2 = paramArrayOfChar[i38];
        i38 = i42;
        break label337;
        i43 = i39;
        break label371;
      }
      label428: label435: if (c2 == '\'')
      {
        int i44 = i2 + 1;
        localStack.push(Char.make(paramArrayOfChar[i2]));
        i2 = i44 + 1;
        c2 = paramArrayOfChar[i44];
        break label195;
      }
      if (c2 == ',')
      {
        localStack.push("<unspecified>");
        break label195;
        int i4 = i2 + 1;
        c2 = paramArrayOfChar[i2];
        i2 = i4;
        break label164;
        if (c2 == '@')
        {
          bool2 = true;
          break label226;
        }
        char c3 = Character.toUpperCase(c2);
        int i6 = localStack.size() - i1;
        int i30;
        label928: Object localObject;
        switch (c3)
        {
        default:
          ParseException localParseException10 = new ParseException("unrecognized format specifier ~" + c3, m);
          throw localParseException10;
        case 'B':
        case 'D':
        case 'O':
        case 'R':
        case 'X':
          int i29 = i1;
          if (c3 == 'R')
          {
            int i36 = i29 + 1;
            i30 = getParam(localStack, i29);
            i29 = i36;
            int i31 = getParam(localStack, i29);
            int i32 = getParam(localStack, i29 + 1);
            int i33 = getParam(localStack, i29 + 2);
            int i34 = getParam(localStack, i29 + 3);
            int i35 = 0;
            if (bool1)
              i35 = 0x0 | 0x1;
            if (bool2)
              i35 |= 2;
            localObject = IntegerFormat.getInstance(i30, i31, i32, i33, i34, i35);
          }
          break;
        case 'P':
        case '$':
        case 'E':
        case 'F':
        case 'G':
        case 'A':
        case 'S':
        case 'W':
        case 'Y':
        case 'C':
        case '*':
        case '(':
        case ')':
        case '?':
        case '{':
        case '}':
        case '<':
        case '>':
        case '[':
        case ';':
        case ']':
        case '^':
        case '\n':
        case '!':
        case 'T':
        case '&':
        case 'I':
        case '_':
        case '~':
        case '|':
        case '%':
        }
        while (true)
        {
          label1011: localStack.setSize(i1);
          localStack.push(localObject);
          break;
          if (c3 == 'D')
          {
            i30 = 10;
            break label928;
          }
          if (c3 == 'O')
          {
            i30 = 8;
            break label928;
          }
          if (c3 == 'X')
          {
            i30 = 16;
            break label928;
          }
          i30 = 2;
          break label928;
          localObject = LispPluralFormat.getInstance(bool1, bool2);
          continue;
          LispRealFormat localLispRealFormat = new LispRealFormat();
          localLispRealFormat.op = c3;
          localLispRealFormat.arg1 = getParam(localStack, i1);
          localLispRealFormat.arg2 = getParam(localStack, i1 + 1);
          localLispRealFormat.arg3 = getParam(localStack, i1 + 2);
          localLispRealFormat.arg4 = getParam(localStack, i1 + 3);
          if (c3 != '$')
          {
            localLispRealFormat.arg5 = getParam(localStack, i1 + 4);
            if ((c3 == 'E') || (c3 == 'G'))
            {
              localLispRealFormat.arg6 = getParam(localStack, i1 + 5);
              localLispRealFormat.arg7 = getParam(localStack, i1 + 6);
            }
          }
          localLispRealFormat.showPlus = bool2;
          localLispRealFormat.internalPad = bool1;
          if (localLispRealFormat.argsUsed == 0)
          {
            localObject = localLispRealFormat.resolve(null, 0);
          }
          else
          {
            localObject = localLispRealFormat;
            continue;
            boolean bool3;
            label1274: ObjectFormat localObjectFormat;
            int i24;
            int i25;
            int i26;
            int i27;
            ReportFormat localReportFormat;
            if (c3 != 'A')
            {
              bool3 = true;
              localObjectFormat = ObjectFormat.getInstance(bool3);
              if (i6 <= 0)
                break label3066;
              i24 = getParam(localStack, i1);
              i25 = getParam(localStack, i1 + 1);
              i26 = getParam(localStack, i1 + 2);
              i27 = getParam(localStack, i1 + 3);
              localReportFormat = (ReportFormat)localObjectFormat;
              if (!bool2)
                break label1373;
            }
            label1373: for (int i28 = 0; ; i28 = 100)
            {
              localObject = new LispObjectFormat(localReportFormat, i24, i25, i26, i27, i28);
              break;
              bool3 = false;
              break label1274;
            }
            if (i6 > 0);
            for (int i23 = getParam(localStack, i1); ; i23 = -1610612736)
            {
              localObject = LispCharacterFormat.getInstance(i23, 1, bool2, bool1);
              break;
            }
            int i22 = getParam(localStack, i1);
            localObject = new LispRepositionFormat(i22, bool1, bool2);
            continue;
            char c4;
            if (bool1)
              if (bool2)
                c4 = 'U';
            while (true)
            {
              CaseConvertFormat localCaseConvertFormat = new CaseConvertFormat(null, c4);
              localStack.setSize(i1);
              localStack.push(localCaseConvertFormat);
              localStack.push(IntNum.make(i));
              i = i1;
              break;
              c4 = 'C';
              continue;
              if (bool2)
                c4 = 'T';
              else
                c4 = 'L';
            }
            if ((i < 0) || (!(localStack.elementAt(i) instanceof CaseConvertFormat)))
            {
              ParseException localParseException9 = new ParseException("saw ~) without matching ~(", m);
              throw localParseException9;
            }
            ((CaseConvertFormat)localStack.elementAt(i)).setBaseFormat(popFormats(localStack, i + 2, i1));
            i = ((IntNum)localStack.pop()).intValue();
            break;
            LispIterationFormat localLispIterationFormat3 = new LispIterationFormat();
            localLispIterationFormat3.seenAt = bool2;
            localLispIterationFormat3.maxIterations = 1;
            localLispIterationFormat3.atLeastOnce = true;
            localObject = localLispIterationFormat3;
            continue;
            LispIterationFormat localLispIterationFormat2 = new LispIterationFormat();
            localLispIterationFormat2.seenAt = bool2;
            localLispIterationFormat2.seenColon = bool1;
            localLispIterationFormat2.maxIterations = getParam(localStack, i1);
            localStack.setSize(i1);
            localStack.push(localLispIterationFormat2);
            localStack.push(IntNum.make(i));
            i = i1;
            break;
            if ((i < 0) || (!(localStack.elementAt(i) instanceof LispIterationFormat)))
            {
              ParseException localParseException8 = new ParseException("saw ~} without matching ~{", m);
              throw localParseException8;
            }
            LispIterationFormat localLispIterationFormat1 = (LispIterationFormat)localStack.elementAt(i);
            localLispIterationFormat1.atLeastOnce = bool1;
            if (i1 > i + 2)
              localLispIterationFormat1.body = popFormats(localStack, i + 2, i1);
            i = ((IntNum)localStack.pop()).intValue();
            break;
            LispPrettyFormat localLispPrettyFormat3 = new LispPrettyFormat();
            localLispPrettyFormat3.seenAt = bool2;
            if (bool1)
              localLispPrettyFormat3.prefix = "(";
            for (localLispPrettyFormat3.suffix = ")"; ; localLispPrettyFormat3.suffix = "")
            {
              localStack.setSize(i1);
              localStack.push(localLispPrettyFormat3);
              localStack.push(IntNum.make(i));
              localStack.push(IntNum.make(j));
              i = i1;
              j = 0;
              break;
              localLispPrettyFormat3.prefix = "";
            }
            if ((i < 0) || (!(localStack.elementAt(i) instanceof LispPrettyFormat)))
            {
              ParseException localParseException3 = new ParseException("saw ~> without matching ~<", m);
              throw localParseException3;
            }
            localStack.push(popFormats(localStack, j + (i + 3), i1));
            LispPrettyFormat localLispPrettyFormat2 = (LispPrettyFormat)localStack.elementAt(i);
            localLispPrettyFormat2.segments = getFormats(localStack, i + 3, localStack.size());
            localStack.setSize(i + 3);
            ((IntNum)localStack.pop()).intValue();
            i = ((IntNum)localStack.pop()).intValue();
            if (bool1)
            {
              int i21 = localLispPrettyFormat2.segments.length;
              if (i21 > 3)
              {
                ParseException localParseException5 = new ParseException("too many segments in Logical Block format", m);
                throw localParseException5;
              }
              if (i21 >= 2)
              {
                if (!(localLispPrettyFormat2.segments[0] instanceof LiteralFormat))
                {
                  ParseException localParseException7 = new ParseException("prefix segment is not literal", m);
                  throw localParseException7;
                }
                localLispPrettyFormat2.prefix = ((LiteralFormat)localLispPrettyFormat2.segments[0]).content();
              }
              for (localLispPrettyFormat2.body = localLispPrettyFormat2.segments[1]; i21 >= 3; localLispPrettyFormat2.body = localLispPrettyFormat2.segments[0])
              {
                if ((localLispPrettyFormat2.segments[2] instanceof LiteralFormat))
                  break label2173;
                ParseException localParseException6 = new ParseException("suffix segment is not literal", m);
                throw localParseException6;
              }
              label2173: localLispPrettyFormat2.suffix = ((LiteralFormat)localLispPrettyFormat2.segments[2]).content();
              break;
            }
            ParseException localParseException4 = new ParseException("not implemented: justfication i.e. ~<...~>", m);
            throw localParseException4;
            LispChoiceFormat localLispChoiceFormat2 = new LispChoiceFormat();
            localLispChoiceFormat2.param = getParam(localStack, i1);
            if (localLispChoiceFormat2.param == -1073741824)
              localLispChoiceFormat2.param = -1610612736;
            if (bool1)
              localLispChoiceFormat2.testBoolean = true;
            if (bool2)
              localLispChoiceFormat2.skipIfFalse = true;
            localStack.setSize(i1);
            localStack.push(localLispChoiceFormat2);
            localStack.push(IntNum.make(i));
            localStack.push(IntNum.make(j));
            i = i1;
            j = 0;
            break;
            if (i >= 0)
            {
              if ((localStack.elementAt(i) instanceof LispChoiceFormat))
              {
                LispChoiceFormat localLispChoiceFormat1 = (LispChoiceFormat)localStack.elementAt(i);
                if (bool1)
                  localLispChoiceFormat1.lastIsDefault = true;
                localStack.push(popFormats(localStack, j + (i + 3), i1));
                j++;
                break;
              }
              if ((localStack.elementAt(i) instanceof LispPrettyFormat))
              {
                LispPrettyFormat localLispPrettyFormat1 = (LispPrettyFormat)localStack.elementAt(i);
                if (bool2)
                  localLispPrettyFormat1.perLine = true;
                localStack.push(popFormats(localStack, j + (i + 3), i1));
                j++;
                break;
              }
            }
            ParseException localParseException2 = new ParseException("saw ~; without matching ~[ or ~<", m);
            throw localParseException2;
            if ((i < 0) || (!(localStack.elementAt(i) instanceof LispChoiceFormat)))
            {
              ParseException localParseException1 = new ParseException("saw ~] without matching ~[", m);
              throw localParseException1;
            }
            localStack.push(popFormats(localStack, j + (i + 3), i1));
            ((LispChoiceFormat)localStack.elementAt(i)).choices = getFormats(localStack, i + 3, localStack.size());
            localStack.setSize(i + 3);
            j = ((IntNum)localStack.pop()).intValue();
            i = ((IntNum)localStack.pop()).intValue();
            break;
            int i18 = getParam(localStack, i1);
            int i19 = getParam(localStack, i1 + 1);
            int i20 = getParam(localStack, i1 + 2);
            localObject = new LispEscapeFormat(i18, i19, i20);
            continue;
            if (bool2)
              localStringBuffer.append(c3);
            if (bool1)
              break;
            while (m < k)
            {
              int i17 = m + 1;
              if (!Character.isWhitespace(paramArrayOfChar[m]))
              {
                m = i17 - 1;
                break;
                localObject = FlushFormat.getInstance();
                break label1011;
                int i14 = getParam(localStack, i1);
                int i15 = getParam(localStack, i1 + 1);
                int i16 = getParam(localStack, i1 + 2);
                localObject = new LispTabulateFormat(i14, i15, i16, bool2);
                break label1011;
                int i13 = getParam(localStack, i1);
                localObject = new LispFreshlineFormat(i13);
                break label1011;
                int i12 = getParam(localStack, i1);
                if (i12 == -1073741824)
                  i12 = 0;
                localObject = LispIndentFormat.getInstance(i12, bool1);
                break label1011;
                int i10 = getParam(localStack, i1);
                if (i10 == -1073741824)
                  i10 = 1;
                label2828: int i11;
                if ((bool1) && (bool2))
                {
                  if ((!bool2) || (!bool1))
                    break label2857;
                  i11 = 82;
                }
                while (true)
                {
                  localObject = LispNewlineFormat.getInstance(i10, i11);
                  break;
                  break label2828;
                  label2857: if (bool2)
                    i11 = 77;
                  else if (bool1)
                    i11 = 70;
                  else
                    i11 = 78;
                }
                if (i6 == 0)
                {
                  localStringBuffer.append(c3);
                  break;
                }
                int i8 = getParam(localStack, i1);
                if (i8 == -1073741824)
                  i8 = 1;
                int i9 = getParam(localStack, i1 + 1);
                if (i9 == -1073741824)
                  if (c3 != '|')
                    break label2968;
                label2968: for (i9 = 12; ; i9 = 126)
                {
                  localObject = LispCharacterFormat.getInstance(i9, i8, false, false);
                  break;
                }
                int i7 = getParam(localStack, i1);
                if (i7 == -1073741824)
                  i7 = 1;
                localObject = LispNewlineFormat.getInstance(i7, 76);
                break label1011;
                label3007: if (i >= 0)
                {
                  ParseException localParseException11 = new ParseException("missing ~] or ~}", m);
                  throw localParseException11;
                }
                this.length = localStack.size();
                this.formats = new Format[this.length];
                localStack.copyInto(this.formats);
                return;
              }
              m = i17;
            }
            label3066: localObject = localObjectFormat;
          }
        }
      }
      i5 = i2;
      break label206;
      label3080: i38 = i2;
    }
  }

  public static Object[] asArray(Object paramObject)
  {
    if ((paramObject instanceof Object[]))
      return (Object[])paramObject;
    if (!(paramObject instanceof Sequence))
      return null;
    int i = ((Sequence)paramObject).size();
    Object[] arrayOfObject = new Object[i];
    int m;
    for (int j = 0; (paramObject instanceof Pair); j = m)
    {
      Pair localPair = (Pair)paramObject;
      m = j + 1;
      arrayOfObject[j] = localPair.getCar();
      paramObject = localPair.getCdr();
    }
    if (j < i)
    {
      if (!(paramObject instanceof Sequence))
        return null;
      int k = j;
      Sequence localSequence = (Sequence)paramObject;
      while (j < i)
      {
        arrayOfObject[j] = localSequence.get(k + j);
        j++;
      }
    }
    return arrayOfObject;
  }

  static Format[] getFormats(Vector paramVector, int paramInt1, int paramInt2)
  {
    Format[] arrayOfFormat = new Format[paramInt2 - paramInt1];
    for (int i = paramInt1; i < paramInt2; i++)
      arrayOfFormat[(i - paramInt1)] = ((Format)paramVector.elementAt(i));
    return arrayOfFormat;
  }

  public static int getParam(Vector paramVector, int paramInt)
  {
    if (paramInt >= paramVector.size())
      return -1073741824;
    Object localObject = paramVector.elementAt(paramInt);
    if (localObject == "<from list>")
      return -1610612736;
    if (localObject == "<from count>")
      return -1342177280;
    if (localObject == "<unspecified>")
      return -1073741824;
    return getParam(localObject, -1073741824);
  }

  static Format popFormats(Vector paramVector, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1 + 1);
    for (Object localObject = (Format)paramVector.elementAt(paramInt1); ; localObject = new CompoundFormat(getFormats(paramVector, paramInt1, paramInt2)))
    {
      paramVector.setSize(paramInt1);
      return localObject;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.LispFormat
 * JD-Core Version:    0.6.2
 */