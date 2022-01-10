//kth largest element
//tc n log k(min heap) / n log(n-k) (max heap)
//sc k for min heap and n-k for max heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int n = nums.length;
//         //min heap 
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         //size of pq will be maintained at k
//         for(int num : nums){
            
//             pq.add(num);
//             if(pq.size() > k) pq.poll();
//         }
//         return pq.peek();
        
        //max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b -a );
        
        int result = Integer.MAX_VALUE;
        //size of pq will be maintained at n-k
        
        for(int num : nums){
            
            pq.add(num);
            if(pq.size() > n-k){
                
                result = Math.min(result, pq.poll());
                
            }
        }
        
        return result;
    }
}

//merge k sorted linked lists
//tc nk log k (where n elements in each k list)
//sc k
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
// brute force can be add all elements in a single array and sort and print out the list
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        
        for(ListNode head : lists){
            if(head!=null)
                pq.add(head);
        }
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        
        while(!pq.isEmpty()){
            
            ListNode min = pq.poll();
            
            curr.next = min;
            curr = curr.next;
            
            if(min.next!=null)
                pq.add(min.next); 
        
        }
        
        return dummy.next;
            
        
    }
}
// merge 2 and their result to incoming lists k * kn = k sqaure n
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
        
//         ListNode merged = new ListNode(Integer.MIN_VALUE);
        
//         for(ListNode head : lists){
            
//             merged = merge(merged, head);
//         }
        
//         return merged.next;
        
//     }
    
//     private ListNode merge(ListNode head1, ListNode head2){
        
//         ListNode dummy = new ListNode(Integer.MIN_VALUE);
//         ListNode curr = dummy;
        
//         while(head1!=null && head2!=null){
            
//             if(head1.val<=head2.val){
                
//                 curr.next=head1;
//                 head1=head1.next;
                
//             }
//             else{
                
//                 curr.next=head2;
//                 head2=head2.next;
//             }
            
//             curr=curr.next;
//         }
        
//         if(head1 != null){
//             curr.next = head1;
//         }
        
//         if(head2 != null){
//             curr.next = head2;
//         }
//        return dummy.next; 
//     }
    
// }
