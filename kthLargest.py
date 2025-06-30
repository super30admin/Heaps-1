# TC: O(nlogk)
# SC: O(k)
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        temp=[]
        for i in nums:
            heapq.heappush(temp,i)
            if len(temp)>k:
                heapq.heappop(temp)
        
        return heapq.heappop(temp)
