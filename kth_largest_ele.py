"""215. Kth Largest Element in an Array
Time Complexity: O(nlogk)
Space Complexity: O(k)"""
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        import heapq
        minheap = []
        # maintain the k largest elements in minheap and then
        #call peek.
        for num in nums:
            heapq.heappush(minheap,num)
            if len(minheap)>k:
                heapq.heappop(minheap)
        return heapq.heappop(minheap)
        