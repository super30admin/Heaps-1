## Problem2

# Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

# Method1: Storing all the linked list elements in an array and sorting and puting back into the linked list
# We have k linked lists --- size n1, n2, n3 ......... let average size = n
# total size = k * (n1 + n2 + n3 + ...) ....... = n * k
# Time Complexity : O(n * k) -- create array + O(n * k * Log(n * k)) --- sort array + O(n * k) -- create linked list back
# Space Complexity : O(n * k) -- creating new array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Iterate through all elements of the linked list and put it in an array. Sort the array, and put the elements of the sorted array back
# in a linked list

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    # override the comparison operator
    def __lt__(self, nxt):
        return self.val < nxt.val

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        # brute force using array
        if(not lists):
            return None
        flatArr = []
        for i in range(len(lists)):
            curr = lists[i]
            while(curr):
                flatArr.append(curr.val)
                curr = curr.next
        
        if(not flatArr):
            return None

        flatArr.sort()
        head = ListNode(flatArr[0])
        curr = head
        for i in range(1, len(flatArr)):
            newNode = ListNode(flatArr[i])
            curr.next = newNode
            curr = newNode

        return head

def printLinkedList(root):
    curr = root
    while(curr):
        print(curr.val, end=" -> ")
        curr = curr.next
    print()


node1 = ListNode(1)
node2 = ListNode(2)
node4 = ListNode(4)
node5 = ListNode(5)
node6 = ListNode(6)
head1 = node1
node1.next = node2
node2.next = node4
node4.next = node5
node5.next = node6

node22 = ListNode(2)
node23 = ListNode(3)
node27 = ListNode(7)
node28 = ListNode(8)
head2 = node22
node22.next = node23
node23.next = node27
node27.next = node28

node31 = ListNode(1)
node33 = ListNode(3)
node34 = ListNode(4)
node35 = ListNode(5)
head3 = node31
node31.next = node33
node33.next = node34
node34.next = node35

node42 = ListNode(2)
node45 = ListNode(5)
node46 = ListNode(6)
head4 = node42
node42.next = node45
node45.next = node46

lists = [head1, head2, head3, head4]
print("# Method1: Storing all the linked list elements in an array and sorting and puting back into the linked list")
sol = Solution()
head = sol.mergeKLists(lists)
printLinkedList(head)


# Method2: Using min heap with custom comparator in the object class
# We have k linked lists --- size n1, n2, n3 ......... let average size = n
# total size = k * (n1 + n2 + n3 + ...) ....... = n * k
# Time Complexity : O(n * k * Logk)
# Space Complexity : O(k) -- using min heap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Start by adding the head nodes of each of the k sorted linked lists in a min heap. This min heap has custom comparator where
# elements are sorted based of val property of the ListNode object. Whenever we pop the min node from the linked list, we attach it to the 
# previous min node. For that popped out node, we insert its next node if exists into the heap. So we always maintain a min heap of k size.
# We then set the next of this popped node to None

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#     # override the comparison operator
#     def __lt__(self, nxt):
#         return self.val < nxt.val    

import heapq
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        if(not lists):
            return None

        minheap = []
        
        # create minheap starting with first elements of each linked list
        # k-size heap
        for i in range(len(lists)):
            if(lists[i]):
                heapq.heappush(minheap, lists[i])

        if(not minheap):
            return None

        head = None
        prev = None
        # maintain heap of k-size
        while(minheap):
            # get min from heap
            curr = heapq.heappop(minheap)
            
            # newNode = ListNode(curr.val)
            if(not head):
                head = curr
                prev = curr
            else:
                prev.next = curr
                prev = curr

            if(curr.next):
                heapq.heappush(minheap, curr.next)

            curr.next = None

        return head

sol = Solution()
print("Method2: Using min heap with custom comparator in the object class")
head = sol.mergeKLists(lists)
printLinkedList(head)

# Method3: Using min heap with custom comparator in the main class
# We have k linked lists --- size n1, n2, n3 ......... let average size = n
# total size = k * (n1 + n2 + n3 + ...) ....... = n * k
# Time Complexity : O(n * k * Logk)
# Space Complexity : O(k) -- using min heap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The logic is exactly same as above. Just we are using the custom comparator in the main class, rather than creating it in the 
# object class

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#     # override the comparison operator
#     def __lt__(self, nxt):
#         return self.val < nxt.val

import heapq
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        if(not lists):
            return None

        minheap = []
        # overload the __lt__() method of the ListNode class based on our object property
        ListNode.__lt__ = lambda n1,n2:n1.val < n2.val
        
        # create minheap starting with first elements of each linked list
        # k-size heap
        for i in range(len(lists)):
            if(lists[i]):
                heapq.heappush(minheap, lists[i])

        if(not minheap):
            return None

        
        head = None
        prev = None
        # maintain heap of k-size
        while(minheap):
            # get min from heap
            curr = heapq.heappop(minheap)

            # newNode = ListNode(curr.val)
            if(not head):
                head = curr
                prev = curr
            else:
                prev.next = curr
                prev = curr

            if(curr.next):
                heapq.heappush(minheap, curr.next)

            curr.next = None

        return head

