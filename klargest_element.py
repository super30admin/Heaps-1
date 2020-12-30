from Queue import heapq
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
       # #O(Nlogk)>>insert a element>logk>do it N times
       #  #O(k)>>queue size
       #  if not nums or not k:
       #      return False
       #  #minheap by default
       #  q = PriorityQueue()
       #  for num in nums:
       #      q.put(num)
       #      #maintain qsize k
       #      if q.qsize()>k:
       #          q.get()
       #  return q.get()
        
        if not nums:
            return 0
        heap = []
        for i in nums:
            heapq.heappush(heap, i)
            if len(heap) > k:
                heapq.heappop(heap)
        return heapq.heappop(heap)