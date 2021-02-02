'''
    Time Complexity:
        O(nlogk)

    Space Complexity:
        O(k)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        MinHeap
        Iterate through nums:
            Add num to the Heap and heapify.
            If the size of the heap > k:
                Remove from Heap and heapify.
        Return the top of the Heap.
'''

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []

        for num in nums:
            heappush(heap, num)

            if len(heap) > k:
                heappop(heap)

        return heap[0]
