package Nov26;

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
class MergeKSortedLists {
    
    /*
        Time Complexity: O(nk log k) because we are processing total n number of nodes and time complexity for priority queue is k log k where k is the size of priority queue.
    
    Space Complexity: O(k) because we are using extra space of a priority queue of k size.
    
    Approach:
    Min heap used .
    
    */
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        // create a dummy node to hold result list
        ListNode res = new ListNode(-1);
        
        // edge
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Initialising a min heap for custom object ListNode, so comparator logic needs to be provided
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        // populate the head node of all the k linked lists in priority queue so priority queue at size at any time will be k, i.e. one node of each list in priority queue at a time 
        for (ListNode cur: lists) {
            if (cur != null) {
                pq.add(cur);
            }
        }
        
        // another node used to point to dummy node initially.
        // it will be used to iterate through the resultant linked list as it is constructed.
        ListNode polled = res;
        
        // Till queue is not empty, keep popping an element(node) from the min heap and connect it to result list using next pointer property of linked list. 
        // Also check if the polled element has a non-null next node, then add the next node to Priority Queue for processing in future while loop iterations.
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            polled.next = temp;
            polled = temp;
            if (temp.next != null) {
                pq.add(temp.next);
            }
        }
        
        return res.next;
        
    }
}
