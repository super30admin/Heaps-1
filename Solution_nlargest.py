"""
Used n largest in heapq python to get second largest element. This will be done in O(N log k)

"""

import heapq
class Solution_nlargest:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return heapq.nlargest(k, nums)[-1]
                
        