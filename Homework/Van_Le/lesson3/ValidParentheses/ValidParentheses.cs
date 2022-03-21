using System.Collections.Generic;
using System.Linq;

namespace ValidParentheses
{
	public static class ValidParentheses
    {
		public static bool isValid(string s)
		{
			if (s == null || s.Length == 0)
			{
				return false;
			}
			Stack<char> stack = new Stack<char>();
			for (int i = 0; i < s.Length; i++)
			{
				char currentChar = s[i];
				if (currentChar == '(' || currentChar == '{' || currentChar == '[')
				{
					stack.Push(currentChar);
				}
				else
				{
					if (stack.Count() == 0)
					{
						return false;
					}
					if (!isMatch(stack.Pop(), currentChar))
					{
						return false;
					}
				}
			}
			if (stack.Count() != 0)
			{
				return false;
			}
			return true;
		}

		public static bool isMatch(char open, char close)
		{
			if (open == '(' && close != ')')
			{
				return false;
			}
			if (open == '[' && close != ']')
			{
				return false;
			}
			if (open == '{' && close != '}')
			{
				return false;
			}
			return true;
		}
	}
}
