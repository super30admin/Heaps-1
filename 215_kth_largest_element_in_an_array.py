"""
Problem: 215. Kth Largest Element in an Array
Leetcode: https://leetcode.com/problems/kth-largest-element-in-an-array/

Basic Approach: Sort the array and return the kth element from end - O(n log n)
Better Approach: Create a max heap of size n, push all elements of array, pop k times and return kth element from max heap
Optimized Approach : Create a Min heap of size k, push each elements to heap while maintaining size k.
     - Head of the heap will contain kth largest element after iterating through all elements of array

Time Complexity: O(N log k), where N is the number of elements in an array, with given kth largest element
Space Complexity: O(k) to store k elements in the heap

Did this code successfully run on Leetcode: Yes
"""

from heapq import heappush as push
from heapq import heappop as pop


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # base case
        if not nums or not k or k < 0:
            return None

        # declare min heap
        min_heap = []

        # push each element to heap and as soon as heap size exceeds k, remove smallest element
        for num in nums:
            push(min_heap, num)

            if len(min_heap) > k:
                pop(min_heap)

        return min_heap[0]
