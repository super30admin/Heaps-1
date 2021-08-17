# Time Complexity: O(nk logk), where n - average length of the lists, k - no of lists
# Space Complexity: O(k), where k - heap size
# Did this code successfully run on Leetcode: Yes

# Solution:

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if not lists or len(lists) == 0:
            return None

        # Custom comparator for the heap
        ListNode.__lt__ = (lambda a, b: a.val < b.val)

        # Minheap to maintain k nodes
        heap = []
        dummy = ListNode(float('-inf'))
        result = dummy

        # Push the head node of k lists into the heap
        for head in lists:
            if head:
                heapq.heappush(heap, head)

        while heap:
            # Pop the smallest element from the heap and push its next node
            minimum = heapq.heappop(heap)
            if minimum.next:
                heapq.heappush(heap, minimum.next)

            # Append the popped smallest element to the result
            dummy.next = minimum
            dummy = dummy.next

        return result.next



