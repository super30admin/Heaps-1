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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode head : lists){
            if(head != null){
               pq.add(head);
            }
            
            
        }

        ListNode result = new ListNode(-1);
            ListNode curr = result;

            while(!pq.isEmpty()){
              ListNode min = pq.poll();
               curr.next = min;
               curr = curr.next;
               if(min.next != null){
                   pq.add(min.next);
               }
            }
            return result.next;
    }
}

/*
TC : O(n log k)

In Bruteforce, put all the numbers in arraylist and sort them. TC : O(N logN)

In another approach, if there are two lists we can merge using 2 pointers.O(nk) How can we merge 3 lists together? → by maintaining 3 pointers in Heap.

Putting 3 nodes inside the heap and moving the pointer of smallest among 3 nodes.

TC : O(N log K)



 */