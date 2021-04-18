using System;
using System.Collections.Generic;

namespace Beast_Mode
{
    class Program
    {
        static void Main(string[] args)
        {
            long X, Y;
            String mural;
            String[] line;
            long T = long.Parse(Console.ReadLine());
            for (int i = 0; i < T; ++i)
            {
                line = Console.ReadLine().Split(' ');
                X = long.Parse(line[0]);
                Y = long.Parse(line[1]);
                mural = line[2];

                Console.WriteLine("Case #" + (i + 1) + ": " + minCopyrightCost(X, Y, mural));
            }
        }

        static long minCopyrightCost(long X, long Y, string mural)
        {
            if (X < 0 || Y < 0)
            {
                return minCopyrightCostRecursive(X, Y, mural);
            }

            mural = mural.Replace("?", "");
            return X * System.Text.RegularExpressions.Regex.Matches(mural, "CJ").Count + Y * System.Text.RegularExpressions.Regex.Matches(mural, "JC").Count;
        }

        static long minCopyrightCostRecursive(long X, long Y, string mural)
        {
            if (mural.Length <= 1)
            {
                return 0;
            }

            if (mural[0] == '?')
            {
                string str1 = "J" + mural.Substring(1);
                string str2 = "C" + mural.Substring(1);
                return Math.Min(minCopyrightCostRecursive(X, Y, str1), minCopyrightCostRecursive(X, Y, str2));
            }
            else if (mural[1] == '?')
            {
                string str1 = mural[0] + "J" + mural.Substring(2);
                string str2 = mural[0] + "C" + mural.Substring(2);
                return Math.Min(minCopyrightCostRecursive(X, Y, str1), minCopyrightCostRecursive(X, Y, str2));
            }
            else if (mural[0] == mural[1])
            {
                return minCopyrightCostRecursive(X, Y, mural.Substring(1));
            }
            else if (string.Format("{0}{1}", mural[0], mural[1]) == "CJ")
            {
                return X + minCopyrightCostRecursive(X, Y, mural.Substring(1));
            }
            else if (string.Format("{0}{1}", mural[0], mural[1]) == "JC")
            {
                return Y + minCopyrightCostRecursive(X, Y, mural.Substring(1));
            }

            throw new Exception("minCopyrightCostRecursive unexpected code flow");
        }
    }
}