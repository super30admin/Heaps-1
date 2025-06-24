"""
I implemented the solution using a min-heap.
I insert each element from the input array into the min-heap.
If the size of the heap exceeds k, I remove the smallest element (the root).
This ensures that the heap always contains the k largest elements seen so far.
At the end, the root of the min-heap (minHeap[0]) will be the k-th largest element in the array.
Time Complexity: O(nlogk)
Space Complexity: O(k)
"""
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        minHeap = []
        for num in nums:
            heapq.heappush(minHeap, num)
            if len(minHeap) > k:
                heapq.heappop(minHeap)
        return minHeap[0]    