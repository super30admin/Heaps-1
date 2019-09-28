//Time Complexity:O(n*mlog(n*m))
//Space Complexity:O(n*m)
//where n is the max number of nodes and m is the max number of lists.
//In this problem , I'll be adding all the k lists to the priority queue and simply construct a new final list by removing elements from the priority queue. This list will be the merged sorted list.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(ListNode head:lists){
            while(head!=null){
                minHeap.add(head.val);
                head=head.next;
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode head=dummy;
        while(!minHeap.isEmpty()){
            head.next=new ListNode(minHeap.remove());
            head=head.next;
        }
        return dummy.next;
    }
}