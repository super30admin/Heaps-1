#215. Kth Largest Element in an Array
# Time Complexity : Add - O(nlog(n-k)) 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#first push the elemenst into maxheap untill it reaches size of n - k . If exceeds the size we will remove the top elements of the max heap . compare the top element with min value #and store in min . cont untill we reach end of the ele in array and finnaly return min val
import heapq
class maxheap:
    def __init__(self,val):
        self.val = val
    def __lt__(self, other):
        return (self.val > other.val)
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        minval = float('inf')
        for i in nums:
            heapq.heappush(heap,maxheap(i))
            if len(heap) > len(nums) - k:
                minval = min(minval,heapq.heappop(heap).val)
        return minval
#min heap
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        li = []
        for i in range(len(nums)):
            heapq.heappush(li,nums[i])
            if len(li) > k:
                heapq.heappop(li)
        return heappop(li)