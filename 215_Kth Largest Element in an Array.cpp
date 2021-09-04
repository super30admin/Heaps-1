// Time Complexity : O(N*logK)where N is number of elements and K is the largest element in array.
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        if(nums.empty() || nums.size() == 0)
            return -1;
        priority_queue<int, vector<int>, greater<int>> pq;
        for(int num : nums){
            pq.push(num);
            if(pq.size() >  k){
                pq.pop();
            }
        }
        return pq.top();
    }
};

// Time Complexity : O(N*log(N-K))where N is number of elements and K is the largest element in array.
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        if(nums.empty() || nums.size() == 0)
            return -1;
        priority_queue<int> pq;
        int result = INT_MAX;
        for(int num : nums){
            pq.push(num);
            if(pq.size() > nums.size() - k){
                result = min(result, pq.top());
                pq.pop();
            }
                   
        }
        return result;
    }
};
