#TIme:O(nlogk)
#Space:O(k)
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for i in range(k):
            heapq.heappush(heap,nums[i])
        for i in range(k,len(nums)):
            if heap[0]<nums[i]:
                heapq.heappop(heap)
                heapq.heappush(heap,nums[i])
            else:
                continue
        return heap[0]