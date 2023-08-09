package org.example;

// Time Complexity : O(N(k)) or O(nk*k) -> N is the total number of nodes in all the lists / k is the number of lists
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class MergeKsortedListsUsingForLoop {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode mergedList = new ListNode(Integer.MIN_VALUE);
        for(ListNode node: lists)
        {
            mergedList = mergeList(mergedList,node);
            // display(mergedList);
        }
        return mergedList.next;
    }

    public void display(ListNode mergedList)
    {
        ListNode displayList = mergedList;
        while(displayList!=null)
        {
            System.out.println(displayList.val);
            displayList = displayList.next;
        }
    }

    public ListNode mergeList(ListNode l1, ListNode l2)
    {
        ListNode result = new ListNode(-1);
        ListNode tempResult = result;
        while(l1!= null && l2!=null)
        {
            if(l1.val < l2.val)
            {
                tempResult.next = l1;
                l1 = l1.next;
            }else{
                tempResult.next = l2;
                l2 = l2.next;
            }
            tempResult = tempResult.next;
        }

        if(l1 !=null)
        {
            tempResult.next = l1;

        }
        if(l2 !=null)
        {
            tempResult.next = l2;

        }
        return result.next;
    }

}
