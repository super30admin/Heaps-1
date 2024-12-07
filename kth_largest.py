"Time Complexity is O(N Log K)"
"Space Complexity is O(N)"

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # Min-heap to store the k largest elements
        min_heap = []
        
        # Iterate through the array
        for num in nums:
            heappush(min_heap, num)  # Push the number into the heap
            if len(min_heap) > k:         # If heap exceeds size k
                heappop(min_heap)   # Remove the smallest element
        
        # The root of the heap is the k-th largest element
        return min_heap[0]
