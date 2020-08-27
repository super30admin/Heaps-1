#Problem 1: https://leetcode.com/problems/kth-largest-element-in-an-array/
#Test Cases passed on Leetcode 
#Time Complexity:    O(n.logk)
#Space Complexity:   O(k)
#Approach:
#create a min heap that contains k maximum elements at any time.
#Remove min element from the heap
#After traversing the entire array,return top element in the heap 
class Solution:
   
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap=[]
        for n in nums:
            heapq.heappush(heap,n)
            if len(heap)>k:
                heapq.heappop(heap)
        return heap[0]