#Time O(nlogk) , space O(k)

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
   #Creating min heap     
        min_heap=[]
        heapq.heapify(min_heap)
        
        for i in nums:
            #adding elements
            heapq.heappush(min_heap,i)
            #Removing min ele
            if len(min_heap)>k:
                heapq.heappop(min_heap)
                
        return heapq.heappop(min_heap)
        
