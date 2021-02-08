#Time Complexity:O(nlogk)
#Space Complexity:O(k)
import queue as Q 												
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        q=Q.PriorityQueue()									#declaring a priority queue
        for num in nums:									#inserting each element in nums into the queue
            q.put(num)
            if q.qsize()>k:									#if the size increases than k we pop the highest element
                n=q.get()
        return q.get()										#poping the last element in the q which would be the kth element