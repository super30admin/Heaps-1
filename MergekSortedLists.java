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

/*
- Approach 1: Bruteforce 
- Add all the elements in the array, sort it and create a resultant list with the sorted elements
TC: O(nklognk) -> n elements per list * k lists
SC: O(nk) -> n elements * k lists for the temp array
- Approach 2: merge two list at a time in a sorted fashion
TC: 1-2-3-4 (4 lists to iterate)
    - 1 -> 2: 2n
    - 1->2->3: 2n + n = 3n
    - 1->2->3->4: 3n + n = 4n 
    -> n + 2n + 3n + 4n + ... + kn = n(1+2+3+4...+k) = n * k (k+1)/2 => nk^2
TC: O(Nk) -> N is n*k

*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode merged = dummy;
        for(ListNode list: lists){
            merged = merge(merged, list);
        }
        return dummy.next;
    }

    private ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
            }
            //common in both if and else
            curr = curr.next;
        }

        if(list1 != null)
            curr.next = list1;
        if(list2 != null)
            curr.next = list2;
        
        return dummy.next;
    }
}


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

 /*
 - Approach 3: Min heap approach
 - Firstly put first node of all the lists in the heap
 - Whenever we remove the smallest element out of the heap, add its next to the heap
 - That way we can ensured the smallest out of all is being merged in the list

 TC: O(nklogk) -> iterate through all the elements n in k lists * sort k elements at a time
 SC: O(k) -> k elements in the heap at a time
  */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //custom compartor for comparing listnode values
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode merged = dummy;

        for(ListNode list : lists){
            if(list != null)
                pq.add(list);
        }

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            merged.next = min;
            merged = merged.next;
            if(min.next != null)
                pq.add(min.next);
        }
        return dummy.next;
    }
}