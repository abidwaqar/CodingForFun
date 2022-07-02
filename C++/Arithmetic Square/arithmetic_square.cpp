#include <iostream>
#include <string>
// #include <time.h>

using namespace std;

void solve(int case_number)
{
    int inputArr[3][3];

    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            if (i == 1 && j == 1)
                continue;
            cin >> inputArr[i][j];
        }
    }

    double middleNumbers[4];
    int index = 0;
    if ((inputArr[0][0] + inputArr[2][2]) % 2 == 0)
    {
        middleNumbers[index++] = (inputArr[0][0] + inputArr[2][2]) / 2;
    }
    if ((inputArr[1][0] + inputArr[1][2]) % 2 == 0)
    {
        middleNumbers[index++] = (inputArr[1][0] + inputArr[1][2]) / 2;
    }
    if ((inputArr[2][0] + inputArr[0][2]) % 2 == 0)
    {
        middleNumbers[index++] = (inputArr[2][0] + inputArr[0][2]) / 2;
    }
    if ((inputArr[2][1] + inputArr[0][1]) % 2 == 0)
    {
        middleNumbers[index++] = (inputArr[2][1] + inputArr[0][1]) / 2;
    }

    int mostFrequentNumber = 0;
    int maxFrequency = 0, frequency;
    for (int i = 0; i < index; i++)
    {
        frequency = 0;
        for (int j = 0; j < index; j++)
        {
            if (middleNumbers[i] == middleNumbers[j])
                ++frequency;
        }
        if (maxFrequency < frequency)
        {
            maxFrequency = frequency;
            mostFrequentNumber = middleNumbers[i];
        }
    }

    inputArr[1][1] = mostFrequentNumber;

    int answer = 0;

    if ((inputArr[0][0] + inputArr[0][2]) == 2 * inputArr[0][1])
        ++answer;
    if ((inputArr[1][0] + inputArr[1][2]) == 2 * inputArr[1][1])
        ++answer;
    if ((inputArr[2][0] + inputArr[2][2]) == 2 * inputArr[2][1])
        ++answer;
    if ((inputArr[0][0] + inputArr[2][0]) == 2 * inputArr[1][0])
        ++answer;
    if ((inputArr[0][1] + inputArr[2][1]) == 2 * inputArr[1][1])
        ++answer;
    if ((inputArr[0][2] + inputArr[2][2]) == 2 * inputArr[1][2])
        ++answer;
    if ((inputArr[0][0] + inputArr[2][2]) == 2 * inputArr[1][1])
        ++answer;
    if ((inputArr[2][0] + inputArr[0][2]) == 2 * inputArr[1][1])
        ++answer;

    cout << "Case #" << case_number << ": " << answer << endl;
}

int main(int argc, char **argv)
{
    // clock_t start_time = clock();

    int T;
    cin >> T;
    for (int i = 1; i <= T; ++i)
    {
        solve(i);
    }

    // cout << "\n" << "Execution time: " << (clock() - start_time)/CLOCKS_PER_SEC << endl;

    return 0;
}