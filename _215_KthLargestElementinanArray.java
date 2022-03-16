class Solution {
    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> q = new PriorityQueue<>((a,b) -> Integer.compare(a,b));

        for(int i=0; i<k; i++){
            q.add(nums[i]);
        }

       for(int i=k; i<nums.length; i++){
            if(q.peek() < nums[i]){
                q.poll();
                q.add(nums[i]);
            }
        }

        return q.poll();
    }
}
