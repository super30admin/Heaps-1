# Time Complexity: O(nlogk)
# Space Complexity: O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = list()
        #min heap
        heapify(heap)

        for num in nums:
            heappush(heap,num)
            # we keep the max size of heap = to k
            # so at the end, kth largest would be at top
            if len(heap)>k:
                heappop(heap)

        return heappop(heap)