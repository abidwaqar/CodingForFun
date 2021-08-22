using System;
using System.Collections.Generic;
using System.Linq;

namespace Beast_Mode
{
    class Program
    {
        private const String IMPOSSIBLE = "IMPOSSIBLE";

        static String solveRecursively(String inputStr, int currentIndex, Dictionary<char, int> characterCount)
        {
            if (currentIndex == -1)
            {
                return "";
            }

            List<char> keys = characterCount.Keys.ToList();
            String resultStr = "";
            for (int i = 0; i< keys.Count; ++i)
            {
                if (inputStr[currentIndex] != keys[i] && characterCount[keys[i]] != 0)
                {
                    --characterCount[keys[i]];

                    resultStr = solveRecursively(inputStr, currentIndex - 1, characterCount);
                    if (resultStr != IMPOSSIBLE) return resultStr + keys[i];

                    ++characterCount[keys[i]];
                }
            }

            return IMPOSSIBLE;
        }
        static dynamic solve()
        {
            String inputStr = Console.ReadLine().ToLower();
            Dictionary<char, int> characterCount = new Dictionary<char, int>();

            for (int i = 0; i < inputStr.Length; ++i)
            {
                if (!characterCount.ContainsKey(inputStr[i])) characterCount.Add(inputStr[i], 1);
                else ++characterCount[inputStr[i]];
            }

            return solveRecursively(inputStr, inputStr.Length - 1, characterCount);
        }
        static void Main(string[] args)
        {
            long T = long.Parse(Console.ReadLine());

            for (int case_number = 1; case_number <= T; ++case_number)
            { 
                Console.WriteLine("Case #" + case_number + ": " + solve());
            }
        }
    }
}