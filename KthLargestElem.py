class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        heap = []
        
        for num in nums:
            heapq.heappush(heap, num)
            if len(heap) > k:
                heapq.heappop(heap)
            
        return heap[0]
    
    # TIME COMPLEXITY: O(n log(k)) where n is the size of the nums array and log(k) is the time complexity to add elements in the heap
    # SPACE COMPLEXITY: O(k) for heap of size k