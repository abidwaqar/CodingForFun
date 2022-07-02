using System;
using System.Collections.Generic;

namespace Beast_Mode
{
    class Program
    {
        static void Main(string[] args)
        {
            int T = int.Parse(Console.ReadLine());
            long N, K, S;
            string[] inputArr = new string[3];

            for (int i = 0; i < T; ++i)
            {
                inputArr = Console.ReadLine().Split(' ');
                N = long.Parse(inputArr[0]);
                K = long.Parse(inputArr[1]);
                S = long.Parse(inputArr[2]);
                Console.WriteLine("Case #" + (i + 1) + ": " + gameCompletingTime(N, K, S));
            }
        }

        static long gameCompletingTime(long N, long K, long S)
        {
            long option1_time = (K - 1) + (K - S) + (N - S + 1);
            long option2_time = (K - 1) + 1 + N;
            return option1_time < option2_time ? option1_time : option2_time;
        }
    }
}
