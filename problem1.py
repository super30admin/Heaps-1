from heapq import heappop,heappush
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap=[]
        for val in nums:
            heappush(heap,-val)
        if k>=1:
            for i in range(k-1):
                heappop(heap)
        if len(nums)==0:
            return None
        return -heappop(heap)
        #Time O(nlogk)- time for adding element to a heap of size k is O(k)
        #Space O(k)=heapspace
            
