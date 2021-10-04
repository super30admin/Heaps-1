
import java.util.*;
// time complexity : nlogk
// space complexity : k
// did it run on leetcode : yes
// any doubt : no 
//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class Heaps{
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
       for(int i: nums){
           minHeap.add(i);
           if(minHeap.size()>k){
               minHeap.remove();
           }
       }
       return minHeap.remove();
    }

    // time complexity : n*mlogm*n
    // space complexity : mn
    // did it run on leetcode : yes
    // any doubt : no 
    //https://leetcode.com/problems/merge-k-sorted-lists/submissions/
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(ListNode list : lists){
            
            while(list != null){
                
                minheap.add(list.val);
                list = list.next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while(!minheap.isEmpty()){
            head.next = new ListNode(minheap.remove());
            head = head.next;
        }
        return dummy.next;
    }
}