# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:

        # Merge Linked List Method (Unoptimised)
        # Time: O(nk*k)
        # Space: O(1)
        # def merge(l1, l2):
        #     dummy = ListNode()
        #     tempdummy = dummy
        #     templ1 = l1
        #     templ2 = l2

        #     while l1 and l2:
        #         if l1.val <= l2.val:
        #             tempdummy.next = ListNode(l1.val)
        #             l1 = l1.next
        #         else:
        #             tempdummy.next = ListNode(l2.val)
        #             l2 = l2.next
        #         tempdummy = tempdummy.next

        #     if l1:
        #         tempdummy.next = l1
        #     else:
        #         tempdummy.next = l2
        #     # print(dummy)
        #     return dummy.next

        # dum = ListNode(-float('inf'))
        # for i in range(len(lists)):
        #     dum = merge(dum, lists[i])
        #     # print(dum)
        # return dum.next

        # List sort method
        # Time: O(nklognk)
        # Space: O(nk)
        # dummy = ListNode()
        # result = []
        # for node in lists:
        #     curr = node
        #     while curr:
        #         result.append(curr.val)
        #         curr = curr.next
        # curr = dummy
        # result.sort()
        # for val in result:
        #     curr.next = ListNode(val)
        #     curr = curr.next
        # # print(result)
        # return dummy.next

        # Heap Approach
        # Time: O(nklogk)
        # Space: O(nk)
        result = []
        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(result, (lists[i].val, i))
                lists[i] = lists[i].next

        dummy = ListNode()
        dummyP = dummy
        while result:
            node_val, idx = heapq.heappop(result)
            dummyP.next = ListNode(node_val)
            dummyP = dummyP.next
            if lists[idx]:
                heapq.heappush(result, (lists[idx].val, idx))
                lists[idx] = lists[idx].next

        return dummy.next











