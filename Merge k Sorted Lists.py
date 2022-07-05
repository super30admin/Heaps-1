# time complexity is o(Nlogk), where N is the total number of list nodes in lists and k is the number of listnodes
# space complexity is o(k), k is the number of listnodes
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
            
        from heapq import heappush
        from heapq import heappop
        
        lessthan = lambda x, y : x.val < y.val
        ListNode.__lt__ = lessthan
        
        listheap = []
        for head in lists: # time log(k), space o(k)
            if(head):
                heappush(listheap, head)
        result = ListNode()
        ptr = result
        while(len(listheap) != 0): #time o(N)
            curr = heappop(listheap)
            ptr.next = curr
            ptr = curr
            curr =curr.next
            if(curr):
                heappush(listheap, curr)
        return result.next
            