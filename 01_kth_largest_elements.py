'''
Approach 1:
----------
Using heap

Time Complexity : O(n logn) - for heapifying 
Space Complecity : O(1)

'''

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        for i in range(len(nums)):
            nums[i] = - nums[i]
        heapq.heapify(nums)
        
        while k > 0:
            elem = heapq.heappop(nums)
            k -= 1
        return -elem
        