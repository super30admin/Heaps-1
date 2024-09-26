# Time comlexity --> O(nlogk)
# space complexity --> O(1)-- Inplace 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes Found it hard to come up with custom comparator in python


// Your code here along with comments explaining your approach
we a min heap but as the default for minheap is considering the integer values .we had to come up with a custom comparator to include node values for comparision.we then create a heap of size k and then we pop the min element from the heap.we do this till the queue is empty.
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

import heapq

class Solution(object):
    # def compare(self,a,b):
    #     return cmp(a.val,b.val)
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if lists==None or len(lists)==0:
            return None
        ListNode.__lt__ = lambda x, y: x.val < y.val
        q=[]
        # q=sorted(h,cmp=self.compare)
        heapq.heapify(q)
        # adding heads to the heapq
        for headnode in lists:
        #check everytime if headnode is none or not
            if headnode!=None:
                heapq.heappush(q,headnode)
        # taking a dummy node and setting cursor to dummy to keep track of the end of the dummy
        print(q)
        dummy=ListNode(0)
        cursor=dummy
        
        while len(q)!=0:
        #get the min element
            mini=heapq.heappop(q)
            # print("mini",mini)
            # print("cursor",cursor)
            cursor.next=mini            #linking the min element to the linked list
            cursor=mini                 
        #pushing the node into the queue
            if mini.next!=None:
                heapq.heappush(q,mini.next)
        return dummy.next
        
#using priority queue
# Time comlexity --> O(nlogk)
# space complexity --> O(1)-- Inplace 
#// Did this code successfully run on Leetcode : Yes
#// Any problem you faced while coding this : None
#Description:
we use priority queue in here.we insert all the headnodes of linked lists with priority based on their node values.we then pop the min priority element from the queue and then add to the linked list.we do this till the queue is empty.

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
from Queue import PriorityQueue
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if lists==None or len(lists)==0:
            return None
        q=PriorityQueue()
        #inserting the headnodes into the priorityqueue
        for headnode in lists:
            if headnode!=None:
                q.put([headnode.val,headnode])  #inserting with value for priority purposes.
        dummy=ListNode(-1)
        cursor=dummy
    #minimum element node popped from the queue will be linked to the end of the linked list.
        while not q.empty():
            mini=q.get()
            node=mini[1]
            value=mini[0]
            cursor.next=node
            cursor=node
            if node.next!=None:
                q.put([node.next.val,node.next])
        return dummy.next

