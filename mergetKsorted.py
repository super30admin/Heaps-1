"""
23. Merge k Sorted Lists

Time Complexity:  O(Nlogk) where k is the number of linked lists.
Space Complexity : O(k) to create heap

Approach: Heap
1. Compare every k nodes (head of every linked list) and get the node with the smallest value.
2. Create heap, Extend the final sorted linked list with the selected nodes.

"""

class Merge(object):
    def mergeKLists(self, lists):
        q, h = len(lists), []
        for i in range(q):
            if lists[i]:
                heapq.heappush(h, (lists[i].val, i, lists[i]))
        
        rhead = rtail = ListNode(0)
        
        while h:
            i, n = heapq.heappop(h)[1:]
            rtail.next = n
            rtail = rtail.next
            if n.next:
                heapq.heappush(h, (n.next.val, i, n.next))
                
        return rhead.next