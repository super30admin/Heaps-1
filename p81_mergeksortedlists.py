"""
https://leetcode.com/problems/merge-k-sorted-lists/
:return
We merge all the nodes as we encounter them, we merge the final list and then we make a linkedlist of the orted nodes
TC: of this solution nklognk
Sc: of this solution O(n)
# Tc of heap solution nklogk
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

##brute force
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        nodes = []
        head = refer = ListNode([0])
        for l in lists:
            while l:
                nodes.append(l.val)
                l = l.next
        print(nodes)
        nodes.sort()
        print(nodes)

        for node in nodes:
            refer.next = ListNode(node)
            refer = refer.next
        print(head.next)

        return head.next

        # return nodes


    # for i in range(len(nums))