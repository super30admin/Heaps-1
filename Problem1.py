# Time complexity : O(n log k)
# Space complexity : O(k)
# Leetcode : Solved and submitted

import heapq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
      # check for null and empty nums list, return -1
        if not nums or len(nums) == 0:
            return -1
        # constructing heap in a list
        k_large = []
        # put k elements from nums to the heap of size k
        for i in range(k):
            heapq.heappush(k_large, nums[i])
        
        # traverse over the elements from k till the end of the nums list
        for i in range(k,len(nums)):
          # get the smallest element from the heap, which is the first element, then compare it with the elements from the list
          # if any number is larger than that, we simply remove the root and insert the element
            smallest = k_large[0]
            if smallest < nums[i]:
                heapq.heappop(k_large)
                heapq.heappush(k_large, nums[i])
        # we return the top element as it will always be the kth largest element
        return k_large[0]
