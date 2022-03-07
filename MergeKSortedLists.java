import java.util.PriorityQueue;
/*
Time Complexity: O(Nlogk) here k is the number of linked lists given and N is the total number of nodes once those
elements got merged
Space Complexity: O(n), n is the size of the priority queue

Run on leetcode: yes

Approach:
1. Using priority queue to add all the elements from the array of ListNode in the ascending order,
2. Once all the elements added in the priority queue extract them and creating a sortedList by popping elements
from the priority queue
3. Return the sortedList
 */
public class MergeKSortedLists {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode mergeSortedLists(ListNode[] lists){

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(ListNode list: lists) {
            ListNode curr = list;
            while (curr != null) {
                pq.add(curr.val);
                curr = curr.next;
            }
        }

        if(pq.isEmpty()){
           return null;
        }

        ListNode sortedList = new ListNode(pq.poll());
        ListNode temp = sortedList;
        while(!pq.isEmpty()){
            temp.next = new ListNode(pq.poll());
            temp = temp.next;
        }

        return sortedList;
    }

    public static void main(String[] args){
        ListNode head1 = new ListNode(1);
        ListNode first1 = new ListNode(4);
        ListNode second1 = new ListNode(5);
        head1.next = first1;
        first1.next = second1;
        second1.next = null;
        ListNode head2 = new ListNode(1);
        ListNode first2 = new ListNode(3);
        ListNode second2 = new ListNode(4);
        head2.next = first2;
        first2.next = second2;
        second2.next = null;
        ListNode head3 = new ListNode(2);
        ListNode first3 = new ListNode(6);
        head3.next = first3;
        first3.next = null;

        ListNode[] lists = {head1,head2,head3};
        ListNode result = mergeSortedLists(lists);
        while(result!= null){
            System.out.print(result.val+",\t");
            result = result.next;
        }

    }
}
