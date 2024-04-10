# Time Complexity: O(nlogk)
# Space Complexity: O(logk)

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # To heapify the input as minheap
        heapq.heapify(nums)
        #remove topmost item form the heap
        while len(nums)>k:
            heapq.heappop(nums)
        return nums[0]

        