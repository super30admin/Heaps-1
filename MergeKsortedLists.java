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

//Space : O(number of total elements in all the linked lists) this is to set up priority queue
//Time : O(n) : for iterating through all the elements to insert them into pq + O(nlog(n)) for priority queue polling;


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0){
            return null;
        }

        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        for(int i=0;i<lists.length;i++){
            ListNode head=lists[i];
            while(head!=null){
                pQueue.add(head.val);
                head=head.next;
            }
        }
        if(pQueue.size()==0){
            return null;
        }

        ListNode head=new ListNode(pQueue.poll());
        ListNode temp=head;
        int size=pQueue.size();
        while(size>0){

            temp.next=new ListNode(pQueue.poll());
            temp=temp.next;




            size=size-1;
        }
        return head;


    }
}