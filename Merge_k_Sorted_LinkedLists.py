# Created by Aashish Adhikari at 2:53 PM 2/11/2021

'''
Time Complexity:
O(nk log k) where n is hte length of the longest linked list.

Space Complexity:
O(n.k) + O(k) ~ O(n.k)


# Note: Store a tuple of (value, node)  in the heapq/ priority q. The heap operations will take the first element of the tuple for comparison.
'''


#Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next



class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """


        import heapq

        from Queue import PriorityQueue
        minheap = PriorityQueue()

        dummy_head = ListNode()
        curr = dummy_head

        for idx in range(len(lists)):

            if lists[idx] is not None:


                temp = lists[idx]
                minheap.put((temp.val,temp))



        while not minheap.empty():

            val, minimum_node = minheap.get()
            curr.next = minimum_node
            curr = curr.next

            # update the pointer if the adde node's next node is not None
            if minimum_node.next is not None:
                minheap.put((minimum_node.next.val,minimum_node.next))





        return dummy_head.next









