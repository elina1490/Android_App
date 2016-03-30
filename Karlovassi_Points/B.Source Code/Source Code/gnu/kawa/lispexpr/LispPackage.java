package gnu.kawa.lispexpr;

import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;

public class LispPackage extends Namespace
{
  Namespace exported;
  NamespaceUse imported;
  NamespaceUse importing;
  LList shadowingSymbols = LList.Empty;

  private void addToShadowingSymbols(Symbol paramSymbol)
  {
    Pair localPair;
    for (Object localObject = this.shadowingSymbols; localObject != LList.Empty; localObject = localPair.getCdr())
    {
      localPair = (Pair)localObject;
      if (localPair.getCar() == paramSymbol)
        return;
    }
    this.shadowingSymbols = new Pair(paramSymbol, this.shadowingSymbols);
  }

  private boolean removeFromShadowingSymbols(Symbol paramSymbol)
  {
    Object localObject1 = null;
    Object localObject2 = this.shadowingSymbols;
    while (localObject2 != LList.Empty)
    {
      Pair localPair = (Pair)localObject2;
      localObject2 = localPair.getCdr();
      if (localPair.getCar() == paramSymbol)
      {
        if (localObject1 == null)
          this.shadowingSymbols = ((LList)localObject2);
        while (true)
        {
          return true;
          localObject1.setCdr(localObject2);
        }
      }
      localObject1 = localPair;
    }
    return false;
  }

  public boolean isPresent(String paramString)
  {
    return lookupPresent(paramString, paramString.hashCode(), false) != null;
  }

  public Symbol lookup(String paramString, int paramInt, boolean paramBoolean)
  {
    Symbol localSymbol1 = this.exported.lookup(paramString, paramInt, false);
    if (localSymbol1 != null)
      return localSymbol1;
    Symbol localSymbol2 = lookupInternal(paramString, paramInt);
    if (localSymbol2 != null)
      return localSymbol2;
    for (NamespaceUse localNamespaceUse = this.imported; localNamespaceUse != null; localNamespaceUse = localNamespaceUse.nextImported)
    {
      Symbol localSymbol3 = lookup(paramString, paramInt, false);
      if (localSymbol3 != null)
        return localSymbol3;
    }
    if (paramBoolean)
      return add(new Symbol(this, paramString), paramInt);
    return null;
  }

  public Symbol lookupPresent(String paramString, int paramInt, boolean paramBoolean)
  {
    Symbol localSymbol = this.exported.lookup(paramString, paramInt, false);
    if (localSymbol == null)
      localSymbol = super.lookup(paramString, paramInt, paramBoolean);
    return localSymbol;
  }

  public void shadow(String paramString)
  {
    addToShadowingSymbols(lookupPresent(paramString, paramString.hashCode(), true));
  }

  public void shadowingImport(Symbol paramSymbol)
  {
    String str = paramSymbol.getName();
    str.hashCode();
    Symbol localSymbol = lookupPresent(str, str.hashCode(), false);
    if ((localSymbol != null) && (localSymbol != paramSymbol))
      unintern(localSymbol);
    addToShadowingSymbols(paramSymbol);
  }

  public boolean unintern(Symbol paramSymbol)
  {
    String str = paramSymbol.getName();
    int i = str.hashCode();
    if (this.exported.lookup(str, i, false) == paramSymbol)
      this.exported.remove(paramSymbol);
    while (true)
    {
      paramSymbol.setNamespace(null);
      if (removeFromShadowingSymbols(paramSymbol));
      return true;
      if (super.lookup(str, i, false) != paramSymbol)
        break;
      super.remove(paramSymbol);
    }
    return false;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.LispPackage
 * JD-Core Version:    0.6.2
 */