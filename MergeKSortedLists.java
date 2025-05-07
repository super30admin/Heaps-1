import java.util.PriorityQueue;
//TC : O(n log k)
//SC : O(k)

/*
The algorithm uses a min-heap to efficiently merge k sorted linked lists.
First, it inserts the head node of each non-empty list into the priority queue.
Then, it repeatedly extracts the smallest node from the heap and appends it to the result list.
After each extraction, if the removed node has a next node, that next node is added to the heap.
This process continues until all nodes are processed, producing a single sorted merged list.
The min-heap ensures we always select the next smallest element efficiently.
* */
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a, b)->a.val - b.val);

        for(ListNode node:lists)
        {
            if(node!=null)
                pq.add(node);
        }
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(!pq.isEmpty())
        {
            ListNode temp=pq.poll();
            curr.next=temp;
            curr=curr.next;
            if(temp.next!=null)
                pq.add(temp.next);
        }


        return dummy.next;

    }
}