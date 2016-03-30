package gnu.xml;

import gnu.lists.Consumer;
import gnu.text.LineBufferedReader;
import gnu.text.LineInputStreamReader;
import gnu.text.Path;
import gnu.text.SourceMessages;
import java.io.IOException;
import java.io.InputStream;

public class XMLParser
{
  private static final int ATTRIBUTE_SEEN_EQ_STATE = 11;
  private static final int ATTRIBUTE_SEEN_NAME_STATE = 8;
  static final String BAD_ENCODING_SYNTAX = "bad 'encoding' declaration";
  static final String BAD_STANDALONE_SYNTAX = "bad 'standalone' declaration";
  private static final int BEGIN_ELEMENT_STATE = 2;
  private static final int DOCTYPE_NAME_SEEN_STATE = 16;
  private static final int DOCTYPE_SEEN_STATE = 13;
  private static final int END_ELEMENT_STATE = 4;
  private static final int EXPECT_NAME_MODIFIER = 1;
  private static final int EXPECT_RIGHT_STATE = 27;
  private static final int INIT_LEFT_QUEST_STATE = 30;
  private static final int INIT_LEFT_STATE = 34;
  private static final int INIT_STATE = 0;
  private static final int INIT_TEXT_STATE = 31;
  private static final int INVALID_VERSION_DECL = 35;
  private static final int MAYBE_ATTRIBUTE_STATE = 10;
  private static final int PREV_WAS_CR_STATE = 28;
  private static final int SAW_AMP_SHARP_STATE = 26;
  private static final int SAW_AMP_STATE = 25;
  private static final int SAW_ENTITY_REF = 6;
  private static final int SAW_EOF_ERROR = 37;
  private static final int SAW_ERROR = 36;
  private static final int SAW_LEFT_EXCL_MINUS_STATE = 22;
  private static final int SAW_LEFT_EXCL_STATE = 20;
  private static final int SAW_LEFT_QUEST_STATE = 21;
  private static final int SAW_LEFT_SLASH_STATE = 19;
  private static final int SAW_LEFT_STATE = 14;
  private static final int SKIP_SPACES_MODIFIER = 2;
  private static final int TEXT_STATE = 1;

  public static LineInputStreamReader XMLStreamReader(InputStream paramInputStream)
    throws IOException
  {
    LineInputStreamReader localLineInputStreamReader = new LineInputStreamReader(paramInputStream);
    int i = localLineInputStreamReader.getByte();
    int j;
    int k;
    if (i < 0)
    {
      j = -1;
      if (j >= 0)
        break label75;
      k = -1;
      label27: if ((i != 239) || (j != 187) || (k != 191))
        break label84;
      localLineInputStreamReader.resetStart(3);
      localLineInputStreamReader.setCharset("UTF-8");
    }
    while (true)
    {
      localLineInputStreamReader.setKeepFullLines(false);
      return localLineInputStreamReader;
      j = localLineInputStreamReader.getByte();
      break;
      label75: k = localLineInputStreamReader.getByte();
      break label27;
      label84: if ((i == 255) && (j == 254) && (k != 0))
      {
        localLineInputStreamReader.resetStart(2);
        localLineInputStreamReader.setCharset("UTF-16LE");
      }
      else
      {
        if ((i != 254) || (j != 255) || (k == 0))
          break label150;
        localLineInputStreamReader.resetStart(2);
        localLineInputStreamReader.setCharset("UTF-16BE");
      }
    }
    label150: if (k < 0);
    for (int m = -1; (i == 76) && (j == 111) && (k == 167) && (m == 148); m = localLineInputStreamReader.getByte())
      throw new RuntimeException("XMLParser: EBCDIC encodings not supported");
    localLineInputStreamReader.resetStart(0);
    int n;
    int i1;
    label308: int i2;
    int i3;
    label379: int i4;
    if (((i == 60) && (((j == 63) && (k == 120) && (m == 109)) || ((j == 0) && (k == 63) && (m == 0)))) || ((i == 0) && (j == 60) && (k == 0) && (m == 63)))
    {
      char[] arrayOfChar1 = localLineInputStreamReader.buffer;
      if (arrayOfChar1 == null)
      {
        arrayOfChar1 = new char[8192];
        localLineInputStreamReader.buffer = arrayOfChar1;
      }
      char[] arrayOfChar2 = arrayOfChar1;
      n = 0;
      i1 = 0;
      do
        i2 = localLineInputStreamReader.getByte();
      while (i2 == 0);
      if (i2 < 0);
      for (int i5 = i1; ; i5 = i3)
      {
        localLineInputStreamReader.pos = 0;
        localLineInputStreamReader.limit = i5;
        break;
        i3 = i1 + 1;
        arrayOfChar2[i1] = ((char)(i2 & 0xFF));
        if (n != 0)
          break label408;
        if (i2 != 62)
          break label379;
      }
      if ((i2 != 39) && (i2 != 34))
        break label430;
      i4 = i2;
    }
    while (true)
    {
      n = i4;
      i1 = i3;
      break label308;
      label408: if (i2 == n)
      {
        i4 = 0;
        continue;
        localLineInputStreamReader.setCharset("UTF-8");
        break;
      }
      label430: i4 = n;
    }
  }

