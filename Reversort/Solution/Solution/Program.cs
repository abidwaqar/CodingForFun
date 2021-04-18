using System;
using System.Collections.Generic;

namespace Beast_Mode
{
    class Program
    {
        static void Main(string[] args)
        {
            long[] L;
            String[] line;
            long N;
            long T = long.Parse(Console.ReadLine());
            for (int i = 0; i < T; ++i)
            {
                N = long.Parse(Console.ReadLine());
                L = new long[N];
                line = Console.ReadLine().Split(' ');
                for (int j = 0; j < N; j++)
                {
                    L[j] = long.Parse(line[j]);
                }

                Console.WriteLine("Case #" + (i + 1) + ": " + reversortCost(N, L));
            }
        }

        static long reversortCost(long N, long[] L)
        {
            long j = 0;
            long cost_of_reverse_sort = 0;
            for (long i = 0; i < N - 1; i++)
            {
                j = getMinValueIndex(L, i, N);
                reverseArray(L, i, j);
                cost_of_reverse_sort += j - i + 1;
            }
            return cost_of_reverse_sort;
        }

        static long getMinValueIndex(long[] L, long starting_index, long ending_index)
        {
            long min_value = L[starting_index];
            long min_index = starting_index;
            for (long i = starting_index + 1; i < ending_index; i++)
            {
                if (min_value > L[i])
                {
                    min_value = L[i];
                    min_index = i;
                }
            }
            return min_index;
        }

        static void reverseArray(long[] L, long starting_index, long ending_index)
        {
            long temp;
            long start_end_gap = ending_index - starting_index + 1;
            while (starting_index < ending_index)
            {
                temp = L[starting_index];
                L[starting_index] = L[ending_index];
                L[ending_index] = temp;
                ++starting_index;
                --ending_index;
            }
        }
    }
}