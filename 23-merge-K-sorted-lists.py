# Question: Merge k sorted linked lists and return it as one sorted list.

# LINEAR APPROACH

# Time: O(k * N) where N = n*k (where n: avg length of linked list and k: number of lists) the total number of nodes and K is the number of lists.
# Space: O(1) if we don't consider the resultant linked list.

# So in this approach we merge all the k linked lists one by one.
# Starting with the first linked list which is on 0th index, then we loop from the 1st idx until the end.
# In each iteration we merge the current merged linked list with the next linked list and update the merged linked list to the new merged linked list.
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists: return None
        newArr = lists[0]
        for i in range(1,len(lists)):
            list1 = newArr
            list2 = lists[i]
            if not list1: 
                newArr = list2
                continue

            dummy = ListNode(0)
            curr = dummy

            while list1 and list2:
                if list1.val <= list2.val:
                    curr.next = list1
                    list1 = list1.next
                else:
                    curr.next = list2
                    list2 = list2.next
                curr = curr.next
            
            if list1:
                curr.next = list1
            if list2:
                curr.next = list2
            newArr = dummy.next

        return newArr
    
# HEAP APPROACH

# Time: O(N log K) which is n*k log k where n is avg len of linked list and k is the number of linked lists.
# Space: O(k) for the heap stack

# In this approach we use min heap and give priority to the val then to the idx of when it comes and then to the node itself.
# At first we add all the heads of the linked lists to the heap
# After that we create a dummy node and assign curr to it because we will be building the merged linked list from the dummy node.
# The we loop until the heap is empty while popping the top element which would be the minimum element from all k heads/currents of the linked lists.
# Then we add the popped node to the linked list that we are creating and move the current pointer.
# after that we check if the popped node had next if yes we add that next node as well to the heap.

# We add index to the heap because if we have two nodes with the same value we want to give priority to the one that came first in the input list of linked lists 
    # or else we get an error because we can't compare the two nodes to decide which one should be on top of the heap.

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        pq = []

        for i in range(len(lists)):
            lin_list = lists[i]
            if lin_list: heapq.heappush(pq,(lin_list.val,i,lin_list))

        dummy = ListNode(-1)
        curr = dummy
        while pq:
            _, idx, min_val = heapq.heappop(pq)

            curr.next = min_val
            curr = curr.next

            if min_val.next: heapq.heappush(pq,(min_val.next.val,idx,min_val.next))

        return dummy.next