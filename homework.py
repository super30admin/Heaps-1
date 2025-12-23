# Kth largest in Array
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # 1. brute force: sort all the elements and then get the 3rd largest element directly from it: O(nlogn) 
        # for sorting
        # 2. Try to find the largest element in k passes, in first pass find the greatest element and mark it as something like the number out of the given range for constraints. This way we can find the kth largest in k passes. O(n*k)
        # 3. We can use a min heap of size k: whenever the heap size is k and we want to add a new element
        # check if the new element is greater than the root element and only insert then and remove the root. By the end of the iteration we can find the heap of size k and the root will be the kth largest. 
        # O(n*logk)

        min_heap = [] #needs to be of size k
        for i, n in enumerate(nums):
            if i < k:
                heapq.heappush(min_heap, n)
            else:
                if n > min_heap[0]:
                    heapq.heappushpop(min_heap, n)
        
        return min_heap[0]


## Problem2
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # N -> is the total number of elements in all the lists
        # brute force: merge all the lists and then sort them. NlogN
        # have k pointers each pointing at starting of each list and then find the least every time from the k lists. O(k) for finding the min from the head of the k lists + O(N) repeat for every element in the array: O(N*k)
        # Since we are doing repeated work every time we are getting the minimum from the k heads we can use a min heap for this. heapify: O(klogk) + log(k) for every pop and we continue until the min heap is empty since : O(N*log(k))

        min_heap = [] # only consists of valid node values
        temp = dummy = ListNode() 
        for i, l in enumerate(lists):
            if l:
                heapq.heappush(min_heap, (l.val, i))
        
        while min_heap:
            smallest, list_index = heapq.heappop(min_heap)
            
            if lists[list_index].next:
                lists[list_index] = lists[list_index].next
                heapq.heappush(min_heap, (lists[list_index].val, list_index))
            temp.next = ListNode(val=smallest)
            temp = temp.next
        
        return dummy.next





        






        