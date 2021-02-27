using System;
using System.Collections.Generic;

namespace Beast_Mode
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Length of array: ");
            int arrayLength = int.Parse(Console.ReadLine());
            int[] array = new int[arrayLength];
            for (int i = 0; i < arrayLength; i++)
            {
                Console.Write("Input " + (i + 1) + ": ");
                array[i] = int.Parse(Console.ReadLine());
            }

            Console.WriteLine("The length of LIS is " + findLongestIncreasingSubSequenceCount(array, arrayLength));
        }

        static int findLongestIncreasingSubSequenceCount(int[] array, int arrayLength)
        {
            int[] LIS = new int[arrayLength];
            for (int i = 0; i < arrayLength; i++)
            {
                LIS[i] = 1;
            }

            for (int i = 1; i < arrayLength; i++)
            {
                for (int j = 0; j <= i - 1; j++)
                {
                    if (array[i] > array[j])
                    {
                        LIS[i] = Math.Max(LIS[i], LIS[j] + 1);
                    }
                }
            }

            int max = LIS[0];
            for (int i = 1; i < arrayLength; i++)
            {
                max = Math.Max(max, LIS[i]);
            }
            return max;
        }
    }
}