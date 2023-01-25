# Time Complexity: O(nklogk) n->avg length of each LL and k->no. of LLs
# Space Complexity: O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if (lists is None) or (len(lists)==0):
            return None

        heap = list()
        heapify(heap)

        # we push into the heap a tuple containing the value of the head
        # and the index representing the location of where the element is coming from
        # In python the first element of the tuple is considered to sort in the heap
        for idx,c_list in enumerate(lists):
            if c_list is not None:
                heappush(heap, (c_list.val, idx))

        # Initialize a new dummy node to store the result LL
        dummy = curr = ListNode()

        while len(heap)!=0:
            val, idx = heappop(heap)
            curr.next = ListNode(val)
            # we increment the head of the LL from which the current element was popped
            if lists[idx].next is not None:
                heappush(heap, (lists[idx].next.val, idx))
                lists[idx] = lists[idx].next
            curr = curr.next

        return dummy.next