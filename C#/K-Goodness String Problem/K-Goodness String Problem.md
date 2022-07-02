# K-Goodness String Problem

### Problem

Charles defines the goodness score of a string as the number of indices ii such that Si≠SN−i+1Si≠SN−i+1 where 1≤i≤N/21≤i≤N/2 (11-indexed). For example, the string `CABABC` has a goodness score of 22 since S2≠S5S2≠S5 and S3≠S4S3≠S4.

Charles gave Ada a string SS of length NN, consisting of uppercase letters and asked her to convert it into a string with a goodness score of KK. In one operation, Ada can change any character in the string to any uppercase letter. Could you help Ada find the *minimum* number of operations required to transform the given string into a string with goodness score equal to KK?

### Input

The first line of the input gives the number of test cases, TT. TT test cases follow.

The first line of each test case contains two integers NN and KK. The second line of each test case contains a string SS of length NN, consisting of uppercase letters.

### Output

For each test case, output one line containing `Case #xx: yy`, where xx is the test case number (starting from 1) and yy is the minimum number of operations required to transform the given string SS into a string with goodness score equal to KK.

### Limits

Memory limit: 1 GB.
1≤T≤1001≤T≤100.
0≤K≤N/20≤K≤N/2.

#### Test Set 1

Time limit: 20 seconds.
1≤N≤1001≤N≤100.

#### Test Set 2

Time limit: 40 seconds.
1≤N≤2×1051≤N≤2×105 for at most 1010 test cases.
For the remaining cases, 1≤N≤1001≤N≤100.

### Sample

Sample Input

```
2
5 1
ABCAA
4 2
ABAA
```

Sample Output

```
Case #1: 0
Case #2: 1
```

In Sample Case #1, the given string already has a goodness score of 11. Therefore the minimum number of operations required is 00.

In Sample Case #2, one option is to change the character at index 11 to `B` in order to have a goodness score of 22. Therefore, the minimum number of operations required is 11.