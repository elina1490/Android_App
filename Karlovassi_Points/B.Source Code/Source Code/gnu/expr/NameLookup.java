package gnu.expr;

import gnu.kawa.util.GeneralHashTable;
import gnu.kawa.util.HashNode;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.Symbol;

public class NameLookup extends GeneralHashTable<Object, Declaration>
{
  static final Symbol KEY = Symbol.makeUninterned("<current-NameLookup>");
  Language language;

  public NameLookup(Language paramLanguage)
  {
    this.language = paramLanguage;
  }

  public static NameLookup getInstance(Environment paramEnvironment, Language paramLanguage)
  {
    Location localLocation = paramEnvironment.getLocation(KEY);
    NameLookup localNameLookup1 = (NameLookup)localLocation.get(null);
    if (localNameLookup1 == null)
    {
      NameLookup localNameLookup2 = new NameLookup(paramLanguage);
      localLocation.set(localNameLookup2);
      return localNameLookup2;
    }
    localNameLookup1.setLanguage(paramLanguage);
    return localNameLookup1;
  }

  public static void setInstance(Environment paramEnvironment, NameLookup paramNameLookup)
  {
    if (paramNameLookup == null)
    {
      paramEnvironment.remove(KEY);
      return;
    }
    paramEnvironment.put(KEY, null, paramNameLookup);
  }

  public Language getLanguage()
  {
    return this.language;
  }

  public Declaration lookup(Object paramObject, int paramInt)
  {
    int i = hashToIndex(hash(paramObject));
    for (HashNode localHashNode = ((HashNode[])this.table)[i]; localHashNode != null; localHashNode = localHashNode.next)
    {
      Declaration localDeclaration = (Declaration)localHashNode.getValue();
      if ((paramObject.equals(localDeclaration.getSymbol())) && (this.language.hasNamespace(localDeclaration, paramInt)))
        return localDeclaration;
    }
    return null;
  }

  public Declaration lookup(Object paramObject, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 2; ; i = 1)
      return lookup(paramObject, i);
  }

  public void pop(ScopeExp paramScopeExp)
  {
    for (Declaration localDeclaration = paramScopeExp.firstDecl(); localDeclaration != null; localDeclaration = localDeclaration.nextDecl())
      pop(localDeclaration);
  }

  public boolean pop(Declaration paramDeclaration)
  {
    Object localObject1 = paramDeclaration.getSymbol();
    if (localObject1 == null)
      return false;
    int i = hash(localObject1);
    Object localObject2 = null;
    int j = hashToIndex(i);
    HashNode localHashNode;
    for (Object localObject3 = ((HashNode[])this.table)[j]; localObject3 != null; localObject3 = localHashNode)
    {
      localHashNode = ((HashNode)localObject3).next;
      if (((HashNode)localObject3).getValue() == paramDeclaration)
      {
        if (localObject2 == null)
          ((HashNode[])this.table)[j] = localHashNode;
        while (true)
        {
          this.num_bindings -= 1;
          return true;
          localObject2.next = localHashNode;
        }
      }
      localObject2 = localObject3;
    }
    return false;
  }

  public void push(Declaration paramDeclaration)
  {
    Object localObject = paramDeclaration.getSymbol();
    if (localObject == null)
      return;
    int i = 1 + this.num_bindings;
    this.num_bindings = i;
    if (i >= ((HashNode[])this.table).length)
      rehash();
    int j = hash(localObject);
    HashNode localHashNode = makeEntry(localObject, j, paramDeclaration);
    int k = hashToIndex(j);
    localHashNode.next = ((HashNode[])this.table)[k];
    ((HashNode[])this.table)[k] = localHashNode;
  }

  public void push(ScopeExp paramScopeExp)
  {
    for (Declaration localDeclaration = paramScopeExp.firstDecl(); localDeclaration != null; localDeclaration = localDeclaration.nextDecl())
      push(localDeclaration);
  }

  public void removeSubsumed(Declaration paramDeclaration)
  {
    int i = hashToIndex(hash(paramDeclaration.getSymbol()));
    Object localObject1 = null;
    Object localObject2 = ((HashNode[])this.table)[i];
    if (localObject2 != null)
    {
      HashNode localHashNode = ((HashNode)localObject2).next;
      Declaration localDeclaration = (Declaration)((HashNode)localObject2).getValue();
      if ((localDeclaration != paramDeclaration) && (subsumedBy(paramDeclaration, localDeclaration)))
        if (localObject1 == null)
          ((HashNode[])this.table)[i] = localHashNode;
      while (true)
      {
        localObject2 = localHashNode;
        break;
        localObject1.next = localHashNode;
        continue;
        localObject1 = localObject2;
      }
    }
  }

  public void setLanguage(Language paramLanguage)
  {
    this.language = paramLanguage;
  }

  protected boolean subsumedBy(Declaration paramDeclaration1, Declaration paramDeclaration2)
  {
    return (paramDeclaration1.getSymbol() == paramDeclaration2.getSymbol()) && ((this.language.getNamespaceOf(paramDeclaration1) & this.language.getNamespaceOf(paramDeclaration2)) != 0);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.NameLookup
 * JD-Core Version:    0.6.2
 */