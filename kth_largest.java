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
This solution lessens the number of comparison in the prioroty queue

        for(int i =0; i< nums.length; i++){
            if(pq.size() < k){
                pq.add(nums[i]);
            }
            else{
                if(pq.peek() < nums[i]){
                    pq.remove();
                    pq.add(nums[i]);
                }
                
            }
            
        }
        
        
  BEST SOLUTION modified Quick sort Time complexity : O(N) in the average case, O(N ^2) in the worst case.Space complexity : O(1).
  class Solution {
    public int findKthLargest(int[] nums, int k) {
           return quicksort(nums, 0, nums.length-1, k);
    }
    
    public int quicksort(int[] nums, int l, int r, int k) {
        if (l==r) return nums[l];
        int left = l;
        int right = r;
        int pivot = nums[l+(r-l)/2];
        while(left<=right) {
            while(left<=right && nums[left]>pivot) {
                left++;
            }
            while(left<=right && nums[right]<pivot) {
                right--;
            }
            if (left<=right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        
        if (k-1<=right) {
            return quicksort(nums, l, right, k);
        }
        if (k-1>=left) {
            return quicksort(nums, left, r, k);
        }
        return nums[k-1];
    }
    
    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}


        





BRUTE Force
Time Complexity:O(NlogN)

Space Complexity:O(1)

class Solution {

   public int findKthLargest(int[] nums, int k) {

       Arrays.sort(nums);

       return nums[nums.length -k];

   }

}
*/ 

