#Time Complexity : O(nlogn)
#Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        hp = []
        for i in nums:
            if len(hp)==k:
                heappushpop(hp, i)
            else:
                heappush(hp, i)
        return heappop(hp)