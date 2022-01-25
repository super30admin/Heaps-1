# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        final = ListNode()
        temp = final
        
        q = []
        
        for node in lists:
            while node:
                # print(node)
                heapq.heappush(q,node.val)
                node = node.next
        # heapq.heapify(q)
        
        while q:
            val = heapq.heappop(q)
            temp.next = ListNode(val)
            temp = temp.next
            # node = node.next
                # q.append((node.val, node))
            
        return final.next