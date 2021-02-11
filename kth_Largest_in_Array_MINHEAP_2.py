# Created by Aashish Adhikari at 1:37 PM 2/11/2021

'''
Time Complexity:
O(n) for the for loop.
At each iteration, heappush() takes O(log k) where k is very small.

O(n.logk) --> better than O(nlogn) seen before.

Space Complexity:
O(k)
'''

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """

        import heapq

        minheap = []

        for idx in range(len(nums)):

            if idx < k:
                heapq.heappush(minheap, nums[idx])
            else:

                # VVI: make sure to pop after you push, not the other way around.
                heapq.heappush(minheap, nums[idx])
                heapq.heappop(minheap)
        return minheap[0]
