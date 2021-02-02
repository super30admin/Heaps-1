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
mthod 1: brute force of merging lists and then sorting . nklognk time complexity 

method 2: can use min heap to merger the lists.
first,add head nodes of all lists to the heap. Then poll one by one and add the next node of polled node to the heap. 
Append the poll node to the result list.
Time complexity: O(n*k log k) -> O(N log k)

method 3: merge 2 lists at a time 
time complexity: O(Nk^2)

*/
class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)return null;
        
        
        //method 2 - using min heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        //ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode temp = result;
        
//         for(ListNode li : lists){
//             if(li != null){
//                 ListNode head = li;
//                 pq.add(head);
//             }
           
//         }
        
//         while(!pq.isEmpty()){
//             ListNode minNode = pq.poll();
//             if(minNode.next != null){
//                  pq.add(minNode.next);
//             }
           
//             result.next = minNode;
//             result = result.next;
            
//         }
//         return temp.next;
        
        
    }
}