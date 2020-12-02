# Leetcode 215 - Kth Largest Element in an Array
#space - O(k)-- exculding the inputs
#time - O(nlogk) n - total number of elements in list , k - kth largest element
# HEAp is same as priority queue , and min heap and min element on top while max heap has max on top
#brute force sort the elements and give the kth largest # time - O(nlogn)
import heapq
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        pq = nums[:k] #created an intial list with k elements
        heapq.heapify(pq)
        for i in range(k, len(nums), 1):
            heapq.heappush(pq, nums[i])
            # pq.heappush(nums[i])
            if len(pq) > k:
                heapq.heappop(pq)
        return heapq.heappop(pq)
