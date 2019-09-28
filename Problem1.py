# Did this code successfully run on Leetcode : Yes
# Time Complexity: O(n*logk) (We keep only k elemnt in the heap so adding elment is heap is O(log n) so for n element time complexity is O(n logk))
# Space Complexity: O(k) (where k is number of element we keep in heap)

# Three line explanation of solution in plain english:
# - Use min heap to store all the numbers.
# - Add number in the heap one by one, if the size of heap is more than k (from kth largest elemnt) remove the element from the heap.
# - After adding all the elements this way, top of the heap will be our answer. 


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
#       Initialize heap
        heap = []
#       Iterate over all numbers
        for num in nums:
#           Add numbers to the heap
            heapq.heappush(heap, num)
#           If size of the heap exceeds k than remove top of the heap
            if len(heap) > k:
                heapq.heappop(heap)
#       In the end return top of the heap.
        return heapq.heappop(heap)
        
        
