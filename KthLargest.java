package com.exmaple.problems;

import java.util.Random;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
//Time Complexity : O(N) for Quick Select ,O(log N) for Heap
//Space Complexity : O(1) for QuickSelect,O(N) for MaxHeap 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach
/*
* There are two approaches to find kth Largest element
* Quick Select  quickselect is a selection algorithm to find the kth smallest element in an unordered list.
* Heap We can use min heap or max heap to find kth smalles/largest element.In our case,we have used max heap to find kth largest
* 
* */
public class KthLargest {
	public static boolean shouldUseHeap = false;
	public static boolean shouleUseRecursion = false;

	public static Random rand = new Random();

	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0 || k > nums.length)
			return 0;
		int size = nums.length;
		if (shouldUseHeap) {
			return priorityQueue(nums, k);
		} else {
			if (shouleUseRecursion) {
				return quickSelectRec(nums, 0, nums.length - 1, size - k);
			} else {
				return quickSelectIter(nums, 0, nums.length - 1, size - k);
			}
		}
	}

	public int priorityQueue(int nums[], int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		for (int num : nums) {
			queue.add(num);
		}
		while (--k > 0) {
			queue.poll();
		}
		return queue.peek();
	}

	public int quickSelectRec(int nums[], int low, int high, int k) {
		if (low == high)
			return nums[low];

		int pivotIndex = low + rand.nextInt(high - low);

		pivotIndex = findPivot(nums, low, high, pivotIndex);

		if (k == pivotIndex)
			return nums[k];
		else if (k < pivotIndex)
			return quickSelectRec(nums, low, pivotIndex - 1, k);
		else
			return quickSelectRec(nums, pivotIndex + 1, high, k);
	}

	public int quickSelectIter(int nums[], int low, int high, int k) {
		boolean flag = true;
		while (flag) {
			if (low == high) {
				return nums[low];
			}
			int pivotIndex = low + rand.nextInt(high - low);
			pivotIndex = findPivot(nums, low, high, pivotIndex);
			if (k == pivotIndex)
				return nums[k];
			else if (k < pivotIndex) {
				high = pivotIndex - 1;
			} else {
				low = pivotIndex + 1;
			}
		}
		return -1;
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public int findPivot(int nums[], int low, int high, int pivotIndex) {

		int pivot = nums[pivotIndex];
		swap(nums, pivotIndex, high);
		int pIndex = low;
		for (int i = low; i < high; i++) {
			if (nums[i] <= pivot) {
				swap(nums, i, pIndex);
				pIndex++;
			}
		}
		swap(nums, pIndex, high);
		return pIndex;
	}

	public static void main(String args[]) {
		int array[] = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 4;
		System.out.print(new KthLargest().findKthLargest(array, k));
	}
}
