#Time complexity : O(nk) where n is the total number of nodes and k is number of comparisions
#Did this code successfully run on Leetcode : Yes
#youtube : https://youtu.be/kg2-5xTrfQY
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        #defining the result node
        merged = ListNode()
        #calling merge function for each list
        for li in lists:
            merged = self.merge(merged, li)
        return merged.next
    def merge(self, li1 : List[Optional[ListNode]], li2 :List[Optional[ListNode]]):
        #defining two pointer for traversal of two list
        n1 = li1
        n2 = li2
        #creating node for storing the merged result
        result =ListNode()
        head = result
        #comparing the nodes value for two list and appending the smaller value till any one list is traverse
        while n1 and n2:
            if n1.val < n2.val:
                head.next = n1
                n1 = n1.next
            else:
                head.next = n2
                n2 = n2.next
            head = head.next
        #if any one list is left to be merge then we will just connect the list with current element at head
        if n1:
            head.next = n1
        if n2:
            head.next = n2
        return result.next
