-------------------------------- Find Kth largest element ---------------------------------------------
# Time Complexity : n log k
# Space Complexity : O(k)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here I have used heap to store k elements. I will iterate through the array and insert elements into heap. if my length of heap 
# greater than k, then I will pop elements from heap so that smallets element is popped from heap. Once I iterated through all elements 
# return top element from heap.



import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for i in nums:
            heapq.heappush(heap, i)
            if len(heap)>k:
                heapq.heappop(heap)
        return heapq.heappop(heap)
        


