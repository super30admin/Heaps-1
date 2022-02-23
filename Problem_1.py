# Time Complexity : O(N) in average O(N ^ (2)) in worst case when input is sorted and we always take the first element as pivot
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import random
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        def partition(lo, hi):
            pivot = random.randint(lo, hi)
            nums[lo], nums[pivot] = nums[pivot], nums[lo]
            
            left = lo + 1
            right = hi
            
            while left <= right:
                while left <= hi and nums[left] <= nums[lo]:
                    left += 1
                
                while right > lo and nums[right] > nums[lo]:
                    right -= 1
                
                if left < right:
                    nums[left], nums[right] = nums[right], nums[left]
            
            nums[lo], nums[right]  = nums[right], nums[lo]
            return right

        def recur(lo, hi):
            
            mid = partition(lo, hi)
            if mid == len(nums) - k:
                return nums[mid]
            
            if mid > len(nums) - k:
                return recur(lo, mid - 1)
            
            else:
                return recur(mid + 1, hi)
        
        
        return recur(0, len(nums) - 1)