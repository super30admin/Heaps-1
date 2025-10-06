import heapq
# Definition for singly-linked list.
# tc : O(nlogk) n is the totoal number of nodes gets heapified which takes logk time where k is the number of lists 
# sc : O(k)
# ran successfully on leetcode 
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        
        # using min heap , intiate with the size of k where k is the number of lists lets add the head nodes 
        # and the min of this will be poped up first and we use and put this in new list and so on, in the min heap 
        # as we have poped up from lista we add the next node of it into the heap and repeat the process

        pq = []
        for i, l in enumerate(lists):
            if l:
                heapq.heappush(pq, (l.val, l)) # since heap cannt directly compare the listnodes, i am adding node val and the node 

        dummy = ListNode(-1)
        curr = dummy

        while pq:
            val, min_node = heapq.heappop(pq) # val are compared and sorted in a min heap manner 
            curr.next = min_node # node is the node which is used ot get the next node later 
            curr = curr.next

            if min_node.next:
                heapq.heappush(pq, (min_node.next.val, min_node.next))

        return dummy.next
