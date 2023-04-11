class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
# Approach 1 Min Heap
# Time: O(n)
# Space: O(n)
# heapq.heapify(nums)
# while len(nums) > k:
#     heapq.heappop(nums)
# return nums[0]

# Approach 2: Optimised Min Heap (Fastest)
# Time: O(n)
# Space: O(n)
# h = nums[:k] # Create a heap of size k
# heapq.heapify(h)
# for i in range(k, len(nums)):
#     if nums[i] > h[0]: # Only greater elements than root val should be appended to the minheap
#         heapq.heappushpop(h, nums[i])
# return h[0]


# # QUICKSELECT ALGORITHM
# k = len(nums) - k

# def qs(l, r):
#     pivot, p = nums[r], l
#     for i in range(l, r):
#         if nums[i] <= pivot:
#             nums[p], nums[i] = nums[i], nums[p]
#             p+=1
#     nums[p], nums[r] = nums[r], nums[p]

#     if p>k:   return qs(l, p-1)
#     elif p<k: return qs(p+1, r)
#     else:     return nums[p]

# # return qs(0, random.randint(0, (len(nums)-1)))
# return qs(0, len(nums)-1)

