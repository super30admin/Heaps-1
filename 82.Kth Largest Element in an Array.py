import heapq


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        h = []  # to create heap
        # looping through the list
        for i in range(len(nums)):
            # heappush will push elements the list in ascending order
            heapq.heappush(h, nums[i])
            # if the length of the heap i.e is greater than k = 2 it will pop smallest element
            if len(h) > k:
                # whenever the heap length is greater than the k it will pop the smallest element and the length of
                # the list will remain equal to k 
                heapq.heappop(h)
                # now only 2 largest elements wil be remaining and returning the smallest will give us Kth element
        return heapq.heappop(h)
