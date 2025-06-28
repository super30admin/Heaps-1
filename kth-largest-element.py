# // Time Complexity : O(nlog(k))
# // Space Complexity : O(log(k))
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # we can use a min - heap for finding top kth element, and conversely a max-heap to find the bottom k-th element
        # works because since the higher priority elements bubble up in the eap, we can limit the size of the heap to K & pop everything that goes above it. 
        heap = []

        for num in nums:
            heapq.heappush(heap, num)
            if len(heap) > k:
                heapq.heappop(heap)
        
        return heap[0] 