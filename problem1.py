#Time Complexity ONLog(N)
#Space Complexity O(N)
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return heapq.nlargest(k,nums)[-1]
        
