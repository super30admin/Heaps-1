import heapq
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        my_heap = []
        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(my_heap,(lists[i].val, i, lists[i]))
                
                
        head = ListNode(-1)
        dummy_head = head
        
        while my_heap:
            i, the_list = heapq.heappop(my_heap)[1:]
            dummy_head.next = the_list
            dummy_head = dummy_head.next
            if the_list.next:
                heapq.heappush(my_heap,(the_list.next.val, i, the_list.next))
        return head.next  