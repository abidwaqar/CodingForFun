# L Shaped Plots Problem

### Problem

Given a grid of RR rows and CC columns each cell in the grid is either 00 or 11.

A segment is a nonempty sequence of consecutive cells such that all cells are in the same row or the same column. We define the length of a segment as number of cells in the sequence.

A segment is called "good" if all the cells in the segment contain only 11s.

An "L-shape" is defined as an unordered pair of segments, which has all the following properties:

- Each of the segments must be a "good" segment.
- The two segments must be perpendicular to each other.
- The segments must share one cell that is an endpoint of both segments.
- Segments must have length at least 22.
- The length of the longer segment is twice the length of the shorter segment.

We need to count the number of L-shapes in the grid.

Below you can find two examples of correct L-shapes,

![Examples of valid L-shapes.](https://codejam.googleapis.com/dashboard/get_file/AQj_6U1WsahNThgYYtiGIsNwzSCjHVJWsHC6X_ingMAqSrQGYgfbVuL0LVBATISPEtJMRcB--32orWnGB_o38g/examples_correct.png)

and three examples of **invalid** L-shapes.

![Examples of invalid L-shapes.](https://codejam.googleapis.com/dashboard/get_file/AQj_6U2uIrTynEAgxTEUyFr7fXYtrQsMVCBgF3JvvNjteUmCzkLv9kKcp0jGtvdyJxUXG8N3_NZ6pDlWXetE4C6K/examples_incorrect.png)

Note that in the shape on the left, two segments do not share a common endpoint. The next two shapes do not meet the last requirement, as in the middle shape both segments have the same length, and in the last shape the longer segment is longer than twice the length of the shorter one.

### Input

The first line of the input contains the number of test cases, TT. TT test cases follow.

The first line of each testcase contains two integers RR and CC.

Then, RR lines follow, each line with CC integers representing the cells of the grid.

### Output

For each test case, output one line containing `Case #xx: yy`, where xx is the test case number (starting from 1) and yy is the number of L-shapes.

### Limits

Time limit: 60 seconds.
Memory limit: 1 GB.
1≤T≤1001≤T≤100.
Grid consists of 00s and 11s only.

#### Test Set 1

1≤R≤401≤R≤40.
1≤C≤401≤C≤40.

#### Test Set 2

1≤R≤10001≤R≤1000 and 1≤C≤10001≤C≤1000 for at most 55 test cases.
For the remaining cases, 1≤R≤401≤R≤40 and 1≤C≤401≤C≤40.

### Sample

Sample Input

[*save_alt*](https://codejam.googleapis.com/dashboard/get_file/AQj_6U2rausXfdOEWMhThNtEqTwOM5viFJ_9CG181PikjAsve_pGhfTBMwZmB3NL3k9y1QS6YreMpTTT5B7_4eFSydxBE7lH/l_shaped_plots_sample_ts1_input.txt)

*content_copy*

```
2
4 3
1 0 0
1 0 1
1 0 0
1 1 0
6 4
1 0 0 0
1 0 0 1
1 1 1 1
1 0 1 0
1 0 1 0
1 1 1 0
```

Sample Output

[*save_alt*](https://codejam.googleapis.com/dashboard/get_file/AQj_6U2OEwEtMOBECY7O6vIlFuYIkkoSP2cJBlx_4ttKyxdr4NqKM2VAGrXSQc2yeslVNUppnh6naO7zocGuNX6anSK9t2aaDQ/l_shaped_plots_sample_ts1_output.txt)

*content_copy*

```
Case #1: 1
Case #2: 9
```

In Sample Case #1, there is one L-shape.

- The first one is formed by using cells: (1,1)(1,1), (2,1)(2,1), (3,1)(3,1), (4,1)(4,1), (4,2)(4,2)

![Visualization for the first sample case, showing one L-shape.](https://codejam.googleapis.com/dashboard/get_file/AQj_6U02RuuoHmgmAvG0ZBiqjEBwJYXaz0T0xEagTAd5cOoedtB-pfxZ399i3flXxnk04O0w1g/sample1.png)

In Sample Case #2, there are nine L-shapes.

- The first one is formed by using cells: (1,1)(1,1), (2,1)(2,1), (3,1)(3,1), (4,1)(4,1), (5,1)(5,1), (6,1)(6,1), (6,2)(6,2), (6,3)(6,3)
- The second one is formed by using cells: (3,1)(3,1), (4,1)(4,1), (5,1)(5,1), (6,1)(6,1), (6,2)(6,2)
- The third one is formed by using cells: (6,1)(6,1), (5,1)(5,1), (4,1)(4,1), (3,1)(3,1), (3,2)(3,2)
- The fourth one is formed by using cells: (3,3)(3,3), (4,3)(4,3), (5,3)(5,3), (6,3)(6,3), (6,2)(6,2)
- The fifth one is formed by using cells: (6,3)(6,3), (5,3)(5,3), (4,3)(4,3), (3,3)(3,3), (3,2)(3,2)
- The sixth one is formed by using cells: (3,1)(3,1), (3,2)(3,2), (3,3)(3,3), (3,4)(3,4), (2,4)(2,4)
- The seventh one is formed by using cells: (3,4)(3,4), (3,3)(3,3), (3,2)(3,2), (3,1)(3,1), (2,1)(2,1)
- The eighth one is formed by using cells: (3,4)(3,4), (3,3)(3,3), (3,2)(3,2), (3,1)(3,1), (4,1)(4,1)
- The ninth one is formed by using cells: (6,3)(6,3), (5,3)(5,3), (4,3)(4,3), (3,3)(3,3), (3,4)(3,4)

The first three L-shapes are shown on the picture below. ![Visualization for the second sample case, showing first three L-shapes.](https://codejam.googleapis.com/dashboard/get_file/AQj_6U1W7GSavANlJvX8yZ6WD8w0vImYNHTW3ggnwzh7DOx3MSc7yexHsNidAtCt9CFyqWt3zQ/sample2.png)