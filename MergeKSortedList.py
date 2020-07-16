# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if not lists:
            return None
        def helper(l1,l2):
            head=ListNode(None)
            perm=head
            
            while l1 and l2:
                if l1.val<l2.val:
                    head.next=l1
                    l1=l1.next
                else:
                    head.next=l2
                    l2=l2.next
                head=head.next
            if l1:
                head.next=l1
            if l2:
                head.next=l2
            return perm.next
        
        while(len(lists)>1):
            next=[]
            for i in range(0,len(lists)-1,2):
                next.append(helper(lists[i],lists[i+1]))    
                
            if len(lists)%2!=0:    
                next.append(lists[-1])    
            
            lists=next
        return lists[0]
        
        
      Time Complexity is O(nk(square)logk)
      Space complexity is O(1)
