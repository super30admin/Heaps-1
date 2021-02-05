# Minheap
# TC: O(nlogk)
# SC: O(k) 
# create min heap and maintain k largest elements at any instant
# At the end, the last element(peek) in the queue is Kth largest
import heapq
class Solution:
    def findKthLargest(self, nums, k):
        return heapq.nlargest(k, nums)[-1]