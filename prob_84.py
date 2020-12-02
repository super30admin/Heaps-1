#brutte force - out all the elements in a list and sort them and then iterate over to make a linked list with these elements --- time - O(nklog nk), space - O(nk)
#Using merge sort -, using merge sort and then sorting all the lists
#3rd approach -- adding the head of all the lists to a minheap and then popping hte min element to replace it byt its next eleent if it exists, this way we get a sorted single list
#in above approach we are using minheap just to ge the least elemnt

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
import heapq
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        pq=[]
        for headNode in lists: #putting all the head nodes into list
            if headNode:
                heapq.heappush(pq,(headNode.val,headNode))
        heapq.heapify(pq)

        dummy=ListNode(0)
        curr=dummy
        while pq:
            value,node=heapq.heappop(pq)
            curr.next=ListNode(value)
            curr=curr.next
            node=node.next
            if node:
                heapq.heappush(pq,(node.val,node))
        return dummy.next