// Time Complexity : O(n*log(k)) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Using MinHeap
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode head = null;
        ListNode tail = null;
        
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<lists.length; i++){
            ListNode ln = lists[i];
            while(ln!= null){
                pq.add(ln.val);
                ln = ln.next;
            }
        }
        
        while(!pq.isEmpty()){
            int val = pq.poll();
            ListNode ln = new ListNode(val);
            if(head == null && tail==null){
                head = ln;
                tail = ln;
            }else{
                tail.next = ln;
                tail = ln;
            }
        }
        return head;
        
    }
}
