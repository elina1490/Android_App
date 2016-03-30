package com.google.appinventor.components.runtime.util;

import gnu.lists.FString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonUtil
{
  public static Object convertJsonItem(Object paramObject)
    throws JSONException
  {
    if (paramObject == null)
      return "null";
    if ((paramObject instanceof JSONObject))
      return getListFromJsonObject((JSONObject)paramObject);
    if ((paramObject instanceof JSONArray))
      return getListFromJsonArray((JSONArray)paramObject);
    if ((paramObject.equals(Boolean.FALSE)) || (((paramObject instanceof String)) && (((String)paramObject).equalsIgnoreCase("false"))))
      return Boolean.valueOf(false);
    if ((paramObject.equals(Boolean.TRUE)) || (((paramObject instanceof String)) && (((String)paramObject).equalsIgnoreCase("true"))))
      return Boolean.valueOf(true);
    if ((paramObject instanceof Number))
      return paramObject;
    return paramObject.toString();
  }

  public static String getJsonRepresentation(Object paramObject)
    throws JSONException
  {
    if ((paramObject == null) || (paramObject.equals(null)))
      return "null";
    if ((paramObject instanceof FString))
      return JSONObject.quote(paramObject.toString());
    if ((paramObject instanceof YailList))
      return ((YailList)paramObject).toJSONString();
    if ((paramObject instanceof Number))
      return JSONObject.numberToString((Number)paramObject);
    if ((paramObject instanceof Boolean))
      return paramObject.toString();
    if (paramObject.getClass().isArray())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      String str = "";
      for (Object localObject : (Object[])paramObject)
      {
        localStringBuilder.append(str).append(getJsonRepresentation(localObject));
        str = ",";
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    return JSONObject.quote(paramObject.toString());
  }

  public static List<Object> getListFromJsonArray(JSONArray paramJSONArray)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramJSONArray.length(); i++)
      localArrayList.add(convertJsonItem(paramJSONArray.get(i)));
    return localArrayList;
  }

  public static List<Object> getListFromJsonObject(JSONObject paramJSONObject)
    throws JSONException
  {
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator1 = paramJSONObject.keys();
    ArrayList localArrayList2 = new ArrayList();
    while (localIterator1.hasNext())
      localArrayList2.add(localIterator1.next());
    Collections.sort(localArrayList2);
    Iterator localIterator2 = localArrayList2.iterator();
    while (localIterator2.hasNext())
    {
      String str = (String)localIterator2.next();
      ArrayList localArrayList3 = new ArrayList();
      localArrayList3.add(str);
      localArrayList3.add(convertJsonItem(paramJSONObject.get(str)));
      localArrayList1.add(localArrayList3);
    }
    return localArrayList1;
  }

  public static Object getObjectFromJson(String paramString)
    throws JSONException
  {
    if ((paramString == null) || (paramString.equals("")))
      return "";
    Object localObject = new JSONTokener(paramString).nextValue();
    if ((localObject == null) || (localObject.equals(null)))
      return null;
    if (((localObject instanceof String)) || ((localObject instanceof Number)) || ((localObject instanceof Boolean)))
      return localObject;
    if ((localObject instanceof JSONArray))
      return getListFromJsonArray((JSONArray)localObject);
    if ((localObject instanceof JSONObject))
      return getListFromJsonObject((JSONObject)localObject);
    throw new JSONException("Invalid JSON string.");
  }

  public static List<String> getStringListFromJsonArray(JSONArray paramJSONArray)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramJSONArray.length(); i++)
      localArrayList.add(paramJSONArray.getString(i));
    return localArrayList;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.JsonUtil
 * JD-Core Version:    0.6.2
 */