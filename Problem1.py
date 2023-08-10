from queue import PriorityQueue


class Solution:
    # Time Complexity: O(Nlogk)
    # Space Complexity: O(k)
    def findKthLargest(self, nums: List[int], k: int) -> int:
        q = PriorityQueue()
        for i in range(0, len(nums)):
            q.put(nums[i])
            if q.qsize() > k:
                q.get()
        return q.get()
