'''
Accepted on leetcode
time - O(Nk)
Using merge sort to sort arrays 2 at a time.
'''


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """

        def merge(lst1, lst2): # merge two lists
            result = dummy = ListNode(-1)
            while lst1 and lst2:
                if lst1.val < lst2.val:
                    dummy.next = lst1
                    lst1 = lst1.next
                else:
                    dummy.next = lst2
                    lst2 = lst2.next
                dummy = dummy.next

            dummy.next = lst1 if not lst2 else lst2
            return result.next

        if not lists: return None
        if len(lists) == 1: return lists[0]

        mid = len(lists) / 2
        left = self.mergeKLists(lists[:mid])
        right = self.mergeKLists(lists[mid:])

        return merge(left, right)