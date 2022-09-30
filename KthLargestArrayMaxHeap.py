"""
Time Complexity : O(nlogn-k) where n is the number of elements in the array. logk is the complexity for heapyfi function and we are calling it for every element hence nlog(n)
Space Complexity : O(n-k) as heap will store k elements at a particular time.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
1. Add every element to the heap, heapify will take place whenever add or remove function is performed.
2. If heap has more than n-k elements pop the peek element from heap. As this is the max Heap, it will always have max element at the peek and hence we will get k minimum elements in the heap.
3. At the end return the minimum element pop from the stack as it will be the kth largest element.
"""
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if len(nums) == 0:
            return None
        heap = []
        n = len(nums)
        minimum = float('inf')
        for num in nums:
            heapq.heappush(heap, -1*num)
            
            if len(heap) > n-k:
                minimum = min(minimum, heapq.heappop(heap)*-1)
        
        return minimum
        