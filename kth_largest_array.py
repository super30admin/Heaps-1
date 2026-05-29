import heapq

class Solution:
    def findKthLargest(self, nums, k):
        n = len(nums)
        result = float('inf')

        pq = []
        for num in nums:
            heapq.heappush(pq, -num)
            if len(pq) > n - k:
                result = min(result, -heapq.heappop(pq))

        return result

# Time : O(n log (n-k))
# Space: O(n-k)