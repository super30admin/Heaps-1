"""
Problem : 1

Time Complexity : O()
Space Complexity : 
MinHeap - O()

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""

# Kth largest in Array


# Approach - 1
# MaxHeap

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:

        nums=[-n for n in nums]

        heapq.heapify(nums)

        while k>1:
            heapq.heappop(nums)
            k-=1

        return -nums[0]

# Approach - 2
# MinHeap

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:

        heapq.heapify(nums)
        n=len(nums)
        count=0
        while n-k>count:
            heapq.heappop(nums)
            count+=1
        return nums[0]
    
# Approach - 3
# MinHeap of size(k)

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        pq=[]
        heapq.heapify(pq)

        for i in range(len(nums)):
            heapq.heappush(pq,nums[i])
            
            if len(pq)>k:
                heapq.heappop(pq)
        return pq[0]