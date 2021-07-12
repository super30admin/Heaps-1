# Time Complexity: O(n log k)
# Space Complexity: O(k)
import heapq


class Solution:
    def findKthLargest(self, nums, k):
        #         define list
        heapm = []
        #     add k elements to the heap and start the staring index from k to add other elements from the list
        for i in range(k):
            heapq.heappush(heapm, nums[i])
        start = k
        # Iterate over the list and if any other number is greater than
        # top element in heap then we will pop the root and add the current element from the list and heapify the heap
        for i in range(start, len(nums)):
            if nums[i] > heapm[0]:
                heapq.heappop(heapm)
                heapq.heappush(heapm, nums[i])
                heapq.heapify(heapm)
        #         In the end we will return the kth largest number which will be at
        #         the root of the heap we built
        return heapm[0]



