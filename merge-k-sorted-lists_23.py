#Approach: Min heap
#Time Complexity O(NKlogK)
#Space Complexity O(K)
#It successfully runs on leetcode

class CustomListNode:
    def __init__(self, node):
        self.node = node
    
    def __lt__(self, other):
            return self.node.val < other.node.val

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        minheap = []
        for head in lists:
            if head!= None:
                heapq.heappush(minheap, (head.val, CustomListNode(head)))
        res = ListNode(-1,None)
        cur  = res
        while minheap:
            minval = heapq.heappop(minheap)
            min = minval[1].node
            cur.next = min
            cur = cur.next
            if min.next:
                heapq.heappush(minheap, (min.next.val, CustomListNode(min.next)))
        return res.next


#Approach: Min heap
#Time Complexity O(NK^2)
#Space Complexity O(K)
#It successfully runs on leetcod


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        merged = ListNode(float("-inf"))
        
        def merge(l1, l2):
            res = ListNode(-1)
            cur = res
            while l1 and l2:
                if l1.val < l2.val:
                    cur.next = l1
                    l1 = l1.next
                else:
                    cur.next = l2
                    l2 = l2.next
                cur = cur.next
            if l1:
                cur.next = l1
            if l2:
                cur.next = l2
            return res.next
                    
        for li in lists:
            if li:
                merged = merge(merged,li)
                  
        return merged.next