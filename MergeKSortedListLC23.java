//Time Complexity: n*log(k)       k = lists.size, k = total elements in all the linkedlists
//Space Complexity: k



// Time Complexity: n*k*log(k)       n = lists.size, k = average elements in linked list
// Space Complexity: log(n)

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

        Queue<ListNode> queue = new PriorityQueue<>( (a, b) -> a.val - b.val);              //creating a minHeap
        ListNode result = new ListNode();                            //to store the result, we are creating a dummy pointer
        ListNode current = result;                                  //create a current pointer which helps us to add the nodes

        for(ListNode node : lists){                             //iterate through list
            if(node != null){                                   //check if node's not null then add it to the queue
                queue.add(node);
            }
        }

        while(!queue.isEmpty()){                            //iterate till queue is empty

            ListNode min = queue.poll();                    //poll the element which is minimum

            if(min.next != null){                           //check if that node's next is not null, then add it into the queue
                queue.add(min.next);
            }
            current.next = min;                             //add the polled node into current's next pointer and move current to the next element
            current = current.next;
        }
        return result.next;                                 //return the result.next
    }




    //Time Complexity: n*k       k = lists.size, n = total element in all the linkedlists
    //Space Complexity: log(n)

//      public ListNode mergeKLists(ListNode[] lists) {

//          ListNode mergedList = new ListNode(Integer.MIN_VALUE);

//          for(ListNode li: lists){

//              mergedList = merge(li, mergedList);

//          }
//          return mergedList.next;

//      }

//     private ListNode merge(ListNode l1, ListNode l2){

//         ListNode result = new ListNode(-1);
//         ListNode current = result;

//         while(l1!= null && l2!= null){

//             if(l1.val < l2.val){
//                 current.next = l1;
//                 l1 = l1.next;
//             }
//             else{
//                 current.next = l2;
//                 l2 = l2.next;
//             }
//             current = current.next;
//         }

//         if(l1!= null){
//             current.next = l1;
//         }
//         if(l2 != null){
//             current.next = l2;
//         }

//         return result.next;

//     }


}



public class MergeKSortedListLC23 {
}
