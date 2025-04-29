// Time Complexity : O(n*mlog(n*m))
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for(ListNode head:lists){
            while(head!=null){
                minHeap.add(head.val);
                head=head.next;
            }
        }

        ListNode dummy=new ListNode(-1);

        ListNode head=dummy;

        while(!minHeap.isEmpty()){
            head.next=new ListNode(minHeap.remove());
            head=head.next;
        }
        return dummy.next;
    }
}
