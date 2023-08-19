# Time Complexity: O(n * k) k: lists
# Space Complexity: O(k)
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if len(lists) == 0:
            return None

        while len(lists) > 1:
            merged_result = []
            for i in range(0,len(lists), 2):
                l1 = lists[i]
                l2 = lists[i+1] if (i+1) < len(lists) else None
                merged_result.append(self.mergehelper(l1,l2))
            lists = merged_result
        return lists[0]


    
    def mergehelper(self,l1,l2):
        dummy = ListNode()
        result = dummy

        while l1 and l2:
            if l1.val < l2.val:
                result.next = l1
                l1 = l1.next
            else:
                result.next = l2
                l2 = l2.next
            result = result.next

        if l1:
            result.next = l1
        elif l2:
            result.next = l2
        return dummy.next





