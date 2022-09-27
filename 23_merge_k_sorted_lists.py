'''

## Problem 23: Merge k sorted lists

## Author: Neha Doiphode
## Date:   09-17-2022

## Description:
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
    Merge all the linked-lists into one sorted linked-list and return it.

## Examples:
    Example 1:
        Input: lists = [[1,4,5],[1,3,4],[2,6]]
        Output: [1,1,2,3,4,4,5,6]
        Explanation: The linked-lists are:
        [
            1->4->5,
            1->3->4,
            2->6
        ]

        Merging them into one sorted list: 1->1->2->3->4->4->5->6

    Example 2:
        Input: lists = []
        Output: []

    Example 3:
        Input: lists = [[]]
        Output: []

## Constraints:
    k == lists.length
    0 <= k <= 104
    0 <= lists[i].length <= 500
    -104 <= lists[i][j] <= 104
    lists[i] is sorted in ascending order.
    The sum of lists[i].length will not exceed 104.


## Time complexity: Please refer to respective doc-strings of different approaches used below.

## Space complexity: Please refer to respective doc-strings of different approaches used below.


'''

from typing import List, Optional
from queue import PriorityQueue

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        return str(self.val)

    def __lt__(self, other):
        return self.val < other.val

    def __gt__(self, other):
        return self.val > other.val

    def __le__(self, other):
        return self.val <= other.val

    def __ge__(self, other):
        return self.val >= other.val


class Solution:
    def display(self, head):
        if head:
            while head.next:
                print(f"{head} -> ", end = "")
                head = head.next
            print(f"{head}", end = "")
            print()

    def mergeKLists_brute_force(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        '''
        Time complexity: O(N log N), where N is total number of nodes in all the linked lists.
                         O(N) - To go over all linked lists and collect nodes.
                         O(N log N) - To sort nodes using stable sorting algorithm.
                         O(N) - To go over sorted nodes and create new linked list out of them.

        Space complexity: O(N), Sorting costs O(N) space to store the result.
                          O(N), Creation of linked list.
        '''
        result = []
        for l in lists:
            current = l
            while current:
                result.append(current)
                current = current.next

        # Uses Tim sort which is combination of merge sort and insertion sort.
        result.sort(key = lambda node: node.val)

        head = ListNode(-1, None)
        current = None
        for node in result:
            if current == None:
                current = node
                head.next = current
            else:
                current.next = node
                current = current.next

        return head.next

    def merge_two_lists(self, l1, l2):
        head = previous = ListNode(-1, None)
        while l1 and l2:
            if l1.val <= l2.val:
                previous.next = l1
                previous = l1
                l1 = l1.next
            else:
                previous.next = l2
                previous = l2
                l2 = l2.next

        if l1:
            previous.next = l1
        elif l2:
            previous.next = l2

        return head.next

    def mergeKLists_divide_and_conquer(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        '''
        Time complexity: O(N log N), where N is total number of nodes in all the linked lists.
                         O(N) - To go over all linked lists and collect nodes.
                         O(N log N) - To sort nodes using stable sorting algorithm.
                         O(N) - To go over sorted nodes and create new linked list out of them.

        Space complexity: O(N), Sorting costs O(N) space to store the result.
                          O(N), Creation of linked list.
        '''
        interval = 1
        amount = len(lists)

        while interval < amount:
            for index in range(0, amount - interval, interval * 2):
                lists[index] = self.merge_two_lists(lists[index], lists[index + interval])
            interval *= 2

        return lists[0] if amount > 0 else None


    def mergeKLists_priority_queue(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        '''
        Time complexity: O(N log N), where N is total number of nodes in all the linked lists.
                         O(N) - To go over all linked lists and collect nodes.
                         O(N log N) - To sort nodes using stable sorting algorithm.
                         O(N) - To go over sorted nodes and create new linked list out of them.

        Space complexity: O(N), Sorting costs O(N) space to store the result.
                          O(N), Creation of linked list.
        '''
        head = point = ListNode(0)
        q = PriorityQueue()
        for list_head in lists:
            if list_head:
                q.put((list_head.val, list_head))
        while not q.empty():
            val, node = q.get()
            point.next = ListNode(val)
            point = point.next
            node = node.next
            if node:
                q.put((node.val, node))
        return head.next


# Driver code
##############################################################

l1 = ListNode(1)
l1.next = ListNode(4)
l1.next.next = ListNode(5)

l2 = ListNode(1)
l2.next = ListNode(3)
l2.next.next = ListNode(4)

l3 = ListNode(2)
l3.next = ListNode(6)

l = [l1, l2, l3]
#l = [ListNode(1), []]
solution = Solution()

print()
print("Input: lists to merge are: ")
print("l1 = ", end = "")
solution.display(l1)
print("l2 = ", end = "")
solution.display(l2)
print("l3 = ", end = "")
solution.display(l3)
print()
print("Output: Merge k lists: Brute Force: ")
head = solution.mergeKLists_brute_force(l)
solution.display(head)

##############################################################

l1 = ListNode(1)
l1.next = ListNode(4)
l1.next.next = ListNode(5)

l2 = ListNode(1)
l2.next = ListNode(3)
l2.next.next = ListNode(4)

l3 = ListNode(2)
l3.next = ListNode(6)

l = [l1, l2, l3]

print()
print("Output: Merge k lists: Priority Queue: ")
head = solution.mergeKLists_priority_queue(l)
solution.display(head)

##############################################################

l1 = ListNode(1)
l1.next = ListNode(4)
l1.next.next = ListNode(5)

l2 = ListNode(1)
l2.next = ListNode(3)
l2.next.next = ListNode(4)

l3 = ListNode(2)
l3.next = ListNode(6)

l = [l1, l2, l3]
print()
print("Output: Merge k lists: Divide and Conquer: ")
head = solution.mergeKLists_divide_and_conquer(l)
solution.display(head)
print()
##############################################################
