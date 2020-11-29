"""
Using Min heap of size K 
so TC is  Nlog k 
and space complexity is O(k)


"""


import heapq
class Solution_klarge:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        pq=[]
        for num in nums:
            heapq.heappush(pq,num)
            if(len(pq)>k):
                heapq.heappop(pq)
        return pq[0]
                
                
        