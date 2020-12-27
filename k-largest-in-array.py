# t = O(nlogk) - min heap
#     O(nlog(n-k)) - maxheap
# s - O(1)

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        import heapq
        # heapq.heapify(nums)
        return heapq.nsmallest(len(nums)-k+1,nums).pop() #maxheap
        # return heapq.nlargest(k,nums).pop() #minheap