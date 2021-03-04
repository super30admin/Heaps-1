import heapq

class Solution:
    """
    Time complexity: O(nlogk)
    Space complexity: O(k)
    """
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # check if the list is empty or not
        if nums is None:
            return None
        
        heap = []
        
        # push the list elements in the heap
        for num in nums:
            heapq.heappush(heap, num)
            
            # remove the first (n-k) elements of the heap
            if len(heap) > k:
                heapq.heappop(heap)
        # the first elem of the heap is the result    
        return heap[0]