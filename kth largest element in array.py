# TC: O(nlogn)
# SC: O(n)

class Solution:
    def findKthLargest(self, nums, k):
        nums.sort(reverse=True)
        return nums[k - 1]

#minimum heap
# TC: O(nlogk)
# SC: O(k)
class Solution:
    def findKthLargest(self, nums, k):
        heap = []
        for num in nums: #n
            heapq.heappush(heap, num) #logk
            if len(heap) > k:
                heapq.heappop(heap) #logk
        
        return heap[0]
    
#maximum heap
# TC: O(nlogk)
# SC: O(k)
class Solution:
    def findKthLargest(self, nums, k):
        heap = []
        n = len(nums)
        for num in nums: #n
            heapq.heappush(heap, -1*num) #logk
            if len(heap) > n-k+1:
                heapq.heappop(heap) #logk
        
        return -1*heap[0]