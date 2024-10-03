# PostScript-Stack
This program contains commands such as
```
pop dup exch clear index copy count
```

exch: Exchanges the top two elements of the stack.<br>
dup: Duplicates the top element of the stack.<br>
clear: Clears the stack.<br>
count: Pushes the current size of the stack as a string onto the stack.<br>
index: Retrieves the element at a specified index and pushes it to the top of the stack.<br>

<h1>Sample Command</h1>
```
5 3 dup exch pop 2
```

Output:
```
2 3 5
```
