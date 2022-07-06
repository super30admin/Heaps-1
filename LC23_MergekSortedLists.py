"""
#M1
Brute Force
Add all the elements in a list and sort that list 
TC = O(n log n)
"""
"""

#M2 : 
Compare pairwise
compare elements from 2 Linked List at a time and form a list which is sorted, then combine this list with the rest of the linked list pairwise(2 LL at a time)
TC = O(nk)
"""







"""

#M3
Heapify the heads
We will put all the k list heads in the heap and heapify to ensure that min element is at the top. Whenever we pop, we push the next of that element in the heap and heapify
We keep adding the popped elements to the result list

we will maintain a priority queue of nodes
TC = O(n log k) as we have heap of size k and to maintain heap property we do logk operations and we do that for all n elements.
SC = O(k) for k elements that we maintain in the heap

"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq 
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists or len(lists) == 0:
            return None
        
        lessthan =lambda x,y : x.val<y.val
        ListNode.__lt__ = lessthan

        h = [(l.val, l)for l in lists if l]
       
        heapq.heapify(h)

        dummy = ListNode(-1)
        curr = dummy
        while h:
            _,heap_min = heapq.heappop(h)
            curr.next  = heap_min
            curr = curr.next

            if heap_min.next :
                heapq.heappush(h, (heap_min.next.val, heap_min.next))

        return dummy.next
                

