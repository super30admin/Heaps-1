# tc O(n log k), sc O(k).
minheap = nums[:k]
import heapq
heapq.heapify(minheap)

for idx in range(k, len(nums)):
    if nums[idx] > minheap[0]:
        heapq.heappushpop(minheap, nums[idx])

return minheap[0]