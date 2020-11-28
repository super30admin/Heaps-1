from queue import PriorityQueue
​
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        class Wrapper():
            def __init__(self, node):
                self.node = node
            def __lt__(self, other):
                return self.node.val < other.node.val
            
        head = point = ListNode(0)
        q = PriorityQueue()
        for l in lists:
            if l:
                q.put(Wrapper(l))
        while not q.empty():
            temp = q.get().node
            point.next = temp
            point = point.next
            temp = temp.next
            if temp:
                q.put(Wrapper(temp))
        return head.next
