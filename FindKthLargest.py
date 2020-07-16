import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        h=[]
        for i in range(len(nums)):
            heapq.heappush(h,nums[i])
            if(len(h)>k):
                heapq.heappop(h)
        res=[]
        for i in range(k):
            res.append(heapq.heappop(h))
        
        return res[0]
Space is O(k) size of heap
Time is O(nlogk)
