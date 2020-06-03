package com.ds.rani.heap;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * <p>
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

//Approach: Take  last element as a pivot element, then swap all the elements less than pivot to its left side, all elements larger than pivot to right side
//It means pivot element is at its correct position, now check (n-k) is equal to the pivot element index.
//If it is equal then return pivot element, else reapet same process either on left or right based on value of(n-k)

//Time complexity:o(n) where n is number of elements in an array.
//Space complexity:o(1)

public class KthLargestElemt {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        //kth largest means n-k th smallest ie n=5 and k=2, so second largest means third smallest
        return findKthLargest( nums, 0, nums.length - 1, nums.length - k );
    }

    public int findKthLargest(int[] nums, int start, int end, int k) {// quick select: kth smallest
        if (start > end) return Integer.MAX_VALUE;

        int pivot = nums[end];

        //i will keep track of the last smallest element than pivot value
        int i = start, j;
        for (j = start; j < end; j++) {
            if (nums[j] <= pivot) {// Put numbers < pivot to pivot's left
                swap( nums, i, j );
                i++;
            }
        }
        swap( nums, i, j );// Finally, swap nums[j] with nums[i],here j is at pivot element
        // and when we swap it pivot comes at i's place and all the elements from pivot are less and all right elements are greater than pivot.

        if (i == k)// Found kth smallest number
            return nums[i];
        else if (k > i)// Check right part
            return findKthLargest( nums, i + 1, end, k );
        else // Check left part
            return findKthLargest( nums, start, i - 1, k );
    }

    void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
