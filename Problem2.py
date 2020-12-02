class ListNode1:
	def __init__(self, x):
		self.val = x
		self.next = None

	def __lt__(self, other):
		return self.val < other.val
import heapq

class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None

from queue import PriorityQueue
class Solution:
	# One issue with this is we have to import seperate packages for priority queue which would be difficult in coding challenge
	def mergeKLists1(self, lists):
		# This works fine with all kinds of elements but for this we have to modify the ListNode Class
		# Because of these issues I don't know if I can submit on leetcode
		# Time Complexity : O(nlog(k))
		dummy = ListNode(0)
		res = dummy
		queue = PriorityQueue()
		for i in lists:
			queue.put(i)
			i = i.next
		while not queue.empty():
			node = queue.get()
			dummy.next = node
			dummy = dummy.next
			if node.next != None:
				node = node.next
				queue.put(node)
		return res.next

	def mergeKLists2(self, lists):
		# This works fine if I don't have the repeated elements
		# Here we insert the (value, ListNode) tuple into the priority queue
		# Because in heapq if we add a list it will consider the first element of the list for comparison and if the first element is same then it uses the second element of the list for comparison which is an object in this case and it fails with an error if we compare the objects using '<' or '>' symbols
		# If there are repeated elements then it fails with error "TypeError: '<' not supported between instances of 'ListNode' and 'ListNode'"
		# Because of these issues I don't know if I can submit on leetcode
		# Time Complexity : O(nlog(k))
		dummy = ListNode(0)
		res = dummy
		queue = []
		for i in lists:
			heapq.heappush(queue, (i.val, i))
			i = i.next
		while len(queue) > 0:
			val, node = heapq.heappop(queue)
			dummy.next = node
			dummy = dummy.next
			if node.next != None:
				node = node.next
				heapq.heappush(queue, (node.val, node))
		return res.next

	def mergeKLists3(self, lists: List[ListNode]) -> ListNode:
		# Time Complexity : O(nK) where n is the average length of the list and K is the number of lists
		# Failed on LeetCode : Time limit exceeded for one testcase
		# Have k pointers each one moving simultaneously moving on each of its list
		dummy = ListNode(0)
		res = dummy
		while any(lists):
			minNode = None
			minIndex = -1
			for index, i in enumerate(lists):
				if i != None:
					if minNode == None:
						minNode = i
						minIndex = index
					else:
						if minNode.val > i.val:
							minNode = i
							minIndex = index
			dummy.next = minNode
			dummy = dummy.next
			lists[minIndex] = lists[minIndex].next
		return res.next

	def mergeKLists(self, lists: List[ListNode]) -> ListNode:
		# Time Complexity : O(nK) where n is the average length of the list and K is the number of lists
		# Passes on LeetCode
		# Here we have our own ListNode class where we have overwritten the less than operation. We insert only the ListNodes into priority queue
		dummy = ListNode(0)
		res = dummy
		while any(lists):
			minNode = None
			minIndex = -1
			for index, i in enumerate(lists):
				if i != None:
					if minNode == None:
						minNode = i
						minIndex = index
					else:
						if minNode.val > i.val:
							minNode = i
							minIndex = index
			dummy.next = minNode
			dummy = dummy.next
			lists[minIndex] = lists[minIndex].next
			if lists[minIndex] == None:
				lists.remove(lists[minIndex])
		return res.next

if __name__ == '__main__':
	mKl = Solution()
	l1 = [1,3,9]
	l2 = [2,4,8]
	l3 = [5,7]
	list1 = ListNode(l1[0])
	list2 = ListNode(l2[0])
	list3 = ListNode(l3[0])
	temp1 = list1
	temp2 = list2
	temp3 = list3
	for i in l1[1:]:
		node = ListNode(i)
		temp1.next = node
		temp1 = temp1.next
	for i in l2[1:]:
		node = ListNode(i)
		temp2.next = node
		temp2 = temp2.next
	for i in l3[1:]:
		node = ListNode(i)
		temp3.next = node
		temp3 = temp3.next
	res = mKl.mergeKLists2([list1, list2, list3])
	while res != None:
		print(res.val)
		res = res.next