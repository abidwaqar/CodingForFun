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

            Console.WriteLine("LCS is " + findLongestCommonSubSequence(X, Y));
        }
        static String findLongestCommonSubSequence(String X, String Y)
        {
            int[,] table = new int[X.Length + 1, Y.Length + 1];

            // Assigning 0 to initial indices
            for (int i = 0; i <= X.Length; i++)
            {
                for (int j = 0; j <= Y.Length; j++)
                {
                    table[i,j] = 0;
                }
            }

            // Calculating the whole table
            for (int j = 1; j <= Y.Length; j++)
            {
                for (int i = 1; i <= X.Length; i++)
                {
                    if (Y[j - 1] != X[i - 1])
                    {
                        table[i, j] = Math.Max(table[i - 1, j], table[i, j - 1]);
                    }
                    else
                    {
                        table[i, j] = table[i - 1, j - 1] + 1;
                    }
                }
            }

            // Traversing back the table to store the longest subsequence
            int xi = X.Length, yj = Y.Length;
            String LCS = "";
            while (xi > 0 && yj > 0)
            {
                if (table[xi, yj] > Math.Max(table[xi, yj - 1], table[xi - 1, yj]))
                {
                    LCS = X[xi - 1] + LCS;
                    xi -= 1;
                    yj -= 1;
                }
                else if (table[xi, yj] == table[xi, yj - 1])
                {
                    yj -= 1;
                }
                else if (table[xi, yj] == table[xi - 1, yj])
                {
                    xi -= 1;
                }
            }

            return LCS;
        }
    }
}