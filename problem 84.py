# https://leetcode.com/problems/merge-k-sorted-lists/

# Time Complexity : O(n * logk)
# Space Complexity : O(k) for storing k largest elements
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        ans = []
        for n in nums:
            heapq.heappush(ans,n)
            if (len(ans)>k):
                heapq.heappop(ans)
        
        return ans[0]

# TC : O(n * logk) for n each elements we heapify it for upto k elements
# SC: O(k) heap will only be for k elements and then we return the top element