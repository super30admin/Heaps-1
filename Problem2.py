# Time Complexity : O(nlogk) where n are the number of head nodes.
# Space Complexity : O(k) where k are the total number of nodes in total.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach


from queue import PriorityQueue
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
    
class Solution:
    def mergeKLists(self, lists):
        dummy = ListNode(-1)
        if not lists or len(lists) < 1:
            return dummy.next 
        pq = PriorityQueue()
        for i in range(len(lists)): # O(n) where k are the number of head nodes.
            if lists[i]:
                pq.put((lists[i].val,i,lists[i]))
                
        curr = dummy
        while pq.qsize() > 0: # O(log k) where n are the number of the nodes in total
            node = pq.get()
            curr.next = node[2]
            curr = curr.next 
            if node[2].next:
                pq.put((node[2].next.val,node[1],node[2].next))
        
        return dummy.next 
    
if __name__ == "__main__":
    s = Solution()
    n1 = ListNode(1)
    n1.next = ListNode(4)
    n1.next.next = ListNode(5)
    
    n2 = ListNode(1)
    n2.next = ListNode(3)
    n2.next.next = ListNode(4)
    
    n3 = ListNode(2)
    n3.next = ListNode(6)
    
    res = s.mergeKLists([n1, n2, n3])
    temp = []
    while res:
        temp.append(res.val)
        res = res.next
    print(temp)