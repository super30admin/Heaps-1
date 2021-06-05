# TC: O(N logK) where N is the size of the input array which we iterate in order to form the heap internally and log K, since we use to heapify() the heap of size k.  
# SC: O(K) since we store only k largest elements at a time in the heap.
  
  import heapq

    class Solution:
        def findKthLargest(self, nums: List[int], k: int) -> int:
            if not nums: 
                return 

            final = heapq.nlargest(k, nums)
            return final[k - 1]
