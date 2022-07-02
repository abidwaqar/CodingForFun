using System;
using System.Collections.Generic;

namespace Beast_Mode
{
    class Program
    {
        static void Main(string[] args)
        {
            long T = long.Parse(Console.ReadLine());
            long L, R;
            String[] line;

            for (int i = 0; i < T; ++i)
            {
                line = Console.ReadLine().Split(' ');
                L = long.Parse(line[0]);
                R = long.Parse(line[1]);

                Console.WriteLine("Case #" + (i + 1) + ": " + boringNumbersInRange(L, R));
            }
        }

        static long boringNumbersInRange(long L, long R)
        {
            if (L > R)
            {
                throw new Exception("L cannot be greater than R");
            }
            return calculateBoringNumberFromZero(R) - calculateBoringNumberFromZero(L - 1);
        }

        static long calculateBoringNumberFromZero(long num)
        {
            if (num <= 0)
            {
                return 0;
            }

            int numberOfDigitsInNumber = (int)Math.Log10(num) + 1;

            long numberOfBoringNumbersInRange = 0;
            for (int i = 1; i < numberOfDigitsInNumber; ++i)
            {
                numberOfBoringNumbersInRange += (long)Math.Pow(5, i);
            }

            long tempNumber;
            for (int i = 1; i <= numberOfDigitsInNumber; ++i)
            {
                if (i > 1)
                {
                    tempNumber = num % (long)Math.Pow(10, numberOfDigitsInNumber - i + 2);
                    tempNumber = tempNumber / (long)Math.Pow(10, numberOfDigitsInNumber - i + 1);
                    if ((i - 1) % 2 != tempNumber % 2)
                        break;
                }
                if (i % 2 != 0)
                {
                    tempNumber = num % (long)Math.Pow(10, numberOfDigitsInNumber - i + 1);
                    tempNumber = tempNumber / (long)Math.Pow(10, numberOfDigitsInNumber - i);
                    numberOfBoringNumbersInRange += (calculateOneDigitBoringNumberFromZero((int)tempNumber - 1) * (long)Math.Pow(5, numberOfDigitsInNumber - i));
                }
                else
                {
                    tempNumber = num % (long)Math.Pow(10, numberOfDigitsInNumber - i + 1);
                    tempNumber = tempNumber / (long)Math.Pow(10, numberOfDigitsInNumber - i);
                    numberOfBoringNumbersInRange += (calculateOneDigitNonBoringNumberFromZero((int)tempNumber - 1) * (long)Math.Pow(5, numberOfDigitsInNumber - i));
                }
            }

            return numberOfBoringNumbersInRange + (numberIsBoringNumber(num) ? 1 : 0);
        }

        static int calculateOneDigitBoringNumberFromZero(int num)
        {
            if (num <= 0)
            {
                return 0;
            }
            else if (num <= 2)
            {
                return 1;
            }
            else if (num <= 4)
            {
                return 2;
            }
            else if (num <= 6)
            {
                return 3;
            }
            else if (num <= 8)
            {
                return 4;
            }
            else if (num == 9)
            {
                return 5;
            }
            else
            {
                throw new Exception("Number is greater than 9");
            }
        }

        static int calculateOneDigitNonBoringNumberFromZero(int num)
        {
            if (num < 0)
            {
                return 0;
            }
            else if (num <= 1)
            {
                return 1;
            }
            else if (num <= 3)
            {
                return 2;
            }
            else if (num <= 5)
            {
                return 3;
            }
            else if (num <= 7)
            {
                return 4;
            }
            else if (num <= 9)
            {
                return 5;
            }
            else
            {
                throw new Exception("Number is greater than 9");
            }
        }
        static bool numberIsBoringNumber(long num)
        {
            int numberOfDigitsInNumber = (int)Math.Log10(num) + 1;
            long tempNumber;
            for (int i = 1; i <= numberOfDigitsInNumber; ++i)
            {
                tempNumber = num % (long)Math.Pow(10, numberOfDigitsInNumber - i + 1);
                tempNumber = tempNumber / (long)Math.Pow(10, numberOfDigitsInNumber - i);
                if ((i % 2 != 0 && tempNumber % 2 == 0) || (i % 2 == 0 && tempNumber % 2 != 0))
                {
                    return false;
                }
            }
            return true;
        }
    }
}