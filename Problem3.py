import heapq

class Solution:
    def findKthLargest(self, nums, k):
    	# Time Complexity : O(nlogk) where n is the number of elements in the list nums
        queue = []
        for i in nums:
            heapq.heappush(queue, i)
            if len(queue) > k:
                heapq.heappop(queue)
        return heapq.heappop(queue)