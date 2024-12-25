"""
TC: O(Nlogk) N number  of nodes in lists, k number of lists
SP: O(1)
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergetwolists(self, list1, list2):
        dummy = curr= ListNode()
        while list1 and list2:
            if list1.val < list2.val:
                curr.next = list1
                list1 = list1.next
            else:
                curr.next = list2
                list2 = list2.next
            curr = curr.next
        curr.next = list1 if list1 else list2
        return dummy.next


    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        n = len(lists)
        if n==0:
            return None
        elif n==1:
            return lists[0]
        m = n//2
        l1 = self.mergeKLists(lists[:m])
        l2 = self.mergeKLists(lists[m:])
        return self.mergetwolists(l1, l2)



        