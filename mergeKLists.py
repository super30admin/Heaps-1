# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        h=[(l.val, idx) for idx, l in enumerate(lists) if l]
        heapq.heapify(h)
        head = cur = ListNode(None)
        #print("h",h)
        while h:
            val, idx = heapq.heappop(h)
            #print(val,idx)
            cur.next = ListNode(val)
            cur = cur.next
            lists[idx] = lists[idx].next
            node=lists[idx]
            if node:
                heapq.heappush(h, (node.val, idx))
                #print("h after push",h)
        #print(head)
        return head.next