using System.Collections.Generic;

namespace EvaluateRPN
{
    public static class EvaluateRPN
    {
        public static int evalRPN(string[] tokens)
        {
            if (tokens == null || tokens.Length == 0)
            {
                return 0;
            }

            Stack<string> stack = new Stack<string>();

            foreach (string token in tokens)
            {
                if (isOperator(token))
                {
                    string operand2 = stack.Pop();
                    string operand1 = stack.Pop();
                    int val = calculate(operand1, operand2, token);
                    stack.Push(val.ToString());
                }
                else
                {
                    stack.Push(token);
                }
            }

            return int.Parse(stack.Pop());
        }

        public static bool isOperator(string token)
        {
            if (token == null)
            {
                return false;
            }
            if (token=="+" || token == "-" || token=="*" || token=="/")
            {
                return true;
            }

            return false;
        }

        public static int calculate(string o1, string o2, string op)
        {
            if (op == "+")
            {
                return int.Parse(o1) + int.Parse(o2);
            }
            else if (op == "-")
            {
                return int.Parse(o1) - int.Parse(o2);
            }
            else if (op == "*")
            {
                return int.Parse(o1) * int.Parse(o2);
            }
            else
            {
                return int.Parse(o1) / int.Parse(o2);
            }
        }
    }
}
