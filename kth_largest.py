# Algorithm:
# 1. create min heap, restrict size = k. Want to keep only the k largest elements in heap
# 2. push elements into min heap one by one
# 3. once size of min heap crosses k, pop out of min heap
# 4. at the end of iterating through the list, heap will have only k largest elements left in it
# 5. pop one last time and return that value

# Time Complexity: O(n log k)
# Space Complexity: O(k)

import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        return heapq.nlargest(k, nums)[-1]