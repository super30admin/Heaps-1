#time complexity: O(nklog(k))
#space complexity: O(k)
#ran on leetcode: Yes
#Insert all the heads inside heap. Now, loop till heap is not empty, in each iteration get the top element from the heap and insert the next element in top's linkedlist to the final output. Also delete the top element from the heap. 
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        head=None
        H=[]
        i=0
        if(lists==None):
            return None
        if(len(lists)==1):
            return lists[0]
        for node in lists:
            if(node==None):
                continue
            H.append((node.val,i,node))
            i+=1
        heapq.heapify(H)
        if(H==[]):
            return None
        val,i,head=heapq.heappop(H)
        temp=head
        
        while(H!=[]):
            if(temp.next!=None):
                heapq.heappush(H,(temp.next.val,i,temp.next))
            val,i,temp2=heapq.heappop(H)
            temp.next=temp2
            temp=temp.next
            print(temp.val)
        
    
        return head
