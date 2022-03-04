#O(n log k) solution using min heap
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        minHeap = []
        for num in nums:
            heappush(minHeap, num)
            if len(minHeap) > k:
                heappop(minHeap)
        return minHeap[0]