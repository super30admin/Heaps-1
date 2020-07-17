#23. Merge k Sorted Lists
# Time Complexity : O(nk log k)
# Space Complexity :O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#first we take all the head of the linked list from list and store it in heap. Now remove top ele in heap and add to a dummy node. if the top elem has any next node move the pointer to next node and push to heap. We will continue untill we reach the end of linklists for all the list and finally return dummy node
import heapq
class MyObject():
    def __init__(self, val):
        self.val = val

    def __lt__(self, other):
        return (self.val.val < other.val.val)

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if not lists or len(lists) < 1:
            return 
        heap = []
        for heads in lists:
            if heads is not None:
                heapq.heappush(heap,MyObject(heads))
        dummy = ListNode()
        curr = dummy
        while heap:
            temp = heapq.heappop(heap)
            curr.next = temp
            curr = curr.next
            if temp.next:
                push(heap, MyObject(temp.next))

        return dummy.next