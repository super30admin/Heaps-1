'''
TC: O(nlogk)
SC: O(k)
'''
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
    def __lt__(self, tmp):
        return self.val < tmp.val
    
    def __gt__(self, tmp):
        return not (self < tmp)
    
    def __eq__(self, tmp):
        return not (self < tmp or self > tmp)
    
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        
        if not lists:
            return None
        
        arr = list()
        i = -1
        
        for li in lists:
            i += 1
            if not li:
                continue
            heapq.heappush(arr, [li.val, li])
        
        head = ListNode(0)
        fakehead = head
        
        while arr:
            top, li = heapq.heappop(arr)
            fakehead.next = ListNode(top)
            li = li.next
            fakehead = fakehead.next
            
            if not li:
                continue
            heapq.heappush(arr, [li.val, li])
                
        return head.next
    

