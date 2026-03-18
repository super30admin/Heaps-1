# Time Complexity : O(n log k)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use a min-heap of size k.
# Iterate through the array and push each element into the heap.
# If the heap size exceeds k, remove the smallest element.
# At the end, the heap contains k largest elements, and the top
# of the heap is the k-th largest element.


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        pq = []
        for i in nums:
            heapq.heappush(pq,i)
            if len(pq) > k:
                heapq.heappop(pq)
        return heapq.heappop(pq)
