# Created by Aashish Adhikari at 12:27 PM 2/11/2021

'''
Time Complexity:
Sorting takes O(nlogn).

Space Complexity:
In-place sorting using merge-sort. Hence O(1)
'''

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """

        nums.sort()
        return nums[len(nums) - k]