node1 = ListNode(1)
node2 = ListNode(2)
node4 = ListNode(4)
node5 = ListNode(5)
node6 = ListNode(6)
head1 = node1
node1.next = node2
node2.next = node4
node4.next = node5
node5.next = node6

node22 = ListNode(2)
node23 = ListNode(3)
node27 = ListNode(7)
node28 = ListNode(8)
head2 = node22
node22.next = node23
node23.next = node27
node27.next = node28

node31 = ListNode(1)
node33 = ListNode(3)
node34 = ListNode(4)
node35 = ListNode(5)
head3 = node31
node31.next = node33
node33.next = node34
node34.next = node35

node42 = ListNode(2)
node45 = ListNode(5)
node46 = ListNode(6)
head4 = node42
node42.next = node45
node45.next = node46

lists = [head1, head2, head3, head4]     
sol = Solution()
print("Method3: Using min heap with custom comparator in the main class")
head = sol.mergeKLists(lists)
printLinkedList(head)

# Method4: Using min heap with tuple of (propertyValue, object)
# We have k linked lists --- size n1, n2, n3 ......... let average size = n
# total size = k * (n1 + n2 + n3 + ...) ....... = n * k
# Time Complexity : O(n * k * Logk)
# Space Complexity : O(k) -- using min heap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The logic is exactly same as above. Just instead of custom comparator we use a tuple of (property Value, ListNode) as entries of our
# min heap.

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    # override the comparison operator
    def __lt__(self, nxt):
        return self.val < nxt.val

import heapq
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        if(not lists):
            return None

        minheap = []
        
        # create minheap starting with first elements of each linked list
        # k-size heap
        for i in range(len(lists)):
            if(lists[i]):
                heapq.heappush(minheap, (lists[i].val, lists[i]))

        if(not minheap):
            return None

        # while(minheap):
        #     print(heapq.heappop(minheap).val)

        head = None
        prev = None
        # maintain heap of k-size
        while(minheap):
            # get min from heap
            val, curr = heapq.heappop(minheap)

            # newNode = ListNode(curr.val)
            if(not head):
                head = curr
                prev = curr
            else:
                prev.next = curr
                prev = curr

            if(curr.next):
                heapq.heappush(minheap, (curr.next.val, curr.next))

            curr.next = None

        return head

node1 = ListNode(1)
node2 = ListNode(2)
node4 = ListNode(4)
node5 = ListNode(5)
node6 = ListNode(6)
head1 = node1
node1.next = node2
node2.next = node4
node4.next = node5
node5.next = node6

node22 = ListNode(2)
node23 = ListNode(3)
node27 = ListNode(7)
node28 = ListNode(8)
head2 = node22
node22.next = node23
node23.next = node27
node27.next = node28

node31 = ListNode(1)
node33 = ListNode(3)
node34 = ListNode(4)
node35 = ListNode(5)
head3 = node31
node31.next = node33
node33.next = node34
node34.next = node35

node42 = ListNode(2)
node45 = ListNode(5)
node46 = ListNode(6)
head4 = node42
node42.next = node45
node45.next = node46

lists = [head1, head2, head3, head4]  
sol = Solution()
print("Method4: Using min heap with tuple of (propertyValue, object)")
head = sol.mergeKLists(lists)
printLinkedList(head)


# Method5: Using min heap with dummy node
# We have k linked lists --- size n1, n2, n3 ......... let average size = n
# total size = k * (n1 + n2 + n3 + ...) ....... = n * k
# Time Complexity : O(n * k * Logk)
# Space Complexity : O(k) -- using min heap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The logic is same as above. Just we are starting our curr pointer from a dummy node.
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#     # override the comparison operator
#     def __lt__(self, nxt):
#         return self.val < nxt.val

import heapq
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        if(not lists):
            return None

        minheap = []
        ListNode.__lt__ = lambda n1,n2:n1.val < n2.val
        
        # create minheap starting with first elements of each linked list
        # k-size heap
        for i in range(len(lists)):
            if(lists[i]):
                heapq.heappush(minheap, lists[i])

        if(not minheap):
            return None
        
        dummy = ListNode(-1)
        curr = dummy
        # maintain heap of k-size
        while(minheap):
            # get min from heap
            minn = heapq.heappop(minheap)
            curr.next = minn

            if(minn.next):
                # add next element of the current to the min heap
                heapq.heappush(minheap, minn.next)

            # move the curr pointer
            curr = curr.next

        return dummy.next
    
node1 = ListNode(1)
node2 = ListNode(2)
node4 = ListNode(4)
node5 = ListNode(5)
node6 = ListNode(6)
head1 = node1
node1.next = node2
node2.next = node4
node4.next = node5
node5.next = node6

node22 = ListNode(2)
node23 = ListNode(3)
node27 = ListNode(7)
node28 = ListNode(8)
head2 = node22
node22.next = node23
node23.next = node27
node27.next = node28

node31 = ListNode(1)
node33 = ListNode(3)
node34 = ListNode(4)
node35 = ListNode(5)
head3 = node31
node31.next = node33
node33.next = node34
node34.next = node35

