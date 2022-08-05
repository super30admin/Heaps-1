#time: o(Nlogk)
#space: O(K)

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if not nums:
            return -1

        minHeap = []
        for i in range(k):
            heapq.heappush(minHeap, nums[i])

        for i in range(k, len(nums)):
            if minHeap[0] < nums[i]:
                heapq.heappop(minHeap)
                heapq.heappush(minHeap, nums[i])

        return minHeap[0]