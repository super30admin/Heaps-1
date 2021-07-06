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