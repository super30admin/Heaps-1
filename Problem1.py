# Time Complexity :- O(n log k )
# Space Complexity :- O(k)
# Did it run on leetcode succesfully :- Yes
# Approach :- We create a min heap by inserting 2 elements in the start if the elements incoming are greater than the top most element we pop the top most element and insert new element and heapify
#We do this until all the elements are finished 

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        top = []
        for i in range(k):
            heapq.heappush(top,nums[i])

        for j in range(k, len(nums)):
            smallest = top[0]
            if smallest < nums[j]:
                heapq.heappop(top)
                heapq.heappush(top,nums[j])
        return top[0]


