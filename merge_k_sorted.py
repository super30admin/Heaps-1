# Time Complexity :
# O(N log k)

# Space Complexity :
# O(k)

# Did this code successfully run on Leetcode :
#Yes

#We start adding all elements into a min heap. Then after adding k elements, we add a new element to the heap and pop one element (the min of the current heap). What this ensures is that there are at least k elements larger than the min popped element in the heap
#Then at the end,we are left with k of the largest elements in the heap with the k-th largest at the root which we pop and return

from heapq import heappush as insert
from heapq import heappop as remove

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for i,elem in enumerate(nums):
            insert(heap,elem)
            if i >= k :
                remove(heap)
        return remove(heap)
