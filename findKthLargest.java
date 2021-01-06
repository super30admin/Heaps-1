//Time Complexity: O(NlogK)
//Space Complexity: O(K)
//Idea 
//Start building the min heap
//if the size of the min heap tree is more than k remove the node and return the top
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num: nums){
            queue.add(num);
            if(queue.size() > k){
                queue.remove();
            }
        }
        return queue.peek();
    }
}