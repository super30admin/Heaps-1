public class KthLargestElementArray {

// Time Complexity : O(nlogk)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 1: Using min heap

    class MinHeapSolution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i : nums) {
                pq.add(i);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            return pq.peek();
        }
    }

// Time Complexity : O(nlog(n-k))
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 2: Using max heap

    class MaxHeapSolution {
        public int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            for (int i : nums) {
                pq.add(i);
                if (pq.size() > (n + 1 - k)) {
                    pq.poll();
                }
            }
            return pq.peek();
        }
    }

// Time Complexity : O(n)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 3: Quick select

    class QuickSelectSolution {
        private int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int pIdx = low;
            for (int i = low; i <= high - 1; i++) {
                if (arr[i] > pivot) {
                    int temp = arr[i];
                    arr[i] = arr[pIdx];
                    arr[pIdx] = temp;
                    pIdx++;
                }
            }
            int temp = arr[pIdx];
            arr[pIdx] = arr[high];
            arr[high] = temp;
            return pIdx;
        }

        private int quickSelect(int[] arr, int low, int high, int k) {
            int pIdx = partition(arr, low, high);
            if (pIdx == k - 1) {
                return arr[pIdx];
            } else if (pIdx > k - 1) {
                return quickSelect(arr, low, pIdx - 1, k);
            } else {
                return quickSelect(arr, pIdx + 1, high, k);
            }
        }

        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, k);
        }
    }
}
