# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:

        #Here we  merge 2 lists at a time, until only one is left
        #Time complexity - O(Nk) - where k is no. of lists and N is all the elements present in all lists. N=n.k where we traverse all elements (n) of k lists to merge and k traversal to traverse k lists
        #Space complexity - O(1)  
        merged = None

        for i in range(len(lists)):
            merged = self.merge2lists(merged,lists[i])
        
        return merged


    #Function to merge 2 lists
    def merge2lists(self, l1, l2):
        if not l1:
            return l2
        
        if not l2:
            return l1
        
        dummy = ListNode(0)
        l3 = dummy

        while l1 and l2:
            if l1.val<l2.val:
                l3.next = l1
                l1 = l1.next
            else:
                l3.next = l2
                l2 = l2.next
            l3 = l3.next
        
        if l1:
            l3.next = l1

        if l2:
            l3.next = l2

        return dummy.next

        #----------------------------------------------OR------------------------------------------------------


        #Using heaps. Here we add head of all lists into the heap. Then we pop the min element from heap and add it to o/p list. We increment the pointer of poped element's list to next. This is done until heap is empty
        #Time complexity - O(Nlogk) - where k is no. of lists and N is all the elements present in all lists.
        #Space complexity - O(k)  

        
        #comparator for heap, since values of Linked list need to be compared
        
        #setattr(ListNode, "__lt__", lambda self, other: self.val <= other.val)
        #---OR--
        ListNode.__lt__ = lambda self, other: self.val<other.val 
        
        heap_arr = []

        for l in lists:
            if l:
                heap_arr.append(l)
        
        heapq.heapify(heap_arr)

        res = ListNode(0)
        cur = res

        while heap_arr:
            curMin = heapq.heappop(heap_arr)
            cur.next = curMin
            cur = cur.next
            if curMin and curMin.next:
                heapq.heappush(heap_arr, curMin.next)

        return res.next



        