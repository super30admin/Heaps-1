import java.util.Comparator;
import java.util.PriorityQueue;
//time complexity   Nlogk k- number of lists and N  is the total number of nodes.
//space= 0(n) o(k)
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head=new ListNode(0); //to be returned
        ListNode point=head;// its a pointer to work on diffternt nodes

      //comparator is used to arrange the nodes in the heap in ascending order
        PriorityQueue<ListNode> minHeap=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) {
                    return 1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return -1;
                }
            }
        }
        );

        //all the lists(linkedLists) are put in the PriorityQueue
        for(ListNode list:lists){
            if(list!=null){
                minHeap.add(list);
            }
        }
       //when polling we get the node that have the min value
        // and add it to the pointer node and add next element to the pq.
        while(!minHeap.isEmpty()){
            point.next=minHeap.poll();
            point=point.next;
            if(point.next != null){
                minHeap.add(point.next);
            }
        }

        return head.next;
    }


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

}
