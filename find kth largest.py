# // Time Complexity : O(n log(k)) where n is number of elements in list
# // Space Complexity : O(k)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# we use the Priority queue MIN HEAP
# we add to PQ, it will heapify at each insertion
# when we pass the k elements we pop out of the heap

from heapq import heappush as insert
from heapq import heappop as remove

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        #declare the heap
        heap = []
        for n in nums:
            #inser tinto heap 
            insert(heap,n)
            #when size gets greater than k we pop
            if len(heap)>k:
                remove(heap)
        return heap[0]
            
        
        