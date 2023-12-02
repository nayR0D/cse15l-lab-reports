# Lab Report 5 - Putting It All Together
## Part 1 - Debugging Scenario
1. ![image](bug.png) \
Hi, It seems that when there are two lists with elements in my merge function, there is TestTimedOutException. It seems that when one list is empty, and when one list is not, the function works. So it seems that when two lists have elements there is an error somewhere. 

2. Hi, A TestTimedOutException usually means that there is an infinite loop somewhere in your code. Be sure to carefully check all your loops and ensure they terminate correctly.

3. ![image](fix.png) \
After carefully reviewing my loops, I see what the error is. In my loops iterating over list2, I increment the index counter for list1, not list2. therefore the condition, `while(index2 < list2.size())` never ends, resulting in an infinite loop. 

4. 
- The file & directory structure needed \
  ListExamplesFolder
  - ListExamples.java
  - ListExamplesTest.java
  - test.sh
  - lib
    - hamcrest-core-1.3.jar
    - junit-4.13.2.jar 
- The contents of each file before fixing the bug
  - ListExamples.java
    - ![ListExamples.java](ListExamples.png)
  - ListExamplesTest.java
    - ![ListExamplesTest.java](ListExamplesTest.png)
  - test.sh
    - ![test.sh](test.png)
  - hamcrest-core-1.3.jar
    - ![hamcrest](hamcrest.png)
  - junit-4.13.2.jar
    - ![junit](junit.png) \
- The full command line (or lines) you ran to trigger the bug
  - `bash test.sh` 
- A description of what to edit to fix the bug
  - To fix the bug, you must vim into ListExamples.java and edit that line that increments index1 in the `while(index2 < list2.size())` loop. You must change index1 to index2.
