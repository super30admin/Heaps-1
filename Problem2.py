
'''
Problem: Merge k Sorted Lists
Time Complexity: O(nlog k) where n is all nodes and k is list
Space Complexity: O(k)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        add the list first nodes to heap
        whichever popped, add that in heap
'''

# Merge k Sorted Lists
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        length = len(lists)
        head = curr = ListNode(0)
        heap=[]
        heapq.heapify(heap)

        for i in range(length):
            if lists[i]:
                heapq.heappush(heap,(lists[i].val, i))

        while heap:
            val, i = heapq.heappop(heap)
            curr.next = ListNode(val)
            curr = curr.next

            lists[i] = lists[i].next
            if lists[i]:
                heapq.heappush(heap,(lists[i].val, i))

        return head.next