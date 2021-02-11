# Created by Aashish Adhikari at 12:45 PM 2/11/2021

'''
Time Complexity:
Building minheap under the hood take O( (n/2) * logn) ~ O(nlogn) (Tight upper bound, however, gives O(n))
The for loop takes ~ n - k iterations ~ n iterations.
O(n) + O(nlogn) ~ O(nlogn) --> same time complexity as sorting solution, so no good than that.


Space Complexity:
O(1)
'''

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """

        import heapq
        heapq.heapify(nums)

        leng = len(nums)

        result = None
        for idx in range(leng - k +1):
            result = heapq.heappop(nums)

        return result
