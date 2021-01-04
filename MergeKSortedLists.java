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
Approach: Using heap

In this apporach what we are doing maintaing a min heap that will return us the min element everytime we need it.

At first we will add the heads of lists into the heap. Then we will poll the minimum element which would be present at the top of heap and add it to our resultant list. After that we will add the next element of the element which we just removed from the heap. 

In this manner we will keep removing the elements and add the next elements next to the removed elements into the heap. Thus we will continuosuly get the minimum element from the heap that instance.

Time complexity: O(nk log k)
Space complexity: O(k)

where n = no of elements in the given array
* check comments below for the complexity reasoning
*/


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null)
            return null;
            
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;
        
        for (ListNode head: lists){ //klogk
            if (head != null){
                pq.add(head);
            }
        }
        
        //From the comments below it is n x k x logk
        while (!pq.isEmpty()){ // We are doing this n x k times
            ListNode curr = pq.poll(); // This take logk time and we are doing this n x k times. 
            dummy.next = curr;
            if(curr.next != null){
                pq.add(curr.next); // This take logk time and we are doing this n x k times. 
            }
            dummy = dummy.next;
        }
        return result.next;
    }
}