'''
- Time Complexity: O(N + klogN)
- Space Complexity: O(1) - takes k spaces
- Works in Leetcode
- 3 line explantion
    - Maintain a max heap of size k
    - Heapify first k elements from nums array
    - Do push or pop remaining elements in the nums array
        - If the element is greater than any element in heap, the smaller value will be popped and the new value will be pushed

'''
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        ans = nums[:k]
        heapq.heapify(ans) # run time O(n)
        for i in range(k, len(nums)):
            heapq.heappushpop(ans, nums[i]) # if nums[i] > ans[0] => heapq.push, run time O(klgn)
        return ans[0]  