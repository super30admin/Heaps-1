class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int result = Integer.MAX_VALUE;
        for(int num : nums){
            pq.add(num);
            if(pq.size() > nums.length - k){
                result = Math.min(pq.poll(),result);
            }
        }
        return result;

    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node : lists){
            if(node != null ){
                pq.add(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            if(min.next != null){
                pq.add(min.next);
            }
            curr.next = min;
            curr = curr.next;
        }
        return dummy.next;
    }
}