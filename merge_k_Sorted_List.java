    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/merge-k-sorted-lists/
    Time Complexity for operators : o(nlogk) ..
    Extra Space Complexity for operators : o(k) ... to create heap.
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
s
        # Optimized approach same like basic approach:
                              
            Approach 1st:- 
                    A. Create a minheap of an element.
                    B. Once we are done with  creation of heap the interate thru each element.
                    D. And create new list of it and return it. This approach requires more time complexity.
                        the second approach is slight modification of it.

            Approach 2nd:- 
                    A. Create a minheap of an element.
                    B. Once we are done with  creation of heap the interate thru each element.
                    D. And create new list of it and return it
       */

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

 // 1st approach
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
        
        
//         // but below solutuion taker more time as we are storing all the elemtns from the list and then 
//         // creating list on the basis of heap
        
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
//         for(ListNode num : lists){
//             ListNode head = num;
//             while(head!=null){
//                 minHeap.add(head.val);
//                 head = head.next;
//             }
//         }
        
//         ListNode dummyhead = new ListNode(-1);
//         ListNode head = dummyhead;

//         while(!minHeap.isEmpty()){
//             int val = minHeap.remove();
//             head.next = new ListNode(val);
//             head = head.next;
//         }
        
//         return dummyhead.next;
//     }
// }

// 2nd approach

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new pqcomparator());
        
        for(ListNode num : lists){

            if(num!=null){
                minHeap.add(num);
            }
        }
        
        ListNode dummyhead = new ListNode(-1);
        ListNode head = dummyhead;

        while(!minHeap.isEmpty()){
            ListNode val = minHeap.remove();
            
            if(val.next!=null){
                minHeap.add(val.next);
            }
            head.next = val;
            head = head.next;
        }
        
        return dummyhead.next;
    }
}

class pqcomparator implements Comparator<ListNode>{
    public int compare(ListNode s1, ListNode s2){
        if(s1.val>s2.val)
            return 1;
        else if(s1.val <s2.val)
            return -1;
        return 0;
    }
}