// Time Complexity :O(N logK ) N - is number of element and k is the number of times the elements are arraged in queue
// Space Complexity :(N) N - is number of element
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->b-a);
        int res=0;
        for(int i:nums){
            queue.offer(i);
        }
        while(k-->0){
            res=queue.poll();
        }
        return res;
    }
}
