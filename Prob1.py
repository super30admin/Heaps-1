from Queue import PriorityQueue
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # q = PriorityQueue()
        # res = float('inf')
        # #max heap route
        # for num in nums:
        #     #add all nums to priority queue one by one
        #     q.put(-1*num)
        #     if q.qsize() > len(nums)-k:
        #         res = min(res,-1*q.get())
        # return res
        #make priority queue
        # min heap route --> Better
        q = PriorityQueue()
        
        for num in nums:
            #add all nums to priority queue one by one
            q.put(num)
            #think of it as a stack of k elements, we are making sure the q does not exceed size k
            #when it does, we poll the smallest element, that the largest k elements are stored in the stack
            if q.qsize() > k:
                q.get()
        return q.get()
        
