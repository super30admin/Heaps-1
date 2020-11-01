class Solution {// Time of  N log k  and space of O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        //Base case 
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((t1,t2) -> t1.val - t2.val);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        //Add first k headers
        for(ListNode node:lists){
            if(node != null){
                queue.add(node);
            }
        }
        while(!queue.isEmpty()){
            curr.next = queue.poll(); // Root of Heap : Min Node
            curr = curr.next;
            if(curr.next!= null){
                queue.add(curr.next) ;
            }
        }
        return dummy.next ;
    }
}