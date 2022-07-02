using System;
using System.Collections.Generic;

namespace Beast_Mode
{
    class Program
    {
        static void Main(string[] args)
        {
            long T = long.Parse(Console.ReadLine());
            long R, C;
            String[] line;

            for (int i = 0; i < T; ++i)
            {
                line = Console.ReadLine().Split(' ');
                R = long.Parse(line[0]);
                C = long.Parse(line[1]);

                int[,] grid = new int[R, C];
                for (int j = 0; j < R; j++)
                {
                    line = Console.ReadLine().Split(' ');
                    for (int k = 0; k < C; k++)
                    {
                        grid[j, k] = int.Parse(line[k]);
                    }
                }

                Console.WriteLine("Case #" + (i + 1) + ": " + countGridLShapes(R, C, grid));
            }
        }

        static long countGridLShapes(long rows, long columns, int[,] grid)
        {
            long lCount = 0, reverse_i, reverse_j;

            int[,] up_grid = new int[rows, columns];
            int[,] right_grid = new int[rows, columns];
            int[,] down_grid = new int[rows, columns];
            int[,] left_grid = new int[rows, columns];

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < columns; j++)
                {
                    // Up
                    if (i == 0)
                        up_grid[i, j] = grid[i, j];
                    else if (grid[i, j] != 0)
                        up_grid[i, j] = up_grid[i - 1, j] + 1;
                    else
                        up_grid[i, j] = 0;

                    // left
                    if (j == 0)
                        left_grid[i, j] = grid[i, j];
                    else if (grid[i, j] != 0)
                        left_grid[i, j] = left_grid[i , j - 1] + 1;
                    else
                        left_grid[i, j] = 0;

                    reverse_i = rows - i - 1;
                    reverse_j = columns - j - 1;

                    // Down
                    if (reverse_i == rows - 1)
                        down_grid[reverse_i, reverse_j] = grid[reverse_i, reverse_j];
                    else if (grid[reverse_i, reverse_j] != 0)
                        down_grid[reverse_i, reverse_j] = down_grid[reverse_i + 1, reverse_j] + 1;
                    else
                        down_grid[reverse_i, reverse_j] = 0;

                    // Right
                    if (reverse_j == columns - 1)
                        right_grid[reverse_i, reverse_j] = grid[reverse_i, reverse_j];
                    else if (grid[reverse_i, reverse_j] != 0)
                        right_grid[reverse_i, reverse_j] = right_grid[reverse_i, reverse_j + 1] + 1;
                    else
                        right_grid[reverse_i, reverse_j] = 0;
                }
            }

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < columns; j++)
                {
                    if (grid[i, j] != 0)
                        lCount += countLShapedPlots(up_grid[i, j], right_grid[i, j], down_grid[i, j], left_grid[i, j]);
                }
            }

            return lCount;
        }
        static long countLShapedPlots(long up, long right, long down, long left)
        {
            long lCount = Math.Min(up / 2, right) + Math.Min(up, right / 2) + Math.Min(up / 2, left) + Math.Min(up, left / 2) +
                Math.Min(down / 2, right) + Math.Min(down, right / 2) + Math.Min(down / 2, left) + Math.Min(down, left / 2);
            if (up > 1) lCount -= 2;
            if (right > 1) lCount -= 2;
            if (down > 1) lCount -= 2;
            if (left > 1) lCount -= 2;
            return lCount;
        }
    }
}