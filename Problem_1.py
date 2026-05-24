import heapq


class Solution:
    def findKthLargest(self, nums, k):
        pq = []
        for num in nums:
            heapq.heappush(pq, num)
            if len(pq) > k:
                heapq.heappop(pq)
        return heapq.heappop(pq)
    

# class Solution:
#     def findKthLargest(self, nums, k):
#         pq = []
#         result = math.inf
#         for num in nums:
#             heapq.heappush(pq, -num)
#             if len(pq) > len(nums) - k:
#                 result = min(result, -heapq.heappop(pq))
#         return result
