// Time Complexity : O(NlogK) where N=Number of elements in array.
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//This problem is solved using min heap.


class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {

        priority_queue<int,vector<int>,greater<int>> q;

        for(int i=0;i<nums.size();i++){
            q.push(nums[i]);
            if(q.size()>k){
                q.pop();
            }
        }
        return q.top();

    }
};

// Time Complexity : O(Nlog(N-K) where N=Size of array.
// Space Complexity : O(N-K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//This problem is solved using max heap.

int findKthLargest(vector<int>& nums, int k) {

        priority_queue<int> q;
        for(int i=0;i<nums.size();i++){
            q.push(nums[i]);
            if(q.size()>nums.size()-k+1){
                q.pop();
            }
        }
        return q.top();
    }
};
