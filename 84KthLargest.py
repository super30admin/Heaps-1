"""
T = O(nlogk)
S = O(k)

create heap of size k
push numbers from nums till the heap is full
if len(heapifyqueue) > k, pop element so that kth element is always on the top
at the end, return top element of the heap i.e kth element
"""
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        queue = []
        for i in range(len(nums)):
            heapq.heappush(queue,nums[i])
            if len(queue) > k:
                heapq.heappop(queue)
        return heapq.heappop(queue)
