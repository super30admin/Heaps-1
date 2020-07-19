import heapq
class Solution(object):
    # Time Complexity : O(n*log(n)), where n is the length of the array
    # Space Complexity : O(1), modified input list
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # Sort the list and return the kth elem from the end.
    def findKthLargestSorting(self, nums, k):
        nums.sort()
        return nums[len(nums)-k]

#----------------------------------------------------------x-----------------------------------------------------------#
    # USING MIN HEAP

    # Time Complexity : O(n*log(k)), where n is the length of the array
    # Space Complexity : O(k), where k is given in the input
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # Push all elements into a min heap to preserve ascending order
    # If the size of the heap is > k pop minimum. In the end the heap
    # will have k elems and the next pop should give the kth largest elem
    def findKthLargestMinHeap(self, nums, k):
        pQueue = []
        for i in nums:
            heapq.heappush(pQueue, i)
            if len(pQueue) > k:
                heapq.heappop(pQueue)

        return heapq.heappop(pQueue)

#----------------------------------------------------------x-----------------------------------------------------------#
    # USING MAX HEAP with negative numbers

    # Time Complexity : O(n*log(k)), where n is the length of the array
    # Space Complexity : O(n), where k is given in the input
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # This approach will negate the numbers to use a min heap as a max heap,
    # All numbers are pushed and popping the heap k times  will give out the result
    def findKthLargestMaxHeap(self, nums, k):
        pQueue = []
        for i in nums:
            heapq.heappush(pQueue, -i)

        while k != 1:
            heapq.heappop(pQueue)
            k -= 1

        return -heapq.heappop(pQueue)
