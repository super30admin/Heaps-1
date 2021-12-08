# 23. Merge k Sorted Lists
# https://leetcode.com/problems/merge-k-sorted-lists/

# Logic: Make a minHeap with the first node of all the LL. 
# Maintain a hashmap that will have which LL it belongs to. 
# Pop from heap and add to new LL. return the new LL.

# Time Complexity: O(nlogk) [For heap]
# Space Complexity: O(k) [for heap]

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if len(lists) == 0:
            return None
        
        heap = []
        hashmap = dict()
        
        newHead = ListNode()
        ptr = newHead
        
        for i in lists:
            if i:
                if i.val in hashmap:
                    hashmap[i.val].append(i)
                else:
                    hashmap[i.val] = [i]
                heapq.heappush(heap,i.val)
            
            
        while heap:
            minVal = heapq.heappop(heap)
            node = hashmap[minVal].pop()
            
            if len(hashmap[minVal]) == 0:
                hashmap.pop(minVal)
            
            newNode = ListNode(node.val)
            ptr.next = newNode
            ptr = ptr.next
            
            if node.next:
                node = node.next
                if node.val in hashmap:
                    hashmap[node.val].append(node)
                else:
                    hashmap[node.val] = [node]
                heapq.heappush(heap,node.val)
        
        return newHead.next