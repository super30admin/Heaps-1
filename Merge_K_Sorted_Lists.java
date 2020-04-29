// Time Complexity : O(nlog(k))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1,n2)->n1.val-n2.val);
        
        for(ListNode root: lists){
            if(root!=null){
                minHeap.add(root);
            }
        }
        
        ListNode resultHead = null, resultTail = null;
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            if(resultHead==null){
                resultHead=resultTail=node;
            }
            else{
                resultTail.next = node;
                resultTail = resultTail.next;
            }
            if(node.next!=null){
                minHeap.add(node.next);
            }
        }
        return resultHead;
    }
}