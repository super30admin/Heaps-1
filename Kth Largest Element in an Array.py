# time complexity is o(nlogk), where n is the size of the input, and k is given in the input
# space complexity is o(k)
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if(nums == None or len(nums) == 0):
            return -1
        from heapq import heappush
        from heapq import heappop
        
        heap = list()
        for n in nums:
            heappush(heap, n) #adding element to heap
            if(len(heap) > k):
                heappop(heap)
        return heap[0]
                