# time: O(NlogK) - N is total num of elements, push pop from heap of max size k is O(logk), repeated N times
# space: O(k) - store at most k elements in heap
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # the sorted() method in python is O(nlogn) - slow
        nums_heap = []
        # O(n)
        for i in nums:
            nums_heap.append(-i)
     
        # before heap: [-3, -2, -1, -5, -6, -4]
        # default is to create a min heap, which means smallest element is at root
        heapq.heapify(nums_heap)
        # after heap: [-6, -5, -4, -3, -2, -1]
        count = 0
        # pop from heap to get kth largest
        while nums_heap and count < k:
            # heap operations take logk time
            val = heapq.heappop(nums_heap)
            val = -val
            count += 1
        
        # overall time complexity is O(nlogk)
        return val 

# by popping whenever heap size exceeds k, the code constantly throws away the smallest element currently in the heap
# time: O(NlogK) - N is total num of elements, push pop from heap of max size k is O(logk), repeated N times
# space: O(k) - store at most k elements in heap
class Solution:
    def findKthLargest(self, nums, k):
        pq = []
        for i in range(len(nums)):
            heapq.heappush(pq, nums[i])
            if len(pq) > k:
                heapq.heappop(pq)
        return pq[0]