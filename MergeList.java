// Time Complexity : O(N * log k), k = number of lists, N = total number of nodes in all list (n * k), n = avg length of each list
// Space Complexity :O(k), height of the tree which will be k elements in queue.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Maintain a min heap of size K to find the miniumum element while traversing.
// We did a heap sort

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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));
        ListNode dummy = new ListNode(-1);
        for(ListNode head : lists){
            if(head != null){
                pq.add(head);
            }
        }

        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode el = pq.poll();
            curr.next = el;
            curr = curr.next;

            if(el.next != null){
                pq.add(el.next);
            }    
        }
        
        return dummy.next;
    }
}


// Another Approach
// Time Complexity : O(N * k) or O(nk^2), k = number of lists, N = total number of nodes in all list (n * k), n = avg length of each list
// Space Complexity :O(1), no extra auxiallry space being used
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Merge every list one by one

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
        
        for(ListNode head : lists){
            if(head != null){
                result = merge(result,head);
            }     
        }
        return result.next;
    }

    private ListNode merge(ListNode h1 , ListNode h2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                curr.next = h1;
                h1 = h1.next;
            }
            else{
                curr.next = h2;
                h2 = h2.next; 
            }

            curr = curr.next;
        }

        if(h1 != null){
            curr.next = h1;
        }

        if(h2 != null){
            curr.next = h2;
        }


        return dummy.next;
    }
}