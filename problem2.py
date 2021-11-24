#Time O(nklognk), space O(1)
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        #Initializing minheap, head,cur of listnode
        min_heap=[]
        head = cur = ListNode(None)
 
#Traversing through the list to add it to min hea
        for i in lists:
            while i:
                heapq.heappush(min_heap,i.val)
                i=i.next
#Popping the min element from head and adding it to listnode            
        while min_heap:
            cur.next=ListNode(heapq.heappop(min_heap))
            cur=cur.next
            
        return head.next
