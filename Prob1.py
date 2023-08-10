#In Min heap, we add elements from array to the heap and each time we check if heap grows more than k, if it does, pop out the top most element. In the end, just return the top element.
#The key idea is that, once k elements are in the heap k+1th element will be too small to be the kth biggest, so pop it out. IN the end, 0th element will be kth biggest 
#TC-O(nlogk), SC-O(k)

#In Max heap, we add elements from array to the heap and each time we check if heap grows more than (n-k), if it does, pop out the top most element and compare if it's minimum than currest res variable. In the end, just return res.
#The key idea is that, once n-k elements are in the heap, k+1th element will breach the length condition. We take min, to make sure to get the kth -> Dry run and you'll get it
#TC-O(nlog(n-k)), SC-O(n-k)

import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        #method 1 - brute force sort - O(nlogn)
        # nums.sort()
        # return nums[len(nums)-k]
        #Method 2 - Min heap - TC-O(nlogk), SC-O(k)
        # heap=[]
        # for num in nums:
        #     heapq.heappush(heap,num) #log k
        #     if len(heap)>k: #O(1) -> same as len(array) operation -> O(1)
        #         heapq.heappop(heap) #log k

        # return heap[0] #O(1)
        #Method 3 - Max Heap -TC-O(nlog(n-k)), SC-O(n-k)
        heap=[]
        n=len(nums)
        res=float('inf')
        for num in nums:
            heapq.heappush(heap,-num) #(-negative, since python doesn't have direct implmenetation of max heap)
            if len(heap)>n-k:
                res=min(res,-heapq.heappop(heap)) #(-negative, since python doesn't have direct implmenetation of max heap)
        return res

        
            
