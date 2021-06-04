// Time Complexity : O(nk)
//          - Assuming n is the average length of the each list.
//          - k is the number of lists that we need to merge.
// Space Complexity : O(k) At max we store k elements in the heap.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class MergeKSortedLists {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        
        // base case for input
        if(lists == null || lists.length == 0) return null;
        
        ListNode dummy = new ListNode(-1);
        ListNode headPrev = dummy;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the head of linked lists to the min heap.
        for(ListNode list: lists){
            if(list != null){
                pq.add(list);
            }
        }
        
        // While the min heap is not empty pick one element from the heap and add it to the resulting LinkedList.
        // At max the size of the heap will be k elements where k is the length of the input lists.
        while(!pq.isEmpty()){
            ListNode top = pq.remove();
            if(top.next != null) pq.add(top.next);
            dummy.next = top;
            dummy = dummy.next;
        }
        
        return headPrev.next;
    }

}
