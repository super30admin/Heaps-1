class Solution:
    # Heap insert = log(k)
    # N times ==> N log(K)
    # Space: O(K)
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        head = ListNode()
        tail = head
        ListNode.__lt__ = lambda self,other: self.val < other.val

        q = []
        for l in lists:
            if l:
                heapq.heappush(q, l)
        while q:
            minL = heapq.heappop(q)
            tail.next = ListNode(minL.val)
            tail = tail.next
            minL = minL.next
            if minL:
                heapq.heappush(q, minL)
        
        return head.next

    # # Do a merge similar to 2 list merge
    # # Maintain k pointers ( array of size k ) containing current value from each list
    # # Each iteration: 
    # #. - build the array of k pointers
    # #  - Get the min value
    # #  - push min value into the result 
    # #. - increment the min pointer
    # # build k pointer - O(k)
    # # delete - O(k)
    # # loop till all lists gone => N times
    # # O(K N) // Space: O(N)
    # def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
    #     head = ListNode()
    #     tail = head

    #     while len(lists) > 0:
    #         minV = float("inf") 
    #         minIdx = None
    #         for i, l in enumerate(lists):
    #             if l and l.val < minV:
    #                 minV = l.val
    #                 minIdx = i
    #         if minIdx == None:
    #             return head.next
    #         tail.next = ListNode(lists[minIdx].val)
    #         tail = tail.next
    #         if lists[minIdx].next:
    #             lists[minIdx] = lists[minIdx].next
    #         else:
    #             del(lists[minIdx])
        
    #     return head.next







        


    # # Merge 1 by 1  // K lists - each merge takes N ==> O(K N) / O(N)
    # def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
    #     if len(lists) == 0:
    #         return None
    #     if len(lists) == 1:
    #         return lists[0]

    #     i = 1
    #     curr = lists[0]
    #     while i < len(lists):
    #         curr = self.mergeTwoLists(curr, lists[i])
    #         i += 1
        
    #     return curr


    # #BF: Dump all into an array then sort /// NlogN
    # def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
    #     res = []
    #     for l in lists:
    #         curr = l
    #         while curr:
    #             res.append(curr.val)
    #             curr = curr.next
    #     head = ListNode() 
    #     tail = head
    #     for num in sorted(res):
    #         tail.next = ListNode(num)
    #         tail = tail.next
        
    #     return head.next

    # def mergeTwoLists(self, l1, l2): 
    #     if not l1:
    #         return l2
    #     if not l2:
    #         return l1
    #     head = ListNode()
    #     tail = head
    #     i = l1
    #     j = l2
    #     while i and j:
    #         if i.val < j.val:
    #             tail.next = i
    #             tail = tail.next
    #             i = i.next
    #         else:
    #             tail.next = j
    #             tail = tail.next
    #             j = j.next
    #     while i:
    #         tail.next = i
    #         tail = tail.next
    #         i = i.next
    #     while j:
    #         tail.next = j
    #         tail = tail.next
    #         j = j.next
    #     return head.next

    # def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
    #     # edge case: only 1 list 
    #     # weird scenario: 1 list has majority of elements
    #     if not lists:
    #         return None
    #     if len(lists) == 1:
    #         return lists[0]
    #     if len(lists) == 2:
    #         return self.mergeTwoLists(lists[0], lists[1])
        
    #     mid = len(lists) // 2
    #     return self.mergeKLists([self.mergeKLists(lists[0:mid]), self.mergeKLists(lists[mid:])])
        
            
    
      

      
        
