// Min heap TC O(nlogk) SC log k 
// Max heap TC (nlog(n-k)) SC log(n-k) 
// We can use min heap when k is smaller n max heap when k is larger 
// 
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        int min = Integer.MAX_VALUE;
        for(int i =0; i< nums.length; i++){
            
            pq.add(nums[i]);
            if(pq.size() > nums.length-k){
                min = Math.min(min, pq.remove());
            }
            
        }
        
        return min;
        
        
    }
}

/*

Time Complexity:O(NlogN)

Space Complexity:O(1)

class Solution {

   public int findKthLargest(int[] nums, int k) {

       Arrays.sort(nums);

       return nums[nums.length -k];

   }

}
*/ 

