## Problem1 
# Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)
import heapq
from typing import List

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        """
        =====================================================================
        APPROACH 1: MIN-HEAP (Commented Out)
        =====================================================================
        Logic: 
        We maintain a min-heap to keep track of the 'k' largest elements 
        seen so far. As we iterate through the array, we push each element 
        into the heap. If the heap size ever exceeds 'k', we pop the 
        smallest element. By the end of the loop, the heap contains exactly 
        the 'k' largest elements of the array. The root of this min-heap 
        (which we pop at the very end) will naturally be the k-th largest 
        element.

        Time Complexity: O(N * log(k))
        - We iterate through all N elements in the array.
        - Pushing and popping from a heap of size 'k' takes O(log(k)) time.
        
        Space Complexity: O(k)
        - The min-heap stores at most k + 1 elements at any given time.
        =====================================================================
        """
        # minheap = []
        # for n in nums:
        #     heapq.heappush(minheap, n)
        #     if len(minheap) > k:
        #         heapq.heappop(minheap)
        # return heapq.heappop(minheap)


        """
        =====================================================================
        APPROACH 2: MAX-HEAP (Active Solution)
        =====================================================================
        Logic:
        Python's heapq is a min-heap by default, so we push negated values 
        (-n) to simulate a max-heap. Here, we cap the heap size at (N - k + 1). 
        Whenever the heap size exceeds (N - k), it means we have started 
        encountering the top 'k' largest elements. We pop the maximum element 
        from the heap and update 'mini' to keep track of the smallest value 
        among these popped top 'k' elements. After pushing all N elements, 
        we will have popped exactly 'k' times, and 'mini' will hold the 
        k-th largest element.

        Time Complexity: O(N * log(N - k))
        - We iterate through all N elements.
        - The heap size never exceeds (N - k + 1), so each push and pop 
          operation takes O(log(N - k)) time. 
          (Note: Worst-case time is O(N log N) if k is very small).
        
        Space Complexity: O(N - k)
        - The max-heap requires memory proportional to (N - k) to store 
          the elements.
        =====================================================================
        """
        maxheap = []
        mini = float('inf')
        
        for n in nums:
            # Push negated value to simulate max-heap
            heapq.heappush(maxheap, -n)
            
            # If heap size exceeds the total elements minus k (N - k)
            if len(maxheap) > (len(nums) - k):
                # Pop the largest element seen so far and track the minimum of these maximums
                mini = min(-heapq.heappop(maxheap), mini)
                
        return mini