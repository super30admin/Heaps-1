# Time Complexity :average O(nklogk)
# Space Complexity :O(k)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
import heapq        
class ListNode(object):
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        #create dummy list node
        dummy = ListNode(float('-inf'))
        #current is pointer to dummy
        curr = dummy
        # create heap
        heap = []
        # for each link list append head of list to heap
        for i in lists:
            if i:
                heapq.heappush(heap,(i.val,i))
        # while heap not empty
        while heap:
            # get the node with least value
            least = heapq.heappop(heap)[1]
            #append it to sorted list
            curr.next = least
            curr = curr.next
            # push new node
            if least.next:
                heapq.heappush(heap,(least.next.val,least.next))
        return dummy.next