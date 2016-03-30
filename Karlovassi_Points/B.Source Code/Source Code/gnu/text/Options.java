package gnu.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class Options
{
  public static final int BOOLEAN_OPTION = 1;
  public static final int STRING_OPTION = 2;
  public static final String UNKNOWN = "unknown option name";
  OptionInfo first;
  HashMap<String, OptionInfo> infoTable;
  OptionInfo last;
  Options previous;
  HashMap<String, Object> valueTable;

  public Options()
  {
  }

  public Options(Options paramOptions)
  {
    this.previous = paramOptions;
  }

  private void error(String paramString, SourceMessages paramSourceMessages)
  {
    if (paramSourceMessages == null)
      throw new RuntimeException(paramString);
    paramSourceMessages.error('e', paramString);
  }

  static Object valueOf(OptionInfo paramOptionInfo, String paramString)
  {
    if ((0x1 & paramOptionInfo.kind) != 0)
    {
      if ((paramString == null) || (paramString.equals("1")) || (paramString.equals("on")) || (paramString.equals("yes")) || (paramString.equals("true")))
        return Boolean.TRUE;
      if ((paramString.equals("0")) || (paramString.equals("off")) || (paramString.equals("no")) || (paramString.equals("false")))
        return Boolean.FALSE;
      return null;
    }
    return paramString;
  }

  public OptionInfo add(String paramString1, int paramInt, Object paramObject, String paramString2)
  {
    OptionInfo localOptionInfo;
    if (this.infoTable == null)
    {
      this.infoTable = new HashMap();
      localOptionInfo = new OptionInfo();
      localOptionInfo.key = paramString1;
      localOptionInfo.kind = paramInt;
      localOptionInfo.defaultValue = paramObject;
      localOptionInfo.documentation = paramString2;
      if (this.first != null)
        break label123;
      this.first = localOptionInfo;
    }
    while (true)
    {
      this.last = localOptionInfo;
      this.infoTable.put(paramString1, localOptionInfo);
      return localOptionInfo;
      if (this.infoTable.get(paramString1) == null)
        break;
      throw new RuntimeException("duplicate option key: " + paramString1);
      label123: this.last.next = localOptionInfo;
    }
  }

  public OptionInfo add(String paramString1, int paramInt, String paramString2)
  {
    return add(paramString1, paramInt, null, paramString2);
  }

  public Object get(OptionInfo paramOptionInfo)
  {
    return get(paramOptionInfo, null);
  }

  public Object get(OptionInfo paramOptionInfo, Object paramObject)
  {
    for (Options localOptions = this; localOptions != null; localOptions = localOptions.previous)
    {
      for (OptionInfo localOptionInfo = paramOptionInfo; ; localOptionInfo = (OptionInfo)localOptionInfo.defaultValue)
      {
        if (localOptions.valueTable == null);
        for (Object localObject = null; localObject != null; localObject = localOptions.valueTable.get(localOptionInfo.key))
          return localObject;
        if (!(localOptionInfo.defaultValue instanceof OptionInfo))
          break;
      }
      if (localOptionInfo.defaultValue != null)
        paramObject = localOptionInfo.defaultValue;
    }
    return paramObject;
  }

  public Object get(String paramString, Object paramObject)
  {
    OptionInfo localOptionInfo = getInfo(paramString);
    if (localOptionInfo == null)
      throw new RuntimeException("invalid option key: " + paramString);
    return get(localOptionInfo, paramObject);
  }

  public boolean getBoolean(OptionInfo paramOptionInfo)
  {
    Object localObject = get(paramOptionInfo, null);
    if (localObject == null)
      return false;
    return ((Boolean)localObject).booleanValue();
  }

  public boolean getBoolean(OptionInfo paramOptionInfo, boolean paramBoolean)
  {
    if (paramBoolean);
    for (Boolean localBoolean = Boolean.TRUE; ; localBoolean = Boolean.FALSE)
      return ((Boolean)get(paramOptionInfo, localBoolean)).booleanValue();
  }

  public boolean getBoolean(String paramString)
  {
    return ((Boolean)get(paramString, Boolean.FALSE)).booleanValue();
  }

  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    if (paramBoolean);
    for (Boolean localBoolean = Boolean.TRUE; ; localBoolean = Boolean.FALSE)
      return ((Boolean)get(paramString, localBoolean)).booleanValue();
  }

  public String getDoc(String paramString)
  {
    OptionInfo localOptionInfo = getInfo(paramString);
    if (paramString == null)
      return null;
    return localOptionInfo.documentation;
  }

  public OptionInfo getInfo(String paramString)
  {
    if (this.infoTable == null);
    for (OptionInfo localOptionInfo = null; ; localOptionInfo = (OptionInfo)this.infoTable.get(paramString))
    {
      if ((localOptionInfo == null) && (this.previous != null))
        localOptionInfo = this.previous.getInfo(paramString);
      return (OptionInfo)localOptionInfo;
    }
  }

  public Object getLocal(String paramString)
  {
    if (this.valueTable == null)
      return null;
    return this.valueTable.get(paramString);
  }

  public ArrayList<String> keys()
  {
    ArrayList localArrayList = new ArrayList();
    for (Options localOptions = this; localOptions != null; localOptions = localOptions.previous)
      if (localOptions.infoTable != null)
      {
        Iterator localIterator = localOptions.infoTable.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!localArrayList.contains(str))
            localArrayList.add(str);
        }
      }
    return localArrayList;
  }

  public void popOptionValues(Vector paramVector)
  {
    int i = paramVector.size();
    while (true)
    {
      i -= 3;
      if (i < 0)
        break;
      String str = (String)paramVector.elementAt(i);
      Object localObject = paramVector.elementAt(i + 1);
      paramVector.setElementAt(null, i + 1);
      reset(str, localObject);
    }
  }

  public void pushOptionValues(Vector paramVector)
  {
    int i = paramVector.size();
    int n;
    for (int j = 0; j < i; j = n)
    {
      int k = j + 1;
      String str = (String)paramVector.elementAt(j);
      Object localObject = paramVector.elementAt(k);
      int m = k + 1;
      paramVector.setElementAt(localObject, k);
      n = m + 1;
      set(str, paramVector.elementAt(m));
    }
  }

  public void reset(String paramString, Object paramObject)
  {
    if (this.valueTable == null)
      this.valueTable = new HashMap();
    if (paramObject == null)
    {
      this.valueTable.remove(paramString);
      return;
    }
    this.valueTable.put(paramString, paramObject);
  }

  public String set(String paramString1, String paramString2)
  {
    OptionInfo localOptionInfo = getInfo(paramString1);
    if (localOptionInfo == null)
      return "unknown option name";
    Object localObject = valueOf(localOptionInfo, paramString2);
    if ((localObject == null) && ((0x1 & localOptionInfo.kind) != 0))
      return "value of option " + paramString1 + " must be yes/no/true/false/on/off/1/0";
    if (this.valueTable == null)
      this.valueTable = new HashMap();
    this.valueTable.put(paramString1, localObject);
    return null;
  }

  public void set(String paramString, Object paramObject)
  {
    set(paramString, paramObject, null);
  }

  public void set(String paramString, Object paramObject, SourceMessages paramSourceMessages)
  {
    OptionInfo localOptionInfo = getInfo(paramString);
    if (localOptionInfo == null)
    {
      error("invalid option key: " + paramString, paramSourceMessages);
      return;
    }
    if ((0x1 & localOptionInfo.kind) != 0)
    {
      if ((paramObject instanceof String))
        paramObject = valueOf(localOptionInfo, (String)paramObject);
      if (!(paramObject instanceof Boolean))
        error("value for option " + paramString + " must be boolean or yes/no/true/false/on/off/1/0", paramSourceMessages);
    }
    else if (paramObject == null)
    {
      paramObject = "";
    }
    if (this.valueTable == null)
      this.valueTable = new HashMap();
    this.valueTable.put(paramString, paramObject);
  }

  public static final class OptionInfo
  {
    Object defaultValue;
    String documentation;
    String key;
    int kind;
    OptionInfo next;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.Options
 * JD-Core Version:    0.6.2
 */