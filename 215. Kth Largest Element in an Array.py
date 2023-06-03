#Time Complexity:O(nlogn)
#Space Complexity:O(n)

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        heap = []
        for num in nums:
            heapq.heappush(heap, num)
        n=len(nums)
        k=n-k
        while(k>=0):
            k-=1
            pop=heapq.heappop(heap)
        return pop