class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        """
        TC: O(nlogk), k=heapsize
        SC: O(k)
        """
        if not nums: return None
        min_heap=[]
        for num in nums:
            heapq.heappush(min_heap, num)
            if len(min_heap)>k:
                heapq.heappop(min_heap)
        return min_heap[0]

        # # brute force
        # # TC : O(nlogn)
        # nums.sort()
        # for i in range(len(nums)):
        #     if i==n-k:
        #         return nums[i]
        # return -1