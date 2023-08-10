#Method 1 -Brute Force - put all elements to an arrya and sort -> NlogN

#Method 2 - Min Heap - min heap all elements in an order-> all 1st go in, then, once min removed, the next element from the respective LL is added. -> N Log k

#Method 3 - Merge 2 lists at a time - comapre 2 lists at a time and evenetually, do all lists.-> NK

#Order of solutions in terms of TC -> 2,3,1

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        #Method 1 -Brute Force - put all elements to an arrya and sort -> NlogN
        # nodes = []
        # head = curr = ListNode(0)
        # for l in lists:
        #     while l:
        #         nodes.append(l.val)
        #         l = l.next

        # for x in sorted(nodes):
        #     curr.next = ListNode(x)
        #     curr = curr.next

        # return head.next
        
        #Method 2 - Min Heap - min heap all elements in an order-> all 1st go in, then, once min removed, the next element from the respective LL is added. -> N Log k
        # heap=[]
        # curr=dummy=ListNode(-1)

        # for i,l in enumerate(lists):
        #     if l:
        #         heappush(heap,(l.val,i))
        # while heap:
        #     value,i=heappop(heap)
        #     curr.next=ListNode(value)
        #     if lists[i].next:
        #         heappush(heap,(lists[i].next.val,i))
        #         lists[i]=lists[i].next
        #     curr=curr.next
        # return dummy.next

        #Method 3 - Merge lists 2 at a time - NK
        
        def mergestuff(l1,l2):
            curr=dummy=ListNode(-1)
            while l1 and l2:
                if l1.val<l2.val:
                    curr.next=l1
                    l1=l1.next
                else:
                    curr.next=l2
                    l2=l2.next
                curr=curr.next
            
            if l1: curr.next=l1
            if l2: curr.next=l2
            return dummy.next

        if len(lists)==0: return None
        if len(lists)==1: return lists[0]
        else:
            res=lists[0]
        for i in range(1,len(lists)): 
            res=mergestuff(res,lists[i]) #each time there are N comaprisons and we call this K times -> NK
        return res
        
    



        
                