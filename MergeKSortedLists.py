import heapq

class Solution:

    class ListNode:
        def __init__(self, val=0, next=None):
            self.val = val
            self.next = next

    def mergeKLists(self, lists):
        heap = []
        head = tail = self.ListNode(0)
        
        for i in range(len(lists)):
            heapq.heappush(heap, (lists[i].val, i, lists[i]))
        
        while heap:
            node = heapq.heappop(heap)
            node = node[2]
            tail.next = node
            tail = tail.next
            if node.next:
                i += 1
                heapq.heappush(heap, (node.next.val, i, node.next))
                
        return head.next

if __name__ == "__main__":
    s = Solution()
    lists = [[1,4,5],[1,3,4],[2,6]]
    print(s.mergeKLists(lists))