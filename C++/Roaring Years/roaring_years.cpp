#include <iostream>
#include <string>
#include <map>
// #include <time.h>

using namespace std;

map<string, bool> isRoaringYearMemory = {};
bool isRoaringYear(string year){
    if (isRoaringYearMemory.count(year) > 0){
        return isRoaringYearMemory[year];
    }

    bool isRoaringNumber;
    for (int i = 1; i <= year.size()/2; i++)
    {
        int dynamic_i = i;
        isRoaringNumber = true;
        int expected_next_number_int = stoi(year.substr(0, i)) + 1;
        string expected_next_number_str = to_string(expected_next_number_int);

        int j = dynamic_i;
        for (; j < year.size(); j += dynamic_i)
        {
            if (expected_next_number_str != year.substr(j, expected_next_number_str.size())){
                isRoaringNumber = false;
                break;
            }
            else {
                if (expected_next_number_str.size() != dynamic_i)
                    dynamic_i = dynamic_i + 1;
                expected_next_number_int = stoi(year.substr(j, dynamic_i)) + 1;
                expected_next_number_str = to_string(expected_next_number_int);
            }
        }

        if (isRoaringNumber == true) {
            break;
        }
    }
    
    isRoaringYearMemory[year] = isRoaringNumber;
    return isRoaringYearMemory[year];
}

void solve(int case_number)
{
    int Y;    
    cin >> Y;

    int answer;

    for (int i = Y + 1 ; ; i++) {
        if (isRoaringYear(to_string(i))){
            cout << "Case #" << case_number << ": " << i << endl;
            break;
        }
    }
}

int main(int argc, char** argv) 
{
    // clock_t start_time = clock();

    int T;
    cin >> T;
    for (int i = 1; i <= T; ++i) {
        solve(i);
    }

    // cout << "\n" << "Execution time: " << (clock() - start_time)/CLOCKS_PER_SEC << endl;

    return 0;
}