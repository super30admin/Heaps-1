# Time Complexity : O(Nlogk) where N is the no of nodes in each linked list and k is no of linked lists to merge.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Divide and Conquer Approach. For k lists we partition the lists into half and take first and second list merge them and take 3rd and 4th list merge them at the same level.
# Then merge the merged list of 1 and 2 and merged list of 3 and 4 at the next level.
# After all the lists are merged merge the ouput of 1st and 2nd list with the output of 3rd and 4th list and so on. Finally we will get one merged list.
# Every time we merge k lists, there are log k levels.
# For the first level we merge k/2 lists, then k/4 and so on.


class Solution:
    def mergeKLists(self, lists):
        if not lists:
            return None
        if len(lists) == 1:
            return lists[0]
        mid = len(lists) // 2
        l1 = self.mergeKLists(lists[:mid])
        l2 = self.mergeKLists(lists[mid:])
        return self.mergeTwoLists(l1, l2)

    def mergeTwoLists(self, l1, l2):
        if not l1 and not l2:
            return None
        if not l1:
            return l2
        if not l2:
            return l1

        dummy = ListNode(0)
        currentNode = dummy

        while l1 and l2:
            if l1.val <= l2.val:
                currentNode.next = l1
                l1 = l1.next
            else:
                currentNode.next = l2
                l2 = l2.next
            currentNode = currentNode.next

        if l1:
            currentNode.next = l1
        if l2:
            currentNode.next = l2

        return dummy.next
