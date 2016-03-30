package gnu.kawa.lispexpr;

import gnu.mapping.Namespace;

class NamespaceUse
{
  Namespace imported;
  Namespace importing;
  NamespaceUse nextImported;
  NamespaceUse nextImporting;
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.NamespaceUse
 * JD-Core Version:    0.6.2
 */