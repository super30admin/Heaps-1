# TC: O(N logK) where N is the size of the input array which we iterate in order to form the heap internally and log K, since we use to heapify() the heap of size k.  
# SC: O(K) since we store only k largest elements at a time in the heap."

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if not nums: 
            return

        final = []
        for num in nums: 
            heapq.heappush(final,num)
            if len(final) > k: 
                heapq.heappop(final)
    
        return final[0]
