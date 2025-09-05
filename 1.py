'''
Heaps-1

Problem1

Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)
'''

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int: # type: ignore
        if nums == None or len(nums) == 0:
            return -1

        li = []

        for i in range(len(nums)):
            heapq.heappush(li, nums[i]) # type: ignore
            if len(li) > k:
                heapq.heappop(li) # type: ignore
        return heapq.heappop(li) # type: ignore
        
                    