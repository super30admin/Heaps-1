"""
Time Complexity : O(nlogk) where k is the no that is given and n is no. of elements in array
Space Complexity : O(k)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if len(nums) == 0:
            return -1
        minHeap = []
        for i in nums:
            # Adding to the priority queue or heap
            heapq.heappush(minHeap, i)
            # If the size of the priority queue goes beyond k
            # we remove the smallest element from the queue
            if len(minHeap) > k:
                heapq.heappop(minHeap)
        return heapq.heappop(minHeap)