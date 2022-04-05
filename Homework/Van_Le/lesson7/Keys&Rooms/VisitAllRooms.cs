namespace LeetCodeSolutions
{
    public static class VisitAllRooms
    {
        public static bool CanVisitAllRooms(IList<IList<int>> rooms)
        {
            bool[] seen = new bool[rooms.Count];
            seen[0] = true;
            Stack<int> stack = new Stack<int>();
            stack.Push(0);

            while (stack.Count != 0)
            {
                int node = stack.Pop();

                foreach (var key in rooms[node])
                {
                    if (!seen[key])
                    {
                        seen[key] = true;
                        stack.Push(key);
                    }
                }
            }

            foreach (var partialSeen in seen)
            {
                if (!partialSeen) return false;
            }
            return true;
        }
    }
}