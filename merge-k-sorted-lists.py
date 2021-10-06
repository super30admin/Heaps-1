



from Queue import PriorityQueue

class Solution:
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        # h = [(l.val, idx) for idx, l in enumerate(lists) if l]
        h=[]
        for l in lists:
            if l:
                h.append((l.val,l))
        heapq.heapify(h)
        head = cur = ListNode(None)
        while h:
            val, idx = heapq.heappop(h)
            cur.next = ListNode(val)
            cur = cur.next
            # node = idx = idx.next
            if idx.next:
                heapq.heappush(h, (idx.next.val, idx.next))
        return head.next
                
