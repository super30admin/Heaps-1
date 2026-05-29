class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists):
        dummy = ListNode(float('-inf'))
        merged = dummy
        for list in lists:
            merged = self.merge(merged, list)
        return dummy.next

    def merge(self, list1, list2):
        dummy = ListNode(-1)
        curr = dummy

        while list1 is not None and list2 is not None:
            if list1.val < list2.val:
                curr.next = list1
                list1 = list1.next
            else:
                curr.next = list2
                list2 = list2.next
            curr = curr.next

        if list1 is not None:
            curr.next = list1

        if list2 is not None:
            curr.next = list2

        return dummy.next

# Time: O(N * k) or O(n * k^2) where N is total number of nodes, n is the average nodes in each list and k is the number of lists.
# Space: O(1)