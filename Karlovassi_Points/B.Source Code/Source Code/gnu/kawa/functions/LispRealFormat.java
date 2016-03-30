package gnu.kawa.functions;

import gnu.math.ExponentialFormat;
import gnu.math.FixedRealFormat;
import gnu.math.RealNum;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;

class LispRealFormat extends ReportFormat
{
  int arg1;
  int arg2;
  int arg3;
  int arg4;
  int arg5;
  int arg6;
  int arg7;
  int argsUsed;
  boolean internalPad;
  char op;
  boolean showPlus;

  LispRealFormat()
  {
    if ((this.arg1 == -1342177280) || (this.arg2 == -1342177280) || (this.arg3 == -1342177280) || (this.arg4 == -1342177280) || (this.arg5 == -1342177280) || (this.arg6 == -1342177280) || (this.arg7 == -1342177280));
    for (int i = 1; ; i = 0)
    {
      this.argsUsed = i;
      if (this.arg1 == -1610612736)
        this.argsUsed = (2 + this.argsUsed);
      if (this.arg2 == -1610612736)
        this.argsUsed = (2 + this.argsUsed);
      if (this.arg3 == -1610612736)
        this.argsUsed = (2 + this.argsUsed);
      if (this.arg4 == -1610612736)
        this.argsUsed = (2 + this.argsUsed);
      if (this.arg5 == -1610612736)
        this.argsUsed = (2 + this.argsUsed);
      if (this.arg6 == -1610612736)
        this.argsUsed = (2 + this.argsUsed);
      if (this.arg7 == -1610612736)
        this.argsUsed = (2 + this.argsUsed);
      return;
    }
  }

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    Format localFormat = resolve(paramArrayOfObject, paramInt);
    int i = paramInt + (this.argsUsed >> 1);
    int j = i + 1;
    localFormat.format((RealNum)paramArrayOfObject[i], localStringBuffer, paramFieldPosition);
    paramWriter.write(localStringBuffer.toString());
    return j;
  }

  public Format resolve(Object[] paramArrayOfObject, int paramInt)
  {
    if (this.op == '$')
    {
      FixedRealFormat localFixedRealFormat1 = new FixedRealFormat();
      int i = getParam(this.arg1, 2, paramArrayOfObject, paramInt);
      if (this.arg1 == -1610612736)
        paramInt++;
      int j = getParam(this.arg2, 1, paramArrayOfObject, paramInt);
      if (this.arg2 == -1610612736)
        paramInt++;
      int k = getParam(this.arg3, 0, paramArrayOfObject, paramInt);
      if (this.arg3 == -1610612736)
        paramInt++;
      char c1 = getParam(this.arg4, ' ', paramArrayOfObject, paramInt);
      if (this.arg4 == -1610612736)
        (paramInt + 1);
      localFixedRealFormat1.setMaximumFractionDigits(i);
      localFixedRealFormat1.setMinimumIntegerDigits(j);
      localFixedRealFormat1.width = k;
      localFixedRealFormat1.padChar = c1;
      localFixedRealFormat1.internalPad = this.internalPad;
      localFixedRealFormat1.showPlus = this.showPlus;
      return localFixedRealFormat1;
    }
    if (this.op == 'F')
    {
      FixedRealFormat localFixedRealFormat2 = new FixedRealFormat();
      int m = getParam(this.arg1, 0, paramArrayOfObject, paramInt);
      if (this.arg1 == -1610612736)
        paramInt++;
      int n = getParam(this.arg2, -1, paramArrayOfObject, paramInt);
      if (this.arg2 == -1610612736)
        paramInt++;
      int i1 = getParam(this.arg3, 0, paramArrayOfObject, paramInt);
      if (this.arg3 == -1610612736)
        paramInt++;
      localFixedRealFormat2.overflowChar = getParam(this.arg4, '\000', paramArrayOfObject, paramInt);
      if (this.arg4 == -1610612736)
        paramInt++;
      char c2 = getParam(this.arg5, ' ', paramArrayOfObject, paramInt);
      if (this.arg5 == -1610612736)
        (paramInt + 1);
      localFixedRealFormat2.setMaximumFractionDigits(n);
      localFixedRealFormat2.setMinimumIntegerDigits(0);
      localFixedRealFormat2.width = m;
      localFixedRealFormat2.scale = i1;
      localFixedRealFormat2.padChar = c2;
      localFixedRealFormat2.internalPad = this.internalPad;
      localFixedRealFormat2.showPlus = this.showPlus;
      return localFixedRealFormat2;
    }
    ExponentialFormat localExponentialFormat = new ExponentialFormat();
    localExponentialFormat.exponentShowSign = true;
    localExponentialFormat.width = getParam(this.arg1, 0, paramArrayOfObject, paramInt);
    if (this.arg1 == -1610612736)
      paramInt++;
    localExponentialFormat.fracDigits = getParam(this.arg2, -1, paramArrayOfObject, paramInt);
    if (this.arg2 == -1610612736)
      paramInt++;
    localExponentialFormat.expDigits = getParam(this.arg3, 0, paramArrayOfObject, paramInt);
    if (this.arg3 == -1610612736)
      paramInt++;
    localExponentialFormat.intDigits = getParam(this.arg4, 1, paramArrayOfObject, paramInt);
    if (this.arg4 == -1610612736)
      paramInt++;
    localExponentialFormat.overflowChar = getParam(this.arg5, '\000', paramArrayOfObject, paramInt);
    if (this.arg5 == -1610612736)
      paramInt++;
    localExponentialFormat.padChar = getParam(this.arg6, ' ', paramArrayOfObject, paramInt);
    if (this.arg6 == -1610612736)
      paramInt++;
    localExponentialFormat.exponentChar = getParam(this.arg7, 'E', paramArrayOfObject, paramInt);
    if (this.arg7 == -1610612736)
      (paramInt + 1);
    if (this.op == 'G');
    for (boolean bool = true; ; bool = false)
    {
      localExponentialFormat.general = bool;
      localExponentialFormat.showPlus = this.showPlus;
      return localExponentialFormat;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.LispRealFormat
 * JD-Core Version:    0.6.2
 */