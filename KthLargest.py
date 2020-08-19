'''
Solution:
1.  To find kth largest element, maintain a min heap so that it always maintains k maximum elements at a particular
    point of time and releases min element in those k elements in O(1) operation.
2.  After traversing the entire array, just extract the top element in the heap and that would be Kth largest element.

Time Complexity:    O(n.logk)   |   Space Complexity:   O(k)

--- Passed all testcases successfully on Leetcode.
'''


import heapq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:

        #   edge case check
        if (nums == None or len(nums) == 0):
            return -1

        #   initialize an empty list which acts as min heap
        topK = []

        #   push first k elements into min heap
        for i in range(k):
            heapq.heappush(topK, nums[i])

        #   for next (n-k) elements, push element if greater than smallest element in min heap
        for i in range(k, len(nums)):
            smallest = topK[0]
            if (smallest < nums[i]):
                heapq.heappop(topK)
                heapq.heappush(topK, nums[i])

        return topK[0]