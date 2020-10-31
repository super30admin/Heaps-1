# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


'''
Did it run on leetcode: yes
Did you face any problem: How to add new element into heap after we add it our sorted list

Time Complexity: 0(N)
Space Complexity: 0(K)

Algorithm:
- create a min heap which will contain all heads of the list's to be merged.
- create a dummy head
- while the queue is not empty:
    - get the minimum from heap and point dummy head to this minimum element
    - add the next element into the heap which is pointed by the popped element
    from the min heap
- increment the dummy head to its next pointer
- Now you have merged K sorted lists

'''

import heapq

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        heap = []
        
        for (index,listHead) in enumerate(lists):
          if listHead:
            heap.append((listHead.val,index))
        
        heapq.heapify(heap)
        head = ListNode(0)
        temp = head
        
        while heap:
          poppedHead,listIndex = heapq.heappop(heap)
          temp.next = lists[listIndex]
          temp = temp.next
          lists[listIndex] = lists[listIndex].next
          if lists[listIndex]:
            heapq.heappush(heap,(lists[listIndex].val,listIndex))
          
        return head.next