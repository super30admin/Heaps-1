#Kth Largest Element in an Array

# make every elemnt as negate and push every element into the list (To represent max heap), and heapify it will be logN once and On for iterating over the each elemnt in array
# then for k-1 times just pop the element in the end the negated value of topmost elemnt is result
# Time complexity -> nLog(k) -> 
# space -> Ok



import heapq
from typing import List

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        minHeap = []

        for num in nums:
            heapq.heappush(minHeap,num)
            print("before Pop", minHeap)
            if len(minHeap) > k:
                heapq.heappop(minHeap)                        
                print("After Pop", minHeap)

        
        return -minHeap[0]
    
sol = Solution()
print(sol.findKthLargest([3,2,1,5,6,4], 2))