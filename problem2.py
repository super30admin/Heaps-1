#Time complexity- O(nlogk)  where n=total number of nodes and k=total number of lists
#space complexity- O(k) 

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq as hq
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        dummy=ListNode()
        temp=dummy
        h=[]
        
        for i in range(len(lists)):
            if lists[i]:
                hq.heappush(h,(lists[i].val,i))
        
        while h:
            val,index=hq.heappop(h)
            temp.next=lists[index]
            temp=temp.next
            if lists[index].next:
                lists[index]=lists[index].next
                hq.heappush(h,(lists[index].val,index))
            
        return dummy.next
