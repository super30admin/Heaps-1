# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
"""
TC -> O(NK) where N is the average length of linkedlists and K is the number of sorted linked lists
SC -> O(NK)
Logic:
Here instead of uisng the min-heap implementation, I am using the merge operation similar to merge sort.
Till the list has more than 1 linkedlist, I will pop the last two. Perform merge and push the newly merged into the lists
At the end, there will be only one fully merged and sorted linked list in lists which will be returned.
If the list is empty method returns a None
"""
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        while len(lists) > 1:
            ll1 = lists.pop()
            ll2 = lists.pop()
            merged_ll = self.merge(ll1, ll2)
            lists.append(merged_ll)
        return lists.pop() if len(lists) == 1 else None

    def _printer(self, ptr):
        while ptr is not None:
            print(ptr.val)
            ptr = ptr.next

    def merge(self, lptr, rptr):
        start = ListNode()
        curr = start
        while (lptr and rptr):
            if lptr.val <= rptr.val:
                curr.next = lptr
                curr = lptr
                lptr = lptr.next
            else:
                curr.next = rptr
                curr = rptr
                rptr = rptr.next
        while lptr:
            curr.next = lptr
            curr = lptr
            lptr = lptr.next
        while rptr:
            curr.next = rptr
            curr = rptr
            rptr = rptr.next
        return start.next
