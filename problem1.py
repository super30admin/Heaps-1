#Time complexity= O(nlogk)
#space complexity= O(k)
import heapq as hq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap=[]
        for i in nums:
            hq.heappush(heap,i)
            if len(heap)>k:
                hq.heappop(heap)
        
        return hq.heappop(heap)
        
