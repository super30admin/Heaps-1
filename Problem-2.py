"""
Approach: using min heap
1) push all the heads to the min heap
2) at any given point, min heap will have the node with the local minimum val
3) built the linked list with the root node and keep adding the node after root node (in the given lists) to the min heap
4) Notice that we start with a dummy node and return the resultant node
5) Another py hack here is to use object identifier as the second priority
    This will be helpful in case you encounter two nodes with same val

TC: O(n log k) n = number of nodes, k = number oflinked lists
SC: O(k)
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

import heapq as q


class Solution:
    def mergeKLists(self, l: List[ListNode]) -> ListNode:
        dummy = ListNode()
        if not l:
            return dummy.next

        pri_q = []
        for head in l:
            if head:
                q.heappush(pri_q, (head.val, id(head), head))

        curr = dummy
        while pri_q:
            _, _, curr.next = q.heappop(pri_q)
            curr = curr.next
            if curr.next:
                node = curr.next
                q.heappush(pri_q, (node.val, id(node), node))

        return dummy.next