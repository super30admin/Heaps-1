#find k largest
#     minheap, add k element to minheap, if nums[i] > minheap[0], then pop and add it, else pass.
#     Time: O(nlgk) where n is the len of array and k is the heap size Space: O(k) 
#     import heapq
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if not nums or not k or k < 0:
            return None

        minheap = []
        for num in nums:
            if len(minheap) < k:
                heapq.heappush(minheap, num)
            else:
                if num > minheap[0]:
                    heapq.heappop(minheap)
                    heapq.heappush(minheap, num)
        return minheap[0]