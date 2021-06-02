/*Running Time complexity: O(n)
Space Time Complexity: O(n-k) priority queue
Sucessfully Run and Compiled on leetcode

*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pg = new PriorityQueue<>((a,b)-> b-a);
        int mini = Integer.MAX_VALUE;
        int diff = nums.length-k;
        for(int num : nums){
            pg.add(num);
            if(pg.size()>diff){
                mini = Math.min(mini,pg.poll());    
            }
            
        }
        return mini;
    }
}