'''
TC: O(nlogk) where n is the number of elements in the array
            and k is the capacity restricted for the heap
SC: O(k) where k is the set capacity of the heap
'''
import heapq
from typing import List

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        #create minheap
        heap = []
        for n in nums:
            heapq.heappush(heap, n)
            if len(heap)>k:
                heapq.heappop(heap)
        return heapq.heappop(heap)
s = Solution()
print(s.findKthLargest([3,2,1,5,6,4], 2))
print(s.findKthLargest([3,2,3,1,2,4,5,5,6], 4))