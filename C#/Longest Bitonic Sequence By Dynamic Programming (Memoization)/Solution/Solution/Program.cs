using System;
using System.Collections.Generic;

namespace Beast_Mode
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Length:");
            long length = long.Parse(Console.ReadLine());
            long[] arr = new long[length];
            for (int i = 0; i < length; i++)
            {
                Console.Write("Input element: ");
                arr[i] = long.Parse(Console.ReadLine());
            }

            Console.WriteLine("The length of LBS is " + findLongestBitonicSubSequenceCount(arr, length));
        }

        /*Slope == true means increasing and vice versa*/
        static long findLongestBitonicSubSequenceCount(long[] arr, long length)
        {
            if (length == 0) return 0;

            // Longest increasing subsequence
            int[] lis = new int[length];
            for (int i = 1; i < length; ++i)
            {
                lis[i] = 1;
            }

            for (int i = 1; i < length; i++)
            {
                for (int j = 0; j < i; j++)
                {
                    if (arr[j] < arr[i]) lis[i] = Math.Max(lis[j] + 1, lis[i]);
                }
            }


            // Longest decreasing subsequence
            int[] lds = new int[length];
            for (int i = 1; i < length; i++)
            {
                lds[i] = 1;
            }

            for (long i = length - 2; i >= 0; --i)
            {
                for (long j = length - 1; j > i; --j)
                {
                    if (arr[j] < arr[i]) lds[i] = Math.Max(lds[j] + 1, lds[i]);
                }
            }

            long max = lis[0] + lds[0];
            for (int i = 1; i < length; i++)
            {
                if (max < lis[i] + lds[i])
                {
                    max = lis[i] + lds[i];
                }
            }

            return max;
        }
    }
}