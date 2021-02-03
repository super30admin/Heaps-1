//Time Complexity: O(Nk log k) where N is the average length of the lists and k is the number of lists
//Space Complexity: O(k)

//Successfully runs on leetcode: 7 ms

//Approach: We are using min-heap based on the listnode values and keeping a track of only k elements(equal to number of
//lists) in the min-heap. We keep on adding the minimum node in the resultant list and add the next element of the list
//from where we got the minimum node to the heap. In this way, everytime, we will be adding one minimum node to the result
//and we get a sorted list after merging k lists.


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
        int k = lists.length;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head: lists)
        {
            if(head != null)
                pq.add(head);
        }
        
        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();
            if(min.next != null)
                pq.add(min.next);
            dummy.next = min;
            dummy = dummy.next;
        }
        return result.next;
    }
}
