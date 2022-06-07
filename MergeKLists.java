// Time Complexity:O(n*mlog(n*m))

// Space Complexity:O(n*m)

where n is the max number of nodes and m is the max number of lists.

class Solution {

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
