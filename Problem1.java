//Problem - Kth Largest Element in an Array 
//Time Complexity - O(N log K) K is the size of the heap
//Space Complexity - O(N) to store N elements in max heap
//Code run successfully on Leetcode - Yes

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        //Creating a priority queue to store numbers
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int num : nums){
            pq.add(num); //adding current numbers to priority queue
        }
            for(int i = 0; i < k - 1; i++){
                pq.poll();  
            }
        
        //return top kth element
        return pq.poll();
    
    }
}
