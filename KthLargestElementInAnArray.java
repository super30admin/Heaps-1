
class KthLargestElementInAnArray {
    /*
     *
     * Time Complexity - O(n log(k)) because one insertion requires log k time and total n insertions
     * Space Complexity - O(k) to store all elements in priority queue/ heap
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
