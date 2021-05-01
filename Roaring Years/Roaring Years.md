# Roaring Years

### Problem

Something is happening in 20212021 that has not happened in over a century. 20212021, like 19201920 before it, is a roaring year. A year represented by a positive integer yy is roaring if the decimal writing (without leading zeroes) of yy is the concatenation of the decimal writing (without leading zeroes) of two or more distinct consecutive positive integers, in increasing order. In this case, 20212021 is a roaring year because it is the concatenation of 2020 and 2121.

![Three calendars from roaring years 789, 2021, and 910. Each is marked to show how roaring it is.](https://codejam.googleapis.com/dashboard/get_file/AQj_6U0EyJ2fwmDnVAdMqYxQPibfkiR2VbdmCYI4nyTuQBC7AgR9txefUNmKMAzP1IaGWRwAE7zlMg/roaring_years.png)

*Three calendars from roaring years, marked to show how roaring their years are.*

Other examples of roaring years are 1212, 789789, 910910, 12341234, and 98991009899100. 20202020 was not roaring because the only list of two or more positive integers that concatenate into 20202020 is [20,20][20,20], and it is not made of consecutive integers. Similarly, there are only three lists for 20192019: [20,1,9][20,1,9], [201,9][201,9], and [20,19][20,19]. The first two are not made of consecutive integers, while the third does not have the integers in increasing order. Thus, 20192019 was also not roaring. As a final example, 778778 was not a roaring year because [7,78][7,78] and [77,8][77,8] are not made up of consecutive integers and [7,7,8][7,7,8] is not made up of distinct integers.

Given the current year (which may or may not be roaring), find what the next roaring year is going to be.

### Input

The first line of the input gives the number of test cases, TT. TT lines follow. Each line represents a test case and contains a single integer YY, the current year.

### Output

For each test case, output one line containing `Case #xx: zz`, where xx is the test case number (starting from 1) and zz is the first year strictly after YY that is roaring.

### Limits

Time limit: 30 seconds.
Memory limit: 1 GB.
1≤T≤1001≤T≤100.

#### Test Set 1 (Visible Verdict)

1≤Y≤1061≤Y≤106.

#### Test Set 2 (Hidden Verdict)

1≤Y≤10181≤Y≤1018.

### Sample

Sample Input

[*save_alt*](https://codejam.googleapis.com/dashboard/get_file/AQj_6U2os-eHFfTN2ulnQd5SPzQQZRWCG7UMicCK7Xfji-I4kxgKdT-Jju6StKjsSRuER7UihzmWjw2qnoDcweQ6RlsQZBQ/roaring_years_sample_ts1_input.txt)

*content_copy*

```
4
2020
2021
68000
101
```

Sample Output

[*save_alt*](https://codejam.googleapis.com/dashboard/get_file/AQj_6U2Mw7zl8_QMd02P0eRVYllyFZ_7sdBSZJX544OGtbeAcECHFdkQK-c_1jeN3mayulSjCV9y_MIUI8Zn37qNpwsGTMaM/roaring_years_sample_ts1_output.txt)

*content_copy*

```
Case #1: 2021
Case #2: 2122
Case #3: 78910
Case #4: 123
```

Notice in the last Sample Case that 102102 is not a roaring year because [10,2][10,2] is not a list of consecutive integers and you cannot write 22 with a leading zero to use [1,02][1,02].