class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        '''
        Time Complexity: nklogk
        Space Complexity: k
        '''
        setattr(ListNode, "__lt__", lambda self, other: self.val < other.val)
        import heapq
        hp = []
        o = None
        head = None
        for i in range(0,len(lists)):
            if(lists[i]==None):
                continue
            heapq.heappush(hp,lists[i])

        while(len(hp)>0):
            temp = heapq.heappop(hp)
            if(temp.next!=None):
                heapq.heappush(hp,temp.next)
            if(o==None):
                o = temp
                head = o
                head.next=None
            else:
                o.next = temp
                o = o.next
                o.next=None
        return head
