/**
 * Time Complexity: O(n. log k)
 * Space complexity: O(k) - heap of size k
 * Idea:
 * 1. Push head nodes from k lists to heap
 * 2. Poll until heap is empty, add next of polled element to heap and insert the polled element into new result list. 
 * 
 * Leetcode: Yes
 */

import java.util.*;

public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
            new Comparator<ListNode>() {
                public int compare(ListNode a, ListNode b) 
                { 
                    return a.val - b.val; 
                } 
            });

        for(int i=0;i<lists.length;i++){
            if(lists[i] != null)
                heap.add(lists[i]);
        }

        ListNode resultHead = new ListNode(0);
        ListNode curr = resultHead;
        while(!heap.isEmpty()){
            
            ListNode poppedNode = heap.poll();
            curr.next = poppedNode;
            curr = curr.next;
           // ListNode nextNode = poppedNode.next;
            if(poppedNode.next != null)
                heap.add(poppedNode.next);            
        }
        return resultHead.next;
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("Merge K sroted lists");
    }
}