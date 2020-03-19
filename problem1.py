'''
Time Complexity: O(nlogk)
Space Complexity: O(k)
Did this code successfully run on Leetcode : Yes
Explanation: Add k elements in heap and keep removing elements till you reach the end of list. the last iteration will
have k elements in heap and the min of the heap will be the kth element.
'''


import heapq


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if nums == None or len(nums) == 0:
            return 0

        minHeap = list()

        # print(minHeap)
        # heapq.heapify(minHeap)

        for i in range(0, k):
            heapq.heappush(minHeap, nums[i])

            # print(minHeap)
        for i in range(k, len(nums)):
            # print(minHeap[0])
            if nums[i] > minHeap[0]:
                # print()
                heapq.heappop(minHeap)
                heapq.heappush(minHeap, nums[i])

        return minHeap[0]