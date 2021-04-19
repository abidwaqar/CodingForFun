#include <iostream>
#include <string>

using namespace std;

void solve(int case_number)
{
    int N;    
    cin >> N;

    string str;
    cin >> str;

    int count = 1;
    cout << "Case #" << case_number << ": " << count;

    for (int i = 1; i < N; i++)
    {
        if (str[i - 1] < str[i]) ++count;
        else count = 1;
        cout << " " << count;
    }
    cout << endl;
}

int main(int argc, char** argv) 
{
    int T;
    cin >> T;
    for (int i = 1; i <= T; ++i) {
        solve(i);
    }

    return 0;
}