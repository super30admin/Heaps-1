####23. Merge k Sorted Lists##############################################################################################################
// Time Complexity : log N
// Space Complexity : number of Link List
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
We will take the initial nodes of Link list and put it in heap than will pop the first element and add it to new created link list once the pop is done the element nest to it is added in heap and we continue to do this till heap is empty


import heapq
ListNode.__lt__=lambda x,y: x.val < y.val

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        mergell=ListNode(None)
        curr=mergell
        minheap=[]
        for list1 in lists:
            if list1 != None:
                heappush(minheap, list1)
        #print(minheap)

        while len(minheap)>0:
            minnode=heappop(minheap)
            curr.next=minnode
            curr=curr.next
            #print(curr,minnode)
            if curr.next != None:
                heappush(minheap, curr.next)
        return mergell.next



        


