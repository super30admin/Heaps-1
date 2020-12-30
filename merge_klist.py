from Queue import PriorityQueue

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        #O(nklogk)
        #O(k)
        #insert tuple of value, linklist reference
        # head = point = ListNode(0)
        # q = PriorityQueue()
        # for l in lists:
        #     if l:
        #         q.put((l.val, l))
        # while not q.empty():
        #     val, node = q.get()
        #     point.next = ListNode(val)
        #     point = point.next
        #     node = node.next
        #     if node:
        #         q.put((node.val, node))
        # return head.next
        
        
        #while inserting maintain sort order for node values
        #custom sort
        setattr(ListNode, "__lt__", lambda self, other: self.val <= other.val)
            
        pq = []
        for l in lists:
            if l:
                heapq.heappush(pq,  l)
        
        out = ListNode(None)
        head = out
        while pq:
            l = heapq.heappop(pq)
            head.next = l
            head = head.next
            if l and l.next:
                heapq.heappush( pq, l.next)
            
        return out.next