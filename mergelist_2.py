# time complexity: o(nlogk)
# leetcode: time - limit exceeded
# explination: consider if there are three given lists, you call a merge function for the first two lists which gives sorted list and call it result. Now merge result and the third result recursively.

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if len(lists) == 0 or lists == None:
            return None
        merged = lists[0]
        for i in range(len(lists) - 1):
            merged = self.merge(merged, lists[i + 1])
        return merged

    def merge(self, list1, list2):
        if not list1:
            return list2
        if not list2:
            return list1
        if list1.val < list2.val:
            list1.next = self.merge(list1.next, list2)
            return list1
        else:
            list2.next = self.merge(list1, list2.next)
            return list2