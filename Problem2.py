'''

Time Complexity : O(nk log(k)
Space Complexity : O(nk)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

Can be implemented by merging the linked lists in pairs and other solution is to add tuples of node values and the node object and
maintaining a new priority queue 

'''

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:

        heap = []
        count = 0
        for head in lists:
            if head:
                count += 1
                heapq.heappush(heap, (head.val,count, head))

        dummy = ListNode(-1)
        current = dummy

        while heap:
            min_node = heapq.heappop(heap)[2]
            current.next = min_node
            current = current.next

            if min_node.next:
                count += 1
                heapq.heappush(heap, (min_node.next.val,count, min_node.next))

        return dummy.next