#explaination: put all the heads of all the lists in the heap of size k(number of lists). if adding an element exceeds the size, smallest element will be popped because of min heap property and if that value, linked list formation is done
#time complexity: o(nlogk)
#Leetcode: error


import heapq
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def mergeKLists(self, lists):
        queue = []
        curr = ListNode(0)
        ans = curr
        for head in lists:
            if head:
                print(head.val, head)
                heapq.heappush(queue, (head.val, head))
        curr = ans = ListNode(0)

        while len(queue) != 0:
            minimum = heapq.heappop(queue)[1]
            curr.next = minimum
            curr = curr.next
            if curr.next:
                heapq.heappush(queue, (curr.next.val, curr.next))
        return ans.next

