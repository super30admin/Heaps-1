# TC: O(N logK) :  log K for heapify() the heap of size k.  
# SC: O(K) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if len(nums)==0:
            return -1
        
        result = []
        #maintain a minheap of size k
        for i in nums:
            heapq.heappush(result,i)
            #print('--push--')
            #print(result)
            if len(result)>k:
                #print('--pop--')
                heapq.heappop(result)
                #print(result)

        return result[0]

#kth smallest
import heapq
class Solution:
    def kthSmallest(self,arr, l, r, k):
        '''
        arr : given array
        l : starting index of the array i.e 0
        r : ending index of the array i.e size-1
        k : find kth smallest element and return using this function
        '''
        
        result = [] 
        #maxheap - to store in maxheap negate the value when inserting 
        
        for i in range(len(arr)):
            heapq.heappush(result,-1*arr[i])
            if len(result)>k:
                heapq.heappop(result)
                
        #-1*result since val negated during insertion
        return -1*result[0]
