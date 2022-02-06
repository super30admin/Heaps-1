# sc : n
# tc: nlogn
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        import heapq
        
        nums = [-1*x for x in nums]
        heapq.heapify(nums) # inplace nums is now a heap type set
        
        res = 0
        for i in range(k):
            res = heapq.heappop(nums) # pop top element
        return -1*res 
