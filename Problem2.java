// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Time Complexity : O(Nlog N) --> sorting result array. N - totl number of nodes in all linked lists.
// Space Complexity :O(N) -->storing all the nodes
// Your code here along with comments explaining your approach:
// 1. Store each element in each linked list into an array.
// 2. Sort the array create a linked list of all the elements in the array and return the starting node.
class Solution {
    public class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        List<Integer> list = new ArrayList<>();
        for(ListNode current:lists){
            while(current!=null){
                list.add(current.val);
                current = current.next;
            }
        }
        int[] arr = new int[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        ListNode dummy = head;
        for(int i = 0;i<arr.length;i++){
            dummy.next = new ListNode(arr[i]);
            dummy = dummy.next;
        }
        return head.next;
    }
}
