# Problem1: Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)
# Time complexity: O(n log k)
# n is the total number of elements in nums
# for every element we push it into the heap, which costs O(log k)
# since the heap size never grows beyond k, because we pop whenever it exceeds k
# so total work is n pushes and pops, each costing O(log k)

# Space complexity: O(k),the heap never holds more than k elements at a time

# Approach:
# we keep a min heap of size at most k
# this heap holds the k largest elements seen so far
# for every new number, we push it into the heap
# if the heap grows bigger than k, we pop the smallest element out
# this way the smallest of our k largest elements keeps getting removed if a bigger one comes along
# after going through all numbers, the smallest element left in the heap, which is at the top, is the kth largest overall

import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # pq is our min heap, starts empty
        pq = []
        
        # go through every number in nums
        for i in range(len(nums)):
            # push the current number into the heap
            heapq.heappush(pq, nums[i])
            
            # if the heap has grown bigger than k elements
            if len(pq) > k:
                # remove the smallest element, we only want to keep the k largest
                heapq.heappop(pq)
        
        # after processing everything, the heap has exactly k elements
        # the smallest of these k elements sits at index 0, and that is the kth largest overall
        return pq[0]