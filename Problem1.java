//Time Complexity : O(Nlog(k))
// Space Complexity : O(k), since max elements in the heap would be k
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

class Problem1 {
    public int findKthLargest(int[] nums, int k) {

        //taking a priority queue which is based on heap
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i =0; i<nums.length; i++){


            q.add(nums[i]);

            if(q.size() > k){
                q.poll();
            }
        }
        return q.poll();
    }
}


/**
 * Brute force way, would be sorting the array and returning the kth largest element
 *
 *
 **/

/*
    int n = nums.length;
    Arrays.sort(nums);

    return nums[n-k];


 */
