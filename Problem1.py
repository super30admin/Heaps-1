class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # edge case: blank num / k > total nums
        if len(nums) == 1:
          return nums[0]
          
        heap = []
        for num in nums:
          heapq.heappush(heap, num)
          while len(heap) > k:
            heapq.heappop(heap)
        
        return heap[0]
