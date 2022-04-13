'''
- Time Complexity: O(Nlogk)
- Space Complexity: O(n)
- Works in Leetcode
- 3 line explanation:
    - put the nodes into a hashmap
    - put the nodes into a list
    - heapify the list
    - from the list and hashmap, reoreder the linked list and get the sorted list of nodes
'''
import heapq

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        node_map = {}
        node_heap = []
        for node in lists:
            if node:
                node_map[id(node)] = node
                node_heap.append((node.val, id(node)))
        print(node_map)
        heapq.heapify(node_heap)
        head = curr = ListNode("dummy")

        while node_heap:
            val, node_id = heapq.heappop(node_heap)
            node = node_map[node_id]
            if node.next:
                heapq.heappush(node_heap, (node.next.val, id(node.next)))
                node_map[id(node.next)] = node.next
            curr.next = node
            curr = curr.next

        return head.next