## A command-line utility tool made using Java and Maven.
Currently includes the commands:
* Diff
* Task
* Greet

Detailed usage examples are provided below(all of which assume there is an alias set up).
### Commands:
#### 1. Diff
Finds the line-by-line diff between 2 given files and prints it. 
```bash
> adclu diff "filepath1" "filepath2"
```
Where _filepath1_ and _filepath2_ are the file paths to each of your files, such as: 
```bash
> adclu diff ./file1.txt ./resources/file2.txt
```

Implemented with O(nm) time complexity using the Longest common Subsequence concept.

#### 2. Task
Maintains a Task List from which tasks can be displayed, added, or deleted.
##### To display the tasks:
```bash
> adclu task show
```
##### To delete a task:
```bash
> adclu task delete "number"
```
where _"number"_ is the task number displayed using _task show_, used as 
```bash
> adclu task delete 3
```
##### To add a task:
```bash
> adclu task delete "task name"
```
Used as 
```bash
> adclu task add fix my sleep cycle
```
where _fix my sleep cycle_ will be added as a task.
#### 3. Greet
A hellow world program that prints _hello!_ or _hello **args**!_ if args were supplied.
```bash
> adclu greet Guests
hello Guests!
```
### Abbreviations 
Any of the commands and the arguments which are not values can be abbreviated to the first letter of the command. Any of the following uses is completely valid:
```
> adclu task s
> adclu t s
> adclu g 
> adclu t a new task, eat good food
> adclu t d 3
> adclu d ./file1.txt ./file3.txt
```

### Running the Jar 
The straightforward way to run the Jar is as follows
```bash
java -jar home/code/adclu-jar-with-dependencies.jar args
```

where _"home/code/adclu-jar-with-dependencies"_ is the address of the _adclu-jar-with-dependencies.jar_ and _args_ is a part of one of the commands specified above.


Running the jar file can be made easier using an Alias set to 

```bash
alias adclu="java -jar home/code/adclu-jar-with-dependencies"
```
on Linux. Or for Powershell users,

```
function adclufunc {
    java -jar C:\Users\adity\Code\Adclu\adclu\target\adclu-jar-with-dependencies.jar $args
}
New-Alias adclu adclufunc
```
in the profile.ps1 file.

Packaging with a executable may be done in the future.

