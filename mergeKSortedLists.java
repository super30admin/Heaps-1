//time complexity: O(nklogn) where k is the number of linkedlists and n is the average length of each linked list
//space complexity : O(total nodes in all linked lists)
//executed on leetcode: yes
//approach : we iterate over each list and keep on adding node.val into the min heap
//next we start polling elements from min heap until the minheap is empty
//we add each popped element to a linked list

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
/**
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(ListNode head: lists)
        {
            while(head!=null)
            {
                minheap.add(head.val);
                System.out.println(head.val);
                head=head.next;
            }
        }
        ListNode dummyhead = new ListNode(-1);
        ListNode head = dummyhead;
        while(!minheap.isEmpty())
        {
            head.next = new ListNode(minheap.poll());
            head = head.next;
        }
        return dummyhead.next;
    }
}
**/
//time complexity: O(nklogk) here we are taking a priority queue whose size is equal to the number of linked lists , even during the implementation of the while loop.
//n is the avg length of the linked lists, k is the number of linked lists
//space complexity: O(k) ; at any time, we will have a max of k number of nodes in the minheap.
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a,b)->a.val-b.val); //we will make min heap based on node values
        for(ListNode head: lists)
        {   if(head!=null) minheap.add(head); //checking this condition as in a case where third list can be null
        }
        ListNode dummyhead= new ListNode(-1);
        ListNode head = dummyhead;
        while(!minheap.isEmpty())
        {
            ListNode min = minheap.poll();
            head.next = min;
            head = head.next;
            if(min.next!=null) minheap.add(min.next);
        }
        return dummyhead.next;
    }
}

