class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        min_heap=[]
        for num in nums:
            if len(min_heap)<k:
                heapq.heappush(min_heap,num)
            else:
                if num>min_heap[0]:
                    heapq.heappop(min_heap)
                    heapq.heappush(min_heap,num)
        return min_heap[0]


# Time complexity: N log k (n to access each and every element in nums, and log k to re-arrange every 
#element in the heap)
# Space complexity: O(k) to store k elements in the heap