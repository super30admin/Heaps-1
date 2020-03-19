//TimeComplexity: O(Nlogk)

//SpaceComplexity: O(k)


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
        if(lists == null || lists.length == 0) 
        	return null;

        Comparator<ListNode> custom = new Comparator<>(){
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        };

        PriorityQueue<ListNode> minHeap = new PriorityQueue(custom);

        for(ListNode headNode: lists){
            if(headNode != null)minHeap.add(headNode);
        }

        ListNode result = new ListNode(0);
        ListNode cursor = result;

        while(!minHeap.isEmpty()){
            ListNode minNode = minHeap.poll();
            cursor.next = minNode;
            cursor = minNode;
            if(minNode.next != null)
            minHeap.add(minNode.next);
        }

        return result.next;
    }
}