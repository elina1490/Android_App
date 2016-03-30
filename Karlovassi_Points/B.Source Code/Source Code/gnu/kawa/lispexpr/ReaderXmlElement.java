package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.expr.Compilation;
import gnu.expr.PrimProcedure;
import gnu.expr.Special;
import gnu.kawa.xml.CommentConstructor;
import gnu.kawa.xml.MakeAttribute;
import gnu.kawa.xml.MakeCDATA;
import gnu.kawa.xml.MakeProcInst;
import gnu.kawa.xml.MakeText;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import gnu.xml.XName;
import java.io.IOException;

public class ReaderXmlElement extends ReadTableEntry
{
  static final String DEFAULT_ELEMENT_NAMESPACE = "[default-element-namespace]";

  public static void namedEntity(LispReader paramLispReader, String paramString)
  {
    String str = paramString.intern();
    int i = 63;
    if (str == "lt")
      i = 60;
    while (true)
    {
      paramLispReader.tokenBufferAppend(i);
      return;
      if (str == "gt")
        i = 62;
      else if (str == "amp")
        i = 38;
      else if (str == "quot")
        i = 34;
      else if (str == "apos")
        i = 39;
      else
        paramLispReader.error("unknown enity reference: '" + str + "'");
    }
  }

  public static Pair quote(Object paramObject)
  {
    return LList.list2(Namespace.EmptyNamespace.getSymbol("quote"), paramObject);
  }

  static void readCharRef(LispReader paramLispReader)
    throws IOException, SyntaxException
  {
    int i = paramLispReader.read();
    int j;
    int k;
    if (i == 120)
    {
      j = 16;
      i = paramLispReader.read();
      k = 0;
    }
    while (true)
    {
      int m;
      if (i >= 0)
      {
        m = Character.digit((char)i, j);
        if (m >= 0)
          break label62;
      }
      label62: 
      while (k >= 134217728)
      {
        if (i == 59)
          break label83;
        paramLispReader.unread(i);
        paramLispReader.error("invalid character reference");
        return;
        j = 10;
        break;
      }
      k = m + k * j;
      i = paramLispReader.read();
    }
    label83: if (((k > 0) && (k <= 55295)) || ((k >= 57344) && (k <= 65533)) || ((k >= 65536) && (k <= 1114111)))
    {
      paramLispReader.tokenBufferAppend(k);
      return;
    }
    paramLispReader.error("invalid character value " + k);
  }

