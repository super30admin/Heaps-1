 //Heap: Best
 //TC = Nlogk = nklogk, where N = n*k, where n is the max number of nodes and k is the max number of lists
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        for(ListNode head: lists){
            if(head != null){
                pq.add(head);
            }
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next=min;
            if(min.next != null){
                pq.add(min.next);
            }
            curr = curr.next;
        }
        return result.next;
    }
}

// //Intermediate is using Lists. Merging two lists and then merge it with third list.
// // TC = n*k^2
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//        ListNode merged = new ListNode(Integer.MIN_VALUE);
//         for(ListNode head: lists){ //k
//             if(head != null){
//                 merged = merge(merged, head);
//             }
//         }
//         return merged.next;
//     }
//     private ListNode merge(ListNode l1, ListNode l2){
//         ListNode dummy = new ListNode(-1);
//         ListNode curr = dummy;
//         ListNode p1 = l1;
//         ListNode p2 = l2;
//         while(p1!=null && p2!=null){
//             if(p1.val < p2.val){
//                 curr.next = p1;
//                 p1 = p1.next;
//             } else {
//                 curr.next = p2;
//                 p2 = p2.next;
//             }
//             curr = curr.next;
//         }
//         if(p1 == null){
//             curr.next = p2;
//         }
//         if(p2 == null){
//             curr.next = p1;
//         }
//         return dummy.next;
//     }
// }

//Brute force: Put everything in an array, sort the array, put everything into list
//TC = NlogN = (nk log nk)