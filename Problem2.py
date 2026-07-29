# Problem2:Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

# Time complexity: O(n log k),n is the total number of nodes across all lists, k is the number of lists every node gets pushed into the heap once and popped once,each push or pop on a heap of size at most k costs O(log k)
# Space complexity: O(k),the heap never holds more than one node per list at a time,so its size is bounded by k
# Approach:
# we put the first node of every list into a min heap
# we push tuples of (value, index, node) instead of just the node,this way the heap compares by value first, and uses index as a tie breaker
# this avoids needing the node itself to be comparable
#each time we pop the smallest tuple and attach its node to our answer list
# if that node has a next node in its own list, we push that next node in too
# we repeat until the heap is empty, which means every node has been used

import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # pq is our min heap, starts empty
        pq = []
        
        # go through each list along with its index i
        # we push val, i, node instead of just node so the heap always has numbers to compare
        for i, node in enumerate(lists):
            # only push if this list is not empty
            if node is not None:
                heapq.heappush(pq, (node.val, i, node))

        # dummy is a placeholder node, not part of the real answer
        # it lets us attach the first real node the same simple way as every other node
        dummy = ListNode(-1)
        # current points at the last node we have attached so far, starts at dummy
        current = dummy

        # keep going as long as there is something left in the heap
        while pq:
            # pop the smallest tuple, this gives us the smallest node available right now
            val, i, min_node = heapq.heappop(pq)
            
            # attach this smallest node to the end of our answer list
            current.next = min_node
            # move current forward so it points at the node we just attached
            current = current.next
            
            # if this node has a next node in its own original list
            if min_node.next is not None:
                # push that next node in, using the same index i since it belongs to the same list
                heapq.heappush(pq, (min_node.next.val, i, min_node.next))

        # dummy itself is not a real node, so the real answer starts right after it
        return dummy.next

