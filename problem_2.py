# TC: O(n*log(k)); SC: O(k)
# Using heapq
# creating Comparator class on our own.
import heapq


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Comparator:
    def __init__(self, node):
        self.node = node

    def __lt__(self, other):
        return self.node.val < other.node.val


class Solution:
    def mergeKLists(self, lists):
        dummy = ListNode()
        tail = dummy
        heap = []
        for i in lists:
            if i is not None:
                heapq.heappush(heap, Comparator(i))
        while heap:
            pop = heapq.heappop(heap).node
            tail.next = pop
            tail = tail.next
            if pop.next:
                heapq.heappush(heap, Comparator(pop.next))
        return dummy.next


check = Solution()
first = ListNode(1)
first.next = ListNode(4)
first.next.next = ListNode(5)
second = ListNode(1)
second.next = ListNode(3)
second.next.next = ListNode(4)
print(check.mergeKLists([first, second]))


# Overloading special method __lt__() directly to main class ListNode.
# import heapq
#
#
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
#
#
# class Solution:
#     def mergeKLists(self, lists):
#         ListNode.__lt__ = lambda l1, l2: l1.val < l2.val
#         dummy = ListNode()
#         tail = dummy
#         heap = []
#         for i in lists:
#             if i is not None:
#                 heapq.heappush(heap, i)
#         while heap:
#             pop = heapq.heappop(heap)
#             tail.next = pop
#             tail = tail.next
#             if pop.next:
#                 heapq.heappush(heap, pop.next)
#         return dummy.next
#
#
# check = Solution()
# first = ListNode(1)
# first.next = ListNode(4)
# first.next.next = ListNode(5)
# second = ListNode(1)
# second.next = ListNode(3)
# second.next.next = ListNode(4)
# print(check.mergeKLists([first, second]))


# TC: O(N*K); SC: O(1)

# merging linked-lists one by one
# class Solution:
#     def __init__(self):
#         self.dummy = ListNode()
#         self.tail = self.dummy
#
#     def mergeTwoLists(self, l1, l2):
#         while l1 and l2:
#             if l1.val <= l2.val:
#                 self.tail.next = l1
#                 self.tail = l1
#                 l1 = l1.next
#             else:
#                 self.tail.next = l2
#                 self.tail = l2
#                 l2 = l2.next
#         if l1:
#             self.tail.next = l1
#         else:
#             self.tail.next = l2
#         return self.dummy.next
#
#     def mergeKLists(self, lists):
#         merged = ListNode(float('-inf'))
#         for i in lists:
#             merged = self.mergeTwoLists(merged, i)
#             self.tail = self.dummy
#         return merged.next
#
#
# check = Solution()
# first = ListNode(1)
# first.next = ListNode(4)
# first.next.next = ListNode(5)
# second = ListNode(1)
# second.next = ListNode(3)
# second.next.next = ListNode(4)
# print(check.mergeKLists([first, second]))


# class Solution:
#     def __init__(self):
#         self.dummy = ListNode()
#         self.tail = self.dummy

#     def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
#         if len(lists) == 0:
#             return
#         for i in range(len(lists)-1):
#             temp1 = lists[i]
#             temp2 = lists[i + 1]
#             while temp1 and temp2:
#                 if temp1.val <= temp2.val:
#                     self.tail.next = temp1
#                     self.tail = temp1
#                     temp1 = temp1.next
#                 else:
#                     self.tail.next = temp2
#                     self.tail = temp2
#                     temp2 = temp2.next
#             if temp1:
#                 self.tail.next = temp1
#             elif temp2:
#                 self.tail.next = temp2
#             lists[i+1] = self.dummy.next
#             self.tail = self.dummy
#         return lists[-1]
#
#
# check = Solution()
# first = ListNode(1)
# first.next = ListNode(4)
# first.next.next = ListNode(5)
# second = ListNode(1)
# second.next = ListNode(3)
# second.next.next = ListNode(4)
# print(check.mergeKLists([first, second]))
