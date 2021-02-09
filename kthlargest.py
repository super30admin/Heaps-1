# TC: O(nlogk) -> minheap, O(nlog(n-k)) -> maxheap
# SC: O(K) -> minheap, O(n-k) -> maxheap

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        q = []
        n = len(nums)
        ## Min heap solution
        """for num in nums:
            heappush(q, num)
            
            if len(q) > k:
                heappop(q)"""
        
        ## Max heap solution
        for num in nums:
            heappush(q, -num)
            
            if len(q) > n-k+1:
                heappop(q)
        
        return -heappop(q)