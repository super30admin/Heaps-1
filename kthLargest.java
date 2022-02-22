
//Time : O(nlog(n))
//Space: O(n)

class Solution {
    public int findKthLargest(int[] nums, int k) {



        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pQueue.add(nums[i]);

        }
        int element=pQueue.peek();
        while(k>0){
            element=pQueue.poll();
            k=k-1;
        }
        return element;

    }
}