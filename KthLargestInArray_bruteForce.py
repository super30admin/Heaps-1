"""
Time Complexity : O(nlogn) where n is the number of elements in the array.
Space Complexity : O(1) as no auxillary data structure is use.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
The brute force way is to sort the array in the descending order and return the k-1th element in the array.
"""
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if len(nums) == 0:
            return None
        # nums = sorted(nums, reverse = True)
        nums.sort(reverse = True)
        print(nums)
        return nums[k-1]
