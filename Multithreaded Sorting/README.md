## Objectives

Change a sequential program into a multithreaded sorting program as follows: 
- There are two arrays: 
  - a and b of type integer.
  - Make two threads to sort: a and b.
- Make a third thread to merge these two arrays into array: c.
  - The method: main should display array c.
- Note that the two sort threads should work concurrently. Once the array a and b are sorted, the merge thread merges them.
