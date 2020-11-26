# Time Complexity: O(n log k)
# Space Complexity: O(k) - storing all elements in the heap
# Approach: Push k elements in a min heap, when heap size exceeds k, pop the top element and push the next element if it is greater than the top element of the heap. 
from heapq import *
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        min_heap = []
        for i in range(k):
            heappush(min_heap, nums[i])
            
        for i in range(k, len(nums)):
            if nums[i] > min_heap[0]:
                heappop(min_heap)
                heappush(min_heap,nums[i])
                
        return min_heap[0]