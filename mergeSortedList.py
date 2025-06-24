"""
Push the head of each non-empty list into a min-heap based on node value
Pop the smallest node, add it to the result list, and push its next node into the heap
Repeat until heap is empty
"""
"""
Time Complexity: O(N log k) N - total number of nodes and k - number of lists
Space Complexity: O(k) for heap
"""


from typing import List, Optional
import heapq

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __lt__(self, other):
        return self.val < other.val

class mergeSortedList:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        for node in lists:
            if node:
                heapq.heappush(heap, node)

        dummy = ListNode(0)
        current = dummy

        while heap:
            node = heapq.heappop(heap)
            current.next = node
            current = current.next
            if node.next:
                heapq.heappush(heap, node.next)

        return dummy.next


def build_linked_list(values):
    dummy = ListNode()
    curr = dummy
    for v in values:
        curr.next = ListNode(v)
        curr = curr.next
    return dummy.next

def print_linked_list(head):
    result = []
    while head:
        result.append(head.val)
        head = head.next
    print(result)


if __name__ == "__main__":
    lists = [
        build_linked_list([1, 4, 5]),
        build_linked_list([1, 3, 4]),
        build_linked_list([2, 6])
    ]
    obj = mergeSortedList()
    merged = obj.mergeKLists(lists)
    print_linked_list(merged) 
