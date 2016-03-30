package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class SourceFileAttr extends Attribute
{
  String filename;
  int filename_index;

  public SourceFileAttr(int paramInt, ClassType paramClassType)
  {
    super("SourceFile");
    this.filename = ((CpoolUtf8)paramClassType.constants.getForced(paramInt, 1)).string;
    this.filename_index = paramInt;
  }

  public SourceFileAttr(String paramString)
  {
    super("SourceFile");
    this.filename = paramString;
  }

  public static String fixSourceFile(String paramString)
  {
    String str = System.getProperty("file.separator", "/");
    if ((str != null) && (str.length() == 1))
    {
      char c = str.charAt(0);
      if (c != '/')
        paramString = paramString.replace(c, '/');
    }
    return paramString;
  }

  public static void setSourceFile(ClassType paramClassType, String paramString)
  {
    Attribute localAttribute = Attribute.get(paramClassType, "SourceFile");
    if ((localAttribute != null) && ((localAttribute instanceof SourceFileAttr)))
    {
      ((SourceFileAttr)localAttribute).setSourceFile(paramString);
      return;
    }
    new SourceFileAttr(paramString).addToFrontOf(paramClassType);
  }

  public void assignConstants(ClassType paramClassType)
  {
    super.assignConstants(paramClassType);
    if (this.filename_index == 0)
      this.filename_index = paramClassType.getConstants().addUtf8(this.filename).getIndex();
  }

  public final int getLength()
  {
    return 2;
  }

  public String getSourceFile()
  {
    return this.filename;
  }

  public void print(ClassTypeWriter paramClassTypeWriter)
  {
    paramClassTypeWriter.print("Attribute \"");
    paramClassTypeWriter.print(getName());
    paramClassTypeWriter.print("\", length:");
    paramClassTypeWriter.print(getLength());
    paramClassTypeWriter.print(", ");
    paramClassTypeWriter.printOptionalIndex(this.filename_index);
    paramClassTypeWriter.print('"');
    paramClassTypeWriter.print(getSourceFile());
    paramClassTypeWriter.println('"');
  }

  public void setSourceFile(String paramString)
  {
    this.filename = paramString;
    this.filename_index = 0;
  }

  public void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    paramDataOutputStream.writeShort(this.filename_index);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.SourceFileAttr
 * JD-Core Version:    0.6.2
 */