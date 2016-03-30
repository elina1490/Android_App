package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;
import java.util.List;

class SetList extends Procedure2
{
  Type elementType;
  List list;

  public SetList(List paramList)
  {
    this.list = paramList;
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    this.list.set(((Number)paramObject1).intValue(), paramObject2);
    return Values.empty;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.SetList
 * JD-Core Version:    0.6.2
 */