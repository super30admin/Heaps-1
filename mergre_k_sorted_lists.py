# // Time Complexity : O(kn)
#k is number of lists
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists or len(lists)==0:
            return None
        
        #Repeat this step until you have only 1 list
        while len(lists)>1:
            merged=[]
            
            
            for i in range(0,len(lists),2):
                l1=lists[i]
                
                l2=lists[i+1] if i+1<len(lists) else None
                merged.append(self.mergeLists(l1,l2))
            lists=merged   
        return lists[0]
         
        
        
     #Funstion to merge 2 lists   
    def mergeLists(self,l1,l2):
        dummy=ListNode()
        tail=dummy

        while l1 and l2:
            if l1.val<l2.val:
                tail.next=l1
                l1=l1.next
            else:
                tail.next=l2
                l2=l2.next

            tail=tail.next

        if l1:
            tail.next=l1
        if l2:
            tail.next=l2

        return dummy.next