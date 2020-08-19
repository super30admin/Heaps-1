//Max Heap

//TC: O(k log n) k - kth largest and n number of elements
//SC: O(n) where n is the number of elements in the array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        
        while(k>1){
            pq.poll();
            k--;
        }
        
       return pq.poll();
    }
}


//Min Heap

//TC: O(n log k) where k - kth largest and n number of elements
//SC: O(K) where k is the largest element to be retrieved

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            
            if(pq.size() > k){
                pq.poll();
            }
            
        }
        
        return pq.poll();
    }
}