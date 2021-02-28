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

            Console.WriteLine("Minimum operations to convert X to Y are " + calculateEditDistance(X, Y));
        }
        static int calculateEditDistance(String X, String Y)
        {
            int[,] table = new int[X.Length + 1, Y.Length + 1];

            // Calculating initial values
            for (int i = 0; i <= X.Length; i++)
            {
                table[i, 0] = i;
            }
            for (int j = 1; j <= Y.Length; j++)
            {
                table[0, j] = j;
            }

            // Calculating rest of the table
            for (int i = 1; i <= X.Length; i++)
            {
                for (int j = 1; j <= Y.Length; j++)
                {
                    if (X[i - 1] == Y[j - 1])
                    {
                        table[i, j] = table[i - 1, j - 1];
                    }
                    else
                    {
                        table[i, j] = Math.Min(Math.Min(table[i - 1, j], table[i, j - 1]), table[i - 1, j - 1]) + 1;
                    }
                }
            }

            return table[X.Length, Y.Length];
        }
    }
}