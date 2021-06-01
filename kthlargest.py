import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for element in nums:
            heapq.heappush(heap, element)
            if heap.__len__() > k:
                heapq.heappop(heap)
        return heapq.heappop(heap)
# Space:- O(k)
# Time:- nlogk