# TC : O(NlogN)
# SC : O(N)


import heapq
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        list1 = []
        for i in range(len(lists)):
            head = lists[i]
            while head:
                list1.append(head.val)
                head = head.next

        if len(list1) == 0:
            return None

        heapq.heapify(list1)
        sval = heapq.heappop(list1)
        dummy = ListNode(sval)
        head = dummy

        while len(list1) > 0:
            head.next = ListNode(heapq.heappop(list1))
            head = head.next

        return dummy

        




            
