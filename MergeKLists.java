// Time Complexity : The time complexity is O(nlogk) where n is total number of nodes in all k list of nodes
// Space Complexity : The space complexity is O(n) where n is the total number of nodes in all k list of nodes.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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

        return partition(lists,0,lists.length-1);

    }

    // Divide the lists into half and start merging each of them.
    public ListNode partition(ListNode[] lists,int start,int end){

        if(start == end){
            return lists[start];
        }

        while(start < end){

            int mid = (end-start)/2 + start;

            // Left half
            ListNode l1 = partition(lists,start,mid);
            //Right half
            ListNode l2 = partition(lists,mid+1,end);
            // Merging left and right halfs
            return merge(l1,l2);

        }

        return null;
    }

    // Merge 2 lists together by comparing each of its nodes.
    public ListNode merge(ListNode l1,ListNode l2){

        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        if(l1.val <= l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }
        else{
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}