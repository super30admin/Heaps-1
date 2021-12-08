# 215. Kth Largest Element in an Array
# https://leetcode.com/problems/kth-largest-element-in-an-array/

# Logic: Maintain a minheap of size k. If the size goes 
# more than k then pop an element from the heap. Return 
# the root (res[0]]) of the heap.

# Time Complexity: O(nlogk)
# Space Complexity: O(k)

import heapq
class Solution:
    def findKthLargest(self, nums, k: int) -> int:
        res = []

        for i in nums:
            heapq.heappush(res,i)
            if len(res) == k + 1:
                heapq.heappop(res)
        return res[0]

obj = Solution()
print(obj.findKthLargest([3,2,1,5,6,4],2))
print(obj.findKthLargest([3,2,3,1,2,4,5,5,6],4))