package gnu.ecmascript;

import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.LambdaExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.SetExp;
import gnu.lists.Sequence;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.TtyInPort;
import gnu.mapping.Values;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Vector;
import kawa.standard.Scheme;

public class Parser
{
  public static final Expression[] emptyArgs = new Expression[0];
  static Expression emptyStatement = new QuoteExp(Values.empty);
  public static Expression eofExpr = new QuoteExp(Sequence.eofValue);
  public int errors;
  Lexer lexer;
  InPort port;
  Object previous_token;
  Object token;

  public Parser(InPort paramInPort)
  {
    this.port = paramInPort;
    this.lexer = new Lexer(paramInPort);
  }

  public static void main(String[] paramArrayOfString)
  {
    new Scheme();
    InPort localInPort = InPort.inDefault();
    if ((localInPort instanceof TtyInPort))
    {
      Prompter localPrompter = new Prompter();
      ((TtyInPort)localInPort).setPrompter((Procedure)localPrompter);
    }
    Parser localParser = new Parser(localInPort);
    OutPort localOutPort = OutPort.outDefault();
    try
    {
      while (true)
      {
        Expression localExpression = localParser.parseStatement();
        if (localExpression == eofExpr)
          return;
        localOutPort.print("[Expression: ");
        localExpression.print(localOutPort);
        localOutPort.println("]");
        Object localObject = localExpression.eval(Environment.user());
        localOutPort.print("result: ");
        localOutPort.print(localObject);
        localOutPort.println();
      }
    }
    catch (Throwable localThrowable)
    {
      System.err.println("caught exception:" + localThrowable);
      localThrowable.printStackTrace(System.err);
    }
  }

  public Expression buildLoop(Expression paramExpression1, Expression paramExpression2, Expression paramExpression3, Expression paramExpression4)
  {
    if (paramExpression1 != null)
    {
      Expression[] arrayOfExpression = new Expression[2];
      arrayOfExpression[0] = paramExpression1;
      arrayOfExpression[1] = buildLoop(null, paramExpression2, paramExpression3, paramExpression4);
      return new BeginExp(arrayOfExpression);
    }
    throw new Error("not implemented - buildLoop");
  }

  public String getIdentifier()
    throws IOException, SyntaxException
  {
    Object localObject = getToken();
    if ((localObject instanceof String))
      return (String)localObject;
    syntaxError("missing identifier");
    return "??";
  }

  public void getSemicolon()
    throws IOException, SyntaxException
  {
    this.token = peekToken();
    if (this.token == Lexer.semicolonToken)
      skipToken();
    while ((this.token == Lexer.rbraceToken) || (this.token == Lexer.eofToken) || (this.previous_token == Lexer.eolToken))
      return;
    syntaxError("missing ';' after expression");
  }

  public Object getToken()
    throws IOException, SyntaxException
  {
    Object localObject = peekToken();
    skipToken();
    return localObject;
  }

  public Expression makeCallExpression(Expression paramExpression, Expression[] paramArrayOfExpression)
  {
    return new ApplyExp(paramExpression, paramArrayOfExpression);
  }

  public Expression makeNewExpression(Expression paramExpression, Expression[] paramArrayOfExpression)
  {
    if (paramArrayOfExpression == null)
      paramArrayOfExpression = emptyArgs;
    return new ApplyExp(null, paramArrayOfExpression);
  }

  public Expression makePropertyAccessor(Expression paramExpression1, Expression paramExpression2)
  {
    return null;
  }

  public Expression[] parseArguments()
    throws IOException, SyntaxException
  {
    skipToken();
    if (peekToken() == Lexer.rparenToken)
    {
      skipToken();
      return emptyArgs;
    }
    Vector localVector = new Vector(10);
    while (true)
    {
      localVector.addElement(parseAssignmentExpression());
      Object localObject = getToken();
      if (localObject == Lexer.rparenToken)
      {
        Expression[] arrayOfExpression = new Expression[localVector.size()];
        localVector.copyInto(arrayOfExpression);
        return arrayOfExpression;
      }
      if (localObject != Lexer.commaToken)
        syntaxError("invalid token '" + localObject + "' in argument list");
    }
  }

  public Expression parseAssignmentExpression()
    throws IOException, SyntaxException
  {
    Expression localExpression1 = parseConditionalExpression();
    Object localObject = peekToken();
    if (localObject == Lexer.equalToken)
    {
      skipToken();
      Expression localExpression2 = parseAssignmentExpression();
      if ((localExpression1 instanceof ReferenceExp))
      {
        SetExp localSetExp = new SetExp(((ReferenceExp)localExpression1).getName(), localExpression2);
        localSetExp.setDefining(true);
        return localSetExp;
      }
      return syntaxError("unmplemented non-symbol ihs in assignment");
    }
    if (!(localObject instanceof Reserved))
      return localExpression1;
    Reserved localReserved = (Reserved)localObject;
    if (!localReserved.isAssignmentOp())
      return localExpression1;
    skipToken();
    Expression[] arrayOfExpression = { localExpression1, parseAssignmentExpression() };
    return new ApplyExp(new QuoteExp(localReserved.proc), arrayOfExpression);
  }

