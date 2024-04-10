# Time Complexity: O(nk logk)
# Space Complexity: O(log nk)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        pq= []
        ListNode.__lt__ = lambda l1,l2:l1.val<l2.val #override the constructor in python as default heap is minheap and works only on integers.
        dummy = ListNode(-1)
        for head in lists:
            if head!=None:
                heapq.heappush(pq,head) #push all heads into heap
        curr = dummy
        while pq:
            minNode = heapq.heappop(pq) #pop the min from heap
            curr.next = minNode 
            curr = curr.next
            if curr.next!=None:
                heapq.heappush(pq, curr.next) #push the next node of current(in original linked list) into heap
        return dummy.next
        