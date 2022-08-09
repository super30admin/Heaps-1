# Time complexity: O(nlogk)
# Space complexity: O(k)
# Approach: minheap
# use minheap of size k
# after reaching minheap of size k, insert the next element if the element is greater than the root and remove the root. 
# then heapify
# return the root which is the k th largest element.


import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if nums==None or len(nums)==0:
            return -1
        heaplist = []
        for i in range(k):
            heapq.heappush(heaplist,nums[i])
        for j in range(k,len(nums)):
            min = heaplist[0]
            if min < nums[j]:
                heapq.heappop(heaplist)
                heapq.heappush(heaplist, nums[j])
        return heaplist[0]
        
        