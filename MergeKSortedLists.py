#Time Complexity: O(nklogk)
#Space Complexity: O(k)
#Successfully ran on leetcode

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        ListNode.__lt__ = lambda self,other:self.val<other.val
        h = []
        dummy = ListNode(-1)
        curr = dummy
        for node in lists:
            if node:
                heapq.heappush(h,node)
        while h:
            node = heapq.heappop(h)
            curr.next = node
            if node.next:
                heapq.heappush(h,node.next)
            curr = curr.next
        return dummy.next