# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        minHeap = []
        
        for i in range(len(lists)):
            if lists[i] != None:
                heapq.heappush(minHeap, (lists[i].val , i , lists[i].next))
            
        dummy = ListNode(0)
        curr = dummy
        
        while len(minHeap) != 0:
            value, index, node = heapq.heappop(minHeap)
            
            if node != None:
                heapq.heappush(minHeap, (node.val, index, node.next))
                
            curr.next = ListNode(value)
            curr = curr.next
            
        return dummy.next
        
