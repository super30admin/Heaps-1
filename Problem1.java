//Time Complexity: O(Nlogk) => N - number of elements in array k - kth largest element
//Space Complexity: O(k) 
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //base case
        if(nums == null ||nums.length == 0)
            return 0;
        //create min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //add elements to heap and get the kth largest one from top
        for(int num : nums) {
            if(pq.size() < k){
                pq.add(num);
            }
            else if(num > pq.peek()){
                pq.poll();
                pq.add(num);
            }
        }
        return pq.poll();
    }
    
}
