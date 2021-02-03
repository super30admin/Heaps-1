//Time Complexity: O(Nk log k) where N is the average length of the lists and k is the number of lists
//Space Complexity: O(k)

//Successfully runs on leetcode: 7 ms

//Approach: We are using min-heap based on the listnode values and keeping a track of only k elements(equal to number of
//lists) in the min-heap. We keep on adding the minimum node in the resultant list and add the next element of the list
//from where we got the minimum node to the heap. In this way, everytime, we will be adding one minimum node to the result
//and we get a sorted list after merging k lists.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head: lists)
        {
            if(head != null)
                pq.add(head);
        }
        
        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();
            if(min.next != null)
                pq.add(min.next);
            dummy.next = min;
            dummy = dummy.next;
        }
        return result.next;
    }
}


//Time Complexity: O(Nk^2) where N is the average length of the lists and k is the number of lists
//Space Complexity: O(NK)

//Successfully runs on leetcode: 137 ms

//Approach: Firstly, we are comparing the nodes of any two lists, merging them and comparding the merged result with 
//the next list and so on


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        for(ListNode list: lists)
        {
            result = merge(result,list);
        }
        return result.next;
    }
    
    private ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode res = dummy;
        int min = Integer.MAX_VALUE;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                dummy.next = l1;
                l1 = l1.next;
            }
            else
            {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;    
        }
        
        if(l1 != null)
            dummy.next = l1;
        if(l2 != null)
            dummy.next = l2;
        
        return res.next;
    }
}

