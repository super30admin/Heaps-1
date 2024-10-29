# approach

# Main the k length min stack if number is less than the top element discard else add to the heap and pop the top element



#Complexities
# Time: O(N(logk))
# space: O(K)



import heapq
from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for num in nums:
            heapq.heappush(heap,num)
            if len(heap)> (k):
                heapq.heappop(heap)
        return heapq.heappop(heap)