'''
time complexity: O(Nlogk)
N is total node, k is number of link list
space complexity: O(k)

'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(ListNode):
    def __lt__(self,other):
        return self.val<other.val
    ListNode.__lt__ = __lt__
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        ls = []
        for head in lists:
            if(head!=None):
                heapq.heappush(ls,head)
     
        temp = ListNode(-1)
        curr = temp
        while(len(ls)!=0):
            minNode = heapq.heappop(ls)
            curr.next = minNode
            curr = curr.next
            if(minNode.next!=None):
                heapq.heappush(ls,minNode.next)
        return temp.next