# Time Complexity : O(nlogk) 
# Space Complexity : O(logk)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

import heapq
class Solution:
    # 1) min heap approach
    # def findKthLargest(self,nums,k):
    #     if not nums:
    #         return -1      
    #     st = []
    #     for i in range(len(nums)):
    #         heapq.heappush(st,nums[i])
    #         print(st)
    #         if len(st) > k:
    #             heapq.heappop(st)
    #     return st[0]
        
    # 2) Max heap approach using negative numbers.
    def findKthLargest(self,nums,k):
        if not nums:
            return -1 
        st = []
        for num in nums:
            heapq.heappush(st, -num)
            print(st)
        
        res = None 
        while k != 0:
            res = heapq.heappop(st)
            k -= 1 
        return res
    
if __name__ == "__main__":
    s = Solution()
    nums = [3,2,1,5,6,4]
    k = 2 
    res = s.findKthLargest(nums, k)
    print(-res)