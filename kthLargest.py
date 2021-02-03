# Approach: Python's heapq module has a method nlargest which will maintain 'k' elements in the heap always
# We start with adding elements up until size <= k, once size exceeds, we remove the minimum element

# Time - O( N * log k) since inserting/removing elements in heap is log k and we have N elements in the list
# Space - O(k) always k elements only maintained in the heap.

import heapq

class Solution:
    def findKthLargest(self, nums, k):

        return heapq.nlargest(k, nums)[-1]