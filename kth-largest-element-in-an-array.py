'''

TC: O(nlogk)
SC: O(k)

'''
import heapq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        arr = list()
        
        if not nums:
            return -1
        
        l = 0
        for n in nums:
            if l != k:
                heapq.heappush(arr, n)
                l += 1
            else:
                if n > arr[0]:
                    heapq.heappushpop(arr, n)
        
        return arr[0]
