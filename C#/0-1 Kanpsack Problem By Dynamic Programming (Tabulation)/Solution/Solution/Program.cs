using System;
using System.Collections.Generic;

namespace Beast_Mode
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Input length of weight and value array:");
            long arr_length = long.Parse(Console.ReadLine());
            long[] weight_arr = new long[arr_length];
            long[] value_arr = new long[arr_length];

            for (int i = 0; i < arr_length; i++)
            {
                Console.Write("Input weight and its corresponding value seperated by space:");
                String[] input = Console.ReadLine().Split(' ');
                weight_arr[i] = long.Parse(input[0]);
                value_arr[i] = long.Parse(input[1]);
            }

            Console.Write("Input knapsack max holding weight:");
            long max_weight = long.Parse(Console.ReadLine());

            (long max_value, List<long> selected_weights) = findKnapsackMaxValueAndWeightsSelection(arr_length, weight_arr, value_arr, max_weight);

            Console.WriteLine("Max value " + max_value);
            Console.Write("Selected weights ");
            for (int i = 0; i < selected_weights.Count; i++)
            {
                Console.Write(selected_weights[i] + " ");
            }
            Console.WriteLine();
        }

        static (long, List<long>) findKnapsackMaxValueAndWeightsSelection(long arr_length, long[] weight_arr, long[] value_arr, long max_weight)
        {
            long[,] knapsack_table = new long[arr_length + 1, max_weight + 1];

            for (int i = 0; i <= arr_length; i++)
            {
                for (int j = 0; j <= max_weight; j++)
                {
                    if (i == 0 || j == 0)
                    {
                        knapsack_table[i, j] = 0;
                    }
                    else if (j - weight_arr[i - 1] < 0)
                    {
                        knapsack_table[i, j] = knapsack_table[i - 1, j];
                    }
                    else
                    {
                        knapsack_table[i, j] = Math.Max(knapsack_table[i - 1, j - weight_arr[i - 1]] + value_arr[i - 1], knapsack_table[i - 1, j]);
                    }
                }
            }

            long current_value = knapsack_table[arr_length, max_weight];
            List<long> selected_weights = new List<long>();

            long _j = max_weight;
            for (long i = arr_length; i > 0; --i)
            {
                if (knapsack_table[i, _j] > knapsack_table[i - 1, _j])
                {
                    selected_weights.Add(weight_arr[i - 1]);
                    _j -= weight_arr[i - 1];
                }
            }

            return (knapsack_table[arr_length, max_weight], selected_weights);
        }
    }
}