import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # use a maxheap - to get kth largest element
        # if we maintain a heap of size n-k+1 and everytime we get new element, we remove element from heap if its full
        # to maintain heap size, then when we get the max element from the heap, we get our answer
        # TC O(Nlog(N-K)) Since we are only maintaining heap of size K, and we have total N elements
        # SC O(N-K) size of the heap
        h = []
        for n in nums: # O(N)
            # we use `-ve` sign to send in numbers as negatives, so it acts as a max heap
            heapq.heappush(h, -n)  # O (log K) 
            if len(h) > len(nums) - k + 1:
                heapq.heappop(h)  # O (log K)
        # return the `-ve` result so number becomes positive again
        return -heapq.heappop(h)  # O (log K)



import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # use a minheap - to get kth largest element
        # if we maintain a heap of size k and everytime we get new element, we remove element from heap
        # to maintain heap size of k, then when we get the min element from the heap, we get our answer
        h = []
        for n in nums:
            heapq.heappush(h, n)
            if len(h) > k:
                heapq.heappop(h)
        
        return heapq.heappop(h)