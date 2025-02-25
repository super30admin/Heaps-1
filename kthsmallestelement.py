#********************Using Min heap*------------------------------------------
#Time = O(Nlogk), Space = O(k)
# class Solution:
#     def findKthLargest(self, nums: List[int], k: int) -> int:
#         min_heap = []
#         for i in nums:
#             heapq.heappush(min_heap, i)
#             if len(min_heap) > k:
#                 heapq.heappop(min_heap)
#         return min_heap[0]

#******************Using Max heap of size n - k----------------------
# Time = O(Nlog(n-k)), Space = O(n-k)
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        n = len(nums)
        result = 9999999999999
        max_heap = []
        for i in nums:
            heapq.heappush(max_heap, -i)
            if len(max_heap) > n - k:
                result = min(result, -heapq.heappop(max_heap))
        return result
