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
static void reverseInPlace(int[] arr) {  
&nbsp;&nbsp;&nbsp;&nbsp; for(int i = 0; i < arr.length; i += 1) {  
&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;         arr[i] = arr[arr.length - i - 1];  
&nbsp;&nbsp;&nbsp;&nbsp;     }  
}



  
### The Code Change
static void reverseInPlace(int[] arr) {  
&nbsp;&nbsp;&nbsp;&nbsp;     int j = arr.length - 1;  
&nbsp;&nbsp;&nbsp;&nbsp;     for(int i = 0; i <= j; i += 1) {  
&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;         int temp = arr[i];  
&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;         arr[i] = arr[j];  
&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;         arr[j] = temp;  
&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;         j--;  
&nbsp;&nbsp;&nbsp;&nbsp;     }  
  }  
The original bug in the code was that it would loop over the middle of the array again, so it would reswap values and never reverse the array at all. This new change fixes these errors by having counters that keep track of the beginning and the end of the array, so that they can swap two elements correctly. When the two counters pass eachother, the whole array has already been reversed and the algorithm can stop.

## Part 2 - Researching Commands

### grep -A num option
ryando@Ryans-MacBook-Pro-8 plos % grep -A 3 "Intro" pmed.0020073.txt  
&nbsp;&nbsp;&nbsp;&nbsp;         Introduction  
&nbsp;&nbsp;&nbsp;&nbsp;         Somatic gain-of-function mutations in exons encoding the epidermal growth factor  
&nbsp;&nbsp;&nbsp;&nbsp;         receptor (EGFR) tyrosine kinase domain are found in about 10% of non-small cell lung  
&nbsp;&nbsp;&nbsp;&nbsp;         cancers (NSCLCs) from the United States [1,2,3], with higher percentages observed in east

ryando@Ryans-MacBook-Pro-8 plos % grep -A 3 "The" pmed.0020120.txt  
&nbsp;&nbsp;&nbsp;&nbsp;        The case report by Nautiyal et al. [1] is an instructive reminder that the first episode  
&nbsp;&nbsp;&nbsp;&nbsp;        of an acute painful Horner Syndrome should prompt imaging of the ipsilateral internal  
&nbsp;&nbsp;&nbsp;&nbsp;        carotid artery, since carotid dissection (as well as other conditions, such as high-grade  
&nbsp;&nbsp;&nbsp;&nbsp;        stenosis) needs to be ruled out. Unfortunately, the authors perpetuate the extremely common    

&nbsp;&nbsp;&nbsp;&nbsp;        apparent. The small palpebral fissure makes the eye look sunken in on the affected side,  
&nbsp;&nbsp;&nbsp;&nbsp;        but the position of the globe in the orbit remains virtually unchanged. This has been found  
&nbsp;&nbsp;&nbsp;&nbsp;        by all workers who have measured the supposed enophthalmos objectively.” Loewenfeld cites  
&nbsp;&nbsp;&nbsp;&nbsp;        four supportive references.    
  
