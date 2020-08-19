class Solution {
    public int findKthLargest(int[] nums, int k) {
        //creating max heap
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b) -> b-a);
        //building heap
        for(int i: nums)
            pq.add(i);
        
        //getting kth element from the top. pop 1st k-1 elements
        while(!pq.isEmpty() && k > 1){
            pq.remove();
            k--;
        }
        //removing kth element
        return pq.remove();
    }
}
