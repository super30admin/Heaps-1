#explaination: put all the heads of all the lists in the heap of size k(number of lists). if adding an element exceeds the size, smallest element will be popped because of min heap property and if that value, linked list formation is done
#time complexity: o(nlogk)
#Leetcode: error typer error: '<' not supported between instances of listnode and listnode
from queue import PriorityQueue
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        queue = PriorityQueue()
        for head in lists:
            if head:
                queue.put((head.val, head))
        curr = ans = ListNode(0)
        while not queue.empty():
            curr.next = queue.get()[1]
            curr = curr.next
            if curr.next:
                queue.put((curr.next.val, curr.next)
        return ans.next