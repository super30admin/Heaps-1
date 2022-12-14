'''
we can make use of min heap data structure here
Time Complexity -->
Suppose we have avg length of n of each list and k be the length of the likedlist
O(nklogk)

Space Complexity -->
O(k) where k is the length of the lists

'''
from queue import PriorityQueue
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        node_queue = PriorityQueue(len(lists))
		# Use counter to diff same value nodes.
        counter = 1
        for node in lists:
            if node:
                node_queue.put((node.val, counter, node))
                counter += 1
        
        
        dummy_node = ListNode(0, None)
        current = dummy_node
        
        
        while not node_queue.empty():
            _, _, min_node = node_queue.get()
            current.next = min_node
            current = current.next
            if min_node.next:
                node_queue.put((min_node.next.val, counter, min_node.next))
                counter += 1

        return dummy_node.next
       

            
        
