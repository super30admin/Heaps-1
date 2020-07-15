# Time Complexity : O(nk log k)
# Space Complexity :O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Push head of each lists onto min heap of size = k

2. If size is full, pop it out and connect it with a dummy ListNode pointer
3. Initialize another pointer to move thru the Linked List
4. Push next reference of the lement that is popped out.
'''

#custom comparator
class MyObject():
    def __init__(self, val):
        self.val = val
        
    def __lt__(self, other):
        return (self.val.val < other.val.val)

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        
        if not lists or len(lists) < 1:
            return
        
        heap_list = []
        K_pointers = [None]*len(lists)
        for head_ref in lists:
            if head_ref is not None:
                K_pointers.append(head_ref)
                #converting the ListNode to custom class object to enforce custom comparator
                push(heap_list, MyObject(head_ref))
                
        dummy = ListNode()
        curr = dummy
        while len(heap_list) > 0:
            
            topnode = pop(heap_list).val
            curr.next = topnode
            curr = curr.next
            if topnode.next:
                push(heap_list, MyObject(topnode.next))
                
        return dummy.next
            
              
        