# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
# Time Complexity: O(nlog k) k - number of lists
# Space Complexity: O(k)
import heapq


class Solution:
    def mergeKLists(self, lists):
        #       Initialize two lists  and the heap
        curr = root = ListNode(0)
        heapk = []

        #         add all lists in the list here and then heapify that list
        for i in lists:
            if i:
                heapk.append((i.val, i))

        heapq.heapify(heapk)
        #  while heap we will pull top element value and node and
        #  if current node next is null then we will pop that element and
        #  if not then we will replace it with its next node and its value
        # update current node to next node and return root
        while heapk:
            value, node = heapk[0]

            if not node.next:
                heapq.heappop(heapk)
            else:
                heapq.heapreplace(heapk, (node.next.val, node.next))

            curr.next = node
            curr = curr.next

        return root.next

#         k = len(lists)

#         heapk = []

#         heapq.heapify(lists)
