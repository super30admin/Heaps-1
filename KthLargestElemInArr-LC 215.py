
# Min heap based solution
# Time Complexity = O(n * log k), 1 insertion in heap = log k (since size of heap = k), so 'n' insertions give n * log k

# Space Complexity = O(k), heap size at any moment will not exceed k

import sys
import heapq

class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        if nums == None or len(nums) == 0:
            return -1
        
        minHeap = []
        
        for el in nums:
            heapq.heappush(minHeap, el)
            if len(minHeap) > k:
                heapq.heappop(minHeap)
                
        return heapq.heappop(minHeap)



# Max heap based solution
# Time Complexity = O(n * log(n - k)), since heap size = n - k
# Space Complexity = O(n - k)

import heapq

class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        if nums == None or len(nums) == 0:
            return -1
        
        maxHeap = []
        result = sys.maxsize
        
        for el in nums:
            # (-1) to make the heap act like a max heap
            heapq.heappush(maxHeap, -1 * el)
            # if len(maxHeap) > (len(nums) - k):
            #     result = min(result, heapq.heappop(maxHeap))
        
        
        for i in range(k - 1):
            heapq.heappop(maxHeap)
        
        # (-) of the value return to accomodate line 40
        # return -1 * result
        return -heappop(maxHeap)
    
    