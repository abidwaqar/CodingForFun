using System;
using System.Collections.Generic;

namespace Beast_Mode
{
    class Program
    {
        static void Main(string[] args)
        {
            long N, a, b, c;
            long[,] N_arr; 
            String[] line;
            long T = long.Parse(Console.ReadLine());
            for (int i = 0; i < T; ++i)
            {
                N = long.Parse(Console.ReadLine());
                N_arr = new long[N, N];
                for (int j = 0; j < N; j++)
                {
                    line = Console.ReadLine().Split(' ');
                    for (int k = 0; k < N; k++)
                    {
                        N_arr[j, k] = long.Parse(line[k]);
                    }
                }

                (a, b, c) = vestigium(N, N_arr);
                Console.WriteLine("Case #" + (i + 1) + ": " + a + " " + b + " " + c);
            }
        }

        static (long, long , long) vestigium(long N, long[,] N_arr)
        {
            long trace_sum = 0, wrong_row = 0, wrong_col = 0;
            long[,] col_arr = new long[N,N];
            long[,] row_arr = new long[N,N];

            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if (i == j)
                        trace_sum += N_arr[i, j];
                    ++col_arr[j, N_arr[i, j] - 1];
                    ++row_arr[i, N_arr[i, j] - 1];
                }
            }

            bool row_flag, col_flag;
            for (int i = 0; i < N; i++)
            {
                row_flag = false;
                col_flag = false;
                for (int j = 0; j < N; j++)
                {
                    if (col_arr[i, j] != 1)
                        col_flag = true;
                    if (row_arr[i, j] != 1)
                        row_flag = true;
                }
                if (row_flag)
                    ++wrong_row;
                if (col_flag)
                    ++wrong_col;
            }

            return (trace_sum, wrong_row, wrong_col);
        }
    }
}