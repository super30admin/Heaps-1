import heapq
class Solution:
    def findKthLargest(self,nums,k):
        min_heap=[]

        for num in nums:
            heapq.heappush(min_heap,num)
            if len(min_heap)>k:
                heapq.heappop(min_heap)
        return min_heap[0]

param_1=[3,2,1,5,6,4]
param_2=2
sol=Solution().findKthLargest(param_1,param_2)
print(sol)