
'''Heaps Based Solution'''
# Time Complexity : Nlog(k) N is size of nums and k is the input parameter k
# Space Complexity : O(k) for maintaining the heap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''Main Idea'''
# Maintain a minheap of size k
# This means that that the kth largest element will always be on the top of the heap

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        heap = []
        for num in nums:
            if len(heap) == k:
                heapq.heappushpop(heap, num)
            else:
                heapq.heappush(heap, num)
        
        return heap[0]




'''Quick Select Based Solution'''
# Time Complexity : O(N) in average O(N ^ (2)) in worst case when input is sorted and we always take the first element as pivot
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''Main Idea'''
# Randomly pick a pivot. Use a partition function (like quick sort) to find the correct position of the partition
# If the position of the pivot is N - k (we found answer)
# If position of pivot is less than N - k then search in right side
# If position of pivot is more than N - k then search on left side

import random
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        def partition(lo, hi):
            pivot = random.randint(lo, hi)
            nums[lo], nums[pivot] = nums[pivot], nums[lo]
            
            left = lo + 1
            right = hi
            
            while left <= right:
                while left <= hi and nums[left] <= nums[lo]:
                    left += 1
                
                while right > lo and nums[right] > nums[lo]:
                    right -= 1
                
                if left < right:
                    nums[left], nums[right] = nums[right], nums[left]
            
            nums[lo], nums[right]  = nums[right], nums[lo]
            return right

        def recur(lo, hi):
            
            mid = partition(lo, hi)
            if mid == len(nums) - k:
                return nums[mid]
            
            if mid > len(nums) - k:
                return recur(lo, mid - 1)
            
            else:
                return recur(mid + 1, hi)
        
        
        return recur(0, len(nums) - 1)