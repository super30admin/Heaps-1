#Difficulty: how to write a custom comparator for priority queue in python?
from queue import PriorityQueue
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        dummy = ListNode(-1)
        result = dummy
        pq = PriorityQueue()
        for head in lists:
            if head is not None:
                pq.put(head)
        while(len(pq)is not 0):
            min = pq.get()
            dummy.next = min
            dummy = dummy.next
            if min.next is not None:
                pd.put(min.next)
        return result.next