#Time Complexity: O(Nlogk)
#Space Complexity: O(k)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
         return heapq.nlargest(k, nums)[-1]