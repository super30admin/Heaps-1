class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        
        for num in nums:
            heapq.heappush(heap,num)
            if len(heap) > k:
                heapq.heappop(heap)
        return heapq.heappop(heap)
        
        
        
#time complexity is O(nlogk) 
#space complexity is O(k)
