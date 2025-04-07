#  Time Complexity : O(nlogk)
#  Space Complexity :  O(k)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : We create a minHeap. Traversing through the list we append the elements to the minHeap. As soon as the length of the minheap exceeds k we pop the element out of the minheap. When only k elements are present in the minHeap we pop the kth element.

import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        min_heap = [] 

        for num in nums:
            heapq.heappush(min_heap, num)
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        
        return heapq.heappop(min_heap)




#  Time Complexity : O(n + nlogn)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : We consider an empty array res. Traversing through the array we append the elements one by one to this empty array. We sort the array in an ascending order. Then we return the n - k element.

#Brute Force 
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        res = []
        for i in nums:
            res.append(i)

        res.sort()
        n = len(res)
        return res[n - k]