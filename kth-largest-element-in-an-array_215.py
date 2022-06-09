#Approach: Min heap
#Time Complexity O(NlogK)
#Space Complexity O(K)
#It successfully runs on leetcode


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if not nums or not k or k < 0:
            return None
        minheap =[]
        for n in nums:
            if len(minheap) <  k:
                heapq.heappush(minheap,n)
            else:
                if minheap[0] < n:
                    heapq.heappop(minheap)
                    heapq.heappush(minheap,n)
            
        return minheap[0]        

#Approach: Max heap
#Time Complexity O(NlogN) +  O(KLogN)
#Space Complexity O(N)
#It successfully runs on leetcode

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if not nums or not k or k < 0:
            return None
        maxheap =[]
        res = None
        for n in nums:
            heapq.heappush(maxheap,-n)
           
        for i in range(k):
            res = -heapq.heappop(maxheap)
            
        return res                
                
                