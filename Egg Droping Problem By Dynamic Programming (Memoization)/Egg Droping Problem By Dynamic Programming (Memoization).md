# Egg Droping Problem By Dynamic Programming (Memoization)

### Problem

There are **E eggs (= allowed egg breaks)**, a building with **F** **floors** [**1 ≥ F]** and a special floor **S** [**0 ≤ S ≤ F] -** any unbroken egg dropped at a floor higher than S will break and any egg dropped at or below this floor will not break.

Given that an unbroken egg can be dropped from any floor, what is the minimum number of **egg drops D [1 ≤ D ≤ F]** needed in order to find S in the worst case?

Input1: E =1 , F=1 | Output1: D=1
Input2: E =1 , F=2 | Output2: D=2
Input3: E =1 , F=7 | Output3: D=7
Input4: E =2 , F=7 | Output4: D=4
Input5: E =3 , F=7 | Output5: D=3