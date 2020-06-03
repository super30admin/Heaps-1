# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#Problem 2: Merge k sorted lists
#Time complexity: n*log(k), n the sum of number of elements of ALL the lists
#Space complexity O(k), size of the heap, k is the number of list in lists
'''
We start from the head of each list, we get the minimum and the list's index
amongst these k list (k=len(lists)). we point our root node to it then make it
our root node (we kept a pointer on the head). For that list that gave the minimum
we move it to list.next . We keep doing that until all of my lists are None.
We return the head of the result node.

Now is there a way to find the min faster? We see that there's only one item
that is updated in lists and the rest of the heads are the same. So it's not 
efficient to go through them again. We can create a heap with all the heads values 
and index. To get the min we pop(). And then we push() the next value of the updated
head to heap. Both of these operations are log(k) instead of k, which is a huge
improvement if we have many list in lists.

'''
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        lists=[head for head in lists if head]
        #edge case
        if not lists or not any(lists):
            return None
        dummy=ListNode(0)
        root=dummy
        k=len(lists)
        heap=[(head.val,i) for i,head in enumerate(lists)]
        heapq.heapify(heap)
        while k:
            _,idx=heapq.heappop(heap)
            root.next=lists[idx]
            root=lists[idx]
            lists[idx]=lists[idx].next
            
            if lists[idx]:heapq.heappush(heap,(lists[idx].val,idx))   
            else:k-=1
        return dummy.next
