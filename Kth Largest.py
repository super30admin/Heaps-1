class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        

        #Using Max Heap
        arr = []
        for i in range(len(nums)):
            heapq.heappush(arr, nums[i])
            if len(arr)>k:
                heapq.heappop(arr)
        #We keep popping the smallest elementx, will have top k elements in the end, return first 
        
        
        return arr[0]

Time: Nlog(K)
Space: K