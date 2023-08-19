# Time Complexity: O(n * log n + n) ==> O(n * log n)
# Space Complexity:  O(1)
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
       
        heapq.heapify(nums)  #O(n)
        l = len(nums) 
        while l: #O(n)
            if l ==k:
                return heapq.heappop(nums) #O(logn)
                break
            heapq.heappop(nums)
            l -= 1
            



        