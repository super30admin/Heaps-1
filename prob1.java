// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public int partition(int nums[],int si,int ei){
        int pivot=nums[ei];
        int i=si-1;
        for(int j=si;j<ei;j++){
            if(nums[j]<=pivot){
                i++;
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        i++;
        int temp=nums[ei];
        nums[ei]=nums[i];
        nums[i]=temp;
        return i;
    }
    public int quickSelect(int nums[],int si,int ei,int k){
        int pi=partition(nums,si,ei);
        if(k<pi){
            return quickSelect(nums,si,pi-1,k);
        } else if(k>pi){
            return quickSelect(nums,pi+1,ei,k);
        } else {
            return nums[pi];
        }
    }
    public int findKthLargest(int[] nums, int k) {
        if(nums.length==1){
            return nums[0];
        }
        k=nums.length-k;
        return quickSelect(nums,0,nums.length-1,k);
    }
}