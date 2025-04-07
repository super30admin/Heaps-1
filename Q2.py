#  Time Complexity : O(nk) n -> Avg length of a list, k -> No of lists 
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : We consider a dummy node having the value 0. By enumerationg through the list we find the minimum value and the min index. We store the min value node in the next of the dummy node and remove the value which we have already taken from its list by moving the index to the next element. If a list has become empty we remove the list from the list of lists. 

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = ListNode(0)
        res = dummy

        while any(lists):
            minNode = None
            minIndex = -1

            for index, i in enumerate(lists):
                if i != None:
                    if minNode == None:
                        minNode = i
                        minIndex = index
                    else:
                        if minNode.val > i.val:
                            minNode = i
                            minIndex = index
                
            dummy.next = minNode
            dummy = dummy.next

            lists[minIndex] = lists[minIndex].next

            if lists[minIndex] == None:
                lists.remove(lists[minIndex])
        
        return res.next