# TC: O(N logN)
# SC: O(N)
import heapq
class Solution:
    def findKthLargest(self, nums, k):
        pq = []
        # TC: O(n log n)
        for each in nums:
            heapq.heappush(pq, -1 * each)
        # TC: O(k)
        while k > 1:
            heapq.heappop(pq)
            k -= 1
        return -1 * heapq.heappop(pq)

# TC: O(n log k)
# SC: O(k)
class Solution:
    def findKthLargest(self, nums, k):
        pq = []

        for each in nums:
            heapq.heappush(pq, each)
            if len(pq) > k:
                heapq.heappop(pq)
        return heapq.heappop(pq)
    

s = Solution()
nums = [3,2,1,5,6,4]
k = 2
print(s.findKthLargest(nums, k))

