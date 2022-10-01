#Time: O(logn)
#Space: O(n)
#Program ran on leetcode successfully

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        pq = []
        n = len(nums)
        min_num = float('inf')
        for num in nums:
            heapq.heappush(pq, 0-num)
            if (len(pq) > (n-k)):
                min_num = min(0-heapq.heappop(pq), min_num)
        
        return min_num
                