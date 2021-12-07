#Time Complexity : O(n*log k)
#Space Complexity: O(k)
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        max_heap =[]
        for num in nums:
            heapq.heappush(max_heap,-num)
            if len(max_heap)>k:
                heapq.heappop(max_heap)
        return [max_heap[i]*-1 for i in range(0,k)]