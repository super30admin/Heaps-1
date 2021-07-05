# Runs on Leetcode
    # Runtime complexity - O(nlogk)
    # Memory complexity - asymptotically, O(1) but originally O(k)
            # k is order of max element required, n is number of elements in array


class Solution:
    import heapq
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if not nums:
            return 0
        
        queue = []
        
        for i in range(len(nums)):
            if len(queue) < k:
                heapq.heappush(queue, nums[i])
            else:
                heapq.heappushpop(queue, nums[i])
                
        return heapq.heappop(queue)