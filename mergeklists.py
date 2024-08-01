#// Time Complexity : O(n log k) 
# // Space Complexity : O(K) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : Saw the class video

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class HeapNode:
    def __init__(self, node):
        self.node = node

    def __lt__(self, other):
        # Define comparison based on ListNode's value
        return self.node.val < other.node.val

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        curr = dummy
        heap = []
        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(heap,HeapNode(lists[i]))
        
        while heap:
            temp = heapq.heappop(heap)
            curr.next = temp.node
            curr = curr.next
            if temp.node.next:
                heapq.heappush(heap,HeapNode(temp.node.next))
        
        return dummy.next

# Approach:
# 1. Create a dummy node to simplify the code and avoid edge cases.
# 2. Create a min-heap to store the nodes from the linked lists.
# 3. Push the head of each linked list into the heap.
# 4. While the heap is not empty, pop the smallest node from the heap and add it to
# the result linked list.








        