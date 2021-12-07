#Time Complexity : O(n*log k)
#Space Complexity: O(k)
class Solution:
    def findKthLargest(self, nums, k: int) -> int:
        res = []

        for i in nums:
            heapq.heappush(res,i)
            if len(res) == k + 1:
                heapq.heappop(res)
        return res[0]