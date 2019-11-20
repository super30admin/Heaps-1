# Leet code- 23 - Merge k sorted lists - https://leetcode.com/problems/merge-k-sorted-lists/
# time complexity - O(NKlogk)
# approach = priority queue we store the node and node.values.


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

from Queue import PriorityQueue
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        pq=PriorityQueue()
        for head_node in lists:
            if head_node:
                pq.put((head_node.val,head_node))
        
        dummy=ListNode(0)
        curr=dummy
        while not pq.empty():
            val,node=pq.get()
            curr.next=ListNode(val)
            curr=curr.next
            node=node.next
            if node:
                pq.put((node.val,node))
        return dummy.next
            






# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None



import heapq
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        pq=[]
        for head_node in lists:
            if head_node:
                heapq.heappush(pq,(head_node.val,head_node))
        
        dummy=ListNode(0)
        curr=dummy
        while pq:
            smallest=heapq.heappop(pq)[1]
            curr.next=smallest
            curr=curr.next
            if smallest.next:
                heapq.heappush(pq,(smallest.next.val,smallest.next))
        return dummy.next
            