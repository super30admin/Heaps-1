"""

## Problem1
Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2

Output: 5

Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4

Output: 4

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.

case-1
time - nlogk
space- k to create a HEAP - NOT SURE ( Am i right ?)


case-2
time - nlogn
space- n to create a HEAP - NOT SURE ( Am i right ?)

"""
import heapq


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # nlogk
        h = []                          #list initialized to [] to create a heap
        for i in range(len(nums)):
            heapq.heappush(h, nums[i])
            if nums[i] >= h[0] and len(h) > k:  #starting poping elemetns from heap we will keep heap size only size = k  so height of heap is k
                heapq.heappop(h)               # and we only compare the pushing element with the root of the heap, least element
        return heapq.heappop(h)

        # nlogk
        h = []                        #list initialized to []  create a heap
        for i in range(len(nums)):
            heapq.heappush(h, nums[i])
            if len(h) > k:
                heapq.heappop(h)        #starting poping elemetns from heap we will keep heap size only size = k  so height of heap is k
        return heapq.heappop(h)

        #nlogn
        heapq.heapify(nums)   # create a min heap  of all nums
        for i in range(len(nums)-k):      #  starting poping elemetns from heap it will return the min every time we pop
            heapq.heappop(nums)
            print("x")
        return heapq.heappop(nums)







