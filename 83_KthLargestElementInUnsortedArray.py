'''
Accepted on leetcode(215)
time - O(Nlog(k)), space - O(k)
We are using priority queue(heapq) of size k and at every point just maintain k elements in heapq, so that at the end the first element will be the kth largest element in the given array.
'''
import heapq

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        pq = [] # heapq
        for i in range(len(nums)):

            heapq.heappush(pq,nums[i]) # it pushes new number and heapifies simultaneously
            if len(pq) > k: # heap should be of size k
                heapq.heappop(pq)
        return heapq.heappop(pq)