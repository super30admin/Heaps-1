''''
Time Complexity: O(nlogk)
Space Complexity: O(k)
Executed on Leet: Yes
'''



class cl:
    def __init__(self, data):
        self.data = data

import heapq as hq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        setattr(cl,'__lt__',lambda self,other: self.data > other.data)
        result = float('inf')
        heap = list()
        for num in nums:
            ob = cl(num)
            hq.heappush(heap, ob)
            if len(heap) > len(nums) - k:
                result = min(result,hq.heappop(heap).data)
        return result