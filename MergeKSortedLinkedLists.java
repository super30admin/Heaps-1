import java.util.PriorityQueue;

//Idea is to use heap to merge k sorted lists by loading all the first elements of list into heap.
//we poll the minimum element from heap and insert the next element into heap
//Time complexity: O(nlogk)
//space complexity: O(k)
public class MergeKSortedLinkedLists {
        public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        for(ListNode list: lists){
            if(list != null){
                pq.add(list);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }

        return dummy.next;
    }
}
