# Time Complexity :O(nLogk)
# Space Complexity :O(K)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        list_k=[]
        heapq.heapify(list_k)

        for i in nums:
            heapq.heappush(list_k, i)
            if(len(list_k)>k):
                heapq.heappop(list_k)
        return heapq.heappop(list_k)