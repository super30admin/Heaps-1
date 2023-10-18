# Time Complexity: O(nlg(k)) where n is length of nums and k is the kth largest number.
#  Space Complexity:  O(k).
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # min heap
        # li = []
        # heapq.heapify(li)
        # for i in nums:
        #     heapq.heappush(li, i)
        #     if len(li) > k:
        #         heapq.heappop(li)
        # return li[0]

        li = []
        heapq.heapify(li)
        res = float("inf")
        for i in nums:
            heapq.heappush(li, -i)
            if len(li) > len(nums)-k:
                m = -1 * heapq.heappop(li)
                res = min(m,res)
        return res
