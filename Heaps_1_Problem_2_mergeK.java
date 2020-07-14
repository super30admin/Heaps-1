//Time Complexity: nklogk (n*k = total number of nodes , k = total number of lists)
//Space Complexity: k (size of the priority queue)
//Runs successfully on leetcode
//No Problem


//Here we will be putting the head of all the lists in the priority queue
//After using head of a certain list, we will be putting the next element of that list into priority queue
//We will repeating until the priority queue is not empty

import java.util.PriorityQueue;

public class Heaps_1_Problem_2_mergeK {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        ListNode temp = new ListNode(-1);
        ListNode result = temp;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->Integer.compare(a.val,b.val));

        for(ListNode l : lists)
        {
            if(l!=null)
            {
                pq.add(l);
            }
        }

        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();
            temp.next = min;
            temp = temp.next;
            if(min.next!=null)
            {
                pq.add(min.next);
            }
        }

        return result.next;
    }
}
