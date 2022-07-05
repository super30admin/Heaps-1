import heapq as heap
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    '''Time Complexity: O(nlogk)
    Space Complexity: O(k)
    
    First push all the heads into minheap. Minheap cuz we can extract the minimum at any point of time. Extract the smallest head node and assign the next node of the same list as head and push it into the heap.
    '''
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        #Create an empty list for minheap of size k
        minheap=[]
        
        #Custom less than comparator using a lambda function taking ListNode objects x and y as parameters
        lessThan = lambda x, y: x.val < y.val
        ListNode.__lt__ = lessThan
        
        #Create a dummy head
        dummyNode=ListNode(-1)
        curr=dummyNode
        
        for i in range(len(lists)):
            if lists[i] is not None:
                heap.heappush(minheap,lists[i] )
        print(minheap)
        
        #Pop min 
        while len(minheap)>0:
            minimumNode=heap.heappop(minheap)
            #point the dummy.next to the minimum (curr.next)
            curr.next=minimumNode
            #push the next head
            if minimumNode.next is not None:
                heap.heappush(minheap, minimumNode.next)
            curr=minimumNode
        return dummyNode.next
            
