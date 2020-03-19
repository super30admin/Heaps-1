# TIme complexity --> O(n logk) where n is the length of the nums
#space complexity --> O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
Description:
we create a minheap with k elements and then try to insert the other elements if they are greater than least element in the minheap.In this way traverse thorugh the whole loop and then at the end of the given list we end up with only three largest elements in the array.

import heapq
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if nums==None or len(nums)==0:
            return 0
        h=[]
        #convert the list to a heap
        heapq.heapify(h)
        #create a hep of k elements
        for i in range(k):
            heapq.heappush(h,nums[i])
        #make the heap contain the three greatest numbers in the list
        for i in range(k,len(nums)):
            if nums[i]>h[0]:
                heapq.heappop(h)
                heapq.heappush(h,nums[i])
        return heapq.heappop(h)
        