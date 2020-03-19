// Time Complexity :O(nlogK)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length==0) return null;

        Comparator<ListNode> customComparator = new Comparator<>(){
            public int compare(ListNode a , ListNode b){
                return a.val-b.val;
            }
        };

        PriorityQueue<ListNode> minHeap = new PriorityQueue(customComparator);


        for(ListNode nodes: lists){
            if(nodes!=null){
                minHeap.add(nodes);
            }
        }

        ListNode result = new ListNode(0);
        ListNode cursor = result;
        while(!minHeap.isEmpty()){
            ListNode minNode = minHeap.poll();
            cursor.next = minNode;
            cursor = minNode;
            if(minNode.next!=null){
                minHeap.add(minNode.next);
            }
        }




        return result.next;
    }
}