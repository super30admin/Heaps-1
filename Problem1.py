
'''
Problem: Kth Largest Element in an Array
Time Complexity: O(nlog k) where n is length of array
Space Complexity: O(k), heap space
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        create a min heap of size k
        iterate over array and if larger element then pop and push to heap
        at the end top element of heap will be the kth largest

'''

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        heapq.heapify(heap)
        i = 0

        while i!=k:
            heapq.heappush(heap, nums[i])
            i+=1
        
        for i in range(k, len(nums)):
            if nums[i]>heap[0]:
                heapq.heappop(heap)
                heapq.heappush(heap, nums[i])
        
        return heap[0]