# Time Complexity : O(nlogK)
# Space Complexity : O(size of heap)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        """
        Put elements from nums into a heap. While maintaining the heap size set to K. 
        Whenever the size of heap is > k then just pop from heap. 
        """
        heap = []
        for i in range(len(nums)):
            heappush(heap, nums[i])
            if len(heap) > k:
                heappop(heap)
                
        return heap[0]
