"""
k th largest element in the array

For largest element, we maintain min heap and for the smallest element we maintain the max heap

We will be using a min heap of size = k and every time a new element is added, we will only maintain 4 elements inside it and bring the min to the top and exreact that

Finally we are left with 4 largest element, Minimum in these 4 largest will be the 4th largest of the whole list

Time Complexity : nlogk + log k  = O(n log k)
k =4 
Space Complexty = O(k)
"""

import heapq
from heapq import heappush as insert 
from heapq import heappop as remove

#using minHeap
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        h = []
        for element in nums:
            heapq.heappush(h,element)
            if len(h)>k:
                heapq.heappop(h)
        return heapq.heappop(h)


#using maxHeap

"""
if we maintain n-k smallest elements, 
the smallest of the k largest element will be the kth largest element
we will use a result variable and everytime the heap size exceeds, we will compare the element coming out of it with the current result variable and save the smaller one

as the size of heap will be n-k, and the heap is max heap, k largest elements will be coming out and smallest of it will be our answer
Time Complexity= n log(n-k)
Space COmplexity = O(n-k)
"""

import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        h = []

        for element in nums:
            heapq.heappush(h, -element)
            if len(h)>len(nums)-k+1:
                heapq.heappop(h)
            
        return -1* heapq.heappop(h)
            

