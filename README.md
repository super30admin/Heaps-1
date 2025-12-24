# Heaps-1

## Problem1 
Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)
* MinHeap with k elements
* if Heap exceeds size k , remove the top element
* T - nlogk (log k for heapify k elements), S - k


## Problem2

Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)
* keeping all the heads of the list in the minheap
* having a nummy node & adding lowest element from pq to that list 
* T - nklogk(n=avg num of elements in a array, k = number of lists in the array, logk = for heapify of k elements), S - k(Heap size)

