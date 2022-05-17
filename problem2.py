#merge k sorted list

# // Time Complexity : O(N k Log k)
# // Space Complexity : O(k)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def mergeKLists(self, lists):
        merged=None
        def merge (l1, l2):
            dummy = ListNode(-1)
            curr = dummy
            while(l1 and l2):                           #check two linked lists
                if(l1.val < l2.val):                    #add the least one first and go to the next one
                    curr.next = l1
                    l1=l1.next
                else:
                    curr.next = l2
                    l2=l2.next
                curr=curr.next
            if(l1):
                curr.next =l1                           #if there are still elements remaining, add the rest
            if(l2):
                curr.next = l2
                
            return dummy.next
        for i in lists:
            merged = merge(merged, i)
        return merged
        