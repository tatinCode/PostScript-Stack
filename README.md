# PostScript-Stack
This program contains commands such as
```
pop exch dup clear count index copy
```

pop: Pops the element at the top of the stack.<br>
exch: Exchanges the top two elements of the stack.<br>
dup: Duplicates the top element of the stack.<br>
clear: Clears the stack.<br>
count: Pushes the current size of the stack as a string onto the stack.<br>
index: Retrieves the element at a specified index and pushes it to the top of the stack.<br>
copy: copies the entire list and puts it at the end

<h1>Sample Commands</h1>

Input:
```
5 3 dup exch pop 2
```

Output:
```
2 3 5
```
<br>
Input:
```
10 20 30 3 copy
```
Output:
```
10 20 30 10 20 30
```
