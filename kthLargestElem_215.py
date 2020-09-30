# // Time Complexity : O(n logk), log k to push n elements on the heap
# // Space Complexity : O(k)
# // Did this code successfully run on Leetcode : Yes 
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 

# Approach 1: Brute Force
# Sort the array and return N-Kth element -> Time Complexity: O(N logN)

# Approach 2: Use Maxheap
# Build a maxheap from the given nums array and remove kth largest element -> Time Complexity: O(N logN)

# Approach 3: Use Minheap (as coded below)
# To get the Kth largest element, we can either remove the first K-1 elements or iterate N-K steps back 
# Why not create a minheap that has a size of K and as soon as size increases, we remove the element going forward
# When we do this, we'll end up with a minheap that has root as our Kth largest value

import heapq

class Solution:
    
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        minHeap = []
        
        for num in nums:
            #keep pushing elements one by one
            heapq.heappush(minHeap, num)
            
            #when size increases than k, remove an element
            if len(minHeap) > k:
                heapq.heappop(minHeap)
        
        return heapq.heappop(minHeap)