The -A num option on the grep command prints out num lines after the pattern matched with grep along with the line matched with grep. This is useful for when someone needs to look at what a function does really quickly by looking at the first few lines, or when someone needs to see what the lines are after a specific line of code.   
Source: (2023, bash manual page) (https://man7.org/linux/man-pages/man1/grep.1.html)

### grep -B num option
ryando@Ryans-MacBook-Pro-8 plos % grep -B 3 "Acquired" pmed.0020073.txt  
&nbsp;&nbsp;&nbsp;&nbsp;        KRAS mutations have been associated with some cases of primary resistance  
&nbsp;&nbsp;&nbsp;&nbsp;        to gefitinib or erlotinib [7], mechanisms underlying “acquired” or “secondary” resistance  
&nbsp;&nbsp;&nbsp;&nbsp;        are unknown.  
&nbsp;&nbsp;&nbsp;&nbsp;        Acquired resistance to kinase-targeted anticancer therapy has been most extensively  

ryando@Ryans-MacBook-Pro-8 plos % grep -B 3 "twin" pmed.0020086.txt  
&nbsp;&nbsp;&nbsp;&nbsp;        dietary and lifestyle factors explain the majority of individual susceptibility to  
&nbsp;&nbsp;&nbsp;&nbsp;        Alzheimer disease.  
&nbsp;&nbsp;&nbsp;&nbsp;        The basis for asserting a 50% or greater role for genetics in Alzheimer disease risk  
&nbsp;&nbsp;&nbsp;&nbsp;        comes from family studies and from twin studies. In family studies, first-degree relatives  
&nbsp;&nbsp;&nbsp;&nbsp;        of individuals with Alzheimer disease are at more than double the risk of Alzheimer disease  
&nbsp;&nbsp;&nbsp;&nbsp;        compared to those with no affected relatives [2,3]. In twin studies, across different  
&nbsp;&nbsp;&nbsp;&nbsp;        Scandinavian twin registries, estimates of heritability of Alzheimer disease range from 55%    
  
The -B num option on the grep command prints out numlines before the pattern matched with grep along with the string thats matched. This command is useful for getting more context behind a line of code.  
Source: (2023, bash manual page)  (https://man7.org/linux/man-pages/man1/grep.1.html)

### grep -C num option
ryando@Ryans-MacBook-Pro-8 plos % grep -C 3 "Dissecting" pmed.0020090.txt  
&nbsp;&nbsp;&nbsp;&nbsp;        the studies on serum uric acid are epidemiologic studies—somewhere in the middle of the  
&nbsp;&nbsp;&nbsp;&nbsp;        hierarchy of evidence—and have come to different conclusions about how useful measurement  
&nbsp;&nbsp;&nbsp;&nbsp;        of uric acid is.  
&nbsp;&nbsp;&nbsp;&nbsp;        Dissecting out the role of uric acid is further complicated by three things: high levels  
&nbsp;&nbsp;&nbsp;&nbsp;        of uric acid are associated with hypertension and being overweight (other risk factors for  
&nbsp;&nbsp;&nbsp;&nbsp;        CHD); levels of uric acid can be altered by drugs such as diuretics that people with CHD  
&nbsp;&nbsp;&nbsp;&nbsp;        often take; and finally, alteration of renal function can affect uric acid levels. Another  

ryando@Ryans-MacBook-Pro-8 plos % grep -C 1 "This o" pmed.0010071.txt  
&nbsp;&nbsp;&nbsp;&nbsp;        whom to speak to at the organization.  
&nbsp;&nbsp;&nbsp;&nbsp;        This omission is significant because partnership is one of the key tenets of the EDCTP.  
&nbsp;&nbsp;&nbsp;&nbsp;        European research agencies are slowly beginning to realize that they need to cooperate with  
  
The -C option of the grep command combines the -A and the -B option together to print num lines before and after the pattern matched line along with the pattern matched line. This is especially useful for people who want to get even more context from a specific line of code but not have to open up the file everytime.  
Source: (2023, bash manual page) (https://man7.org/linux/man-pages/man1/grep.1.html)

### grep -H option
ryando@Ryans-MacBook-Pro-8 plos % grep -H "treatment" pmed.0010067.txt  
pmed.0010067.txt:        treatment. And an essential part of this work up is assessing whether or not there has been  

ryando@Ryans-MacBook-Pro-8 plos % grep -H "nanoparticles" *.txt  
journal.pbio.0020431.txt:        usual result: mostly nanowires, nanoparticles, and simple aggregates of nanoparticles. The  
pmed.0010066.txt:        development [15,16] and clinical introduction of lymphotropic magnetic nanoparticles has  
pmed.0010066.txt:        in prostate cancer [17]. These nanoparticles serve as probes for lymphatic anatomy and  
pmed.0010067.txt:        have developed nanoparticles to improve the diagnostic accuracy of MRI. The nanoparticles  
pmed.0010067.txt:        long circulation times and biocompatibility. When injected intravenously, the nanoparticles  
pmed.0010067.txt:        described using these nanoparticles to assess lymphoid spread in patients with prostate  
  
The -H option of the grep command prints out what files the pattern matched string was found in. This command is useful for when a developer knows the name of a command but does not know what file it is in.  
Source: (2023, bash manual page) (https://man7.org/linux/man-pages/man1/grep.1.html)
