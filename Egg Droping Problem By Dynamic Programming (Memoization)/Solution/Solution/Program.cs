using System;
using System.Collections.Generic;

namespace Beast_Mode
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Eggs:");
            long eggs = long.Parse(Console.ReadLine());
            Console.Write("Floors:");
            long floors = long.Parse(Console.ReadLine());

            Console.WriteLine("Egg drops needed: " + calculateEggDrops(eggs, floors));
        }

        static long[,] memory;
        static long calculateEggDrops(long eggs, long floors)
        {
            if (memory == null)
            {
                memory = new long[eggs + 1, floors + 1];
                for (int i = 1; i <= eggs; i++)
                {
                    for (int j = 1; j <= floors; j++)
                    {
                        if (i == 1)
                        {
                            memory[i, j] = j;
                        }
                        else if (j == 1 || j == 0)
                        {
                            memory[i, j] = j;
                        }
                        else
                        {
                            memory[i, j] = -1;
                        }
                    }
                }
            }

            if (memory[eggs, floors] == -1)
            {
                long current_value, smallest_value = Math.Max(calculateEggDrops(eggs, floors - 1), calculateEggDrops(eggs - 1, 0));
                for (int i = 2; i <= floors; i++)
                {
                    current_value = Math.Max(calculateEggDrops(eggs, floors - i), calculateEggDrops(eggs - 1, i - 1));
                    if (current_value < smallest_value)
                    {
                        smallest_value = current_value;
                    }
                }

                memory[eggs, floors] = smallest_value + 1;
            }

            return memory[eggs, floors];
        }
    }
}