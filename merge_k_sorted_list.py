"""23. Merge k Sorted Lists
Time Complexity :O(nk logk)
Space Complexity: O(N) # new result linkedlist"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

import heapq
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        min_heap, k = [], len(lists) 
        # put first element of each list
        for i, x in enumerate(lists):
            if x:
                heapq.heappush(min_heap, (x.val, i))
            else:
                k -= 1
            
        current = result = None
        # while there are elements to process
        while k:
            smallest, i = heapq.heappop(min_heap)
            
            # add the value to the result
            if not current:
                current = result = ListNode(smallest)
            else:
                current.next = ListNode(smallest)
                current = current.next
            
            # continue to process other elements
            if lists[i]:
                lists[i] = lists[i].next
                if lists[i]:
                    heapq.heappush(min_heap, (lists[i].val, i))
                else:
                    k -= 1
        return result