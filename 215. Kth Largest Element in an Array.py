T = O(nlogk)
S = O(k)
Approach:
Store the list in a min heap;
Keep pipoing the heap untill the lenght of the array is k
the top element on the heap is now the kth largest element

from heapq import heapify,heappop
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heapify(nums)
        while(len(nums) > k):
            heappop(nums)
        return heappop(nums)