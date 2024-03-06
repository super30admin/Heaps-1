//## Problem2

//Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

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
    //1. Brute force
    // Merge all lists into the first one, one-by-one
    // Time: O(k*kn) -> O(k^2 * n), where k-number of lists, n-avg size of each list
    // Space: O(1)
    private ListNode bruteForce(ListNode[] lists){
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        for(ListNode head: lists){// O(n + 2n + 3n + ..... kn) --> O(k^2 * n)
            dummy=merge(dummy, head);
        }
        return dummy.next;
    }
    // Merge two sorted linked lists 
    //Time: O(m+n), where m and n are sizes of the two lists respectively
    //Space:O(1)
    private ListNode merge(ListNode h1, ListNode h2){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;

        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                curr.next=h1;
                h1=h1.next;
            }else{
                curr.next=h2;
                h2=h2.next;
            }
            curr=curr.next;
        }

        if(h1!=null){
            curr.next=h1;
        }
        if(h2!=null){
            curr.next=h2;
        }

        return dummy.next;
    } 


    //2. Heap based solution
    // Maintain a min-heap of heads of k lists, get the min element, add next element of the list to heap
    // Time: O(nk log k), n-avg number of elements in each list, k - total number of lists
    // Space: O(k) for min heap 
    private ListNode minHeap(ListNode[] lists){
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        ListNode curr=dummy;

        // Add all the heads to heap -- O(k)
        for(ListNode head: lists){
            if(head!=null){
                pq.add(head);
            }
        }

        // Process the heap until empty
        while(!pq.isEmpty()){ // O(nk logk) -- processing each element of every list of size k, total n lists, in a heap of size k
            ListNode top=pq.poll(); 
            curr.next=top;
            curr=curr.next;

            // check if there is a next element in the list
            if(top.next!=null){
                pq.add(top.next);
            }
        }

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        //1. Brute force
        //return bruteForce(lists);

        //2. min-heap
        return minHeap(lists);
    }
}