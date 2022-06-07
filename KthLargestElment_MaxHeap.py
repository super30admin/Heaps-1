'''
time complexity: O(Nlog(n-k)) , n is total number of node
space complexity: O(n-k), creating head of n-k
'''
import heapq
class MaxHeapObj(object):
    def __init__(self, val):
        self.val = val

    def __lt__(self, other):
        return self.val > other.val

    def __eq__(self, other):
        return self.val == other.val

    def __str__(self):
        return str(self.val)
    
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        ls = []
        l = len(nums)
        maximum = float('inf')
        for n in nums:
            heapq.heappush(ls,MaxHeapObj(n))
            if(len(ls)>l-k):
                maximum = min(maximum,heapq.heappop(ls).val)
        return maximum