'''
We can make use of heaps here.
A min heap of size k 

Time Complexity -->
O(nlogk) n is the size of the elements an k is the size of the heap
Space Complexity -->
O(k) since we are using a heap tree of size k 
'''

import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        q = []
        for i in range(k):
            q.append(nums[i])
        #append k number of elements and then heapify
        heapq.heapify(q) # this gives us min heap structure
        for i in range(k, len(nums)):
            heapq.heappush(q, nums[i])
            if len(q)>k:
                #perform heappop
                heapq.heappop(q)
            #print(q)
        val = heapq.heappop(q)
        return(val)

'''
   1
  1  2                  
'''