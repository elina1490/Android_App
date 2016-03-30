package gnu.kawa.functions;

import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.text.Char;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

class LispEscapeFormat extends ReportFormat
{
  public static final int ESCAPE_ALL = 242;
  public static final int ESCAPE_NORMAL = 241;
  public static final LispEscapeFormat alwaysTerminate = new LispEscapeFormat(0, -1073741824);
  boolean escapeAll;
  int param1;
  int param2;
  int param3;

  public LispEscapeFormat(int paramInt1, int paramInt2)
  {
    this.param1 = paramInt1;
    this.param2 = paramInt2;
    this.param3 = -1073741824;
  }

  public LispEscapeFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    this.param1 = paramInt1;
    this.param2 = paramInt2;
    this.param3 = paramInt3;
  }

  static Numeric getParam(int paramInt1, Object[] paramArrayOfObject, int paramInt2)
  {
    if (paramInt1 == -1342177280)
      return IntNum.make(paramArrayOfObject.length - paramInt2);
    if (paramInt1 == -1610612736)
    {
      Object localObject = paramArrayOfObject[paramInt2];
      if ((localObject instanceof Numeric))
        return (Numeric)localObject;
      if ((localObject instanceof Number))
      {
        if (((localObject instanceof Float)) || ((localObject instanceof Double)))
          return new DFloNum(((Number)localObject).doubleValue());
        return IntNum.make(((Number)localObject).longValue());
      }
      if ((localObject instanceof Char))
        return new IntNum(((Char)localObject).intValue());
      if ((localObject instanceof Character))
        return new IntNum(((Character)localObject).charValue());
      return new DFloNum((0.0D / 0.0D));
    }
    return IntNum.make(paramInt1);
  }

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    boolean bool;
    int i;
    if (this.param1 == -1073741824)
      if (paramInt == paramArrayOfObject.length)
      {
        bool = true;
        if (bool)
          break label204;
        i = 0;
      }
    while (true)
    {
      return result(i, paramInt);
      bool = false;
      break;
      if ((this.param2 == -1073741824) && (this.param1 == 0))
      {
        bool = true;
        break;
      }
      Numeric localNumeric1 = getParam(this.param1, paramArrayOfObject, paramInt);
      if (this.param1 == -1610612736)
        paramInt++;
      if (this.param2 == -1073741824)
      {
        bool = localNumeric1.isZero();
        break;
      }
      Numeric localNumeric2 = getParam(this.param2, paramArrayOfObject, paramInt);
      if (this.param2 == -1610612736)
        paramInt++;
      if (this.param3 == -1073741824)
      {
        bool = localNumeric1.equals(localNumeric2);
        break;
      }
      Numeric localNumeric3 = getParam(this.param3, paramArrayOfObject, paramInt);
      if (this.param3 == -1610612736)
        paramInt++;
      if ((localNumeric2.geq(localNumeric1)) && (localNumeric3.geq(localNumeric2)));
      for (bool = true; ; bool = false)
        break;
      label204: if (this.escapeAll)
        i = 242;
      else
        i = 241;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.LispEscapeFormat
 * JD-Core Version:    0.6.2
 */