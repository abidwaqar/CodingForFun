# Moons and Umbrellas

### Problem

Cody-Jamal is working on his latest piece of abstract art: a mural consisting of a row of waning moons and closed umbrellas. Unfortunately, greedy copyright trolls are claiming that waning moons look like an uppercase C and closed umbrellas look like a J, and they have a copyright on CJ and JC. Therefore, for each time CJ appears in the mural, Cody-Jamal must pay XX, and for each time JC appears in the mural, he must pay YY.

![img](https://codejam.googleapis.com/dashboard/get_file/AQj_6U2owO5JXHIGuA09leq_iuziif8xf8j8AWhNKwWXPxK_KhJTriQ5hvecBNuT2vgvaARVhhe_GSKL/moons_and_umbrellas.png)

Cody-Jamal is unwilling to let them compromise his art, so he will not change anything already painted. He decided, however, that the empty spaces he still has could be filled strategically, to minimize the copyright expenses.

For example, if `CJ?CC?` represents the current state of the mural, with `C` representing a waning moon, `J` representing a closed umbrella, and `?` representing a space that still needs to be painted with either a waning moon or a closed umbrella, he could finish the mural as `CJCCCC`, `CJCCCJ`, `CJJCCC`, or `CJJCCJ`. The first and third options would require paying X+YX+Y in copyrights, while the second and fourth would require paying 2⋅X+Y2⋅X+Y.

Given the costs XX and YY and a string representing the current state of the mural, how much does Cody-Jamal need to pay in copyrights if he finishes his mural in a way that minimizes that cost?

### Input

The first line of the input gives the number of test cases, TT. TT lines follow. Each line contains two integers XX and YY and a string SS representing the two costs and the current state of the mural, respectively.

### Output

For each test case, output one line containing `Case #xx: yy`, where xx is the test case number (starting from 1) and yy is the minimum cost that Cody-Jamal needs to pay in copyrights for a finished mural.

### Limits

Time limit: 10 seconds.
Memory limit: 1 GB.
1≤T≤1001≤T≤100.
Each character of SS is either `C`, `J`, or `?`.

#### Test Set 1 (Visible Verdict)

1≤1≤ the length of SS ≤10≤10.
1≤X≤1001≤X≤100.
1≤Y≤1001≤Y≤100.

#### Test Set 2 (Visible Verdict)

1≤1≤ the length of SS ≤1000≤1000.
1≤X≤1001≤X≤100.
1≤Y≤1001≤Y≤100.

### Extra credit!

What if some copyright holders could pay Cody-Jamal for the advertisement instead of being paid? Cody-Jamal getting paid is represented by a negative cost.

#### Test Set 3 (Hidden Verdict)

1≤1≤ the length of SS ≤1000≤1000.
−100≤X≤100−100≤X≤100.
−100≤Y≤100−100≤Y≤100.

### Sample

*Note: there are additional samples that are not run on submissions down below.*

Sample Input

[*save_alt*](https://codejam.googleapis.com/dashboard/get_file/AQj_6U3PbqYbwiFNAMPP1wOKIuVr4GSkRpG7b59EQpIC8rj-17A-ZkbjiEJqgR20vWN5WZowHUAPq_pX72W9kPRHZAlfCOxx5UQCXNY/moons_and_umbrellas_sample_ts1_input.txt)

*content_copy*

```
4
2 3 CJ?CC?
4 2 CJCJ
1 3 C?J
2 5 ??J???
```

Sample Output

[*save_alt*](https://codejam.googleapis.com/dashboard/get_file/AQj_6U1k5_OqINNLFuZMrt76Oi8knF7URX8514Q-WQZTuXFlCy1-T1uVMgWPobtZZJ9YCSHjUMzoB5JteJfOfK6TpAXUwa2kltliq8nh/moons_and_umbrellas_sample_ts1_output.txt)

*content_copy*

```
Case #1: 5
Case #2: 10
Case #3: 1
Case #4: 0
```

Sample Case #1 is the one explained in the problem statement. The minimum cost is X+Y=2+3=5X+Y=2+3=5.

In Sample Case #2, Cody-Jamal is already finished, so he does not have a choice. There are two `CJ`s and one `JC` in his mural.

In Sample Case #3, substituting either `C` or `J` results in one `CJ` either from the second and third characters or the first and second characters, respectively.

In Sample Case #4, Cody-Jamal can finish his mural with all `J`s. Since that contains no instance of `CJ` nor `JC`, it yields no copyright cost.



### Additional Sample - Test Set 3

*The following additional sample fits the limits of Test Set 3. It will not be run against your submitted solutions.*

Sample Input

[*save_alt*](https://codejam.googleapis.com/dashboard/get_file/AQj_6U0fN8NwfZCfTN3nzuY7sz9tUCB4m-NRsfPren63yE43F8qFy8Y9Anj7yizyj0qHpwpYBFTfuCTatf8ED70YpnRQD8JLUrkIfLw/moons_and_umbrellas_sample_ts3_input.txt)

*content_copy*

```
1
2 -5 ??JJ??
```

Sample Output

[*save_alt*](https://codejam.googleapis.com/dashboard/get_file/AQj_6U3979liOnrmKa974i9YtBmknZQOG6-54NWMY1DPjKSK3khkIEOr7EpUoJIB1lGzwEIp7SPAdDIpGcg1z6Lf3Y_LZwqJiGrhfpFx/moons_and_umbrellas_sample_ts3_output.txt)

*content_copy*

```
Case #1: -8
```

In Sample Case #1 for Test Set 3, Cody-Jamal can finish his mural optimally as `JCJJCC` or `JCJJJC`. Either way, there is one `CJ` and two `JC`s in his mural.