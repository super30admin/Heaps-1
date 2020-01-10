# Runs on Leetcode
      # Bruteforce 
            # Runtime - O(nk) where k is number of lists and n is length of lists
            # Memory - O(1) - no extra space used
          
      # Optimized
            # Runtime - O(nlogk)  n and k are same as above
            # Memory - O(1) excluding the resultant linked list space

          
          
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None



# Bruteforce

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1:
            return l2
        if not l2:
            return l1
        dummy = ListNode(float('-inf'))
        result = dummy
        while l1 and l2:
            if l1.val < l2.val:
                dummy.next = l1
                dummy = dummy.next
                l1 = l1.next
                dummy.next = None
            else:
                dummy.next = l2
                dummy = dummy.next
                l2 = l2.next
                dummy.next = None
        if l1:
            dummy.next = l1
        if l2:
            dummy.next = l2
        return result.next
    
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        merged = ListNode(float('-inf'))
        result = merged
        if not lists:
            return merged.next
        i = 0
        while i < len(lists):
            if lists[i]:
                merged = self.mergeTwoLists(merged, lists[i])
            i += 1
        return result.next




# Optimized

class Solution:
    import heapq
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        dummy = result = ListNode(float('-inf'))
        queue = []

        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(queue, (lists[i].val, i ,lists[i]))
                
        while queue:
            node_val, index, node = heapq.heappop(queue)
            dummy.next = ListNode(node_val)
            dummy = dummy.next
            node = node.next
            if node:
                heapq.heappush(queue, (node.val, index, node))
        return result.next
