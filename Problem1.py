# Time Complexity: O(nlogk)
# Space Complexity: O(k)
# Did this code successfully run on Leetcode: all test cases passed
# Any problem you faced while coding this: No

# Approach: approach is to use the priority queue and only have k elements in the queue and pop the kth largest element



import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        queue = []

        for i in nums:

            heapq.heappush(queue, i)

            if len(queue) > k:
                heapq.heappop(queue)
            
            print(queue)

        return queue[0]