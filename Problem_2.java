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

// Time Complexity : O(n*k*k)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// in itterative check each value of the list and store it as per the accending order
// Your code here along with comments explaining your approach
// itterative method - t:
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode main = new ListNode(Integer.MIN_VALUE);
        for(ListNode l: lists){
            main = merged(main, l);
        }
        return main.next;
    }
    private ListNode merged(ListNode p1, ListNode p2){
        ListNode main = new ListNode(-1);
        ListNode curr = main;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                curr.next = p1;
                p1 = p1.next;
            }else{
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        if(p1 != null){
            curr.next = p1;
        }
        if(p2 !=null){
            curr.next = p2;
        }
        return main.next;
    }
}

// Time Complexity : O(nk*log(k))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Use the min heap to give the min node- first store first node from each string and then pop from each heap, and store it to result list, and add the next of poped node to the proioity queue, to get in an order.
// Your code here along with comments explaining your approach
// // Using Min Heap - PriorityQueue
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
//         ListNode result = new ListNode(-1);
//         ListNode curr = result;
//         for(ListNode node : lists){
//             if(node != null){
//                 pq.add(node);
//             }
//         }
//         while(!pq.isEmpty()){
//             ListNode node = pq.poll();
//             curr.next = node;
//             curr = curr.next;
//             node = node.next;
//             if(node != null){
//                 pq.add(node);
//             }
//         }
//         return result.next;
//     }
// }