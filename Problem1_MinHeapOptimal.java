/**
LeetCode Submitted : YES
Space Complexity : O(Nums.length)
Time Complexity : O(nlogk)

The idea is to use min/max heap to store the elements and then perform heapify function to get top k elements. 
**/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Max Heap created
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        //Add Integer to priority Queue
        for(int i : nums){
            pq.add(i);
            if(pq.size() > k)
                pq.poll();
        }
            
        /*
        //Return top k elements
        while (true){
            int result = pq.poll();
            k--;
            if(k == 0)
                return result;
        }*/
        return pq.poll();
    }
}
