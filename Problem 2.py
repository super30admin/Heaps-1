# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Time Complexity: O(nk^2)
# Space Complexity: O(1) # Since they are expecting to return a nk sized lists
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if len(lists) == 0:
            return None
        elif len(lists) == 1:
            return lists[0]
        ret = self.merge_two_lists(lists[0], lists[1])
        #print(ret)
        curr = ret
        for i in range(2, len(lists)):
            #print(self.merge_two_lists(curr, lists[i]))
            curr = self.merge_two_lists(curr, lists[i])
        #print(curr)
        return curr
        
        
    def merge_two_lists(self, node1, node2):
        dummy = ListNode(-1)
        curr = dummy
        while(node1 != None and node2 != None):
            if node1.val <= node2.val:
                curr.next = node1
                node1 = node1.next
            else:
                curr.next = node2
                node2 = node2.next
            curr = curr.next
        if node1!= None:
            curr.next = node1
        if node2 != None:
            curr.next = node2
        return dummy.next
        
                
        
    
                
            
        

        
