# Using min heap
#Time Complexity: O(nlogk)
#Space Complexity: O(k)
#Successfully ran on leetcode
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        h = []
        for i in nums:
            heapq.heappush(h,i)
            if len(h)>k:
                heapq.heappop(h)
        return heapq.heappop(h)

#Using max heap
#Time Complexity:O(nlog(n-k))
#Space Complexity:O(n-k)
#Successfully ran on leetcode

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        h = []
        result = float('inf')
        for i in nums:
            heapq.heappush(h,-i)
            if len(h)>len(nums)-k:
                result = min(result,-heapq.heappop(h))   
        return result
    
        