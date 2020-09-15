// Time Complexity - O(nk)
// Space Complexity - O(nk)
// This solution worked on LeetCode

// Brute Force 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        ListNode res = merged;
        for(int i=0;i<lists.length;i++){
            merged = merge(merged,lists[i]);   
        }
        return res.next;
        
    }
    
    ListNode merge(ListNode list1, ListNode list2){
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode dummy = result;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                result.next = list1;
                list1 = list1.next;
            }
            else{
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }
        if(list1 != null) result.next= list1;
        else if(list2 != null)  result.next = list2;
        return dummy.next;
    }
}

// Time Complexity - O(nk) where n is the average length of the lists and k is the number of lists since we are traversing through each of the lists
// Space Complexity - O(k) the heap function worst case will use the queue of size k
// This solution worked on LeetCode
// Optimal Heap Solution

// The head nodes of all the lists will first be added to the min heap. The min heap always holds the min value at its top as per the comparator that we have declared. We would be polling the top node and adding it to the result list and keep adding the next node as it is removed. We keep traversing until the queue becomes empty that is all the nodes of the lists are processed. We use the dummy which will point to the start of the result. Since as we keep adding to the result we will loose the starting node of the result.

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge Case
        if(lists == null || lists.length ==0)   return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode dummy = result;
        for(ListNode head : lists){
            if(head != null)
                pq.add(head);
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            result.next = min;
            if(min.next != null)
                pq.add(min.next);
            result = result.next;
        }
        return dummy.next; 
    }
}
