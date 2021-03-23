using System;
using System.Collections.Generic;

namespace Beast_Mode
{
    class Program
    {
        static void Main(string[] args)
        {
            long T = long.Parse(Console.ReadLine());
            long N, K;
            String[] line;
            String S;

            for (int i = 0; i < T; ++i)
            {
                line = Console.ReadLine().Split(' ');
                N = long.Parse(line[0]);
                K = long.Parse(line[1]);
                S = Console.ReadLine();

                Console.WriteLine("Case #" + (i + 1) + ": " + operationsToConvertKGoodnessValue(N, K, S));
            }
        }

        static long operationsToConvertKGoodnessValue(long lengthOfString, long expectedKGoodnessValue, String actualString)
        {
            long kGoodnessValue = 0;
            for (int i = 0; i < lengthOfString/2; i++)
            {
                if (actualString[i] != actualString[(int)(lengthOfString - i - 1)])
                {
                    ++kGoodnessValue;
                }
            }

            long result = expectedKGoodnessValue - kGoodnessValue;

            return result < 0 ? result * -1 : result;
        }
    }
}