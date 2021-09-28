# Time Complexity: O(nlogk) using min heap
# Space Complexity: O(n) for heap as we insert all elements into the heap
# Did this run successfully on Leetcode: Yes
# Any problem while coding this question: Faced issues with max heap implementation
# Approach: using min heap, remove from min heap till count > k, 
# at that point, the next element popped will be the kth largest
# for max  heap, remove from max heap, till count > len(nums) - k, 
# at that point, the next element popped will be the kth largest


# using min heap
import heapq

class Solution:

    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        heapq.heapify(nums)
        count = len(nums)
        while count > k:
            heapq.heappop(nums)
            count -= 1
        return heapq.heappop(nums)

# using max heap
# import heapq
# class Solution:
#     def findKthLargest(self, nums: List[int], k: int) -> int:
        
#         for num in nums:
#             num *= -1
            
#         li = []
#         for num in nums:
#             heapq.heappush(li, num)
        
#         for i in range(len(nums) - k):
#             heapq.heappop(li)
        
#         return heapq.heappop(li)