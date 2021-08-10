//Time complexity - O(m*n * log(m*n)) log for inserting into heap
//Space complexity - O(m*n)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ListNode res = new ListNode(-1);
        for(int i=0; i<lists.length; i++){
            ListNode curr = lists[i];
            while(curr != null){
                minHeap.add(curr.val);
                curr = curr.next;
            }
        }
        ListNode head = res;
        while(!minHeap.isEmpty()){
            head.next = new ListNode(minHeap.remove());
            head = head.next;
        }
        
       return res.next; 
        
    }
}
