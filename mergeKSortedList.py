'''
Time Complexity: 0(nk logk)
Space Conplexity: 0(k)
'''

import heapq
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    def __init__(self):
        self.heapList = []
    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        # overriding the __it__ method
        ListNode.__lt__ = lambda o1,o2 : o1.val < o2.val
        
        # return the result i.e. headNode 
        resultHead = None
        currentNode = None 
        
        # Push the head's of the linkedList in each index to the heap
        for head in lists:
            if head != None:
                heapq.heappush(self.heapList,head)
        
        # extractMin from heapList and add the result into the list
        while len(self.heapList) != 0:
            
            # 1. extractMin from the list
            headMin = heapq.heappop(self.heapList)
            
            # 2. create an object of headMin val
            objNewNode = ListNode(headMin.val)
            
            # 3. add it to the resultHead
            if resultHead == None:
                resultHead = objNewNode
                currentNode = resultHead
            
            else:
                currentNode.next = objNewNode
                currentNode = objNewNode
            
            # 4. chk if headMin has "next"
            if headMin.next != None:
                heapq.heappush(self.heapList,headMin.next)
            
            continue
        
        # I have my result linked list
        return resultHead