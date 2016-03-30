package gnu.bytecode;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class AnnotationEntry
  implements Annotation
{
  ClassType annotationType;
  LinkedHashMap<String, Object> elementsValue = new LinkedHashMap(10);

  public void addMember(String paramString, Object paramObject)
  {
    this.elementsValue.put(paramString, paramObject);
  }

  public Class<? extends Annotation> annotationType()
  {
    return this.annotationType.getReflectClass();
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AnnotationEntry))
      return false;
    AnnotationEntry localAnnotationEntry = (AnnotationEntry)paramObject;
    if (!getAnnotationType().getName().equals(localAnnotationEntry.getAnnotationType().getName()))
      return false;
    Iterator localIterator1 = this.elementsValue.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
      String str2 = (String)localEntry2.getKey();
      Object localObject3 = localEntry2.getValue();
      Object localObject4 = localAnnotationEntry.elementsValue.get(str2);
      if ((localObject3 != localObject4) && ((localObject3 == null) || (localObject4 == null) || (!localObject3.equals(localObject4))))
        return false;
    }
    Iterator localIterator2 = localAnnotationEntry.elementsValue.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
      String str1 = (String)localEntry1.getKey();
      Object localObject1 = localEntry1.getValue();
      Object localObject2 = this.elementsValue.get(str1);
      if ((localObject2 != localObject1) && ((localObject2 == null) || (localObject1 == null) || (!localObject2.equals(localObject1))))
        return false;
    }
    return true;
  }

  public ClassType getAnnotationType()
  {
    return this.annotationType;
  }

  public int hashCode()
  {
    int i = 0;
    Iterator localIterator = this.elementsValue.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      int j = ((String)localEntry.getKey()).hashCode();
      i += (localEntry.getValue().hashCode() ^ j * 127);
    }
    return i;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('@');
    localStringBuilder.append(getAnnotationType().getName());
    localStringBuilder.append('(');
    int i = 0;
    Iterator localIterator = this.elementsValue.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (i > 0)
        localStringBuilder.append(", ");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append('=');
      localStringBuilder.append(localEntry.getValue());
      i++;
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.AnnotationEntry
 * JD-Core Version:    0.6.2
 */