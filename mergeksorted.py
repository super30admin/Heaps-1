# TC: O(nklog(k))
# SC: O(k)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    class nodeInterface:
        def __init__(self, listNode):
            self.node = listNode
        def __lt__(self, other):
            return self.node.val < other.node.val
        
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        
        q = []
        cur = ListNode(-1, None)
        result = cur
        for l in lists:
            if l:
                heappush(q, self.nodeInterface(l))
        
        while q:
            
            top = heappop(q)
            
            cur.next = top.node
            cur = cur.next
            
            if top.node.next is not None:
                heappush(q, self.nodeInterface(top.node.next))
        
        return result.next