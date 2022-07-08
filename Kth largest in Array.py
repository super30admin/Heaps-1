# TC : NlogK
# SC : K
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        hq = []
        for num in nums:
            heappush(hq,num)
            if len(hq) > k :
                heapq.heappop(hq)                
        return hq[0]