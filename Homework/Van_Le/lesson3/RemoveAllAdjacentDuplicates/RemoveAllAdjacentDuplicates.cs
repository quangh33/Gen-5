using System;
using System.Collections.Generic;

namespace RemoveAllAdjacentDuplicates
{
    public class RemoveAllAdjacentDuplicates
    {
        public string RemoveDuplicates(string s)
        {
            if (s.Length == 0)
                return "";

            Stack<char> charStack = new Stack<Char>();

            foreach (char ch in s)
            {
                if (charStack.Count == 0)
                {
                    charStack.Push(ch);
                    continue;
                }

                if (charStack.Peek() == ch)
                    charStack.Pop();
                else
                    charStack.Push(ch);
            }

            char[] charArray = new char[charStack.Count];

            while (charStack.Count > 0)
            {
                charArray[charStack.Count - 1] = charStack.Pop();
            }

            return new string(charArray);
        }
    }
}
