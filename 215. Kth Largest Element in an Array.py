# time complexity: O(nlogk)
# space complexity: O(k)

from heapq import heapify, heappush, heappop
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap=[]
        heapify(heap)
        result=inf
        
        for num in nums:
            heappush(heap, -1*num)
            if len(heap)>len(nums)-k+1:
                heappop(heap)
                
        return -1*heap[0]
    
#         for num in nums:
#             heappush(heap, num)
#             if len(heap)>k:
#                 heappop(heap)
                
#         return heap[0]