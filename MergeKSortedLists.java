/**Leetcode Question 23 - Merge K Sorted Lists */
/**Algorithm - Priority Queue
 * Add the heads of all the lists in the priority queue.
 * Make a dummy node that will move ahead with every added node and point the result to the head of the dummy node
 * While the priority queue is not empty,
 * Pop the element from the queue and increment the pointer in the original list. If there are more elements, add them to the queue
 * Return result.next because results head has the initialisation value of dummy
 */
/**TC - O(Nlogk) - N = total number of elements in all the lists
 * SC - O(logK)
 */
public class MergeKSortedLists {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            //ListNode result = new ListNode();
            if(lists.length ==0 || lists == null){
                return null;
            }
            ListNode dummy = new ListNode(0);
            ListNode result = dummy;
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));
            for(ListNode head: lists){
                if(head!=null){
                    pq.add(head);
                }
            }
            while(!pq.isEmpty()){
                ListNode min = pq.poll();
                dummy.next = min;
                if(min.next!=null){
                    pq.add(min.next);
                }
                dummy = dummy.next;
            }
            return result.next;
        }
    }
}
