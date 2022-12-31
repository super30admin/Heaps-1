#Time Complexity : O(nk log k) or O(N log k) where N is n.k 
#Space Complexity :  O(k)
#Did this code successfully run on Leetcode : Yes

#code along with comments 
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        result = []                                     #using min heap
        dummy = ListNode(0)                             #creating dummy listnode
        curr = dummy                                    #curr contains dummy
        for node in lists:
            while node:                                 #if node exists
                heapq.heappush(result, node.val)        #we push it on to heap
                node = node.next                        #move to next node in lists
        
        while result:                                   #now we iterate over heap
            temp = ListNode(heapq.heappop(result))      #creating new listnode
            curr.next = temp                            #curr.next is the new listnode
            curr = curr.next                            #move curr pointer to next
        
        return dummy.next                               #returning dummy.next which is sorted list