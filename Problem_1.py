# Using max heap
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        result = float(inf)
        hp = []
        for num in nums:
            heapq.heappush(hp, -num)
            if len(hp) > len(nums) - k:
                result = min(result, -heapq.heappop(hp))
        return result

# Time Complexity: O(n * log(n-k))
# Space Complexity: O(n-k)


# Using min heap
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        hp = []
        for num in nums:
            heapq.heappush(hp, num)
            if len(hp) > k:
                heapq.heappop(hp)
        return hp[0]

# Time Complexity: O(n * log(k))
# Space Complexity: O(k)
        