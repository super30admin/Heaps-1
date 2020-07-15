# Time Complexity : Add - O(nlog(n-k)) --> n = nuber of elements, K = kth largets element
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Maintain a heap of size n-k, iterate thrru elment and keep pushing it maintaining max element at the top
2. If element > n-k, pop it out and compare it with the global min, and repeat
3. global min is the Kth largest value
'''

import heapq
import sys

class MyObject():
    def __init__(self, val):
        self.val = val
        
    def __lt__(self, other):
        return (self.val > other.val)
    
    
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        if not nums or len(nums) < k:
            return -1
                  
        min_ = sys.maxsize
        heap_list = []
        for i in nums:
            heapq.heappush(heap_list, MyObject(i))
            if len(heap_list) > len(nums)-k:
                pop = heapq.heappop(heap_list).val
                min_ = min(min_, pop)
                
        return min_
        
####### Using Min heap

import heapq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        if not nums or len(nums) < k:
            return -1
            
        
        heap_list = []
        for i in nums:
            heapq.heappush(heap_list,i)
            if len(heap_list) > k:
                heapq.heappop(heap_list)
                
        return heapq.heappop(heap_list)