  public static Pair readContent(LispReader paramLispReader, char paramChar, Pair paramPair)
    throws IOException, SyntaxException
  {
    paramLispReader.tokenBufferLength = 0;
    int i = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    int j = 1 + paramLispReader.getLineNumber();
    int k = paramLispReader.getColumnNumber();
    char c = paramLispReader.read();
    int m;
    Object localObject3;
    Object localObject4;
    label62: Object localObject5;
    label85: String str4;
    if (c < 0)
    {
      paramLispReader.error("unexpected end-of-file");
      Object localObject7 = Special.eof;
      m = i;
      localObject3 = null;
      localObject4 = localObject7;
      if ((localObject4 == null) || (paramLispReader.tokenBufferLength <= 0))
        break label480;
      localObject5 = paramLispReader.tokenBufferString();
      paramLispReader.tokenBufferLength = 0;
      if (localObject5 != null)
      {
        PairWithPosition localPairWithPosition2 = PairWithPosition.make(Pair.list2(MakeText.makeText, localObject5), paramLispReader.makeNil(), null, -1, -1);
        paramPair.setCdrBackdoor(localPairWithPosition2);
        paramPair = localPairWithPosition2;
      }
      if (localObject4 == Special.eof)
        return paramPair;
    }
    else if (c == paramChar)
    {
      if (paramChar == '<')
      {
        if (paramLispReader.tokenBufferLength <= 0)
          break label493;
        str4 = paramLispReader.tokenBufferString();
        paramLispReader.tokenBufferLength = 0;
      }
    }
    label275: label480: label487: label493: for (String str3 = str4; ; str3 = null)
    {
      c = paramLispReader.read();
      Object localObject6;
      String str2;
      if (c == '/')
      {
        localObject6 = Special.eof;
        str2 = str3;
      }
      while (true)
      {
        localObject3 = str2;
        localObject4 = localObject6;
        m = 0;
        break;
        localObject6 = readXMLConstructor(paramLispReader, c, true);
        str2 = str3;
        continue;
        if (paramLispReader.checkNext(paramChar))
        {
          paramLispReader.tokenBufferAppend(paramChar);
          localObject6 = null;
          str2 = null;
        }
        else
        {
          localObject6 = Special.eof;
          str2 = null;
        }
      }
      int n;
      if (c == '&')
      {
        n = paramLispReader.read();
        if (n == 35)
        {
          readCharRef(paramLispReader);
          m = 1;
          localObject3 = localObject2;
          localObject4 = localObject1;
          break label62;
        }
        if ((n == 40) || (n == 123))
          if ((paramLispReader.tokenBufferLength <= 0) && (i == 0))
            break label487;
      }
      for (String str1 = paramLispReader.tokenBufferString(); ; str1 = null)
      {
        paramLispReader.tokenBufferLength = 0;
        localObject1 = readEscapedExpression(paramLispReader, n);
        localObject2 = str1;
        break label275;
        localObject1 = readEntity(paramLispReader, n);
        localObject2 = null;
        if (i == 0)
          break label275;
        int i1 = paramLispReader.tokenBufferLength;
        localObject2 = null;
        if (i1 != 0)
          break label275;
        localObject2 = "";
        break label275;
        if ((paramChar != '<') && ((c == '\t') || (c == '\n') || (c == '\r')))
          c = ' ';
        if (c == '<')
          paramLispReader.error('e', "'<' must be quoted in a direct attribute value");
        paramLispReader.tokenBufferAppend((char)c);
        m = i;
        localObject3 = null;
        localObject4 = null;
        break label62;
        if (localObject4 != null)
        {
          PairWithPosition localPairWithPosition1 = PairWithPosition.make(localObject4, paramLispReader.makeNil(), null, j, k);
          paramPair.setCdrBackdoor(localPairWithPosition1);
          paramPair = localPairWithPosition1;
        }
        i = m;
        break;
        localObject5 = localObject3;
        break label85;
      }
    }
  }

