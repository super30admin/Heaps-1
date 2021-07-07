import heapq
from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        """
            https://leetcode.com/problems/kth-largest-element-in-an-array/
            Time Complexity - O(nlogk)
                'n' is the number of elements,
                'k' is the size of priority queue at any point in time
            Space Complexity - O(k)
            Three lines explanation - (Using min heap)
                - Add elements to the priority queue
                - If the size of the priority queue is greater than
                  k, pop the minimum element.
                - The minimum element on the top of the heap is the
                  kth largest element.
        """
        pq = []
        for num in nums:
            heapq.heappush(pq, num)
            if len(pq) > k:
                heapq.heappop(pq)
        return pq[0]

    def findKthLargest(self, nums: List[int], k: int) -> int:
        """
           https://leetcode.com/problems/kth-largest-element-in-an-array/
           Time Complexity - O(klogn)
               'n' is the number of elements,
               'k' is the size of priority queue
           Space Complexity - O(n)
           Three lines explanation - (Using max heap)
               - Add elements to the priority queue
               - Pop elements until we reach k
        """
        pq = []
        for num in nums:
            heapq.heappush(pq, -num)
        i = 1
        while i < k:
            heapq.heappop(pq)
            i += 1
        return -result


if __name__ == '__main__':
    Solution().findKthLargest([3, 2, 1, 5, 6, 4], 2)
