# // Time Complexity :O(Nlogk)
# // Space Complexity :O(k)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we add the elements in a min-heap of size k. at once we get the min element in the root of minheap. we finish constructing the min heap with all elements given - this would ensure we get
# kth largest at the root node at last. whenever we get a new val and the size of heap is at max -k, we delete the min and add the new value and heapify. 
import heapq
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # using min heap
        heap=[]
        for num in nums:
            heapq.heappush(heap,num)
            if(len(heap)>k):
                heapq.heappop(heap)
        return heap[0]