  public static Object readElementConstructor(LispReader paramLispReader, int paramInt)
    throws IOException, SyntaxException
  {
    int i = 1 + paramLispReader.getLineNumber();
    int j = paramLispReader.getColumnNumber() - 2;
    Object localObject1 = readQNameExpression(paramLispReader, paramInt, true);
    if (paramLispReader.tokenBufferLength == 0);
    PairWithPosition localPairWithPosition1;
    Object localObject2;
    Object localObject3;
    int k;
    int m;
    for (String str1 = null; ; str1 = paramLispReader.tokenBufferString())
    {
      localPairWithPosition1 = PairWithPosition.make(localObject1, LList.Empty, paramLispReader.getName(), i, j);
      localObject2 = LList.Empty;
      localObject3 = localPairWithPosition1;
      k = 0;
      m = paramLispReader.readUnicodeChar();
      while ((m >= 0) && (Character.isWhitespace(m)))
      {
        m = paramLispReader.read();
        k = 1;
      }
    }
    int n;
    label145: Object localObject5;
    String str5;
    if ((m < 0) || (m == 62) || (m == 47))
    {
      n = 0;
      if (m == 47)
      {
        m = paramLispReader.read();
        if (m == 62)
          n = 1;
      }
      else
      {
        if (n != 0)
          break label741;
        if (m == 62)
          break label490;
        paramLispReader.error("missing '>' after start element");
        Boolean localBoolean = Boolean.FALSE;
        return localBoolean;
      }
    }
    else
    {
      if (k == 0)
        paramLispReader.error("missing space before attribute");
      localObject5 = readQNameExpression(paramLispReader, m, false);
      (1 + paramLispReader.getLineNumber());
      (1 + paramLispReader.getColumnNumber() - paramLispReader.tokenBufferLength);
      if ((paramLispReader.tokenBufferLength < 5) || (paramLispReader.tokenBuffer[0] != 'x') || (paramLispReader.tokenBuffer[1] != 'm') || (paramLispReader.tokenBuffer[2] != 'l') || (paramLispReader.tokenBuffer[3] != 'n') || (paramLispReader.tokenBuffer[4] != 's'))
        break label748;
      if (paramLispReader.tokenBufferLength == 5)
        str5 = "";
    }
    while (true)
    {
      label291: if (skipSpace(paramLispReader, 32) != 61)
        paramLispReader.error("missing '=' after attribute");
      int i4 = skipSpace(paramLispReader, 32);
      PairWithPosition localPairWithPosition3 = PairWithPosition.make(MakeAttribute.makeAttribute, LList.Empty, paramLispReader.getName(), i, j);
      PairWithPosition localPairWithPosition4 = PairWithPosition.make(localObject5, LList.Empty, paramLispReader.getName(), i, j);
      paramLispReader.setCdr(localPairWithPosition3, localPairWithPosition4);
      readContent(paramLispReader, (char)i4, localPairWithPosition4);
      Object localObject6;
      Object localObject7;
      if (str5 != null)
      {
        localObject6 = new PairWithPosition(localPairWithPosition4, Pair.make(str5, localPairWithPosition4.getCdr()), localObject2);
        localObject7 = localObject3;
      }
      while (true)
      {
        localObject2 = localObject6;
        localObject3 = localObject7;
        break;
        if (paramLispReader.tokenBuffer[5] != ':')
          break label748;
        str5 = new String(paramLispReader.tokenBuffer, 6, paramLispReader.tokenBufferLength - 6);
        break label291;
        PairWithPosition localPairWithPosition5 = PairWithPosition.make(localPairWithPosition3, paramLispReader.makeNil(), null, -1, -1);
        ((Pair)localObject3).setCdrBackdoor(localPairWithPosition5);
        localObject7 = localPairWithPosition5;
        localObject6 = localObject2;
      }
      paramLispReader.unread(m);
      n = 0;
      break label145;
      label490: Pair localPair = readContent(paramLispReader, '<', (Pair)localObject3);
      int i1 = paramLispReader.readUnicodeChar();
      String str2;
      String str4;
      if (XName.isNameStart(i1))
      {
        paramLispReader.tokenBufferLength = 0;
        do
        {
          paramLispReader.tokenBufferAppend(i1);
          i1 = paramLispReader.readUnicodeChar();
        }
        while ((XName.isNamePart(i1)) || (i1 == 58));
        str2 = paramLispReader.tokenBufferString();
        if ((str1 == null) || (!str2.equals(str1)))
        {
          String str3 = paramLispReader.getName();
          int i2 = 1 + paramLispReader.getLineNumber();
          int i3 = paramLispReader.getColumnNumber() - paramLispReader.tokenBufferLength;
          if (str1 == null)
          {
            str4 = "computed start tag closed by '</" + str2 + ">'";
            paramLispReader.error('e', str3, i2, i3, str4);
          }
        }
        else
        {
          paramLispReader.tokenBufferLength = 0;
        }
      }
      else if (skipSpace(paramLispReader, i1) != 62)
      {
        paramLispReader.error("missing '>' after end element");
      }
      label741: for (Object localObject4 = localPair; ; localObject4 = localObject3)
      {
        LList localLList = LList.reverseInPlace(localObject2);
        PairWithPosition localPairWithPosition2 = PairWithPosition.make(MakeXmlElement.makeXml, Pair.make(localLList, localPairWithPosition1), paramLispReader.getName(), i, j);
        return localPairWithPosition2;
        str4 = "'<" + str1 + ">' closed by '</" + str2 + ">'";
        break;
      }
      label748: str5 = null;
    }
  }

