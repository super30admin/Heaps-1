#TimeComplexity:O(Nlogk) 
#SpaceComplexity: O(k)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap=[]
        for i in range(len(nums)):
            heapq.heappush(heap,nums[i])
            if i >= k:
                heapq.heappop(heap)
        return heapq.heappop(heap)