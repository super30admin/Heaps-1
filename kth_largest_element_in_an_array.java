class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a); //we take a priority queue with name as pq and input as integer. b - a converts it into a max heap.
        int result = Integer.MAX_VALUE; // initially result is initialized to the max value.
        for(int num : nums) { //we go through all the elements in the integer array
            pq.add(num); // we add each of it to the priority queue
            if(pq.size() > nums.length - k + 1) { // if the size of the priority queue is greater than no. of elements - k
                result = Math.min(result, pq.poll()); // we remove the elements from the priority queue and we take the result as the min of result and the removed value
            }
        }
        return pq.peek(); //in the end, we return the result.
    }
}
//tc and sc - O(n log(n-k)) and O(n-k)