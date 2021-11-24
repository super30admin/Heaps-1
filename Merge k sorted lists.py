class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        min_heap=[]
        dummy=head=ListNode(-1)
        
        for i in range(len(lists)):
            if lists[i]:
                current_head=lists[i]
                heapq.heappush(min_heap,(current_head.val,i,current_head))
                
                
        while min_heap:
            current_value,index,node=heapq.heappop(min_heap)
            head.next=node
            if node.next:
                node=node.next
                heapq.heappush(min_heap,(node.val,index,node))
            head=head.next
            
        return dummy.next

# Time Complexity: O(nlogk)
# Space Complexity: O(n)