# Time complexity - O(nk log(k)) where n :total number of nodes in entire lists and  k : length of list array
# Space Complexity: O(k)
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        
        ListNode.__lt__ = (lambda a,b : a.val < b.val)
        #MinHeap
        heap = []
        dummy = ListNode(None,None)
        result = dummy
        #insert the heads of all the lists in the heap
        for head in lists:
            if head:
                heappush(heap,head)
                
        while heap:
            # Remove the top of the Heap and add it to the output list.
            min_num = heappop(heap)
            # if popped node has next node then push it to the minheap.
            if min_num.next:
                heappush(heap,min_num.next)
                
            dummy.next = min_num
            dummy = dummy.next
            
        return result.next
        
        