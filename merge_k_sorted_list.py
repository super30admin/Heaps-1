# Approach:
# - Use a min-heap (priority queue) to keep track of the smallest current node across all k linked lists.
# - Push the first node of each list into the heap along with its index to avoid comparison conflicts.
# - Repeatedly pop the smallest node from the heap and add it to the result list.
# - If the popped node has a next node, push it into the heap.
# - This ensures that the merged list is always sorted.

# Time Complexity:
# - O(N log k), where:
#     N = total number of nodes across all lists
#     k = number of linked lists
#   Each node is pushed and popped from the heap once, and heap operations take O(log k)

# Space Complexity:
# - O(k) for the heap (storing up to k nodes at any time)
# - O(1) for result list (no extra space beyond the new linked list)

import heapq
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists):
        dummy = ListNode(-1)
        curr = dummy
        minHeap = []
        for i, node in enumerate(lists):
            if node:
                heapq.heappush(minHeap, (node.val, i, node))
        while minHeap:
            val, i, node = heapq.heappop(minHeap)
            curr.next = ListNode(val)
            curr = curr.next
            if node.next:
                heapq.heappush(minHeap, (node.next.val, i, node.next))
        return dummy.next
#  Utility to convert Python list to Linked List
def build_linked_list(arr):
    dummy = ListNode(-1)
    curr = dummy
    for val in arr:
        curr.next = ListNode(val)
        curr = curr.next
    return dummy.next

# Utility to convert Linked List to Python list
def linked_list_to_list(head):
    result = []
    while head:
        result.append(head.val)
        head = head.next
    return result

# Main function to test
def main():
    sol = Solution()
    input_lists = [[1,4,5], [1,3,4], [2,6]]
    list_nodes = [build_linked_list(lst) for lst in input_lists]

    merged_head = sol.mergeKLists(list_nodes)
    print("Merged Linked List:", linked_list_to_list(merged_head))

if __name__ == "__main__":
    main()