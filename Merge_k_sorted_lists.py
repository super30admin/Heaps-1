# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# TC: O(nk log(k)) 
# SC: O(k)

class Solution:

    # def insert(self,node):
    #     print(node.val)
    #     if self.head_res==None:
    #         self.head_res=node
    #     else:
    #         cur=self.head_res
    #         while cur.next!=None:
    #             cur=cur.next
    #         cur.next=node

    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        head_res=cur=ListNode()
        heap=[]
        heapq.heapify(heap)
        for i,lis in enumerate(lists):
            if lis:
                heapq.heappush(heap,(lists[i].val,i))

        print(heap)

        while len(heap)>0:
            pop_val,i=heapq.heappop(heap)
            cur.next=ListNode(pop_val)
            cur=cur.next
            # self.insert(temp)
            if lists[i].next:
                heapq.heappush(heap,(lists[i].next.val,i))
                lists[i]=lists[i].next

        print(heap)


        return head_res.next
        