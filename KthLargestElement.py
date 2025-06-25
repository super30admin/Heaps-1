from typing import List
import heapq
# class Solution:
#     def findKthLargest(self, nums: List[int], k: int) -> int:
#         res =[]
#         for n in nums:
#             heapq.heappush(res, n)
#             if len(res) > k:
#                 heapq.heappop(res)
#         return res[0]

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return heapq.nlargest(k,nums)[-1]

        
        