package gnu.kawa.models;

import java.io.Serializable;

public class Column extends Box
  implements Viewable, Serializable
{
  public int getAxis()
  {
    return 1;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.models.Column
 * JD-Core Version:    0.6.2
 */