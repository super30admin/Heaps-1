# Time Complexity : O(nlogk)
# Space Complexity : O(1)  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def mergeKLists(self, lists):
        # merge list step by step
        # 1. merge [1->4->5] and [1->3-4]. Result = [1->1->3->4->5]
        # 2. merge Result ([1->1->3->4->5]) and last list (2->6)
        if not lists:
            return
        if len(lists) == 1:
            return lists[0]
        mid = len(lists) // 2
        
        #merge sort. Get the left and right list to mid
        left = self.mergeKLists(lists[:mid])
        right = self.mergeKLists(lists[mid:])
     
        return self.merge(left, right)
    
    def merge(self, left, right):
        dummyHead = node = ListNode(-1)
        while left and right:
            if left.val < right.val:
                node.next = left
                left = left.next
            else:
                node.next = right
                right = right.next
            node = node.next
        #if nodes are remaining just point to the list with nodes left
        node.next = left or right
        return dummyHead.next
                
