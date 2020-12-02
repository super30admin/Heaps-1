# leetcode:accepted
# time complexity: 0(nlogk)
# explaination: create a queue  keep on pushing the elements from the list into the heap. if the size of the heap becomes more than k,Pop the element from the quue.
"""

import heapq
class Solution(object):
    def findKthLargest(self, nums, k):

        heap=[]
        for n in nums:
            heapq.heappush(heap,n)
            if len(heap)>k:
                heapq.heappop(heap)
        return heapq.heappop(heap)
"""


### brute force method

# Explaination
# tc:nlogn
# sort the array and give the kth index

class Solution(object):
    def findKthLargest(self, nums, k):
        nums.sort()
        nums = nums[::-1]
        return (nums[k - 1])