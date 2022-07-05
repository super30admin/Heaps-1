import heapq as heap
class Solution(object):
    '''Time Complexity: O(nlogk)
    Space Complexity: O(k)'''
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        #Edge case
        if len(nums)==0:
            return None
        
        #Create an empty list which act as a min heap
        minheap=[]
        #print(nums)
        
        #Creating a min heap of size k
        for i in range(k):
            heap.heappush(minheap,nums[i])
        #print(minheap)
        
        #Now for the remaining elements
        for i in range(k,len(nums)):
            topmin=minheap[0]
            if topmin<nums[i]:
                heap.heappushpop(minheap,nums[i])
                
        return minheap[0]
        
