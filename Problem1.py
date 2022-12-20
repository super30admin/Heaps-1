#Time complexity: O(nlogk)
#Space complexity: O(k)

#Accepted on Leetcode

#Approach:
#Use a min-heap and keep it's size constrained to k
#For each element added after k -> push it, then extract min
#Thus, at the end the root of the heap would be the kth largest element in the array

import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        #create empty heap and let it's max capacity be k
        heap = []
        heapq.heapify(heap)
        capacity = k
        #insert up till capacity
        for i in range(capacity):
            heapq.heappush(heap, nums[i])
        #maintain size as k by pushing then popping minimum
        for i in range(capacity, len(nums)):
            heapq.heappush(heap,nums[i])
            heapq.heappop(heap)

        #return top of the heap
        return heapq.nsmallest(1, heap)[0]