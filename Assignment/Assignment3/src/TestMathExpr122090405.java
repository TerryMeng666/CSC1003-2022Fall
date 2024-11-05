import java.util.*;

public class TestMathExpr
{
  private String  str;
  private boolean is_num;

  TestMathExpr(String str, boolean is_num)
  {
    this.str    = str;
    this.is_num = is_num;
  }

  public static double parse(String str)
  {
    int n                     = str.length();
    Stack<TestMathExpr> stk   = new Stack<TestMathExpr>();
    Stack<TestMathExpr> stk2  = new Stack<TestMathExpr>();
    

    for (int i = 0; i < n; )
    {
      if (Character.isDigit(str.charAt(i)) || str.charAt(i) == '.')
      {
        
        String tmp = new String("");
        for (; i < n && (Character.isDigit(str.charAt(i)) ||
              str.charAt(i) == '.'); ++i)
          tmp += str.charAt(i);

        if (!stk.empty())
        {
        
          if (stk.peek().str.equals("*")) {
            stk.pop();
            tmp = String.valueOf(Double.parseDouble(stk.pop().str) *
                Double.parseDouble(tmp));
          } else if (stk.peek().str.equals("/")) {
            stk.pop();
            tmp = String.valueOf(Double.parseDouble(stk.pop().str) /
                Double.parseDouble(tmp));
          }
        }

        stk.push(new TestMathExpr(tmp, true));
      }

      else if (Character.isAlphabetic(str.charAt(i)) || str.charAt(i) == '(')
      {
        
        String tmp = new String("");
        for (boolean mark = false; !mark && i < n &&
            (Character.isAlphabetic(str.charAt(i)) ||
             str.charAt(i) == '('); mark |= str.charAt(i++) == '(')
          tmp += str.charAt(i);
        stk.push(new TestMathExpr(tmp, false));
      }

      else if (str.charAt(i) == '-')
      {
        
        if (!stk.empty() && stk.peek().is_num)
          stk.push(new TestMathExpr("-", false));
        else {
          stk.push(new TestMathExpr("-1", true));
          stk.push(new TestMathExpr("*", false));
        }
        ++i;
      }

      else if (str.charAt(i) == '+' ||
          str.charAt(i) == '*' || str.charAt(i) == '/')
      {
        stk.push(new TestMathExpr(String.valueOf(str.charAt(i)), false));
        ++i;
      }

      else if (str.charAt(i) == ')')
      {
        while (!stk.empty() &&
            stk.peek().str.charAt(stk.peek().str.length() - 1) != '(')
          stk2.push(stk.pop());
       

        double tmp = Double.parseDouble(stk2.pop().str);

        while (!stk2.empty())
        {
          
          if (stk2.peek().str.equals("+")) {
            stk2.pop();
            tmp = tmp + Double.parseDouble(stk2.pop().str);
          } else if (stk2.peek().str.equals("-")) {
            stk2.pop();
            tmp = tmp - Double.parseDouble(stk2.pop().str);
          }
        }

        switch (stk.peek().str)
        {
          case "sin(":
            tmp = Math.sin(tmp);
            break;
          case "cos(":
            tmp = Math.cos(tmp);
            break;
          case "tan(":
            tmp = Math.tan(tmp);
            break;
          case "sqrt(":
            tmp = Math.sqrt(tmp);
            break;
          default:
            break;
        }
        stk.pop();

        if (!stk.empty())
        {
          
          if (stk.peek().str.equals("*")) {
            stk.pop();
            tmp = Double.parseDouble(stk.pop().str) * tmp;
          } else if (stk.peek().str.equals("/")) {
            stk.pop();
            tmp = Double.parseDouble(stk.pop().str) / tmp;
          }
        }

        stk.push(new TestMathExpr(String.valueOf(tmp), true));
        ++i;
      } else {
        ++i;
      }
    }

    while (!stk.empty())
      stk2.push(stk.pop());

    double ans = Double.parseDouble(stk2.pop().str);
    while (!stk2.empty())
    {
      if (stk2.peek().str.equals("+")) {
        stk2.pop();
        ans = ans + Double.parseDouble(stk2.pop().str);
      } else if (stk2.peek().str.equals("-")) {
        stk2.pop();
        ans = ans - Double.parseDouble(stk2.pop().str);
      }
    }

    return ans;
  }

  public static void main(String[] args) throws Exception
  {
    Scanner input = new Scanner(System.in);
    while (input.hasNextLine())
    {
      double result = parse(input.nextLine());
      System.out.println(String.valueOf(Math.round(result)));
    }
    return;
  }
}
