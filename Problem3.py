import heapq

class Solution:
    def findKthLargest(self, nums, k):
    	# Time Complexity : O(nlogk) where n is the number of elements in the list nums
        queue = []
        for i in nums:
        	# Insert all the elements into the priority queue
            heapq.heappush(queue, i)
            if len(queue) > k: # whenever the length of the queue exceeds the k value pop an element out of the priority queue
                heapq.heappop(queue)
        return heapq.heappop(queue)