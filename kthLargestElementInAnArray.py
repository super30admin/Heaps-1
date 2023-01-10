# // Time Complexity :O(nlogk)
# // Space Complexity : O(k)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
class Solution:
    # THe solution is straight forward. we maintain a heapsize of k at all times. this means our top element is always the kth highest in those k elements.
    # whenever we add mor enumber of elements we start popping them out. this gives us a guarantee that the poppped out element is definitely more than k.
    ## at the end we pop the top element and return it as kth largest element.
    def findKthLargest(self, nums, k):
        myHeap = []

        for n in nums:
            heapq.heappush(nums), n
            if len(myHeap) > k:
                heapq.heappop(nums)
        
        result = heapq.heappop()
        return result