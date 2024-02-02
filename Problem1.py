'''

Time Complexity : O(n log(k))
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced


'''


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # can be implemented in 2 ways.

        #Implementing using min-heap
        '''min_heap = []

        for num in nums:
            heapq.heappush(min_heap,num)
            if len(min_heap) == k+1:
                heapq.heappop(min_heap)


        return min_heap[0]'''

        #Implementing using max-heap
        maxheap = []

        for num in nums:
            heapq.heappush(maxheap,-1 * num)
            n = len(nums)
            if len(maxheap) > n-k+1:
                heapq.heappop(maxheap)



        return -1 * maxheap[0]




