// Time Complexity : O(N*log k) where k is the numbers of lists and N is the total number of lists and total number of elements (N = n*k)
// Space Complexity : O(k) where k is the numbers of lists
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val); //Initiate the min heap and as it's initialized with listnode, the comparator indicates to sort the heap in ascending order
        for (ListNode li : lists) { //Iterate over the lists
            if (li != null) { //As long as the head of that li is not null, add the head of the list to the heap
                pq.add(li);
            }
        }

        ListNode result = new ListNode(-1); //Initialize the result and point to the dummy
        ListNode curr = result; //Initialize the curr pointer to point to the result
        ListNode currMin; //Initialize currMin to point the min value in the heap which is at the top of the min heap

        while (!pq.isEmpty()) { //As long the heap is not empty
            currMin = pq.poll(); //Remove the top of the heap and store it in currMin
            curr.next = currMin; //Add the currMin to the result to the next of curr
            curr = curr.next; //Point the curr to curr.next(currMin)
            if (currMin.next != null) { //If the just added head has a next elem in the list
                pq.add(currMin.next); //Then add that elem to the heap
            }
        }

        return result.next; //Return the head of the result
    }
}