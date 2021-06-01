# Definition for singly-linked list.
# time:- O(nlogk)
# Space:- O(k)
from typing import List
import heapq
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        dummynode = ListNode(-1)
        tmp=dummynode
        heap=[]
        for header in lists:
            heapq.heappush(heap,(header.val,header))

        while heap.__len__() > 0:
            val,ptr=heapq.heappop(heap)
            print(val,ptr)
            if ptr.next !=None:
                heapq.heappush(heap,(ptr.next.val,ptr.next))
            tmp.next=ptr
            tmp=ptr
        return dummynode.next




if __name__ == '__main__':
    heap = []
    heapq.heappush(heap, (0, 'one'))
    heapq.heappush(heap, (11, 'two'))
    heapq.heappush(heap, (12, 'two'))
    heapq.heappush(heap, (13, 'one'))
    heapq.heappush(heap, (14, 'two'))
    heapq.heappush(heap, (122, 'one'))
    heapq.heappush(heap, (100, 'two'))
    heapq.heappush(heap, (199, 'one'))
    while heap.__len__()>0:
        val,address=heapq.heappop(heap)
        print(val,address)



    print(Solution().mergeKLists(lists = [[1,4,5],[1,3,4],[2,6]]))

