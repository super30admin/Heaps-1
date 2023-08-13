# Definition for singly-linked list.

#Time complexity: O(Nlogk) = N=> no.of lists (k) * len(each list)
#Space complexity: O(N)
#Using min heap for this as we require it to be sorted
#In this approach we are adding only k nodes into the heap

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        store_elements=[]
        head=ListNode(0)
        curr=head
        #Using enumerate function to get index,value
        for index, node in enumerate(lists):
            if node:
            #node can't be pushed directly, hence custom function is created using tuple.
            #index has to be passed because node doesn't have natural ordering like integer or float
            #It is used to differentiate 2 nodes with same value
                heapq.heappush(store_elements,(node.val,index,node))
                
        while store_elements:
            value,i,temp=heapq.heappop(store_elements)
            head.next=temp
            head=head.next
            if temp.next:
                heapq.heappush(store_elements,(temp.next.val,i,temp.next))
        return curr.next



#Time Complexity: O(NlogN) N=> no.of lists (k) * len(each list)
#Space complexity: O(N)
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        store_elements=[]
        head=ListNode(0)
        store=head
        for node in lists:
            while node:
                heapq.heappush(store_elements,node.val)
                node=node.next
        while store_elements:
            value= heapq.heappop(store_elements)
            temp=ListNode(value)
            head.next=temp
            head=head.next
        return store.next