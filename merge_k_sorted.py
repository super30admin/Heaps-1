# n=size of big list
# m=size of node_list
# Time Complexity :O(n*mLog(m*n))
# Space Complexity :O(n*m)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        l=[]
        heapq.heapify(l)
        if(len(lists)==0):
            return None
        for i in lists:
            temp=i
            while(temp):
                heapq.heappush(l, temp.val)
                temp=temp.next
        
        result=[]
        if(len(l)==0):
            return None
        temp=None
        while(len(l)):
            if(temp==None):
                temp=ListNode(heapq.heappop(l))
                head=temp
                # result.append(temp)
            else:
                temp.next=ListNode(heapq.heappop(l))
                temp=temp.next
        
        return head
        pass