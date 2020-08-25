class Solution(object):
    def findKthLargest(self, nums, k):
        num=heapq.nlargest(k,nums)[-1]
        return num
#Time-Complexity: O(Nlogk)
#Space-Complexity:O(N)