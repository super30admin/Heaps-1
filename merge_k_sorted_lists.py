""" 
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Time Complexity: O(nlogk) where n is the total number of nodes and k is the number of linked lists
Space Complexity: O(1)
"""


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def mergeKLists(lists):
    
    n = len(lists)
    if n == 0:
        return None
    
    count = 1
    while count < n:
        for i in range(0, n-count, count*2):
            lists[i] = mergeTwoLists(lists[i], lists[i+count])
        count *= 2
        
    return lists[0]

def mergeTwoLists(l1, l2):
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
        
    if l1:
        curr.next = l1
    if l2:
        curr.next = l2
        
    return dummy.next
        