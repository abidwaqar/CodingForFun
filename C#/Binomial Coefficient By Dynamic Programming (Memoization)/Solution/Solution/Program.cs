using System;
using System.Collections.Generic;

namespace Beast_Mode
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("N:");
            long N = long.Parse(Console.ReadLine());
            Console.Write("K:");
            long K = long.Parse(Console.ReadLine());

            Console.WriteLine("Binomial Coefficient is " + calculateBinomialCoefficient(N, K));
        }

        static Dictionary<string, long> memory = new Dictionary<string, long>();
        static long calculateBinomialCoefficient(long N, long K)
        {
            if (K > N)
            {
                return 0;
            }

            if (K == 0 || K == N)
            {
                return 1;
            }

            if (!memory.ContainsKey(N + "C" + K))
            {
                memory[N + "C" + K] = calculateBinomialCoefficient(N - 1, K - 1) + calculateBinomialCoefficient(N - 1, K);
            }

            return memory[N + "C" + K];
        }
    }
}