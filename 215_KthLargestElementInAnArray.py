"""
Leetcode-https://leetcode.com/problems/kth-largest-element-in-an-array/
TC- O(N * 2logK (for heapify and extracting min)), SC- O(K)
Challenges-Implementing heap in python, specially max heap. Refer notes.
Lecture-https://youtu.be/kg2-5xTrfQY
FAQ-

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.


Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4


Constraints:

1 <= k <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
"""

import heapq as hq
import sys


class Solution:
    """
    *most optimized solution*
    Ideation- K min heap, TC- O(N * 2logK) = O(NlogK), SC- O(k) heap size

    The idea is to pop n- k elements from min heap and only keep the largest k elements in min heap, so in the end
    when you pop the next element, it is the kth the largest element, or you can say (n - k + 1)the smallest element.

    That's why we only keep the size of min heap as k, so like mentioned we only have kth the largest elements after
    popping n - k elements.
    """

    def findKthLargest(self, nums, k):
        minHeap = []
        # track the size of min heap
        length = 0
        for num in nums:  # O(N)
            length += 1
            hq.heappush(minHeap, num)  # log(k)
            # if k elements are already in our min heap, we pop the smallest element leaving the largest element in heap
            if length > k:
                hq.heappop(minHeap)  # log(k)

        return hq.heappop(minHeap)

    """
    Ideation- n-k max heap, TC- O(N * log(N-K)), SC- O(N-K)

    The idea here is to keep n-k elements in max heap, and when you go over it, the pop will give you largest number in 
    the current heap, but remember this will not give your answer since, not all elements were processed in the heap. 
    The popped element will be one of the K largest elements 
    So, you will compare the popped elements and keep the minimum of them, which will be our kth largest element.
    
    Implementation in python for max heap can be done by min heap with negative values in them.
    """

    def findKthLargest1(self, nums, k):
        minheap = []
        result = sys.maxsize
        length = 0
        for num in nums:
            length += 1
            hq.heappush(minheap, -num)
            if length > len(nums) - k:
                result = min(result, -hq.heappop(minheap))

        return result
