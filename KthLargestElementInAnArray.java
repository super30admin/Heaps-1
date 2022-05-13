
class KthLargestElementInAnArray {
    /*
     *
     * Time Complexity - O(n) to traverse over the entire list and store the elements to max heap/ priority queue
     * Space Complexity - O(n) to store all elements in priority queue/ heap
     *
     */

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b - a); 
        
        for (int num: nums) {
            maxPQ.add(num);
        }
        
        int result = 0;
        
        for (int i=0; i<k; i++) {
            result = maxPQ.poll();
        }
        
        return result;
    }
}
