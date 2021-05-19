## Problem1 
# Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        def partition(l: int, r: int) -> int:
            if l > r:
                return
            pivot = nums[r]
            p_index = l
            for i in range(l, r):
                if nums[i] < pivot:
                    nums[i], nums[p_index] = nums[p_index], nums[i]
                    p_index += 1
            nums[p_index], nums[r] = nums[r], nums[p_index]
            return p_index, r - p_index + 1

        l = 0
        r = len(nums) - 1
        while True:
            p_index, length = partition(l, r)
            if length > k:
                l = p_index + 1
            elif length < k:
                k -= length
                r = p_index - 1
            else:
                return nums[p_index]
        