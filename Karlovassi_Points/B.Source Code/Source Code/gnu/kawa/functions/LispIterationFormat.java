package gnu.kawa.functions;

import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;

class LispIterationFormat extends ReportFormat
{
  boolean atLeastOnce;
  Format body;
  int maxIterations;
  boolean seenAt;
  boolean seenColon;

  public static int format(Format paramFormat, int paramInt1, Object[] paramArrayOfObject, int paramInt2, Writer paramWriter, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    int i = 0;
    if ((i == paramInt1) && (paramInt1 != -1));
    int j;
    do
    {
      do
        return paramInt2;
      while ((paramInt2 == paramArrayOfObject.length) && ((i > 0) || (!paramBoolean2)));
      if (!paramBoolean1)
        break;
      Object[] arrayOfObject = LispFormat.asArray(paramArrayOfObject[paramInt2]);
      if (arrayOfObject == null);
      j = ReportFormat.format(paramFormat, arrayOfObject, 0, paramWriter, null);
      paramInt2++;
    }
    while (ReportFormat.resultCode(j) == 242);
    do
    {
      i++;
      break;
      paramInt2 = ReportFormat.format(paramFormat, paramArrayOfObject, paramInt2, paramWriter, null);
    }
    while (paramInt2 >= 0);
    return ReportFormat.nextArg(paramInt2);
  }

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    int i = getParam(this.maxIterations, -1, paramArrayOfObject, paramInt);
    if (this.maxIterations == -1610612736)
      paramInt++;
    Object localObject1 = this.body;
    int j;
    Object localObject3;
    if (localObject1 == null)
    {
      j = paramInt + 1;
      localObject3 = paramArrayOfObject[paramInt];
      if (!(localObject3 instanceof Format))
        break label97;
      localObject1 = (Format)localObject3;
      paramInt = j;
    }
    while (this.seenAt)
    {
      boolean bool1 = this.seenColon;
      boolean bool2 = this.atLeastOnce;
      return format((Format)localObject1, i, paramArrayOfObject, paramInt, paramWriter, bool1, bool2);
      try
      {
        label97: LispFormat localLispFormat = new LispFormat(localObject3.toString());
        localObject1 = localLispFormat;
        paramInt = j;
      }
      catch (Exception localException)
      {
        print(paramWriter, "<invalid argument for \"~{~}\" format>");
        return paramArrayOfObject.length;
      }
    }
    Object localObject2 = paramArrayOfObject[paramInt];
    Object[] arrayOfObject = LispFormat.asArray(localObject2);
    if (arrayOfObject == null)
      paramWriter.write("{" + localObject2 + "}".toString());
    while (true)
    {
      return paramInt + 1;
      format((Format)localObject1, i, arrayOfObject, 0, paramWriter, this.seenColon, this.atLeastOnce);
    }
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("LispIterationFormat[");
    localStringBuffer.append(this.body);
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.LispIterationFormat
 * JD-Core Version:    0.6.2
 */