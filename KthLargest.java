// O(n) average time, O(n^2) worst case
// O(1) space

import java.util.Random;
class Solution {
  int [] nums;

  public int findKthLargest(int[] nums, int k) {
    this.nums = nums;
    int size = nums.length;
    // kth largest is (N - k)th smallest
    return quickselect(0, size - 1, size - k);
  }

  public int quickselect(int left, int right, int k_smallest) {
    /*
    Returns the k-th smallest element of list from left to right.
    */

    if (left == right) // one element in list
      return this.nums[left]; 

    // select a random pivot index
    Random random_num = new Random();
    int pivotIdx = left + random_num.nextInt(right - left); 
    
    pivotIdx = partition(left, right, pivotIdx);

    // the pivot is on (N - k)th smallest position
    if (k_smallest == pivotIdx)
      return this.nums[k_smallest];
    // go left side
    else if (k_smallest < pivotIdx)
      return quickselect(left, pivotIdx - 1, k_smallest);
    // go right side
    return quickselect(pivotIdx + 1, right, k_smallest);
  }

  public int partition(int left, int right, int pivot_index) {
    int pivot = nums[pivot_index];
    // 1. move pivot to end
    swap(pivot_index, right);
    int storeIdx = left;

    // 2. move all smaller elements to the left
    for (int i = left; i <= right; i++) {
      if (this.nums[i] < pivot) {
        swap(storeIdx, i);
        storeIdx++;
      }
    }

    // 3. move pivot to its final place
    swap(storeIdx, right);

    return storeIdx;
  }

  public void swap(int a, int b) {
    int tmp = nums[a];
    this.nums[a] = this.nums[b];
    this.nums[b] = tmp;
  }

}