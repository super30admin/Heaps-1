# Time: O(n log n)
# Space: O(n)

# this is the simplest solution, 
# We sort the array and return the k-th largest element
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        s = sorted(nums)
        idx = len(nums) - k
        return s[idx]


# HEAP SOLUTION
# Time: O(n log k)
# Space: O(k) for the heap stack

# We use the min heap because we want to keep the k largest elements
    # The way we keep it is we just delete the the smallest element that comes after k elements in the heap
    # Hence we are left with the top k largest elements 
# At the end we return the top of the heap which is the smallest element in the heap, and hence the k-th largest element in the array
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []

        for num in nums:
            heapq.heappush(heap,num)
            if len(heap) > k:
                heapq.heappop(heap)
        
        return heap[0]