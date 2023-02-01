#time O(logN)
#space O(1)

class Solution:
    #using min-heap
    def findKthLargest(self, nums: List[int], k: int) -> int:
        x=len(nums)-k
        heapq.heapify(nums)
        for i in range(x):
            heapq.heappop(nums)
        return heapq.heappop(nums)
