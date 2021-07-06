# TC: O(N logK) 
# SC: O(K) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from queue import PriorityQueue
class Solution:
    ListNode.__lt__ = lambda self, other: self.val < other.val

    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if not lists: 
            return 

        dummy = ListNode(-1)
        curr = dummy
        result = PriorityQueue()

        for head in lists: 
            if head: 
                result.put(head)

        while not result.empty(): 
            node = result.get()
            curr.next = node
            curr = curr.next
            if node.next: 
                result.put(node.next)

        return dummy.next