# Heaps-1

## Problem1 
Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)
Approach:
1. Make a minheap of size k (where k is the index of largest element (ascending order) that we have to return) and starting adding numbers in it.
2. Whenever my size of minhead > k,remove the first element of minheap, it will adjust itself using heapify operation.
3. Return minheap.poll().

## Problem2

Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)
Approach:
1. Design a minheap of size k where k is the total number of sorted lists.
2. Add the initial listnodes in the heap.
3. Make a listNode object 
4. add min of the minheap and go to next element in that particular array. 
4. Add that element to minheap and Remove the added element from the minheap.Again go to step 4.
5. Repeat till minheap is empty.
6. Retuen the create node. 