  public Expression parseBinaryExpression(int paramInt)
    throws IOException, SyntaxException
  {
    Reserved localReserved;
    Expression[] arrayOfExpression;
    for (Object localObject = parseUnaryExpression(); ; localObject = new ApplyExp(new QuoteExp(localReserved.proc), arrayOfExpression))
    {
      this.token = peekToken();
      if (!(this.token instanceof Reserved));
      do
      {
        return localObject;
        localReserved = (Reserved)this.token;
      }
      while (localReserved.prio < paramInt);
      getToken();
      arrayOfExpression = new Expression[] { localObject, parseBinaryExpression(1 + localReserved.prio) };
    }
  }

  public Expression parseBlock()
    throws IOException, SyntaxException
  {
    Object localObject = null;
    if (getToken() != Lexer.lbraceToken)
      return syntaxError("extened '{'");
    label81: label91: int m;
    for (int i = 0; ; i = m)
    {
      this.token = peekToken();
      int j;
      if (this.token == Lexer.rbraceToken)
      {
        skipToken();
        if (localObject == null)
          return emptyStatement;
        j = 1;
        if (localObject != null)
          break label81;
        localObject = new Expression[2];
      }
      while (true)
        if (j != 0)
        {
          return new BeginExp((Expression[])localObject);
          j = 0;
          break;
          if (j != 0)
          {
            if (localObject.length != i)
              if (j == 0);
          }
          else
            for (int k = i; ; k = 2 * localObject.length)
            {
              Expression[] arrayOfExpression = new Expression[k];
              System.arraycopy(localObject, 0, arrayOfExpression, 0, i);
              localObject = arrayOfExpression;
              break;
              if (localObject.length > i)
                break;
              break label91;
            }
        }
      m = i + 1;
      localObject[i] = parseStatement();
    }
  }

  public Expression parseConditionalExpression()
    throws IOException, SyntaxException
  {
    Expression localExpression1 = parseBinaryExpression(1);
    if (peekToken() != Lexer.condToken)
      return localExpression1;
    skipToken();
    Expression localExpression2 = parseAssignmentExpression();
    if (getToken() != Lexer.colonToken)
      return syntaxError("expected ':' in conditional expression");
    return new IfExp(localExpression1, localExpression2, parseAssignmentExpression());
  }

  public Expression parseExpression()
    throws IOException, SyntaxException
  {
    Object localObject = null;
    int m;
    for (int i = 0; ; i = m)
    {
      Expression localExpression = parseAssignmentExpression();
      int j;
      if (peekToken() != Lexer.commaToken)
        j = 1;
      while (localObject == null)
        if (j != 0)
        {
          return localExpression;
          j = 0;
        }
        else
        {
          localObject = new Expression[2];
        }
      do
      {
        m = i + 1;
        localObject[i] = localExpression;
        if (j == 0)
          break label130;
        return new BeginExp((Expression[])localObject);
        if (j == 0)
          break;
      }
      while (localObject.length == i + 1);
      label80: if (j != 0);
      for (int k = i + 1; ; k = 2 * localObject.length)
      {
        Expression[] arrayOfExpression = new Expression[k];
        System.arraycopy(localObject, 0, arrayOfExpression, 0, i);
        localObject = arrayOfExpression;
        break;
        if (localObject.length > i)
          break;
        break label80;
      }
      label130: skipToken();
    }
  }

  public Expression parseFunctionDefinition()
    throws IOException, SyntaxException
  {
    skipToken();
    String str = getIdentifier();
    Object localObject1 = getToken();
    if (localObject1 != Lexer.lparenToken)
      return syntaxError("expected '(' - got:" + localObject1);
    Vector localVector = new Vector(10);
    if (peekToken() == Lexer.rparenToken)
      skipToken();
    while (true)
    {
      LambdaExp localLambdaExp = new LambdaExp(parseBlock());
      localLambdaExp.setName(str);
      SetExp localSetExp = new SetExp(str, localLambdaExp);
      localSetExp.setDefining(true);
      return localSetExp;
      Object localObject2;
      do
      {
        if (localObject2 != Lexer.commaToken)
          syntaxError("invalid token '" + localObject2 + "' in argument list");
        localVector.addElement(getIdentifier());
        localObject2 = getToken();
      }
      while (localObject2 != Lexer.rparenToken);
    }
  }

  public Expression parseIfStatement()
    throws IOException, SyntaxException
  {
    skipToken();
    Object localObject1 = getToken();
    if (localObject1 != Lexer.lparenToken)
      return syntaxError("expected '(' - got:" + localObject1);
    Expression localExpression1 = parseExpression();
    Object localObject2 = getToken();
    if (localObject2 != Lexer.rparenToken)
      return syntaxError("expected ')' - got:" + localObject2);
    Expression localExpression2 = parseStatement();
    if (peekToken() == Lexer.elseToken)
      skipToken();
    for (Expression localExpression3 = parseStatement(); ; localExpression3 = null)
      return new IfExp(localExpression1, localExpression2, localExpression3);
  }

