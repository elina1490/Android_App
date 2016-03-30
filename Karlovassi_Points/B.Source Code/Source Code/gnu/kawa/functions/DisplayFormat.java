package gnu.kawa.functions;

import gnu.expr.Keyword;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.AbstractFormat;
import gnu.lists.CharSeq;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.ConsumerWriter;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.SimpleVector;
import gnu.lists.Strings;
import gnu.mapping.Namespace;
import gnu.mapping.OutPort;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.Values;
import gnu.math.IntNum;
import gnu.math.RatNum;
import gnu.text.Char;
import gnu.text.Printable;
import gnu.xml.XMLPrinter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisplayFormat extends AbstractFormat
{
  public static final ThreadLocation outBase = new ThreadLocation("out-base");
  public static final ThreadLocation outRadix = new ThreadLocation("out-radix");
  static Pattern r5rsIdentifierMinusInteriorColons = Pattern.compile("(([a-zA-Z]|[!$%&*/:<=>?^_~])([a-zA-Z]|[!$%&*/<=>?^_~]|[0-9]|([-+.@]))*[:]?)|([-+]|[.][.][.])");
  char language;
  boolean readable;

  static
  {
    outBase.setGlobal(IntNum.ten());
  }

  public DisplayFormat(boolean paramBoolean, char paramChar)
  {
    this.readable = paramBoolean;
    this.language = paramChar;
  }

  public static DisplayFormat getCommonLispFormat(boolean paramBoolean)
  {
    return new DisplayFormat(paramBoolean, 'C');
  }

  public static DisplayFormat getEmacsLispFormat(boolean paramBoolean)
  {
    return new DisplayFormat(paramBoolean, 'E');
  }

  public static DisplayFormat getSchemeFormat(boolean paramBoolean)
  {
    return new DisplayFormat(paramBoolean, 'S');
  }

  public boolean getReadableOutput()
  {
    return this.readable;
  }

  int write(gnu.lists.Array paramArray, int paramInt1, int paramInt2, Consumer paramConsumer)
  {
    int i = paramArray.rank();
    String str;
    label37: int j;
    int m;
    int n;
    if (paramInt2 > 0)
    {
      str = "(";
      if (!(paramConsumer instanceof OutPort))
        break label182;
      ((OutPort)paramConsumer).startLogicalBlock(str, false, ")");
      j = 0;
      if (i <= 0)
        break label208;
      int k = paramArray.getSize(paramInt2);
      m = paramInt2 + 1;
      n = 0;
      label62: if (n >= k)
        break label208;
      if (n > 0)
      {
        write(" ", paramConsumer);
        if ((paramConsumer instanceof OutPort))
          ((OutPort)paramConsumer).writeBreakFill();
      }
      if (m != i)
        break label193;
      writeObject(paramArray.getRowMajor(paramInt1), paramConsumer);
    }
    label182: label193: for (int i1 = 1; ; i1 = write(paramArray, paramInt1, m, paramConsumer))
    {
      paramInt1 += i1;
      j += i1;
      n++;
      break label62;
      if (i == 1)
      {
        str = "#(";
        break;
      }
      str = "#" + i + "a(";
      break;
      write(str, paramConsumer);
      break label37;
    }
    label208: if ((paramConsumer instanceof OutPort))
    {
      ((OutPort)paramConsumer).endLogicalBlock(")");
      return j;
    }
    write(")", paramConsumer);
    return j;
  }

  public void write(int paramInt, Consumer paramConsumer)
  {
    if (!getReadableOutput())
    {
      Char.print(paramInt, paramConsumer);
      return;
    }
    if ((this.language == 'E') && (paramInt > 32))
    {
      paramConsumer.write(63);
      Char.print(paramInt, paramConsumer);
      return;
    }
    write(Char.toScmReadableString(paramInt), paramConsumer);
  }

  public void writeBoolean(boolean paramBoolean, Consumer paramConsumer)
  {
    String str;
    if (this.language == 'S')
      if (paramBoolean)
        str = "#t";
    while (true)
    {
      write(str, paramConsumer);
      return;
      str = "#f";
      continue;
      if (paramBoolean)
        str = "t";
      else
        str = "nil";
    }
  }

  public void writeList(LList paramLList, OutPort paramOutPort)
  {
    Object localObject = paramLList;
    paramOutPort.startLogicalBlock("(", false, ")");
    while ((localObject instanceof Pair))
    {
      if (localObject != paramLList)
        paramOutPort.writeSpaceFill();
      Pair localPair = (Pair)localObject;
      writeObject(localPair.getCar(), paramOutPort);
      localObject = localPair.getCdr();
    }
    if (localObject != LList.Empty)
    {
      paramOutPort.writeSpaceFill();
      paramOutPort.write(". ");
      writeObject(LList.checkNonList(localObject), paramOutPort);
    }
    paramOutPort.endLogicalBlock(")");
  }

  public void writeObject(Object paramObject, Consumer paramConsumer)
  {
    boolean bool1 = paramConsumer instanceof OutPort;
    int i = 0;
    if (bool1)
    {
      boolean bool2 = paramObject instanceof UntypedAtomic;
      i = 0;
      if (!bool2)
      {
        boolean bool3 = paramObject instanceof Values;
        i = 0;
        if (!bool3)
          if (!getReadableOutput())
          {
            boolean bool4 = paramObject instanceof Char;
            i = 0;
            if (!bool4)
            {
              boolean bool5 = paramObject instanceof CharSequence;
              i = 0;
              if (!bool5)
              {
                boolean bool6 = paramObject instanceof Character;
                i = 0;
                if (bool6);
              }
            }
          }
          else
          {
            ((OutPort)paramConsumer).writeWordStart();
            i = 1;
          }
      }
    }
    writeObjectRaw(paramObject, paramConsumer);
    if (i != 0)
      ((OutPort)paramConsumer).writeWordEnd();
  }

  public void writeObjectRaw(Object paramObject, Consumer paramConsumer)
  {
    if ((paramObject instanceof Boolean))
      writeBoolean(((Boolean)paramObject).booleanValue(), paramConsumer);
    while (true)
    {
      return;
      if ((paramObject instanceof Char))
      {
        write(((Char)paramObject).intValue(), paramConsumer);
        return;
      }
      if ((paramObject instanceof Character))
      {
        write(((Character)paramObject).charValue(), paramConsumer);
        return;
      }
      if ((paramObject instanceof Symbol))
      {
        Symbol localSymbol = (Symbol)paramObject;
        if (localSymbol.getNamespace() == XmlNamespace.HTML)
        {
          write("html:", paramConsumer);
          write(localSymbol.getLocalPart(), paramConsumer);
          return;
        }
        writeSymbol(localSymbol, paramConsumer, this.readable);
        return;
      }
      if (((paramObject instanceof URI)) && (getReadableOutput()) && ((paramConsumer instanceof PrintWriter)))
      {
        write("#,(URI ", paramConsumer);
        Strings.printQuoted(paramObject.toString(), (PrintWriter)paramConsumer, 1);
        paramConsumer.write(41);
        return;
      }
      if (!(paramObject instanceof CharSequence))
        break;
      CharSequence localCharSequence = (CharSequence)paramObject;
      if ((getReadableOutput()) && ((paramConsumer instanceof PrintWriter)))
      {
        Strings.printQuoted(localCharSequence, (PrintWriter)paramConsumer, 1);
        return;
      }
      if ((paramObject instanceof String))
      {
        paramConsumer.write((String)paramObject);
        return;
      }
      if ((paramObject instanceof CharSeq))
      {
        CharSeq localCharSeq = (CharSeq)paramObject;
        localCharSeq.consume(0, localCharSeq.size(), paramConsumer);
        return;
      }
      int i2 = localCharSequence.length();
      for (int i3 = 0; i3 < i2; i3++)
        paramConsumer.write(localCharSequence.charAt(i3));
    }
    if (((paramObject instanceof LList)) && ((paramConsumer instanceof OutPort)))
    {
      writeList((LList)paramObject, (OutPort)paramConsumer);
      return;
    }
    if ((paramObject instanceof SimpleVector))
    {
      SimpleVector localSimpleVector = (SimpleVector)paramObject;
      String str3 = localSimpleVector.getTag();
      String str4;
      String str5;
      label374: int n;
      if (this.language == 'E')
      {
        str4 = "[";
        str5 = "]";
        if (!(paramConsumer instanceof OutPort))
          break label486;
        ((OutPort)paramConsumer).startLogicalBlock(str4, false, str5);
        n = localSimpleVector.size() << 1;
      }
      for (int i1 = 0; ; i1 += 2)
        if (i1 < n)
        {
          if ((i1 > 0) && ((paramConsumer instanceof OutPort)))
            ((OutPort)paramConsumer).writeSpaceFill();
          if (localSimpleVector.consumeNext(i1, paramConsumer));
        }
        else
        {
          if (!(paramConsumer instanceof OutPort))
            break label502;
          ((OutPort)paramConsumer).endLogicalBlock(str5);
          return;
          if (str3 == null);
          for (str4 = "#("; ; str4 = "#" + str3 + "(")
          {
            str5 = ")";
            break;
          }
          label486: write(str4, paramConsumer);
          break label374;
        }
      label502: write(str5, paramConsumer);
      return;
    }
    if ((paramObject instanceof gnu.lists.Array))
    {
      write((gnu.lists.Array)paramObject, 0, 0, paramConsumer);
      return;
    }
    if ((paramObject instanceof KNode))
    {
      if (getReadableOutput())
        write("#", paramConsumer);
      if ((paramConsumer instanceof Writer));
      ConsumerWriter localConsumerWriter;
      for (Object localObject3 = (Writer)paramConsumer; ; localObject3 = localConsumerWriter)
      {
        XMLPrinter localXMLPrinter = new XMLPrinter((Writer)localObject3);
        localXMLPrinter.writeObject(paramObject);
        localXMLPrinter.closeThis();
        return;
        localConsumerWriter = new ConsumerWriter(paramConsumer);
      }
    }
    if ((paramObject == Values.empty) && (getReadableOutput()))
    {
      write("#!void", paramConsumer);
      return;
    }
    if ((paramObject instanceof Consumable))
    {
      ((Consumable)paramObject).consume(paramConsumer);
      return;
    }
    if ((paramObject instanceof Printable))
    {
      ((Printable)paramObject).print(paramConsumer);
      return;
    }
    if ((paramObject instanceof RatNum))
    {
      int k = 10;
      Object localObject1 = outBase.get(null);
      Object localObject2 = outRadix.get(null);
      int m = 0;
      if (localObject2 != null)
        if (localObject2 != Boolean.TRUE)
        {
          boolean bool = "yes".equals(localObject2.toString());
          m = 0;
          if (!bool);
        }
        else
        {
          m = 1;
        }
      label750: String str2;
      if ((localObject1 instanceof Number))
      {
        k = ((IntNum)localObject1).intValue();
        str2 = ((RatNum)paramObject).toString(k);
        if (m != 0)
        {
          if (k != 16)
            break label834;
          write("#x", paramConsumer);
        }
      }
      while (true)
      {
        write(str2, paramConsumer);
        if ((m == 0) || (k != 10) || (!(paramObject instanceof IntNum)))
          break;
        write(".", paramConsumer);
        return;
        if (localObject1 == null)
          break label750;
        k = Integer.parseInt(localObject1.toString());
        break label750;
        label834: if (k == 8)
          write("#o", paramConsumer);
        else if (k == 2)
          write("#b", paramConsumer);
        else if ((k != 10) || (!(paramObject instanceof IntNum)))
          write("#" + localObject1 + "r", paramConsumer);
      }
    }
    if (((paramObject instanceof Enum)) && (getReadableOutput()))
    {
      write(paramObject.getClass().getName(), paramConsumer);
      write(":", paramConsumer);
      write(((Enum)paramObject).name(), paramConsumer);
      return;
    }
    if (paramObject == null);
    for (String str1 = null; str1 == null; str1 = paramObject.toString())
    {
      write("#!null", paramConsumer);
      return;
      if (paramObject.getClass().isArray())
      {
        int i = java.lang.reflect.Array.getLength(paramObject);
        if ((paramConsumer instanceof OutPort))
          ((OutPort)paramConsumer).startLogicalBlock("[", false, "]");
        while (true)
        {
          for (int j = 0; j < i; j++)
          {
            if (j > 0)
            {
              write(" ", paramConsumer);
              if ((paramConsumer instanceof OutPort))
                ((OutPort)paramConsumer).writeBreakFill();
            }
            writeObject(java.lang.reflect.Array.get(paramObject, j), paramConsumer);
          }
          write("[", paramConsumer);
        }
        if ((paramConsumer instanceof OutPort))
        {
          ((OutPort)paramConsumer).endLogicalBlock("]");
          return;
        }
        write("]", paramConsumer);
        return;
      }
    }
    write(str1, paramConsumer);
  }

  void writeSymbol(Symbol paramSymbol, Consumer paramConsumer, boolean paramBoolean)
  {
    String str1 = paramSymbol.getPrefix();
    Namespace localNamespace = paramSymbol.getNamespace();
    String str2;
    int i;
    label36: int j;
    label52: int k;
    if (localNamespace == null)
    {
      str2 = null;
      if ((str2 == null) || (str2.length() <= 0))
        break label123;
      i = 1;
      if ((str1 == null) || (str1.length() <= 0))
        break label129;
      j = 1;
      k = 0;
      if (localNamespace != Keyword.keywordNamespace)
        break label141;
      if ((this.language != 'C') && (this.language != 'E'))
        break label135;
      paramConsumer.write(58);
    }
    while (true)
    {
      writeSymbol(paramSymbol.getName(), paramConsumer, paramBoolean);
      if (k != 0)
        paramConsumer.write(58);
      return;
      str2 = localNamespace.getName();
      break;
      label123: i = 0;
      break label36;
      label129: j = 0;
      break label52;
      label135: k = 1;
      continue;
      label141: if (j == 0)
      {
        k = 0;
        if (i == 0);
      }
      else
      {
        if (j != 0)
          writeSymbol(str1, paramConsumer, paramBoolean);
        if ((i != 0) && ((paramBoolean) || (j == 0)))
        {
          paramConsumer.write(123);
          paramConsumer.write(str2);
          paramConsumer.write(125);
        }
        paramConsumer.write(58);
        k = 0;
      }
    }
  }

  void writeSymbol(String paramString, Consumer paramConsumer, boolean paramBoolean)
  {
    if ((paramBoolean) && (!r5rsIdentifierMinusInteriorColons.matcher(paramString).matches()))
    {
      int i = paramString.length();
      if (i == 0)
        write("||", paramConsumer);
      int j;
      label75: 
      do
      {
        return;
        j = 0;
        int k = 0;
        if (k < i)
        {
          int m = paramString.charAt(k);
          String str;
          if (m == 124)
            if (j != 0)
            {
              str = "|\\";
              write(str, paramConsumer);
              j = 0;
            }
          while (true)
          {
            paramConsumer.write(m);
            k++;
            break;
            str = "\\";
            break label75;
            if (j == 0)
            {
              paramConsumer.write(124);
              j = 1;
            }
          }
        }
      }
      while (j == 0);
      paramConsumer.write(124);
      return;
    }
    write(paramString, paramConsumer);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.DisplayFormat
 * JD-Core Version:    0.6.2
 */