// Time Complexity :  O(NlogN) because for adding one element is log N and there are N elements so O(NlogN) 
// Space Complexity : O(N) for adding elements into PriorityQueue.
// Did this code successfully run on Leetcode : Yes

class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq= new PriorityQueue<>((n1, n2) -> n2-n1); // Heap in descending order
        for(int i=0;i<nums.length;i++){
            
            pq.add(nums[i]); // Add all elements
            
        }
        int count=1;
        while(!pq.isEmpty()){ // Check if pq not empty
            
            if(count==k){ // Check if k then pop element and return
                
                int a=pq.poll();
               return a;
            }
            
            else              //Pop elements until k is not reached
                pq.poll();
            
            count++; // Increment count
            
        }
        
        return nums[0]; // Handles edge case if queue has only one element
    }
}