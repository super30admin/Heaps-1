import java.util.PriorityQueue;

public class MergeKSortedListsHeap {


        public ListNode mergeKLists(ListNode[] lists) {

            // pq (heap) of list node values
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

            // add head nodes of all lists to heap
            for(ListNode Head: lists) {

                if(Head != null) pq.add(Head);
            }

            // for adding the first (smallest) list node
            ListNode dummy = new ListNode(-1);

            // to move current pointer of result list
            ListNode curr = dummy;

            // as long as priority queue is not empty
            while(!pq.isEmpty()) {

                // get minimum of k size heap
                ListNode min = pq.poll();

                // add this minimum to current pointer of result list
                curr.next = min;

                // move current pointer further (recently added minimum)
                curr = curr.next;

                // if minimum has a next list node in its list, add it to heap
                if(min.next != null) pq.add(min.next);
            }
            // result starts after dummy pointer
            return dummy.next;
        }



}

/*
TIME COMPLEXITY = O(nklogk)

heap of size - k
size of each list - n

SPACE COMPLEXITY = O(k)

O(n) space - for a new linked list
*/