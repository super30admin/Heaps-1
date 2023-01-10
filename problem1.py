#time complexity: O(nlog(k))
#space complexity: O(k)
#ran on leetcode: Yes
#Use a min heap. Insert elements into this heap. Whenver the size of heap goes beyond k delete the topmost element. Finally after inserting all elements, return the topmost element.
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        Q=[]
        for i in nums:
            heapq.heappush(Q,i)
            if(len(Q)>k):
                heapq.heappop(Q)
        return heapq.heappop(Q)


