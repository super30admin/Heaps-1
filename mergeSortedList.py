import heapq

class ListNode:
    def __init__(self,val=0,next=None):
        self.val=val
        self.next=next

    def __repr__(self):
        return f"{self.val}->{self.next}"

def mergeKLists(lists):
    heap=[]

    class Wrapper:
        def __init__(self,node):
            self.node=node
        
        def __lt__(self,other):
            return self.node.val <other.node.val

    for l in lists:
        if l:
            heapq.heappush(heap,Wrapper(l))
    
    dummy=ListNode(0)
    current=dummy

    while heap:
        node=heapq.heappop(heap).node
        current.next=node
        current=current.next
        if node.next:
            heapq.heappush(heap,Wrapper(node.next))
    return dummy.next

def build_linked_list(arr):
    dummy=ListNode(0)
    current=dummy
    for num in arr:
        current.next=ListNode(num)
        current=current.next
    return dummy.next

def print_linked_list(head):
    res=[]
    while head:
        res.append(head.val)
        head=head.next
    print(res)

lists=[
    build_linked_list([1,4,5]),
    build_linked_list([1,3,4]),
    build_linked_list([2,6])
]
merged_head=mergeKLists(lists)
print_linked_list(merged_head)