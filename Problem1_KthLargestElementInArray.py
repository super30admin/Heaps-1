# Time Complexity: O(n logk), where n is length of nums and k is heap size
# Space Complexity: O(k)
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if not nums or len(nums) == 0:
            return -1

        # Maintain a minheap of size k
        heap = []
        for num in nums:
            heapq.heappush(heap, num)
            if len(heap) > k:
                heapq.heappop(heap)

        # The top element from the heap gives the kth largest value
        return heap[0]

