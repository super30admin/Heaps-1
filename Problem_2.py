'''
Time Complexity - O(nk log k)
Space Complexity - O(log nk)
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        pq = []
        ListNode.__lt__ = lambda l1,l2:l1.val<l2.val #override the constructor in python as default heap is minheap and works only on integers.
        dummy = ListNode(-1) #create a dummy node
        for head in lists:
            if head != None:
                heapq.heappush(pq,head) #push all the heads into the heap
        curr = dummy
        while pq: #while heap is not empty
            minNode = heapq.heappop(pq) #pop the smallest node
            curr.next = minNode #point the next of the new linked list to the popped node
            curr= curr.next #point current to the next node
            if curr.next!=None:
                heapq.heappush(pq, curr.next) #push the next node of current(in original linked list) into heap
        return dummy.next #return the next of min

        