node42 = ListNode(2)
node45 = ListNode(5)
node46 = ListNode(6)
head4 = node42
node42.next = node45
node45.next = node46

lists = [head1, head2, head3, head4]  
sol = Solution()
print("Method5: Using min heap with dummy node")
head = sol.mergeKLists(lists)
printLinkedList(head)


# Method6: Merging two sorted linked list at a time using two pointers
# We have k linked lists --- size n1, n2, n3 ......... let average size = n
# total size = k * (n1 + n2 + n3 + ...) ....... = n * k
# merging 2 lists takes - 2n time
# merging 3 lists takes - 2n + n = 3n time
# merging 4 lists takes - 3n + n = 4n time
# Total time = n * (1 + 2 + 3 + ------ K) = n * (k * (k -1) / 2) = n * (k ^ 2)
# Time Complexity : O(n * k * k)
# Space Complexity : O(1) -- we are merging the given nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# We merging two sorted linked lists at a time. This merged list then gets merged with the next sorted list.
# We continue this until we merge all k sorted lists

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        if(not lists):
            return None

        dummy = ListNode(-1)
        curr = dummy
        p1 = lists[0]
        for i in range(1, len(lists)):
            p2 = lists[i]
            # merging two sorted lists at a time using two pointers
            while(p1 and p2):
                if(p1.val <= p2.val):
                    curr.next = p1
                    p1 = p1.next
                else:
                    curr.next = p2
                    p2 = p2.next
                curr = curr.next

            # if p1 is still existing, just append p1 as it is
            if(p1):
                curr.next = p1

            # if p2 is still existing, just append p2 as it is
            if(p2):
                curr.next = p2

            # update the pointers
            curr = dummy
            # p1 would point to head of the merged lists
            p1 = dummy.next

        return p1


node1 = ListNode(1)
node2 = ListNode(2)
node4 = ListNode(4)
node5 = ListNode(5)
node6 = ListNode(6)
head1 = node1
node1.next = node2
node2.next = node4
node4.next = node5
node5.next = node6

node22 = ListNode(2)
node23 = ListNode(3)
node27 = ListNode(7)
node28 = ListNode(8)
head2 = node22
node22.next = node23
node23.next = node27
node27.next = node28

node31 = ListNode(1)
node33 = ListNode(3)
node34 = ListNode(4)
node35 = ListNode(5)
head3 = node31
node31.next = node33
node33.next = node34
node34.next = node35

node42 = ListNode(2)
node45 = ListNode(5)
node46 = ListNode(6)
head4 = node42
node42.next = node45
node45.next = node46

lists = [head1, head2, head3, head4]  
sol = Solution()
print("Method6: Merging two sorted linked list at a time using two pointers")
head = sol.mergeKLists(lists)
printLinkedList(head)

# Method7: Merging two sorted linked list at a time using two pointers covering all lists
# We have k linked lists --- size n1, n2, n3 ......... let average size = n
# total size = k * (n1 + n2 + n3 + ...) ....... = n * k
# merging 2 lists takes - 2n time
# merging 3 lists takes - 2n + n = 3n time
# merging 4 lists takes - 3n + n = 4n time
# Total time = n * (1 + 2 + 3 + ------ K) = n * (k * (k -1) / 2) = n * (k ^ 2)
# Time Complexity : O(n * k * k)
# Space Complexity : O(1) -- we are merging the given nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The Algo is same as above. Just here we started with a min value node as our first list.

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        def merge(res, listi):
            dummy = ListNode(-1)
            curr = dummy
            
            # merging two sorted lists at a time using two pointers
            while(res and listi):
                if(res.val <= listi.val):
                    curr.next = res
                    res = res.next
                else:
                    curr.next = listi
                    listi = listi.next
                curr = curr.next

            # if p1 is still existing, just append p1 as it is
            if(res):
                curr.next = res

            # if p2 is still existing, just append p2 as it is
            if(listi):
                curr.next = listi

            return dummy.next
        
        if(not lists):
            return None

        result = ListNode(float('-inf'))
        for i in range(len(lists)):
            if(lists[i]):
                result = merge(result, lists[i])

        return result.next

        
node1 = ListNode(1)
node2 = ListNode(2)
node4 = ListNode(4)
node5 = ListNode(5)
node6 = ListNode(6)
head1 = node1
node1.next = node2
node2.next = node4
node4.next = node5
node5.next = node6

node22 = ListNode(2)
node23 = ListNode(3)
node27 = ListNode(7)
node28 = ListNode(8)
head2 = node22
node22.next = node23
node23.next = node27
node27.next = node28

node31 = ListNode(1)
node33 = ListNode(3)
node34 = ListNode(4)
node35 = ListNode(5)
head3 = node31
node31.next = node33
node33.next = node34
node34.next = node35

node42 = ListNode(2)
node45 = ListNode(5)
node46 = ListNode(6)
head4 = node42
node42.next = node45
node45.next = node46

lists = [head1, head2, head3, head4]  
sol = Solution()
print("Method7: Merging two sorted linked list at a time using two pointers covering all lists")
head = sol.mergeKLists(lists)
printLinkedList(head)