  public Expression parseLeftHandSideExpression()
    throws IOException, SyntaxException
  {
    int i = 0;
    while (peekToken() == Lexer.newToken)
    {
      i++;
      skipToken();
    }
    Expression localExpression1 = parsePrimaryExpression();
    while (true)
    {
      Object localObject1 = peekToken();
      if (localObject1 == Lexer.dotToken)
      {
        skipToken();
        localExpression1 = makePropertyAccessor(localExpression1, new QuoteExp(getIdentifier()));
      }
      else if (localObject1 == Lexer.lbracketToken)
      {
        skipToken();
        Expression localExpression2 = parseExpression();
        Object localObject2 = getToken();
        if (localObject2 != Lexer.rbracketToken)
          return syntaxError("expected ']' - got:" + localObject2);
        localExpression1 = makePropertyAccessor(localExpression1, localExpression2);
      }
      else
      {
        if (localObject1 != Lexer.lparenToken)
          break;
        Expression[] arrayOfExpression = parseArguments();
        System.err.println("after parseArgs:" + peekToken());
        if (i > 0)
        {
          localExpression1 = makeNewExpression(localExpression1, arrayOfExpression);
          i--;
        }
        else
        {
          localExpression1 = makeCallExpression(localExpression1, arrayOfExpression);
        }
      }
    }
    while (i > 0)
    {
      localExpression1 = makeNewExpression(localExpression1, null);
      i--;
    }
    return localExpression1;
  }

  public Expression parsePostfixExpression()
    throws IOException, SyntaxException
  {
    Expression localExpression = parseLeftHandSideExpression();
    Object localObject = peekTokenOrLine();
    if ((localObject != Reserved.opPlusPlus) && (localObject != Reserved.opMinusMinus))
      return localExpression;
    skipToken();
    Expression[] arrayOfExpression = { localExpression };
    return new ApplyExp(new QuoteExp(((Reserved)localObject).proc), arrayOfExpression);
  }

  public Expression parsePrimaryExpression()
    throws IOException, SyntaxException
  {
    Object localObject1 = getToken();
    if ((localObject1 instanceof QuoteExp))
      return (QuoteExp)localObject1;
    if ((localObject1 instanceof String))
      return new ReferenceExp((String)localObject1);
    if (localObject1 == Lexer.lparenToken)
    {
      Expression localExpression = parseExpression();
      Object localObject2 = getToken();
      if (localObject2 != Lexer.rparenToken)
        return syntaxError("expected ')' - got:" + localObject2);
      return localExpression;
    }
    return syntaxError("unexpected token: " + localObject1);
  }

  public Expression parseStatement()
    throws IOException, SyntaxException
  {
    Object localObject = peekToken();
    if ((localObject instanceof Reserved));
    switch (((Reserved)localObject).prio)
    {
    default:
      if (localObject == Lexer.eofToken)
        return eofExpr;
      break;
    case 31:
      return parseIfStatement();
    case 32:
      return parseWhileStatement();
    case 41:
      return parseFunctionDefinition();
    }
    if (localObject == Lexer.semicolonToken)
    {
      skipToken();
      return emptyStatement;
    }
    if (localObject == Lexer.lbraceToken)
      return parseBlock();
    Expression localExpression = parseExpression();
    getSemicolon();
    return localExpression;
  }

  public Expression parseUnaryExpression()
    throws IOException, SyntaxException
  {
    return parsePostfixExpression();
  }

  public Expression parseWhileStatement()
    throws IOException, SyntaxException
  {
    skipToken();
    Object localObject1 = getToken();
    if (localObject1 != Lexer.lparenToken)
      return syntaxError("expected '(' - got:" + localObject1);
    Expression localExpression = parseExpression();
    Object localObject2 = getToken();
    if (localObject2 != Lexer.rparenToken)
      return syntaxError("expected ')' - got:" + localObject2);
    return buildLoop(null, localExpression, null, parseStatement());
  }

  public Object peekToken()
    throws IOException, SyntaxException
  {
    if (this.token == null);
    for (this.token = this.lexer.getToken(); this.token == Lexer.eolToken; this.token = this.lexer.getToken())
      skipToken();
    return this.token;
  }

  public Object peekTokenOrLine()
    throws IOException, SyntaxException
  {
    if (this.token == null)
      this.token = this.lexer.getToken();
    return this.token;
  }

  public final void skipToken()
  {
    if (this.token != Lexer.eofToken)
    {
      this.previous_token = this.token;
      this.token = null;
    }
  }

  public Expression syntaxError(String paramString)
  {
    this.errors = (1 + this.errors);
    OutPort localOutPort = OutPort.errDefault();
    String str = this.port.getName();
    int i = 1 + this.port.getLineNumber();
    int j = 1 + this.port.getColumnNumber();
    if (i > 0)
    {
      if (str != null)
        localOutPort.print(str);
      localOutPort.print(':');
      localOutPort.print(i);
      if (j > 1)
      {
        localOutPort.print(':');
        localOutPort.print(j);
      }
      localOutPort.print(": ");
    }
    localOutPort.println(paramString);
    return new ErrorExp(paramString);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.ecmascript.Parser
 * JD-Core Version:    0.6.2
 */