/**
nums = [3,2,1,5,6,4], k = 2

    maxHeap

        3
    2           1
5       6   4

TC - O(nlogn) + O(klogn)
SC - O(1)


**/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int length = nums.length;
        
        for (int i=length/2 - 1; i>=0; i--)
        {
            heapifyDown(i, nums, length);
        }
    
        int max = -1;
        
        for (int i=length; i>=0; i--)
        {
            if (k == 0)
            {
                return max;
            }
            
            max = nums[0];
            
            // swap to the last element
            nums[0] = nums[i-1];
            
            heapifyDown(0,nums,i - 1);
            
            k--;
        }
        
        return -1;
    }
    
    private void heapifyDown(int index, int nums[], int n)
    {
        int root = index;
        int left = 2*index + 1;
        int right = 2* index + 2;
        int largest = root;
        
        if (left < n && nums[left] > nums[largest])
        {
            largest = left;
        }
        
        if (right < n && nums[right] > nums[largest])
        {
            largest = right;
        }
        
        if (largest != root)
        {
            // swap the elements 
            int temp = nums[largest];
            nums[largest] = nums[root];
            nums[root] = temp;
            
            heapifyDown(largest, nums, n);
        }
        
    }
    
}
