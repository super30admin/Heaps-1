#23. Merge k Sorted Lists
"""
Time Complexity : O( N * log(len(lists)) ) N = max size of LL
Space Complexity : O( len(lists) )

We have head of al the LLs. We will create heap of all heads to know which one is min.
As we find one min node, we will add it to our result list and move head to its next.
As a LL is traversed, we will not insert into heap.
If lenght of heap = 0, this means that we have traversed all the LLs. Stop function and return result LL.
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        hp = [] #list will be used as heapq

        #overwriting heappush function so that it compares values of nodes rather than standard integers.
        lessThan = lambda x, y: x.val < y.val
        ListNode.__lt__ = lessThan
        
        #base

        for head in lists:
            print(head)
            if head != None:
                heapq.heappush(hp, head) #pushing all heads in hp(heap)
        
        #logic
        result = ListNode()
        curr = result
        
        while len(hp) > 0:
            mi = heapq.heappop(hp)
            curr.next = mi
            curr = curr.next
            
            if mi.next != None:
                heapq.heappush(hp, mi.next)
        
        return result.next
