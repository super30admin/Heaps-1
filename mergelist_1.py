#type 1

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#explaination: iterate through all the lists and put the elements of the linkedlist in an
#array and sort it. Then create a linkedlist with the values from the list
#leetcode:accepted

#timecomplexity : nklognk

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        head=ListNode(0)
        result=[]
        temp=head
        for i in lists:
            while i:
                result.append(i.val)
                i=i.next
        result.sort()
        # print(result)
        for val in result:
            temp.next=ListNode(val)
            temp=temp.next
        return head.next