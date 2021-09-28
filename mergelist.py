# // Time Complexity :O(nklog(n))
# // Space Complexity :O(k),elements in the heap
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
from heapq import heappush as insert
from heapq import heappop as remove
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        maxheap=[]
        for i in range(len(nums)):
            insert(maxheap,(-nums[i]))
            # print(maxheap)
            if (len(maxheap)-1)>(len(nums)-k):
                remove(maxheap)
        # print(maxheap)
            
        return -(maxheap[0])
        




from heapq import heappush as insert
from heapq import heappop as remove
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class CustomListNode:
    def __init__(self, node):
        self.node = node
        # self.next = next
    
    def __lt__(self, other):
            return self.node.val < other.node.val
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) ->Optional[ListNode]:
        dummy=ListNode(-1)
        curr=dummy
        pq=[]
        
        
        for i in lists:
            if i is not None:
                print(i.val)
            
                insert(pq,(i.val,CustomListNode(i)))
        while pq:
            
            minim=remove(pq)
            print(minim[1].node)
            nnode=minim[1].node
        
            curr.next=nnode
            curr=curr.next
            if nnode.next is not None:
                
                insert(pq,(nnode.next.val,CustomListNode(nnode.next)))
        return dummy.next

        
        
        