#Time complexity:O(nklogk)
#Space complexity:O(k)
#Ran successfully on leetcode:Yes
#Algorithm:
#1. Create a heap with such that all the heads of each linked list is added to it and heapify it. 
#2. Now declare Head and Tail as None. 
#3. Now take out the top element from heap and store in a temp node. If head is None make head=temp else make tail point to this temp and make temp as tail.


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    import heapq
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if lists is None or len(lists)==0:
            return None
        myheap=[]
        for l in lists:
            while l:
                heapq.heappush(myheap,l.val)
                l=l.next
        head=None
        tail=None
        while(myheap):
            k=heapq.heappop(myheap)
            temp=ListNode(k)
            if head is None:
                head=temp
                tail=temp
            else:
                tail.next=temp
                tail=temp
        return head
                
        
        
