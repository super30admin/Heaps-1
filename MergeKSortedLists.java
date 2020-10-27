//TC: O(N log N), N is total number of ListNodes
//SC: O(1)
//Difficulty: No
//Approach: Used Min Heap to store all ListNode values, popped nodes and updated .next values
 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> (n1.val - n2.val));
        
        for(ListNode n : lists){
            ListNode cur = n;
            while(cur!=null){
                pq.offer(cur);
                cur = cur.next;
            }
        }
        
        ListNode head = pq.poll();
        ListNode cur = head;
        
        while(!pq.isEmpty()){
            cur.next = pq.poll();
            cur = cur.next;
        }
        
        if(cur!=null) cur.next = null;
        
        return head;
    }
}