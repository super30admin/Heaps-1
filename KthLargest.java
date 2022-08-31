//TC - O(nlogk).  n-> length of nums
//SC - O(1);

class Solution {
    public int findKthLargest(int[] nums, int k) {
        k=k-1;
        int start =0,end=nums.length-1;
        int pivotIndex = partition(nums,start,end);
        
        while(k!=pivotIndex){
            if(k<pivotIndex){
                end = pivotIndex -1;
                pivotIndex = partition(nums,start,end);
            }
            if(k>pivotIndex){
                start = pivotIndex +1;
                pivotIndex = partition(nums,start,end);
            }
        }
        return nums[pivotIndex];
    }
    
    public int partition(int[] nums,int start, int end){
        int pivot = nums[end];
        
        for(int i=start;i<end;i++){
            if(nums[i] > pivot){
                int temp = nums[start];
                nums[start] = nums[i];
                nums[i]=temp;
                start++;
            }
        }
        int temp = nums[start];
        nums[start] = pivot;
        nums[end] = temp;
        return start;
    }
}
