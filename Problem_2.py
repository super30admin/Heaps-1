# Time Complexity: O(nk * log k)
# Space Complexity: O(k)

import heapq

class Node:
    def __init__(self, node, val):
        self.val = val
        self.node = node
        
    def __lt__(self, other):
        return self.val < other.val
    
class Solution(object):
    def mergeKLists(self, lists):
        hp = []
        for head in lists:
            if head != None:
                heapq.heappush(hp, Node(head, head.val))
                
        dummy = ListNode(-1)
        curr = dummy
        
        while len(hp):
            miniNode = heapq.heappop(hp).node
            curr.next = miniNode
            curr = curr.next
            if miniNode.next != None:
                heapq.heappush(hp, Node(miniNode.next, miniNode.next.val))
                
        return dummy.next

# Merging Two Lists
# Time Complexity: O(n (k^2))
# Space Complexity: O(1)
class Solution(object):
    def mergeKLists(self, lists):
        merged = ListNode(-float('inf'))
        for head in lists:
            merged = self.mergeTwoLists(merged, head)
        return merged.next
        
        
    def mergeTwoLists(self, head1, head2):
        dummy = ListNode(-float('inf'))
        curr = dummy
        while head1 != None and head2 != None:
            if head1.val <= head2.val:
                curr.next = head1
                head1 = head1.next
            else:
                curr.next = head2
                head2 = head2.next
            curr = curr.next
            
        if head1 != None:
            curr.next = head1
        if head2 != None:
            curr.next = head2
        return dummy.next
        