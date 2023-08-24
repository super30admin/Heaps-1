import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Time Complexity : O(n*k * log(k)) where k is the length of the lists array and n is the avg length of each list
// Space Complexity :O(k) where k is the length of the lists array
// Did this code successfully run on Leetcode :yes
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length < 1){
            return null;
        }

        ListNode mergedHead = new ListNode(-9999); //dummy node
        ListNode current = mergedHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode head: lists){
            if(head != null){
                pq.add(head);
            }
        }

        while(!pq.isEmpty()){
            ListNode top = pq.poll();
            current.next = top;
            current = current.next;

            if(top.next != null){
                pq.add(top.next);
            }
        }
        return mergedHead.next;
    }
}
