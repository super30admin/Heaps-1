'''
time complexity: O(Nlog(k)) , n is total number of node
space complexity: O(k), creating head of k
'''
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        ls = []
        
        for n in nums:
            heapq.heappush(ls,n)
            if(len(ls)>k):
                heapq.heappop(ls)
        return ls[0]