"""
Time complexity: O(nlogn) Heap insertion is logn and we insert n elements in a heap
Space complexity: O(k) Heap size will be the size of k.
Compiled on leetcode?: Yes
Difficulties faced?: No
"""
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for i in range(len(nums)):
            if len(heap) == k:
                heapq.heappushpop(heap, nums[i])
            else:    
                heapq.heappush(heap, nums[i])
        return heap[-1 * k]  