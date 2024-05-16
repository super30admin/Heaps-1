# Heaps-1

## Problem1 
# Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

# Approach
# Import heapq. Traverse through nums array and push n to heap. If len(heap)>k, pop the top element
# After completing traversal through the list, the topmost element will the kth largest element in the array
# return heap[0]

# Time Complexity: O( nlogk)
# Space Complexity : O(k+1) -> O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


import heapq as hq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for n in nums:
            hq.heappush(heap,n)
            if len(heap) >k:
                hq.heappop(heap)
        return heap[0]