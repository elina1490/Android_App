package gnu.kawa.xml;

import gnu.lists.Consumer;
import gnu.lists.XConsumer;
import gnu.mapping.Location;
import gnu.mapping.NamedLocation;
import gnu.mapping.ThreadLocation;
import gnu.text.Path;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import gnu.xml.NodeTree;
import gnu.xml.XMLParser;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Hashtable;

public class Document
{
  private static HashMap cache = new HashMap();
  private static ThreadLocation docMapLocation;
  public static final Document document = new Document();

  static
  {
    docMapLocation = new ThreadLocation("document-map");
  }

  public static void clearLocalCache()
  {
    docMapLocation.getLocation().set(null);
  }

  public static void clearSoftCache()
  {
    cache = new HashMap();
  }

  public static KDocument parse(Object paramObject)
    throws Throwable
  {
    NodeTree localNodeTree = new NodeTree();
    parse(paramObject, localNodeTree);
    return new KDocument(localNodeTree, 10);
  }

  public static void parse(Object paramObject, Consumer paramConsumer)
    throws Throwable
  {
    SourceMessages localSourceMessages = new SourceMessages();
    if ((paramConsumer instanceof XConsumer))
      ((XConsumer)paramConsumer).beginEntity(paramObject);
    XMLParser.parse(paramObject, localSourceMessages, paramConsumer);
    if (localSourceMessages.seenErrors())
      throw new SyntaxException("document function read invalid XML", localSourceMessages);
    if ((paramConsumer instanceof XConsumer))
      ((XConsumer)paramConsumer).endEntity();
  }

  public static KDocument parseCached(Path paramPath)
    throws Throwable
  {
    while (true)
    {
      Hashtable localHashtable;
      try
      {
        DocReference localDocReference1 = (DocReference)DocReference.queue.poll();
        if (localDocReference1 == null)
        {
          NamedLocation localNamedLocation = docMapLocation.getLocation();
          localHashtable = (Hashtable)localNamedLocation.get(null);
          if (localHashtable == null)
          {
            localHashtable = new Hashtable();
            localNamedLocation.set(localHashtable);
          }
          KDocument localKDocument1 = (KDocument)localHashtable.get(paramPath);
          if (localKDocument1 != null)
          {
            localObject2 = localKDocument1;
            return localObject2;
          }
        }
        else
        {
          cache.remove(localDocReference1.key);
          continue;
        }
      }
      finally
      {
      }
      DocReference localDocReference2 = (DocReference)cache.get(paramPath);
      KDocument localKDocument2;
      if (localDocReference2 != null)
      {
        localKDocument2 = (KDocument)localDocReference2.get();
        if (localKDocument2 == null)
          cache.remove(paramPath);
      }
      else
      {
        KDocument localKDocument3 = parse(paramPath);
        localHashtable.put(paramPath, localKDocument3);
        cache.put(paramPath, new DocReference(paramPath, localKDocument3));
        localObject2 = localKDocument3;
        continue;
      }
      localHashtable.put(paramPath, localKDocument2);
      Object localObject2 = localKDocument2;
    }
  }

  public static KDocument parseCached(Object paramObject)
    throws Throwable
  {
    return parseCached(Path.valueOf(paramObject));
  }

  private static class DocReference extends SoftReference
  {
    static ReferenceQueue queue = new ReferenceQueue();
    Path key;

    public DocReference(Path paramPath, KDocument paramKDocument)
    {
      super(queue);
      this.key = paramPath;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.Document
 * JD-Core Version:    0.6.2
 */