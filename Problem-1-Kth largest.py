import heapq
class Solution:
    def findKthLargest(self, nums, k) :
        if nums == None or len(nums) == 0:
            return "-inf"

        heap = []

        for i in range(len(nums)):
            heapq.heappush(heap, nums[i])
            if len(heap) > k:
                heapq.heappop(heap)
        return heap[0]

sol=Solution()
arr=[12,1,0,-11,40,68]
print(sol.findKthLargest(arr,2))