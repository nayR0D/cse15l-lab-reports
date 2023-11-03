# Lab Report 3
## Part 1 - Bugs
The bug I have chosen is the one in the reverseInPlace method. 
### Failure Inducing Input
int[] input2 = {1, 0};\
ArrayExamples.reverseInPlace(input2);\
assertArrayEquals(new int[]{0, 1}, input2);
### Non-Failure Inducing Input
int[] input1 = { 3 };\
ArrayExamples.reverseInPlace(input1);\
assertArrayEquals(new int[]{ 3 }, input1);
### Symptom
![image](failed_test(1).png)
