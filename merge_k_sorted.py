# Time Complexity : O(n*k*logk) where n is the max elements in list and k is the number of list
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I start at head of all elements and insert them all in k sized heap. Moving to next pointer in list whenever
# we enter an element. Once the size of heap exceeds k we remove top element. At the end I empty the list


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        heads = lists
        is_changed = True
        head = ListNode()
        current = head
        heap = []
        while is_changed:
            is_changed = False
            for i in range(len(heads)):
                if heads[i]:
                    is_changed = True
                    heapq.heappush(heap, heads[i].val)
                    heads[i] = heads[i].next
            if len(heap):
                next_i = heapq.heappop(heap)
                current.next = ListNode(val = next_i)
                current = current.next
        while len(heap):
            next_i = heapq.heappop(heap)
            current.next = ListNode(val = next_i)
            current = current.next
        return head.next