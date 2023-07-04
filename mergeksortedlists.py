# Time Complexity : O(Nlog(k))
#Space Complexity : O(k)
# #// Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :NO
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        h = []
	head = tail = ListNode(0)
	for i in range(len(lists)):
		heapq.heappush(h, (lists[i].val, i, lists[i]))

	while h:
		node = heapq.heappop(h)
		node = node[2]
		tail.next = node
		tail = tail.next
		if node.next:
			i+=1
			heapq.heappush(h, (node.next.val, i, node.next))

	return head.next