#Time complexity is O(n(logk))
#SPace complexity is O(n)
#Program ran successfully on leetcode
#No issues faced while coding

#kth largest in the Array
import heapq,sys
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        #We are creating a priority queue of min heap type
        pq = []
        for num in nums:
            #We are pushing values into the priority queue
            heapq.heappush(pq, num)
            #If the length of the priority queue is greater tgan K, we will be popping the priority queue
            if len(pq) > k:
                heapq.heappop(pq)
        #Finally the top value in the priority queue will be the kth largest value
        return heapq.heappop(pq)