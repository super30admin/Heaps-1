#Time Complexity:O(n log n )
#Space Complexity:O(1), 

#Algorithm: 
#1. Sort the array . 
#2. Pop the element from the aray from the position (len(nums)-k)
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        nums.sort()#O(n log n )
#         
        
        return nums.pop(len(nums)-k)
##################
#
#Time Complexity:O(nlog k)
#Space Complexity:O(k)
#Algorithm:
#Other possibility is to use a min oriented priority queue that will store the K-th largest values. The algorithm iterates over the whole input and maintains the size of priority queue.


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        myHeap = []
        
        for i in range(k):
            heappush(myHeap, nums[i])
            
        for i in range(k, len(nums)):
            heappush(myHeap, nums[i])
            heappop(myHeap)
            
        return heappop(myHeap)
        
