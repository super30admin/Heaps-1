# Time Complexity: O(nklogk)
# Space Complexity: O(k)
# Did this run successfully on Leetcode: Yes
# Any problem while coding this question: 
# Approach: using heapq or PriorityQueue in Python, 
# put the heads of all lists in the min heap of size k, 
# and pop out the smallest element, say mymin, from the heap
# and push mymin's next on the heap, 
# continue till you go through all nk nodes

# using heapq module
import heapq

class ListNode:

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        ListNode.__lt__=lambda self, y: self.val <= y.val
        li = []
        count = 0
        dummy = ListNode(-1)
        curr = dummy
        for node in lists:
            if node is not None:
                li.append(node)
                count += 1
        
        heapq.heapify(li)
        
        while count != 0:
            count -= 1
            mymin = heapq.heappop(li)
            curr.next = mymin
            curr = curr.next
            if mymin.next is not None:
                heapq.heappush(li, mymin.next)
                count += 1
            
                
        return dummy.next

# using PriorityQueue
# from queue import PriorityQueue
# class Solution:
    
    
#     def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
#         ListNode.__lt__=lambda self, y: self.val <=y.val
        
#         head = point = ListNode(0)
#         q = PriorityQueue()
#         for node in lists:
#             if node is not None:
#                 q.put((node.val, node))
        
#         while not q.empty():
            
#             val, node = q.get()
#             point.next = ListNode(val)
#             point = point.next
#             node = node.next
#             if node is not None:
#                 q.put((node.val, node))
            
#         return head.next