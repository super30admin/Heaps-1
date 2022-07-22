"""
TODO- read priority queue and what it prioritizes and its implementation in python.
Leetcode-https://leetcode.com/problems/merge-k-sorted-lists/
TC- O(N * logK(for heapify in heap)), SC- O(K)
Challenges- Implementing minheap on
Lecture-https://youtu.be/kg2-5xTrfQY

FAQ-
Which of two min heap and max heap solution will be a better solution? If k is very small, min heap
solution will be better, if k is larger than max heap is better. (depends on size of heap since number of
times heapify is called will depend on size)


You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.


Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:
k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
"""

import sys

from heapq import heappush as hpush
from heapq import heappop as hpop


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    """
    Ideation-N pointer merge using Min heap, TC- O(N * logK(for heapify in heap)), SC- O(K)

    
    Put the element in min heap one by one and keep popping and adding to the merged list and replace it with its
    next element.
    In other words, put the heads of all linked list in min heap, pop the minimum and go to it's next, repeat.

    Even if one of the list get empty, our algorithm will still continue for rest of the LL until there is something in
    heap. When the heap is empty, our algo will terminate
    """

    def mergeKLists(self, lists):
        # override '<' operator of listnode so heap can perform heapify on this comparision
        lessThan = lambda x, y: x.val < y.val
        ListNode.__lt__ = lessThan

        hp = []
        # put head of each LL in min heap
        for ll in lists:
            if ll is not None:
                hpush(hp, ll)

        # dummy node
        result = ListNode(-1)
        curr = result
        while hp:
            # pop the minimum element from heap and add it's next to heap and go to it's next
            minNode = hpop(hp)
            curr.next = minNode
            minNode = minNode.next
            if minNode:
                hpush(hp, minNode)

            curr = curr.next

        return result.next

    """
    Ideation-Brute force Merging two at a time, O(N*K) where N is number of total elements in our list and K is number 
    of merge comparisons.

    Start with merging two list at a time and merge the third list with the result of first two and so on.

    For merging two nodes, do it just like you would do in an array. Move the pointer on whichever is the minimum and
    add that node to our merged result. In the end, whichever LL remains, we point our result's next to that remained
    curr pointer.

    NOTE-We are doing in place arrangement in our merging.
    """

    def mergeKLists1(self, lists):
        # dummy node - take min possible value since we want our dummy node to remain at the beginning even after merges
        merged = ListNode(-sys.maxsize)
        for ll in lists:
            merged = self.mergeTwoLL(merged, ll)
        return merged.next

    def mergeTwoLL(self, ll1, ll2):
        curr1, curr2 = ll1, ll2
        result = ListNode(-1)
        curr = result
        # compare two LL while both of them remains
        while curr1 and curr2:
            if curr1.val < curr2.val:
                curr.next = curr1
                curr1 = curr1.next
            else:
                curr.next = curr2
                curr2 = curr2.next

            curr = curr.next

        # remaining left
        if curr1:
            curr.next = curr1
        elif curr2:
            curr.next = curr2

        return result.next

    """
    Ideation-Brute Force sorting, O(2N + NlogN(sorting)) where N is number of total elements in our list, SC- O(2N) for 
    new list
    
    Convert list of LL into a 1D array. Sort that list and create a new linkedlist out of it. 
    """

    def mergeKLists2(self, lists):
        numsArr = []
        # create 1D array
        for ll in lists:
            while ll:
                numsArr.append(ll.val)
                ll = ll.next

        numsArr.sort()

        # create new LL
        head = ListNode(-1)
        curr = head
        for num in numsArr:
            curr.next = ListNode(num)
            curr = curr.next

        return head.next
