//problem1
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
           for(int i=0;i<n;i++){
            pq.add(nums[i]);
            if(pq.size()>k) pq.poll();
           }
        return pq.peek();
    }
}
//problem2
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
        PriorityQueue<ListNode> q=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode list:lists){
            if(list!=null){
            q.add(list);
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(!q.isEmpty()){
        ListNode node=q.poll();
        curr.next=node;
        curr=curr.next;
        if(node.next!=null){
            q.add(node.next);
        }
    }
     return dummy.next;
}
}
