# TC: O(N logK) where K is the number of sorted lists and N is the total number of nodes we process for merging, i.e. sum of all nodes of k lists.
# SC: O(K) since at any point of time, we will be storing only k nodes in the priority queue.

from queue import PriorityQueue
class Solution:
    ListNode.__lt__ = lambda self, other: self.val < other.val
    # ListNode.__eq__ = lambda self, other: self.val == other.val
    
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if not lists: 
            return 
        
        dummy = ListNode(-1)
        curr = dummy
        final = PriorityQueue()
        
        for head in lists: 
            if head: 
                final.put(head)
        
        while not final.empty(): 
            node = final.get()
            curr.next = node
            curr = curr.next
            if node.next: 
                final.put(node.next)
        
        return dummy.next
