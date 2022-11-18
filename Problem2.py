 #Time Complexity :- O(kn)
# Space Complexity :- O(k)
# Did it run on leetcode succesfully :- Yes
# Approach :- We create a heap of length k and then remove elements from heap once a min element is removed and pushed into linkedlist 

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if lists == None or len(lists) == 0:
            return None
        
        dummy = ListNode(-1)
        tail = dummy
        heap = []
        
        #Pushing first values to the heap
        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(heap, (lists[i].val, i))
        
        while heap:
            temp, i = heapq.heappop(heap)
            tail.next = ListNode(temp)
            tail = tail.next
            
            lists[i] = lists[i].next
            if lists[i]:
                heapq.heappush(heap, (lists[i].val, i))
            
        return dummy.next