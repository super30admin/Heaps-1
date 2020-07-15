
  
"""
    Student : Shahreen Shahjahan Psyche
    Time    : usingMinHeap : O(NlogK) [Where N is the number of average elements and K is the number of LinkedList/Also the size of the heap]
              usingMaxHeap : O(Nlog(N-K))
    Space   : usingMinHeap : O(K) [My Heap size]
              usingMaxHeap : O(N-K)
              
    Pased Test Cases : Yes
    
"""

# As python's heapq does not implement max_heap, thats why I am creating a custom class. So that this compares the value with the new value and 
# returns true or false. 
class Node(object):
    def __init__(self, val: int):
        self.val = val

    def __repr__(self):
        return f'Node value: {self.val}'
    
    # comparing to find the max value
    def __lt__(self, other):
        return self.val > other.val
    
    def returnValue(self):
        return self.val

class Solution:
    # this method uses the default heapq to find the kth largest
    def usingMinHeap(self, nums, k): 
        import heapq
        track = []
        heapq.heapify(track)
        for i in nums:
            heapq.heappush(track, i)
            if len(track) > k:
                heapq.heappop(track)
        
        return track[0]
        
    # this method levarages the Node class to convert the min heap into max heap. 
    def usingMaxHeap(self, nums, k):   
        import heapq
        size = len(nums) - k 
        track = []
        min_val = float('inf')
        for i in nums:
            heapq.heappush(track, Node(i))
            if len(track) > size:
                val = heapq.heappop(track).returnValue()
                min_val = min(val, min_val)
        # for i in nums:
        #     heapq.heappush(track, -1*i)
        #     if len(track) > size:
        #         heapq.heappop(track)
        
        # return track[0]*-1
        
        return min_val
    
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if nums is None or len(nums) == 0:
            return float('inf')
        
        return self.usingMaxHeap(nums, k)
