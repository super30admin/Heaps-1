# Time Complexity : O(nlog(k))
#Space Complexity : O(k)
# #// Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :NO
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if not nums or not k or k < 0:
            return None
        minheap = []
        for num in nums:
            if len(minheap) < k:
                heapq.heappush(minheap, num)
            else:
                if num > minheap[0]:
                    heapq.heappop(minheap)
                    heapq.heappush(minheap, num)
        return minheap[0]