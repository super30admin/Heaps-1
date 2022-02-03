# Time Complexity : O(nlogk)
# Space Complexity:o(k)
#  Did this code successfully run on Leetcode : Yes

from queue import PriorityQueue

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        pq = PriorityQueue()

        for num in nums:
            pq.put(num)

            if pq.qsize() > k:
                pq.get()


        return pq.queue[0]
