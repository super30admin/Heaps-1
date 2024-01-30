# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# class Solution:
#     def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        
#         heap = []
        
#         for li in lists:
#             print(li)
#             curr = li
            
#             while curr:
                
#                 heapq.heappush(heap, curr.val)
                
#                 curr = curr.next
                
#         if len(heap) == 0:
#             return None
            
#         ans = ListNode()       
#         ans.val = heapq.heappop(heap)
#         ans.next = None
        
#         curr = ListNode()
#         curr = ans
                
#         while len(heap) > 0:
            
#             new = ListNode()
#             new.val = heapq.heappop(heap)
#             new.next = None
            
#             curr.next = new
#             curr = curr.next
            
#         return ans


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        amount = len(lists)
        interval = 1
        while interval < amount:
            for i in range(0, amount - interval, interval * 2):
                lists[i] = self.merge2Lists(lists[i], lists[i + interval])
            interval *= 2

        return lists[0] if amount > 0 else None

    def merge2Lists(self, l1, l2):
        head = point = ListNode(0)
        while l1 and l2:
            if l1.val <= l2.val:
                point.next = l1
                l1 = l1.next
            else:
                point.next = l2
                l2 = l1
                l1 = point.next.next
            point = point.next

        if not l1:
            point.next=l2
        else:
            point.next=l1

        return head.next
