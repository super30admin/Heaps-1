"""
Time Complexity : O(nlogn)- for converting the array to heap and heapify 
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
I am using heaps for this question. As we need to find kth largest element, i will be using a min heap.
Firstly, we will heapify the given list. Then, while we dont reach the desired k value, we keep on popping values
from the heap. This is done as this will remove all the smaller elements from the heap and only largest k
values will remain. After that, the kth largest would be at the root of heap which we would remove 
and resturn.
"""

from heapq import heapify, heappop


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heapify(nums)
        while len(nums) > k:
            heappop(nums)
        return heappop(nums)