  public static void parse(LineBufferedReader paramLineBufferedReader, SourceMessages paramSourceMessages, Consumer paramConsumer)
    throws IOException
  {
    XMLFilter localXMLFilter = new XMLFilter(paramConsumer);
    localXMLFilter.setMessages(paramSourceMessages);
    localXMLFilter.setSourceLocator(paramLineBufferedReader);
    localXMLFilter.startDocument();
    Path localPath = paramLineBufferedReader.getPath();
    if (localPath != null)
      localXMLFilter.writeDocumentUri(localPath);
    parse(paramLineBufferedReader, localXMLFilter);
    localXMLFilter.endDocument();
  }

  public static void parse(LineBufferedReader paramLineBufferedReader, SourceMessages paramSourceMessages, XMLFilter paramXMLFilter)
    throws IOException
  {
    paramXMLFilter.setMessages(paramSourceMessages);
    paramXMLFilter.setSourceLocator(paramLineBufferedReader);
    paramXMLFilter.startDocument();
    Path localPath = paramLineBufferedReader.getPath();
    if (localPath != null)
      paramXMLFilter.writeDocumentUri(localPath);
    parse(paramLineBufferedReader, paramXMLFilter);
    paramXMLFilter.endDocument();
    paramLineBufferedReader.close();
  }

