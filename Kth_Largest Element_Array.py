####215. Kth Largest Element in an Array#####################################################################################################
// Time Complexity : logN
// Space Complexity : k
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
To find the k largest element we have used min heap with length of k so we will keep inserting the element and once the length is k+1 we will pop the element to ensure there are only 3 element which are the highest

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        l1=[]
        heapq.heapify(l1)
        for i in nums:
            if len(l1)==k:
                heapq.heappushpop(l1, i)
                #heapq.heappop(l1)
            else:
                heapq.heappush(l1, i)
        return heapq.heappop(l1)
        