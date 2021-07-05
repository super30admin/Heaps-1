class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1:
            return l2
        if not l2:
            return l1
        dummy = ListNode(float('-inf'))
        result = dummy
        while l1 and l2:
            if l1.val < l2.val:
                dummy.next = l1
                dummy = dummy.next
                l1 = l1.next
                dummy.next = None
            else:
                dummy.next = l2
                dummy = dummy.next
                l2 = l2.next
                dummy.next = None
        if l1:
            dummy.next = l1
        if l2:
            dummy.next = l2
        return result.next
    
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        merged = ListNode(float('-inf'))
        result = merged
        if not lists:
            return merged.next
        i = 0
        while i < len(lists):
            if lists[i]:
                merged = self.mergeTwoLists(merged, lists[i])
            i += 1
        return result.next
