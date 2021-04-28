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

//Approach - implment merging 2 list and perform iteratively for all elements in list
// Space Complexity - O(1) - no additional space expect for result
// Time Complexity - O(N log k) - k - number of linked lists - log k (comparision of elements and popping them)
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {

    ListNode dummy = new ListNode(Integer.MIN_VALUE);

    for(ListNode list: lists){
      dummy = merge(dummy, list);
    }
    return dummy.next;
  }

  public ListNode merge(ListNode l1, ListNode l2){

    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    ListNode temp = dummy;

    while(l1 != null && l2 != null){
      if(l1.val < l2.val){
        temp.next = l1;
        l1 = l1.next;
      }
      else{
        temp.next = l2;
        l2 = l2.next;
      }
      temp = temp.next;
    }
    if(l1 != null){
      temp.next = l1;
    }
    if(l2 != null){
      temp.next = l2;
    }
    return dummy.next;
  }

}

// Approach PriorityQueue - add all the ListNode elements from all the lists from array to PriorityQueue
// from the PQ, poll the elements and create the result linked list
// Space Complexity - O(N) - space for PriorityQueue - size of all lists in lists array
// Time Complexity - O(N log k) - k - number of linked lists - log k (comparision of elements and popping them)

// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {

//         if(lists == null || lists.length == 0 ) return null;


//         PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);

//         for(ListNode listHead: lists){
//             if(listHead != null){
//                 heap.add(listHead);
//             }
//         }

//         ListNode head = new ListNode(-100);
//         ListNode temp = head;

//         while (!heap.isEmpty()){
//             temp.next=heap.poll();
//             temp=temp.next;

//             if (temp.next!=null)
//                 heap.add(temp.next);
//         }
//         return head.next;
//     }
// }
