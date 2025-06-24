
# Approach:
# - Method 1 (findKlargest): Use a min-heap of size k.
#   - Push each number into the heap.
#   - If heap size exceeds k, pop the smallest.
#   - The root of the heap is the k-th largest element.

# - Method 2 (findKlargest_dumb): Use Python's built-in heapq.nlargest to get the top k elements and return the last one.

# Time Complexity:
# - Both methods: O(n log k), where n = len(nums)

# Space Complexity:
# - Both methods: O(k), for storing the heap


import heapq
class Solution:
    def findKlargest(self, nums, k):
        minHeap = []
        for num in nums:
            heapq.heappush(minHeap, num)
            if len(minHeap) > k:
                heapq.heappop(minHeap)
        return minHeap[0]
    
    def findKlargest_dumb(self, nums, k):
        return heapq.nlargest(k, nums)[-1]

def main():
    sol = Solution()

    # Test Case 1
    nums1 = [3, 2, 1, 5, 6, 4]
    k1 = 2
    print(f"Input: {nums1}, k={k1} → Output: {sol.findKlargest(nums1, k1)}")

    # Test Case 2
    nums2 = [3, 2, 3, 1, 2, 4, 5, 5, 6]
    k2 = 4
    print(f"Input: {nums2}, k={k2} → Output: {sol.findKlargest(nums2, k2)}")


if __name__ == "__main__":
    main()
