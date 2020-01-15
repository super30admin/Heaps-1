
complexity : nlogk logk for adding elements to heap
space : o(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i : nums){
            
            pq.add(i);
            if(pq.size() > k) pq.poll();
        }
        
        return pq.poll();
    }
}