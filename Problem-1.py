#T.C = O(nlog(n−k)) S.C = O(n−k)
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        heap = []
        result = 99999999999999999999
        n = len(nums)

        for i in range (n-k):
            heapq.heappush(heap,-nums[i])
        
        for i in range(n-k,len(nums)):
            heapq.heappush(heap,-nums[i])
            pop = heapq.heappop(heap)
            result = min(-pop,result)

        return result        