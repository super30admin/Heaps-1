'''
    Time Complexity:
        O(Nlogk)
        (where N = total number of nodes in the entire lists array,
         and k = the length of the lists array)

    Space Complexity:
        O(k)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        MinHeap
        Put the heads of all the lists in a MinHeap
        Until Heap is empty:
            -> Remove the top of the Heap and attach it to the output list.
            -> If this removed node has a node next to it, add it to the MinHeap.
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        ListNode.__lt__ = (lambda a, b : a.val < b.val)

        heap = []
        dummy = ListNode(None, None)
        walk = dummy

        for head in lists:
            if head:
                heappush(heap, head)

        while heap:
            smallest_node = heappop(heap)
            walk.next = smallest_node
            walk = walk.next

            if smallest_node.next:
                heappush(heap, smallest_node.next)


        return dummy.next
