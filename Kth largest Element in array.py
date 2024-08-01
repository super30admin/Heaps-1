#// Time Complexity : O(n log k) 
# // Space Complexity : O(K) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : was confused between min heap and max heap
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for i in nums:
            heapq.heappush(heap,i)
            if len(heap) > k:
                heapq.heappop(heap)
            
        return heap[0]

# Approach:
# The problem can be solved using a min heap. The idea is to push all the elements of the
# nums array into the heap. If the size of the heap exceeds k, we pop the smallest element