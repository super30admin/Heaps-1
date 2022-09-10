# Time Complexity : O(N * logk) # N = size of nums && K = height of heap
# Space Complexity : O(k)

# Storing elements from nums in min heap and then popping* out as soon as size of heap = k
# * because we want to find max elements and popping out will give us min elements. So, at the end 
# only 4 elemets will be left in min-heap. Bottom one will be max and top one will be kth max.
# Because size of out heap is maintained k

import heapq


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        hq = []
        
        for i in nums:
            heapq.heappush(hq, i)
            
            if len(hq) > k: 
                heapq.heappop(hq)
                
        return heapq.heappop(hq)
