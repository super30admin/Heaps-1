"""
Approach: Using heap

Why min heap?
Now here we want the kth largest element. So what we will do is use mean heap of size k. So we will push elements inside the heap and if it reaches its capacity k we will pop the element. So after k iterations, one push and one pop operation will be done to maintain its capacity. So after iterating through all the elements and doing operations, at the end the kth largest element can be found on the top of the heap.

So this was the reason we used a mean heap to find the largest element. So that we can eliminate n-k smallest elements from the array and only remaining k elements are remaining.

Time complexity: O(nlogk)
Space complexity: O(k)

where n = length of the given array
"""

import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        
        for num in nums:
            heapq.heappush(heap, num)
            if len(heap) > k:
                heapq.heappop(heap)
                
        return heapq.heappop(heap)