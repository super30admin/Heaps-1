# Time Complexity : O(nlogk)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We use a min-heap to keep track of the k largest elements.
# As we add elements, we remove the smallest if the heap grows beyond size k.
# In the end, the top of the heap gives us the k-th largest number.

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        pq = []
        for num in nums:
            heapq.heappush(pq, num)
            if len(pq) > k:
                heapq.heappop(pq)
        return pq[0]
        
