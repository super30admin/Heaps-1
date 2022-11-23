package s30.heaps;

import s30.linkedList.ListNode;

import java.util.PriorityQueue;

//Algo:  pointer approach.  compare current indices of k lists. and then add the minIndex to final list;
//TC: O(Nk) where N is number of nodes in the final list
// SC: O(1)

//ALgo: using heaps to optimize the above approach. instead of checking the indices of k lists add them to heap an remove
//TC: O(Nlogk) where k is number of lists
//SC: O(k) for storing k nodes into the heap.
public class MergeKSortedLists {

    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummyHead = new ListNode();

        ListNode curr = dummyHead;



        for(int i =0; i < lists.length; i++){

            if(lists[i]!=null) pq.add(lists[i]);
        }


        while(!pq.isEmpty()){
            curr.next = pq.poll();
            curr = curr.next;
            if(curr.next != null) pq.add(curr.next);

        }

        return dummyHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummyHead = new ListNode();

        ListNode curr = dummyHead;

        while(true){

            int minIndex = -1;

            for(int i =0; i < lists.length; i++){
                if( lists[i] != null &&

                        (minIndex == -1 || lists[minIndex].val > lists[i].val)){
                    minIndex = i;
                }
            }


            if(minIndex == -1 ) break;
            curr.next = lists[minIndex];
            curr = curr.next;
            lists[minIndex] = lists[minIndex].next;

        }

        return dummyHead.next;
    }
    public static void main(String[] args) {

    }
}
