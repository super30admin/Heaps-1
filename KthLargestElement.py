#Time complexity: O(Nlogk) inserting the elements into the priority queue and then popping k times
#Space Complexity: O(n) space used by heap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The logic here it to use a priority queue(min heap) and then pop elements until there are k elements left in the heap and then return the top element

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        result = []
        n = len(nums)
        for num in nums:
            heapq.heappush(result, num)
            if len(result) > k:
                heapq.heappop(result)

        return result[0]