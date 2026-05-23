# time: O(nlogk) where n is total number of nodes and k is number of lists
# push pop from heap of max size k is logk
# space: O(k) for k linked lists

# Definition for singly-linked list.
class ListNode:

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def mergeKLists(lists):
    # pq = priorityqueue(a.val-b.val)
    pq = []

    # add each head, index (index of list in lists), and the list itself
    for i, head in enumerate(lists):
        if head is not None:  # if head != null
            # Push (value, index, node). Index 'i' handles duplicate values safely.
            heapq.heappush(pq, (head.val, i, head))  # pq.add(head)

    dummy = ListNode(-1)  # dummy = new listnode(-1)
    curr = dummy  # (Implicitly needed in Java code to track the tail)

    # while pq is not empty
    while pq:
        val, i, min_node = heapq.heappop(pq)

        curr.next = min_node 
        curr = curr.next  

        if min_node.next is not None:  
            heapq.heappush(pq, (min_node.next.val, i, min_node.next))

    return dummy.next  