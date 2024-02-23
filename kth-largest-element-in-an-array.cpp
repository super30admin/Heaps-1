// TC = O(n log k)
// SC = O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        // sort(nums.begin(), nums.end());
        // return(nums[nums.size() - k]);

        // TC = O(n log k)
        // SC = O(k)
        // maintaining a min pq of size k that'll give kth largest element as if the size of pq crosses k we are polling min elements
        // In cpp we have max heap by default so convrting it to min heap
        // IMP
        priority_queue<int, vector<int>, greater<int>> pq;
        for(int num: nums) {
            pq.push(num);
            if(pq.size() > k) {
                pq.pop();
            }
        }
        return pq.top();

        // also same can be achieved using max heap of size n - k
        // TC = O(n log n - k), SC = O(n - k)
        // priority_queue<int> pq;
        // int result = INT_MAX;
        // int n = nums.size();
        // for(int num : nums) {
        //     pq.push(num);
        //     if(pq.size() > n - k) {
        //         result = min(pq.top(), result); // polled items are among max k elements, so find min out of those k elements
        //         pq.pop();
        //     }
        // }
        // return result;
    }
};