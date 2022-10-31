import heapq
class Solution:
    def findKthLargest(self, nums, k):
        heap = []
        heapq.heapify(heap)
        
        for num in nums:
            heapq.heappush(heap, num)
            if len(heap) > k:
                heapq.heappop(heap)
        return heapq.heappop(heap)

if __name__ == "__main__":
    s = Solution()
    nums = [3,2,1,5,6,4]
    k = 2
    print(s.findKthLargest(nums, 4))

        