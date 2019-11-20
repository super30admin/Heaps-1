# Leet code - 215 - kth largest element - https://leetcode.com/problems/kth-largest-element-in-an-array/
# Time compexity - O(Nlogk)  when we brute force - O(NlogN)
# MIN HEAP approach

import heapq
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        pq=[]
        for i,v in enumerate(nums):
            if i <k:
                heapq.heappush(pq,v)
                print(pq)
            else:
                if v<=pq[0]:
                     continue
                heapq.heappop(pq)
                heapq.heappush(pq,v)
                print(pq)
        return heapq.heappop(pq)




import heapq
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        pq=nums[:k]
        heapq.heapify(pq)
        for i in (nums[k:]):
            heapq.heappush(pq,i)
            heapq.heappop(pq)
        return pq[0]
    