# Time Complexity : O(nlogk)
# Space Complexity :O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        minHeap = []
        for x in nums:
            heappush(minHeap,x)
            if len(minHeap)>k:
                heappop(minHeap)
        return minHeap[0]
