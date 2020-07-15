"""

    Student : Shahreen Shahjahan Psyche
    Time    : O(NKlogK) [Where N is the number of average elements and K is the number of LinkedList/Also the size of the heap]
    Space   : O(K) [My Heap size]
    
    Pased Test Cases : Yes


"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


# As python's heapq does not allow me to pass the ListNode class directly, thats why I am creating a wrapper class, which matches the value with other values of
# the heap while pushing into the heap

class Node(object):
    
    def __init__(self, val: int, node = None):
        self.val = val
        self.node = node

    def __repr__(self):
        return f'Node value: {self.val}'
    
    # comparing values
    def __lt__(self, other):
        return self.val < other.val
    
    def returnNode(self):
        return self.node
    
    
class Solution:
    def minHeap(self, lists):
        
        import heapq
        
        # this is the heap
        track = []
        # creating a dummy node for cleaner code
        dummyNode = ListNode(float('-inf'))
        head = dummyNode
        
        # first pushing all the heads of the linked lists inside the list in the heap
        for i in range(len(lists)):
            # edge case
            if not lists[i]:
                continue
            curr = Node(lists[i].val, lists[i])
            heapq.heappush(track, curr)
        
        # now in this loop, until my heap is empty it runs and one by listnode it extracts from heap, adds into the LinkedList and finally pushes the next
        # element if available inside the heap
        while track:
            curr = heapq.heappop(track)
            curr_node = curr.returnNode()
            dummyNode.next = curr_node
            if curr_node.next:
                heapq.heappush(track, Node(curr_node.next.val, curr_node.next))
            dummyNode = dummyNode.next 
        
        return head.next 
        
        
    
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        
        if not lists:
            return 
        
        head = self.minHeap(lists)
        
        return head
        
        
