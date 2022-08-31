# Time Complexity: O (n * log k)
# Space Complexity: O(1) if we modify the given nums in place. O(n) if we don't want to disturb the i/p array
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for i in range(len(nums)): # Takes k time
            heapq.heappush(heap,nums[i])
            if len(heap) > k:
                heapq.heappop(heap)
        return heap[0]




# # Time Complexity: O(k * log n) which is better than O (n * log k)
# # Space Complexity: O(1) if we modify the given nums in place. O(n) if we don't want to disturb the i/p array
# class Solution:
#     def findKthLargest(self, nums: List[int], k: int) -> int:
#         heap_n = [-i for i in nums]
#         heapq.heapify(heap_n) # O(n) time, modifies in place
#         for i in range(k-1): # Takes k time
#             heapq.heappop(heap_n) # O(1) time to swap and pop and takes max O(log n) swaps to bring back heap property
#         return -1*heap_n[0]