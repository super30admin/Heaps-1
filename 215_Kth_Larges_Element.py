"""
TC -> O(kLogN)
SC -> O(k)
Logic
Use a min heap and push elements until len(heap)<k
If len(heap)==k, check if top heap element is lesseer than current elemnt. If yes, pop top element
and push new element to heap.
Finally return the top heap element as it will be the kth largest element and the heap will have largest k elements
"""
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for i in range(0, len(nums)):
            if len(heap)<k:
                heapq.heappush(heap,nums[i])
            else:
                if heap[0]< nums[i]:
                    heapq.heappop(heap)
                    heapq.heappush(heap, nums[i])
        return heap[0]