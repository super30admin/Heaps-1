# Time Complexity : O()
# Space Complexity : O()
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from heapq import heappush, heappop

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:

        hp = []
        ctr = 0
        for l in lists:
            if l:
                heappush(hp, (l.val, ctr, l))
                ctr += 1
        
        dummy = ListNode()
        curr = dummy

        while hp:
            lval, _, l = heappop(hp)
            curr.next = l
            curr = curr.next
            if l.next:
                heappush(hp, (l.next.val, ctr, l.next))
                ctr += 1
        
        return dummy.next

            
