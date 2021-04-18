using System;
using System.Collections.Generic;

namespace Beast_Mode
{
    class Program
    {
        static void Main(string[] args) 
        {
            String[] line;
            long N, C;
            long T = long.Parse(Console.ReadLine());
            for (int i = 0; i < T; ++i)
            {
                line = Console.ReadLine().Split(' ');
                N = long.Parse(line[0]);
                C = long.Parse(line[1]);

                try
                {
                    long[] reversort_arr = reversortEngineering(N, C);
                    Console.Write("Case #" + (i + 1) + ": ");
                    for (int j = 0; j < reversort_arr.Length; j++)
                    {
                        Console.Write(reversort_arr[j]);
                        if (j != reversort_arr.Length - 1)
                        {
                            Console.Write(" ");
                        }
                    }
                    Console.WriteLine();
                }
                catch (Exception e)
                {
                    Console.WriteLine("Case #" + (i + 1) + ": " + e.Message);
                }
            }
        }

        static long[] reversortEngineering(long N, long C)
        {
            long[] L = new long[N];
            for (int i = 1; i <= N; i++)
            {
                L[i - 1] = i;
            }

            if ((N - 1) > C)
            {
                throw new Exception("IMPOSSIBLE");
            }

            int start_border = 0;
            int end_border = (int)N - 1;
            long summation = N;
            long old_summation = summation;
            bool parity = true;

            for (int i = 0; i < N; i++)
            {
                old_summation = summation;
                summation += N - i - 1;
                if (C >= (summation - 1))
                {
                    reverseArray(L, start_border, end_border);
                    if (parity)
                    {
                        --end_border;
                    }
                    else
                    {
                        ++start_border;
                    }
                    parity = !parity;
                }
                else
                {
                    if (parity)
                    {
                        reverseArray(L, end_border - (C - old_summation + 1), end_border);
                    }
                    else
                    {
                        reverseArray(L, start_border, start_border + (C - old_summation + 1));
                    }
                    return L;
                }
            }
            if (summation - 1 == C)
            {
                return L;
            }

            throw new Exception("IMPOSSIBLE");
        }

        static void reverseArray(long[] L, long starting_index, long ending_index)
        {
            long temp;
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