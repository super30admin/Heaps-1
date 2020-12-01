// Time Complexity : nklogk
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Having head at all the lists and traversing next after merging.

import java.util.PriorityQueue;

public class mergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;

        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> myQ = new PriorityQueue<>((a, b)->a.val - b.val);
        ListNode temp = new ListNode(-1);
        ListNode result = temp;

        for(ListNode head:lists){
            if(head != null){
                myQ.add(head);
            }
        }

        while(!myQ.isEmpty()){
            ListNode minimum = myQ.poll();
            temp.next = minimum;
            temp = temp.next;
            if(minimum.next!= null){
                myQ.add(minimum.next);
            }
        }
        return result.next;
    }
}
