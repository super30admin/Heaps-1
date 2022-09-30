"""
Time Complexity : O(nlogk) where n is the number of elements in the array. logk is the complexity for heapyfi function and we are calling it for every element hence nlog(n)
Space Complexity : O(k) as heap will store k elements at a particular time.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
1. Add every element to the heap, heapify will take place whenever add or remove function is performed.
2. If heap has more than k elements pop the peek element from heap. As this is the min Heap, it will always have min element at the peek and hence we will get k largest elements in the heap.
3. At the end return the peek element in the heap as peek element will be the kth largest element.
"""
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if len(nums) == 0:
            return None
        heap = []
        
        for num in nums:
            #Whenever heappush or heappop function is called heapify takes place automatically
            heapq.heappush(heap, num)
            
            if len(heap) > k:
                #As we are using a minHeap a smallest element will be pop
                #This will result in having k largest elements in the heap
                heapq.heappop(heap)
        
        #At last return the peek element in the heap as peek element will be the kth largest element
        return heapq.heappop(heap)
        