'''
Time Complexity - O(nlogk)
Space Complexity - O(log k)

This code works on leetcode.
'''
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        pq = [] #heap created. default minheap.
        for num in nums:
            heapq.heappush(pq,num) #push element into minheap
            if len(pq) > k: #when the size exceeds k, we popout the min as we need to return the kth largest element
                heapq.heappop(pq)
        return heapq.heappop(pq) #at the end the kth largest element will be the smallest element in the heap
        
        