# TC: O(N log k)
# SC: O(k)
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        h=[]
        dummy=ListNode()
        curr=dummy
        count=0
        for i in lists:
            if i:
                heapq.heappush(h,(i.val,count,i))
                count+=1
        
        while h:
            curr.next=latest=heapq.heappop(h)[2]
            curr=curr.next
            if latest.next:
                heapq.heappush(h,(latest.next.val,count,latest.next))
                count+=1
        
        return dummy.next