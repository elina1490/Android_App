package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class module_implements extends Syntax
{
  public static final module_implements module_implements = new module_implements();

  static
  {
    module_implements.setName("module-implements");
  }

  public void scanForm(Pair paramPair, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    Object localObject = paramPair.getCdr();
    int i = LList.listLength(localObject, false);
    if (i < 0)
    {
      paramTranslator.syntaxError("improper argument list for " + getName());
      return;
    }
    ClassType[] arrayOfClassType = new ClassType[i];
    for (int j = 0; j < i; j++)
    {
      Pair localPair = (Pair)localObject;
      arrayOfClassType[j] = ((ClassType)paramTranslator.exp2Type(localPair));
      localObject = localPair.getCdr();
    }
    ModuleExp localModuleExp = paramTranslator.getModule();
    localModuleExp.setInterfaces(arrayOfClassType);
    localModuleExp.setFlag(131072);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.module_implements
 * JD-Core Version:    0.6.2
 */