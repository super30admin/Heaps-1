# TC O(Nk) - N is total elements across k lists - and total up to k comparisons will happen
# SC O(1) - No extra space is used.
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists or len(lists) == 0:
            return None
        # we will repeatedly merge 2 lists at a time and replace lists with new set of MergedLists
        while len(lists) > 1:
            mergeLists = []
            
            for i in range(0, len(lists), 2): 
                l1 = lists[i]
                l2 = lists[i+1] if (i+1) < len(lists) else None
                mergeLists.append(self.mergeTwoLists(l1,l2))
            lists = mergeLists
        return lists[0]
        
    
    def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode() # dummy head of our output list - useful to avoid condition where you inserting node in empty list, without a dummy node it will be tricky to solve this problem as to how to create the output list, and maintain a head pointer for it.
        p = dummy 
        
        while l1 and l2: # while both non None
            if l1.val < l2.val: # if l1 value is less, add that to p.next
                p.next = l1
                l1 = l1.next # move forward
            else:
                p.next = l2 # else add l2 for p.next
                l2 = l2.next # move forward
            p = p.next # always move this forward
        
        if l1:  # if l1 is not None yet, l1 was longer list
            p.next = l1 # make p.next point to remainder of l1
        else:
            p.next = l2 # else l2
        
        return dummy.next # return dummy.next as that is where our merged list started

"""Approach: Use a min heap
Put all of the k list heads in the heap, heapify, that will make sure every time you pop out the heap, you get the first element
that is minimum at that point in time. When you pop out, push next of that element in the heap and heapify
Every popped element is added to the resulting list.

TC: O(NlogK) as we have heap of size K and to maintain heap property we do log K operations and we do that for all N elements.
SC: O(K) for K elements that we maintain in the heap
"""

import heapq as hq
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
    
#     def __lt__(self, other):
#         return self.val < other.val
    
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists or len(lists) == 0:
            return None
        
        lessThan = lambda x, y: x.val < y.val
        ListNode.__lt__ = lessThan
        
        h = [(l.val, l) for l in lists if l] # for heap
        hq.heapify(h)
        
        dummy = ListNode(-1)
        cur = dummy
        
        while h:
            _, heap_min = hq.heappop(h)
            cur.next = heap_min
            cur = cur.next
            if heap_min.next:
                hq.heappush(h, (heap_min.next.val, heap_min.next))
        
        return dummy.next