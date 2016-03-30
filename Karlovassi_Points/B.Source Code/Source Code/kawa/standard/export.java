package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class export extends Syntax
{
  public static final export export;
  public static final export module_export = new export();

  static
  {
    module_export.setName("module-export");
    export = new export();
    module_export.setName("export");
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    return null;
  }

  public boolean scanForDefinitions(Pair paramPair, Vector paramVector, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    Object localObject1 = paramPair.getCdr();
    Object localObject2 = paramTranslator.pushPositionOf(paramPair);
    while (true)
    {
      SyntaxForm localSyntaxForm2;
      try
      {
        SyntaxForm localSyntaxForm1;
        if ((paramScopeExp instanceof ModuleExp))
        {
          ((ModuleExp)paramScopeExp).setFlag(16384);
          localSyntaxForm1 = null;
          if (localObject1 == LList.Empty)
            continue;
          paramTranslator.pushPositionOf(localObject1);
          if ((localObject1 instanceof SyntaxForm))
          {
            localSyntaxForm1 = (SyntaxForm)localObject1;
            localObject1 = localSyntaxForm1.getDatum();
            continue;
          }
        }
        else
        {
          paramTranslator.error('e', "'" + getName() + "' not at module level");
          return true;
        }
        localSyntaxForm2 = localSyntaxForm1;
        if ((localObject1 instanceof Pair))
        {
          Pair localPair = (Pair)localObject1;
          Object localObject4 = localPair.getCar();
          if ((localObject4 instanceof SyntaxForm))
          {
            localSyntaxForm2 = (SyntaxForm)localObject4;
            localObject4 = localSyntaxForm2.getDatum();
            continue;
          }
          if ((localObject4 instanceof String))
          {
            String str = (String)localObject4;
            if (str.startsWith("namespace:"))
            {
              paramTranslator.error('w', "'namespace:' prefix ignored");
              localObject4 = str.substring(10).intern();
            }
          }
          if ((localObject4 instanceof String))
            break label346;
          if ((localObject4 instanceof Symbol))
          {
            break label346;
            Declaration localDeclaration = paramScopeExp.getNoDefine(localObject4);
            if (localDeclaration.getFlag(512L))
              Translator.setLine(localDeclaration, localPair);
            localDeclaration.setFlag(1024L);
            localObject1 = localPair.getCdr();
            continue;
          }
        }
        paramTranslator.error('e', "invalid syntax in '" + getName() + '\'');
        return false;
        return true;
      }
      finally
      {
        paramTranslator.popPositionOf(localObject2);
      }
      label346: if (localSyntaxForm2 == null);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.export
 * JD-Core Version:    0.6.2
 */