  static Object readEntity(LispReader paramLispReader, int paramInt)
    throws IOException, SyntaxException
  {
    int i = paramLispReader.tokenBufferLength;
    while (true)
    {
      int j;
      if (paramInt >= 0)
      {
        j = (char)paramInt;
        if (XName.isNamePart(j));
      }
      else
      {
        if (paramInt == 59)
          break;
        paramLispReader.unread(paramInt);
        paramLispReader.error("invalid entity reference");
        return "?";
      }
      paramLispReader.tokenBufferAppend(j);
      paramInt = paramLispReader.read();
    }
    String str = new String(paramLispReader.tokenBuffer, i, paramLispReader.tokenBufferLength - i);
    paramLispReader.tokenBufferLength = i;
    namedEntity(paramLispReader, str);
    return null;
  }

  static Object readEscapedExpression(LispReader paramLispReader, int paramInt)
    throws IOException, SyntaxException
  {
    if (paramInt == 40)
    {
      paramLispReader.unread(paramInt);
      return paramLispReader.readObject();
    }
    LineBufferedReader localLineBufferedReader = paramLispReader.getPort();
    char c = paramLispReader.pushNesting('{');
    int i = localLineBufferedReader.getLineNumber();
    int j = localLineBufferedReader.getColumnNumber();
    try
    {
      Pair localPair1 = paramLispReader.makePair(new PrimProcedure(Compilation.typeValues.getDeclaredMethod("values", 1)), i, j);
      ReadTable localReadTable = ReadTable.getCurrent();
      Object localObject2 = localPair1;
      while (true)
      {
        int k = localLineBufferedReader.getLineNumber();
        int m = localLineBufferedReader.getColumnNumber();
        int n = localLineBufferedReader.read();
        if (n == 125)
        {
          paramLispReader.tokenBufferLength = 0;
          if (localObject2 != localPair1.getCdr())
            break;
          Object localObject3 = ((Pair)localObject2).getCar();
          return localObject3;
        }
        if (n < 0)
          paramLispReader.eofError("unexpected EOF in list starting here", i + 1, j);
        Object localObject4 = paramLispReader.readValues(n, localReadTable.lookup(n), localReadTable);
        if (localObject4 != Values.empty)
        {
          Pair localPair2 = paramLispReader.makePair(paramLispReader.handlePostfix(localObject4, localReadTable, k, m), k, m);
          paramLispReader.setCdr(localObject2, localPair2);
          localObject2 = localPair2;
        }
      }
      return localPair1;
    }
    finally
    {
      paramLispReader.popNesting(c);
    }
  }

  public static Object readQNameExpression(LispReader paramLispReader, int paramInt, boolean paramBoolean)
    throws IOException, SyntaxException
  {
    paramLispReader.getName();
    int i = 1 + paramLispReader.getLineNumber();
    int j = paramLispReader.getColumnNumber();
    paramLispReader.tokenBufferLength = 0;
    if (XName.isNameStart(paramInt))
    {
      int k = -1;
      do
        while (true)
        {
          paramLispReader.tokenBufferAppend(paramInt);
          paramInt = paramLispReader.readUnicodeChar();
          if ((paramInt != 58) || (k >= 0))
            break;
          k = paramLispReader.tokenBufferLength;
        }
      while (XName.isNamePart(paramInt));
      paramLispReader.unread(paramInt);
      if ((k >= 0) || (paramBoolean))
      {
        int m = paramLispReader.tokenBufferLength - k - 1;
        String str1 = new String(paramLispReader.tokenBuffer, k + 1, m).intern();
        if (k < 0);
        for (String str2 = "[default-element-namespace]"; ; str2 = new String(paramLispReader.tokenBuffer, 0, k).intern())
        {
          Symbol localSymbol = Namespace.EmptyNamespace.getSymbol(str2);
          return new Pair(ResolveNamespace.resolveQName, PairWithPosition.make(localSymbol, new Pair(str1, LList.Empty), paramLispReader.getName(), i, j));
        }
      }
      return quote(Namespace.getDefaultSymbol(paramLispReader.tokenBufferString().intern()));
    }
    if ((paramInt == 123) || (paramInt == 40))
      return readEscapedExpression(paramLispReader, paramInt);
    paramLispReader.error("missing element name");
    return null;
  }

