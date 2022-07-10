#Time complexity: O(nlogk)
#space complexity: O(k)
import heapq as hq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        minH = []
        
        for num in nums:
            hq.heappush(minH, num)
            if len(minH) > k:
                hq.heappop(minH)
        return hq.heappop(minH)
        
