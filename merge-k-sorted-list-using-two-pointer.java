class Solution {
    // Merging two list solution
    // Time complexity is O(k*kn) since it will n, 2n, 3n, 4n ... kn elements to iterate for merging
    // Space complexity is O(1)
    // This solution is submitted on leetcode with zero errors
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case
        if(lists == null || lists.length == 0)
            return null;
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for(ListNode li: lists){
            if(li!=null)
                merged = merge(merged,li);
        }
        return merged.next;
    }
    
    public ListNode merge(ListNode nodeA, ListNode nodeB){
        ListNode result =  new ListNode(-1);
        ListNode curr = result;
        while(nodeA!=null && nodeB!=null){
            if(nodeA.val< nodeB.val){
                curr.next = nodeA;
                nodeA = nodeA.next;
            } else {
                curr.next = nodeB;
                nodeB = nodeB.next;
            }
            curr = curr.next;
        }
        if(nodeA!=null) curr.next = nodeA;
        if(nodeB!=null) curr.next = nodeB;
        return result.next;
    }
}