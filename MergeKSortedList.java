/*
TC: O(N * logK) + O(N * logK) insert + removal from heap.
SC: O(K) K - number of lists

1. The reference to the lists are added to priority queue.
2. Comparator is defined which stores node values in priority queue.
3. Elements are removed from top of the queue, and the next element is added to queue.
4. The removed element is added to result list and returned.


*/

import java.util.*;

public class MergeKSortedList {
    
    public static ListNode mergeList(ListNode[] lists){
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode list : lists){
            if(list != null){
                pq.add(list);
            }
        }

        while(!pq.isEmpty()){

            ListNode top = pq.remove();

            if(top.next != null)
                pq.add(top.next);
            
            cur.next = new ListNode(top.val);
            cur = cur.next;
        }
        return head.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
      
        ListNode[] array = new ListNode[]{l1,l2,l3};

        ListNode res = mergeList(array);

        while(res != null){
            System.out.print(res.val+">");
            res = res.next;
        }
    }
}

class ListNode{

    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
    }
}
