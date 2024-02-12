#Time Complexity :  O(k log k + (n - k) log k)
#Space Complexity :O(k)
#Did this code successfully run on Leetcode : yes


from ast import List
import heapq


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []

        for i in nums[:k]:
            heapq.heappush(heap, i)
        
        for num in nums[k:]:
            if num > heap[0]:
                heapq.heappop(heap)
                heapq.heappush(heap, num)
        
        return heap[0]
