using System;
using System.Collections.Generic;

namespace Beast_Mode
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("X:");
            String X = Console.ReadLine();
            Console.Write("Y:");
            String Y = Console.ReadLine();

            Console.WriteLine("The length of LCS is " + findLongestCommonSubSequenceCount(X, Y));
        }

        static Dictionary<string, int> memory = new Dictionary<string, int>();
        static int findLongestCommonSubSequenceCount(String X, String Y)
        {
            if (X.Length == 0 || Y.Length == 0)
            {
                return 0;
            }

            if (memory.ContainsKey(X + "|" + Y))
            {
                return memory[X + "|" + Y];
            }

            if (X[X.Length - 1] == Y[Y.Length - 1])
            {
                memory[X + "|" + Y] = findLongestCommonSubSequenceCount(X.Substring(0, X.Length - 1), Y.Substring(0, Y.Length - 1)) + 1;
                return memory[X + "|" + Y];
            }
            else
            {

                memory[X + "|" + Y] = Math.Max(findLongestCommonSubSequenceCount(X.Substring(0, X.Length - 1), Y),
                    findLongestCommonSubSequenceCount(X, Y.Substring(0, Y.Length - 1)));
                return memory[X + "|" + Y];
            }
        }
    }
}