// With sorting
// TC: O(nlogn)
// SC: O(1) - constant

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n-k];  
    }
}

// Without sort
// TC: O(nlogk)
// SC: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        // Required n - k
        for(int i=0;i<n;i++){
            if(pq.size() < k){
                pq.add(nums[i]);
            }
            else{
                if(pq.peek() < nums[i]){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}