  static Object readXMLConstructor(LispReader paramLispReader, int paramInt, boolean paramBoolean)
    throws IOException, SyntaxException
  {
    int i = 1 + paramLispReader.getLineNumber();
    int j = paramLispReader.getColumnNumber() - 2;
    if (paramInt == 33)
    {
      int n = paramLispReader.read();
      if (n == 45)
      {
        n = paramLispReader.peek();
        if (n == 45)
        {
          paramLispReader.skip();
          if (!paramLispReader.readDelimited("-->"))
            paramLispReader.error('f', paramLispReader.getName(), i, j, "unexpected end-of-file in XML comment starting here - expected \"-->\"");
          String str4 = paramLispReader.tokenBufferString();
          return LList.list2(CommentConstructor.commentConstructor, str4);
        }
      }
      if (n == 91)
      {
        n = paramLispReader.read();
        if (n == 67)
        {
          n = paramLispReader.read();
          if (n == 68)
          {
            n = paramLispReader.read();
            if (n == 65)
            {
              n = paramLispReader.read();
              if (n == 84)
              {
                n = paramLispReader.read();
                if (n == 65)
                {
                  n = paramLispReader.read();
                  if (n == 91)
                  {
                    if (!paramLispReader.readDelimited("]]>"))
                      paramLispReader.error('f', paramLispReader.getName(), i, j, "unexpected end-of-file in CDATA starting here - expected \"]]>\"");
                    String str3 = paramLispReader.tokenBufferString();
                    return LList.list2(MakeCDATA.makeCDATA, str3);
                  }
                }
              }
            }
          }
        }
      }
      paramLispReader.error('f', paramLispReader.getName(), i, j, "'<!' must be followed by '--' or '[CDATA['");
      while ((n >= 0) && (n != 62) && (n != 10) && (n != 13))
        n = paramLispReader.read();
      return null;
    }
    if (paramInt == 63)
    {
      int k = paramLispReader.readUnicodeChar();
      if ((k < 0) || (!XName.isNameStart(k)))
        paramLispReader.error("missing target after '<?'");
      do
      {
        paramLispReader.tokenBufferAppend(k);
        k = paramLispReader.readUnicodeChar();
      }
      while (XName.isNamePart(k));
      String str1 = paramLispReader.tokenBufferString();
      int m = 0;
      while ((k >= 0) && (Character.isWhitespace(k)))
      {
        m++;
        k = paramLispReader.read();
      }
      paramLispReader.unread(k);
      char c = paramLispReader.pushNesting('?');
      try
      {
        if (!paramLispReader.readDelimited("?>"))
          paramLispReader.error('f', paramLispReader.getName(), i, j, "unexpected end-of-file looking for \"?>\"");
        paramLispReader.popNesting(c);
        if ((m == 0) && (paramLispReader.tokenBufferLength > 0))
          paramLispReader.error("target must be followed by space or '?>'");
        String str2 = paramLispReader.tokenBufferString();
        return LList.list3(MakeProcInst.makeProcInst, str1, str2);
      }
      finally
      {
        paramLispReader.popNesting(c);
      }
    }
    return readElementConstructor(paramLispReader, paramInt);
  }

  static int skipSpace(LispReader paramLispReader, int paramInt)
    throws IOException, SyntaxException
  {
    while (true)
    {
      if ((paramInt < 0) || (!Character.isWhitespace(paramInt)))
        return paramInt;
      paramInt = paramLispReader.readUnicodeChar();
    }
  }

  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    LispReader localLispReader = (LispReader)paramLexer;
    return readXMLConstructor(localLispReader, localLispReader.readUnicodeChar(), false);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderXmlElement
 * JD-Core Version:    0.6.2
 */