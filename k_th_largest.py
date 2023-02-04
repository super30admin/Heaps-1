# Time Complexity :
# O(N log k) , where N is the total number of elements in all lists combined and k is the number of lists

# Space Complexity :
# O(k)

# Did this code successfully run on Leetcode :
#Yes

#We start by adding the first element of each list to a min heap. Then we pop (the min of all the lists gets popped). Then we add the popped node's next to the heap. 
#We repeat the above process till all the elements are processed. At each step, we pop the minumum available element and hence the order in which the elements are popped is the sorted list of all the elements together

from heapq import heappush as insert
from heapq import heappop as remove

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        self.heap = []
        #self.heap2 = []
        self.head = None

        for i in range(0,len(lists)):
            if lists[i] == None :
                continue
            insert(self.heap,(lists[i].val,i,lists[i]))

        if len(self.heap) == 0 :
            return None

        val,i,node = remove(self.heap)
        self.head = node

        while len(self.heap) != 0 :
            if node.next != None :
                insert(self.heap,(node.next.val, i,node.next))
            val,i,node2 = remove(self.heap)
            node.next = node2
            node = node.next
        return self.head
