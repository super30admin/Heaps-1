# Time Complexity: O (N logk)
# Space Complexity: O(k) (where k is number of linked list in list)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Add heads of all the linked list in the priority queue.
# - Top of link list will give min number, append it to the answer link list.
# - Every time removing the head from heap add list's next element in the heap if next elemnt is not none.

from Queue import PriorityQueue
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
#       Initialize priority queue as heap
        queue = PriorityQueue()
        
#       Add heads of all the linked list into the heap
        for head in lists:
            if head:
                queue.put((head.val, head))
#       Create the linkelist for answer
        curr = ans = ListNode(0)

#       While heap is not empty run the while loop
        while not queue.empty():
#           Get the element from the heap and append it to the answer
            curr.next = queue.get()[1]
#           Change the current node in the answer
            curr = curr.next
#           If popped element from the heap has next element add it to the priority queue
            if curr.next:
                queue.put((curr.next.val, curr.next))
        
        return ans.next
