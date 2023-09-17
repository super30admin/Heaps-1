# ## Problem1
# Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)
# // Time Complexity : O(nlogk)
# // Space Complexity : O(k) --> O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution:
    def findKthLargest(self, nums, k):
        # importing heapq funtions
        from heapq import heappush as insert
        from heapq import heappop as remove
        # creating a prioroty queue
        heap = []
        # iterating over the numbers
        for num in nums:
            # inserting into the pq
            insert(heap, num)
            # if k numbers reached, we remove from queue
            if len(heap) > k:
                remove(heap)
        # first element of the heap is kth largest
        return heap[0]


nums = [3, 2, 1, 5, 6, 4]
k = 2
sol = Solution()
print(sol.findKthLargest(nums, k))
