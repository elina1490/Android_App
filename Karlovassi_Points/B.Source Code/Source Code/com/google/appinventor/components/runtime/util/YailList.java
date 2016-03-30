package com.google.appinventor.components.runtime.util;

import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import gnu.lists.LList;
import gnu.lists.Pair;
import java.util.Collection;
import java.util.List;
import org.json.JSONException;

public class YailList extends Pair
{
  public YailList()
  {
    super(YailConstants.YAIL_HEADER, LList.Empty);
  }

  private YailList(Object paramObject)
  {
    super(YailConstants.YAIL_HEADER, paramObject);
  }

  public static YailList makeList(Collection paramCollection)
  {
    return new YailList(Pair.makeList(paramCollection.toArray(), 0));
  }

  public static YailList makeList(List paramList)
  {
    return new YailList(Pair.makeList(paramList));
  }

  public static YailList makeList(Object[] paramArrayOfObject)
  {
    return new YailList(Pair.makeList(paramArrayOfObject, 0));
  }

  public Object getObject(int paramInt)
  {
    return get(paramInt + 1);
  }

  public String getString(int paramInt)
  {
    return (String)get(paramInt + 1);
  }

  public int size()
  {
    return super.size() - 1;
  }

  public Object[] toArray()
  {
    if ((this.cdr instanceof Pair))
      return ((Pair)this.cdr).toArray();
    if ((this.cdr instanceof LList))
      return ((LList)this.cdr).toArray();
    throw new YailRuntimeError("YailList cannot be represented as an array", "YailList Error.");
  }

  public String toJSONString()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str1 = "";
      localStringBuilder.append('[');
      int i = size();
      for (int j = 1; j <= i; j++)
      {
        Object localObject = get(j);
        localStringBuilder.append(str1).append(JsonUtil.getJsonRepresentation(localObject));
        str1 = ",";
      }
      localStringBuilder.append(']');
      String str2 = localStringBuilder.toString();
      return str2;
    }
    catch (JSONException localJSONException)
    {
    }
    throw new YailRuntimeError("List failed to convert to JSON.", "JSON Creation Error.");
  }

  public String toString()
  {
    if ((this.cdr instanceof Pair))
      return ((Pair)this.cdr).toString();
    if ((this.cdr instanceof LList))
      return ((LList)this.cdr).toString();
    throw new RuntimeException("YailList cannot be represented as a String");
  }

  public String[] toStringArray()
  {
    int i = size();
    String[] arrayOfString = new String[i];
    for (int j = 1; j <= i; j++)
      arrayOfString[(j - 1)] = String.valueOf(get(j));
    return arrayOfString;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.YailList
 * JD-Core Version:    0.6.2
 */