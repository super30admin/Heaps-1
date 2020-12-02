'''
Accepted on leetcode(23)
Bruteforce Approach, Time - O(N*log(N)), space - O(N)
Merge all lists, then sort the array using internal sorted command and then convert it linked list and return the result.
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
        arrRes = []
        for lst in lists:
            while lst:
                arrRes.append(lst.val)  # merge all lists
                lst = lst.next
        arrRes = sorted(arrRes)  # sort the array

        dummy = ListNode(0)
        result = dummy
        for item in arrRes:  # convert array to linked list
            dummy.next = ListNode(item)
            dummy = dummy.next
        return result.next