  public static void parse(LineBufferedReader paramLineBufferedReader, XMLFilter paramXMLFilter)
  {
    char[] arrayOfChar = paramLineBufferedReader.buffer;
    int i = paramLineBufferedReader.pos;
    int j = paramLineBufferedReader.limit;
    int k = 32;
    int i1 = 0;
    int i2 = -1;
    int i3 = j;
    int i4 = 60;
    int i6 = 0;
    Object localObject1 = null;
    int i7 = j;
    int i8 = 14;
    int i9 = i;
    while (true)
    {
      label220: int i16;
      int i15;
      int i11;
      Object localObject2;
      int i13;
      label240: Object localObject3;
      label390: label534: label606: label878: int i59;
      label515: label674: label961: label967: label1351: int i10;
      switch (i6)
      {
      case 18:
      case 22:
      default:
        i16 = i8;
        i15 = i6;
        i11 = i9;
        localObject2 = localObject1;
        i13 = i4;
      case 0:
      case 31:
      case 34:
      case 35:
      case 37:
      case 1:
      case 28:
      case 12:
      case 15:
      case 23:
      case 29:
      case 32:
      case 3:
      case 5:
      case 7:
      case 9:
      case 17:
      case 24:
      case 33:
        while (true)
          if (i11 < i7)
          {
            int i21 = i11 + 1;
            k = arrayOfChar[i11];
            localObject1 = localObject2;
            i4 = i13;
            i6 = i15;
            i9 = i21;
            i8 = i16;
            break;
            i13 = i4;
            i15 = 31;
            i11 = i9;
            i16 = i8;
            localObject2 = localObject1;
            continue;
            if (k == 60)
            {
              i13 = i4;
              i15 = 34;
              i11 = i9;
              i16 = i8;
              localObject2 = localObject1;
            }
            else
            {
              i6 = 1;
              break;
              if (k == 63)
              {
                i3 = i9;
                i13 = i4;
                i15 = 33;
                i11 = i9;
                i16 = i8;
                localObject2 = localObject1;
              }
              else
              {
                i6 = 14;
                break;
                i9 = i2;
                localObject3 = "invalid xml version specifier";
                paramLineBufferedReader.pos = i9;
                paramXMLFilter.error('e', (String)localObject3);
                do
                {
                  int i26 = i9;
                  if (i26 >= i7)
                    return;
                  i9 = i26 + 1;
                  k = arrayOfChar[i26];
                }
                while (k != 62);
                i13 = i4;
                i15 = 1;
                i11 = i9;
                localObject2 = localObject3;
                i16 = i8;
                continue;
                paramLineBufferedReader.pos = i9;
                paramXMLFilter.error('f', "unexpected end-of-file");
                return;
                i3 = i9 - 1;
                int i62 = i9;
                while (true)
                {
                  int i69;
                  int i65;
                  if (k == i4)
                  {
                    i69 = i8;
                    i65 = i9;
                  }
                  for (int i66 = i69; ; i66 = 25)
                  {
                    i1 = i65 - i62;
                    if (i1 > 0)
                    {
                      paramLineBufferedReader.pos = i65;
                      paramXMLFilter.textFromParser(arrayOfChar, i3, i1);
                    }
                    i3 = arrayOfChar.length;
                    i13 = i4;
                    i15 = i66;
                    i11 = i65;
                    i16 = i8;
                    localObject2 = localObject1;
                    break;
                    if (k != 38)
                      break label606;
                    i65 = i9;
                  }
                  int i68;
                  if (k == 13)
                  {
                    i1 = i9 - i62;
                    paramLineBufferedReader.pos = i9;
                    if (i1 > 0)
                      paramXMLFilter.textFromParser(arrayOfChar, i3, i1);
                    if (i9 < i7)
                    {
                      k = arrayOfChar[i9];
                      if (k == 10)
                      {
                        i3 = i9;
                        i68 = i9 + 1;
                        i62 = i68;
                        paramLineBufferedReader.incrLineNumber(1, i68);
                        i9 = i68;
                      }
                    }
                  }
                  while (true)
                  {
                    if (i9 != i7)
                      break label878;
                    i62--;
                    i65 = i9;
                    i66 = i6;
                    break label534;
                    paramXMLFilter.linefeedFromParser();
                    if (k == 133)
                    {
                      i68 = i9 + 1;
                      i3 = i9;
                      i62 = i68 + 1;
                      break label674;
                    }
                    paramLineBufferedReader.incrLineNumber(1, i9);
                    i3 = i9;
                    int i67 = i9 + 1;
                    i62 = i67;
                    i9 = i67;
                    break label515;
                    paramXMLFilter.linefeedFromParser();
                    i13 = i4;
                    i15 = 28;
                    i11 = i9;
                    i16 = i8;
                    localObject2 = localObject1;
                    break;
                    if ((k == 133) || (k == 8232))
                    {
                      int i63 = i9 - i62;
                      paramLineBufferedReader.pos = (i9 - 1);
                      if (i63 > 0)
                        paramXMLFilter.textFromParser(arrayOfChar, i3, i63);
                      paramXMLFilter.linefeedFromParser();
                      paramLineBufferedReader.incrLineNumber(1, i9);
                      i62 = i9 + 1;
                      i3 = i9;
                    }
                    else if (k == 10)
                    {
                      paramLineBufferedReader.incrLineNumber(1, i9);
                    }
                  }
                  int i64 = i9 + 1;
                  k = arrayOfChar[i9];
                  i9 = i64;
                }
                int i60;
                if (k == 10)
                {
                  i60 = 1;
                  label907: if (k != 133)
                    break label961;
                }
                for (int i61 = 1; ; i61 = 0)
                {
                  if ((i60 | i61) == 0)
                    break label967;
                  paramLineBufferedReader.incrLineNumber(1, i9);
                  i13 = i4;
                  i15 = 1;
                  i11 = i9;
                  i16 = i8;
                  localObject2 = localObject1;
                  break;
                  i60 = 0;
                  break label907;
                }
                paramLineBufferedReader.incrLineNumber(1, i9 - 1);
                i6 = 1;
                break;
                if (k == 32)
                  break label220;
                if (k == 9)
                {
                  i16 = i8;
                  i15 = i6;
                  i11 = i9;
                  localObject2 = localObject1;
                  i13 = i4;
                }
                else if ((k == 10) || (k == 13) || (k == 133) || (k == 8232))
                {
                  paramLineBufferedReader.incrLineNumber(1, i9);
                  i16 = i8;
                  i15 = i6;
                  i11 = i9;
                  localObject2 = localObject1;
                  i13 = i4;
                }
                else
                {
                  i6 -= 2;
                  break;
                  i1 = i3 + 1;
                  while (true)
                  {
                    if (((k < 97) || (k > 122)) && ((k < 65) || (k > 90)) && (k != 95) && (k != 58) && ((k < 192) || ((k > 767) && ((k < 880) || (((k > 8191) || (k == 894)) && ((k < 8204) || ((k > 8205) && ((k < 8304) || (k > 8591)) && ((k < 11264) || (k > 12271)) && ((k < 12289) || (k > 55295)) && ((k < 63744) || (k > 65533)))))))) && ((i9 <= i1) || (k < 48) || (k > 57)) && (k != 46) && (k != 45) && (k != 183) && ((k <= 768) || ((k > 879) && ((k < 8255) || (k > 8256)))))
                      break label1351;
                    if (i9 >= i7)
                      break;
                    int i58 = i9 + 1;
                    k = arrayOfChar[i9];
                    i9 = i58;
                  }
                  i59 = i6 - 1;
                  i1 = i9 - i1;
                  if (i1 != 0)
                    break label4533;
                  String str2;
                  if (i59 == 8)
                    str2 = "missing or invalid attribute name";
                  while (true)
                  {
                    localObject1 = str2;
                    i6 = 36;
                    break;
                    if ((i59 == 2) || (i59 == 4))
                      str2 = "missing or invalid element name";
                    else
                      str2 = "missing or invalid name";
                  }
                  label1417: if ((i10 == 120) && (i2 == 0))
                  {
                    i2 = 16;
                    if (i11 >= i7)
                      break label4510;
                    int i24 = i11 + 1;
                    int i25 = arrayOfChar[i11];
                    i11 = i24;
                    i10 = i25;
                  }
                }
              }
            }
          }
      case 25:
      case 6:
      case 14:
      case 2:
      case 21:
      case 30:
      case 20:
      case 13:
      case 16:
      case 10:
      case 8:
      case 11:
      case 19:
      case 4:
      case 27:
      case 36:
      case 26:
      }
      label1522: label2299: int i14;
      label3022: label3194: int n;
      while (true)
      {
        if (i10 != 59)
          break label1417;
        paramLineBufferedReader.pos = i11;
        int i12 = i11 - 1 - i3;
        paramXMLFilter.emitCharacterReference(i1, arrayOfChar, i3, i12);
        localObject2 = localObject1;
        i13 = i4;
        i15 = 1;
        k = i10;
        i16 = i8;
        break label240;
        if (i1 >= 134217728)
        {
          paramLineBufferedReader.pos = i11;
          paramXMLFilter.error('e', "invalid character reference");
          localObject2 = localObject1;
          i13 = i4;
          i15 = 1;
          k = i10;
          i16 = i8;
          break label240;
        }
        if (i2 == 0);
        for (int i22 = 10; ; i22 = i2)
        {
          int i23 = Character.digit(i10, i22);
          if (i23 < 0)
            break label1522;
          i1 = i23 + i1 * i22;
          break;
        }
        if (k == 35)
        {
          i3 = i9;
          i13 = i4;
          i15 = 26;
          i11 = i9;
          i16 = i8;
          localObject2 = localObject1;
          i1 = 0;
          i2 = 0;
          break label240;
        }
        i3 = i9 - 1;
        i6 = 7;
        break;
        paramLineBufferedReader.pos = i9;
        if (k != 59)
          paramXMLFilter.error('w', "missing ';'");
        paramXMLFilter.emitEntityReference(arrayOfChar, i3, i1);
        i3 = i7;
        i13 = i4;
        i15 = 1;
        i11 = i9;
        i16 = i8;
        localObject2 = localObject1;
        break label240;
        if (k == 47)
        {
          i13 = i4;
          i15 = 19;
          i11 = i9;
          i16 = i8;
          localObject2 = localObject1;
          break label240;
        }
        if (k == 63)
        {
          i3 = i9;
          i13 = i4;
          i15 = 24;
          i11 = i9;
          i16 = i8;
          localObject2 = localObject1;
          break label240;
        }
        if (k == 33)
        {
          i3 = i9;
          i13 = i4;
          i15 = 20;
          i11 = i9;
          i16 = i8;
          localObject2 = localObject1;
          break label240;
        }
        i3 = i9 - 1;
        i6 = 3;
        break;
        paramLineBufferedReader.pos = (i9 - i1);
        paramXMLFilter.emitStartElement(arrayOfChar, i3, i1);
        i3 = i7;
        i6 = 12;
        break;
        int i42;
        int i43;
        if (i2 < 0)
        {
          i2 = i9 - 1;
          i42 = k;
          i43 = i9;
        }
        while (true)
        {
          int m;
          if (i42 == 62)
          {
            int i46 = i43 - 2;
            if ((arrayOfChar[i46] == '?') && (i46 >= i2))
            {
              paramLineBufferedReader.pos = i43;
              if ((i1 == 3) && (arrayOfChar[i3] == 'x') && (arrayOfChar[(i3 + 1)] == 'm') && (arrayOfChar[(i3 + 2)] == 'l'))
              {
                if (i6 == 30)
                {
                  if ((i46 <= i2 + 7) || (arrayOfChar[i2] != 'v') || (arrayOfChar[(i2 + 1)] != 'e') || (arrayOfChar[(i2 + 2)] != 'r') || (arrayOfChar[(i2 + 3)] != 's') || (arrayOfChar[(i2 + 4)] != 'i') || (arrayOfChar[(i2 + 5)] != 'o') || (arrayOfChar[(i2 + 6)] != 'n'))
                  {
                    i9 = i2;
                    localObject1 = "xml declaration without version";
                    i6 = 36;
                    k = i42;
                    break;
                  }
                  i2 += 7;
                  for (k = arrayOfChar[i2]; Character.isWhitespace(k); m = arrayOfChar[i2])
                  {
                    i2++;
                    if (i2 >= i46)
                      break;
                  }
                  if (m != 61)
                  {
                    i6 = 35;
                    i9 = i43;
                    break;
                  }
                  i2++;
                  for (m = arrayOfChar[i2]; Character.isWhitespace(m); m = arrayOfChar[i2])
                  {
                    i2++;
                    if (i2 >= i46)
                      break;
                  }
                  if ((m != 39) && (m != 34))
                  {
                    i6 = 35;
                    i9 = i43;
                    break;
                  }
                  int i48 = m;
                  i2++;
                  for (int i49 = i2; ; i49++)
                  {
                    if (i49 == i46)
                    {
                      i6 = 35;
                      i9 = i43;
                      break;
                    }
                    m = arrayOfChar[i49];
                    if (m == i48)
                    {
                      int i50 = i2 + 3;
                      if ((i49 == i50) && (arrayOfChar[i2] == '1') && (arrayOfChar[(i2 + 1)] == '.'))
                      {
                        m = arrayOfChar[(i2 + 2)];
                        if (m == 48);
                      }
                      else
                      {
                        if (m != 49)
                          break label2299;
                      }
                      for (i2 = i49 + 1; (i2 < i46) && (Character.isWhitespace(arrayOfChar[i2])); i2++);
                    }
                  }
                  i6 = 35;
                  i9 = i43;
                  break;
                  int i56;
                  if ((i46 > i2 + 7) && (arrayOfChar[i2] == 'e') && (arrayOfChar[(i2 + 1)] == 'n') && (arrayOfChar[(i2 + 2)] == 'c') && (arrayOfChar[(i2 + 3)] == 'o') && (arrayOfChar[(i2 + 4)] == 'd') && (arrayOfChar[(i2 + 5)] == 'i') && (arrayOfChar[(i2 + 6)] == 'n') && (arrayOfChar[(i2 + 7)] == 'g'))
                  {
                    i2 += 8;
                    for (m = arrayOfChar[i2]; Character.isWhitespace(m); m = arrayOfChar[i2])
                    {
                      i2++;
                      if (i2 >= i46)
                        break;
                    }
                    if (m != 61)
                    {
                      localObject1 = "bad 'encoding' declaration";
                      i6 = 36;
                      i9 = i43;
                      break;
                    }
                    i2++;
                    for (m = arrayOfChar[i2]; Character.isWhitespace(m); m = arrayOfChar[i2])
                    {
                      i2++;
                      if (i2 >= i46)
                        break;
                    }
                    if ((m != 39) && (m != 34))
                    {
                      localObject1 = "bad 'encoding' declaration";
                      i6 = 36;
                      i9 = i43;
                      break;
                    }
                    int i55 = m;
                    i2++;
                    for (i56 = i2; ; i56++)
                    {
                      if (i56 == i46)
                      {
                        localObject1 = "bad 'encoding' declaration";
                        i6 = 36;
                        i9 = i43;
                        break;
                      }
                      m = arrayOfChar[i56];
                      if (m == i55)
                      {
                        int i57 = i56 - i2;
                        String str1 = new String(arrayOfChar, i2, i57);
                        if ((paramLineBufferedReader instanceof LineInputStreamReader))
                          ((LineInputStreamReader)paramLineBufferedReader).setCharset(str1);
                        for (i2 = i56 + 1; (i2 < i46) && (Character.isWhitespace(arrayOfChar[i2])); i2++);
                      }
                    }
                  }
                  if ((i46 > i2 + 9) && (arrayOfChar[i2] == 's') && (arrayOfChar[(i2 + 1)] == 't') && (arrayOfChar[(i2 + 2)] == 'a') && (arrayOfChar[(i2 + 3)] == 'n') && (arrayOfChar[(i2 + 4)] == 'd') && (arrayOfChar[(i2 + 5)] == 'a') && (arrayOfChar[(i2 + 6)] == 'l') && (arrayOfChar[(i2 + 7)] == 'o') && (arrayOfChar[(i2 + 8)] == 'n') && (arrayOfChar[(i2 + 9)] == 'e'))
                  {
                    i2 += 10;
                    for (m = arrayOfChar[i2]; Character.isWhitespace(m); m = arrayOfChar[i2])
                    {
                      i2++;
                      if (i2 >= i46)
                        break;
                    }
                    if (m != 61)
                    {
                      localObject1 = "bad 'standalone' declaration";
                      i6 = 36;
                      i9 = i43;
                      break;
                    }
                    i2++;
                    for (m = arrayOfChar[i2]; Character.isWhitespace(m); m = arrayOfChar[i2])
                    {
                      i2++;
                      if (i2 >= i46)
                        break;
                    }
                    if ((m != 39) && (m != 34))
                    {
                      localObject1 = "bad 'standalone' declaration";
                      i6 = 36;
                      i9 = i43;
                      break;
                    }
                    int i51 = m;
                    i2++;
                    int i52 = i2;
                    if (i52 == i46)
                    {
                      localObject1 = "bad 'standalone' declaration";
                      i6 = 36;
                      i9 = i43;
                      break;
                    }
                    m = arrayOfChar[i52];
                    if (m == i51)
                    {
                      int i53 = i2 + 3;
                      if ((i52 != i53) || (arrayOfChar[i2] != 'y') || (arrayOfChar[(i2 + 1)] != 'e') || (arrayOfChar[(i2 + 2)] != 's'))
                        break label3022;
                    }
                    int i54;
                    do
                    {
                      for (i2 = i52 + 1; (i2 < i46) && (Character.isWhitespace(arrayOfChar[i2])); i2++);
                      i52++;
                      break;
                      i54 = i2 + 2;
                    }
                    while ((i52 == i54) && (arrayOfChar[i2] == 'n') && (arrayOfChar[(i2 + 1)] == 'o'));
                    localObject1 = "bad 'standalone' declaration";
                    i6 = 36;
                    i9 = i43;
                    break;
                  }
                  if (i46 == i2)
                    break label3135;
                  i9 = i2;
                  localObject1 = "junk at end of xml declaration";
                  i6 = 36;
                  break;
                }
                localObject1 = "<?xml must be at start of file";
                i6 = 36;
                m = i42;
                i9 = i43;
                break;
              }
              int i47 = i46 - i2;
              paramXMLFilter.processingInstructionFromParser(arrayOfChar, i3, i1, i2, i47);
              m = i42;
              label3135: i3 = i7;
              i2 = -1;
              localObject2 = localObject1;
              i13 = i4;
              i11 = i43;
              i15 = 1;
              i16 = i8;
              break label240;
            }
          }
          if (i43 < i7)
          {
            int i44 = i43 + 1;
            int i45 = arrayOfChar[i43];
            i43 = i44;
            i42 = i45;
            continue;
            label3334: label3474: 
            do
            {
              do
              {
                if (i9 >= i7)
                  break;
                int i37 = i9 + 1;
                m = arrayOfChar[i9];
                i9 = i37;
                if (m != 62)
                  break label3474;
                i1 = i9 - 1 - i3;
                if ((i1 < 4) || (arrayOfChar[i3] != '-') || (arrayOfChar[(i3 + 1)] != '-'))
                  break label3334;
              }
              while ((arrayOfChar[(i9 - 2)] != '-') || (arrayOfChar[(i9 - 3)] != '-'));
              paramLineBufferedReader.pos = i9;
              int i40 = i3 + 2;
              int i41 = i1 - 4;
              paramXMLFilter.commentFromParser(arrayOfChar, i40, i41);
              while (true)
              {
                i3 = i7;
                i13 = i4;
                i15 = 1;
                i11 = i9;
                i16 = i8;
                localObject2 = localObject1;
                break;
                if ((i1 >= 6) && (arrayOfChar[i3] == '[') && (arrayOfChar[(i3 + 1)] == 'C') && (arrayOfChar[(i3 + 2)] == 'D') && (arrayOfChar[(i3 + 3)] == 'A') && (arrayOfChar[(i3 + 4)] == 'T') && (arrayOfChar[(i3 + 5)] == 'A') && (arrayOfChar[(i3 + 6)] == '['))
                {
                  if ((arrayOfChar[(i9 - 2)] != ']') || (arrayOfChar[(i9 - 3)] != ']'))
                    break label3194;
                  paramLineBufferedReader.pos = i9;
                  int i38 = i3 + 7;
                  int i39 = i9 - 10 - i3;
                  paramXMLFilter.writeCDATA(arrayOfChar, i38, i39);
                }
              }
            }
            while ((i9 != i3 + 7) || (arrayOfChar[i3] != 'D') || (arrayOfChar[(i3 + 1)] != 'O') || (arrayOfChar[(i3 + 2)] != 'C') || (arrayOfChar[(i3 + 3)] != 'T') || (arrayOfChar[(i3 + 4)] != 'Y') || (arrayOfChar[(i3 + 5)] != 'P') || (m != 69));
            i3 = i7;
            i13 = i4;
            i15 = 15;
            i11 = i9;
            i16 = i8;
            localObject2 = localObject1;
            break label240;
            i3 = i9 - 1;
            i6 = 17;
            break;
            int i29;
            int i28;
            if (i2 < 0)
            {
              i2 = i9 - 1 - i3 << 1;
              int i36 = m;
              i29 = 0;
              i28 = i36;
            }
            while (true)
            {
              label3622: int i30;
              if ((i28 == 39) || (i28 == 34))
                if (i29 == 0)
                  i30 = i28;
              while (true)
              {
                if (i9 < i7)
                {
                  int i32 = i9 + 1;
                  int i33 = arrayOfChar[i9];
                  i9 = i32;
                  i28 = i33;
                  i29 = i30;
                  break label3622;
                  if (i29 != i28)
                    break label4454;
                  i31 = 0;
                  continue;
                  if (i29 != 0)
                    break label4454;
                  if (i28 == 91)
                  {
                    i2 |= 1;
                    i31 = i29;
                    continue;
                  }
                  if (i28 == 93)
                  {
                    i2 &= -2;
                    i31 = i29;
                    continue;
                  }
                  if ((i28 != 62) || ((i2 & 0x1) != 0))
                    break label4454;
                  paramLineBufferedReader.pos = i9;
                  int i34 = i3 + (i2 >> 1);
                  int i35 = i9 - 1 - i34;
                  paramXMLFilter.emitDoctypeDecl(arrayOfChar, i3, i1, i34, i35);
                  i3 = i7;
                  i2 = -1;
                  i14 = 60;
                  i15 = 1;
                  m = i28;
                  i11 = i9;
                  i16 = i8;
                  localObject2 = localObject1;
                  break label240;
                  i16 = 14;
                  if (m == 47)
                  {
                    paramLineBufferedReader.pos = i9;
                    paramXMLFilter.emitEndAttributes();
                    paramXMLFilter.emitEndElement(null, 0, 0);
                    i14 = 60;
                    i15 = 27;
                    i11 = i9;
                    localObject2 = localObject1;
                    break label240;
                  }
                  if (m == 62)
                  {
                    paramLineBufferedReader.pos = i9;
                    paramXMLFilter.emitEndAttributes();
                    i14 = 60;
                    i15 = 1;
                    i11 = i9;
                    localObject2 = localObject1;
                    break label240;
                  }
                  i3 = i9 - 1;
                  i5 = 60;
                  i6 = 9;
                  i8 = i16;
                  break;
                  if ((m == 32) || (m == 9) || (m == 13) || (m == 10) || (m == 133))
                    break label220;
                  if (m == 8232)
                  {
                    i16 = i8;
                    i15 = i6;
                    i11 = i9;
                    localObject2 = localObject1;
                    i14 = i5;
                    break label240;
                  }
                  paramLineBufferedReader.pos = (i9 - i1);
                  paramXMLFilter.emitStartAttribute(arrayOfChar, i3, i1);
                  i3 = i7;
                  if (m == 61)
                  {
                    i14 = i5;
                    i15 = 11;
                    i11 = i9;
                    i16 = i8;
                    localObject2 = localObject1;
                    break label240;
                  }
                  paramXMLFilter.emitEndAttributes();
                  localObject1 = "missing or misplaced '=' after attribute name";
                  i6 = 36;
                  break;
                  if ((m == 39) || (m == 34))
                  {
                    int i27 = m;
                    i16 = 12;
                    i14 = i27;
                    i15 = 1;
                    i11 = i9;
                    localObject2 = localObject1;
                    break label240;
                  }
                  if ((m == 32) || (m == 9) || (m == 13) || (m == 10) || (m == 133))
                    break label220;
                  if (m == 8232)
                  {
                    i16 = i8;
                    i15 = i6;
                    i11 = i9;
                    localObject2 = localObject1;
                    i14 = i5;
                    break label240;
                  }
                  localObject1 = "missing or unquoted attribute value";
                  i6 = 36;
                  break;
                  i3 = i9 - 1;
                  i6 = 5;
                  break;
                  paramLineBufferedReader.pos = i9;
                  paramXMLFilter.emitEndElement(arrayOfChar, i3, i1);
                  i3 = i7;
                  i6 = 29;
                  break;
                  if (m != 62)
                  {
                    localObject1 = "missing '>'";
                    i6 = 36;
                    break;
                  }
                  i14 = i5;
                  i15 = 1;
                  i11 = i9;
                  i16 = i8;
                  localObject2 = localObject1;
                  break label240;
                  int i17 = i11 - i3;
                  if (i17 > 0);
                  while (true)
                  {
                    int i19;
                    try
                    {
                      paramLineBufferedReader.pos = i3;
                      paramLineBufferedReader.mark(i17 + 1);
                      paramLineBufferedReader.pos = i11;
                      if (paramLineBufferedReader.read() < 0)
                      {
                        if (i15 == 1)
                          break label4558;
                        if (i15 != 28)
                          break label4577;
                        break label4558;
                      }
                      if (i17 > 0)
                      {
                        paramLineBufferedReader.reset();
                        paramLineBufferedReader.skip(i17);
                        int i18 = paramLineBufferedReader.pos;
                        arrayOfChar = paramLineBufferedReader.buffer;
                        i19 = paramLineBufferedReader.limit;
                        if (i17 <= 0)
                          break label4420;
                        i3 = i18 - i17;
                        int i20 = i18 + 1;
                        n = arrayOfChar[i18];
                        localObject1 = localObject2;
                        i5 = i14;
                        i7 = i19;
                        i6 = i15;
                        i8 = i16;
                        i9 = i20;
                        break;
                      }
                      paramLineBufferedReader.unread_quick();
                      continue;
                    }
                    catch (IOException localIOException)
                    {
                      RuntimeException localRuntimeException = new RuntimeException(localIOException.getMessage());
                      throw localRuntimeException;
                    }
                    label4420: i3 = i19;
                  }
                }
                n = i28;
                i15 = i6;
                i16 = i8;
                i14 = i31;
                i11 = i9;
                localObject2 = localObject1;
                break label240;
                label4454: int i31 = i29;
              }
              i28 = n;
              i29 = i5;
            }
          }
          localObject2 = localObject1;
          n = i42;
          i11 = i43;
          i15 = i6;
          i16 = i8;
          i14 = i5;
          break label240;
          i42 = n;
          i43 = i9;
        }
        label4510: localObject2 = localObject1;
        n = i10;
        i15 = i6;
        i14 = i5;
        i16 = i8;
        break label240;
        label4533: i6 = i59;
        break;
        localObject3 = localObject1;
        break label390;
        i10 = n;
        i11 = i9;
      }
      label4558: return;
      label4577: localObject1 = localObject2;
      int i5 = i14;
      i6 = 37;
      i9 = i11;
      i8 = i16;
    }
  }

  public static void parse(InputStream paramInputStream, Object paramObject, SourceMessages paramSourceMessages, Consumer paramConsumer)
    throws IOException
  {
    LineInputStreamReader localLineInputStreamReader = XMLStreamReader(paramInputStream);
    if (paramObject != null)
      localLineInputStreamReader.setName(paramObject);
    parse(localLineInputStreamReader, paramSourceMessages, paramConsumer);
    localLineInputStreamReader.close();
  }

  public static void parse(Object paramObject, SourceMessages paramSourceMessages, Consumer paramConsumer)
    throws IOException
  {
    parse(Path.openInputStream(paramObject), paramObject, paramSourceMessages, paramConsumer);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.xml.XMLParser
 * JD-Core Version:    0.6.2
 */