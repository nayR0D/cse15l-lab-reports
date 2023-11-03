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

### The Bug Before change
static void reverseInPlace(int[] arr) {\
   for(int i = 0; i < arr.length; i += 1) {\
      arr[i] = arr[arr.length - i - 1];\
    }\
  }
  
### The Code Change
static void reverseInPlace(int[] arr) {  
    int j = arr.length - 1;  
    for(int i = 0; i <= j; i += 1) {  
        int temp = arr[i];  
        arr[i] = arr[j];  
        arr[j] = temp;  
        j--;  
    }  
  }  
The reason this code change fixes the bug is that in the original code, there would be indexing out of bounds errors, and it would also loop over the middle of itself again, so it could reswap values and never swap at all. This new change fixes these errors by having counters that keep track of the beginning and the end of the array, so that they can swap the two, then when the two counters, pass eachother, the whole array has already been swapped and the algorithm can stop.
