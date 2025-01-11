# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:

        """
        [1,4,5],[1,3,4]

        """
        def merge2Lists(l1, l2):
            dummy = ListNode(0)   # sentinel
            tail = dummy

            while l1 and l2:
                if l1.vl < l2.val:
                    tail.next = l1
                    l1 = l1.next
                else:
                    tail.next = l2
                    l2 = l2.next
                tail = tail.next

            # Append any remaining nodes
            if l1:
                tail.next = l1
            else:
                tail.next = l2

            return dummy.next

        if len(lists) == 1:
            return lists[0]
        if not lists: return

        h1= merge2Lists(lists[0], lists[1])
        
        for i in range(2, len(lists)):
            h1 = merge2Lists(h1, lists[i])
        return h1

                
            
































    #     #merging two lists at a time. 
    #     if not lists or len(lists) == 0:
    #         return None

    #     # if len(lists) == 1:
    #     #     return lists

    #     while len(lists)>1:
    #         answer = []
    #         for i in range(0, len(lists), 2):
    #             #better way is to use i , i+1 only check if i+1 exists, like this
    #             l1 = lists[i]
    #             l2 = lists[i+1] if i+1 < len(lists) else None
    #             answer.append(self.mergeTwoLists(l1, l2)) 
    #         lists = answer

    #     return lists[0]



        

    # def mergeTwoLists(self, ls1, ls2):
    #     #todo

    #     temp = ListNode()
    #     head = temp
    #     # i = 0
    #     # j = 0

    #     while ls1 and ls2:
    #         if ls1.val < ls2.val:
    #             temp.next = ls1
    #             temp = temp.next
    #             ls1 = ls1.next
    #             # i += 1

    #         elif ls1.val >= ls2.val:
    #             temp.next = ls2
    #             temp = temp.next
    #             ls2 = ls2.next
    #             # j += 1

        
    #     if ls1:
    #         temp.next = ls1

    #     if ls2:
    #         temp.next = ls2

    #     return head.next

        
    
        

        
