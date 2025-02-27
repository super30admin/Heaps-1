# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Time Complexity : O(nK) where n is the average length of the list and K is the number of lists

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = ListNode(0)
        res = dummy

        while any(lists):
            minNode = None
            minIndex = -1

            for index, i in enumerate(lists):
                if i is not None:
                    if minNode is None:
                        minNode = i
                        minIndex = index
                    else:
                        if minNode.val > i.val:
                            minNode = i
                            minIndex = index

            dummy.next = minNode
            dummy = dummy.next
            lists[minIndex] = lists[minIndex].next

            if lists[minIndex] is None:
                lists.remove(lists[minIndex])

        return res.next

        
