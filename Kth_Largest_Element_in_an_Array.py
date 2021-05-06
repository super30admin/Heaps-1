import heapq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        heapq._heapify_max(nums)
        for i in range(k-1):
            print(heapq._heappop_max(nums))
        
        return heapq._heappop_max(nums)
        
