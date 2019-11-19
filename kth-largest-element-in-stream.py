'''
Did it run leet code: Yes
Did you face any problem : No

Time complexity: 0(NlogN)
Space Complexity: 0(N)

Algorithm:
- Create a max heap out of elements in the array list.
- pop out of max-heap k times.
- you will get the kth largest element in the stream

'''


import heapq
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        heap = []
        for num in nums:
            heap.append((-1*num,num))
        heapq.heapify(heap)
        poppedElement = None
        for i in range(k):
            poppedElement = heapq.heappop(heap)
        return poppedElement[1]