"""
215. Kth Largest Element in an Array
Time Complexity - O(nlogk)
Space Complexity - O(k)
Create a heap of size k where we will keep adding elements till size of heap is k and then if heap[0] is less than nums[i] then pop heap[0] and push nums[i] in heap"""
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for i in range(len(nums)):
            if i < k:
                heapq.heappush(heap,nums[i])
            else:
                if heap[0] < nums[i]:
                    heapq.heappushpop(heap,nums[i])
        return heap[0]