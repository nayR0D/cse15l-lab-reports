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
<html> 
   static void reverseInPlace(int[] arr) {
   <head>   
   for(int i = 0; i < arr.length; i += 1) {
      <head1>
      arr[i] = arr[arr.length - i - 1];
      </head1>
    }
   </head>
  }
</html>

  
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
The original bug in the code was that it would loop over the middle of the array again, so it would reswap values and never reverse the array at all. This new change fixes these errors by having counters that keep track of the beginning and the end of the array, so that they can swap two elements correctly. When the two counters pass eachother, the whole array has already been reversed and the algorithm can stop.

## Part 2 - Researching Commands

### grep -A option

