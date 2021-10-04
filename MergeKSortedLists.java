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
class MergeKSortedLists {
    
    // Time Complexity: O(nlogk)    (where n -> no. of nodes in the linked list, k -> no. of lists)
    // Space Complexity: O(k)   
    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new pqComp());
        
        for(ListNode list : lists){
            if(list != null)
                minHeap.add(list);
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while(!minHeap.isEmpty()){
            ListNode top = minHeap.remove();
            
            if(top.next != null)
                minHeap.add(top.next);
            
            curr.next = top;
            curr = top;
        }
        
        return dummy.next;
    }
    
    public class pqComp implements Comparator<ListNode> {
        public int compare(ListNode l1, ListNode l2){
            if(l1.val > l2.val)
                return 1;
            else if(l1.val < l2.val)
                return -1;
            return 0;
        }
    }
}