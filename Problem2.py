from queue import PriorityQueue


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    # Time Complexity: O(Nlogk)
    # Space Complexity: O(k)
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        q = PriorityQueue()

        for head in lists:
            if head:
                q.put((head.val, id(head), head))

        dummy = ListNode(-1)
        curr = dummy

        while not q.empty():
            val, _, currMin = q.get()
            curr.next = currMin
            curr = curr.next

            if currMin.next:
                q.put((currMin.next.val, id(currMin.next), currMin.next))

        return dummy.next
