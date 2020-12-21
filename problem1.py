#Time Complexity : O(nlogk) where n is the len of the list and k is the k largest number
#Space Complexity : O(k) where k is the k largest number
#desc maintaining min heap
#if heap length is greater than k then comparing the first element with the current element if it is smaller only then pop the element and push curr element as smallest element of 
#https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        hp = []
        for i in range(len(nums)):
            #if heap size is less then k just push curr element into heap
            if len(hp) < k:
                heapq.heappush(hp, nums[i])
            elif hp[0] < nums[i]:
                heapq.heappop(hp)
                heapq.heappush(hp, nums[i])
        return hp[0]
        