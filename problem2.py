# problem 2

# https://leetcode.com/problems/merge-k-sorted-lists/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def mergeList(self,node1,node2):
        dump_node = ListNode(float('-inf'))
        temp_node = dump_node
        while node1 and node2:
            if node1.val < node2.val:
                temp_node.next = node1
                node1 = node1.next
            else:
                temp_node.next = node2
                node2 = node2.next
            temp_node = temp_node.next 
        if node1:
            temp_node.next = node1 
        if node2:
            temp_node.next = node2
        return dump_node

    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy_node = ListNode(float('-inf'))
        new_node = dummy_node
        for list in lists:
            new_node = self.mergeList(new_node,list)
        return dummy_node.next