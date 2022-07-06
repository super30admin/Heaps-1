# Time Complexity: O(nlog(k))
# Space Complexity: O(nlog(k))
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        from heapq import heappush as insert
        from heapq import heappop as remove
        li=[]
        for i in nums:
            insert(li,i)
            if len(li)>k:
                remove(li)
        return remove(li)