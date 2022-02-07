# Time Complexity :
# TC: O(NlogK)

# Space Complexity :
# SC: O(k)

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach
# I have maintained a min heap of size k by inserting value in heap one by one
# When the k+1 element comes i insert it into heap and then remove min of the heap
# In this way when all the elements of list are processed heap will contain k largest elements of list
# And out of this k elements min will be kth largest.

class Solution:
    
    # Min Heap solution
    # TC: O(NlogK)
    # SC: O(K) --> size of heap
    
    def findKthLargest(self, nums: List[int], k: int) -> int:
        import heapq
        hp = []
        heapq.heapify(hp)
        
        for e in nums:
            heapq.heappush(hp, e)
            if (len(hp) > k):
                heapq.heappop(hp)
                
        return heapq.heappop(hp)