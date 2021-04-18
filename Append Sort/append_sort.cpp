#include <iostream>
#include <string>
#include <time.h>

using namespace std;

void solve(int case_number)
{
    int N;    
    cin >> N;

    int answer = 0;

    string *str_num_arr = new string[N];

    for (int i = 0; i < N; i++) cin >> str_num_arr[i];

    string prev, current, prev_substring, prev_extra_part;
    int non_nine_index;
    for (int i = 1; i < N; i++)
    {
        prev = str_num_arr[i - 1];
        current = str_num_arr[i];

        if (prev.length() < current.length() || (prev.length() == current.length() && prev < current));

        else if  (prev.length() == current.length() && prev >= current) {
            str_num_arr[i].append("0");
            ++answer;
        }

        else if (prev.length() > current.length()) {
            prev_substring = prev.substr(0, current.length());

            if (prev_substring < current) {
                for (int j = 0; j < (prev.length() - prev_substring.length()); j++)
                {
                    str_num_arr[i].append("0");
                    ++answer;
                }
            }

            else if (prev_substring > current) {
                for (int j = 0; j < (prev.length() - prev_substring.length()) + 1; j++)
                {
                    str_num_arr[i].append("0");
                    ++answer;
                }
            }

            else if (prev_substring == current) {
                prev_extra_part = prev.substr(current.length());
                non_nine_index = prev_extra_part.length() - 1;

                for (; non_nine_index >= 0 && prev_extra_part[non_nine_index] == '9'; non_nine_index--);

                if (non_nine_index == -1) {
                    str_num_arr[i].append("1");
                    ++answer;
                    for (int j = 0; j < prev_extra_part.length(); j++) {
                        str_num_arr[i].append("0");
                        ++answer;
                    }
                }
                else {
                    long number = stol(prev_extra_part.substr(non_nine_index));
                    ++number;
                    str_num_arr[i].append(prev_extra_part.substr(0, non_nine_index) + to_string(number));
                    answer += prev_extra_part.length();
                }
            }

            else {
                throw "Case out of logic";
            }
        }

        else {
            throw "Case out of logic";
        }
    }
    
    
    // for (int i = 0; i < N; i++) cout << str_num_arr[i] << " " ;
    // cout << endl;

    cout << "Case #" << case_number << ": " << answer << endl ;

    delete[] str_num_arr;
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