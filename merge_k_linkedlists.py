# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """
    TC : O(kn), k= number of sorted list, n=total number of elemnts
    SC : O(total elements all lists)
    """
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        merged= ListNode(float('-inf'))
        for listt in lists:
            merged = self.merger(merged, listt)
        return merged.next
    
    def merger(self, listt1, listt2):
        dummy=cur=ListNode(0)
        while listt1 and listt2:
            if listt1.val<listt2.val:
                cur.next=listt1
                listt1=listt1.next
            else:
                cur.next=listt2
                listt2=listt2.next
            cur=cur.next
        if listt1:
            cur.next=listt1
        if listt2:
            cur.next=listt2
        
        return dummy.next
        