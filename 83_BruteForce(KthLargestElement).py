'''
 Aceepted on leetcode
 Bruteforce Approach(time - O(nlog(n))
 Just sort in desc order and return k-1 position element
'''


class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        nums = sorted(nums, reverse=True)

        return nums[k - 1]