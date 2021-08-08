# Time Complexity : O(nlogk) Where k is the largest Number
# Space Complexity : O(k)

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for i in range(len(nums)):
            #if heap size is less than k, then push the value to it
            if len(heap) < k:
                heapq.heappush(heap, nums[i])
            #if length of heap is greater than k, then compare the current element with the first element
            # if it is small, then pop it and push the next new element from the array
            # smallest element of the heap will be the first element in the array
            elif heap[0] < nums[i]:
                heapq.heappop(heap)
                heapq.heappush(heap, nums[i])
        return heap[0]