import heapq
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def __init__(self):
        self.result=[]
    """Time complexity-O(nk^2)
    Space complexity-O(1)"""
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if not lists:
            return
        for i in range(len(lists)):
            self.result=self.mergeSort(self.result, lists[i])
        return self.result
    
    def mergeSort(self, li1, li2):
        head=ListNode(-1)
        curr=head
        while li1 and li2:
            if li1.val<=li2.val:
                curr.next=li1
                li1=li1.next
                curr=curr.next
            else:
                curr.next=li2
                li2=li2.next
                curr=curr.next
        if li1:
            curr.next=li1
        else:
            curr.next=li2
        return head.next
    
    
    """Time complexity-O(nklog(k))
    Space complexity-O(1)"""
#     def mergeKLists(self, lists: List[ListNode]) -> ListNode:
#         last=len(lists)-1
#         while last:
#             i=0
#             j=last
#             while i<j:
#                 lists[i]=self.mergeSort(lists[i], lists[j])
#                 i+=1
#                 j-=1
#                 if i>=j:
#                     last=j
            
#         return lists[0]
    
#     def mergeSort(self, li1, li2):
#         curr1=ListNode(-1)
#         curr=curr1
#         while li1 and li2:
#             if li1.val<=li2.val:
#                 curr.next=li1
#                 li1=li1.next
#                 curr=curr.next
#             else:
#                 curr.next=li2
#                 li2=li2.next
#                 curr=curr.next
#         if li1:
#             curr.next=li1
#         else:
#             curr.next=li2
#         return curr1.next
                
                
            
        # pq=[]
        # lessThan = lambda x, y: x.val < y.val
        # ListNode.__lt__ = lessThan
        # for li in lists:
        #     if li:
        #         heapq.heappush(pq, li)
        # dummy=ListNode(-1)
        # curr=dummy
        # while pq:
        #     curr.next=heapq.heappop(pq)
        #     curr=curr.next
        #     if curr.next:
        #         heapq.heappush(pq, curr.next)
        # return dummy.next
    
    
# class Solution:
"""Time complexity-O(nklog(nk))"""
#     def mergeKLists(self, lists: List[ListNode]) -> ListNode:
#         pq=[]
#         for li in lists:
#             while li:
#                 heapq.heappush(pq, li.val)
#                 li=li.next
#         dummy=ListNode(-1)
#         curr=dummy
#         while pq:
#             curr.next=ListNode(heapq.heappop(pq))
#             curr=curr.next
#         return dummy.next
            
                
                
    
            
        