# Problem2 Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
    
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        lessThan = lambda x, y: x.val < y.val
        ListNode.__lt__ = lessThan

        minHeap = []
        dummyHead = ListNode(-1)
        cursorNode = dummyHead

        for i in range(len(lists)):
            current = lists[i]
            if current != None:
                heappush(minHeap,current)
        
        while len(minHeap) > 0:
            minNode = heappop(minHeap)
            cursorNode.next = minNode
            if (minNode.next != None):
                heappush(minHeap, minNode.next)
            cursorNode = minNode
        return dummyHead.next
# Time complexity O(NlogK)
# Space complexity O(k)
# K is the no:of linked lists
# N is the no:of nodes across all linked lists