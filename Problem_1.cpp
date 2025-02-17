// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: kth largest element in an Array.
// Approach: Max Heap
// Time Complexity: O(n log n)
// Space Complexity: O(n)


class Solution {
    public:
        int findKthLargest(std::vector<int>& nums, int k) {
            if (nums.empty()) {
                return 0;
            }
    
            int n = nums.size();
            int min = INT_MAX;
            std::priority_queue<int> pq; // Max heap by default
    
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                pq.push(num);
                if (pq.size() > n - k) {
                    min = std::min(min, pq.top());
                    pq.pop();
                }
            }
    
            return min;
        }
    };