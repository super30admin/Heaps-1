# TC: O(Nk) where N is avg length of each list and merging them takes N.k time.
# SC: O(1) since we do not use any extra space.

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        def merge(l1, l2): 
            dummy = ListNode(-1)
            curr = dummy
            while l1 and l2: 
                if l1.val < l2.val: 
                    curr.next = l1
                    l1 = l1.next
                else: 
                    curr.next = l2
                    l2 = l2.next
                curr = curr.next
            
            if not l1: 
                curr.next = l2
                
            if not l2: 
                curr.next = l1
            
            return dummy.next
        
        dummy1 = ListNode(float('-inf'))
        for head in lists: 
            if head: 
                dummy1 = merge(dummy1, head)
                
        
        return dummy1.next
