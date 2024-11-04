#T.C = O(Nlogk) S.C = O(K)
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        heap = []
        for list_node in lists:
            if list_node is not None:
                heapq.heappush(heap,(list_node.val,list_node))
        
        dummy = ListNode(-1)
        curr = dummy
        while heap:
            currMinVal, currMinNode = heapq.heappop(heap)
            curr.next = currMinNode
            curr = curr.next

            if currMinNode.next is not None:
                heapq.heappush(heap, (currMinNode.next.val, currMinNode.next))
            
        return dummy.next
            

        