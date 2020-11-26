#Time Complexity : O(nlogk) where n is the length of the list and k is the k largest number
#Space Complexity : O(k) where k is the k largest number
#Did this code successfully run on Leetcode : Yes

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for i in range(len(nums)):
            #if heap is still less then length of k just push to heap
            if len(heap) < k:
                heapq.heappush(heap, nums[i])
            #if heap's length is greater than k then compare the first element with the current element and if it is smaller only then pop it out and push in new element as smallest element of the heap will be the first element in the array
            elif heap[0] < nums[i]:
                heapq.heappop(heap)
                heapq.heappush(heap, nums[i])
        return heap[0]
