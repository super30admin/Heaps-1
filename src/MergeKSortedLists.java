// Approaches:              merge & sort           two lists at a time           heap
// Time Complexity:        O(nk * log(kn))              O(n*k*k)             O(n*k*log(k))
// Space Complexity:            O(1)                      O(1)                   O(1)
// where n is number of elements in given array
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a, b) -> a.val - b.val
        );

        for(int i=0; i<lists.length; i++) {
            if(lists[i] != null) {                             // adding all first nodes in lists
                pq.add(lists[i]);
            }
        }

        while(!pq.isEmpty()) {
            ListNode min = pq.remove();                        // removing minimum node every time
            if(min.next != null) {                             // if it has next node present
                pq.add(min.next);                              // then add it in heap
            }
            tail.next = min;                                   // adding min in result
            tail = tail.next;
        }

        return dummyHead.next;
    }
}



// // ****************************** two lists at a time approach ******************************
//public class MergeKSortedLists {
//    public ListNode mergeKLists(ListNode[] lists) {
//
//        ListNode dummyHead = new ListNode();
//        ListNode tail = dummyHead;
//
//        while(true) {
//            ListNode min = null;
//            int index = -1;
//            for(int i=0; i<lists.length; i++) {
//                ListNode node = lists[i];                         // taking node from k lists one by one
//
//                if(node != null) {                                // if node is not null
//                    if(min == null || node.val < min.val) {       // and value is less than min
//                        index = i;
//                        min = node;
//                    }
//                }
//            }
//
//            if(min == null) {
//                break;
//            }
//
//            tail.next = min;                                      // updating result list
//            tail = tail.next;
//            lists[index] = lists[index].next;                     // updating given lists
//        }
//        return dummyHead.next;
//    }
//}