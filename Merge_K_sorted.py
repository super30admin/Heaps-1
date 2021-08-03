#Time: O(Nk) where N is total number of elements and k is number of linked lists
import heapq
class ListNodeExtension(ListNode):
    def __lt__(self, other):
        return self.val < other.val

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        
        #replacing the comparator for heap
        ListNode.__lt__ = ListNodeExtension.__lt__
        
        heap = []
        for list_node in lists:
            if list_node:
                heapq.heappush(heap, list_node)
        
        dummy = head = ListNode()
        while heap:
            node = heapq.heappop(heap)
            head.next = node #add to head
            head = head.next #move head
            if node.next:
                heapq.heappush(heap, node.next)
                
        return dummy.next