#215. Kth Largest Element in an Array
"""
Time Complexity : O(n logk) n = size of nums k = height of heap
Space Complexity : O(k)

Storing elements from nums in min heap and then popping* out as soon as size of heap = k

* because we want to find max elements and popping out will give us min elements. So, at the end 
only 4 elemets will be left in min-heap. Bottom one will be max and top one will be kth max.
Because size of out heap is maintained k
"""
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        hq = []
        
        for i in nums:
            heapq.heappush(hq, i)
            
            if len(hq) > k: #maintaining size of heap. This saves TC and SC. 
                            #If not done then TC is n log n which is equal to quick sort approach
                heapq.heappop(hq)
                
        return heapq.heappop(hq)
