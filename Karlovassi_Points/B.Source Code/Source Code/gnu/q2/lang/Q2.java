package gnu.q2.lang;

import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.kawa.functions.AppendValues;
import gnu.kawa.lispexpr.ReadTable;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.mapping.InPort;
import gnu.mapping.Procedure;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.xml.XMLPrinter;
import java.io.Writer;
import kawa.standard.Scheme;

public class Q2 extends Scheme
{
  static final Object emptyForm = new FString();
  static Q2 instance;

  public Q2()
  {
    instance = this;
    ModuleBody.setMainPrintValues(true);
  }

  public static int compareIndentation(int paramInt1, int paramInt2)
  {
    int i = paramInt1 >>> 16;
    int j = paramInt1 >>> 16;
    int k = paramInt1 & 0xFF;
    int m = paramInt2 & 0xFF;
    if (i == j)
      return k - m;
    if (((i < j) && (k <= m)) || ((i > j) && (k >= m)))
      return 8 * (i - j);
    return -2147483648;
  }

  public static Q2 getQ2Instance()
  {
    if (instance == null)
      new Q2();
    return instance;
  }

  public static void registerEnvironment()
  {
    Language.setDefaults(new Q2());
  }

  public ReadTable createReadTable()
  {
    ReadTable localReadTable = ReadTable.createInitial();
    localReadTable.set(40, new Q2ReaderParens());
    localReadTable.setFinalColonIsKeyword(true);
    return localReadTable;
  }

  public Lexer getLexer(InPort paramInPort, SourceMessages paramSourceMessages)
  {
    gnu.expr.Compilation.defaultCallConvention = 2;
    return new Q2Read(paramInPort, paramSourceMessages);
  }

  public Consumer getOutputConsumer(Writer paramWriter)
  {
    return new XMLPrinter(paramWriter, false);
  }

  public Procedure getPrompter()
  {
    return new Prompter();
  }

  public Expression makeApply(Expression paramExpression, Expression[] paramArrayOfExpression)
  {
    Expression[] arrayOfExpression = new Expression[1 + paramArrayOfExpression.length];
    arrayOfExpression[0] = paramExpression;
    System.arraycopy(paramArrayOfExpression, 0, arrayOfExpression, 1, paramArrayOfExpression.length);
    return new ApplyExp(Q2Apply.q2Apply, arrayOfExpression);
  }

  public Expression makeBody(Expression[] paramArrayOfExpression)
  {
    return new ApplyExp(AppendValues.appendValues, paramArrayOfExpression);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.q2.lang.Q2
 * JD-Core Version:    0.6.2
 */