package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import java.io.PrintStream;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class ImportFromLibrary extends Syntax
{
  private static final String BUILTIN = "";
  private static final String MISSING;
  static final String[][] SRFI97Map = arrayOfString;;
  public static final ImportFromLibrary instance = new ImportFromLibrary();
  public String[] classPrefixPath = { "", "kawa.lib." };

  static
  {
    MISSING = null;
    String[][] arrayOfString; = new String[48][];
    arrayOfString;[0] = { "1", "lists", "gnu.kawa.slib.srfi1" };
    arrayOfString;[1] = { "2", "and-let*", "gnu.kawa.slib.srfi2" };
    String[] arrayOfString1 = new String[3];
    arrayOfString1[0] = "5";
    arrayOfString1[1] = "let";
    arrayOfString1[2] = MISSING;
    arrayOfString;[2] = arrayOfString1;
    arrayOfString;[3] = { "6", "basic-string-ports", "" };
    arrayOfString;[4] = { "8", "receive", "" };
    arrayOfString;[5] = { "9", "records", "" };
    arrayOfString;[6] = { "11", "let-values", "" };
    arrayOfString;[7] = { "13", "strings", "gnu.kawa.slib.srfi13" };
    String[] arrayOfString2 = new String[3];
    arrayOfString2[0] = "14";
    arrayOfString2[1] = "char-sets";
    arrayOfString2[2] = MISSING;
    arrayOfString;[8] = arrayOfString2;
    arrayOfString;[9] = { "16", "case-lambda", "" };
    arrayOfString;[10] = { "17", "generalized-set!", "" };
    String[] arrayOfString3 = new String[3];
    arrayOfString3[0] = "18";
    arrayOfString3[1] = "multithreading";
    arrayOfString3[2] = MISSING;
    arrayOfString;[11] = arrayOfString3;
    String[] arrayOfString4 = new String[3];
    arrayOfString4[0] = "19";
    arrayOfString4[1] = "time";
    arrayOfString4[2] = MISSING;
    arrayOfString;[12] = arrayOfString4;
    String[] arrayOfString5 = new String[3];
    arrayOfString5[0] = "21";
    arrayOfString5[1] = "real-time-multithreading";
    arrayOfString5[2] = MISSING;
    arrayOfString;[13] = arrayOfString5;
    arrayOfString;[14] = { "23", "error", "" };
    arrayOfString;[15] = { "25", "multi-dimensional-arrays", "" };
    arrayOfString;[16] = { "26", "cut", "" };
    String[] arrayOfString6 = new String[3];
    arrayOfString6[0] = "27";
    arrayOfString6[1] = "random-bits";
    arrayOfString6[2] = MISSING;
    arrayOfString;[17] = arrayOfString6;
    arrayOfString;[18] = { "28", "basic-format-strings", "" };
    String[] arrayOfString7 = new String[3];
    arrayOfString7[0] = "29";
    arrayOfString7[1] = "localization";
    arrayOfString7[2] = MISSING;
    arrayOfString;[19] = arrayOfString7;
    String[] arrayOfString8 = new String[3];
    arrayOfString8[0] = "31";
    arrayOfString8[1] = "rec";
    arrayOfString8[2] = MISSING;
    arrayOfString;[20] = arrayOfString8;
    String[] arrayOfString9 = new String[3];
    arrayOfString9[0] = "38";
    arrayOfString9[1] = "with-shared-structure";
    arrayOfString9[2] = MISSING;
    arrayOfString;[21] = arrayOfString9;
    arrayOfString;[22] = { "39", "parameters", "" };
    String[] arrayOfString10 = new String[3];
    arrayOfString10[0] = "41";
    arrayOfString10[1] = "streams";
    arrayOfString10[2] = MISSING;
    arrayOfString;[23] = arrayOfString10;
    String[] arrayOfString11 = new String[3];
    arrayOfString11[0] = "42";
    arrayOfString11[1] = "eager-comprehensions";
    arrayOfString11[2] = MISSING;
    arrayOfString;[24] = arrayOfString11;
    String[] arrayOfString12 = new String[3];
    arrayOfString12[0] = "43";
    arrayOfString12[1] = "vectors";
    arrayOfString12[2] = MISSING;
    arrayOfString;[25] = arrayOfString12;
    String[] arrayOfString13 = new String[3];
    arrayOfString13[0] = "44";
    arrayOfString13[1] = "collections";
    arrayOfString13[2] = MISSING;
    arrayOfString;[26] = arrayOfString13;
    String[] arrayOfString14 = new String[3];
    arrayOfString14[0] = "45";
    arrayOfString14[1] = "lazy";
    arrayOfString14[2] = MISSING;
    arrayOfString;[27] = arrayOfString14;
    String[] arrayOfString15 = new String[3];
    arrayOfString15[0] = "46";
    arrayOfString15[1] = "syntax-rules";
    arrayOfString15[2] = MISSING;
    arrayOfString;[28] = arrayOfString15;
    String[] arrayOfString16 = new String[3];
    arrayOfString16[0] = "47";
    arrayOfString16[1] = "arrays";
    arrayOfString16[2] = MISSING;
    arrayOfString;[29] = arrayOfString16;
    String[] arrayOfString17 = new String[3];
    arrayOfString17[0] = "48";
    arrayOfString17[1] = "intermediate-format-strings";
    arrayOfString17[2] = MISSING;
    arrayOfString;[30] = arrayOfString17;
    String[] arrayOfString18 = new String[3];
    arrayOfString18[0] = "51";
    arrayOfString18[1] = "rest-values";
    arrayOfString18[2] = MISSING;
    arrayOfString;[31] = arrayOfString18;
    String[] arrayOfString19 = new String[3];
    arrayOfString19[0] = "54";
    arrayOfString19[1] = "cat";
    arrayOfString19[2] = MISSING;
    arrayOfString;[32] = arrayOfString19;
    String[] arrayOfString20 = new String[3];
    arrayOfString20[0] = "57";
    arrayOfString20[1] = "records";
    arrayOfString20[2] = MISSING;
    arrayOfString;[33] = arrayOfString20;
    String[] arrayOfString21 = new String[3];
    arrayOfString21[0] = "59";
    arrayOfString21[1] = "vicinities";
    arrayOfString21[2] = MISSING;
    arrayOfString;[34] = arrayOfString21;
    String[] arrayOfString22 = new String[3];
    arrayOfString22[0] = "60";
    arrayOfString22[1] = "integer-bits";
    arrayOfString22[2] = MISSING;
    arrayOfString;[35] = arrayOfString22;
    String[] arrayOfString23 = new String[3];
    arrayOfString23[0] = "61";
    arrayOfString23[1] = "cond";
    arrayOfString23[2] = MISSING;
    arrayOfString;[36] = arrayOfString23;
    String[] arrayOfString24 = new String[3];
    arrayOfString24[0] = "63";
    arrayOfString24[1] = "arrays";
    arrayOfString24[2] = MISSING;
    arrayOfString;[37] = arrayOfString24;
    arrayOfString;[38] = { "64", "testing", "gnu.kawa.slib.testing" };
    String[] arrayOfString25 = new String[3];
    arrayOfString25[0] = "66";
    arrayOfString25[1] = "octet-vectors";
    arrayOfString25[2] = MISSING;
    arrayOfString;[39] = arrayOfString25;
    String[] arrayOfString26 = new String[3];
    arrayOfString26[0] = "67";
    arrayOfString26[1] = "compare-procedures";
    arrayOfString26[2] = MISSING;
    arrayOfString;[40] = arrayOfString26;
    arrayOfString;[41] = { "69", "basic-hash-tables", "gnu.kawa.slib.srfi69" };
    String[] arrayOfString27 = new String[3];
    arrayOfString27[0] = "71";
    arrayOfString27[1] = "let";
    arrayOfString27[2] = MISSING;
    arrayOfString;[42] = arrayOfString27;
    String[] arrayOfString28 = new String[3];
    arrayOfString28[0] = "74";
    arrayOfString28[1] = "blobs";
    arrayOfString28[2] = MISSING;
    arrayOfString;[43] = arrayOfString28;
    String[] arrayOfString29 = new String[3];
    arrayOfString29[0] = "78";
    arrayOfString29[1] = "lightweight-testing";
    arrayOfString29[2] = MISSING;
    arrayOfString;[44] = arrayOfString29;
    String[] arrayOfString30 = new String[3];
    arrayOfString30[0] = "86";
    arrayOfString30[1] = "mu-and-nu";
    arrayOfString30[2] = MISSING;
    arrayOfString;[45] = arrayOfString30;
    String[] arrayOfString31 = new String[3];
    arrayOfString31[0] = "87";
    arrayOfString31[1] = "case";
    arrayOfString31[2] = MISSING;
    arrayOfString;[46] = arrayOfString31;
    arrayOfString;[47] = { "95", "sorting-and-merging", "kawa.lib.srfi95" };
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    return null;
  }

  public boolean scanForDefinitions(Pair paramPair, Vector paramVector, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    Object localObject1 = paramPair.getCdr();
    if (!(localObject1 instanceof Pair))
      return false;
    Pair localPair1 = (Pair)localObject1;
    Object localObject2 = localPair1.getCar();
    if (LList.listLength(localObject2, false) <= 0)
    {
      paramTranslator.error('e', "expected <library reference> which must be a list");
      return false;
    }
    Object localObject3 = localPair1.getCdr();
    boolean bool1 = localObject3 instanceof Pair;
    Procedure localProcedure = null;
    if (bool1)
    {
      boolean bool2 = ((Pair)localObject3).getCar() instanceof Procedure;
      localProcedure = null;
      if (bool2)
        localProcedure = (Procedure)((Pair)localObject3).getCar();
    }
    String str1 = null;
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject4 = null;
    if ((localObject2 instanceof Pair))
    {
      Pair localPair2 = (Pair)localObject2;
      Object localObject7 = localPair2.getCar();
      Object localObject8 = localPair2.getCdr();
      if ((localObject7 instanceof Pair))
      {
        if (localObject4 != null)
          paramTranslator.error('e', "duplicate version reference - was " + localObject4);
        System.err.println("import version " + localObject7);
        localObject4 = localObject7;
      }
      while (true)
      {
        localObject2 = localObject8;
        break;
        if ((localObject7 instanceof String))
        {
          if ((localObject8 instanceof Pair))
            paramTranslator.error('e', "source specifier must be last elemnt in library reference");
          str1 = (String)localObject7;
        }
        else
        {
          if (localStringBuffer.length() > 0)
            localStringBuffer.append('.');
          localStringBuffer.append(Compilation.mangleNameIfNeeded(localObject7.toString()));
        }
      }
    }
    Object localObject5 = null;
    if (str1 != null)
    {
      localObject5 = require.lookupModuleFromSourcePath(str1, paramScopeExp);
      if (localObject5 == null)
      {
        paramTranslator.error('e', "malformed URL: " + str1);
        return false;
      }
    }
    Object localObject6 = localStringBuffer.toString();
    if (((String)localObject6).startsWith("srfi."))
    {
      String str3 = Compilation.demangleName(((String)localObject6).substring(5));
      int k = str3.indexOf('.');
      String str4;
      String str5;
      if (k < 0)
      {
        str4 = null;
        k = str3.length();
        if (k < 2)
        {
          int i2 = str3.charAt(0);
          str5 = null;
          if (i2 != 58)
            break label446;
        }
      }
      for (int m = 1; ; m++)
      {
        if (m == k)
          str5 = str3.substring(1, k);
        label446: int n;
        do
        {
          if (str5 != null)
            break label505;
          paramTranslator.error('e', "SRFI library reference must have the form: (srfi :NNN [name])");
          return false;
          str4 = str3.substring(k + 1);
          break;
          n = Character.digit(str3.charAt(m), 10);
          str5 = null;
        }
        while (n < 0);
      }
      label505: int i1 = SRFI97Map.length;
      do
      {
        i1--;
        if (i1 < 0)
        {
          paramTranslator.error('e', "unknown SRFI number '" + str5 + "' in SRFI library reference");
          return false;
        }
      }
      while (!SRFI97Map[i1][0].equals(str5));
      String str6 = SRFI97Map[i1][1];
      String str7 = SRFI97Map[i1][2];
      if ((str4 != null) && (!str4.equals(str6)))
        paramTranslator.error('w', "the name of SRFI " + str5 + " should be '" + str6 + '\'');
      if (str7 == "")
        return true;
      if (str7 == MISSING)
      {
        paramTranslator.error('e', "sorry - Kawa does not support SRFI " + str5 + " (" + str6 + ')');
        return false;
      }
      localObject6 = str7;
    }
    int i = this.classPrefixPath.length;
    int j = 0;
    while (true)
      if (j < i)
      {
        String str2 = this.classPrefixPath[j] + (String)localObject6;
        try
        {
          ModuleInfo localModuleInfo = ModuleManager.getInstance().findWithClassName(str2);
          localObject5 = localModuleInfo;
          label775: j++;
        }
        catch (Exception localException)
        {
          break label775;
        }
      }
    if (localObject5 == null)
    {
      paramTranslator.error('e', "unknown class " + (String)localObject6);
      return false;
    }
    require.importDefinitions(null, (ModuleInfo)localObject5, localProcedure, paramVector, paramScopeExp, paramTranslator);
    return true;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.ImportFromLibrary
 * JD-Core Version:    0.6.2
 */