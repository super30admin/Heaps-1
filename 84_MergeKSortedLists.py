'''
Accepted on leetcode(23)
Time - O(Nlog(K)), k - no. of lists., space - O(k)
In this method, we are considering head of each list and comparing and taking minimum of them and putting it in result list.
'''
import heapq


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if lists is None or len(lists) == 0:
            return None
        dummy = ListNode(0)  # dummy node and append it as head element in result.
        result = dummy
        pq = []  # priority queue having length as no. of lists , maintaining head from each list.
        # print(len(lists))
        for head in lists:  # filling priority queue
            # print(head)
            if head != None:
                heapq.heappush(pq, (head.val, head))
        # print(pq)
        while pq:  # adding nodes in sorted order to result by popping minimum element from priority queue.
            minimum = heapq.heappop(pq)[1]
            dummy.next = minimum
            dummy = dummy.next
            if minimum.next != None:
                heapq.heappush(pq, (minimum.next.val, minimum.next))
            # print(minimum)

        return result.next