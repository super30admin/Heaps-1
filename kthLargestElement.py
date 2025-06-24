"""
Use min-heap of size k
Push each number; pop if heap grows beyond k
Return the top of the heap which would be the kth largest
"""
"""
Time Complexity: O(N log k) – maintain heap of size k
Space Complexity:O(k) – for heap
"""


import heapq
from typing import List

class kthLargestElement:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for num in nums:
            heapq.heappush(heap, num)
            if len(heap) > k:
                heapq.heappop(heap)
        return heap[0]
    
if __name__ == "__main__":
    obj = kthLargestElement()
    print(obj.findKthLargest([3,2,1,5,6,4], 2))
    print(obj.findKthLargest([3,2,3,1,2,4,5,5,6], 4))
