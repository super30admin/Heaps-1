#  Time Complexity: O(n log n)
#  Space Complexity : O(1)
#  Brute Force

class Solution(object):
    def findKthLargest(self, nums, k):
        nums.sort(reverse = True)
        return nums[k-1]
        
