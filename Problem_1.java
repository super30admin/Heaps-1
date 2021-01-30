// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//Below is the brute force solution.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int i=0;i<nums.length;i++){
                pq.add(nums[i]);
        }
        System.out.println(pq);
        int temp=0;
        while(k>0){
            temp=pq.remove();
            k=k-1;
        }
        return temp;
    }
}