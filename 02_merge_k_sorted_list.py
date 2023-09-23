'''
Approach 1
----------
Using k pointers for k lists each containing l elements but total of N

time complexity: O(kN) or O(k^2l )
space complexity: O(N)
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        
        dummyHead = ListNode()
        curr = dummyHead
        
        while(True):
            
            minIndex = -1
            for i in range(len(lists)):

                if(lists[i] and (minIndex==-1 or lists[minIndex].val > lists[i].val)):
                    minIndex = i

            if minIndex == -1:
                break
            
            curr.next = ListNode(lists[minIndex].val)
            curr = curr.next
            lists[minIndex] = lists[minIndex].next
            curr.next = None
            
            
        
        return dummyHead.next