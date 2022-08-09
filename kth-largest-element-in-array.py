"""
Runtime Complexity:
O(N logk)- we push elements into result heap and we pop to maintain the heap size of k. We do this operation on n elements N times.
Space Complexity:
O(k) - result list holds elements of size k
Yes, the code worked on leetcode.
Issues while coding - No
"""

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        result = []
        for i in range(len(nums)):
            heapq.heappush(result,nums[i])
            if len(result)>k:
                heapq.heappop(result)
        return heapq.heappop(result)
        