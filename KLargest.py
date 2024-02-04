# Problem1 Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        from queue import PriorityQueue
        pq = PriorityQueue()
        for i in nums:
            pq.put(i)
            if pq.qsize() > k:
                pq.get()
        return pq.queue[0]

# Time complexity O(nlogk)
# space complexity O(k)