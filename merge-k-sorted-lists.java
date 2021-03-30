// Time Complexity :
O(n*logk) n, is total number of linkedListnodes and the logK is for
heapify function to be performed on min heap of size k
// Space Complexity :
O(K) as we are storing k elements in the heap 
// Did this code successfully run on Leetcode :
Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


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
        //define a dummy node
        ListNode dummy = new ListNode(-1);
        
        //define a Min heap using priority Queue
        PriorityQueue<ListNode> pq = new PriorityQueue(new CompareFunction());
        
        for(ListNode l:lists){
            pq.add(l);
        }
        
        //Make the dummy as my current node
        ListNode current = dummy;
        while(!pq.isEmpty()){
            //Pop the top element which is min
            ListNode top = pq.remove();
            if(top.next != null){
                pq.add(top.next);
            }
            current.next = top;
            current = top;
        }
        
        return dummy.next;
        
        }
    //Comparator class that implements compare function to build my priority queue
    public class CompareFunction implements Comparator<ListNode>{
        public int compare(ListNode n1, ListNode n2){
            if(n1.val > n2.val){
                return 1;
            }
            else if(n1.val < n2.val){
                return -1;
            }
            else return 0;
        }
    }
    }
