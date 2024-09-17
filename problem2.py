'''
Time Complexity: O(nlogk) -> k is elements
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a heap containing all the lists. Get the least element from heap and attach it to the current head
and keep doing this till all the elements are completed.
'''



import heapq


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if lists == None or len(lists) == 0:
            return None

        class Wrapper():
            def __init__(self, node):
                self.node = node

            def __lt__(self, other):
                return self.node.val < other.node.val

        minHeap = list()
        # minHeap = PriorityQueue()
        for headNode in lists:
            if headNode != None:
                heapq.heappush((minHeap), Wrapper(headNode))

        result = ListNode(0)
        cursor = result

        while len(minHeap) != 0:
            minNode = heapq.heappop(minHeap).node
            cursor.next = minNode
            cursor = minNode
            node = minNode.next
            if node != None:
                # print(minHeap)
                heapq.heappush(minHeap, Wrapper(node))

        return result.next