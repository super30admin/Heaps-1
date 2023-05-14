# Time Complexity: O(nlogk)
# Space Complexity: O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
To find the kth largest element in the array we use a maxheap of size k. We iterate through the array and push the elements 
into the heap. Once that is done we just get the last element in the heap as the answer
"""

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return heapq.nlargest(k, nums)[-1]