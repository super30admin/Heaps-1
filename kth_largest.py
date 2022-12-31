#Time Complexity :  O(n log k)
#Space Complexity :  O(n)
#Did this code successfully run on Leetcode : Yes

#code along with comments 
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        result = []                 #using min heap     
        for i in range(len(nums)):
            if len(result) < k:             #we maintain heap size to be < k
                heapq.heappush(result, nums[i])     #if true we push nums[i] on to heap
            else:
                heapq.heappushpop(result, nums[i])  #otherwise we push heapify and pop the least element
                
        return heapq.heappop(result)            #pop the least element from heap which will be the kth largest element