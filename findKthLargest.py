# Time Complexity : O(nlogn) as we have to push into a heap
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for num in nums:
            # Using -num so the heap acts like a max heap
            heappush(heap, -num)
        for i in range(k - 1):
            heappop(heap)
        # Since we added "-num", using "-" to the popped elem gets us or original elem
        return -heappop(heap)
