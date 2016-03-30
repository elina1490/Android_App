package gnu.xml;

import gnu.kawa.xml.KNode;
import gnu.lists.Consumer;
import gnu.lists.TreeList;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import java.math.BigDecimal;

public class TextUtils
{
  public static String asString(Object paramObject)
  {
    if ((paramObject == Values.empty) || (paramObject == null))
      return "";
    if ((paramObject instanceof Values))
      throw new ClassCastException();
    StringBuffer localStringBuffer = new StringBuffer(100);
    stringValue(paramObject, localStringBuffer);
    return localStringBuffer.toString();
  }

  public static String replaceWhitespace(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = null;
    int i = paramString.length();
    int j;
    int k;
    if (paramBoolean)
    {
      j = 1;
      k = 0;
    }
    while (true)
    {
      if (k >= i)
        break label291;
      int m = k + 1;
      char c = paramString.charAt(k);
      int n;
      if (c == ' ')
      {
        n = 1;
        label47: if ((localStringBuilder != null) || ((n != 2) && ((n != 1) || (j <= 0) || (!paramBoolean)) && ((n != 1) || (m != i) || (!paramBoolean))))
          break label186;
        localStringBuilder = new StringBuilder();
        if (j <= 0)
          break label173;
      }
      label173: for (int i1 = m - 2; ; i1 = m - 1)
      {
        for (int i2 = 0; i2 < i1; i2++)
          localStringBuilder.append(paramString.charAt(i2));
        j = 0;
        break;
        if ((c == '\t') || (c == '\r') || (c == '\n'))
        {
          n = 2;
          break label47;
        }
        n = 0;
        break label47;
      }
      c = ' ';
      label186: if (paramBoolean)
      {
        if ((j > 0) && (n == 0))
        {
          if ((localStringBuilder != null) && (localStringBuilder.length() > 0))
            localStringBuilder.append(' ');
          j = 0;
        }
        while (true)
        {
          if (j <= 0)
            break label273;
          k = m;
          break;
          if ((n == 2) || ((n == 1) && (j > 0)))
            j = 2;
          else if (n > 0)
            j = 1;
          else
            j = 0;
        }
      }
      label273: if (localStringBuilder != null)
        localStringBuilder.append(c);
      k = m;
    }
    label291: if (localStringBuilder != null)
      return localStringBuilder.toString();
    return paramString;
  }

  public static String stringValue(Object paramObject)
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    TreeList localTreeList;
    int i;
    int j;
    if ((paramObject instanceof Values))
    {
      localTreeList = (TreeList)paramObject;
      i = 0;
      j = localTreeList.getNextKind(i);
      if (j != 0);
    }
    while (true)
    {
      return localStringBuffer.toString();
      if (j == 32)
        stringValue(localTreeList.getPosNext(i), localStringBuffer);
      while (true)
      {
        i = localTreeList.nextPos(i);
        break;
        localTreeList.stringValue(localTreeList.posToDataIndex(i), localStringBuffer);
      }
      stringValue(paramObject, localStringBuffer);
    }
  }

  public static void stringValue(Object paramObject, StringBuffer paramStringBuffer)
  {
    if ((paramObject instanceof KNode))
    {
      KNode localKNode = (KNode)paramObject;
      NodeTree localNodeTree = (NodeTree)localKNode.sequence;
      localNodeTree.stringValue(localNodeTree.posToDataIndex(localKNode.ipos), paramStringBuffer);
    }
    while (true)
    {
      return;
      if ((paramObject instanceof BigDecimal))
        paramObject = XMLPrinter.formatDecimal((BigDecimal)paramObject);
      while ((paramObject != null) && (paramObject != Values.empty))
      {
        paramStringBuffer.append(paramObject);
        return;
        if (((paramObject instanceof Double)) || ((paramObject instanceof DFloNum)))
          paramObject = XMLPrinter.formatDouble(((Number)paramObject).doubleValue());
        else if ((paramObject instanceof Float))
          paramObject = XMLPrinter.formatFloat(((Number)paramObject).floatValue());
      }
    }
  }

  public static void textValue(Object paramObject, Consumer paramConsumer)
  {
    if ((paramObject == null) || (((paramObject instanceof Values)) && (((Values)paramObject).isEmpty())))
      return;
    if ((paramObject instanceof String));
    StringBuffer localStringBuffer;
    for (String str = (String)paramObject; ; str = localStringBuffer.toString())
    {
      paramConsumer.write(str);
      return;
      localStringBuffer = new StringBuffer();
      if ((paramObject instanceof Values))
      {
        Object[] arrayOfObject = ((Values)paramObject).getValues();
        for (int i = 0; i < arrayOfObject.length; i++)
        {
          if (i > 0)
            localStringBuffer.append(' ');
          stringValue(arrayOfObject[i], localStringBuffer);
        }
      }
      stringValue(paramObject, localStringBuffer);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.xml.TextUtils
 * JD-Core Version:    0.6.2
 */