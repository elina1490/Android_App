package gnu.q2.lang;

import gnu.expr.Keyword;
import gnu.expr.QuoteExp;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.xml.MakeAttribute;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.Sequence;
import gnu.mapping.InPort;
import gnu.text.LineBufferedReader;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import kawa.standard.begin;

public class Q2Read extends LispReader
{
  int curIndentation;
  int expressionStartColumn;
  String expressionStartFile;
  int expressionStartLine;

  public Q2Read(InPort paramInPort)
  {
    super(paramInPort);
    init();
  }

  public Q2Read(InPort paramInPort, SourceMessages paramSourceMessages)
  {
    super(paramInPort, paramSourceMessages);
    init();
  }

  public static Object readObject(InPort paramInPort)
    throws IOException, SyntaxException
  {
    return new Q2Read(paramInPort).readObject();
  }

  void init()
  {
    ((InPort)this.port).readState = ' ';
  }

  public Object readCommand()
    throws IOException, SyntaxException
  {
    int i = skipIndentation();
    if (i < 0)
      return Sequence.eofValue;
    this.curIndentation = i;
    Object localObject = readIndentCommand();
    if (!this.interactive)
      this.port.reset();
    return localObject;
  }

  public Object readCommand(boolean paramBoolean)
    throws IOException, SyntaxException
  {
    this.port.getLineNumber();
    int i = this.port.getColumnNumber();
    int j = i;
    LList localLList1 = LList.Empty;
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = localLList1;
    int k = read();
    if (k < 0)
      label45: if (!paramBoolean)
      {
        if (localObject3 != localObject2)
          break label517;
        localObject3 = ((PairWithPosition)localObject2).getCar();
      }
    label161: label190: 
    while (localObject2 != null)
    {
      return localObject3;
      if ((k == 32) || (k == 9))
        break;
      unread();
      if (k == 41)
        break label45;
      int m = this.port.getLineNumber();
      int n = this.port.getColumnNumber();
      do
      {
        if ((k != 13) && (k != 10))
          break label161;
        if (singleLine())
          break;
        read();
        skipIndentation();
        n = this.port.getColumnNumber();
        k = peek();
      }
      while (n > i);
      if ((n <= i) && (localObject2 != null))
        break label45;
      Object localObject4;
      PairWithPosition localPairWithPosition1;
      if ((n == j) && (localObject2 != null))
      {
        localObject4 = readCommand();
        Object localObject5 = Sequence.eofValue;
        if (localObject4 == localObject5)
          break label45;
        j = n;
        String str = this.port.getName();
        LList localLList2 = LList.Empty;
        int i1 = m + 1;
        int i2 = n + 1;
        localPairWithPosition1 = PairWithPosition.make(localObject4, localLList2, str, i1, i2);
        if (localObject2 != null)
          break label431;
        localObject1 = localPairWithPosition1;
        localObject3 = localPairWithPosition1;
      }
      while (true)
      {
        localObject2 = localPairWithPosition1;
        break;
        if ((n < j) && (localObject2 != null))
        {
          Object localObject6 = localObject1;
          while (true)
          {
            Object localObject7 = ((PairWithPosition)localObject6).getCdr();
            if (localObject7 == LList.Empty);
            PairWithPosition localPairWithPosition4;
            while (true)
            {
              localObject4 = readCommand();
              break;
              localPairWithPosition4 = (PairWithPosition)localObject7;
              int i3 = localPairWithPosition4.getColumnNumber() - 1;
              if (i3 < n)
                break label415;
              if (i3 > n)
                error('e', "some tokens on previous line indented more than current line");
              Object localObject8 = localPairWithPosition4.getCdr();
              if (localObject8 != LList.Empty)
              {
                if (((PairWithPosition)localObject8).getColumnNumber() - 1 == n)
                {
                  localObject6 = (PairWithPosition)localObject8;
                  break label283;
                }
                localObject2 = (PairWithPosition)makePair(localPairWithPosition4, this.port.getLineNumber(), n);
                ((PairWithPosition)localObject6).setCdrBackdoor(localObject2);
              }
            }
            localObject6 = localPairWithPosition4;
          }
        }
        localObject4 = readObject();
        break label190;
        if ((((PairWithPosition)localObject2).getCar() instanceof Keyword))
        {
          QuoteExp localQuoteExp = new QuoteExp(((Keyword)((PairWithPosition)localObject2).getCar()).getName());
          MakeAttribute localMakeAttribute = MakeAttribute.makeAttribute;
          PairWithPosition localPairWithPosition2 = new PairWithPosition((SourceLocator)localObject2, localQuoteExp, localPairWithPosition1);
          PairWithPosition localPairWithPosition3 = new PairWithPosition((SourceLocator)localObject2, localMakeAttribute, localPairWithPosition2);
          ((PairWithPosition)localObject2).setCar(localPairWithPosition3);
          break;
        }
        ((PairWithPosition)localObject2).setCdrBackdoor(localPairWithPosition1);
      }
    }
    label283: label415: label431: return QuoteExp.voidExp;
  }

  Object readIndentCommand()
    throws IOException, SyntaxException
  {
    int i = this.curIndentation;
    label215: int i2;
    label257: int i3;
    for (Object localObject1 = LList.Empty; ; localObject1 = makePair(readObject(), localObject1, i2, i3))
    {
      int j = read();
      if (j < 0);
      do
      {
        do
        {
          return LList.reverseInPlace(localObject1);
          if ((j == 32) || (j == 9))
            break;
          unread();
        }
        while (j == 41);
        if ((j != 13) && (j != 10))
          break label257;
      }
      while (singleLine());
      read();
      this.port.mark(2147483647);
      int k = skipIndentation();
      Object localObject2 = LList.Empty;
      this.curIndentation = k;
      while (true)
      {
        if (this.curIndentation == -1);
        int m;
        do
          while (true)
          {
            LList localLList = LList.Empty;
            if (localObject2 == localLList)
              break;
            Pair localPair = new Pair(begin.begin, LList.reverseInPlace(localObject2));
            localObject1 = new Pair(localPair, localObject1);
            break;
            if (k == this.curIndentation)
            {
              m = Q2.compareIndentation(k, i);
              if (m == -2147483648)
              {
                error('e', "cannot compare indentation - mix of tabs and spaces");
              }
              else
              {
                if ((m != -1) && (m != 1))
                  break label215;
                error('e', "indentation must differ by 2 or more");
              }
            }
          }
        while (m <= 0);
        int n = this.port.getLineNumber();
        int i1 = this.port.getColumnNumber();
        localObject2 = makePair(readIndentCommand(), localObject2, n, i1);
      }
      i2 = this.port.getLineNumber();
      i3 = this.port.getColumnNumber();
    }
  }

  void saveExpressionStartPosition()
  {
    this.expressionStartFile = this.port.getName();
    this.expressionStartLine = this.port.getLineNumber();
    this.expressionStartColumn = this.port.getColumnNumber();
  }

  boolean singleLine()
  {
    return (this.interactive) && (this.nesting == 0);
  }

  int skipIndentation()
    throws IOException, SyntaxException
  {
    int i = 0;
    int k;
    for (int j = this.port.read(); ; j = this.port.read())
    {
      k = 0;
      if (j != 9)
        break;
      i++;
    }
    while (j == 32)
    {
      k++;
      j = this.port.read();
    }
    if (j < 0)
      return -1;
    this.port.unread();
    return k + (i << 16);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.q2.lang.Q2Read
 * JD-Core Version:    0.6.2
 */