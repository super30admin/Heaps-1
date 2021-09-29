# // Time Complexity : O(n*lgk) where k stands for number of unique messages
# // Space Complexity : O(k) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for num in nums:
            heapq.heappush(heap,num)
            
            if len(heap) > k:
                heapq.heappop(heap)
        return heap[0]