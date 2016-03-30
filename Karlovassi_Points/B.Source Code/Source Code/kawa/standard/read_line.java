package kawa.standard;

import gnu.expr.Special;
import gnu.lists.FString;
import gnu.mapping.Values;
import gnu.text.LineBufferedReader;
import java.io.IOException;

public class read_line
{
  public static Object apply(LineBufferedReader paramLineBufferedReader, String paramString)
    throws IOException
  {
    int i = paramLineBufferedReader.read();
    if (i < 0)
    {
      Object localObject = Special.eof;
      return localObject;
    }
    int j = paramLineBufferedReader.pos - 1;
    int k = paramLineBufferedReader.limit;
    char[] arrayOfChar = paramLineBufferedReader.buffer;
    int m = -1;
    int n = j;
    int i7;
    int i8;
    if (n < k)
    {
      i7 = n + 1;
      i = arrayOfChar[n];
      if ((i == 13) || (i == 10))
      {
        i8 = i7 - 1;
        int i9;
        int i10;
        if ((paramString == "trim") || (paramString == "peek"))
        {
          if (paramString == "peek")
            m = 0;
          if (i == 10)
          {
            i9 = 1;
            paramLineBufferedReader.pos = (i8 + i9);
            i10 = i8;
          }
        }
        while (true)
        {
          FString localFString2 = new FString(arrayOfChar, j, i10 - j);
          return localFString2;
          if (i8 + 1 >= k)
            break label211;
          if (arrayOfChar[(i8 + 1)] == '\n');
          for (i9 = 2; ; i9 = 1)
            break;
          if ((paramString != "concat") || (i != 10))
            break label211;
          i10 = i8 + 1;
          paramLineBufferedReader.pos = i10;
        }
      }
    }
    label211: for (int i1 = i8; ; i1 = n)
    {
      StringBuffer localStringBuffer = new StringBuffer(100);
      if (i1 > j)
        localStringBuffer.append(arrayOfChar, j, i1 - j);
      paramLineBufferedReader.pos = i1;
      char c;
      int i2;
      int i4;
      int i3;
      if (paramString == "peek")
      {
        c = 'P';
        paramLineBufferedReader.readLine(localStringBuffer, c);
        i2 = localStringBuffer.length();
        if (paramString != "split")
          break label467;
        if (i2 != 0)
          break label382;
        i4 = i2;
        i3 = 0;
      }
      while (true)
      {
        FString localFString1 = new FString(localStringBuffer, 0, i4);
        if (paramString == "split")
        {
          Values localValues = new Values(new Object[] { localFString1, new FString(localStringBuffer, i4 - i3, i3) });
          return localValues;
          if ((paramString == "concat") || (paramString == "split"))
          {
            c = 'A';
            break;
          }
          c = 'I';
          break;
          label382: int i5 = localStringBuffer.charAt(i2 - 1);
          int i6;
          if (i5 == 13)
            i6 = 1;
          while (true)
          {
            i4 = i2 - i6;
            i3 = i6;
            break;
            if (i5 != 10)
              i6 = 0;
            else if ((i5 > 2) && (localStringBuffer.charAt(i2 - 2) == '\r'))
              i6 = 2;
            else
              i6 = 1;
          }
        }
        return localFString1;
        label467: i3 = m;
        i4 = i2;
      }
      n = i7;
      break;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.read_line
 * JD-Core Version:    0.6.2
 */