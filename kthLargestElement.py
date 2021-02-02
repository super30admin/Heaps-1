'''
Time Complexity - O(Nlogk) - N for iterating through nums and log k for heapify
Space Complexity - O(k) Since k+1 elements are saved at max in the heap
Algorithm - Use min heap and pop if length >k . return the popped element once iteration is over.
            In case of max heap, N-k will be the answer
'''
from heapq import heappush, heappop
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        heap = []
        for num in nums:
            heapq.heappush(heap,num)
            if len(heap)>k:
                heapq.heappop(heap)
                
        return heapq.heappop(heap)
        
