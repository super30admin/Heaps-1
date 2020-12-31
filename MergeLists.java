/** Merge all the linked-lists into one sorted linked-list and return it.
* TC O(nk log k) SC O(k) because there are never more than k elements in the heap
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode dummy = new ListNode(-1);
        
        if (lists == null)
            return null;
        ListNode result = dummy;
        PriorityQueue<ListNode> q = new PriorityQueue<>(new ListComp());
        for (ListNode list : lists){
            if (list !=null){
                 q.add(list);   
            }
        }
        while(!q.isEmpty()) {
            ListNode pop = q.poll();
            dummy.next = pop;
            dummy = dummy.next;
            if (pop.next != null) {
                 q.add(pop.next); 
            }
        }
        return result.next;
    }
    
    class ListComp implements Comparator<ListNode>{ 
        public int compare(ListNode l1, ListNode l2) { 
            if (l1.val > l2.val) 
                return 1; 
            else if (l1.val < l2.val) 
                return -1; 
            return 0; 
        } 
    } 
}
