# Time Complexity : O(NlogK) N->total elements, K number of  lists
# Space Complexity O(k)
# Approach : One way is we can dump all elements into heap then pop each one out , but one thing is we know lists are sorted , so we push top element of each lsit at once, and pop min element ,
# if elemnt has next we push that into heap.this way we maintain only k elements in heap.Pop then add to node and continue





# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        #heap has at most k ele
        heap=[]
        i=0
        for head_node in lists:
            if head_node:
                heapq.heappush(heap,(head_node.val,i,head_node))
                i+=1
        dummyHead=ListNode(-1)
        curr=dummyHead
        while(len(heap)):
            _,i,min_node=heapq.heappop(heap)
            curr.next=min_node
            curr=min_node
            if min_node.next:
                heapq.heappush(heap,(min_node.next.val,i,min_node.next))
        return dummyHead.next
