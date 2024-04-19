//Time complexity O(nlog(K)) and space complexity O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num: nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }

        return pq.poll();
        
    }
}

//Time complexity nlog(k) and space complexity O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

          if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
       


        for(ListNode head:lists){
            if(head!=null){
                pq.add(head);
            }
        }

         ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;
            if(minNode.next!=null){
                pq.add(minNode.next);
            }
           
        }

        return dummy.next;
    }
}
