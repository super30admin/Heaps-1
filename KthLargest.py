class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
    ## Brute forca Approach TC - O(nlogn) SC - O(1)
    #   ## Sort the array and then return from the end the n-kth element
    #   nums.sort() ## Tc - O(nlogn)
    #   n = len(nums)
    #   return nums[n-k]

     ## Optimize method would be using heap
     ## Tc - O(log k) for insertion and deletion to maintain the heap  so in general O(n log k)
     #SC- O(k) to store in minHeap
        minHeap = []
        for num in nums:
            heapq.heappush(minHeap,num)
            if len(minHeap) >k:
               heapq.heappop(minHeap)
        return minHeap[0]    


        
