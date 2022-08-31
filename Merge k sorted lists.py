# Time Complexity: O(N log k) where N is the total no.of elements in all lists combined and k is the no.of lists
# SPace complexity: O(k) for heap/priority queue 

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

from queue import PriorityQueue

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        # Wrapper class / boxing imposes order in ListNode obj
        class Distance:
            def __init__(self, node):
                self.node = node
                
            def __lt__(self, other):
                return self.node.val < other.node.val
        
        q = PriorityQueue()
        
        for head in lists:
            if head:
                q.put(Distance(head))
        
        ans = ListNode(-1)
        curr = ans
        
        while not q.empty():
            node = q.get().node
            curr.next = ListNode(node.val)
            curr = curr.next
            node = node.next
            if node:
                q.put(Distance(node))
                
        return ans.next
        
        
        