# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        if lists is None or len(lists) is 0:
            return None
        
        while len(lists)>1:
            mergedLists=[]
            for i in range(0,len(lists),2):
                first=lists[i]
 
                second=lists[i+1] if (i+1)<len(lists) else None
  
                res=self.mergeLists(first,second)

                mergedLists.append(res)
    
            lists=mergedLists
        
        return lists[0]
          
    def mergeLists(self,first,second):
        temp=ListNode(-1,None)
        l=temp
        
        while first is not None and second is not None:
            if first.val<=second.val:
                    temp.next=first
                    temp=first
                    first=temp.next
            else:
                    temp.next=second
                    temp=second
                    second=temp.next
        
        if first is None:
            temp.next=second
        if second is None:
            temp.next=first
            
        return l.next