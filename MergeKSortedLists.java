// Time Complexity - O(nklogk) -- n is average length of the each list and k is the total number of lists
// Space Complexity - O(k) -- as we maintain a heap i.e. priority queue of size k
// Approach - we add all the list heads into the heap and every point of time we poll out the min head amongst those and use that head to go to next element in that particular list
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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode result = new ListNode(-1);
        ListNode dummy = result;
        for(ListNode node:lists){ // this makes a queue of size k i.e. size of input i.e.lists.size()
            if(node!=null){
                pq.add(node);
            }
            
        }
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll(); // the minNode will be at the top as it is a min heap
            dummy.next = minNode;
            dummy = dummy.next;
            if(minNode.next!=null){
                pq.add(minNode.next);
            }

        }
        return result.next;
    }
}