# Increasing Substring

### Problem

Your friend John just came back from vacation, and he would like to share with you a new property that he learned about strings.

John learned that a string CC of length LL consisting of uppercase English characters is strictly increasing if, for every pair of indices ii and jj such that 1≤i<j≤L1≤i<j≤L (11-based), the character at position ii is smaller than the character at position jj.

For example, the strings `ABC` and `ADF` are strictly increasing, however the strings `ACC` and `FDA` are not.

Now that he taught you this new exciting property, John decided to challenge you: given a string SS of length NN, you have to find out, for every position 1≤i≤N1≤i≤N, what is the length of the longest strictly increasing [substring](https://en.wikipedia.org/wiki/Substring) that ends at position ii.

### Input

The first line of the input gives the number of test cases, TT. TT test cases follow.

Each test case consists of two lines.

The first line contains an integer NN, representing the length of the string.

The second line contains a string SS of length NN, consisting of uppercase English characters.

### Output

For each test case, output one line containing `Case #xx: y1y1 y2y2 ... ynyn`, where xx is the test case number (starting from 1) and yiyi is the length of the longest strictly increasing substring that ends at position ii.

### Limits

Memory limit: 1 GB.
1≤T≤1001≤T≤100.

#### Test Set 1

Time limit: 20 seconds.
1≤N≤1001≤N≤100.

#### Test Set 2

Time limit: 40 seconds.
1≤N≤2×1051≤N≤2×105.

### Sample

Sample Input

[*save_alt*](https://codejam.googleapis.com/dashboard/get_file/AQj_6U01OfJGjsrEzYxovpUpNN5L4x8dvde0MVqcTxpOiGehjIyVkpPM7VJLrCTdV8SLilcjWNybFgrZN8uzJaf9_3XPvLA7QKf7wfsM/increasing_substring_sample_ts1_input.txt)

*content_copy*

```
2
4
ABBC
6
ABACDA
```

Sample Output

[*save_alt*](https://codejam.googleapis.com/dashboard/get_file/AQj_6U3uPUnsPuagJWnDhD6TqiX0YsOgnv8MZ7AJXOCcVTte15ZyT40z2aRSD76KMQFOBWu8USxKw9OjwCBeTYSChjTgOgoW-xKq7suqZw/increasing_substring_sample_ts1_output.txt)

*content_copy*

```
Case #1: 1 2 1 2
Case #2: 1 2 1 2 3 1
```

In Sample Case #1, the longest strictly increasing substring ending at position 11 is `A`. The longest strictly increasing substrings ending at positions 22, 33 and 44 are `AB`, `B` and `BC`, respectively.

In Sample Case #2, the longest strictly increasing substrings for each position are `A`, `AB`, `A`, `AC`, `ACD` and `A`.