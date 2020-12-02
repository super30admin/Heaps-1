/**
 * The time complexity in the worst case in O(n*logk) where k is the length of lists array and n is the sum of length of the all
 * linked lists.
 * The space complexity is O(k)
 *
 * The intuition here is to create a priority queue of length k and add all the first nodes of list to it. When we poll it we get the
 * least element, add it to the result list and add the next element to the priority queue. Continue the process till the queue is empty.
 *
 * Yes, the solution passed all the test cases in leet code.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new ListNodeComparator());
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                ListNode node = lists[i];
                pq.offer(node);
                lists[i] = node.next;
            }
        }

        ListNode dummy = new ListNode(-1); ListNode root = dummy;
        while(pq.size()>0){
            ListNode temp = pq.poll();
            if(temp.next!=null){
                pq.offer(temp.next);
            }
            dummy.next = temp;
            dummy = dummy.next;
        }

        return root.next;
    }
}

class ListNodeComparator implements Comparator<ListNode>{

    public int compare(ListNode l1, ListNode l2){

        if(l1.val<l2.val){
            return -1;
        }
        else if(l1.val>l2.val){
            return 1;
        }
        else{
            return 0;
        }
    }
}