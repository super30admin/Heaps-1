#TimeComplexity O(Nlogk) 
#Space O(k)
# Approach : Here we can just dump all elements into heap and then pop which would be same as sorting , 
# but what if we intsead keep only top k elements in heap which means size of heap would be k swaping ops take O(logK)
# used min heap here , so we keep bottom k elements and we directy return heap[0] which is min element in heap of size K




import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap=[] #in python there is only min heaap
        c=0
        for i in nums:
            if c==k:
                heapq.heappush(heap,i)
                heapq.heappop(heap)
            else:
                c+=1
                heapq.heappush(heap,i)
        # print(heap)
        return heap[0]

        
        
