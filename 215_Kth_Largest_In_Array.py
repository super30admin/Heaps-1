# Leetcode problem link : https://leetcode.com/problems/kth-largest-element-in-an-array/
# Time Complexity:    O(nlogk)
# Space Complexity:   O(k)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
    Basic approach : Sort the array and return the k the element from end -> NlogN
    Better approach : Create a max heap of size n and push all the elements of array. Pop k times and return kth element from max heap
    
    Optimized approach : Min heap of size k to keep top k elements. First element after inserting is the kth largest element
    
'''

from heapq import heappush as push
from heapq import heappop as pop
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if not nums:
            return 0
        # declare min heap
        min_heap = []
        
        # push elements to heap and as soon as size exceeds k(remove smallest element)
        
        for i in range(len(nums)):
            push(min_heap,nums[i])
            
            if len(min_heap) > k:
                pop(min_heap)
        
        return min_heap[0]
        