// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Solved after class


// Your code here along with comments explaining your approach
//use minHeap and comparator with natural oredering.
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        //base checks
        if(lists == null || lists.length == 0) return null;
        
        //Custom comparator
        Comparator<ListNode> customComparator = new Comparator<>(){
            
            //natural ordering
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        };
        
        //initialize Priority queue
        PriorityQueue<ListNode> minHeap = new PriorityQueue(customComparator);
        
        //insert to minHeap
        for(ListNode headNode: lists){
            if(headNode != null) minHeap.add(headNode);
        }
        
        //initialize list to store results
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        
        while(!minHeap.isEmpty()){
            ListNode minNode = minHeap.poll();
            dummy.next = minNode;
            dummy = minNode;
            if(minNode.next != null){
                minHeap.add(minNode.next);
            }
        }
        
        return result.next;
    }
}