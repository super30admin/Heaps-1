import heapq


class Solution:
    """
    Min heap approach
    TC - nlogk
    """

    def approach1(self, nums, k):
        pq = []
        for num in nums:
            heapq.heappush(pq, num)
            if len(pq) > k:
                heapq.heappop(pq)
        return pq[0]

    """
    Max heap appraoch
    TC - nlogk
    """

    def approach2(self, nums, k):
        pq = []
        result = -99999
        for num in nums:
            num = -1 * num
            heapq.heappush(pq, num)
            if len(pq) > len(nums) - k:
                t = heapq.heappop(pq)
                result = max(result, t)
        return -1 * result

    def findKthLargest(self, nums: List[int], k: int) -> int:
        if not nums:
            return -1
        # return self.approach1(nums,k)
        return self.approach2(nums, k)