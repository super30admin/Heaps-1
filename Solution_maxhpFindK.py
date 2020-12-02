"""
Using Max heap of size N-k
so TC is  Nlog (N-k) 
and space complexity is O(N-k)




"""


import heapq
class Solution_maxhpFindK:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        pq=[]
        maxval=float('inf')
        N=len(nums)
        for num in nums:
            heapq.heappush(pq,-num)
            if(len(pq)>N-k):
                maxval=min(-(heapq.heappop(pq)),maxval)
        return maxval
                
                
        