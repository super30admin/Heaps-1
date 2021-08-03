# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        #merge 2 rows at a time
        if len(lists)==0:
            return None
        count=1
        while(count<len(lists)):
            for i in range(0,len(lists)-count,count*2):#Each step we are adding two list and  skipping the count
                lists[i]=self.mergelist(lists[i],lists[i+count])
            count*=2#incrementing count
           
        
        if  lists[0]==[]:
            return None
        return lists[0]
    def mergelist(self,l1,l2):
        if l1==None and l2==None:
            return None
        if l1==None and l2!=None:
            return l2
        if l1!=None and l2==None:
            return l1
        
        dummy=ListNode(0,0)
        prev=dummy#we are assigning prev=dummy so we can track later the starting point
        c1=l1
        c2=l2
        while(c1!=None and c2!=None):
            if c1.val>=c2.val:
                prev.next=c2
                prev=c2
                c2=c2.next
            else:
                prev.next=c1
                prev=c1
                c1=c1.next
        if c1!=None:
            prev.next=c1
        if c2!=None:
            prev.next=c2
        return dummy.next
     #Time O(nK)
     #Space O(1), no extra space used
                
                
            
