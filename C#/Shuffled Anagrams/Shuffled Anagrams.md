# Shuffled Anagrams

### Problem

Let SS be a string containing only letters of the English alphabet. An anagram of SS is any string that contains exactly the same letters as SS (with the same number of occurrences for each letter), but in a different order. For example, the word `kick` has anagrams such as `kcik` and `ckki`.

Now, let S[i]S[i] be the ii-th letter in SS. We say that an anagram of SS, A, is *shuffled* if and only if for all ii, S[i]≠A[i]S[i]≠A[i]. So, for instance, `kcik` is not a shuffled anagram of `kick` as the first and fourth letters of both of them are the same. However, `ckki` would be considered a shuffled anagram of `kick`, as would `ikkc`.

Given an arbitrary string SS, your task is to output any one shuffled anagram of SS, or else print `IMPOSSIBLE` if this cannot be done.

### Input

The first line of the input gives the number of test cases, TT. TT test cases follow. Each test case consists of one line, a string of English letters.

### Output

For each test case, output one line containing `Case #xx: yy`, where xx is the test case number (starting from 1) and yy is a shuffled anagram of the string for that test case, or `IMPOSSIBLE` if no shuffled anagram exists for that string.

### Limits

Memory limit: 1 GB.
1≤T≤1001≤T≤100.
All input letters are lowercase English letters.

#### Test Set 1

Time limit: 20 seconds.
1≤1≤ the length of SS ≤8≤8.

#### Test Set 2

Time limit: 40 seconds.
1≤1≤ the length of SS ≤104≤104.

### Sample

Sample Input

[*save_alt*](https://codejam.googleapis.com/dashboard/get_file/AQj_6U2V4occmnMb_iyeAI1F8Kjm0Fkb1ISo40L6xlIczX92zUZgkS7uYhiJDZxUEM4fqIdU8ECcfJgB9BFNDxhioopS9TLDNwb4/shuffled_anagrams_sample_ts1_input.txt)

*content_copy*

```
2
start
jjj
```

Sample Output

[*save_alt*](https://codejam.googleapis.com/dashboard/get_file/AQj_6U2BQB3Nhu--vfahjsEEPPp27W3E_o9-ft4zAn4lRE3ii1irQEngUJZKCbx-pcH_6q-BZUlNn8lwbNOkKRnVvwctblDZ3HJLkA/shuffled_anagrams_sample_ts1_output.txt)

*content_copy*

```
Case #1: tarts
Case #2: IMPOSSIBLE
```

In test case #1, `tarts` is a shuffled anagram of `start` as none of the letters in each position of both strings match the other. Another possible solution is `trsta` (though you only need to provide one solution). However, in test case #2, there is no way of anagramming `jjj` to form a shuffled anagram, so `IMPOSSIBLE` is printed instead.