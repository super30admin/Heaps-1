"Time Complexity is O(N*K)"
"Space Complexity is O(1)"


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        merged_list = lists[0]
        for i in range(1, len(lists)):
            merged_list = self.mergetwolists(merged_list, lists[i])
        
        return merged_list

    def mergetwolists(self, l1, l2):
        dummy = ListNode(-1)
        current = dummy

        while(l1 and l2):
            if l1.val < l2.val:
                current.next = l1
                l1 = l1.next
            else:
                current.next = l2
                l2 = l2.next
            current = current.next
        
        if l1:
            current.next = l1
        else:
            current.next = l2
        
        return dummy.next
        


        