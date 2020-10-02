import heapq
class Solution(object):
    # Time Complexity - O(nlogn)
    # Space Complexity - O(1)
    def findKthLargest1(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        newArray = sorted(nums)
        return newArray[len(nums)-k]
    # Time Complexity - O(nlogk)
    # Space Complexity - O(k)
    def findKthLargest2(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        h = []
        for i in range(k):
            heapq.heappush(h, nums[i])
        for i in range(k,len(nums)):
            if h[0] < nums[i]:
                heapq.heappop(h)
                heapq.heappush(h, nums[i])
        return h[0]
        
        
        
        