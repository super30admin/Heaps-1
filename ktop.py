# Time Complexity : O(Nlogk) where N is the number of elements in the array
# Space Complexity : O(k) where k is the number of elements in the array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using a min heap to store the k largest elements in the array.
# I am iterating through the array and adding each element to the min heap.
# If the size of the min heap exceeds k, I remove the smallest element from the min heap.
# Finally, I return the smallest element in the min heap which is the kth largest element

from typing import List
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        min_heap = []
        for i in nums:
            heapq.heappush(min_heap,i)
            # print(min_heap)
            if len(min_heap) > k:
                heapq.heappop(min_heap)
                # print(min_heap)
        return min_heap[0]
